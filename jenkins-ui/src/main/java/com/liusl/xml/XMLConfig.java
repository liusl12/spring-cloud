package com.liusl.xml;

import com.sun.org.apache.bcel.internal.util.ClassPath;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * created by l1 on 2018/1/11.
 */
public class XMLConfig {

    public static void copyXML() throws IOException {
        File source = new File("src/main/resources/static/config.xml");
        File dest = new File("src/main/resources/static/config/config_temp.xml");
        dest.delete();
        Files.copy(source.toPath(),dest.toPath());
    }
}
