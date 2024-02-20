package restcalls;

import helper.action.GlobalVarsHelper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class HTTPClientPost {
    private String content = "";
    private int responseCode;

    public HTTPClientPost(String endpoint, JSONObject jsonObject) throws IOException {
        HttpClient httpClient = HttpClientBuilder.create().useSystemProperties().build();
        HttpPost httpPost = new HttpPost(endpoint);
        StringEntity inputEntity = new StringEntity(jsonObject.toString());
        inputEntity.setContentType("application/json");
        httpPost.setEntity(inputEntity);
        httpPost.addHeader("Accept", "application/json");
        if (GlobalVarsHelper.getInstance().isUseAuthcode())
            httpPost.addHeader("Authorization", GlobalVarsHelper.getInstance().getResponseheaderAuthorisationCode());
        HttpResponse httpResponse = httpClient.execute(httpPost);
        //content= httpResponse.get;
        responseCode = httpResponse.getStatusLine().getStatusCode();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        httpResponse.getEntity().writeTo(out);
        content = out.toString();
        if (httpResponse.getStatusLine().getStatusCode() != 200) {
            //	System.out.println("Failed response" + httpResponse.getStatusLine().getStatusCode());
        }
        if (httpResponse.containsHeader("Authorization")) {
            GlobalVarsHelper.getInstance()
                    .setResponseheaderAuthorisationCode(httpResponse.getHeaders("Authorization")[0].getValue());
        }
    }

    public String getContent() {
        return content;
    }

    public int getResponseCode() {
        return responseCode;
    }

}
