package UtilityClass;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Question implements Serializable {
    /**Alla frågor innehåller
     * själva frågan,
     * 3 felaktiga svar,
     * ett rätt svar och
     *  en metod som returnerar alla svar i en lista
     *  (för att lätt placera ut svaren på knappar i en loop t.ex.)
     *  Samt getters och constructor.
     */

    String question;
    String category;
    String wrongAnswer1;
    String wrongAnswer2;
    String wrongAnswer3;
    String correctAnswer;

    public Question(String question, String category, String wrongAnswer1,
                    String wrongAnswer2, String wrongAnswer3,
                    String correctAnswer)
    {
        this.question = question;
        this.category = category;
        this.wrongAnswer1 = wrongAnswer1;
        this.wrongAnswer2 = wrongAnswer2;
        this.wrongAnswer3 = wrongAnswer3;
        this.correctAnswer = correctAnswer;
    }

    public String getCategory() {
        return category;
    }

    public String getQuestion() {
        return question;
    }

    public String getWrongAnswer1() {
        return wrongAnswer1;
    }

    public String getWrongAnswer2() {
        return wrongAnswer2;
    }

    public String getWrongAnswer3() {
        return wrongAnswer3;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public List<String> getAllAnswersAsShuffledList(){
        List<String> allAnswers = Arrays.asList(wrongAnswer1,wrongAnswer2,wrongAnswer3,correctAnswer);
        Collections.shuffle(allAnswers);
        return allAnswers;
    }
}
