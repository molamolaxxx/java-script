package com.mola.code;

public interface IChecker {

    /**
     * 检查指令是否符合标准（可扩展责任链）
     * 1、是否是分号结尾
     * 2、括号是否匹配
     * @param instruction 指令
     * @return
     */
    boolean check(String instruction);
}
