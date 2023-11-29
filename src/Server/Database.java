package Server;

import UtilityClass.Question;

import java.util.ArrayList;
import java.util.List;

public class Database {

    //frågorna kommer i form av ett objekt per fråga som ligger i listor
    //listorna motsvarar kategorier

    //ska klienten få alla listkategorier när den ska välja eller
    // ska man skicka över bara vald kategori?

    protected List<Question> History = new ArrayList<>();
    protected List<Question> Music = new ArrayList<>();
    protected List<Question> Food = new ArrayList<>();
    protected List<Question> Movies = new ArrayList<>();
    protected List<Question> Sport = new ArrayList<>();
    protected List<Question> Programming = new ArrayList<>();


    public List<Question> getHistory() {
        return History;
    }

    public List<Question> getMusic() {
        return Music;
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
            "Music",
            "The Dark Side of the Moon",
            "Abbey Road",
            "Thriller",
            "Sgt. Pepper's Lonely Hearts Club Band");

    protected Question musicQ2 = new Question(
            "Who is known as the 'King of Pop'?",
            "Music",
            "Elvis Presley",
            "Prince",
            "David Bowie",
            "Michael Jackson");

    protected Question musicQ3 = new Question(
            "Which music genre originated in Jamaica in the " +
                    "late 1960s and has influenced many other genres worldwide?",
            "Music",
            "Hip Hop",
            "Salsa",
            "Country",
            "Reggae");

    protected Question musicQ4 = new Question(
            "Who was the lead guitarist of the rock band Queen?",
            "Music",
            "Jimmy Page",
            "Jimi Hendrix",
            "Eric Clapton",
            "Brian May");

    //Food 4 questions
    protected Question foodQ1 = new Question(
            "Which spice is derived from the dried stigma of the Crocus sativus flower?",
            "Food",
            "Turmeric",
            "Cinnamon",
            "Saffron",
            "Paprika");

    protected Question foodQ2 = new Question(
            "Which type of pasta is shaped like small rice grains and is often used in soups?",
            "Food",
            "Fettuccine",
            "Orzo",
            "Rigatoni",
            "Farfalle");

    protected Question foodQ3 = new Question(
            "What is the main ingredient in the traditional Japanese soup miso soup?",
            "Food",
            "Seaweed",
            "Tofu",
            "Soy Sauce",
            "Miso Paste");

    protected Question foodQ4 = new Question(
            "Which fruit is known as the 'king of fruits' and is famous for its strong odor?",
            "Food",
            "Banana",
            "Durian",
            "Mango",
            "Pineapple");

    //Movies 4 questions
    protected Question movieQ1 = new Question(
            "Which movie features a character named Tony Stark who becomes a superhero with a powered armor suit?",
            "Movies",
            "The Dark Knight",
            "Spider-Man: Homecoming",
            "Iron Man",
            "Guardians of the Galaxy");

    protected Question movieQ2 = new Question(
            "Who directed the 1994 film 'Pulp Fiction'?",
            "Movies",
            "Christopher Nolan",
            "Quentin Tarantino",
            "Steven Spielberg",
            "Martin Scorsese");

    protected Question movieQ3 = new Question(
            "Which animated film tells the story of a clownfish named Marlin searching for his son Nemo?",
            "Movies",
            "Toy Story",
            "Finding Nemo",
            "Shrek",
            "The Lion King");

    protected Question movieQ4 = new Question(
            "In which movie does Tom Hanks' character say, 'Life is like a box of chocolates'?",
            "Movies",
            "Forrest Gump",
            "Saving Private Ryan",
            "Cast Away",
            "The Green Mile");

    //Sport 4 questions
    protected Question sportQ1 = new Question(
            "Which country hosted the 2016 Summer Olympics?",
            "Sports",
            "Brazil",
            "China",
            "United States",
            "Russia");

    protected Question sportQ2 = new Question(
            "In which sport would you perform a slam dunk?",
            "Sports",
            "Tennis",
            "Basketball",
            "Soccer",
            "Golf");

    protected Question sportQ3 = new Question(
            "Which athlete is often referred to as 'The Fastest Man on Earth'?",
            "Sports",
            "Usain Bolt",
            "Michael Phelps",
            "Lionel Messi",
            "Serena Williams");

    protected Question sportQ4 = new Question(
            "What is the term for a perfect score of 10.0 in gymnastics?",
            "Sports",
            "Gold Medal",
            "Perfect Score",
            "Flawless Ten",
            "Perfect Ten");

    //Programming 4 questions
    protected Question programmingQ1 = new Question(
            "Which programming language was developed by James Gosling at Sun Microsystems in the 1990s?",
            "Programming",
            "Python",
            "C++",
            "Java",
            "Ruby");

    protected Question programmingQ2 = new Question(
            "What does HTML stand for in web development?",
            "Programming",
            "Hypertext Markup Language",
            "High-Level Text Management",
            "Hyperlink and Text Markup Language",
            "Home Tool Markup Language");

    protected Question programmingQ3 = new Question(
            "In object-oriented programming, what is the term for creating an instance of a class?",
            "Programming",
            "Instantiation",
            "Implementation",
            "Inheritance",
            "Integration");

    protected Question programmingQ4 = new Question(
            "Which version control system is known for its distributed nature and is commonly used in open-source projects?",
            "Programming",
            "Subversion",
            "Git",
            "Mercurial",
            "CVS");

    public Database(){

        History.add(historyQ1);
        History.add(historyQ2);
        History.add(historyQ3);
        History.add(historyQ4);

        Music.add(musicQ1);
        Music.add(musicQ2);
        Music.add(musicQ3);
        Music.add(musicQ4);

        Food.add(foodQ1);
        Food.add(foodQ2);
        Food.add(foodQ3);
        Food.add(foodQ4);

        Movies.add(movieQ1);
        Movies.add(movieQ2);
        Movies.add(movieQ3);
        Movies.add(movieQ4);

        Sport.add(sportQ1);
        Sport.add(sportQ2);
        Sport.add(sportQ3);
        Sport.add(sportQ4);

        Programming.add(programmingQ1);
        Programming.add(programmingQ2);
        Programming.add(programmingQ3);
        Programming.add(programmingQ4);

    }


}
