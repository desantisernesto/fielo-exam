package com.fielo.exam.lookingforbananas.model;

import com.fielo.exam.lookingforbananas.exception.JungleException;
import com.fielo.exam.lookingforbananas.model.enumerations.Movement;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import static com.fielo.exam.lookingforbananas.model.enumerations.Movement.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Position {

    private int y = 0;
    private int x = 0;

    public Position(int x, int y){
        setX(x);
        setY(y);
    }

    public void moveRightUp(){
        x++;
        y--;
    }

    public void moveRightDown(){
        x++;
        y++;
    }

    public void moveRight(){
        x++;
    }

    public static Position positionFrom(Position position, Movement movement) {
        validation(position);
        validation(movement);

        Position newPosition = new Position(position.getX(), position.getY());

        if(RIGHT.equals(movement)){
            newPosition.moveRight();
        } else if(RIGHT_UP.equals(movement)){
            newPosition.moveRightUp();
        } else if(RIGHT_DOWN.equals(movement)){
            newPosition.moveRightDown();
        } else {
            throw new JungleException(String.format("Unknow movement %s", movement));
        }

        return newPosition;
    }

    private static void validation(Movement movement) {
        if(movement == null)
            throw new JungleException("Movement cant be null");
    }

    private static void validation(Position position) {
        if(position == null)
            throw new JungleException("Position cant be null");
        if(position.getX() < 0)
            throw new JungleException(String.format("Position with x=%d is invalid", position.getX()));
        if(position.getY() < 0)
            throw new JungleException(String.format("Position with y=%d is invalid", position.getY()));
    }
}
