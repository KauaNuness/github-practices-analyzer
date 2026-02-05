package com.kauanunes.github_practices_analyzer.domain.heuristics;

import com.kauanunes.github_practices_analyzer.shared.AnalysisContext;

public interface Heuristic {
    void analyze(AnalysisContext context);
}
