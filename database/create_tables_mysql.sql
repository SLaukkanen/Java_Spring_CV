CREATE TABLE Data (
	first_name VARCHAR(10) NOT NULL
	,last_name VARCHAR(10) NOT NULL
	,birth_day CHAR(10)
	,email VARCHAR(50) NOT NULL
	,address VARCHAR(55) 
	,area_code CHAR(5) 
	,city VARCHAR(30) 
	,phone VARCHAR(15)
	,heading VARCHAR(30)
	,summary VARCHAR(600)
	,PRIMARY KEY (first_name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE Education (
	id INT NOT NULL AUTO_INCREMENT
	,school VARCHAR(50) NOT NULL
	,degree VARCHAR(50) NOT NULL
	,major VARCHAR(50) NOT NULL
	,minors VARCHAR(100)
	,start_year INT(4)
	,finish_year INT(4)
	,date_graduation CHAR(10)
	,description VARCHAR(500)
	,PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE WorkExperience (
	id INT NOT NULL AUTO_INCREMENT
	,workplace VARCHAR(50) NOT NULL
	,position VARCHAR(50) NOT NULL	
	,start_date CHAR(10) NOT NULL
	,finish_date CHAR(10)
	,description VARCHAR(500)
	,PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE Skill (
	id INT NOT NULL AUTO_INCREMENT
	,skill VARCHAR(50) NOT NULL
	,description VARCHAR(500)
	,PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE Language (
	lang VARCHAR(50) NOT NULL
	,level VARCHAR(100)
	,PRIMARY KEY (lang)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE authority (
  id integer NOT NULL auto_increment PRIMARY KEY,
  role varchar(255) NOT NULL UNIQUE
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 
 CREATE TABLE webuser (
  id integer NOT NULL auto_increment PRIMARY KEY,
  username varchar(255) NOT NULL UNIQUE,
  password_encrypted varchar(255) NOT NULL,
  enabled tinyint NOT NULL,
  firstname varchar(255) default NULL,
  lastname varchar(255) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE webuser_authority (
  id integer NOT NULL auto_increment PRIMARY KEY,
  webuser_id integer NOT NULL,
  authority_id integer NOT NULL,
  FOREIGN KEY (webuser_id) REFERENCES webuser(id) ON DELETE NO ACTION ON UPDATE NO ACTION,
  FOREIGN KEY (authority_id) REFERENCES authority(id) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;