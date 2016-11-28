package com.jd.matchagenttest.bootstrap;

import com.jd.matchagenttest.commons.AgentRequestContent2Xml;
import com.jd.matchagenttest.commons.PropertyPlaceholder;
import com.jd.matchagenttest.datafactory.impl.AgentInfoFactory;
import com.jd.matchagenttest.domains.AgentInfo;
import com.jd.matchagenttest.utils.MD5Utils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Properties;

/**
 * Created by weijiang
 * Date: 2016/11/28
 * Desc: 2031接口启动类
 */
public class MathInfo2031 {
    ApplicationContext applicationContext;
    final static String SPRING_CONF_XML_PATH = "classpath:spring.xml";
    final static String AGENT_FLAG = "2031";
    public static void main(String[] args) {
        //this.doBootStrap(args);
        MathInfo2031 mathInfo2031 = new MathInfo2031();
        mathInfo2031.doBootStrap(args);
    }

    public void doBootStrap(String[] args) {
        applicationContext = new ClassPathXmlApplicationContext(SPRING_CONF_XML_PATH);
        PropertyPlaceholder placeholder = (PropertyPlaceholder) applicationContext.getBean("propertyPlaceholder");
        AgentInfoFactory factory = (AgentInfoFactory)applicationContext.getBean("agentInfoFactory");
        Properties prop = null;
        prop = placeholder.getProperties();
        AgentInfo agentInfo = (AgentInfo) factory.produceData(prop, AgentInfo.class);

        String xmlStr = AgentRequestContent2Xml.reqeustContent2Xml(AGENT_FLAG, agentInfo, "");
        String md5Content = agentInfo.getAgentId()+agentInfo.getToken()+
                xmlStr.substring(xmlStr.indexOf("<body>"), xmlStr.indexOf("</msg>"));
        String mdStr = MD5Utils.getMDHashStr(md5Content);

        String[] xmlStrArray = xmlStr.split("\\#");

        System.out.println(xmlStrArray[0]+mdStr+xmlStrArray[1]);
    }
}
