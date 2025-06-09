package org.example;

import java.util.List;
import java.util.Queue;

public interface AssignmentStartegy {
    public Agent assign(Queue<Agent> freeAgents, Issue issue);
}
