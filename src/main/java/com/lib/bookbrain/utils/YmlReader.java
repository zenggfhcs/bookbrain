package com.lib.bookbrain.utils;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.ClassPathResource;

import java.util.Properties;

public class YmlReader {
YamlPropertiesFactoryBean yamlFactory;
Properties yamlProperties;

private YmlReader(String yaml) {
   yamlFactory = new YamlPropertiesFactoryBean();
   yamlFactory.setResources(new ClassPathResource(yaml)); // 指定YAML文件路径
   yamlProperties = yamlFactory.getObject(); // 加载YAML文件并转换为Properties对象
}

public static YmlReader generate(String yaml) {
   return new YmlReader(yaml);
}

public static void main(String[] args) {
   YmlReader ymlReader = new YmlReader("application.yml");
   System.out.println(ymlReader.reader("server.port"));
}

public String reader(String property) {
   return yamlProperties.getProperty(property);
}
}
