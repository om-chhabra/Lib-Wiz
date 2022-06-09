USE library;

CREATE TABLE IF NOT EXISTS issuebooks (
  id INT(11) NOT NULL AUTO_INCREMENT,
  bookcallno VARCHAR(50) NOT NULL,
  studentid INT(11) NOT NULL,
  studentname VARCHAR(50) NOT NULL,
  studentcontact VARCHAR(20) NOT NULL,
  issueddate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=8;

INSERT INTO issuebooks (bookcallno, studentid, studentname, studentcontact, issueddate) VALUES
('A@4', 23, 'kk', '932992932', '2016-07-19 18:43:16'),
('A@4', 335, 'Sumedh', '95676565756', '2016-07-19 18:44:34'),
('A@4', 87, 'abhishek', '9329882382', '2016-07-19 18:46:12');
