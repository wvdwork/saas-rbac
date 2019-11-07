CREATE DATABASE IF NOT EXISTS saas DEFAULT CHARSET utf8mb4 COLLATE utf8mb4_general_ci;
use saas;

DROP TABLE IF EXISTS `t_fm_company`;
CREATE TABLE t_fm_company (
    id bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '非业务主键ID',
    company_code	varchar(50)	NOT NULL DEFAULT '' COMMENT '公司编码',
    company_name	varchar(50) NOT NULL DEFAULT '' COMMENT '公司名称',
    company_profile	varchar(500) NOT NULL DEFAULT '' COMMENT '公司简介',
    company_legal	varchar(50) NOT NULL DEFAULT '' COMMENT '企业法人',
    company_phone	varchar(50) NOT NULL DEFAULT '' COMMENT '公司电话',
    company_mail	varchar(100) NOT NULL DEFAULT '' COMMENT '公司邮箱',
    company_logo_url	varchar(500) NOT NULL DEFAULT '' COMMENT '公司logo地址',
    company_dis_name	varchar(20) NOT NULL DEFAULT '' COMMENT '公司显示名称',
    is_active	tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '是否有效',
    is_del	tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否被删除',
    create_time	bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '创建时间',
    create_user	varchar(50) NOT NULL DEFAULT '' COMMENT '创建人',
    update_time	bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '最后一次修改时间',
    update_user	varchar(50) NOT NULL DEFAULT '' COMMENT '最后一次修改人',
    PRIMARY KEY(ID)
) ENGINE=InnoDB AUTO_INCREMENT=100000 DEFAULT CHARSET=utf8mb4 COMMENT='公司信息表';