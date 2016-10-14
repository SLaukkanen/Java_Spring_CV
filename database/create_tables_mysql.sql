CREATE TABLE Data (
	first_name VARCHAR(10) NOT NULL
	,last_name VARCHAR(10) NOT NULL
	,email VARCHAR(50) NOT NULL
	,address VARCHAR(55) 
	,area_code CHAR(5) 
	,city VARCHAR(30) 
	,phone VARCHAR(15)
	, heading VARCHAR(30)
	,summary VARCHAR(600)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;