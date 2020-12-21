package com.power.lzh.service.impl;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import com.KGitextpdf.text.BaseColor;
import com.KGitextpdf.text.Rectangle;
import com.KGitextpdf.text.pdf.BaseFont;
import com.kinggrid.kgcore.enmu.KGQueryByEnum;
import com.kinggrid.kgcore.enmu.KGServerTypeEnum;
import com.kinggrid.pdf.KGPdfHummer;
import com.kinggrid.pdf.KGPdfHummerUtils;
import com.kinggrid.pdf.executes.PdfElectronicSeal4KG;
import com.kinggrid.pdf.executes.PdfElectronicSealDetails;
import com.kinggrid.pdf.executes.PdfElectronicSealDetails.Signinfo;
import com.kinggrid.pdf.executes.PdfSignature4KG;
import com.kinggrid.pdf.executes.PdfWatermark;
import com.kinggrid.pdf.exporter.KGPdfExporter;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PdfTest {

    /*public static void main(String ages[])
    {
        sign1();		//从签章服务器获取印章盖章
        //XML2PDF();
        //testElectronicSealDetails();
    }*/

    //对接签章服务器
    @Test
    public  void sign1()
    {
        KGPdfHummer hummer = null;
        FileOutputStream  fileOutputStream = null;
        FileInputStream cert = null;
        try {
            cert = new FileInputStream("src/main/resources/pfx/sign.pfx");
            fileOutputStream = new FileOutputStream("D:/桌面/测试2.pdf"); //盖章之后的文档保存路径
            hummer = KGPdfHummer.createSignature("D:/桌面/测试.pdf", null,
                    true, fileOutputStream, new File("D:/桌面/"),true);			//需要盖章的文档路径
            hummer.setCertificate(cert, "123456", "123456");
            //参数说明：
            //1、签章服务器地址
            //2、签章服务器版本
            //3、KEY的序列号
            //4、直接传空
            //5、印章名称
            PdfSignature4KG pdfElectronicSeal4KG = new PdfSignature4KG(
                    "http://sign.kinggrid.com:80/iSignatureServer/OfficeServer.jsp",KGServerTypeEnum.CA3,
                    "T001","123456","测试章");
            pdfElectronicSeal4KG.setXY(200, 200);			//坐标定位

            //pdfElectronicSeal4KG.setText("定位文字");          //文字定位
            hummer.setPdfSignature(pdfElectronicSeal4KG);
            hummer.doSignature();

        } catch (Exception e) {
            e.printStackTrace();
        }  finally {
            try{
                fileOutputStream.close();
                if(hummer != null) hummer.close();
            }catch (IOException e) {

            }
        }
    }

    public static void XML2PDF(){
        KGPdfExporter pdfExporter = KGPdfExporter.getInstance();
        // String content = ""; // 模板内容
        //pdfExporter. loadObject (content);
        try {
            pdfExporter.loadObjectFromFile("D:/temp/OFD转换演示/PdfTemplates.xml");
            pdfExporter.export(new FileOutputStream("d:/temp/OFD转换演示/templates.pdf"));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void testElectronicSealDetails(){
        KGPdfHummer hummer = null;
        try {
            hummer = KGPdfHummer.createInstance("D:/桌面/测试.pdf", null, true);

            PdfElectronicSealDetails pdfElectronicSealDetails =
                    new PdfElectronicSealDetails();
            hummer.addExecute(pdfElectronicSealDetails);
            hummer.doExecute();

            List<Signinfo> signinfos = pdfElectronicSealDetails.getSeals();
            for(Signinfo signinfo : signinfos){
                System.out.println(signinfo.getIndex());
                System.out.println(signinfo.getKeySn());
                System.out.println(signinfo.getUserName());
                System.out.println(signinfo.getCompName());
                System.out.println(signinfo.getSignSn());
                System.out.println(signinfo.getSignName());
                System.out.println(signinfo.getSignTime());

                System.out.println("左下角：" + signinfo.getRect().getLeft() + " " +
                        signinfo.getRect().getBottom() +

                        "右上角："+ signinfo.getRect().getRight() + " "+
                        signinfo.getRect().getTop());
                // true 为篡改，false 为未篡改
                System.out.println(signinfo.isTamper());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }  finally {
            if(hummer != null) hummer.close();
        }
    }
}
