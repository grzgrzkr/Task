package com.task;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WallTestSuite {

    //Given - data preparation
    List<Block> theList = new ArrayList<>();
    Wall wall = new Wall(theList);

    Block block1 = new ExampleBlock("red", "plastic");
    Block block2 = new ExampleBlock("red", "plastic");
    Block block3 = new ExampleBlock("grey", "concrete");
    CompositeBlock block4 = new ExampleCompositeBlock("grey", "concrete");
    Block block5nested = new ExampleCompositeBlock("grey", "concrete");
    Block block6nested = new ExampleCompositeBlock("yellow", "plastic");
    Block block7nested = new ExampleCompositeBlock("grey", "plastic");

    List<Block> fillTheList() {
        block4.getBlocks().add(block5nested);
        block4.getBlocks().add(block6nested);
        block4.getBlocks().add(block7nested);
        theList.add(block4);
        theList.add(block1);
        theList.add(block2);
        theList.add(block3);
        return theList;
    }

    @Test
    void shouldReturnBlockByColor() {
        //Given
        fillTheList();

        //When
        Optional returnedBlock = wall.findBlockByColor("yellow");

        //Then
        assertEquals(block6nested, returnedBlock.get());
    }

    @Test
    void shouldNotReturnBlockByColor() {
        //Given
        fillTheList();

        //When
        Optional returnedBlock = wall.findBlockByColor("green");

        //Then
        assertEquals(Optional.empty(), returnedBlock);
    }

    @Test
    void shouldReturnListOfAllElementsByMaterial() {
        //Given
        fillTheList();

        //When
        List<Block> materialList = wall.findBlocksByMaterial("plastic");

        //Then
        assertEquals(4, materialList.size());
    }

    @Test
    void shouldReturnEmptyListOfElementsByMaterial() {
        //Given
        fillTheList();

        //When
        List<Block> materialList = wall.findBlocksByMaterial("steel");

        //Then
        assertEquals(0, materialList.size());
    }

    @Test
    void shouldReturnNumberOfElementsInStructure() {
        //Given
        fillTheList();

        //When
        int structureSize = wall.count();

        //Then
        assertEquals(7, structureSize);
    }
}
