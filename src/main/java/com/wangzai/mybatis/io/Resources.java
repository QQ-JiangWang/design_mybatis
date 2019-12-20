package com.wangzai.mybatis.io;

import java.io.InputStream;

public class Resources {
    /**
     * 获取读取文件流
     * @param path
     * @return
     */
    public static InputStream getResourceAsStream(String path) {
        return Resources.class.getClassLoader().getResourceAsStream(path);
    }
}
