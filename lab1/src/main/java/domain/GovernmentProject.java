package domain;

public class GovernmentProject {
    private final String name;
    private Planet basePlanet;
    private Double privacyLevel;

    private final BasePlanetCondition planetCondition;

    public GovernmentProject(String name, Double privacyLevel, BasePlanetCondition planetCondition) {
        this.name = name;
        this.privacyLevel = privacyLevel;
        this.planetCondition = planetCondition;
    }

    public String getName() {
        return name;
    }

    public Double getPrivacyLevel() {
        return privacyLevel;
    }

    public void setPrivacyLevel(Double privacyLevel) {
        this.privacyLevel = privacyLevel;
    }

    public void setBasePlanet(Planet planet) {
        if (!this.planetCondition.isSuitableForProject(planet)) {
            throw new RuntimeException("Not suitable for this project!");
        }

        this.basePlanet = planet;
    }

    public Planet getBasePlanet() {
        return basePlanet;
    }
}
