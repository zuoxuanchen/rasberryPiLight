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