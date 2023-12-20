import java.net.http.HttpResponse;

@SuppressWarnings("ALL")
public class Main {
    public static void main(String[] args) {
        final RestClient restClient = new RestClient();

        try {
            // Example of using GET request
            final HttpResponse<String> getRep = restClient.sendGetRequest("https://jsonplaceholder.typicode.com/posts/1");
            System.out.println(String.format("GET Response: %s", getRep.body()));

            // Example of using POST request
            final String postBody = "{\"title\":\"test\",\"body\":\"hi\",\"code\":123}";
            final HttpResponse<String> postRep = restClient.sendPostRequest("https://jsonplaceholder.typicode.com/posts", postBody);
            System.out.println(String.format("POST Response: %s", postRep.body()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}