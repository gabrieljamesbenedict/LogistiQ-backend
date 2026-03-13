INSERT INTO users (username, password, role)
VALUES (
    'gabriel',
    '$2a$12$6aSX9thhVqDUqmnJLPpFBeIr4mB9oyWV1R06SlUIePvw/.mz9.1Su',
    'EMPLOYEE'
);

INSERT INTO employees (lastname, firstname, middlename, license_number, contact_number, email)
VALUES ('Doe', 'John', 'A', 'LIC-1234567', '09171234567', 'john.doe@example.com');


INSERT INTO trips (trip_status, origin, destination, started_at, ended_at, cargo_description, revenue) VALUES
('COMPLETED','Manila','Cebu','2026-01-01 02:00:00','2026-01-02 10:00:00','Electronics shipment',85000.00),
('COMPLETED','Quezon City','Baguio','2026-01-03 04:00:00','2026-01-03 12:00:00','Fresh vegetables',32000.00),
('INPROGRESS','Davao','Cagayan de Oro','2026-01-05 01:30:00',NULL,'Construction steel bars',54000.00),
('PLANNED','Pasig','Batangas','2026-01-07 06:00:00',NULL,'Textile products',27000.00),
('COMPLETED','Manila','Iloilo','2026-01-08 03:15:00','2026-01-09 14:40:00','Furniture delivery',91000.00),
('COMPLETED','Cebu','Tacloban','2026-01-10 05:00:00','2026-01-10 18:20:00','Medical supplies',46000.00),
('INPROGRESS','Batangas','Lucena','2026-01-11 07:00:00',NULL,'Petroleum drums',39000.00),
('PLANNED','Baguio','Manila','2026-01-12 09:00:00',NULL,'Strawberry crates',22000.00),
('COMPLETED','Iloilo','Bacolod','2026-01-13 01:00:00','2026-01-13 06:00:00','Sugar sacks',18000.00),
('COMPLETED','Pasay','Clark','2026-01-14 02:45:00','2026-01-14 08:00:00','Airport equipment',51000.00);


INSERT INTO trip_employees (trip_id, employee_id) VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 1),
(5, 1),
(6, 1),
(7, 1),
(8, 1),
(9, 1),
(10, 1);


-- Expenses linked to trips
INSERT INTO expenses (description, amount, category, trip_id) VALUES
('Fuel for Manila-Cebu trip', 12000.00, 'FUEL', 1),
('Toll fees for Quezon City-Baguio', 1500.00, 'TOLL', 2),
('Fuel for Davao-Cagayan de Oro', 8000.00, 'FUEL', 3),
('Toll fees for Pasig-Batangas', 500.00, 'TOLL', 4),
('Loading/unloading miscellaneous charges', 3500.00, 'OTHERS', 5),
('Fuel for Manila-Iloilo', 10000.00, 'FUEL', 5),
('Toll fees for Cebu-Tacloban', 1200.00, 'TOLL', 6),
('Miscellaneous labor charges', 2200.00, 'OTHERS', 7),
('Fuel for Batangas-Lucena', 4000.00, 'FUEL', 7),
('Toll for Baguio-Manila', 1800.00, 'TOLL', 8);

-- Miscellaneous expenses (trip_id = NULL)
INSERT INTO expenses (description, amount, category, trip_id) VALUES
('Office supplies', 1500.00, 'OTHERS', NULL),
('Company utilities', 3000.00, 'OTHERS', NULL),
('Driver training materials', 2500.00, 'OTHERS', NULL),
('Printer ink and paper', 1200.00, 'OTHERS', NULL);