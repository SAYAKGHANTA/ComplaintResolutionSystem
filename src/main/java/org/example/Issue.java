package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Issue {
    private String id;
    private String transactionId;
    private IssueType issueType;
    private String subject;
    private String description;
    private PriorityType priorityType;
    private String customerEmailId;
    private IssueStatus status;
    private String resolution;
    private String assignedAgentEmail;

    Issue(String transactionId, IssueType issueType, String subject, String description, String email) {
        this.id = UUID.randomUUID().toString();
        this.transactionId = transactionId;
        this.issueType = issueType;
        this.subject = subject;
        this.description = description;
        this.customerEmailId = email;
        this.status = IssueStatus.BACKLOG;
    }
}
