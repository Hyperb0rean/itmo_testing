package edu.itmo.hyperb0rean.lab1.domain;

import edu.itmo.hyperb0rean.lab1.domain.Material;
import edu.itmo.hyperb0rean.lab1.domain.Planet;
import edu.itmo.hyperb0rean.lab1.domain.Universe;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UniverseTest {
    @Test
    void testAddPlanet_UniquePlanet() {
        Universe universe = new Universe();
        Planet planet = new Planet(Material.GOLD);
        universe.add(planet);
        assertTrue(universe.getPlanets().contains(planet));
    }

    @Test
    void testAddPlanet_DuplicatePlanet() {
        Universe universe = new Universe();
        Planet planet = new Planet(Material.GOLD);
        universe.add(planet);
        RuntimeException exception = assertThrows(RuntimeException.class, () -> universe.add(planet));
        assertEquals("Planet already exists in the universe: " + planet.getMaterial(), exception.getMessage());
    }

    @Test
    void testGetPlanets_EmptyUniverse() {
        Universe universe = new Universe();
        assertTrue(universe.getPlanets().isEmpty());
    }
}