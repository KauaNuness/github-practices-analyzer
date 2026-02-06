package com.kauanunes.github_practices_analyzer.shared;

public class SimpleItem {

    private final String title;
    private final String context;

    public SimpleItem(String title, String context) {
        this.title = title;
        this.context = context;
    }

    public String getTitle() {
        return title;
    }

    public String getContext() {
        return context;
    }
}
