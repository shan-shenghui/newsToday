package com.wd.untils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by aaa on 2017/4/11.
 */
public class Configuration {
    private static final Log log = LogFactory.getLog(Configuration.class);
    private Map<String, String> props;
    public static Configuration c = null;

    public Configuration(String configFile) {
        InputStream is = getClass().getResourceAsStream(configFile);
        try {
            this.props = new HashMap<String, String>();
            FileUtil.readToMap(props, is, "utf-8");
            is.close();
        } catch (IOException e) {
            if (log.isErrorEnabled()) {
                log.error("no file: " + configFile + " -->" + e.getMessage(), e);
            }
        }
    }

    public String getProperty(String key) {
        return (String) this.props.get(key);
    }

    public static Configuration getInstance() {
        if (c == null) {
            c = new Configuration("/application.properties");
        }

        return c;
    }
}
