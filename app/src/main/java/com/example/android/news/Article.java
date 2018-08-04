package com.example.android.news;

/**
 * Created by agarw on 24-07-2018.
 */

public class Article {

    //stores the Title of the article
    private String mTitle;
    //stores the source of article
    //i.e. its publishing house
    private String mSource;
    //stores the date when article was uploaded
    private String mDate;
    //stores the URL for full article to official website
    private String mUrl;

    public Article(String title, String source, String date, String url) {
        mTitle = title;
        mSource = source;
        mDate = date;
        mUrl = url;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getSource() {
        return mSource;
    }

    public String getDate() {
        return mDate;
    }

    public String getUrl() {
        return mUrl;
    }
}
