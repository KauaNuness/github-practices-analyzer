package com.kauanunes.github_practices_analyzer.domain.heuristics;

import com.kauanunes.github_practices_analyzer.shared.AnalysisContext;
import org.springframework.stereotype.Component;

@Component
public class DocumentationQualityHeuristic implements Heuristic {

    @Override
    public void analyze(AnalysisContext context) {

        if (context.metrics().totalRepositories() == 0) return;

        double coverage = context.metrics().readmeCoverage();

        if (coverage >= 0.6) {
            context.strength(
                    "Boa cobertura de documentação",
                    "A maioria dos repositórios possui README ou descrição adequada."
            );
        } else {
            context.recommend(
                    "Baixa cobertura de documentação",
                    "Menos da metade dos repositórios possui README.",
                    "Adicione READMEs explicando objetivo, stack e uso."
            );
        }
    }
}
