package com.mola.session;

import com.mola.context.GlobalContext;
import lombok.Data;

import java.util.UUID;

/**
 * @author : molamola
 * @Project: java-script
 * @Description:
 * @date : 2020-12-20 02:50
 **/
@Data
public class CodeSession {

    /**
     * session唯一id
     */
    private String id = UUID.randomUUID().toString();

    /**
     * 保存上下文的code
     */
    private StringBuilder codeCache = new StringBuilder();

    /**
     * 全局上下文
     */
    private GlobalContext globalContext;

    public CodeSession(GlobalContext globalContext) {
        this.globalContext = globalContext;
    }

    private long createTime = System.currentTimeMillis();
}
