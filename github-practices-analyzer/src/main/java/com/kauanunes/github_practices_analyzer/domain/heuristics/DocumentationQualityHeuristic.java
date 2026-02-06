package com.kauanunes.github_practices_analyzer.domain.heuristics;

import com.kauanunes.github_practices_analyzer.shared.AnalysisContext;
import org.springframework.stereotype.Component;

@Component
public class DocumentationQualityHeuristic implements Heuristic {

    @Override
    public void analyze(AnalysisContext context) {

        int total = context.metrics().getTotalRepositories();

        if (total == 0) {
            return;
        }

        int documented = context.metrics().getRepositoriesWithReadme();
        double ratio = (double) documented / total;

        if (ratio < 0.5) {
            context.recommend(
                    "Baixa cobertura de documentação",
                    "Menos da metade dos repositórios possuem README.",
                    "Adicione READMEs explicando objetivo, stack e instruções básicas."
            );
        } else {
            context.strength(
                    "Boa cobertura de documentação",
                    "A maioria dos repositórios possui README com descrição do projeto."
            );
        }
    }
}
