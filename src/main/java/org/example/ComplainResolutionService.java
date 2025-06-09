package org.example;

import java.util.*;

public class ComplainResolutionService {
    Map<String, Agent> agents = new HashMap<>();
    List<ResolutionHistory> resolutionHistories = new ArrayList<>();
    Map<String, Issue> issues = new HashMap<>();

    public void addAgent(String name, String email)
    {
        agents.put(email, new Agent(name, email));
    }
    public String createIssue(String transactionId, IssueType issueType, String subject, String description, String email) {
        Issue issue = new Issue(transactionId, issueType, subject, description, email);
        issues.put(issue.getId(), issue);
        return issue.getId();
    }
    public boolean assignIssue(String issueId)
    {
        Issue issue = issues.get(issueId);
        if (issue == null || (issue.getStatus() != IssueStatus.BACKLOG))
            return false;
        for (Agent agent : agents.values()) {
            if (!agent.isOccupied()) {
                agent.assignIssue(issue);
                return true;
            }
        }
        return false;
    }
    public boolean resolveIssue(String issueId, String resolution)
    {
        Issue issue = issues.get(issueId);
        if (issue == null || issue.getStatus() != IssueStatus.IN_PROGRESS)
            return false;
        Agent agent = agents.get(issue.getAssignedAgentEmail());
        if (agent != null) {
            agent.resolveIssue(resolution);
            resolutionHistories.add(new ResolutionHistory(agent.getEmail(), issueId));
            return true;
        }
        return false;
    }

    public void resolutionHistory()
    {
        for(ResolutionHistory rs : resolutionHistories)
        {
            System.out.println("IssueId "+ rs.getIssueId() +" resolved by "+ agents.get(rs.getAgentEmailId()).getAgentName());
        }
    }

}
