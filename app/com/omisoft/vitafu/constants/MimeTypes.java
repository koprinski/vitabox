package com.omisoft.vitafu.constants;

/**
 * Holds constants for MIME types
 * Created by dido on 11/13/14.
 */
public enum MimeTypes {
    MP4("video/mp4"), OGGVIDEO("video/ogg"), WEBM("video/webm"), JSON("application/json");

    public String getType() {
        return type;
    }

    private String type;

    MimeTypes(String s) {
        type = s;
    }
}
