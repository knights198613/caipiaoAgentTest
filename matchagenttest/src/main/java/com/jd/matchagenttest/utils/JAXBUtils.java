package com.jd.matchagenttest.utils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

/**
 * Created by weijiang
 * Date: 2016/11/28
 * Desc: 用于xml 2 bean or bean to xml
 */
public class JAXBUtils {

    public static final String DEFAULT_ENCODING = "utf-8";

    /**
     * Bean 2 xml 方法
     * @param clazz
     * @param encoding
     * @param obj
     * @return
     */
    public static String convertBean2Xml(Class clazz, String encoding, Object obj) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding == null ? DEFAULT_ENCODING : encoding);
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);
            StringWriter stringWriter = new StringWriter();
            marshaller.marshal(obj, stringWriter);
            //String result = null;
            //stringWriter.write(result);
            return stringWriter.toString();
        } catch (JAXBException e) {
            System.out.println("bean convert to xml异常,name:"+obj.getClass().getName());
        }

        return null;
    }
}
