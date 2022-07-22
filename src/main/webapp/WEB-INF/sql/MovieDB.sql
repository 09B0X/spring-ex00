CREATE DATABASE MovieDB; -- 1

USE MovieDB; -- 2

CREATE TABLE Movie (
	id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(200) NOT NULL,
    content VARCHAR(2000) NOT NULL
); -- 3

CREATE TABLE Acter (
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR (200)
); -- 4

CREATE TABLE Appear (
	id INT PRIMARY KEY AUTO_INCREMENT,
    movieId INT NOT NULL,
    acterId INT NOT NULL,
    FOREIGN KEY (movieId) REFERENCES Movie (id),
    FOREIGN KEY (acterId) REFERENCES Acter (id)
); -- 5

-- 6
INSERT INTO Movie (title, content) VALUES ('모가디슈', '소말리아 내전에서 표적이 된 남북한의 방문 외교관들. 탈출계획을 세우기 위해 서로에게 의지한다.');
INSERT INTO Movie (title, content) VALUES ('스파이더맨', '유전자를 조작한 슈퍼 거미에게 물린 고등학생 피터 파커. 그날 이후, 상상을 뛰어넘는 초능력이 생긴다. 거미줄을 쏘고, 벽을 오르고, 엄청난 파워를 뿜게 되다니! 놀림이나 당하던 아약한 시절은 끝났다. 이제 악당들을 물리칠 시간이야.');

DESC Movie;
DESC Acter;
DESC Appear;

SELECT * FROM Movie;