package ie.stairs.interview.service;

import ie.stairs.interview.model.request.Inbound;
import ie.stairs.interview.model.response.Outbound;

public interface StairsService {
    public Outbound process(Inbound request);
}
