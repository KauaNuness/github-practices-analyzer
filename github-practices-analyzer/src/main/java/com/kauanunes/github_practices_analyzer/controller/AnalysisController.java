package com.kauanunes.github_practices_analyzer.controller;

import com.kauanunes.github_practices_analyzer.application.AnalysisApplicationService;
import com.kauanunes.github_practices_analyzer.domain.model.AnalysisReport;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/analysis")
public class AnalysisController {

    private final AnalysisApplicationService analysisService;

    public AnalysisController(AnalysisApplicationService analysisService) {
        this.analysisService = analysisService;
    }

    @GetMapping("/{username}")
    public Mono<AnalysisReport> analyze(@PathVariable String username) {
        return analysisService.analyze(username);
    }
}
