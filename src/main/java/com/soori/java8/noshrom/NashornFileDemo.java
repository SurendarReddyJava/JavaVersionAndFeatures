package com.soori.java8.noshrom;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileReader;
import java.io.IOException;

public class NashornFileDemo {
    public static void main(String[] args) {
    	ScriptEngineManager manager = new ScriptEngineManager();
    	ScriptEngine engine = manager.getEngineByName("nashorn");
    	if (engine == null) {
    	    System.err.println("Nashorn script engine not found.");
    	}


        try (FileReader reader = new FileReader("script.js")) {
            engine.eval(reader);
        } catch (ScriptException | IOException e) {
            e.printStackTrace();
        }
    }
}
