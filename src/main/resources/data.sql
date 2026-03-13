-- -- resources -> sql -> data.sql 파일
-- -- day09 todo sample insert --
--
-- INSERT INTO todo( title, content, done, create_date, update_date ) VALUES( "스프링 부트 마스터", "Rest API 설계 원리 파악하기", false, NOW(), NOW() );
-- INSERT INTO todo( title, content, done, create_date, update_date ) VALUES( "데이터베이스 설계", "정규화 과정 복습 및 ERD 그려보기", false, NOW(), NOW() );
-- INSERT INTO todo( title, content, done, create_date, update_date ) VALUES( "운동 가기", "오운완 인증샷 찍기 (하체 하는 날)", false, NOW(), NOW() );
-- INSERT INTO todo( title, content, done, create_date, update_date ) VALUES( "독서하기", "클린 코드 3장까지 읽고 정리하기", false, NOW(), NOW() );
-- INSERT INTO todo( title, content, done, create_date, update_date ) VALUES( "장보기", "우유, 달걀, 닭가슴살 사오기", true, NOW(), NOW() );
-- INSERT INTO todo( title, content, done, create_date, update_date ) VALUES( "리액트 공부", "컴포넌트 생명주기 완벽 이해하기", false, NOW(), NOW() );
-- INSERT INTO todo( title, content, done, create_date, update_date ) VALUES( "알고리즘 문제 풀이", "프로그래머스 레벨 2 정렬 문제 풀기", false, NOW(), NOW() );
-- INSERT INTO todo( title, content, done, create_date, update_date ) VALUES( "방 청소", "책상 위랑 침대 밑 먼지 제거하기", true, NOW(), NOW() );
-- INSERT INTO todo( title, content, done, create_date, update_date ) VALUES( "영어 회화", "유튜브 쉐도잉 영상 20분 반복하기", false, NOW(), NOW() );
-- INSERT INTO todo( title, content, done, create_date, update_date ) VALUES( "블로그 포스팅", "오늘 배운 자바 문법 정리해서 올리기", false, NOW(), NOW() );



-- 0313 day09 practice 실습 sql --
INSERT INTO article (title,content,created_at,updated_at) VALUES ('제목1','내용1',NOW(),NOW());
INSERT INTO article (title,content,created_at,updated_at) VALUES ('제목2','내용2',NOW(),NOW());
INSERT INTO article (title,content,created_at,updated_at) VALUES ('제목3','내용3',NOW(),NOW());