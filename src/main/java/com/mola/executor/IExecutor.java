package com.mola.executor;

import com.mola.result.ExecuteResult;

public interface IExecutor {

    /**
     * 编译并执行
     * @return
     */
    ExecuteResult execute();
}
