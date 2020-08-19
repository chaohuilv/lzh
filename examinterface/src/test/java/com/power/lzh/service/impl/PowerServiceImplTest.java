package com.power.lzh.service.impl;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


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
        JaxWsDynamicClientFactory dcflient=JaxWsDynamicClientFactory.newInstance();
        Client client=dcflient.createClient("http://39.104.86.43:6702/webservice/powerService?wsdl");
        try{
            Object[] objects=client.invoke("GetPosition","2020-03-18",1,10);
            System.out.println("GetPosition 调用结果："+objects[0].toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    void getUser() {
        JaxWsDynamicClientFactory dcflient=JaxWsDynamicClientFactory.newInstance();
        //Client client=dcflient.createClient("http://39.104.86.43:6702/webservice/powerService?wsdl");
        Client client=dcflient.createClient("http://127.0.0.1:6702/webservice/powerService?wsdl");
        try{
            Object[] objects=client.invoke("GetUser","2020-03-18",1,10);
            System.out.println("getUser 调用结果："+objects[0].toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}