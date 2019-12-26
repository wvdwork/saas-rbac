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
    id          bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '非业务主键ID',
    user_id     bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '用户ID',
    org_id      bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '组织ID',
    is_del      tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否被删除',
    create_time bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '创建时间',
    create_user varchar(50)         NOT NULL DEFAULT '' COMMENT '创建人',
    update_time bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '最后一次修改时间',
    update_user varchar(50)         NOT NULL DEFAULT '' COMMENT '最后一次修改人',
    PRIMARY KEY (ID)
) ENGINE = InnoDB
  AUTO_INCREMENT = 100000
  DEFAULT CHARSET = utf8mb4 COMMENT ='用户组织表';

DROP TABLE IF EXISTS `t_fm_role`;
CREATE TABLE t_fm_role
(
    id             bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '非业务主键ID',
    role_name      varchar(20)         NOT NULL DEFAULT '' COMMENT '角色名称',
    application_id bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '项目ID',
    company_id     bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '公司ID',
    role_desc      varchar(500)        NOT NULL DEFAULT '' COMMENT '角色描述',
    is_del         tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否被删除',
    create_time    bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '创建时间',
    create_user    varchar(50)         NOT NULL DEFAULT '' COMMENT '创建人',
    update_time    bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '最后一次修改时间',
    update_user    varchar(50)         NOT NULL DEFAULT '' COMMENT '最后一次修改人',
    PRIMARY KEY (ID)
) ENGINE = InnoDB
  AUTO_INCREMENT = 100000
  DEFAULT CHARSET = utf8mb4 COMMENT ='角色表';

DROP TABLE IF EXISTS `t_fm_menu`;
CREATE TABLE t_fm_menu
(
    id               bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '非业务主键ID',
    menu_name        varchar(20)         NOT NULL DEFAULT '' COMMENT '菜单名称',
    parent_id        bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '父节点ID',
    is_leaf_node     tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否叶子节点',
    company_id       bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '公司ID',
    application_id   bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '项目ID',
    icon             varchar(50)         NOT NULL DEFAULT '' COMMENT '菜单图标url',
    extend_propeties varchar(500)        NOT NULL DEFAULT '' COMMENT '扩展属性，json格式',
    path             varchar(500)        NOT NULL DEFAULT '' COMMENT '资源路径',
    redirect_path    varchar(500)        NOT NULL DEFAULT '' COMMENT '转发路径',
    is_del           tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否被删除',
    create_time      bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '创建时间',
    create_user      varchar(50)         NOT NULL DEFAULT '' COMMENT '创建人',
    update_time      bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '最后一次修改时间',
    update_user      varchar(50)         NOT NULL DEFAULT '' COMMENT '最后一次修改人',
    PRIMARY KEY (ID)
) ENGINE = InnoDB
  AUTO_INCREMENT = 100000
  DEFAULT CHARSET = utf8mb4 COMMENT ='菜单表';

DROP TABLE IF EXISTS `t_fm_menu_resource`;
CREATE TABLE t_fm_menu_resource
(
    id              bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '非业务主键ID',
    parent_id       bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '菜单ID',
    resource_name   varchar(20)         NOT NULL DEFAULT '' COMMENT '资源名称',
    resource_type   varchar(20)         NOT NULL DEFAULT '' COMMENT '资源类型',
    resource_url    varchar(200)        NOT NULL DEFAULT '' COMMENT '资源路径',
    resource_method varchar(20)         NOT NULL DEFAULT '' COMMENT '方法名称',
    resource_desc   varchar(500)        NOT NULL DEFAULT '' COMMENT '描述信息',
    is_del          tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否被删除',
    create_time     bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '创建时间',
    create_user     varchar(50)         NOT NULL DEFAULT '' COMMENT '创建人',
    update_time     bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '最后一次修改时间',
    update_user     varchar(50)         NOT NULL DEFAULT '' COMMENT '最后一次修改人',
    PRIMARY KEY (ID)
) ENGINE = InnoDB
  AUTO_INCREMENT = 100000
  DEFAULT CHARSET = utf8mb4 COMMENT ='菜单资源表';

DROP TABLE IF EXISTS `t_fm_data`;
CREATE TABLE t_fm_data
(
    id             bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '非业务主键ID',
    data_name      varchar(50)         NOT NULL DEFAULT '' COMMENT '名称',
    application_id bigint(20)          NOT NULL DEFAULT '0' COMMENT '项目ID',
    data_desc      varchar(500)        NOT NULL DEFAULT '' COMMENT '描述',
    is_del         tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否被删除',
    create_time    bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '创建时间',
    create_user    varchar(50)         NOT NULL DEFAULT '' COMMENT '创建人',
    update_time    bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '最后一次修改时间',
    update_user    varchar(50)         NOT NULL DEFAULT '' COMMENT '最后一次修改人',
    PRIMARY KEY (ID)
) ENGINE = InnoDB
  AUTO_INCREMENT = 100000
  DEFAULT CHARSET = utf8mb4 COMMENT ='数据主表';

DROP TABLE IF EXISTS `t_fm_data_detail`;
CREATE TABLE t_fm_data_detail
(
    id           bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '非业务主键ID',
    data_id      bigint(20)          NOT NULL DEFAULT '0' COMMENT '数据ID',
    detail_type  varchar(50)         NOT NULL DEFAULT '' COMMENT '类型',
    detail_code  varchar(50)         NOT NULL DEFAULT '' COMMENT '编码',
    detail_value varchar(50)         NOT NULL DEFAULT '' COMMENT '值',
    detail_desc  varchar(500)        NOT NULL DEFAULT '' COMMENT '描述',
    sequence     Integer unsigned    NOT NULL DEFAULT '0' COMMENT '序号',
    status       varchar(20)         NOT NULL DEFAULT '' COMMENT '状态',
    is_del       tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否被删除',
    create_time  bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '创建时间',
    create_user  varchar(50)         NOT NULL DEFAULT '' COMMENT '创建人',
    update_time  bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '最后一次修改时间',
    update_user  varchar(50)         NOT NULL DEFAULT '' COMMENT '最后一次修改人',
    PRIMARY KEY (ID)
) ENGINE = InnoDB
  AUTO_INCREMENT = 100000
  DEFAULT CHARSET = utf8mb4 COMMENT ='数据主明细表';


DROP TABLE IF EXISTS `t_fm_role_data`;
CREATE TABLE t_fm_role_data
(
    id          bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '非业务主键ID',
    role_id     bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '角色ID',
    data_type   varchar(50)         NOT NULL DEFAULT '' COMMENT 'menu/menu_resource/data_detail',
    data_id     bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '数据ID',
    is_del      tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否被删除',
    create_time bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '创建时间',
    create_user varchar(50)         NOT NULL DEFAULT '' COMMENT '创建人',
    update_time bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '最后一次修改时间',
    update_user varchar(50)         NOT NULL DEFAULT '' COMMENT '最后一次修改人',
    PRIMARY KEY (ID)
) ENGINE = InnoDB
  AUTO_INCREMENT = 100000
  DEFAULT CHARSET = utf8mb4 COMMENT ='角色数据表';