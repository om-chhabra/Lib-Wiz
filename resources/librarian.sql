USE library;

CREATE TABLE librarian (
  id INT(5) NOT NULL AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  password VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL,
  address VARCHAR(200) NOT NULL,
  city VARCHAR(100) NOT NULL,
  contact VARCHAR(20) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO librarian (name, password, email, address, city, contact) VALUES
('Prabhakar', 'ppp', 'prabhakar@gmail.com', 'javatpoint', 'noida', '9998328238'),
('sumedh', 'sumesh', 'sumesh@gmail.com', 'Kuch Bhi', 'noida', '93823932823'),
('abhi', 'abhi', 'abhi@gmail.com', 'javatpoint', 'noida', '92393282323');
