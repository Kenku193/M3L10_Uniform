package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.http.*;

public class Old {
    public static void main(String[] args) {

        StringBuilder content = new StringBuilder();

        // Client side
        try {
            // Client
            HttpURLConnection connection = (HttpURLConnection) new URL("http://www.javarush.ru").openConnection();

            // Request
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(10000);

            // Response
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            // Content (HTML)
            while (bufferedReader.ready()){
                content.append(bufferedReader.readLine());
            }

            System.out.println(content);

            System.out.println(connection.getResponseMessage());

            connection.disconnect();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}