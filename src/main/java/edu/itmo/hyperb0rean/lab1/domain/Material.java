package edu.itmo.hyperb0rean.lab1.domain;

public enum Material {
    ROCK("камень"),
    STEEL("сталь"),
    GOLD("чистое золото");

    private String material;
    Material(String s) {
        material = s;
    }

    @Override
    public String toString() {
        return material;
    }
}
