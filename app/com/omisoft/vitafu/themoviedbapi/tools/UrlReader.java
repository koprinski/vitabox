package com.omisoft.vitafu.themoviedbapi.tools;

import java.net.URL;


public interface UrlReader {

    String request(URL url, String jsonBody, RequestMethod requestMethod);
}
