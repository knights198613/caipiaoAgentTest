package com.jd.matchagenttest.domains;

import java.util.Date;

/**
 * Created by weijiang
 * Date: 2016/11/21
 * Desc: 代理商信息
 */
public class AgentInfo {

    private int id;
    private int lotteryTypeId;
    private int agentId;
    private String agentName;
    private String agentUrl;
    private String agentUrl2;
    private int agentType;    /**1:主代理商  0：备代理商**/
    private int agentPriority;
    private String userName;
    private String token;
    private Date timeStamp;
    private Date created;
    private int yn;    /**0:删除   1：正常**/


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLotteryTypeId() {
        return lotteryTypeId;
    }

    public void setLotteryTypeId(int lotteryTypeId) {
        this.lotteryTypeId = lotteryTypeId;
    }

    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getAgentUrl() {
        return agentUrl;
    }

    public void setAgentUrl(String agentUrl) {
        this.agentUrl = agentUrl;
    }

    public String getAgentUrl2() {
        return agentUrl2;
    }

    public void setAgentUrl2(String agentUrl2) {
        this.agentUrl2 = agentUrl2;
    }

    public int getAgentType() {
        return agentType;
    }

    public void setAgentType(int agentType) {
        this.agentType = agentType;
    }

    public int getAgentPriority() {
        return agentPriority;
    }

    public void setAgentPriority(int agentPriority) {
        this.agentPriority = agentPriority;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getYn() {
        return yn;
    }

    public void setYn(int yn) {
        this.yn = yn;
    }


    @Override
    public String toString() {
        return "AgentInfo{" +
                "id=" + id +
                ", lotteryTypeId=" + lotteryTypeId +
                ", agentId=" + agentId +
                ", agentName='" + agentName + '\'' +
                ", agentUrl='" + agentUrl + '\'' +
                ", agentUrl2='" + agentUrl2 + '\'' +
                ", agentType=" + agentType +
                ", agentPriority=" + agentPriority +
                ", userName='" + userName + '\'' +
                ", token='" + token + '\'' +
                ", timeStamp=" + timeStamp +
                ", created=" + created +
                ", yn=" + yn +
                '}';
    }
}
