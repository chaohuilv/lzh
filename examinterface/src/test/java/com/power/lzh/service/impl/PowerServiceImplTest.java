package com.power.lzh.service.impl;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PowerServiceImplTest {

    @Test
    void getDept() {
        JaxWsDynamicClientFactory dcflient=JaxWsDynamicClientFactory.newInstance();

        Client client=dcflient.createClient("http://39.104.86.43:6702/webservice/powerService?wsdl");
        try{
            Object[] objects=client.invoke("GetDept","2020-03-18",1,10);
            System.out.println("getDept 调用结果："+objects[0].toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    void getPosition() {
    }

    @Test
    void getUser() {
    }
}