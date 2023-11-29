package Client;

import UtilityClass.Question;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameGUI extends JFrame implements ActionListener {


    protected JPanel startPanel;
    protected JPanel northStartPanel;
    protected JPanel centerStartPanel;
    protected JLabel namePromptText;
    protected JLabel gameNameLabel;
    protected JTextField nameField;
    protected JButton nameButton;
    protected JButton guestButton;

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
        setStartPanel(); //*
        setCategoryPanel(); //*
        setQuestionPanel(); //*
        setWaitPanel(); //*
        setFinalPanel(); //*

        this.add(startPanel);

        this.setTitle("Välkommen till Quizkampen");
        this.setSize(800, 600);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        updateGUI();
    }

    public void setStartPanel() {

        startPanel = new JPanel(new BorderLayout());
        startPanel.setBackground(new Color(72,127,56));
        startPanel.setBorder(new EmptyBorder(100, 100, 100, 100));
        northStartPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        northStartPanel.setBackground(new Color(72,127,56));

        centerStartPanel = new JPanel();
        centerStartPanel.setLayout(new BoxLayout(centerStartPanel, BoxLayout.Y_AXIS));
        centerStartPanel.setBorder(new EmptyBorder(60, 20, 220, 20));
        centerStartPanel.setBackground(new Color(72,127,56));

        gameNameLabel = new JLabel("QUIZKAMPEN");
        gameNameLabel.setFont(new Font("Tahoma", Font.BOLD, 55));
        gameNameLabel.setHorizontalAlignment(JLabel.CENTER);
        gameNameLabel.setBackground(new Color(72,127,56));
        gameNameLabel.setOpaque(true);

        namePromptText = new JLabel("Vänligen ange ett namn för att starta spelet");
        namePromptText.setFont(new Font("Tahoma", Font.PLAIN, 20));
        namePromptText.setHorizontalAlignment(JLabel.CENTER);

        nameField = new JTextField();
        nameField.setFont(new Font("Tahoma", Font.BOLD, 25));
        nameField.setHorizontalAlignment(JTextField.CENTER);

        nameButton = new JButton("Spela");
        nameButton.setHorizontalAlignment(JButton.CENTER);
        nameButton.setFocusable(false);
        nameButton.addActionListener(this);

        guestButton = new JButton("Gäst");
        guestButton.setHorizontalAlignment(JButton.CENTER);
        guestButton.setFocusable(false);
        guestButton.addActionListener(this);

        northStartPanel.add(gameNameLabel);
        centerStartPanel.add(namePromptText);
        centerStartPanel.add(nameField);
        centerStartPanel.add(nameButton);
        centerStartPanel.add(guestButton);

        startPanel.add(northStartPanel, BorderLayout.NORTH);
        startPanel.add(centerStartPanel, BorderLayout.CENTER);
    }

    public void setCategoryPanel() {

        categoryPanel = new JPanel(new GridLayout(4, 1));
        categoryPanel.setBorder(new EmptyBorder(100, 220, 100, 220));
        categoryPanel.setBackground(new Color(72,127,56));


        chooseCategoryLabel = new JLabel("Välj kategori");
        chooseCategoryLabel.setFont(new Font("Tahoma", Font.BOLD, 35));

        categoryBtnA = new JButton("A");
        categoryBtnB = new JButton("B");
        categoryBtnC = new JButton("C");

        categoryBtnA.setFocusable(false);
        categoryBtnB.setFocusable(false);
        categoryBtnC.setFocusable(false);

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
        backgroundQuestionPanel.setBorder(new EmptyBorder(100,50,100,50));
        backgroundQuestionPanel.setBackground(new Color(72,127,56));

        questionPanel = new JPanel(new FlowLayout());
        questionPanel.setBackground(new Color(72,127,56));
        choicePanel = new JPanel(new GridLayout(2, 2));

        questionLabel = new JLabel("Fråga..........");
        questionLabel.setFont(new Font("Tahoma", Font.BOLD, 20));

        answerA = new JButton("HejA");
        answerB = new JButton("HejB");
        answerC = new JButton("HejC");
        answerD = new JButton("HejD");
        answerA.setFocusable(false);
        answerB.setFocusable(false);
        answerC.setFocusable(false);
        answerD.setFocusable(false);


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
            choicePanel.add(button);
        }


        questionPanel.add(questionLabel);
        backgroundQuestionPanel.add(questionPanel, BorderLayout.NORTH);
        backgroundQuestionPanel.add(choicePanel, BorderLayout.SOUTH);

    }

    public void setWaitPanel() {
        waitPanel = new JPanel(new GridLayout(2, 1));
        waitPanel.setBorder(new EmptyBorder(100,50,100,50));
        waitPanel.setBackground(new Color(72,127,56));

        waitPanelNorth = new JPanel(new FlowLayout(FlowLayout.CENTER));
        waitPanelNorth.setBackground(new Color(72,127,56));
        waitPanelSouth = new JPanel(new FlowLayout(FlowLayout.CENTER));
        waitPanelSouth.setBackground(new Color(72,127,56));

        waitLabel = new JLabel("Väntar på motspelare...");
        waitLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        waitLabel.setHorizontalAlignment(JLabel.CENTER);

        waitPlayBtn = new JButton("Spela");
        waitPlayBtn.setFocusable(false);
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
        finalPanel.setBorder(new EmptyBorder(100,100,100,100));
        finalPanel.setBackground(new Color(72,127,56));

        finalNorth = new JPanel(new GridLayout(3, 1));
        finalNorth.setBackground(new Color(72,127,56));

        finalSouth = new JPanel(new FlowLayout(FlowLayout.CENTER));
        finalSouth.setBackground(new Color(72,127,56));

        playerPoints1 = new JLabel("Player1 poäng");
        playerPoints2 = new JLabel("Player2 poäng");
        playerPoints1.setFont(new Font("Tahoma", Font.BOLD, 20));
        playerPoints2.setFont(new Font("Tahoma", Font.BOLD, 20));
        playerPoints1.setHorizontalAlignment(JLabel.CENTER);
        playerPoints2.setHorizontalAlignment(JLabel.CENTER);

        winnerLabel = new JLabel("Vinnaren är : ");
        winnerLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        winnerLabel.setHorizontalAlignment(JLabel.CENTER);

        playAgainBtn = new JButton("Spela igen");
        playAgainBtn.setFocusable(false);
        quitGameBtn = new JButton("Avsluta");
        quitGameBtn.setFocusable(false);

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

    private void disableAllButtons() {
        answerA.setEnabled(false);
        answerB.setEnabled(false);
        answerC.setEnabled(false);
        answerD.setEnabled(false);
    }

    protected boolean isCorrectAnswer(Question question, String answer) {
        boolean isCorrectAnswer;
        if (question.getCorrectAnswer().equalsIgnoreCase(answer)) {
            isCorrectAnswer = true;
        } else {
            isCorrectAnswer = false;
        }
        return isCorrectAnswer;
    }

    protected void setColorToButtons(boolean isCorrectAnswer, JButton button) {
        if (isCorrectAnswer) {
            button.setBackground(Color.green);
        } else {
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
        if (e.getSource() == nameButton) {
            if (name.isEmpty()) {
                name = nameField.getText();
                if (!name.isEmpty()) {
                    SwingUtilities.invokeLater(() -> {
                        this.setTitle("Spelare: " + name);
                        updateGUI();
                    });
                } else {
                    namePromptText.setText("Du måste ange ett namn\n "+
                            "eller spela som gäst");
                    updateGUI();
                }
            }
        }
        else if(e.getSource() == guestButton) {
            if (name.isEmpty()) {
                name = guestButton.getText();
                if (!name.isEmpty()) {
                    SwingUtilities.invokeLater(() -> {
                        this.setTitle("Spelare: " + name);
                        updateGUI();
                    });
                }
            }
        }
    }

    public static void main(String[] args) {
        new GameGUI();
    }
}
