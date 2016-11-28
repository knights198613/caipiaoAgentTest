package com.jd.matchagenttest.datafactory;

/**
 * Created by weijiang
 * Date: 2016/11/28
 * Desc: 生产不同实体的工厂
 */
public interface DataBeanFactory <T extends Object> {

    /**
     * 生产数据的方法
     * @param obj
     * @param tClass
     * @return
     */
    public T produceData(Object obj, Class<T> tClass);
}
