package com.kauanunes.github_practices_analyzer.domain.heuristics;

import com.kauanunes.github_practices_analyzer.domain.model.Recommendation;
import com.kauanunes.github_practices_analyzer.shared.AnalysisContext;
import org.springframework.stereotype.Component;

@Component
public class DocumentationQualityHeuristic implements Heuristic{

    @Override
    public void analyze(AnalysisContext context){

        int total = context.metrics().getTotalRepositories();
        int documented = context.metrics().getRepositoriesWithReadme();

        if (total > 0 && documented < total * 0.5){
            context.recommend(new Recommendation(
                    "Baixa cobertura de documentação",
                    "Menos da metade dos repositórios possuem README.",
                    "Adicione READMEs explicando objetivo, stack e instruções básicas."
            ));
        }

    }

}
