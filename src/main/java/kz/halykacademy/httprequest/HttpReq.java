package kz.halykacademy.httprequest;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpReq {
    public static void main(String[] args) {
        String message = """
                {"name":"John","salary":1000000,"age":"23"}
                """;

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest httpRequest = HttpRequest.newBuilder(URI.create("https://dummy.restapiexample.com/api/v1/create"))
                .POST(HttpRequest.BodyPublishers.ofString(message))
                .header("Content-type", "application/json")
                .build();

        HttpResponse<String> httpResponse;

        try {
            httpResponse = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String entity = httpResponse.body();
        System.out.println(entity);
    }
}
