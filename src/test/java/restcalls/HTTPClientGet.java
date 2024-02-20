package restcalls;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HTTPClientGet {
    private HttpResponse httpResponse;
    private String responseOutput = "";
    private int responseCode;

    public HTTPClientGet(String endpoint) throws IOException {

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(endpoint);

        httpResponse = httpClient.execute(httpGet);

        responseCode = httpResponse.getStatusLine().getStatusCode();

        String output;

        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader((httpResponse.getEntity().getContent())));

        while ((output = bufferedReader.readLine()) != null) {
            responseOutput = responseOutput + output;
        }

    }

    public String getResponseOutput() {
        return responseOutput;
    }

    public HttpResponse getHttpResponse() {
        return httpResponse;
    }

    public int getResponseCode() {
        return responseCode;
    }

}
