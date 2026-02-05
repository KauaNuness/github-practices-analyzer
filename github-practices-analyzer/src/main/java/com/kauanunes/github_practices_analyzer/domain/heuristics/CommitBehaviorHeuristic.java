package com.kauanunes.github_practices_analyzer.domain.heuristics;

import com.kauanunes.github_practices_analyzer.domain.model.Recommendation;
import com.kauanunes.github_practices_analyzer.domain.model.Strength;
import com.kauanunes.github_practices_analyzer.shared.AnalysisContext;
import org.springframework.stereotype.Component;

@Component
public class CommitBehaviorHeuristic implements Heuristic{

    @Override
    public void analyze(AnalysisContext context) {

        double avgDays = context.metrics().getAverageDaysBetweenCommits();

        if (avgDays > 21) {
            context.recommend(new Recommendation(
                    "Commits muito espaçados",
                    "O intervalo médio entre commits indica ciclos longos de desenvolvimento.",
                    "Considere dividir entregas em mudanças menores e mais frequentes."
            ));
        } else {
            context.strength(new Strength(
                    "Boa cadência de commits",
                    "O padrão de commits favorece rastreabilidade e manutenção."
            ));
        }

    }

}
