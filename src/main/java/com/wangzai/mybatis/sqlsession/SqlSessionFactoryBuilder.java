package com.wangzai.mybatis.sqlsession;

import com.wangzai.mybatis.cfg.Configuration;
import com.wangzai.mybatis.sqlsession.impl.DefaultSqlSessionFactory;
import com.wangzai.utils.XMLConfigBuilder;

import java.io.InputStream;

public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(InputStream in) {
        Configuration cfg = XMLConfigBuilder.loadConfiguration(in);
        return new DefaultSqlSessionFactory(cfg);
    }
}
