package ua.edu.nupp.kpp.server;

public class Measure {
    private Long id;
    private long auditId;
    private String description;
    private double estimatedCost;
    private double expectedSavings;

    public Measure() {
    }

    public Measure(Long id, long auditId, String description, double estimatedCost, double expectedSavings) {
        this.id = id;
        this.auditId = auditId;
        this.description = description;
        this.estimatedCost = estimatedCost;
        this.expectedSavings = expectedSavings;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getAuditId() {
        return auditId;
    }

    public void setAuditId(long auditId) {
        this.auditId = auditId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getEstimatedCost() {
        return estimatedCost;
    }

    public void setEstimatedCost(double estimatedCost) {
        this.estimatedCost = estimatedCost;
    }

    public double getExpectedSavings() {
        return expectedSavings;
    }

    public void setExpectedSavings(double expectedSavings) {
        this.expectedSavings = expectedSavings;
    }
}

