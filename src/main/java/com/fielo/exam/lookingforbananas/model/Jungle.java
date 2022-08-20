package com.fielo.exam.lookingforbananas.model;

import com.fielo.exam.lookingforbananas.exception.JungleException;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;

import static java.lang.String.format;

@AllArgsConstructor
public class Jungle {

    int[][] field;

    @Validated
    public int getBananas(Position position){
        validateIntoJungle(position);
        int bananas = field[position.getY()][position.getX()];
        if(bananas < 0)
            throw new JungleException(format("A quantity of bananas cant be negative: %d", bananas));
        return bananas;
    }

    private void validateIntoJungle(Position position){
        if(!isIntoJungle(position))
            throw new JungleException(format("Out of Jungle! position: [y=%d, x=%d]", position.getX(), position.getY()));
    }

    public boolean isIntoJungle(Position position){
        return position.getY() >= 0
                && position.getX() >= 0
                && position.getY() < field.length
                && position.getX() < field[position.getY()].length;
    }

    public int getXJungleSize(){
        if(getYJungleSize() == 0)
            return 0;
        return field[0].length;
    }

    public int getYJungleSize(){
        return field.length;
    }

}
