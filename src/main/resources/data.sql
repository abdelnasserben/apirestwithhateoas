CREATE TABLE IF NOT EXISTS employees (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NULL,
  last_name VARCHAR(250) NULL,
  salary VARCHAR(50) NULL
);

INSERT INTO employees (first_name, last_name, salary) VALUES
('Colleen ','Myers','$1000'),
('Monica ','Webb','$1100'),
('David ','Case','$1200'),
('Jonathan ','Powers','$1300'),
('Mark ','Ochoa','$1400')