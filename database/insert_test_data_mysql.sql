INSERT INTO Data
	(first_name, last_name, birth_day, email, address, area_code, city, phone, heading, summary)
values
	('Testi', 'Testinen', '30.01.1984', 'testi@testi.com', 'Puistotie 1', '00330', 'Helsinki', '0501234567', 'Testi', 'testidataatestidataa');

INSERT INTO Data
	(first_name, last_name, birth_day, email, address, area_code, city, phone, heading, summary)
values
	('Testi2', 'Testinen2', '20.01.1945', 'testi2@testi.com', 'Puistotie 2', '00550', 'Helsinki', '0501234568', 'Testi2', 'testidataatestidataa2');	
	
INSERT INTO Education
	(school, degree, major)
VALUES
	('Testikoulu', 'Testailija', 'Testit');	
	
INSERT INTO WorkExperience
	(workplace, position, start_date)
VALUES
	('Testipaikka', 'Testaaja', '20.02.2001');
	
INSERT INTO Skill
	(skill)
VALUES
	('testi');
	
INSERT INTO Language
	(lang)
VALUES
	('testiä');
	
INSERT INTO
	authority
VALUES
	(1,'ROLE_ADMIN');

INSERT INTO
	webuser
VALUES
	(1,'admin','0595c149d299f14216320c10d440593f6b7e5e3af9b3a54e503f30ad722c64e0771429671e026bf2',1,'Suvi','Laukkanen');
	
INSERT INTO
	webuser_authority
VALUES
	(1,1,1);

