package com.mola.session;

import com.mola.context.GlobalContext;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : molamola
 * @Project: java-script
 * @Description:
 * @date : 2020-12-20 02:52
 **/
public class SessionFactory {

    private GlobalContext globalContext;

    private Map<String, CodeSession> sessionCache = new ConcurrentHashMap<>(32);

    public SessionFactory(GlobalContext globalContext) {
        this.globalContext = globalContext;
    }

    public CodeSession create() {
        CodeSession codeSession = new CodeSession(this.globalContext);
        return codeSession;
    }
}
