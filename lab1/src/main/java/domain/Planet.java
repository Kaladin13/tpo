package domain;

public class Planet {
    private final String name;
    private final Topology topology;

    public boolean isDesert() {
        return this.topology == Topology.MOUNTAIN;
    }

    public String getName() {
        return name;
    }

    public Planet(String name, Topology topology) {
        this.name = name;
        this.topology = topology;
    }
}
