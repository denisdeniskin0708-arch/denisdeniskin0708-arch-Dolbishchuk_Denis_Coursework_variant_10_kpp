package ua.edu.nupp.kpp.server;

public class EnergyAudit {
    private Long id;
    private long facilityId;
    private String auditDate;
    private String auditorName;
    private AuditStatus status;

    public EnergyAudit() {
    }

    public EnergyAudit(Long id, long facilityId, String auditDate, String auditorName, AuditStatus status) {
        this.id = id;
        this.facilityId = facilityId;
        this.auditDate = auditDate;
        this.auditorName = auditorName;
        this.status = status;
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

    public String getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(String auditDate) {
        this.auditDate = auditDate;
    }

    public String getAuditorName() {
        return auditorName;
    }

    public void setAuditorName(String auditorName) {
        this.auditorName = auditorName;
    }

    public AuditStatus getStatus() {
        return status;
    }

    public void setStatus(AuditStatus status) {
        this.status = status;
    }
}

