CREATE SCHEMA `pi` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE `pi`.`t_program` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL COMMENT '名称',
  `play_time` VARCHAR(10) NOT NULL COMMENT '放送时间',
  `e_num` VARCHAR(10) NOT NULL COMMENT '期数',
  `hanfan_url` VARCHAR(200) NULL COMMENT 'hanfan地址',
  `play_url` VARCHAR(200) NULL COMMENT '播放地址',
  `baidu_url` VARCHAR(45) NULL COMMENT '百度云地址',
  `baidu_pwd` VARCHAR(10) NULL COMMENT '百度云密码',
  `crt_time` TIMESTAMP NULL COMMENT '创建时间',
  PRIMARY KEY (`id`))
COMMENT = '节目表';

ALTER TABLE `pi`.`t_program` 
CHANGE COLUMN `id` `id` INT(11) UNSIGNED NOT NULL ,
ADD UNIQUE INDEX `id_UNIQUE` (`id` ASC);

CREATE TABLE `pi`.`t_nick_name` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nick_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
COMMENT = '用户昵称表';

CREATE TABLE `pi`.`t_work_day` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `start_date` TIMESTAMP NOT NULL,
  `end_date` TIMESTAMP NOT NULL,
  `is_work_day` INT NOT NULL DEFAULT 1 COMMENT '1-是工作日\n0-不是工作日',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
COMMENT = '工作日表';

CREATE TABLE `pi`.`t_weather` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `date` TIMESTAMP NOT NULL,
  `weather` VARCHAR(45) NULL COMMENT '天气',
  `temp` INT NULL COMMENT '温度 摄氏度',
  `pm` INT NULL COMMENT '雾霾',
  `comment` VARCHAR(200) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
COMMENT = '天气表';

CREATE TABLE `pi`.`t_hints` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `year` INT NULL COMMENT '年 通配符为*',
  `month` INT NULL,
  `day` INT NULL,
  `old_year` INT NULL,
  `old_month` INT NULL,
  `old_day` INT NULL,
  `birth_name` VARCHAR(45) NULL,
  `hints` VARCHAR(500) NULL COMMENT '待办事项',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
COMMENT = '备忘录表';

CREATE TABLE `pi`.`t_news` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `date` TIMESTAMP NOT NULL,
  `title` VARCHAR(200) NULL,
  `content` VARCHAR(5000) NULL,
  `comment` VARCHAR(200) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
COMMENT = '新闻表';

ALTER TABLE `pi`.`t_hints` 
ADD COLUMN `schedule_day` INT NULL COMMENT '间隔多少天重新提示' AFTER `old_day`;
