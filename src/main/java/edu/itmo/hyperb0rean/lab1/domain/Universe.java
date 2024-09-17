package edu.itmo.hyperb0rean.lab1.domain;

import java.util.HashSet;
import java.util.Set;

public class Universe {
    private final Set<Planet> planets;

    public Universe() {
        planets = new HashSet<>();
    }

    public void add(Planet planet) throws RuntimeException {
        if (!planets.add(planet)) {
            throw new RuntimeException("Planet already exists in the universe: " + planet.getMaterial());
        }
        planet.setUniverse(this);
    }

    public Set<Planet> getPlanets() {
        return planets;
    }
}