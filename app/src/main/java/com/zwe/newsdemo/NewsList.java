package com.zwe.newsdemo;

/**
 * Created by Asus on 2017/4/3.
 */

public class NewsList {
    private String newsUrl;
    private String url;
    private String time;
    private String title;
    public NewsList(String url,String time,String title,String newsUrl){
        this.url=url;
        this.time=time;
        this.title=title;
        this.newsUrl=newsUrl;
    }

    public void setNewsUrl(String newsUrl) {
        this.newsUrl = newsUrl;
    }

    public String getNewsUrl() {
        return newsUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
