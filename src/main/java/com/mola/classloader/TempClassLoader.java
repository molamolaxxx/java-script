package com.mola.classloader;

/**
 * @author : molamola
 * @Project: java-script
 * @Description:
 * @date : 2020-12-20 02:31
 **/
public class TempClassLoader extends ClassLoader {

    public static final String TEMP_CLASS_NAME = "Temp";

    /**
     * 定义自己的classloader
     * @param b class二进制字节码
     * @param off start-position
     * @param len class长度
     * @return
     */
    public Class<?> defineMyClass(byte[] b, int off ,int len, String className){
        String className0 = (className == null? TEMP_CLASS_NAME : className);
        return super.defineClass(className0, b,off,len);
    }
}
