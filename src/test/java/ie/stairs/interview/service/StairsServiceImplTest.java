package ie.stairs.interview.service;

import ie.stairs.interview.model.request.Inbound;
import ie.stairs.interview.model.response.Outbound;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
public class StairsServiceImplTest {

    private StairsService stairsService;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() {
        stairsService = new StairsServiceImpl();
    }

    @Test
    public void testManySteps() throws Exception {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Too many steps");
        stairsService.process(new Inbound(Lists.newArrayList(17), 10));
    }

    @Test
    public void testManyStairwells() throws Exception {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Too many stairwells");
        stairsService.process(new Inbound(IntStream.range(0, 50).boxed().collect(Collectors.toList()), 2));
    }

    @Test
    public void testManyStepsInFlight() throws Exception {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Too many steps in flight");
        stairsService.process(new Inbound(Lists.newArrayList(30), 2));
    }

    @Test
    public void testOneFlight() throws Exception {
        Outbound outbound = stairsService.process(new Inbound(Lists.newArrayList(17), 3));
        assertNotNull(outbound);
        assertThat(outbound.getResult(), is(6));
    }

    @Test
    public void testTwoFlights() throws Exception {
        Outbound outbound = stairsService.process(new Inbound(Lists.newArrayList(17, 17), 3));
        assertNotNull(outbound);
        assertThat(outbound.getResult(), is(14));
    }

    @Test
    public void testManyFlights() throws Exception {
        Outbound outbound = stairsService.process(new Inbound(Lists.newArrayList(4, 9, 8, 11, 7, 20, 14), 2));
        assertNotNull(outbound);
        assertThat(outbound.getResult(), is(50));
    }
}