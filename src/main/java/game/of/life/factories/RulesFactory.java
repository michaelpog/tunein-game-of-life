package game.of.life.factories;

import game.of.life.rules.NextStateStrategy;
import game.of.life.rules.imp.OverCrowdingRule;
import game.of.life.rules.imp.ReproductionRule;
import game.of.life.rules.imp.UnderPopulationRule;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RulesFactory {
    private static RulesFactory instance;
    private Set<NextStateStrategy> rules;

    private RulesFactory() {
        rules = new HashSet<>();
        rules.add(new OverCrowdingRule());
        rules.add(new ReproductionRule());
        rules.add(new UnderPopulationRule());

        rules = Collections.unmodifiableSet(rules);
    }

    public static RulesFactory getInstance() {
        if (instance == null) {
            instance = new RulesFactory();
        }

        return instance;
    }

    public Set<NextStateStrategy> getRules() {
        return getInstance().rules;
    }
}
