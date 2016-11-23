package com.jd.matchagenttest.domains;

import com.jd.matchagenttest.utils.TimeUtils;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

/**
 * Created by weijiang
 * Date: 2016/11/23
 * Desc:
 */
public class AgentRequestContentTest {

    @Test
    public void testAgentRequestContent2Xml() {
        Loto loto = new Loto();
        loto.setLotoId("301");
        loto.setIssue("");

        RequestBody requestBody = new RequestBody();
        requestBody.setLoto(loto);

        RequestHead requestHead = new RequestHead();
        requestHead.setAgentId("1021");
        requestHead.setCmd("2000");
        requestHead.setMd("sdfsdfsdfsdfsdfsd");
        requestHead.setTimeStamp(TimeUtils.getCurrentTimeStamp());
        //requestHead.setRequestBody(requestBody);

        AgentRequestContent agentRequestContent = new AgentRequestContent();
        agentRequestContent.setId(TimeUtils.getCurrentTimeStamp());
        agentRequestContent.setRequestHead(requestHead);
        agentRequestContent.setRequestBody(requestBody);

        File file = new File("D:\\agentRequestContent.xml");
        try {
            JAXBContext context = JAXBContext.newInstance(AgentRequestContent.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);
            marshaller.marshal(agentRequestContent, file);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
