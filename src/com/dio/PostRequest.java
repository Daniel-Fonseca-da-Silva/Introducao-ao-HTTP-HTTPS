package com.dio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.time.Duration;

public class PostRequest {

    public static final String URL = "https://httpbin.org/forms/post";
    public static final String FILE_JSON = "/home/matrix-buntu/Desktop/learn2022/bootcamp/http-example/pedido/pedido.json";

    public static void main(String[] args) throws IOException, InterruptedException {

        // Cliente HTTP
        HttpClient client = HttpClient.newHttpClient();

        // Cria requisição
        HttpRequest request = HttpRequest.newBuilder()
               // .POST(HttpRequest.BodyPublishers.ofFile(Path.of(FILE_JSON)))
                .timeout(Duration.ofSeconds(10))
                .uri(URI.create(URL))
                .build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();
    }


}
