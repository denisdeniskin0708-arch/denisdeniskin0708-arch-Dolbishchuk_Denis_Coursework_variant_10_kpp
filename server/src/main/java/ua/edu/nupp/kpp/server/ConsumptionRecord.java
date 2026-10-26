
package ua.edu.nupp.kpp.server;

public class ConsumptionRecord {
    private Long id;
    private long facilityId;
    private String recordDate;
    private String energyType;
    private double amount;

    public ConsumptionRecord() {
    }

    public ConsumptionRecord(Long id, long facilityId, String recordDate, String energyType, double amount) {
        this.id = id;
        this.facilityId = facilityId;
        this.recordDate = recordDate;
        this.energyType = energyType;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(long facilityId) {
        this.facilityId = facilityId;
    }

    public String getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate;
    }

    public String getEnergyType() {
        return energyType;
    }

    public void setEnergyType(String energyType) {
        this.energyType = energyType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
