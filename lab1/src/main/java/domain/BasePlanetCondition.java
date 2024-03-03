package domain;

@FunctionalInterface
public interface BasePlanetCondition {
    boolean isSuitableForProject(Planet planet);

}
