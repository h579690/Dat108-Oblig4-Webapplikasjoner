drop schema if exists DAT108_Oblig4 cascade;
create schema DAT108_Oblig4;

set search_path = DAT108_Oblig4;

--DROP TABLE IF EXISTS deltager;

create table deltager 
(
	mobil character(8),
	fornavn VARCHAR,
	etternavn VARCHAR,
	passordSalt VARCHAR,
	passordHash VARCHAR,
	kjonn char,
	
	constraint mobil_pk primary key (mobil),
	constraint mobil_unik unique (mobil)
	
);
	