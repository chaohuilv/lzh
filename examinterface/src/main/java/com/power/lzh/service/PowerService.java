package com.power.lzh.service;

import com.power.lzh.vo.ResultVO;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * 对外的接口服务
 */
@WebService
public interface PowerService {

    //部门
    @WebMethod
    @WebResult(name = "String",targetNamespace = "")
    String GetDept(@WebParam(name = "update") String update , @WebParam(name = "page") Integer page, @WebParam(name = "size") Integer size);
    //岗位
    @WebMethod
    @WebResult(name = "String",targetNamespace = "")
    String GetPosition(@WebParam(name = "update") String update , @WebParam(name = "page") Integer page, @WebParam(name = "size") Integer size);
    //人员
    @WebMethod
    @WebResult(name = "String",targetNamespace = "")
    String GetUser(@WebParam(name = "update") String update , @WebParam(name = "page") Integer page, @WebParam(name = "size") Integer size);

}
