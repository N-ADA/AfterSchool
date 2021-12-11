CREATE TABLE User(
	user_id varchar(8) PRIMARY KEY,
	f_name varchar(15) not NULL,
	l_name varchar(15) not NULL,
	password varchar(8) not NULL,
	phone_num char(10),
	dob date not NULL,
	user_type char(1) not NULL,
	CONSTRAINT CkUser_type CHECK (user_type in ('A', 'S', 'T'))
);

CREATE TABLE Admin(
	PRIMARY KEY(user_id),
	admin_role char(1) not NULL,
	date_hired date not NULL,
	CONSTRAINT Ckadmin_role CHECK (admin_role in ('S', 'M', 'O'))
)INHERITS user;


CREATE TABLE Student(
	PRIMARY KEY(user_id),
	attended_hours int not NULL DEFAULT 0,
	balance decimal(4, 2) not NULL,
	reg_date date not NULL,
	academic_level varchar(5) not NULL,
	CONSTRAINT Ckacademic_level CHECK (academic_level in ('TC', '1BAC', '2BAC'))
)INHERITS user;


CREATE TABLE Tutor(
	PRIMARY KEY(user_id),
	balance decimal(5, 2) not NULL DEFAULT 0,
);

CREATE TABLE Availability(
	av_code varchar(),
	start_time time NOT NULL, 
	end_time time NOT NULL,
	CONSTRAINT available_at FOREIGN KEY (tutor_id) REFERENCES Tutor(user_id)
                      ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Booking(
	student_id varchar(8) PRIMARY KEY,
	session_code varchar(8) PRIMARY KEY,
	rating smallint ,
	CONSTRAINT booked_by FOREIGN KEY (student_id) REFERENCES Student(user_id)
                      	ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT creates FOREIGN KEY (session_code) REFERENCES Session(session_code)
    					ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT Ckacademic_level CHECK (rating <= 5)
);

CREATE TABLE COURSE(

	course_code VARCHAR(8) PRIMARY KEY,
	title VARCHAR(10) not null,
	level VARCHAR(10) not null,
	price/hr decimal(4,2) not null
);

CREATE TABLE OFFERING(

	tutor_ID VARCHAR(8),
	course_code VARCHAR(8),
	PRIMARY KEY(tutor_ID, course_code)
	CONSTRAINT offers FOREIGN KEY (tutor_ID) REFERENCES Tutor(User_ID)
        ON UPDATE CASCADE ON DELETE CASCADE
	CONSTRAINT offered by FOREIGN KEY (course_code) REFERENCES Course(course_code)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE SESSION(

	session_code VARCHAR(8) PRIMARY KEY,
	session_Date date not null,
	start_Time time NOT NULL, 
	end_Time time NOT NULL,
	seats_av smallint not null DEFAULT 14,
	status VARCHAR(9) not null,
	course_code VARCHAR(8),
	tutor_ID VARCHAR(8),
	room_num int 
	CONSTRAINT CKstatus CHECK (status IN ('open', 'closed', 'canceled')),
	CONSTRAINT corresponds FOREIGN KEY (course_code) REFERENCES OFFERING(course_code)
        ON UPDATE CASCADE ON DELETE CASCADE
    CONSTRAINT corresponds FOREIGN KEY (tutor_ID) REFERENCES OFFERING(tutor_ID)
        ON UPDATE CASCADE ON DELETE CASCADE
    CONSTRAINT located in FOREIGN KEY (room_num) REFERENCES Location(room_num)
        ON UPDATE CASCADE ON DELETE CASCADE

);

CREATE TABLE Location(
	room_num int not null,
	floor_num int not null
);

