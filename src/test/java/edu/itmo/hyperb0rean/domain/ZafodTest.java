package edu.itmo.hyperb0rean.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ZafodTest {
    @Test
    void testJumpUp() {
        Zafod zafod = new Zafod();
        String expectedOutput = "Зафод легко вскочил на ноги.";
        String actualOutput = zafod.jumpUp();
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testLookAround_NoPlanet() {
        Zafod zafod = new Zafod();
        String expectedOutput = "Зафод осматривается вокруг, но не знает, на какой планете он.";
        String actualOutput = zafod.lookAround();
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testLookAround_WithPlanet_NoAnalogues() {
        Universe universe = new Universe();
        Planet planet = new Planet(Material.ROCK);
        universe.add(planet);

        Zafod zafod = new Zafod();
        zafod.standOn(planet);

        String expectedOutput = "Зафод осматривается вокруг на планете из камень.что ничто во Вселенной не блестит так, как планета из камень.";
        String actualOutput = zafod.lookAround();
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testLookAround_WithPlanet_WithAnalogues() {
        Universe universe = new Universe();
        Planet planet1 = new Planet(Material.STEEL);
        Planet planet2 = new Planet(Material.STEEL);
        universe.add(planet1);
        universe.add(planet2);

        planet1.setUniverse(universe);
        planet2.setUniverse(universe);

        Zafod zafod = new Zafod();
        zafod.standOn(planet1);

        String expectedOutput = "Зафод осматривается вокруг на планете из сталь.";
        String actualOutput = zafod.lookAround();
        assertEquals(expectedOutput, actualOutput);
    }
}