CREATE TABLE wallet (uuidId UUID NOT NULL PRIMARY KEY default RANDOM_UUID(),
                      operation_type VARCHAR(20) NOT NULL,
                      amount decimal(10,2));