package ie.stairs.interview.web;

import ie.stairs.interview.model.request.Inbound;
import ie.stairs.interview.model.response.Outbound;
import ie.stairs.interview.service.StairsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class EndpointController {

    @Autowired
    private StairsService stairsService;

    @RequestMapping(method = RequestMethod.POST, value = "/stairs",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Outbound processStairs(@RequestBody Inbound inbound) {
        return stairsService.process(inbound);
    }

    @ExceptionHandler
    void handleIllegalArgumentException(IllegalArgumentException e, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }

}
