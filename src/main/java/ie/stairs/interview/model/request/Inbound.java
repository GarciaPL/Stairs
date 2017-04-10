package ie.stairs.interview.model.request;

import java.util.List;

public class Inbound {
    private List<Integer> input;
    private Integer steps;

    public Inbound() {
    }

    public Inbound(List<Integer> input, Integer steps) {
        this.input = input;
        this.steps = steps;
    }

    public List<Integer> getInput() {
        return input;
    }

    public void setInput(List<Integer> input) {
        this.input = input;
    }

    public Integer getSteps() {
        return steps;
    }

    public void setSteps(Integer steps) {
        this.steps = steps;
    }
}