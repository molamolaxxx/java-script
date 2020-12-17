package com.mola.compiler;

import com.mola.constants.StorageConfig;
import com.mola.result.CompileResult;
import com.sun.tools.javac.main.Main;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author : molamola
 * @Project: java-script
 * @Description:
 * @date : 2020-12-17 17:46
 **/
public class JavacCompiler implements ICompiler{

    private com.sun.tools.javac.main.Main compiler = new com.sun.tools.javac.main.Main("javac");

    @Override
    public CompileResult compile(StringBuilder sourceCode) {
        String path = saveTempSourceFile(sourceCode);
        if (null == path) {
            return CompileResult.failed();
        }
        return compile(path);
    }

    @Override
    public CompileResult compile(String sourcePath) {
        String classPath = sourcePath.substring(0, sourcePath.length()-5) + ".class";
        try {
            Main.Result compile = compiler.compile(new String[]{sourcePath});
            if (!compile.isOK()) {
                return CompileResult.failed();
            }
            byte[] bytes = readByteFromClassFile(classPath);

            return new CompileResult(bytes, classPath, sourcePath, true);
        } finally {
            // 删除源码路径
            FileUtils.deleteQuietly(new File(sourcePath));
            // 删除class路径
            FileUtils.deleteQuietly(new File(classPath));
        }

    }

    /**
     * 将源代码存入temp文件
     * @param sourceCode
     * @return 文件地址
     */
    private String saveTempSourceFile(StringBuilder sourceCode){
        String filePath = StorageConfig.TEMP_FILE_ROOT + "/" + "JavaScriptModel" + ".java";
        try {
            FileUtils.writeByteArrayToFile(new File(filePath), sourceCode.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return filePath;
    }

    private byte[] readByteFromClassFile(String classPath) {
        File file = new File(classPath);
        byte[] classBytes = new byte[(int) file.length()];
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(classPath);
            fileInputStream.read(classBytes, 0, classBytes.length);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 读取字节码到数组
        return classBytes;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        JavacCompiler javacCompiler = new JavacCompiler();
        CompileResult result = javacCompiler.compile(new StringBuilder("import java.util.*;public class JavaScriptModel{public static void main(String[] arg){System.out.println(\"aaa\");}}"));
        System.out.println("debug");
        System.out.println(System.currentTimeMillis() - startTime);
    }

}
