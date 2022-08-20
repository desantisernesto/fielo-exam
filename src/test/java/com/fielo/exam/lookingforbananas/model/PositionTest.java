package com.fielo.exam.lookingforbananas.model;

import com.fielo.exam.lookingforbananas.model.enumerations.Movement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.fielo.exam.lookingforbananas.model.enumerations.Movement.*;

public class PositionTest {

    @Test
    public void rightZero(){
        //scenery
        Movement movement = RIGHT;
        Position original = new Position(0,0);
        Position expected = new Position(1,0);

        //action
        Position result = Position.positionFrom(original, movement);

        //validations
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void right(){
        //scenery
        Movement movement = RIGHT;
        Position original = new Position(10,10);
        Position expected = new Position(11,10);

        //action
        Position result = Position.positionFrom(original, movement);

        //validations
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void rightUp(){
        //scenery
        Movement movement = RIGHT_UP;
        Position original = new Position(10,10);
        Position expected = new Position(11,9);

        //action
        Position result = Position.positionFrom(original, movement);

        //validations
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void rightUpZero(){
        //scenery
        Movement movement = RIGHT_UP;
        Position original = new Position(0,0);
        Position expected = new Position(1,-1);

        //action
        Position result = Position.positionFrom(original, movement);

        //validations
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void rightDown(){
        //scenery
        Movement movement = RIGHT_DOWN;
        Position original = new Position(10,10);
        Position expected = new Position(11,11);

        //action
        Position result = Position.positionFrom(original, movement);

        //validations
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void rightDownZero(){
        //scenery
        Movement movement = RIGHT_DOWN;
        Position original = new Position(0,0);
        Position expected = new Position(1,1);

        //action
        Position result = Position.positionFrom(original, movement);

        //validations
        Assertions.assertEquals(expected, result);
    }

}
