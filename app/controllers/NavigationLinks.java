package controllers;

/**
 * Created by dido on 11/4/14.
 */
public class NavigationLinks {
    private String href;
    private String text;

    NavigationLinks(String href, String text) {
        this.href = href;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}
