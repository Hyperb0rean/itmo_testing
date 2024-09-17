package edu.itmo.hyperb0rean.lab1.domain;

public class Zafod {
    private Planet planet;


    public String jumpUp() {
        return "Зафод легко вскочил на ноги.";
    }

    public String lookAround() {
        StringBuilder builder = new StringBuilder();
        if (planet != null) {
            builder.append(String.format("Зафод осматривается вокруг на планете из %s.", planet.getMaterial().toString()));
            if(!planet.hasAnalogues()) {
                builder.append(String.format("что ничто во Вселенной не блестит так, как планета из %s.", planet.getMaterial().toString()));
            }
        } else {
            builder.append("Зафод осматривается вокруг, но не знает, на какой планете он.");
        }
        return builder.toString();
    }

    public void standOn(Planet planet) {
        this.planet = planet;
    }
}