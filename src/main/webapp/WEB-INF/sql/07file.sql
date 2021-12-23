USE test;

CREATE TABLE File (
	id INT PRIMARY KEY AUTO_INCREMENT,
	boardId INT NOT NULL,
    fileName VARCHAR(255) NOT NULL,
    FOREIGN KEY (boardId) REFERENCES Board(id)
);

DESC File;

SELECT * FROM File ORDER BY boardId DESC, id ASC;

INSERT INTO File (boardId, fileName)
SELECT '513' as boardId, fileName FROM File WHERE boardId = 514;