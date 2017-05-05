package com.wd.until;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Properties;

/**
 * Created by aaa on 2017/4/17.
 */
public class getPropertieFile {

    public static Properties getProperties() {
        Properties prop = new Properties();
        try {
            prop.load(new InputStreamReader(Objects.class.getResourceAsStream("/application.properties"), "UTF-8"));
            return prop;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
