
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
	
	
INSERT INTO Data
	(first_name, last_name, birth_day, email, address, area_code, city, phone, heading, summary)
values
	('Suvi', 'Laukkanen', '30.01.1984', 'suvi.laukkanen2@myy.haaga-helia.com', 'Orapihlajanpolku 7', '01360', 'Vantaa', '0501234567', 'Back-end devaaja', 'Olen innokas ja iloinen ongelmanratkaisija.');		

	INSERT INTO Education
	(school, degree, major)
VALUES
	('Haaga-Helia ammattikorkeakoulu', 'Tradenomi', 'Tietojenkäsittelyn koulutusohjelma');	

	INSERT INTO WorkExperience
	(workplace, position, start_date)
VALUES
	('HOK-Elanto', 'Myyjä', '28.02.2005');

	INSERT INTO Skill
	(skill)
VALUES
	('JavaEE');

	INSERT INTO Language
	(lang, level)
VALUES
	('Englanti', 'Erinomainen');
