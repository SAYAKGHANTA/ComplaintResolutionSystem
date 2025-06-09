# Complaint Resolution System

A simple Java-based backend system to manage customer complaints related to failed or pending transactions.

## Features

### Customers
- Can log issues for failed or pending transactions.
- Required fields: `transactionId`, `issueType`, `subject`, `description`, and `email`.

### Customer Service Agents
- Can handle only one issue at a time.
- Can be onboarded with specific expertise (`issueType`s).
- Can search issues by ID or email.
- Can resolve issues and become available for new ones.

### Admins
- Can onboard agents with specific expertise.
- Can assign issues using a simple strategy (assign to any free agent with matching expertise).
- Can view work history of all agents.

---

## System Functionalities

### Issue Management
- `createIssue(transactionId, issueType, subject, description, email)`: Create a new issue.
- `assignIssue(issueId)`: Assign an unassigned issue to a free agent based on expertise.
- `updateIssue(issueId, status, resolution)`: Manually update the status and resolution.
- `resolveIssue(issueId, resolution)`: Automatically resolve an issue and mark the agent as free.
- `getIssues(filterMap)`: Filter issues by `email`, `status`, or `issueType`.

### Agent Management
- `addAgent(agentEmail, agentName, List<String> expertise)`: Add a new support agent.
- `viewAgentsWorkHistory()`: View resolved issue history per agent.

---

## Core Classes

### `Issue`
Represents a customer complaint.

- Fields: `transactionId`, `issueType`, `subject`, `description`, `email`, `status`, `resolution`, `assignedAgentEmail`.
- Enum:
  - `Status`: `PENDING`, `ASSIGNED`, `RESOLVED`
  - `IssueType`: `PAYMENT_FAILURE`, `PENDING_TRANSACTION`, `CARD_DECLINED`, `TECHNICAL_ERROR`, `OTHER`

### `Agent`
Represents a support agent.

- Fields: `email`, `name`, `expertise`, `currentIssue`, `resolvedIssues`.

---

## Example Workflow

```java
ComplaintSystem system = new ComplaintSystem();

// Add agents
system.addAgent("agent1@company.com", "Agent One", Arrays.asList("PAYMENT_FAILURE", "CARD_DECLINED"));

// Create issue
String issueId = system.createIssue("TX12345", "PAYMENT_FAILURE", "Payment not received", "I was charged but did not receive confirmation", "user@example.com");

// Assign issue
system.assignIssue(issueId);

// Resolve issue
system.resolveIssue(issueId, "Refund processed successfully");

// View agent work history
system.viewAgentsWorkHistory();
