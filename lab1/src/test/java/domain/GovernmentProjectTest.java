package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GovernmentProjectTest {
    private ImperialGalacticGovernment imperialGalacticGovernment;
    private Planet damogran;
    private Planet terra;

    @BeforeEach
    void setUp() {
        this.imperialGalacticGovernment = new ImperialGalacticGovernment("God-emperor", "Terra");
        this.damogran = new Planet("Damogran", Topology.MOUNTAIN);
        this.terra = new Planet("Terra", Topology.HILL);
    }
    @Test
    void goldenHeartProjectTest() {
        GovernmentProject goldenHeart = this.imperialGalacticGovernment
                .createProject("Golden Heart",
                        100.00,
                        Planet::isDesert);

        assertDoesNotThrow(() -> goldenHeart.setBasePlanet(this.damogran));
        assertEquals(goldenHeart.getBasePlanet(), this.damogran);

        assertThrows(RuntimeException.class, () -> goldenHeart.setBasePlanet(this.terra));
        assertNotEquals(goldenHeart.getBasePlanet(), this.terra);
    }

    @Test
    void projectSecurityTest() {
        GovernmentProject secureProject = this.imperialGalacticGovernment
                .createProject("Secure", 120.00,
                        (planet) -> planet.getName().contains("Sec"));

        GovernmentProject unsecureProject = this.imperialGalacticGovernment
                .createProject("Unsecure!!", 50.00,
                        (planet) -> planet.getName().contains("Unsec"));

        assertTrue(this.imperialGalacticGovernment.isSecureEnough(secureProject));
        assertFalse(this.imperialGalacticGovernment.isSecureEnough(unsecureProject));
    }
}