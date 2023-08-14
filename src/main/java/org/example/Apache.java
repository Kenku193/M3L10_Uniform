package org.example;

import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Apache {
    public static void main(String[] args) throws IOException {

        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpGet request = new HttpGet("https://jsonplaceholder.typicode.com/albums/1");

        CloseableHttpResponse response = httpClient.execute(request);

        HttpEntity entity = response.getEntity();

        if (entity != null){

            String s = IOUtils.toString(entity.getContent(), StandardCharsets.UTF_8);

            System.out.println(s);

        }

        Header[] allHeaders = response.getAllHeaders();
        for (Header header : allHeaders) {
            System.out.println(header.getName() + " : " + header.getValue());
        }


    }
}
