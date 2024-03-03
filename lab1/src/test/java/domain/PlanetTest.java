package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName(value = "Planet tests")
public class PlanetTest {
    private Planet desertPlanet;
    private Planet waterPlanet;

    @BeforeEach
    void setUp() {
        this.desertPlanet = new Planet("desert planet", Topology.MOUNTAIN);
        this.waterPlanet = new Planet("water planet", Topology.SEA);
    }

    @Test
    void desertTest() {
        assertTrue(this.desertPlanet.isDesert());
        assertFalse(this.waterPlanet.isDesert());
    }
}
