-- Dropping tables if they exist

DROP TABLE IF EXISTS Booking CASCADE;
DROP TABLE IF EXISTS Session CASCADE;
DROP TABLE IF EXISTS Location CASCADE;
DROP TABLE IF EXISTS Offering CASCADE;
DROP TABLE IF EXISTS Course CASCADE;
DROP TABLE IF EXISTS Admin CASCADE;
DROP TABLE IF EXISTS Student CASCADE;
DROP TABLE IF EXISTS Availability CASCADE;
DROP TABLE IF EXISTS Tutor CASCADE;
DROP TABLE IF EXISTS Users CASCADE;
DROP TABLE IF EXISTS Account CASCADE;






------------------------------------------------------------------------------------------

-- Creating tables

CREATE TABLE Account(
	user_id smallint Primary Key,
	user_password varchar(20)
);

CREATE TABLE Users(
	user_id smallint PRIMARY KEY,
	user_fname varchar(15) not NULL,
	user_lname varchar(15) not NULL,
	user_phonenum char(10),
	user_dob date not NULL,
	user_type char(1) not NULL,
	CONSTRAINT CkUser_type CHECK (user_type in ('A', 'S', 'T')),
	CONSTRAINT accountfk FOREIGN KEY (user_id) REFERENCES Account(user_id) 
		ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Admin(
	PRIMARY KEY(user_id),
	admin_role char(1) not NULL,
	admin_hiring_date date not NULL,
	CONSTRAINT Ckadmin_role CHECK (admin_role in ('S', 'M', 'O'))
)INHERITS(users);


CREATE TABLE Student(
	PRIMARY KEY(user_id),
	attended_hours decimal(5,2) NOT NULL DEFAULT 0,
	stud_balance int NOT NULL Default 500,
	reg_date date NOT NULL,
	academic_level varchar(5) NOT NULL,
	CONSTRAINT Ckacademic_level CHECK (academic_level in ('TC', '1BAC', '2BAC'))
)INHERITS(users);


CREATE TABLE Tutor(
	PRIMARY KEY(user_id),
	tutor_balance int not NULL DEFAULT 0,
	tutor_level VARCHAR(10) not null,
	CONSTRAINT Cklevel CHECK (tutor_level in ('TC', '1BAC', '2BAC'))
)INHERITS(users);

CREATE TABLE Availability(
	av_code int PRIMARY KEY,
	av_date date not NULL,
	av_start_time time NOT NULL, 
	av_end_time time NOT NULL,
	tutor_id smallint NOT NULL,
	CONSTRAINT timeConstraint CHECK (av_start_time < av_end_time),
	CONSTRAINT available_at FOREIGN KEY (tutor_id) REFERENCES Tutor(user_id)
                      ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Course(
	course_code VARCHAR(8) PRIMARY KEY,
	course_title VARCHAR(30) not null,
	course_level VARCHAR(10) not null,
	course_price_hr int not null,
	CONSTRAINT Cklevel CHECK (course_level in ('TC', '1BAC', '2BAC'))
);

CREATE TABLE Offering(
	tutor_ID smallint,
	course_code VARCHAR(8),
	PRIMARY KEY(tutor_ID, course_code),
	CONSTRAINT offers FOREIGN KEY (tutor_ID) REFERENCES Tutor(User_ID)
        		ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT offered_by FOREIGN KEY (course_code) REFERENCES Course(course_code)
        		ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Location(
	room_num smallint PRIMARY KEY,
	room_seats smallint not NULL DEFAULT 14
);

CREATE TABLE Session(
	session_code VARCHAR(8) PRIMARY KEY,
	session_date date not null,
	session_start_Time time NOT NULL, 
	session_end_Time time NOT NULL,
	session_seats_av smallint not null DEFAULT 14,
	session_status VARCHAR(9) not null DEFAULT 'Open',
	course_code VARCHAR(8),
	tutor_ID smallint,
	room_num int,
	CONSTRAINT CKstatus CHECK (session_status IN ('Open', 'Closed', 'Canceled')),
   	CONSTRAINT timeConstraint CHECK (session_start_time < session_end_time),
	CONSTRAINT corresponds FOREIGN KEY (course_code, tutor_ID) REFERENCES OFFERING(course_code, tutor_ID)
        		ON UPDATE CASCADE ON DELETE CASCADE,
     	CONSTRAINT located_in FOREIGN KEY (room_num) REFERENCES Location(room_num)
       		 	ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Booking(
	student_id smallint,
	session_code varchar(8),
	PRIMARY KEY(session_code, student_id),
	rating smallint,
	CONSTRAINT booked_by FOREIGN KEY (student_id) REFERENCES Student(user_id)
                      	ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT creates FOREIGN KEY (session_code) REFERENCES Session(session_code)
    			ON UPDATE CASCADE ON DELETE CASCADE,
   	CONSTRAINT Ckacademic_level CHECK (rating BETWEEN 0 AND 5)
);

------------------------------------------------------------------------------------------

-- Inserting into tables

INSERT INTO Account(user_id, user_password) VALUES
  (100, 'saaddr'),
  (101, 'yassirbe'),
  (102, 'khaoulaai'),
  (103, 'nadabo'),
  (104, 'younesja'),
  (1, 'rafahbe'),
  (10, 'lailamo'),
  (11, 'mouadel'),
  (20, 'anassde'),
  (50, 'hassanro'),
  (51, 'wahibakh'),
  (52, 'naimala'),
  (53, 'omarbo'),
  (54, 'fouadzi'),
  (55, 'abdelmajidrb');

INSERT INTO Student(user_id, user_fname, user_lname, user_phonenum, user_dob, user_type, reg_date, academic_level) VALUES
  (100, 'Saad', 'Driouech', '0662097271', '2000-09-15', 'S', '2021-09-01', 'TC'),
  (101, 'Yassir', 'Bendabdellah', '0654789622', '2000-06-14', 'S', '2021-09-01', '1BAC'),
  (102, 'Khaoula', 'Ait Soussi', '0614859473', '2000-12-08', 'S', '2021-09-01', '2BAC'),
  (103, 'Nada', 'Bounajma', '0638749122', '2001-01-22', 'S', '2021-09-01', '1BAC'),
  (104, 'Younes', 'Jamal', '0754399985', '2000-10-01', 'S', '2021-09-01', 'TC');

  

INSERT INTO Admin (user_id, user_fname, user_lname, user_phonenum, user_dob, user_type, admin_role, admin_hiring_date) VALUES
  (1, 'Rafah', 'Bennani', '0512846931', '1982-03-28', 'A', 'O', '2018-09-01'),
  (10, 'Laila', 'Moustaghit', '0546952132', '1990-06-12', 'A', 'M', '2018-09-15'),
  (20, 'Mouad', 'Elazizi', '0548623597', '1988-04-30', 'A', 'S', '2018-09-15'),
  (21, 'Anass', 'Dehbi', '0678549622', '1991-10-24', 'A', 'S', '2019-04-01');

INSERT INTO Tutor(user_id, user_fname, user_lname, user_phonenum, user_dob, user_type, tutor_level) VALUES
  (50, 'Hassan', 'Rouias', '0654896755', '1975-02-14', 'T', 'TC'),
  (51, 'Wahiba', 'Khassim', '0696342100', '1983-03-03', 'T', 'TC'),
  (52, 'Naima', 'Laalami', '0675896314', '1978-08-15', 'T', '1BAC'),
  (53, 'Omar', 'Bouchta', '0666128684', '1976-06-06', 'T', '2BAC'),
  (54, 'Fouad', 'Ziani', '0658669744', '1979-07-12', 'T', 'TC'),
  (55, 'Abdelmajid', 'Rbib', '0685479123','1976-08-12', 'T', 'TC');

INSERT INTO Availability(av_code, av_date, av_start_time, av_end_time, tutor_id) VALUES
  ('1', '2021-12-20', '18:00:00', '20:00:00', 50),
  ('2', '2021-12-21', '19:00:00', '20:30:00', 50),
  ('3', '2021-12-21', '19:00:00', '20:30:00', 51),
  ('4', '2021-12-21', '18:00:00', '20:00:00', 51),
  ('5', '2021-12-20', '19:00:00', '20:30:00', 52),
  ('6', '2021-12-22', '18:30:00', '20:30:00', 53),
  ('7', '2021-12-22', '20:30:00', '21:30:00', 53),
  ('8', '2021-12-22', '18:30:00', '20:30:00', 54),
  ('9', '2021-12-20', '18:30:00', '19:30:00', 50),
  ('10', '2021-12-22', '19:00:00', '20:00:00', 50),
  ('11', '2021-12-23', '18:00:00', '19:30:00', 50);
  

INSERT INTO Course (course_code, course_title, course_level, course_price_hr) VALUES 
  ('MTH1', 'Math 1 BAC', '1BAC', 250.00),
  ('MTH2', 'Math 2 BAC', '2BAC', 300.00),
  ('PHY1', 'Physique 1 BAC', '1BAC', 200.00),
  ('PHY2', 'Physique 2 BAC', '2BAC', 280.00),
  ('MTH0', 'Math tronc commun', 'TC', 150.00),
  ('PHY0', 'Physique TC', 'TC', 120.00),
  ('SVT0', 'Science de Vie et Terre TC', 'TC', 100.00),
  ('SVT1', 'Science de Vie et Terre 1 BAC', '1BAC', 180.00),
  ('SVT2', 'Science de Vie et Terre 2 BAC', '2BAC', 220.00);

INSERT INTO Offering(tutor_id, course_code) VALUES
  (50, 'MTH1'),
  (50, 'MTH0'),
  (51, 'MTH2'),
  (52, 'PHY0'),
  (52, 'PHY1'),
  (52, 'PHY2'),
  (53, 'SVT0'),
  (53, 'SVT1'),
  (54, 'SVT1'),
  (54, 'SVT2');

INSERT INTO Location(room_num, room_seats) VALUES
  (1, 15),
  (2, 7),
  (3, 18),
  (4, 14);

INSERT INTO Session(session_code, session_date, session_start_time, session_end_time, session_seats_av, session_status, course_code, tutor_id, room_num) VALUES
  ('ses1', '2021-12-22', '19:00:00', '20:00:00', 10, 'Open', 'MTH1', 50, 1),
  ('ses2', '2021-12-22', '20:00:00', '21:00:00', 10, 'Open', 'PHY1', 52, 1),
  ('ses3', '2021-12-23', '18:00:00', '19:30:00', 5, 'Open', 'MTH1', 50, 1);

INSERT INTO Booking(student_id, session_code, rating) VALUES
  (100, 'ses1', 5),
  (100, 'ses2', 5),
  (100, 'ses3', 4),
  (101, 'ses1', 4),
  (103, 'ses1', 5),
  (102, 'ses2', 3);
