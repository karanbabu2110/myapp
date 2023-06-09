CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    dob DATE,
    gender VARCHAR(10),
    department VARCHAR(100),
    year_of_apply VARCHAR(10),
    email VARCHAR(100)
);

INSERT INTO students (name, dob, gender, department, year_of_apply, email)
VALUES ('John Doe', '1990-01-01', 'Male', 'Computer Science', '2021', 'johndoe@example.com');

INSERT INTO students (name, dob, gender, department, year_of_apply, email)
VALUES ('Jane Smith', '1992-05-15', 'Female', 'Electrical Engineering', '2022', 'janesmith@example.com');