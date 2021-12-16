USE test;
DESC Board;
SELECT COUNT(*) FROM Board;
INSERT INTO Board (title, content, writer)
(SELECT title, content, writer FROM Board);

SELECT
	b.id,
	b.title,
	b.content,
	b.writer,
	b.inserted,
	b.updated,
	m.nickName
FROM
	Board b
		LEFT JOIN
	Member m 
		ON 
	b.writer = m.id
ORDER BY
	id DESC
LIMIT 0, 10; 
-- from(0-index), number
-- page 1 : 0, 10
-- page 2 : 10, 10
-- page 3 : 20, 10
-- page 4 : 30, 10
-- page 5 : 40, 10
  