package com.kauanunes.github_practices_analyzer.domain.heuristics;

import com.kauanunes.github_practices_analyzer.shared.AnalysisContext;
import org.springframework.stereotype.Component;

@Component
public class RepositoryMaturityHeuristic implements Heuristic {

    @Override
    public void analyze(AnalysisContext context) {

        if (!context.metrics().hasRepositories()) {
            return;
        }

        if (context.metrics().getRepositoryAbandonmentRate() > 0.6) {
            context.recommend(
                    "Alta taxa de repositórios abandonados",
                    "Muitos projetos não recebem manutenção após criação.",
                    "Arquive projetos antigos ou documente o estado atual deles."
            );
        } else {
            context.strength(
                    "Boa manutenção de repositórios",
                    "A maioria dos projetos apresenta sinais de manutenção recente."
            );
        }
    }
}
