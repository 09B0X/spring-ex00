USE test;

DESC Board;
-- Board.writer 가 Member.id 참조
ALTER TABLE Board
ADD FOREIGN KEY (writer) REFERENCES Member(id);

-- 탈퇴한 아이디의 게시물을 삭제
DELETE FROM Board WHERE id IN 
(
SELECT b.id 
FROM Board b LEFT JOIN Member m ON b.writer = m.id
WHERE m.id IS NULL
);

-- Reply boardId 가 Board id 를 참조
ALTER TABLE Reply
ADD FOREIGN KEY (boardId) REFERENCES Board(id);

-- Reply memberId 가 Member id 를 참조
ALTER TABLE Reply
ADD FOREIGN KEY (memberId) REFERENCES Member(id);

DESC Reply;