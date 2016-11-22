package com.jd.matchagenttest.domains;

/**
 * Created by weijiang
 * Date: 2016/11/21
 * Desc: 请求代理商报文头
 */

public class AgentRequestHead {

    private String agentId;
    private String cmd;
    private String timeStamp;
    private String md;
    private RequestBody requestBody;

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMd() {
        return md;
    }

    public void setMd(String md) {
        this.md = md;
    }

    public RequestBody getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(RequestBody requestBody) {
        this.requestBody = requestBody;
    }
}



class RequestBody {
    private String lotoId;
    private String issue;

    public String getLotoId() {
        return lotoId;
    }

    public void setLotoId(String lotoId) {
        this.lotoId = lotoId;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }
}
