package com.advanced.scriptEngine;

import org.junit.jupiter.api.Test;

import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import java.util.List;

/**
 * 脚本引擎
 * oracle JDK中以往都包含一个JavaScript引擎， 但是在Java 15中被移除了。
 *
 * @author 朱俊伟
 * @since 2024/06/29 19:33
 */
public class ScriptEngineManagerTest {

    /**
     * getEngine 找到可用得脚本引擎
     */
    @Test
    public void getEngineTest() {
        ScriptEngineManager engineManager = new ScriptEngineManager();
        List<ScriptEngineFactory> engineFactories = engineManager.getEngineFactories();
        engineFactories.forEach(engineFactory -> {
            System.out.println("engineFactory.getEngineName() = " + engineFactory.getEngineName());
            System.out.println("engineFactory.getEngineVersion() = " + engineFactory.getEngineVersion());
            System.out.println("engineFactory.getLanguageName() = " + engineFactory.getLanguageName());
            System.out.println("engineFactory.getLanguageVersion() = " + engineFactory.getLanguageVersion());
            System.out.println("engineFactory.getExtensions() = " + engineFactory.getExtensions());
        });
    }
}
