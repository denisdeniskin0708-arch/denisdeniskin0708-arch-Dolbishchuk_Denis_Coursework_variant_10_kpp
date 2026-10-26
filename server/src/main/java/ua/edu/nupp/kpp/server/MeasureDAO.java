package ua.edu.nupp.kpp.server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MeasureDAO {

    public void add(Measure measure) throws SQLException {
        String sql = "INSERT INTO measure (audit_id, description, estimated_cost, expected_savings) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, measure.getAuditId());
            ps.setString(2, measure.getDescription());
            ps.setDouble(3, measure.getEstimatedCost());
            ps.setDouble(4, measure.getExpectedSavings());
            ps.executeUpdate();
        }
    }

    public List<Measure> getAll() throws SQLException {
        String sql = "SELECT id, audit_id, description, estimated_cost, expected_savings FROM measure";
        List<Measure> measures = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Measure m = new Measure();
                m.setId(rs.getLong("id"));
                m.setAuditId(rs.getLong("audit_id"));
                m.setDescription(rs.getString("description"));
                m.setEstimatedCost(rs.getDouble("estimated_cost"));
                m.setExpectedSavings(rs.getDouble("expected_savings"));
                measures.add(m);
            }
        }
        return measures;
    }

    public Measure getById(long id) throws SQLException {
        String sql = "SELECT id, audit_id, description, estimated_cost, expected_savings FROM measure WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Measure m = new Measure();
                    m.setId(rs.getLong("id"));
                    m.setAuditId(rs.getLong("audit_id"));
                    m.setDescription(rs.getString("description"));
                    m.setEstimatedCost(rs.getDouble("estimated_cost"));
                    m.setExpectedSavings(rs.getDouble("expected_savings"));
                    return m;
                }
            }
        }
        return null;
    }

    public void update(Measure measure) throws SQLException {
        String sql = "UPDATE measure SET audit_id = ?, description = ?, estimated_cost = ?, expected_savings = ? WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, measure.getAuditId());
            ps.setString(2, measure.getDescription());
            ps.setDouble(3, measure.getEstimatedCost());
            ps.setDouble(4, measure.getExpectedSavings());
            ps.setLong(5, measure.getId());
            ps.executeUpdate();
        }
    }

    public void delete(long id) throws SQLException {
        String sql = "DELETE FROM measure WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        }
    }
}
