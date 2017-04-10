package ie.stairs.interview.service;

import ie.stairs.interview.model.request.Inbound;
import ie.stairs.interview.model.response.Outbound;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.stream.Stream;

@Service
public class StairsServiceImpl implements StairsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Override
    public Outbound process(Inbound request) {

        Assert.isTrue(request.getSteps() >= 1 && request.getSteps() <= 4, "Too many steps");
        Assert.isTrue(request.getInput().size() >= 1 && request.getInput().size() <= 30, "Too many stairwells");
        Assert.isTrue(!Stream.of(request.getInput()).flatMap(List::stream).anyMatch(s -> s < 1 || s > 20), "Too many steps in flight");

        final Integer[] result = {0};
        Stream.of(request.getInput()).flatMap(List::stream).forEach(input -> {
            result[0] = result[0] + divideFlight(request, input);
            if (Math.floorMod(input, request.getSteps()) > 0) {
                result[0] = result[0] + 1;
            }
        });

        calculateLandings(request, result);

        return new Outbound(result[0]);
    }

    private int divideFlight(Inbound request, Integer input) {
        return input / request.getSteps();
    }

    private void calculateLandings(Inbound request, Integer[] result) {
        result[0] = result[0] + ((request.getInput().size() - 1) * 2);
    }

}
