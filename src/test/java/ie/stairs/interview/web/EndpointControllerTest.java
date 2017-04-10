package ie.stairs.interview.web;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;
import java.nio.charset.Charset;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(EndpointController.class)
@ComponentScan("ie.stairs.interview.service")
public class EndpointControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testEndpoint() throws Exception {
        mvc.perform(post("/stairs").contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(readResource("inbound.json")))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(content().json(readResource("outbound.json")));
    }

    @Test
    public void testEndpointException() throws Exception {
        mvc.perform(post("/stairs").contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(readResource("badInbound.json")))
                .andExpect(status().isBadRequest()).andReturn();
    }

    private String readResource(String name) {
        try {
            return IOUtils.toString(getClass().getClassLoader().getResourceAsStream(name), Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}