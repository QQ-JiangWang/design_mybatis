package com.wangzai.mybatis.sqlsession.impl;

import com.wangzai.mybatis.cfg.Configuration;
import com.wangzai.mybatis.sqlsession.SqlSession;
import com.wangzai.mybatis.sqlsession.SqlSessionFactory;

public class DefaultSqlSessionFactory implements SqlSessionFactory {
    private Configuration cfg;
    public DefaultSqlSessionFactory(Configuration cfg) {
        this.cfg = cfg;
    }

    public SqlSession openSession() {
        return new DefaultSqlSession(cfg);
    }
}
