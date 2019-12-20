package com.wangzai.test;

import com.wangzai.admin.User;
import com.wangzai.dao.IUserDao;
import com.wangzai.mybatis.io.Resources;
import com.wangzai.mybatis.sqlsession.SqlSession;
import com.wangzai.mybatis.sqlsession.SqlSessionFactory;
import com.wangzai.mybatis.sqlsession.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    @Test
    public void Test() throws  Exception{
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        // 2.1：读取配置文件中的连接数据库驱动信息
        // 2.2：读取用户配置的所有mapper,或者注解，将所有配置的sql以及类全路径.方法存入Map中
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂生产SqlSession对象
        SqlSession session = factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        IUserDao userDao = session.getMapper(IUserDao.class);
        //5.使用代理对象执行方法
        List<User> users = userDao.findAll();
        for(User user : users){
            System.out.println(user);
        }
        //6.释放资源
        session.close();
        in.close();
    }
}
