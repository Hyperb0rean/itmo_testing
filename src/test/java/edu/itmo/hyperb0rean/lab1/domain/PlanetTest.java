package edu.itmo.hyperb0rean.lab1.domain;

import edu.itmo.hyperb0rean.lab1.domain.Material;
import edu.itmo.hyperb0rean.lab1.domain.Planet;
import edu.itmo.hyperb0rean.lab1.domain.Universe;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlanetTest {
    @Test
    void testHasAnalogues_NoAnalogues() {
        Universe universe = new Universe();
        Planet planet1 = new Planet(Material.GOLD);
        universe.add(planet1);
        assertFalse(planet1.hasAnalogues());
    }

    @Test
    void testHasAnalogues_WithAnalogues() {
        Universe universe = new Universe();
        Planet planet1 = new Planet(Material.GOLD);
        Planet planet2 = new Planet(Material.GOLD);
        universe.add(planet1);
        universe.add(planet2);
        planet1.setUniverse(universe);
        planet2.setUniverse(universe);
        assertTrue(planet1.hasAnalogues());
    }

    @Test
    void testSetUniverse() {
        Universe universe = new Universe();
        Planet planet = new Planet(Material.STEEL);
        planet.setUniverse(universe);
        assertEquals(universe, planet.getUniverse());
    }
}