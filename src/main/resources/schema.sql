CREATE TABLE IF NOT EXISTS location (id SERIAL PRIMARY KEY,
    street VARCHAR(255),
    number VARCHAR(255),
    city VARCHAR(255),
    country VARCHAR(255));

CREATE TABLE IF NOT EXISTS holiday (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    startDate DATE NOT NULL,
    duration INTEGER NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    freeSlots INTEGER NOT NULL,
    location_id INTEGER,
    FOREIGN KEY (location_id) REFERENCES location(id)
);

INSERT INTO location (street,number, city, country)
VALUES ('a 9', '22', 'Sliven', 'Bulgaria');

INSERT INTO holiday (title, startDate, duration, price, freeSlots, location_id)
VALUES ('Velur Holiday', '2024-01-01', 10, 699.99, 20, 1);
