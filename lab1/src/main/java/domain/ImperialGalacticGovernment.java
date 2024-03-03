package domain;

public class ImperialGalacticGovernment {
    private final String emperorName;
    private final String galacticName;

    private final Double PRIVACY_THRESHOLD = 80.00;

    public boolean isSecureEnough(GovernmentProject governmentProject) {
        return Double.compare(this.PRIVACY_THRESHOLD, governmentProject.getPrivacyLevel()) < 0;
    }

    public GovernmentProject createProject(String name, Double privacyLevel, BasePlanetCondition planetCondition) {
        return new GovernmentProject(name, privacyLevel, planetCondition);
    }

    public ImperialGalacticGovernment(String emperorName, String galacticName) {
        this.emperorName = emperorName;
        this.galacticName = galacticName;
    }
}
