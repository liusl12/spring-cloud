package com.liusl.jobmaker;

import com.liusl.configuration.JenkinsBaseInfo;
import org.apache.commons.httpclient.methods.FileRequestEntity;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;

/**
 * created by l1 on 2018/1/12.
 */
public class JobManagement implements JenkinsBaseInfo{
    public String createJobByName(String jobName) throws IOException {
        // 创建HttpClientBuilder
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        BasicHttpContext context = new BasicHttpContext();
        // 设置BasicAuth
        CredentialsProvider provider = new BasicCredentialsProvider();
        // Create the authentication scope
        AuthScope scope = new AuthScope(AuthScope.ANY_HOST, AuthScope.ANY_PORT, AuthScope.ANY_REALM);
        //设置用户名密码
        UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(USERNAME, PASSWORD);
        //认证
        provider.setCredentials(scope,credentials);
        httpClientBuilder.setDefaultCredentialsProvider(provider);
        CloseableHttpClient httpclient = httpClientBuilder.build();
        HttpPost post = new HttpPost("http://10.99.246.99:8080/jenkins/"+"createItem?name="+jobName);
        File fileInput = new File("src/main/resources/static/config/config.xml");
//        FileRequestEntity requestEntity = new FileRequestEntity(fileInput,"text/xml; charset=UTF-8");
        //创建mEntityBuilder
        MultipartEntityBuilder mEntityBuilder = MultipartEntityBuilder.create();
        //添加文件
        mEntityBuilder.addBinaryBody("file", fileInput);
        post.setHeader("Content-Type","application/xml");
        post.setEntity(mEntityBuilder.build());
        HttpResponse httpResponse = httpclient.execute(post);
        HttpEntity entity = httpResponse.getEntity();
        return EntityUtils.toString(entity);
    }
}
