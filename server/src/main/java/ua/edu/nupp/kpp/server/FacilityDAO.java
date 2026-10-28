package ua.edu.nupp.kpp.server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacilityDAO {

        public void add(Facility facility) throws SQLException {
            String sql = "INSERT INTO facility (name, address) VALUES (?, ?)";
            try (Connection conn = DBUtil.getConnection();
                 PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, facility.getName());
                ps.setString(2, facility.getAddress());
                ps.executeUpdate();
            }
        }

        public List<Facility> getAll() throws SQLException {
            String sql = "SELECT id, name, address FROM facility";
            List<Facility> facilities = new ArrayList<>();
            try (Connection conn = DBUtil.getConnection();
                 PreparedStatement ps = conn.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Facility f = new Facility();
                    f.setId(rs.getLong("id"));
                    f.setName(rs.getString("name"));
                    f.setAddress(rs.getString("address"));
                    facilities.add(f);
                }
            }
            return facilities;
        }

        public Facility getById(long id) throws SQLException {
            String sql = "SELECT id, name, address FROM facility WHERE id = ?";
            try (Connection conn = DBUtil.getConnection();
                 PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setLong(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        Facility f = new Facility();
                        f.setId(rs.getLong("id"));
                        f.setName(rs.getString("name"));
                        f.setAddress(rs.getString("address"));
                        return f;
                    }
                }
            }
            return null;
        }

        public void update(Facility facility) throws SQLException {
            String sql = "UPDATE facility SET name = ?, address = ? WHERE id = ?";
            try (Connection conn = DBUtil.getConnection();
                 PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, facility.getName());
                ps.setString(2, facility.getAddress());
                ps.setLong(3, facility.getId());
                ps.executeUpdate();
            }
        }

        public void delete(long id) throws SQLException {
            String sql = "DELETE FROM facility WHERE id = ?";
            try (Connection conn = DBUtil.getConnection();
                 PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setLong(1, id);
                ps.executeUpdate();
            }
        }
    }
