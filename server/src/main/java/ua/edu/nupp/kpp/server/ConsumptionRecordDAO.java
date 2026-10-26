package ua.edu.nupp.kpp.server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConsumptionRecordDAO {

    public void add(ConsumptionRecord record) throws SQLException {
        String sql = "INSERT INTO ConsumptionRecord (facilityId, recordDate, energyType, amount) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, record.getFacilityId());
            ps.setString(2, record.getRecordDate());
            ps.setString(3, record.getEnergyType());
            ps.setDouble(4, record.getAmount());
            ps.executeUpdate();
        }
    }

    public List<ConsumptionRecord> getAll() throws SQLException {
        String sql = "SELECT id, facilityId, recordDate, energyType, amount FROM ConsumptionRecord";
        List<ConsumptionRecord> records = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                ConsumptionRecord r = new ConsumptionRecord();
                r.setId(rs.getLong("id"));
                r.setFacilityId(rs.getLong("facilityId"));
                r.setRecordDate(rs.getString("recordDate"));
                r.setEnergyType(rs.getString("energyType"));
                r.setAmount(rs.getDouble("amount"));
                records.add(r);
            }
        }
        return records;
    }

    public ConsumptionRecord getById(long id) throws SQLException {
        String sql = "SELECT id, facilityId, recordDate, energyType, amount FROM ConsumptionRecord WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    ConsumptionRecord r = new ConsumptionRecord();
                    r.setId(rs.getLong("id"));
                    r.setFacilityId(rs.getLong("facilityId"));
                    r.setRecordDate(rs.getString("recordDate"));
                    r.setEnergyType(rs.getString("energyType"));
                    r.setAmount(rs.getDouble("amount"));
                    return r;
                }
            }
        }
        return null;
    }

    public void update(ConsumptionRecord record) throws SQLException {
        String sql = "UPDATE ConsumptionRecord SET facilityId = ?, recordDate = ?, energyType = ?, amount = ? WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, record.getFacilityId());
            ps.setString(2, record.getRecordDate());
            ps.setString(3, record.getEnergyType());
            ps.setDouble(4, record.getAmount());
            ps.setLong(5, record.getId());
            ps.executeUpdate();
        }
    }

    public void delete(long id) throws SQLException {
        String sql = "DELETE FROM ConsumptionRecord WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        }
    }
}