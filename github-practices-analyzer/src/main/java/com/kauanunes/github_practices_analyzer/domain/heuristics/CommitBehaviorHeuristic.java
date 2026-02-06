package com.kauanunes.github_practices_analyzer.domain.heuristics;

import com.kauanunes.github_practices_analyzer.shared.AnalysisContext;
import org.springframework.stereotype.Component;

@Component
public class CommitBehaviorHeuristic implements Heuristic {

    @Override
    public void analyze(AnalysisContext context) {

        if (!context.metrics().hasCommitHistoryMetrics()) return;

        double avgDays = context.metrics().avgDaysBetweenUpdates();

        if (avgDays > 30) {
            context.recommend(
                    "Commits muito espaçados",
                    "Os repositórios apresentam longos intervalos entre atualizações.",
                    "Considere dividir mudanças em entregas menores e frequentes."
            );
        } else {
            context.strength(
                    "Boa cadência de atualizações",
                    "Os projetos recebem atualizações de forma consistente."
            );
        }
    }
}
