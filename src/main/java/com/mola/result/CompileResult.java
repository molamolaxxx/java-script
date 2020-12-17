package com.mola.result;

import lombok.Data;

/**
 * @author : molamola
 * @Project: java-script
 * @Description:
 * @date : 2020-12-17 17:49
 **/
@Data
public class CompileResult {

    /**
     * 是否编译成功
     */
    private boolean isSuccess;

    /**
     * 成功编译后的字节码
     */
    private byte[] outputBytes;

    /**
     * class文件地址
     */
    private String classPath;

    /**
     * source文件地址
     */
    private String sourcePath;

    public CompileResult() {
    }

    public CompileResult(byte[] outputBytes, String classPath,
                         String sourcePath, boolean isSuccess) {
        this.outputBytes = outputBytes;
        this.classPath = classPath;
        this.sourcePath = sourcePath;
        this.isSuccess = isSuccess;
    }

    public static CompileResult failed() {
        CompileResult result = new CompileResult();
        result.setSuccess(false);
        return result;
    }

}
