package com.kauanunes.github_practices_analyzer.domain.heuristics;

import com.kauanunes.github_practices_analyzer.domain.model.Recommendation;
import com.kauanunes.github_practices_analyzer.shared.AnalysisContext;
import org.springframework.stereotype.Component;

@Component
public class RepositoryMaturityHeuristic implements Heuristic{

    @Override
    public void analyze(AnalysisContext context){

        if (context.metrics().getRepositoryAbandonmentRate() > 0.6) {
            context.recommend(new Recommendation(
                    "Alta taxa de repositórios abandonados",
                    "Muitos projetos não recebem manutenção após criação.",
                    "Arquive projetos antigos ou documente o estado atual deles."
            ));
        }

    }

}
