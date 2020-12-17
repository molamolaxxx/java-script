package com.mola.compiler;

import com.mola.result.CompileResult;

public interface ICompiler {

    /**
     * 直接通过源代码进行编译
     * @param sourceCode 源代码
     * @return
     */
    CompileResult compile(StringBuilder sourceCode);

    /**
     * 基于源文件地址进行编译
     * @param sourcePath
     * @return
     */
    CompileResult compile(String sourcePath);
}
