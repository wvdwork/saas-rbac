package com.wvd.saas.rbac.web.config.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

public class MetaObjectHandlerConfig implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
         setFieldValByName("createTime", System.currentTimeMillis()/1000, metaObject);
         setFieldValByName("createUser", "auto", metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        setFieldValByName("updateTime", System.currentTimeMillis(), metaObject);
        setFieldValByName("updateUser", System.currentTimeMillis(), metaObject);
    }
}
