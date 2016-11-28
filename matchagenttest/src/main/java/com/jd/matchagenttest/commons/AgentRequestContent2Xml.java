package com.jd.matchagenttest.commons;

import com.jd.matchagenttest.domains.AgentInfo;
import com.jd.matchagenttest.domains.AgentRequestContent;
import com.jd.matchagenttest.utils.JAXBUtils;
import com.jd.matchagenttest.utils.TimeUtils;
import org.apache.commons.lang.StringUtils;

/**
 * Created by weijiang
 * Date: 2016/11/28
 * Desc: 形成请求代理商接口的请求报文
 */
public class AgentRequestContent2Xml {

    public static String reqeustContent2Xml(String cmd, AgentInfo agentInfo, String issue) {
        AgentRequestContent.Loto loto = new AgentRequestContent.Loto();
        if(StringUtils.isBlank(issue)) {
            loto.setIssue("");
        }else {
            loto.setIssue(issue);
        }
        loto.setLotoId(String.valueOf(agentInfo.getLotteryTypeId()));

        AgentRequestContent.RequestBody requestBody = new AgentRequestContent.RequestBody();
        requestBody.setLoto(loto);

        AgentRequestContent.RequestHead requestHead = new AgentRequestContent.RequestHead();
        requestHead.setAgentId(String.valueOf(agentInfo.getAgentId()));
        requestHead.setCmd(cmd);
        requestHead.setMd("#");
        requestHead.setTimeStamp(TimeUtils.getCurrentTimeStamp());

        AgentRequestContent agentRequestContent = new AgentRequestContent();
        agentRequestContent.setRequestBody(requestBody);
        agentRequestContent.setRequestHead(requestHead);
        agentRequestContent.setId(TimeUtils.getCurrentTimeStamp());
        //agentRequestContent.setV1("");
        return JAXBUtils.convertBean2Xml(AgentRequestContent.class, "UTF-8", agentRequestContent);
    }
}
