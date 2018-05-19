package org.pk.streamstress;

public class Fruit {

    private String name;
    private String color;
    private boolean small;

    public Fruit(String name, String color, boolean small) {
        this.name = name;
        this.color = color;
        this.small = small;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isSmall() {
        return small;
    }

    public void setSmall(boolean small) {
        this.small = small;
    }

    @Override
    public String toString() {
        return new StringBuilder("Name: ").append(this.getName()).append(", Color: ").append(this.getColor()).append(", Size:").append(this.isSmall()?"Small":"Large").toString();
    }
}
