package com.jd.matchagenttest.datafactory;

import com.jd.matchagenttest.commons.PropertyPlaceholder;
import com.jd.matchagenttest.datafactory.impl.AgentInfoFactory;
import com.jd.matchagenttest.domains.AgentInfo;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by weijiang
 * Date: 2016/11/28
 * Desc:
 */
public class AgentInfoFactoryTest {

    ApplicationContext applicationContext;

    @Before
    public void before() {
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
    }
    @Test
    public void testProduceData() {
        PropertyPlaceholder placeholder = (PropertyPlaceholder) applicationContext.getBean("propertyPlaceholder");
        AgentInfoFactory factory = (AgentInfoFactory)applicationContext.getBean("agentInfoFactory");
        Properties prop = null;

        prop = placeholder.getProperties();


        AgentInfo agentInfo = (AgentInfo) factory.produceData(prop, AgentInfo.class);
        System.out.println("返回的结果为："+ agentInfo.toString());
    }

}
