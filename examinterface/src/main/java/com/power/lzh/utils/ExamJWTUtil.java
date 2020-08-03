package com.power.lzh.utils;

import com.power.lzh.config.ExamConfig;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

@Component
public class ExamJWTUtil {

    @Autowired
    private ExamConfig examConfig;

    /**
     * 获取jwt信息
     * @param actionId 请求类型
     * @return
     */
    public  String getJWTInfo(String actionId) {
        String jwtInfo = null;
        try {
            jwtInfo = Jwts.builder()
                    .setHeaderParam("alg", "HS256")
                    .setHeaderParam("typ", "JWT")
                    .claim("exp", System.currentTimeMillis() + 1000 * 10)
                    .claim("action_id", actionId)
                    .signWith(
                            SignatureAlgorithm.HS256,
                            examConfig.getAppKey().getBytes(StandardCharsets.UTF_8.toString())
                    )
                    .compact();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return jwtInfo;
    }

    /**
     * 发送Post请求
     * @param url
     * @param body
     * @return
     */
    public String sendPost(String url, String body) {
        String responseContent = null;
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(url);
            httpPost.addHeader("Content-Type", "application/json");
            httpPost.setEntity(new StringEntity(body, StandardCharsets.UTF_8.toString()));
            CloseableHttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            responseContent = EntityUtils.toString(entity, StandardCharsets.UTF_8.toString());
            response.close();
            httpClient.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseContent;
    }
}
