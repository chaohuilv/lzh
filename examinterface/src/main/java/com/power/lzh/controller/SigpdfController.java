package com.power.lzh.controller;

import com.alibaba.fastjson.JSON;
import com.kinggrid.pdfviewer.PdfViewer;
import com.power.lzh.config.ProjectConfig;
import com.power.lzh.entity.DocFiles;
import com.power.lzh.entity.Human;
import com.power.lzh.service.impl.DocFilesServiceImpl;
import com.power.lzh.service.impl.SigPDFServiceImpl;
import com.power.lzh.utils.ResultVOUtil;
import com.power.lzh.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.SneakyThrows;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/pdf")
@Api("金格Pdf签章API")
//@CrossOrigin
//@CrossOrigin("http://127.0.0.1:6702") // 只有指定域名可以访问该类下所有接口
public class SigpdfController {

    @Autowired
    private SigPDFServiceImpl sigPDFService;

    @Autowired
    private DocFilesServiceImpl docFilesService;

    @Autowired
    private ProjectConfig projectConfig;


    /**
     * 根据路径，主键生成对应的签章信息
     * @param url 路径
     * @param keyValue 主键
     * @return
     */
    @PostMapping("/sigPdf")
    @ResponseBody
    @ApiOperation(value = "自动生成签章", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name="url",value="附件路径",required=true,paramType="form",dataType="String"),
            @ApiImplicitParam(name="keyValue",value="附件唯一编号",required=true,paramType="query",dataType="String")
    })
    public ResultVO getSigPDF(@RequestParam(value = "url") String url,
                              @RequestParam(value = "keyValue",defaultValue = "") String keyValue){
        sigPDFService.getSigPDF(url,keyValue);
        return ResultVOUtil.success();
    }

    @SneakyThrows
    @PostMapping("/MyPdfServlet")
    @ResponseBody
    public ResultVO MyPdfServlet(HttpServletRequest request, HttpServletResponse response){
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        try {
            PdfViewer.execute(request, response);
        } catch (Throwable e) {
            // 记录日志
            e.printStackTrace();
            String contentType = request.getContentType();
            if("application/json".equals(contentType)){
                return ResultVOUtil.error(201,"程序异常，请联系管理员！");
            }
        }
        return ResultVOUtil.success();
    }

    /**
     * 根据附件唯一编号手动盖章
     * @param id 附件id
     * @return
     */
    @PostMapping("/stamp")
    @ResponseBody
    @ApiOperation(value = "手动盖章", notes = "根据附件唯一编号手动盖章")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value="附件唯一id",required=true,paramType="query",dataType="String")
    })
    public ResultVO stamp(@RequestParam(value = "id") String id) {
        DocFiles docFiles = docFilesService.findById(id);
        if(docFiles.getFileext().equals(".pdf")){
            return ResultVOUtil.success(projectConfig.getUrl()+"/pdfjs/viewer.html?files="+projectConfig.getFtpUrl()+docFiles.getServerurl());
        }else{

            return ResultVOUtil.error(201,"当前附件格式不对，要求附件格式为pdf");
        }

        /*if(docFiles.getFileext().equals(".pdf")){
            return "redirect:" + projectConfig.getUrl()+"/pdfjs/viewer.html?files="+
                    projectConfig.getFtpUrl()+docFiles.getServerurl();
        }else{
            JSONObject json = new JSONObject();
            json.put("code", "201");
            json.put("msg", "当前不上pdf格式");
            return JSON.toJSONString(json);
        }*/
    }
}
