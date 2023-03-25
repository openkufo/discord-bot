package com.paulhan.discord;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class Test {
    public static void main(String[] args) throws IOException {
        // String protocol = "file:/";
        // String rootPath = System.getProperty("user.dir");
        // String propertiesPath = "/config/apikey.properties";


        // StringBuilder filePath = new StringBuilder(protocol)
        //                             .append(rootPath)
        //                             .append(propertiesPath);

        // URL propURL = new URL(filePath.toString());

        // Properties properties = new Properties();
        // properties.load(propURL.openStream());

        // System.out.println(properties.getProperty("TEST_TOKEN"));

        Properties properties = new Properties();
        String propFile = "apikey.properties";
        URL props = ClassLoader.getSystemResource(propFile);
        properties.load(props.openStream());
        System.out.println(properties.get("TEST_TOKEN"));

    }
}
