package com.tardisgallifrey;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class DatabaseConfig {

    public static HashMap<String, String> DatabaseConfig(String propfile) throws IOException {
        HashMap<String, String> props = new HashMap<>();

        FileReader reader = new FileReader(propfile);
        Properties p = new Properties();
        p.load(reader);

        props.put("db.url", p.getProperty("db.url"));
        props.put("db.username", p.getProperty("db.username"));
        props.put("db.password", p.getProperty("db.password"));

        return props;

    }
}
