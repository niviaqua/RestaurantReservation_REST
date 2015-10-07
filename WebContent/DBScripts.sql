
DROP TABLE IF EXISTS `reservation`;

CREATE TABLE `reservation` (
  `CONFID` int(11) NOT NULL AUTO_INCREMENT,
  `HOST_NAME` VARCHAR(45) NOT NULL,
  `EMAIL` VARCHAR(80) NOT NULL,
  `PHONE` VARCHAR(30) NOT NULL,
  `PARTY_SIZE` int(11) NOT NULL,
  `DATE` DATETIME NOT NULL,
  `TIME` TIME NOT NULL,
  `TABLE_ASSIGNED` VARCHAR(20) DEFAULT NULL,
  `TABLE_STATUS` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`CONFID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `login`;

CREATE TABLE `login` (
  `USERNAME` VARCHAR(50) NOT NULL,
  `PASSWORD` VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `restaurantprofile`;

CREATE TABLE `restaurantprofile` (
`RESTAURANT_NAME` varchar(50) DEFAULT NULL,
`EMAIL` varchar(50) DEFAULT NULL,
`ADDRESS1`  varchar(50) DEFAULT NULL,
`ADDRESS2` varchar(50) DEFAULT NULL,
`CITY` varchar(45) DEFAULT NULL,
`STATE` varchar(10) DEFAULT NULL,
`ZIP` int(11) DEFAULT NULL,
`CONTACT_NO` VARCHAR(20) DEFAULT NULL,
`TIMINGS` VARCHAR(50) DEFAULT NULL,
`AUTO_ASSIGN` VARCHAR(5)
) ENGINE=InnoDB DEFAULT charset=utf8

