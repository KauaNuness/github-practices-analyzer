package com.kauanunes.github_practices_analyzer.controller;

import com.kauanunes.github_practices_analyzer.application.AnalysisApplicationService;
import com.kauanunes.github_practices_analyzer.domain.model.AnalysisReport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/analysis")
public class AnalysisController {

    private final AnalysisApplicationService analysisService;

    public AnalysisController(AnalysisApplicationService analysisService) {
        this.analysisService = analysisService;
    }

    @GetMapping("/{username}")
    public AnalysisReport analyze(@PathVariable String username) {
        return analysisService.analyze(username);
    }
}
