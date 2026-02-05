package com.kauanunes.github_practices_analyzer.infrastructure.github.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.Instant;

@Data
public class GitHubRepoDto {

    private String name;
    private String description;
    @JsonProperty("updated_at")
    private Instant updatedAt;
}
