package com.wangzai.mybatis.sqlsession.proxy;

import com.wangzai.mybatis.cfg.Configuration;
import com.wangzai.mybatis.cfg.Mapper;
import com.wangzai.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

public class MapperProxy implements InvocationHandler {
    private Configuration cfg;
    private Connection conn;
    public MapperProxy(Configuration cfg, Connection conn) {
        this.cfg = cfg;
        this.conn = conn;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //1：获取用户调用方法
        String methodName = method.getName();
        //2：获取调用类
        String className = method.getDeclaringClass().getName();
        String key =  className+ "."+methodName;
        if (cfg == null){
            return null;
        }
        //3：获取用户调用方法对应的sql
        Map<String, Mapper> mappers = cfg.getMappers();
        Mapper mapper = mappers.get(key);

        return new Executor().selectList(mapper,conn);
    }
}
