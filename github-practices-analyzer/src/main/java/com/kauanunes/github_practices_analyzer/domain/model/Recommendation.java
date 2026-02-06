package com.kauanunes.github_practices_analyzer.domain.model;

public class Recommendation {

    private final String title;
    private final String context;
    private final String suggestion;

    public Recommendation(String title, String context, String suggestion) {
        this.title = title;
        this.context = context;
        this.suggestion = suggestion;
    }

    public String getTitle() {
        return title;
    }

    public String getContext() {
        return context;
    }

    public String getSuggestion() {
        return suggestion;
    }
}
