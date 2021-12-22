USE test;

CREATE TABLE MyTable30 (
	id INT PRIMARY KEY AUTO_INCREMENT,
    prefix VARCHAR(10)
);

INSERT INTO MyTable30 (prefix) VALUES ('testid');

INSERT INTO MyTable30 (prefix) SELECT prefix FROM MyTable30;

SELECT * FROM MyTable30 ORDER BY id DESC;

DESC Member;

INSERT INTO Member (id, password, email, address, nickName)
SELECT concat(prefix, id), 'pw', concat(prefix, id, '@gmail.com'), 'seoul', concat(prefix, id) FROM MyTable30;

SELECT count(*) FROM Member;