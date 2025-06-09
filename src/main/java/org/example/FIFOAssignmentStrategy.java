package org.example;

import java.util.List;
import java.util.Queue;

public class FIFOAssignmentStrategy implements AssignmentStartegy{
    @Override
    public Agent assign(Queue<Agent> freeAgents, Issue issue) {
        if(freeAgents.isEmpty())
            return null;
        Agent agent = freeAgents.peek();
        freeAgents.poll();
        return agent;
    }
}
