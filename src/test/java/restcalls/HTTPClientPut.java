package restcalls;

import helper.action.GlobalVarsHelper;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;

import java.io.IOException;

public class HTTPClientPut {
    private String content = "";

    private int responseCode;

    public HttpResponse httpPutClient(String endpoint, JSONObject jsonObject) throws IOException {
        HttpClient httpClient = HttpClientBuilder.create().useSystemProperties().build();
        HttpPut httpPut = new HttpPut(endpoint);
        StringEntity inputEntity = new StringEntity(jsonObject.toString());
        inputEntity.setContentType("application/json");
        httpPut.setEntity(inputEntity);
        httpPut.addHeader("Accept", "application/json");
        if (GlobalVarsHelper.getInstance().isUseAuthcode())
            httpPut.addHeader("Authorization", GlobalVarsHelper.getInstance().getResponseheaderAuthorisationCode());
        HttpResponse httpResponse = httpClient.execute(httpPut);
        responseCode = httpResponse.getStatusLine().getStatusCode();
        //System.out.print("Response Code:" + responseCode);
        if (httpResponse.getStatusLine().getStatusCode() != 200) {
            //	System.out.println("Failed response" + httpResponse.getStatusLine().getStatusCode());
        }
        Header[] h = httpResponse.getAllHeaders();
        if (h[0].getName().contains("Auth")) {
            GlobalVarsHelper.getInstance().setResponseheaderAuthorisationCode(h[0].getValue());
        }
        return httpResponse;

    }

    public String getContent() {
        return content;
    }

    public int getResponseCode() {
        return responseCode;
    }

}
