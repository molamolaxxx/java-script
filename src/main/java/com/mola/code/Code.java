package com.mola.code;

import com.mola.classloader.TempClassLoader;
import com.mola.session.CodeSession;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : molamola
 * @Project: java-script
 * @Description:
 * @date : 2020-12-20 03:01
 **/
@Data
@Slf4j
public class Code {

    private static final String PREFIX = "import java.util.*;public class "+ TempClassLoader.TEMP_CLASS_NAME
            +"{public static void main(String[] arg){";
    private static final String SUFFIX = "}}";

    private CodeSession session;

    public Code(CodeSession session, String className){
        this.session = session;
    }
    /**
     * 指令集合
     */
    private List<StringBuilder> instructions = new ArrayList<>();

    public String get() {
        StringBuilder result = new StringBuilder();
        result.append(PREFIX);
        IChecker checker = this.getSession().getGlobalContext().getChecker();
        for(StringBuilder line : instructions) {
            if (!checker.check(line.toString())) {
                log.error("解析错误！");
                return null;
            }
            result.append(line);
        }
        result.append(SUFFIX);
        return result.toString();
    }


}
