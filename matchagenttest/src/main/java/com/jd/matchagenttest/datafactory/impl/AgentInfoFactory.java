package com.jd.matchagenttest.datafactory.impl;

import com.jd.matchagenttest.datafactory.DataBeanFactory;
import com.jd.matchagenttest.domains.AgentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * Created by weijiang
 * Date: 2016/11/28
 * Desc: 生产代理商信息的工厂
 */
public class AgentInfoFactory implements DataBeanFactory {



    public Object produceData(Object obj, Class aClass) {
        try {
            Object object = aClass.newInstance();
            Properties properties = (Properties) obj;
            Method[] methods = aClass.getDeclaredMethods();
            for (Method method : methods) {
                String methodName = method.getName().toLowerCase();

                if (methodName.substring(0, 3).equals("set")) {
                    String parameterType = (method.getParameterTypes())[0].getName();
                    for (Object key : properties.keySet()) {
                         Object val = properties.get(key);
                         String k = (String) key;
                         String ks = k.split("\\.")[1];

                        if (methodName.substring(3).equals(ks)) {
                            if(parameterType.equals("java.lang.String")) {
                                method.invoke(object, val);
                            }else if(parameterType.equals("java.lang.Integer") || parameterType.equals("int")) {
                                method.invoke(object, Integer.valueOf((String) val));
                            }
                            break;
                        }
                    }

                }
            }

            return object;

        }catch (Exception e) {
            System.out.println("析构AgentInfo的工厂方法出错："+ e.getMessage());
        }
        return null;
    }


}
