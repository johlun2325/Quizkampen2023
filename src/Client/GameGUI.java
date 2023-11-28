package Client;

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

    protected JPanel questionPanel;
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

    public GameGUI() {
        setStartPanel(); //**
        setCategoryPanel();
        setQuestionPanel(); //*****
        setWaitPanel();
        setFinalPanel();

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
//        JPanel questionPanel;
//        JLabel questionLabel;
//        JButton answerA;
//        JButton answerB;
//        JButton answerC;
//        JButton answerD;

        questionPanel = new JPanel(new FlowLayout());

        questionLabel = new JLabel("Fråga här");
        questionLabel.setFont(new Font("Tahoma", Font.BOLD, 20));


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

        waitPlayBtn.addActionListener(l-> this.add(questionPanel));

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

        playAgainBtn.addActionListener(l-> playAgain = true);
        quitGameBtn.addActionListener(l-> System.exit(0));


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


    public static void main(String[] args) {
        new GameGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton){
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
}
