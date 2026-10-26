package ua.edu.nupp.kpp.server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnergyAuditDAO {

    public void add(EnergyAudit audit) throws SQLException {
        String sql = "INSERT INTO energyaudit (facility_id, audit_date, auditor_name, status) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, audit.getFacilityId());
            ps.setString(2, audit.getAuditDate());
            ps.setString(3, audit.getAuditorName());
            ps.setString(4, audit.getStatus().name());
            ps.executeUpdate();
        }
    }

    public List<EnergyAudit> getAll() throws SQLException {
        String sql = "SELECT id, facility_id, audit_date, auditor_name, status FROM energyaudit";
        List<EnergyAudit> audits = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                EnergyAudit a = new EnergyAudit();
                a.setId(rs.getLong("id"));
                a.setFacilityId(rs.getLong("facility_id"));
                a.setAuditDate(rs.getString("audit_date"));
                a.setAuditorName(rs.getString("auditor_name"));
                a.setStatus(AuditStatus.valueOf(rs.getString("status")));
                audits.add(a);
            }
        }
        return audits;
    }

    public EnergyAudit getById(long id) throws SQLException {
        String sql = "SELECT id, facility_id, audit_date, auditor_name, status FROM energyaudit WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    EnergyAudit a = new EnergyAudit();
                    a.setId(rs.getLong("id"));
                    a.setFacilityId(rs.getLong("facility_id"));
                    a.setAuditDate(rs.getString("audit_date"));
                    a.setAuditorName(rs.getString("auditor_name"));
                    a.setStatus(AuditStatus.valueOf(rs.getString("status")));
                    return a;
                }
            }
        }
        return null;
    }

    public void update(EnergyAudit audit) throws SQLException {
        String sql = "UPDATE energyaudit SET facility_id = ?, audit_date = ?, auditor_name = ?, status = ? WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, audit.getFacilityId());
            ps.setString(2, audit.getAuditDate());
            ps.setString(3, audit.getAuditorName());
            ps.setString(4, audit.getStatus().name());
            ps.setLong(5, audit.getId());
            ps.executeUpdate();
        }
    }

    public void delete(long id) throws SQLException {
        String sql = "DELETE FROM energyaudit WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        }
    }
}
