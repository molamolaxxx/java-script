package com.mola.context;

import com.mola.compiler.ICompiler;
import com.mola.compiler.JavacCompiler;

/**
 * @author : molamola
 * @Project: java-script
 * @Description:
 * @date : 2020-12-17 18:02
 **/
public class GlobalContext {

    private ICompiler compiler;

    public void init(){
        compiler = new JavacCompiler();
    }

    public ICompiler getCompiler() {
        return compiler;
    }
}
