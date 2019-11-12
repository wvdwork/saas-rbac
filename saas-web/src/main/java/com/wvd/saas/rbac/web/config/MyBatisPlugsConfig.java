package com.wvd.saas.rbac.web.config;

import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.wvd.saas.rbac.web.config.handler.MetaObjectHandlerConfig;
import org.apache.ibatis.plugin.Interceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
public class MyBatisPlugsConfig {

    @Autowired(required = false)
    private Interceptor[] interceptors;

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor page = new PaginationInterceptor();
        page.setDialectType("mysql");
        return page;
    }

    @Bean
    public MybatisSqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) throws IOException {
        MybatisSqlSessionFactoryBean mybatisPlus = new MybatisSqlSessionFactoryBean();

        //加载数据源
        mybatisPlus.setDataSource(dataSource);

        //全局配置
        GlobalConfig globalConfig  = new GlobalConfig();
        //配置填充器
        globalConfig.setMetaObjectHandler(new MetaObjectHandlerConfig());
        mybatisPlus.setGlobalConfig(globalConfig);
        mybatisPlus.setPlugins(interceptors);

        return mybatisPlus;
    }
}
