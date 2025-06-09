package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Agent {
    private String agentName;
    private Issue issue;
    private boolean isOccupied;
    private String email;
    public Agent (String agentName, String agentEmail)
    {
        this.agentName = agentName;
        this.email = agentEmail;
        this.isOccupied = false;
    }
    public void assignIssue(Issue issue)
    {
        this.issue = issue;
        this.isOccupied = true;
        issue.setAssignedAgentEmail(this.email);
        issue.setStatus(IssueStatus.IN_PROGRESS);
    }
    public void resolveIssue(String resolution)
    {
        if(!(this.issue == null))
        {
            issue.setResolution(resolution);
            issue.setStatus(IssueStatus.RESOLVED);
            this.isOccupied = false;
        }
    }
}
