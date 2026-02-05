package com.kauanunes.github_practices_analyzer.infrastructure.github;

import com.kauanunes.github_practices_analyzer.infrastructure.github.dto.GitHubRepoDto;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Component
public class GitHubClient {

    private final WebClient webClient;

    public GitHubClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public Flux<GitHubRepoDto> getRepositories(String username) {
        return webClient.get()
                .uri("/users/{username}/repos?per_page=100", username)
                .retrieve()
                .bodyToFlux(GitHubRepoDto.class);
    }
}
