package com.prime.quizzler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yepyaesonetun on 8/16/18.
 **/

public class QuesitonBank {
    List<Question> list = new ArrayList<Question>();

    public QuesitonBank() {
        list.add(new Question("Valentine\'s day is banned in Saudi Arabia.", true));
        list.add(new Question("A slug\'s blood is green.", true));
        list.add(new Question("Approximately one quarter of human bones are in the feet.", true));
        list.add(new Question("The total surface area of two human lungs is approximately 70 square metres.", true));
        list.add(new Question("In West Virginia, USA, if you accidentally hit an animal with your car, you are free to take it home to eat.", true));
        list.add(new Question("In London, UK, if you happen to die in the House of Parliament, you are technically entitled to a state funeral, because the building is considered too sacred a place.", false));
        list.add(new Question("It is illegal to pee in the Ocean in Portugal.", true));
        list.add(new Question("You can lead a cow down stairs but not up stairs.", false));
        list.add(new Question("Google was originally called \"Backrub\".", true));
        list.add(new Question("Buzz Aldrin\'s mother\'s maiden name was \"Moon\".", true));
        list.add(new Question("The loudest sound produced by any animal is 188 decibels. That animal is the African Elephant.", false));
        list.add(new Question("No piece of square dry paper can be folded in half more than 7 times.", false));
        list.add(new Question("Chocolate affects a dog\'s heart and nervous system; a few ounces are enough to kill a small dog.", true));
    }

}
