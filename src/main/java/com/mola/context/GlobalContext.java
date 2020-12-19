package com.mola.context;

import com.mola.code.IChecker;
import com.mola.compiler.ICompiler;
import com.mola.compiler.JavacCompiler;
import com.mola.executor.IExecutor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author : molamola
 * @Project: java-script
 * @Description:
 * @date : 2020-12-17 18:02
 **/
@Slf4j
@Data
public class GlobalContext {

    /**
     * 编译器
     */
    private ICompiler compiler;

    /**
     * 执行器
     */
    private IExecutor executor;

    /**
     * 检查器
     */
    private IChecker checker;

    /**
     * init
     */
    private AtomicBoolean initFlag = new AtomicBoolean(false);

    public void init(){
        if (!initFlag.compareAndSet(false, true)) {
            return;
        }
        compiler = new JavacCompiler();
    }

}
