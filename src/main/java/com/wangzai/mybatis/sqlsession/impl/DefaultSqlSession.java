package com.wangzai.mybatis.sqlsession.impl;

import com.wangzai.mybatis.cfg.Configuration;
import com.wangzai.mybatis.sqlsession.SqlSession;
import com.wangzai.mybatis.sqlsession.proxy.MapperProxy;
import com.wangzai.utils.DataSourceUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;

public class DefaultSqlSession implements SqlSession {
    private Configuration cfg;
    private Connection connection;
    public DefaultSqlSession(Configuration cfg){
        this.cfg = cfg;
        this.connection = DataSourceUtil.getConnection(cfg);
    }
    public <T> T getMapper(Class<T> daoInterfaceClass) {
        return (T) Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),new Class[]{daoInterfaceClass},new MapperProxy(cfg,connection));
    }

    public void close() {
        try{
            connection.close();
        }catch (Exception e){
            e.fillInStackTrace();
        }
    }
}
