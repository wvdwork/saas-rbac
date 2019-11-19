CREATE DATABASE IF NOT EXISTS saas DEFAULT CHARSET utf8mb4 COLLATE utf8mb4_general_ci;
use saas;

DROP TABLE IF EXISTS `t_fm_company`;
CREATE TABLE t_fm_company
(
    id               bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '非业务主键ID',
    company_code     varchar(50)         NOT NULL DEFAULT '' COMMENT '公司编码',
    company_name     varchar(50)         NOT NULL DEFAULT '' COMMENT '公司名称',
    company_profile  varchar(500)        NOT NULL DEFAULT '' COMMENT '公司简介',
    company_legal    varchar(50)         NOT NULL DEFAULT '' COMMENT '企业法人',
    company_phone    varchar(50)         NOT NULL DEFAULT '' COMMENT '公司电话',
    company_mail     varchar(100)        NOT NULL DEFAULT '' COMMENT '公司邮箱',
    company_logo_url varchar(500)        NOT NULL DEFAULT '' COMMENT '公司logo地址',
    company_dis_name varchar(20)         NOT NULL DEFAULT '' COMMENT '公司显示名称',
    is_active        tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '是否有效',
    is_del           tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否被删除',
    create_time      bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '创建时间',
    create_user      varchar(50)         NOT NULL DEFAULT '' COMMENT '创建人',
    update_time      bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '最后一次修改时间',
    update_user      varchar(50)         NOT NULL DEFAULT '' COMMENT '最后一次修改人',
    PRIMARY KEY (ID)
) ENGINE = InnoDB
  AUTO_INCREMENT = 100000
  DEFAULT CHARSET = utf8mb4 COMMENT ='公司信息表';

DROP TABLE IF EXISTS `t_fm_organization`;
CREATE TABLE `t_fm_organization`
(
    `id`          bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '非业务主键ID',
    `org_name`    varchar(50)         NOT NULL DEFAULT '''' COMMENT '组织名',
    `org_code`    varchar(50)         NOT NULL DEFAULT '''' COMMENT '组织编码唯一',
    `org_level`   int(10) unsigned    NOT NULL DEFAULT '0' COMMENT '等级',
    `parent_id`   bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '父节点ID',
    `seq`         bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '排序',
    `is_del`      tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否被删除',
    `create_time` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '创建时间',
    `create_user` varchar(50)         NOT NULL DEFAULT '' COMMENT '创建人',
    `update_time` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '最后一次修改时间',
    `update_user` varchar(50)         NOT NULL DEFAULT '' COMMENT '最后一次修改人',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 100007
  DEFAULT CHARSET = utf8mb4 COMMENT ='组织表';


DROP TABLE IF EXISTS `t_fm_application`;
CREATE TABLE t_fm_application
(
    id               bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '非业务主键ID',
    application_code varchar(50)         NOT NULL DEFAULT '' COMMENT '项目编码',
    application_name varchar(50)         NOT NULL DEFAULT '' COMMENT '项目名称',
    application_desc varchar(500)        NOT NULL DEFAULT '' COMMENT '项目描述',
    company_id       bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '公司ID',
    is_active        tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '是否有效',
    is_del           tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否被删除',
    create_time      bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '创建时间',
    create_user      varchar(50)         NOT NULL DEFAULT '' COMMENT '创建人',
    update_time      bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '最后一次修改时间',
    update_user      varchar(50)         NOT NULL DEFAULT '' COMMENT '最后一次修改人',
    PRIMARY KEY (ID)
) ENGINE = InnoDB
  AUTO_INCREMENT = 100000
  DEFAULT CHARSET = utf8mb4 COMMENT ='项目信息';

DROP TABLE IF EXISTS `t_fm_user`;
CREATE TABLE t_fm_user
(
    id             bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '非业务主键ID',
    user_name      varchar(50)         NOT NULL DEFAULT '' COMMENT '用户名称',
    user_phone     varchar(50)         NOT NULL DEFAULT '' COMMENT '用户电话',
    user_nick_name varchar(50)         NOT NULL DEFAULT '' COMMENT '用户昵称',
    user_en_name   varchar(50)         NOT NULL DEFAULT '' COMMENT '英文名称',
    user_mail      varchar(50)         NOT NULL DEFAULT '' COMMENT '用户邮箱',
    company_id     bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '公司ID',
    is_active      tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '是否有效',
    is_del         tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否被删除',
    create_time    bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '创建时间',
    create_user    varchar(50)         NOT NULL DEFAULT '' COMMENT '创建人',
    update_time    bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '最后一次修改时间',
    update_user    varchar(50)         NOT NULL DEFAULT '' COMMENT '最后一次修改人',
    PRIMARY KEY (ID)
) ENGINE = InnoDB
  AUTO_INCREMENT = 100000
  DEFAULT CHARSET = utf8mb4 COMMENT ='用户信息表';

DROP TABLE IF EXISTS `t_fm_user_account`;
CREATE TABLE t_fm_user_account
(
    id           bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '非业务主键ID',
    user_id      bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '用户ID（子系统ID）',
    user_account varchar(200)        NOT NULL DEFAULT '' COMMENT '登录帐号',
    account_type varchar(50)         NOT NULL DEFAULT '' COMMENT '帐号类型',
    login_count  integer unsigned    NOT NULL DEFAULT '0' COMMENT '登录次数',
    is_active    tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '是否有效',
    is_del       tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否被删除',
    create_time  bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '创建时间',
    create_user  varchar(50)         NOT NULL DEFAULT '' COMMENT '创建人',
    update_time  bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '最后一次修改时间',
    update_user  varchar(50)         NOT NULL DEFAULT '' COMMENT '最后一次修改人',
    PRIMARY KEY (ID)
) ENGINE = InnoDB
  AUTO_INCREMENT = 100000
  DEFAULT CHARSET = utf8mb4 COMMENT ='用户账号表';

DROP TABLE IF EXISTS `t_fm_password`;
CREATE TABLE t_fm_password
(
    id                       bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '非业务主键ID',
    user_id                  bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '用户ID',
    account_id               varchar(50)         NOT NULL DEFAULT '' COMMENT '帐号ID',
    user_password            varchar(50)         NOT NULL DEFAULT '' COMMENT '用户密码',
    password_expired_time    bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '密码过期时间',
    login_error_count        integer unsigned    NOT NULL DEFAULT '0' COMMENT '登陆错误次数',
    login_error_expired_time bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '登录错误控制失效时间',
    is_locked                tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '是否被锁定',
    is_active                tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '是否有效',
    is_del                   tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否被删除',
    create_time              bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '创建时间',
    create_user              varchar(50)         NOT NULL DEFAULT '' COMMENT '创建人',
    update_time              bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '最后一次修改时间',
    update_user              varchar(50)         NOT NULL DEFAULT '' COMMENT '最后一次修改人',
    PRIMARY KEY (ID)
) ENGINE = InnoDB
  AUTO_INCREMENT = 100000
  DEFAULT CHARSET = utf8mb4 COMMENT ='用户密码表';

DROP TABLE IF EXISTS `t_fm_org_user`;
CREATE TABLE t_fm_org_user
(
    id                       bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '非业务主键ID',
    user_id                  bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '用户ID',
    org_id                   bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '组织ID',
    is_del                   tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否被删除',
    create_time              bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '创建时间',
    create_user              varchar(50)         NOT NULL DEFAULT '' COMMENT '创建人',
    update_time              bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '最后一次修改时间',
    update_user              varchar(50)         NOT NULL DEFAULT '' COMMENT '最后一次修改人',
    PRIMARY KEY (ID)
) ENGINE = InnoDB
  AUTO_INCREMENT=100000 DEFAULT CHARSET = utf8mb4 COMMENT ='用户组织表';