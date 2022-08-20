package com.fielo.exam.lookingforbananas.business;

import com.fielo.exam.lookingforbananas.exception.JungleException;
import com.fielo.exam.lookingforbananas.model.Jungle;
import com.fielo.exam.lookingforbananas.model.Position;
import com.fielo.exam.lookingforbananas.model.enumerations.Movement;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.fielo.exam.lookingforbananas.model.enumerations.Movement.*;
import static java.lang.Math.max;

@Component("LookingForBananasGoBackStrategy")
class GoBackStrategy implements LookingForBananasStrategy {

    @Override
    public int look(Jungle jungle) {
        validate(jungle);
        int ySize = jungle.getYJungleSize();
        int xSize = jungle.getXJungleSize();

        List<Integer> previousColumn = getInitializedColumn(ySize);
        for (int x = xSize-1; x >= 0 ; x--) {
            List<Integer> currentColumn = new ArrayList<>(xSize);
            for (int y = 0; y < ySize; y++) {
                //save banana's quantity best path from this position
                currentColumn.add(getBestFrom(jungle, new Position(x , y), previousColumn));
            }
            previousColumn = currentColumn;
        }

        return previousColumn.stream().reduce(0, Math::max);
    }

    private void validate(Jungle jungle) {
        if(jungle == null)
            throw new JungleException("Jungle cant be null");
    }

    /**
     * Column zero initialized
     *
     * @param size column size
     * @return
     */
    private List<Integer> getInitializedColumn(int size) {
        List<Integer> retorno = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            retorno.add(0);
        }

        return retorno;
    }


    /**
     * Banana's quantity of the best path of current position
     *
     * @param jungle
     * @param position
     * @param column
     * @return
     */
    private int getBestFrom(Jungle jungle, Position position, List<Integer> column) {
        return jungle.getBananas(position) + getBestMovementFrom(column, position);
    }

    /**
     * Banana's quantity of the best path starting in this position
     *
     * @param column
     * @param position
     * @return
     */
    private int getBestMovementFrom(List<Integer> column, Position position) {
        return max(
                getQtdWithMovement(column, position, RIGHT),
                    max(
                        getQtdWithMovement(column, position, RIGHT_UP),
                        getQtdWithMovement(column, position, RIGHT_DOWN)
                    )
        );
    }

    /**
     *
     * @param column
     * @param position
     * @param movement
     * @return banana's quantity taken the movement
     */
    private int getQtdWithMovement(List<Integer> column, Position position, Movement movement) {
        Position newPosition = Position.positionFrom(position, movement);

        if(newPosition.getY() >= 0 && newPosition.getY() < column.size()){
            return column.get(newPosition.getY());
        } else {
            return 0;
        }
    }

}
