package com.omisoft.vitafu.themoviedbapi.tools;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;


public class HttpClientProxy implements UrlReader {

    private HttpClient httpClient = HttpClients.createDefault();


    public HttpClientProxy(HttpClient httpClient) {
        this.httpClient = httpClient;
    }


    @Override
    public String request(URL url, String jsonBody, RequestMethod requestMethod) {


        // todo implement json body support
        // todo implement request method support

        if (httpClient != null) {
            try {
                HttpGet httpGet = new HttpGet(url.toURI());
                httpGet.addHeader("accept", "application/json");
                HttpResponse response = httpClient.execute(httpGet);

                if (response.getStatusLine().getStatusCode() == 200) {
                    HttpEntity entity1 = response.getEntity();

                    String responseJSON = EntityUtils.toString(entity1);

                    return responseJSON;
                } else return "";
            } catch (URISyntaxException ex) {
                throw new MovieDbException(MovieDbExceptionType.CONNECTION_ERROR, null, ex);
            } catch (IOException ex) {
                throw new MovieDbException(MovieDbExceptionType.CONNECTION_ERROR, null, ex);
            } catch (RuntimeException ex) {
                throw new MovieDbException(MovieDbExceptionType.HTTP_503_ERROR, "Service Unavailable", ex);
            }
        }

        return null;
    }
}
