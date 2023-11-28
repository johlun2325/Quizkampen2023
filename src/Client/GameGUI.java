package Client;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GameGUI extends JFrame {


    JPanel startPanel;
    JLabel namePromptText;
    JLabel gameNameLabel;
    JTextField nameField;
    JButton submitButton;

    JPanel categoryPanel;
    JLabel chooseCategoryLabel;
    JButton categoryBtnA;
    JButton categoryBtnB;
    JButton categoryBtnC;

    JPanel questionPanel;
    JLabel questionLabel;
    JButton answerA;
    JButton answerB;
    JButton answerC;
    JButton answerD;

    JPanel waitPanel;
    JLabel waitLabel;
    JButton playBtn; //default disabled

    JPanel finalPanel;
    JLabel playerPoints1;
    JLabel playerPoints2;
    JLabel winnerLabel;
    JButton playAgainBtn;
    JButton quitGameBtn;

    public GameGUI() {
        setStartPanel();
        setCategoryPanel();


//        setQuestionPanel();
//        setWaitPanel();
//        setFinalPanel();

        this.setSize(800, 600);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }


    public void setStartPanel() {
        startPanel = new JPanel();
        startPanel.setLayout(new GridLayout(4, 1));
        startPanel.setBorder(new EmptyBorder(100, 120, 0, 120));

        gameNameLabel = new JLabel("QUIZKAMPEN");
        gameNameLabel.setFont(new Font("Tahoma", Font.BOLD, 45));

        namePromptText = new JLabel("Vänligen ange ett namn för att starta spelet");
        namePromptText.setFont(new Font("Tahoma", Font.PLAIN, 15));

        nameField = new JTextField();
        nameField.setFont(new Font("Tahoma", Font.BOLD, 25));

        //actionlistener
        submitButton = new JButton("Spela");

        startPanel.add(gameNameLabel);
        startPanel.add(namePromptText);
        startPanel.add(nameField);
        startPanel.add(submitButton);

    }

    public void setCategoryPanel() {

        categoryPanel = new JPanel(new GridLayout(4, 1));
        categoryPanel.setBorder(new EmptyBorder(100, 120, 0, 120));

        chooseCategoryLabel = new JLabel("Välj kategori");
        chooseCategoryLabel.setFont(new Font("Tahoma", Font.BOLD, 35));

        //actionlistener
        categoryBtnA = new JButton("A");
        categoryBtnB = new JButton("B");
        categoryBtnC = new JButton("C");

        categoryPanel.add(chooseCategoryLabel);
        categoryPanel.add(categoryBtnA);
        categoryPanel.add(categoryBtnB);
        categoryPanel.add(categoryBtnC);

    }

    public void setQuestionPanel() {
//        JPanel questionPanel;
//        JLabel questionLabel;
//        JButton answerA;
//        JButton answerB;
//        JButton answerC;
//        JButton answerD;

        questionPanel = new JPanel(new FlowLayout());

        questionLabel = new JLabel("Fråga här");
        questionLabel.setFont(new Font("Tahoma", Font.BOLD,20));



    }

    public void setWaitPanel() {

    }

    public void setFinalPanel() {


    }


    public static void main(String[] args) {
        new GameGUI();
    }

}
