package kz.halykacademy.httprequest;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class HttpReq {
    public static void main(String[] args) {
        System.out.println("Enter the name:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        String message = String.format("""
                {"name":"%s", "salary":"1000000", "age":23}
                """, name);
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
