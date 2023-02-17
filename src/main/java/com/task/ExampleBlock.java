package com.task;

public class ExampleBlock implements Block {

    private String color;
    private String material;

    public ExampleBlock(String color, String material) {
        this.color = color;
        this.material = material;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getMaterial() {
        return material;
    }
}
