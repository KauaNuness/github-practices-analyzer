package com.kauanunes.github_practices_analyzer.infrastructure.github.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

public class GitHubRepoDto {

    private String name;
    private String description;

    @JsonProperty("updated_at")
    private Instant updatedAt;

    private boolean fork;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public boolean isFork() {
        return fork;
    }
}
