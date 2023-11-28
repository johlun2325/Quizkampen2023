package Server;

import UtilityClass.Question;

import java.util.ArrayList;
import java.util.List;

public class Database {

    //frågorna kommer i form av ett objekt per fråga som ligger i listor
    //listorna motsvarar kategorier

    //ska klienten få alla listkategorier när den ska välja eller
    // ska man skicka över bara vald kategori?

    protected List<Question> history = new ArrayList<>();
    protected List<Question> music = new ArrayList<>();


    public List<Question> getHistory() {
        return history;
    }

    public List<Question> getMusic() {
        return music;
    }

    //history 4 questions
    protected Question historyQ1 = new Question(
            "What event marked the beginning of World War I?",
            "History",
            "Treaty of Versailles",
            " Invasion of Poland",
            "Battle of Stalingrad",
            "Assassination of Archduke Franz Ferdinand");

    protected Question historyQ2 = new Question(
            "Which ancient civilization built the pyramids at Giza?",
            "History",
            "Roman Empire",
            "Greek Empire",
            "Mesopotamian Empire",
            "Egyptian Empire");

    protected Question historyQ3 = new Question(
            "What year did the United States declare its independence from Great Britain?",
            "History",
            "1789",
            "1812",
            "1607",
            "1776");

    protected Question historyQ4 = new Question(
            "Who was the first woman to win a Nobel Prize and " +
                    "the only person to win Nobel Prizes in two different scientific fields?",
            "History",
            "Rosalind Franklin",
            "Florence Nightingale",
            "Jane Goodall",
            "Marie Curie");


    //music 4 questions
    protected Question musicQ1 = new Question(
            "Which album is often considered one of the " +
                    "greatest and most influential in the history of rock music?",
            "History",
            "The Dark Side of the Moon",
            "Abbey Road",
            "Thriller",
            "Sgt. Pepper's Lonely Hearts Club Band");

    protected Question musicQ2 = new Question(
            "Who is known as the 'King of Pop'?",
            "History",
            "Elvis Presley",
            "Prince",
            "David Bowie",
            "Michael Jackson");

    protected Question musicQ3 = new Question(
            "Which music genre originated in Jamaica in the " +
                    "late 1960s and has influenced many other genres worldwide?",
            "History",
            "Hip Hop",
            "Salsa",
            "Country",
            "Reggae");

    protected Question musicQ4 = new Question(
            "Who was the lead guitarist of the rock band Queen?",
            "History",
            "Jimmy Page",
            "Jimi Hendrix",
            "Eric Clapton",
            "Brian May");

    public Database() {
        history.add(historyQ1);
        history.add(historyQ2);
        history.add(historyQ3);
        history.add(historyQ4);

        music.add(musicQ1);
        music.add(musicQ2);
        music.add(musicQ3);
        music.add(musicQ4);
    }

}
