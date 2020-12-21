package com.power.lzh.service.impl;

import com.kinggrid.kgcore.enmu.KGServerTypeEnum;
import com.kinggrid.pdf.KGPdfHummer;
import com.kinggrid.pdf.executes.PdfSignature4KG;
import com.power.lzh.config.SigPDFConfig;
import com.power.lzh.service.SigPDFService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.time.LocalDateTime;

import static com.alibaba.fastjson.util.IOUtils.close;

@Service
@Slf4j
public class SigPDFServiceImpl implements SigPDFService {

    @Autowired
    private SigPDFConfig sigPDFConfig;

    /**
     * 根据文件路径，主键生成对应的签章附件
     * @param url
     * @param keyValue
     */
    @Override
    public void getSigPDF(String url, String keyValue) {

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        KGPdfHummer hummer = null;
        //FileOutputStream  fileOutputStream = null;
        FileInputStream cert = null;
        FileInputStream fileInputStream = null;
        try {
            cert = new FileInputStream("src/main/resources/pfx/sign.pfx");
            //fileOutputStream = new FileOutputStream("D:/temp/亳州_new.pdf"); //盖章之后的文档保存路径
            fileInputStream = new FileInputStream(url);
            hummer = KGPdfHummer.createSignature(fileInputStream, null,
                    bos, null,true);			//需要盖章的文档路径
            hummer.setCertificate(cert, "123456", "123456");
            //参数说明：
            //1、签章服务器地址
            //2、签章服务器版本
            //3、KEY的序列号
            //4、直接传空
            //5、印章名称
            PdfSignature4KG pdfElectronicSeal4KG = new PdfSignature4KG(
                    sigPDFConfig.getUrl(), KGServerTypeEnum.CA3,
                    sigPDFConfig.getKey(),sigPDFConfig.getPassword(),"测试章");
            //pdfElectronicSeal4KG.setXY(200, 200);			//坐标定位

            pdfElectronicSeal4KG.setText("111");          //文字定位
            hummer.setPdfSignature(pdfElectronicSeal4KG);
            hummer.doSignature();
        } catch (Exception e) {
            log.error(LocalDateTime.now()+"【根据文件路径，主键生成对应的签章附件】Exception={}",e);
            e.printStackTrace();
        }  finally {
            close(cert);
            close(fileInputStream);
            try {
                bos.writeTo(new FileOutputStream(url));
                //关闭文件流
                cert.close();
                fileInputStream.close();
            } catch (FileNotFoundException e) {
                log.error(LocalDateTime.now()+"【根据文件路径，主键生成对应的签章附件】FileNotFoundException={}",e);
                e.printStackTrace();
            } catch (IOException e) {
                log.error(LocalDateTime.now()+"【根据文件路径，主键生成对应的签章附件】IOException={}",e);
                e.printStackTrace();
            }finally {
                try {
                    if(bos != null) {
                        bos.close();
                    }
                } catch (IOException e) {
                    log.error(LocalDateTime.now()+"【根据文件路径，主键生成对应的签章附件】bosIOException={}",e);
                    e.printStackTrace();
                }
            }
        }
    }
}
