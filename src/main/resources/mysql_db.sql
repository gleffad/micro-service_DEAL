CREATE TABLE deal (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    borrower VARCHAR(255) NOT NULL,
    code VARCHAR(255) NOT NULL,
    devise INT NOT NULL,
    lender VARCHAR(255) NOT NULL,
    amount FLOAT NOT NULL,
    status INT NOT NULL,
    zone INT NOT NULL
);

INSERT INTO deal (name, borrower, code, devise, lender, amount, status, zone ) VALUES
  ('koko', 'CFA INSTA', 'L123456', 0, 'BNP', 1000.0, 0, 0),
  ('toto', 'CFA INSTA', 'J123456', 0, 'BNP', 1000.0, 0, 0);