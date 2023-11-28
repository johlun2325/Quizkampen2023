package Client;

import UtilityClass.Question;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameGUI extends JFrame implements ActionListener {


    protected JPanel startPanel;
    protected JLabel namePromptText;
    protected JLabel gameNameLabel;
    protected JTextField nameField;
    protected JButton submitButton;

    protected JPanel categoryPanel;
    protected JLabel chooseCategoryLabel;
    protected JButton categoryBtnA;
    protected JButton categoryBtnB;
    protected JButton categoryBtnC;

    protected JPanel backgroundQuestionPanel;
    protected JPanel questionPanel;
    protected JPanel choicePanel;
    protected JLabel questionLabel;
    protected JButton answerA;
    protected JButton answerB;
    protected JButton answerC;
    protected JButton answerD;

    protected JPanel waitPanel;
    protected JPanel waitPanelNorth;
    protected JPanel waitPanelSouth;
    protected JLabel waitLabel;
    protected JButton waitPlayBtn; //default disabled

    protected JPanel finalPanel;
    protected JPanel finalSouth;
    protected JPanel finalNorth;
    protected JLabel playerPoints1;
    protected JLabel playerPoints2;
    protected JLabel winnerLabel;
    protected JButton playAgainBtn;
    protected JButton quitGameBtn;

    protected String name = "";
    protected String chosenCategory = "";
    protected boolean playAgain = false;
    protected String answerToQuestion = "";
    protected boolean isCorrectAnswerToQuestion = false;


    public GameGUI() {
        setStartPanel(); //**
        setCategoryPanel();
        setQuestionPanel(); //*****
        setWaitPanel();
        setFinalPanel();

        this.add(backgroundQuestionPanel);
//        this.add(startPanel);
//        this.add(categoryPanel);
//        this.add(waitPanel);

        this.setTitle("Välkommen till Quizkampen");
        this.setSize(800, 600);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        updateGUI();
    }

    public void setStartPanel() {
        startPanel = new JPanel(new GridLayout(4, 1));
        startPanel.setBorder(new EmptyBorder(100, 120, 0, 120));

        gameNameLabel = new JLabel("QUIZKAMPEN");
        gameNameLabel.setFont(new Font("Tahoma", Font.BOLD, 45));
        gameNameLabel.setHorizontalAlignment(JLabel.CENTER);

        namePromptText = new JLabel("Vänligen ange ett namn för att starta spelet");
        namePromptText.setFont(new Font("Tahoma", Font.PLAIN, 15));
        namePromptText.setHorizontalAlignment(JLabel.CENTER);

        nameField = new JTextField();
        nameField.setFont(new Font("Tahoma", Font.BOLD, 25));
        nameField.setHorizontalAlignment(JTextField.CENTER);
        nameField.setPreferredSize(new Dimension(300, 50));

        //actionlistener
        submitButton = new JButton("Spela");
        submitButton.addActionListener(this);

        startPanel.add(gameNameLabel);
        startPanel.add(namePromptText);
        startPanel.add(nameField);
        startPanel.add(submitButton);
        pack();
    }

    public void setCategoryPanel() {

        categoryPanel = new JPanel(new GridLayout(4, 1));
        categoryPanel.setBorder(new EmptyBorder(100, 120, 0, 120));

        chooseCategoryLabel = new JLabel("Välj kategori");
        chooseCategoryLabel.setFont(new Font("Tahoma", Font.BOLD, 35));

        categoryBtnA = new JButton("A");
        categoryBtnB = new JButton("B");
        categoryBtnC = new JButton("C");

        //sparar knappvalet till variabel
        categoryBtnA.addActionListener(e -> chosenCategory = categoryBtnA.getText());
        categoryBtnB.addActionListener(e -> chosenCategory = categoryBtnB.getText());
        categoryBtnC.addActionListener(e -> chosenCategory = categoryBtnC.getText());

        categoryPanel.add(chooseCategoryLabel);
        categoryPanel.add(categoryBtnA);
        categoryPanel.add(categoryBtnB);
        categoryPanel.add(categoryBtnC);

    }

    public void setQuestionPanel() {
        backgroundQuestionPanel = new JPanel(new BorderLayout());
        questionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        choicePanel = new JPanel(new GridLayout(2, 2));

        questionLabel = new JLabel("Fråga");
        questionLabel.setFont(new Font("Tahoma", Font.BOLD, 20));

        answerA = new JButton("Hej");
        answerB = new JButton("Hej");
        answerC = new JButton("Hej");
        answerD = new JButton("Hej");


        answerA.addActionListener(l -> {
            answerToQuestion = answerA.getText();
            disableAllButtons();
//            isCorrectAnswerToQuestion = isCorrectAnswer("Rätt svar från frågan", answerA.getText());
            setColorToButtons(isCorrectAnswerToQuestion, answerA);
        });

        answerB.addActionListener(l -> {
            answerToQuestion = answerB.getText();
            disableAllButtons();
        });

        answerC.addActionListener(l -> {
            answerToQuestion = answerC.getText();
            disableAllButtons();
        });

        answerD.addActionListener(l -> {
            answerToQuestion = answerD.getText();
            disableAllButtons();
        });



        JButton[] buttons = {answerA, answerB, answerC, answerD};
        for (JButton button : buttons) {
            button.setFont(new Font("Tahoma", Font.BOLD, 15));
            button.setPreferredSize(new Dimension(300, 80));

            questionPanel.add(questionLabel, BorderLayout.NORTH);
            choicePanel.add(button, BorderLayout.SOUTH);

        }

        questionPanel.add(questionLabel);
        backgroundQuestionPanel.add(questionPanel, BorderLayout.NORTH);
        backgroundQuestionPanel.add(choicePanel, BorderLayout.SOUTH);


    }


    public void setWaitPanel() {
        waitPanel = new JPanel(new GridLayout(2, 1));
        waitPanelNorth = new JPanel(new FlowLayout(FlowLayout.CENTER));
        waitPanelSouth = new JPanel(new FlowLayout(FlowLayout.CENTER));


        waitLabel = new JLabel("Väntar på motspelare...");
        waitLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        waitLabel.setHorizontalAlignment(JLabel.CENTER);

        waitPlayBtn = new JButton("Spela");
        waitPlayBtn.setEnabled(false); //false tills får spela
        waitPlayBtn.setPreferredSize(new Dimension(300, 100));
        waitPlayBtn.setHorizontalAlignment(JButton.CENTER);

        waitPlayBtn.addActionListener(l -> this.add(questionPanel));

        waitPanelNorth.add(waitLabel);
        waitPanelSouth.add(waitPlayBtn);

        waitPanel.add(waitPanelNorth);
        waitPanel.add(waitPanelSouth);
    }

    public void setFinalPanel() {
        finalPanel = new JPanel(new GridLayout(2, 1));
        finalNorth = new JPanel(new GridLayout(3, 1));
        finalSouth = new JPanel(new FlowLayout(FlowLayout.CENTER));

        playerPoints1 = new JLabel("Player1 poäng");
        playerPoints2 = new JLabel("Player2 poäng");
        playerPoints1.setFont(new Font("Tahoma", Font.BOLD, 30));
        playerPoints2.setFont(new Font("Tahoma", Font.BOLD, 30));
        playerPoints1.setHorizontalAlignment(JLabel.CENTER);
        playerPoints2.setHorizontalAlignment(JLabel.CENTER);

        winnerLabel = new JLabel("Vinnaren är : ");
        winnerLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        winnerLabel.setHorizontalAlignment(JLabel.CENTER);

        playAgainBtn = new JButton("Spela igen");
        quitGameBtn = new JButton("Avsluta");

        playAgainBtn.addActionListener(l -> playAgain = true);
        quitGameBtn.addActionListener(l -> System.exit(0));


        finalNorth.add(playerPoints1);
        finalNorth.add(playerPoints2);
        finalNorth.add(winnerLabel);

        finalSouth.add(playAgainBtn);
        finalSouth.add(quitGameBtn);

        finalPanel.add(finalNorth);
        finalPanel.add(finalSouth);
    }

    protected void updateGUI() {
        this.revalidate();
        this.repaint();
    }

    private void disableAllButtons () {
        answerA.setEnabled(false);
        answerB.setEnabled(false);
        answerC.setEnabled(false);
        answerD.setEnabled(false);
    }

    protected boolean isCorrectAnswer(Question question, String answer){
        boolean isCorrectAnswer;
        if (question.getCorrectAnswer().equalsIgnoreCase(answer)){
            isCorrectAnswer = true;
        }
        else{
            isCorrectAnswer = false;
        }
        return isCorrectAnswer;
    }

    protected void setColorToButtons(boolean isCorrectAnswer, JButton button){
        if (isCorrectAnswer){
            button.setBackground(Color.green);
        }
        else{
            button.setBackground(Color.red);
        }
    }


    public String getNameFromGui() {
        return name;
    }

    public String getChosenCategoryFromGui() {
        return chosenCategory;
    }

    public boolean isPlayAgainFromGui() {
        return playAgain;
    }

    public String getAnswerToQuestionFromGui() {
        return answerToQuestion;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            if (name.isEmpty()) {
                name = nameField.getText();
                if (!name.isEmpty()) {
                    SwingUtilities.invokeLater(() -> {
                        this.setTitle("Player: " + name);
                        updateGUI();
                    });
                } else {
                    namePromptText.setText("Du måste ange ett namn");
                    updateGUI();
                }
            }

        }
    }
    public static void main(String[] args) {
        new GameGUI();
    }
}
