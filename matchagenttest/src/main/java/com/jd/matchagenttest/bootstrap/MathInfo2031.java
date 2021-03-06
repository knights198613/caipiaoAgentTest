package com.jd.matchagenttest.bootstrap;

import com.jd.matchagenttest.commons.AgentRequestContent2Xml;
import com.jd.matchagenttest.commons.PropertyPlaceholder;
import com.jd.matchagenttest.datafactory.impl.AgentInfoFactory;
import com.jd.matchagenttest.domains.AgentInfo;
import com.jd.matchagenttest.domains.ResponseResult;
import com.jd.matchagenttest.utils.AgentRequestNewUtils;
import com.jd.matchagenttest.utils.AgentRequestUtils;
import com.jd.matchagenttest.utils.MD5Utils;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Properties;

/**
 * Created by weijiang
 * Date: 2016/11/28
 * Desc: 2031接口启动类
 */
public class MathInfo2031 {
    Logger logger = Logger.getLogger(MathInfo2031.class);

    ApplicationContext applicationContext;
    final static String SPRING_CONF_XML_PATH = "classpath:spring.xml";
    //代理商接口标示
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
        String requestContent = xmlStrArray[0]+mdStr+xmlStrArray[1];
        logger.info("发送请求代理商内容为:"+requestContent);

        //请求代理商获取代理商返回消息体
        //ResponseResult result = AgentRequestUtils.requestAgent(agentInfo, requestContent);
        //请求代理商接口返回消息体的新版httpClient工具类方法
        ResponseResult result = AgentRequestNewUtils.requestAgent(agentInfo, requestContent);
        System.out.println("代理商返回结果:statusCode:"+result.getStatusCode()+",对阵信息："+result.getResultStr());

    }
}
