package edu.itmo.hyperb0rean.lab1.domain;

public class Planet {
    private Material material;
    private Universe universe;

    public Planet(Material material) {
        this.material=material;
    }

    public boolean hasAnalogues() {
        for(Planet planet: universe.getPlanets()) {
            if( planet!=this && planet.material.toString().equals(material.toString())) {
                return true;
            }
        }
        return false;
    }

    public void setUniverse(Universe universe) {
        this.universe = universe;
    }

    public Material getMaterial() {
        return material;
    }
    public Universe getUniverse() {
        return universe;
    }
}
