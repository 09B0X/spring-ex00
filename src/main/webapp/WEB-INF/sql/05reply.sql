USE test;

CREATE TABLE Reply (
	id INT PRIMARY KEY AUTO_INCREMENT,
	boardId INT NOT NULL,
    reply VARCHAR(500) NOT NULL,
    memberId VARCHAR(30) NOT NULL,
    inserted DATETIME NOT NULL DEFAULT NOW(),
    updated DATETIME NOT NULL DEFAULT NOW()
);

DESC Reply;

SELECT * FROM Board ORDER BY id DESC; -- 471
SELECT * FROM Member ORDER BY inserted DESC; -- id13

-- test data insert
INSERT INTO Reply (boardId, reply, memberId) VALUES (471, '테스트용 댓글!!@!@!@', 'id13');

SELECT * FROM Reply ORDER BY id DESC;

SELECT r.*, m.nickName FROM Reply r JOIN Member m ON r.memberId = m.id;

SELECT
	b.id,
	b.title,
	b.content,
	b.writer,
	b.inserted,
	b.updated,
	m.nickName,
    count(r.id) replyCount
FROM
	Board b
		LEFT JOIN 
	Member m ON b.writer = m.id
		LEFT JOIN
	Reply r ON b.id = r.boardId
GROUP BY b.id
ORDER BY b.id DESC
LIMIT 0, 10; 