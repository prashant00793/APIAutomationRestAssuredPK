package com.apiautomationpk.utils;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

public class YAMLReaderUtil {

    public Map<String, Object> readkey() {
        Yaml yaml = new Yaml();
        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream("src/main/java/com/apiautomationpk/resource/TestDataYaml.yaml");
        Map<String, Object> obj = yaml.load(inputStream);
        return obj;
    }
}

