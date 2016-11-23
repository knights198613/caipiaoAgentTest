package com.jd.matchagenttest.domains;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by weijiang
 * Date: 2016/11/21
 * Desc: 请求代理商报体
 */


@XmlRootElement(name="msg")
@XmlType(propOrder = {"requestHead", "requestBody"})
public class AgentRequestContent {

    private String v1 = "1.0";
    private String id;

    private RequestHead requestHead;

    private RequestBody requestBody;

    @XmlAttribute
    public String getV1() {
        return v1;
    }

    public void setV1(String v1) {
        this.v1 = v1;
    }

    @XmlAttribute
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @XmlElement(name = "ctrl")
    public RequestHead getRequestHead() {
        return requestHead;
    }

    public void setRequestHead(RequestHead requestHead) {
        this.requestHead = requestHead;
    }

    @XmlElement(name="body")
    public RequestBody getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(RequestBody requestBody) {
        this.requestBody = requestBody;
    }
}


class RequestHead {

    private String agentId;
    private String cmd;
    private String timeStamp;
    private String md;


    @XmlElement(name="agentID")
    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    @XmlElement(name="cmd")
    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    @XmlElement(name="timestamp")
    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    @XmlElement(name="md")
    public String getMd() {
        return md;
    }

    public void setMd(String md) {
        this.md = md;
    }


}


class RequestBody {
    private Loto loto;

    @XmlElement(name = "loto")
    public Loto getLoto() {
        return loto;
    }

    public void setLoto(Loto loto) {
        this.loto = loto;
    }
}

class Loto {
    private String lotoId;
    private String issue;

    @XmlAttribute(name = "lotoid")
    public String getLotoId() {
        return lotoId;
    }

    public void setLotoId(String lotoId) {
        this.lotoId = lotoId;
    }

    @XmlAttribute(name = "issue")
    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }
}
