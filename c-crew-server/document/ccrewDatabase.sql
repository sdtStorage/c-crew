
-- ccrewDatabase 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `ccrewDatabase` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;
USE `ccrewDatabase`;

-- 테이블 ccrewDatabase.USER_INFO 구조 내보내기
CREATE TABLE IF NOT EXISTS `USER_INFO` (
  `USER_NO` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '사용자번호',
  `USER_NAME` varchar(300) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '사용자명',
  `SCORE` int(6) NOT NULL DEFAULT 0 COMMENT '점수',
  PRIMARY KEY (`USER_NO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='사용자정보테이블';

/*!40000 ALTER TABLE `USER_INFO` DISABLE KEYS */;
INSERT INTO `USER_INFO` (`USER_NO`, `USER_NAME`, `SCORE`) VALUES
	('1', '홍길동', 0),
	('2', '정은채', 1),
	('3', '정태영', 5);
