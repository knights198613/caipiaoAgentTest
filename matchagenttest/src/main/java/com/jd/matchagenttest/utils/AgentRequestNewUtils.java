package com.jd.matchagenttest.utils;

import com.jd.matchagenttest.domains.AgentInfo;
import com.jd.matchagenttest.domains.ResponseResult;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.SocketConfig;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import java.nio.charset.Charset;

/**
 * Created by weijiang
 * Date: 2016/12/22
 * Desc: 采用新版本的httpClient构造代理商
 *       请求工具类，新版比老版本在多线程上
 *       还是下了功夫优化了许多
 */
public class AgentRequestNewUtils {

    static Logger logger = Logger.getLogger(AgentRequestNewUtils.class);

    /**httpConnection连接的缓存**/
    private static final int CONNECTION_BUFFER_SIZE = 5 * 1024 * 1024;
    /**等待建连的时间 2 分钟**/
    private static final int SOCKET_TIMEOUT = 2 * 60 * 1000;
    /**socket等待数据的时间**/
    private static final int SOCKET_WAIT_TIMEOUT = 2 * 60 * 1000;
    /**socket接收数据的缓存**/
    private static final int SOCKET_RECEIVE_BUFFERSIZE = 5 * 1024 * 1024;
    /**socket发送数据的缓存**/
    private static final int SOCKET_SEND_BUFFERSIZE = 2 * 1024 * 1024;

    private static final String CHAR_ENCODING = "UTF-8";

    public static ResponseResult requestAgent(AgentInfo agentInfo, String xmlStr) {
        ResponseResult responseResult = new ResponseResult();
        SocketConfig socketConfig = SocketConfig.custom().setSoTimeout(SOCKET_TIMEOUT)
                .setRcvBufSize(SOCKET_RECEIVE_BUFFERSIZE).setSndBufSize(SOCKET_SEND_BUFFERSIZE).build();
        ConnectionConfig connectionConfig = ConnectionConfig.custom().setCharset(Charset.forName(CHAR_ENCODING))
                .setBufferSize(CONNECTION_BUFFER_SIZE).build();
        CloseableHttpClient closeableHttpClient = HttpClients.custom().setDefaultConnectionConfig(connectionConfig)
                .setDefaultSocketConfig(socketConfig).build();

        HttpPost post = new HttpPost(agentInfo.getAgentUrl());
        try {
            Header[] headers = new Header[2];
            headers[0] = new BasicHeader("Cache-Control", "no-cache");
            headers[1] = new BasicHeader("Content-Type", "application/x-www-form-urlencoded;charset="+CHAR_ENCODING);
            post.setHeaders(headers);
            HttpEntity entity = new StringEntity(xmlStr, ContentType.create("text/xml", CHAR_ENCODING));
            post.setEntity(entity);
            CloseableHttpResponse closeableHttpResponse = closeableHttpClient.execute(post);
            if(closeableHttpResponse != null) {
                HttpEntity httpEntity = closeableHttpResponse.getEntity();
                if(httpEntity != null) {
                    String result = EntityUtils.toString(httpEntity);
                    int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
                    responseResult.setResultStr(result);
                    responseResult.setStatusCode(statusCode);
                }
            }


        }catch(Exception e) {
            logger.error("请求代理商客户接口错误,"+ e.getMessage());
        }

        return responseResult;
    }

}
