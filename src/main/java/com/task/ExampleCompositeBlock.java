package com.task;

import java.util.ArrayList;
import java.util.List;

public class ExampleCompositeBlock extends ExampleBlock implements CompositeBlock {

    private List<Block> blocks;

    public ExampleCompositeBlock(String color, String material) {
        super(color, material);
        blocks = new ArrayList<>();
    }

    @Override
    public String getColor() {
        return super.getColor();
    }

    @Override
    public String getMaterial() {
        return super.getMaterial();
    }

    @Override
    public List<Block> getBlocks() {
        return blocks;
    }
}
