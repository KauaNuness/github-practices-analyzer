package com.kauanunes.github_practices_analyzer.domain.heuristics;

import com.kauanunes.github_practices_analyzer.shared.AnalysisContext;
import org.springframework.stereotype.Component;

@Component
public class RepositoryMaturityHeuristic implements Heuristic {

    @Override
    public void analyze(AnalysisContext context) {

        double abandonment = context.metrics().abandonmentRate();

        if (abandonment > 0.6) {
            context.recommend(
                    "Alta taxa de repositórios abandonados",
                    "Muitos projetos não recebem atualizações há meses.",
                    "Arquive projetos antigos ou documente seu estado atual."
            );
        } else {
            context.strength(
                    "Boa manutenção de repositórios",
                    "A maioria dos projetos apresenta sinais de manutenção recente."
            );
        }
    }
}
