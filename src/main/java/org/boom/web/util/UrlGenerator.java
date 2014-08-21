package org.boom.web.util;

/**
 * Created by jiangshan on 14/8/21.
 */
public class UrlGenerator {
    private static String serverUrl;
    public void setServerUrl(String serverUrl){
        this.serverUrl = serverUrl;
    }

    public static final String getItemUrl(){
        return serverUrl + "/item/show";
    }
}
