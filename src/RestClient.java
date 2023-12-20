import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@SuppressWarnings("ALL")
public class RestClient {

    private final HttpClient httpClient;

    public RestClient() {
        this.httpClient = HttpClient.newHttpClient();
    }

    public HttpResponse<String> sendGetRequest(final String url) throws Exception {
        final HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .GET()
                .build();

        return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public HttpResponse<String> sendPostRequest(final String url, final String requestBody) throws Exception {
        final HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .header("Content-Type", "application/json") // Will implement a way to choose content type
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }

}
