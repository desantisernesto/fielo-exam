package com.fielo.exam.lookingforbananas.business;

import com.fielo.exam.lookingforbananas.exception.JungleException;
import com.fielo.exam.lookingforbananas.model.Jungle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class GoBackStrategyTest {

    @Autowired
    private GoBackStrategy strategy;


    @Test
    public void emptyJungle(){
        //scenery
        int[][] mat = new int[0][0];
        Jungle jungle = new Jungle(mat);
        int expectedResult = 0;

        //action
        int result = strategy.look(jungle);

        //validations
        assertEquals(expectedResult, result);
    }

    @Test
    public void nullJungle(){
        //scenery
        Jungle jungle = null;
        String expectedMessage = "Jungle cant be null";

        //action
        Exception exception = Assertions.assertThrows(JungleException.class, () -> {
            strategy.look(jungle);
        });

        //validations
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void tinyJungle(){
        //scenery
        int mat[][] = {{1}};
        Jungle jungle = new Jungle(mat);
        int expectedResult = 1;

        //action
        int result = strategy.look(jungle);

        //validations
        assertEquals(expectedResult, result);
    }

    @Test
    public void jungleRightDown(){
        //scenery
        int mat[][] = {{1, 3},
                {0, 4}};

        Jungle jungle = new Jungle(mat);
        int expectedResult = 5;

        //action
        int result = strategy.look(jungle);

        //validations
        assertEquals(expectedResult, result);
    }

    @Test
    public void negativeBananas(){
        //scenery
        int mat[][] = {{1, 3},
                {0, -4}};

        Jungle jungle = new Jungle(mat);
        String expectedMessage = "A quantity of bananas cant be negative: -4";

        //action
        Exception exception = Assertions.assertThrows(JungleException.class, () -> {
            strategy.look(jungle);
        });

        //validations
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void invalidJungle(){
        //scenery
        int mat[][] = {{1, 3},
                {0}};

        Jungle jungle = new Jungle(mat);
        String expectedMessage = "Out of Jungle! position: [y=1, x=1]";

        //action
        Exception exception = Assertions.assertThrows(JungleException.class, () -> {
            strategy.look(jungle);
        });

        //validations
        assertEquals(expectedMessage, exception.getMessage());
    }


    @Test
    public void jungleRightUp(){
        //scenery
        int mat[][] = {{1, 5},
                {7, 4}};

        Jungle jungle = new Jungle(mat);
        int expectedResult = 12;

        //action
        int result = strategy.look(jungle);

        //validations
        assertEquals(expectedResult, result);
    }

    @Test
    public void jungleRight(){
        //scenery
        int mat[][] = {{1, 3},
                {7, 4}};

        Jungle jungle = new Jungle(mat);
        int expectedResult = 11;

        //action
        int result = strategy.look(jungle);

        //validations
        assertEquals(expectedResult, result);
    }

    @Test
    public void examExample1(){
        //scenery
        int mat[][] = {{1, 3, 3},
            {2, 1, 4},
            {0, 6, 4}};

        Jungle jungle = new Jungle(mat);
        int expectedResult = 12;

        //action
        int result = strategy.look(jungle);

        //validations
        assertEquals(expectedResult, result);
    }

    @Test
    public void examExample2(){
        //scenery
        int mat[][] = { {1, 3, 1, 5},
                {2, 2, 4, 1},
                {5, 0, 2, 3},
                {0, 6, 1, 2}};

        Jungle jungle = new Jungle(mat);
        int expectedResult = 16;

        //action
        int result = strategy.look(jungle);

        //validations
        assertEquals(expectedResult, result);
    }

    @Test
    public void examExample3(){
        //scenery
        int mat[][] = {{10, 33, 13, 15},
            {22, 21, 4, 1},
            {5, 0, 2, 3},
            {0, 6, 14, 2}};

        Jungle jungle = new Jungle(mat);
        int expectedResult = 83;

        //action
        int result = strategy.look(jungle);

        //validations
        assertEquals(expectedResult, result);
    }

}
