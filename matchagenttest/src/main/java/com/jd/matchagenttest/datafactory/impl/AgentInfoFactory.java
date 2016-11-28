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
                    for (Object key : properties.keySet()) {
                        Object val = properties.get(key);
                        String k = (String) key;
                        String ks = k.split("\\.")[1];

                        if (methodName.contains(ks)) {
                            if (ks.equals("id") || ks.equals("lotteryid") || ks.equals("agentid") || ks.equals("agenttype")
                                    || ks.equals("agentpriority")) {
                                method.invoke(object, Integer.valueOf((String) val));

                            } else {
                                method.invoke(object, val);
                            }

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
