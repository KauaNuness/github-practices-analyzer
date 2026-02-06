package com.kauanunes.github_practices_analyzer.controller;

import com.kauanunes.github_practices_analyzer.application.AnalysisApplicationService;
import com.kauanunes.github_practices_analyzer.domain.model.AnalysisReport;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/analysis")
@Tag(name = "GitHub Analysis", description = "Análise de boas práticas em perfis do GitHub")
public class AnalysisController {

    private final AnalysisApplicationService analysisService;

    public AnalysisController(AnalysisApplicationService analysisService) {
        this.analysisService = analysisService;
    }

    @GetMapping("/{username}")
    @Operation(
            summary = "Analisa um perfil do GitHub",
            description = "Gera um relatório de boas práticas baseado nos repositórios públicos do usuário"
    )
    public AnalysisReport analyze(
            @Parameter(
                    description = "Username do GitHub",
                    example = "torvalds"
            )
            @PathVariable String username
    ) {
        return analysisService.analyze(username);
    }
}
