DROP TABLE IF EXISTS User;
DROP TABLE IF EXISTS Admin;
DROP TABLE IF EXISTS Student;
DROP TABLE IF EXISTS Tutor;
DROP TABLE IF EXISTS Availability;
DROP TABLE IF EXISTS Booking;
DROP TABLE IF EXISTS Course;
DROP TABLE IF EXISTS Offering;
DROP TABLE IF EXISTS Session;
DROP TABLE IF EXISTS Location;


CREATE TABLE User(
	user_id varchar(8) PRIMARY KEY,
	f_name varchar(15) not NULL,
	l_name varchar(15) not NULL,
	password varchar(8) not NULL,
	phone_num char(10),
	DOB date not NULL,
	user_type char(1) not NULL,
	CONSTRAINT CkUser_type CHECK (user_type in ('A', 'S', 'T'))
);

CREATE TABLE Admin(
	PRIMARY KEY(user_id),
	admin_role char(1) not NULL,
	hiring_date date not NULL,
	CONSTRAINT Ckadmin_role CHECK (admin_role in ('S', 'M', 'O'))
)INHERITS user;


CREATE TABLE Student(
	PRIMARY KEY(user_id),
	attended_hours decimal(5,2) not NULL DEFAULT 0,
	stud_balance decimal(4, 2) not NULL,
	reg_date date not NULL,
	academic_level varchar(5) not NULL,
	CONSTRAINT Ckacademic_level CHECK (academic_level in ('TC', '1BAC', '2BAC'))
)INHERITS user;


CREATE TABLE Tutor(
	PRIMARY KEY(user_id),
	balance decimal(5, 2) not NULL DEFAULT 0,
);

CREATE TABLE Availability(
	PRIMARY KEY (av_code),
	av_date date not NULL,
	start_time time NOT NULL, 
	end_time time NOT NULL,
	CONSTRAINT available_at FOREIGN KEY (tutor_id) REFERENCES Tutor(user_id)
                      ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Booking(
	student_id varchar(8) PRIMARY KEY,
	session_code varchar(8) PRIMARY KEY,
	rating smallint,
	CONSTRAINT booked_by FOREIGN KEY (student_id) REFERENCES Student(user_id)
                      	ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT creates FOREIGN KEY (session_code) REFERENCES Session(session_code)
    			ON UPDATE CASCADE ON DELETE CASCADE,
   	CONSTRAINT Ckacademic_level CHECK (rating BETWEEN 0 AND 5)
);

CREATE TABLE Course(

	course_code VARCHAR(8) PRIMARY KEY,
	title VARCHAR(10) not null,
	level VARCHAR(10) not null,
	price_hr decimal(4,2) not null
);

CREATE TABLE Offering(

	tutor_ID VARCHAR(8),
	course_code VARCHAR(8),
	PRIMARY KEY(tutor_ID, course_code)
	CONSTRAINT offers FOREIGN KEY (tutor_ID) REFERENCES Tutor(User_ID)
        		ON UPDATE CASCADE ON DELETE CASCADE
	CONSTRAINT offered_by FOREIGN KEY (course_code) REFERENCES Course(course_code)
        		ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Session(
	session_code VARCHAR(8) PRIMARY KEY,
	session_date date not null,
	start_Time time NOT NULL, 
	end_Time time NOT NULL,
	seats_av smallint not null DEFAULT 14,
	status VARCHAR(9) not null DEFAULT 'Open',
	course_code VARCHAR(8),
	tutor_ID VARCHAR(8),
	room_num int 
	CONSTRAINT CKstatus CHECK (status IN ('Open', 'Closed', 'Canceled')),
	CONSTRAINT corresponds FOREIGN KEY (course_code) REFERENCES OFFERING(course_code)
        		ON UPDATE CASCADE ON DELETE CASCADE
    	CONSTRAINT tutored_by FOREIGN KEY (tutor_ID) REFERENCES OFFERING(tutor_ID)
       	 		ON UPDATE CASCADE ON DELETE CASCADE
     	CONSTRAINT located in FOREIGN KEY (room_num) REFERENCES Location(room_num)
       		 	ON UPDATE CASCADE ON DELETE CASCADE

);

CREATE TABLE Location(
	room_num int PRIMARY KEY,
	room_seats smallint not NULL DEFAULT 14, 
);

