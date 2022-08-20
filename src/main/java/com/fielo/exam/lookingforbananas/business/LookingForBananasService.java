package com.fielo.exam.lookingforbananas.business;

import com.fielo.exam.lookingforbananas.model.Jungle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LookingForBananasService {

    @Autowired
    LookingForBananasStrategy strategy;

    /**
     *
     * @return best quantity of bananas could be obtained
     */
    public int look(Jungle jungle){
        if(!validate(jungle))
            return 0;

        return strategy.look(jungle);
    }

    private boolean validate(Jungle jungle) {
        return jungle != null ;
    }

}
