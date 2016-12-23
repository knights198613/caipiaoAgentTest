package com.jd.matchagenttest.utils;

import com.jd.matchagenttest.domains.AgentInfo;
import com.jd.matchagenttest.domains.ResponseResult;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;


/**
 * Created by weijiang
 * Date: 2016/11/21
 * Desc: 访问代理商接口的工具类
 */
public class AgentRequestUtils {

    public final static Logger logger = Logger.getLogger(AgentRequestUtils.class);

    /**等待建连的时间 2 分钟**/
    private static final int CONNECTION_TIMEOUT = 2 * 60 * 1000;
    /**socket等待数据的时间**/
    private static final int SOCKET_WAIT_TIMEOUT = 2 * 60 * 1000;
    /**socket接收数据的缓存**/
    private static final int SOCKET_RECEIVE_BUFFERSIZE = 5 * 1024 * 1024;

    private static final String CHAR_ENCODING = "UTF-8";


    public static ResponseResult requestAgent(AgentInfo agentInfo, String xmlStr) {
        String result = null;
        HttpClient httpClient = new HttpClient();
        httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(CONNECTION_TIMEOUT);
        httpClient.getHttpConnectionManager().getParams().setSoTimeout(SOCKET_WAIT_TIMEOUT);
        httpClient.getHttpConnectionManager().getParams().setReceiveBufferSize(SOCKET_RECEIVE_BUFFERSIZE);
        PostMethod postMethod = new PostMethod();
        postMethod.setPath(agentInfo.getAgentUrl());
        postMethod.getParams().setContentCharset(CHAR_ENCODING);
        postMethod.setRequestHeader("Cache-Control", "no-cache");
        postMethod.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset="+CHAR_ENCODING);
        try {
            postMethod.setRequestEntity(new StringRequestEntity(xmlStr, "text/xml; charset=" + CHAR_ENCODING, CHAR_ENCODING));
            httpClient.executeMethod(postMethod);
            result = postMethod.getResponseBodyAsString();
        }catch (Exception e) {
            logger.error("请求代理商接口出错,"+e.getMessage());
        }finally {
            postMethod.releaseConnection();
        }
        logger.info("请求返回的状态码为："+postMethod.getStatusCode()+ ", 请求返回的信息内容为："+result);
        ResponseResult responseResult = new ResponseResult();
        responseResult.setStatusCode(postMethod.getStatusCode());
        responseResult.setResultStr(result);
        return responseResult;
    }

}
