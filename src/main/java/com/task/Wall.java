package com.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Wall implements Structure {
    private List<Block> blocks;

    public Wall(List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        Block returnedBlock = null;
        for (Block block : blocks) {
            if (block instanceof CompositeBlock && block.getColor().equals(color)) {
                returnedBlock = block;
                break;
            } else if (block instanceof CompositeBlock) {
                for (Block nestedBlock : ((CompositeBlock) block).getBlocks()) {
                    if (nestedBlock.getColor().equals(color)) {
                        returnedBlock = nestedBlock;
                        break;
                    }
                }
            } else {
                if (block.getColor().equals(color)) {
                    returnedBlock = block;
                    break;
                }
            }
        }
        return Optional.ofNullable(returnedBlock);
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        List<Block> resultList = new ArrayList<>();
        for (Block block : blocks) {
            if (block instanceof CompositeBlock && block.getMaterial().equals(material)) {
                resultList.add(block);
                for (Block nestedBlock : ((CompositeBlock) block).getBlocks()) {
                    if (nestedBlock.getMaterial().equals(material)) {
                        resultList.add(nestedBlock);
                    }
                }
            } else if (block instanceof CompositeBlock) {
                for (Block nestedBlock : ((CompositeBlock) block).getBlocks()) {
                    if (nestedBlock.getMaterial().equals(material)) {
                        resultList.add(nestedBlock);
                    }
                }
            } else {
                if (block.getMaterial().equals(material)) {
                    resultList.add(block);
                }
            }
        }
        return resultList;
    }

    @Override
    public int count() {
        int counter = 0;
        for (Block block : blocks) {
            if (block instanceof CompositeBlock) {
                counter += 1;
                for (Block nestedBlock : ((CompositeBlock) block).getBlocks()) {
                    counter += 1;
                }
            } else {
                counter += 1;
            }
        }
        return counter;
    }
}
