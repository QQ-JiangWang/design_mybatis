### 自定义框架mybatis
#### 1：只针对于查询数库做了处理
#### 2：如需使用注解版则需在SqlMapConfig.xml中mappers标签下
```xml
<mapper resource="com/wangzai/dao/IUserDao.xml"/>
<mapper class="com.wangzai.dao.IUserDao"/>
```

                                                   
