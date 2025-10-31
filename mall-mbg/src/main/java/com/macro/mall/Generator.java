package com.macro.mall;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Used to generate code via MyBatis Generator (MBG)
 * Created by macro on 2018/4/26.
 */
public class Generator {
    public static void main(String[] args) throws Exception {
        // Warnings during MBG execution
        List<String> warnings = new ArrayList<String>();
        // Overwrite existing code when duplicates are generated
        boolean overwrite = true;
        // Read MBG configuration file
        InputStream is = Generator.class.getResourceAsStream("/generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(is);
        is.close();

        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        // Create MBG instance
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        // Execute code generation
        myBatisGenerator.generate(null);
        // Output warning messages
        for (String warning : warnings) {
            System.out.println(warning);
        }
    }
}
