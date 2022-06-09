USE library;

CREATE TABLE books (
  id INT NOT NULL AUTO_INCREMENT,
  callno VARCHAR(100) NOT NULL,
  name VARCHAR(100) NOT NULL,
  author VARCHAR(100) NOT NULL,
  publisher VARCHAR(100) NOT NULL,
  quantity INT NOT NULL,
  issued INT NOT NULL,
  added_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id),
  UNIQUE KEY callno_unique (callno)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO books (callno, name, author, publisher, quantity, issued) VALUES
('A@4', 'C In Depth', 'Shrivastav', 'BPB', 2, 2),
('B@1', 'DBMS', 'Korth', 'Pearson', 3, 0),
('G@12', 'Let''s see', 'Yashwant Kanetkar', 'BPB', 10, 0);
