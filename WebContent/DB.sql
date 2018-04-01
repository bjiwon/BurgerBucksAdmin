/* 관리자 사원 등록 테이블 생성 */

DROP TABLE ADMIN
CASCADE CONSTRAINT;

DROP SEQUENCE ADMIN_SEQ;

CREATE TABLE ADMIN(
	SEQ NUMBER(10) PRIMARY KEY,
	ID VARCHAR2(20) UNIQUE,
	PASSWORD VARCHAR2(20) NOT NULL,
	NAME VARCHAR2(20) NOT NULL,
	PHONE NUMBER(20) NOT NULL,
	STORE_SEQ NUMBER(10) NOT NULL,
	DEL NUMBER(1) NOT NULL
)

CREATE SEQUENCE ADMIN_SEQ
START WITH 1
INCREMENT BY 1;


/* 지점 테이블 생성 */

DROP TABLE STORE
CASCADE CONSTRAINT;

DROP SEQUENCE STORE_SEQ;

CREATE TABLE STORE(
	SEQ NUMBER(10) PRIMARY KEY,
	NAME VARCHAR2(100) NOT NULL,
	PHONE NUMBER(20) NOT NULL,
	ADDRESS VARCHAR2(100) NOT NULL,
	LAT NUMBER(10) NOT NULL,
	LNG NUMBER(10) NOT NULL,
	DEL NUMBER(1) NOT NULL
)

CREATE SEQUENCE STORE_SEQ
START WITH 1
INCREMENT BY 1;



ALTER TABLE ADMIN
ADD CONSTRAINT FK_STORE_SEQ FOREIGN KEY(STORE_SEQ)
REFERENCES STORE(SEQ);



