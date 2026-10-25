CREATE DATABASE IF NOT EXISTS energy_planning;
USE energy_planning;

CREATE TABLE Facility (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          address VARCHAR(255) NOT NULL,
                          area DOUBLE NOT NULL
);

CREATE TABLE ConsumptionRecord (
                                   id INT AUTO_INCREMENT PRIMARY KEY,
                                   facility_id INT NOT NULL,
                                   record_date DATE NOT NULL,
                                   energy_type VARCHAR(100) NOT NULL,
                                   amount DOUBLE NOT NULL,
                                   FOREIGN KEY (facility_id) REFERENCES Facility(id) ON DELETE CASCADE
);

CREATE TABLE EnergyAudit (
                             id INT AUTO_INCREMENT PRIMARY KEY,
                             facility_id INT NOT NULL,
                             audit_date DATE NOT NULL,
                             auditor_name VARCHAR(255) NOT NULL,
                             status VARCHAR(50) NOT NULL,
                             FOREIGN KEY (facility_id) REFERENCES Facility(id) ON DELETE CASCADE
);

CREATE TABLE Measure (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         audit_id INT NOT NULL,
                         description TEXT NOT NULL,
                         estimated_cost DOUBLE NOT NULL,
                         expected_savings DOUBLE NOT NULL,
                         FOREIGN KEY (audit_id) REFERENCES EnergyAudit(id) ON DELETE CASCADE
);

INSERT INTO Facility (name, address, area) VALUES ('Головний корпус', 'вул. Першотравнева, 24', 5000.0);
INSERT INTO ConsumptionRecord (facility_id, record_date, energy_type, amount) VALUES (1, '2023-10-01', 'Електрика', 1200.5);
INSERT INTO EnergyAudit (facility_id, audit_date, auditor_name, status) VALUES (1, '2023-10-15', 'Іванов І.І.', 'СХВАЛЕНО');
INSERT INTO Measure (audit_id, description, estimated_cost, expected_savings) VALUES (1, 'Заміна вікон', 50000.0, 10000.0);