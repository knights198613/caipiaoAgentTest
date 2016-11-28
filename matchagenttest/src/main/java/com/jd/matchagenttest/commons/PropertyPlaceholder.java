package com.jd.matchagenttest.commons;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.HashMap;
import java.util.Properties;

/**
 * Created by weijiang
 * Date: 2016/11/28
 * Desc: 重写spring的PropertyPlaceholderConfigurer方便代码中获取properties
 */
public class PropertyPlaceholder extends PropertyPlaceholderConfigurer{

    Properties properties;
    static HashMap<String, Object> propMap = new HashMap<String, Object>();

    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props) throws BeansException {
        super.processProperties(beanFactoryToProcess, props);
        properties = props;
        for( Object key : props.keySet()) {
            String k = key.toString();
            propMap.put(k, props.get(key));
        }
    }


    public static Object getPropertieValue(String key) {
        return propMap.get(key);
    }

    public Properties getProperties() {
        return properties;
    }

    @Override
    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
