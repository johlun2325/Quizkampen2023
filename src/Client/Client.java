package Client;

import UtilityClass.Question;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;

public class Client {

    protected int port = 44456;
    protected String ipAdr = "127.0.0.1";
    protected PrintWriter out;
    protected ObjectInputStream in;
    protected GameGUI gui;
    Question utilityQ;
    //boolean questionAnswered = false;
    boolean allQuestionIsAnswered = false;

    public Client() {

        try {
            Socket socket = new Socket(ipAdr, port);
            out = new PrintWriter(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void play() {  //ENABLE
        Object fromServer;

        try {
            //fromServer = in.readLine(); ö
            gui = new GameGUI();


            while (true) {
                fromServer = in.readObject();
                System.out.println("Från server" + fromServer);

                if (fromServer.equals("AnslutenPlayer1")) {
                    while (gui.getNameFromGui().isEmpty()) {
                        System.out.println(gui.getNameFromGui());
                        Thread.sleep(5000);
                    }
                    out.println("NamePlayer1:" + gui.name); //Ev. out.flush() efter
                    out.flush();
                    System.out.println("Name sent " + gui.name);


                } else if (fromServer.equals("AnslutenPlayer2")) {
                    while (gui.getNameFromGui().isEmpty()) {
                        System.out.println(gui.getNameFromGui());
                        Thread.sleep(5000);
                    }
                    out.println("NamePlayer2:" + gui.name); //Ev. out.flush() efter
                    out.flush();
                    System.out.println("Name sent " + gui.name);


                } else if (fromServer.equals("Category")) {

                    gui.showCategoryPanel();

                    String chosenCategory = null;

                    while (chosenCategory == null || chosenCategory.isEmpty()) {
                        chosenCategory = gui.getChosenCategoryFromGui();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        System.out.println("Client: i kategori");
                    }
                    out.println(chosenCategory);                   // Skickar  ChosenCategory till Servern
                    out.flush();
                    System.out.println("Skriver ut kategori: " + chosenCategory);


                } else if (fromServer.equals("Wait")) {
                    gui.showWaitPanel();

                    //} else if (fromServer.equals("History")) {
                } else if (fromServer instanceof List) {
                    gui.showQuestionPanel();
                    List<?> list = (List<?>) fromServer;
                    if (!list.isEmpty() && list.get(0) instanceof Question) {
                        List<Question> questions = (List<Question>) list;
                        System.out.println("Client inne i if fromServer instanceof List, Questions mottagna");

                        for (int i = 0; i < 3; i++) {
                            gui.questionLabel.setText(questions.get(i).getQuestion());
                            gui.answerA.setText(questions.get(i).getCorrectAnswer());
                            gui.answerB.setText(questions.get(i).getWrongAnswer1());
                            gui.answerC.setText(questions.get(i).getWrongAnswer2());
                            gui.answerD.setText(questions.get(i).getWrongAnswer3());
                            gui.questionAnswered = false;
                            gui.updateGUI();
                            while (!gui.questionAnswered) {
                                try {
                                    Thread.sleep(500);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        //gui.questionAnswered = false;
                        //gui.updateGUI();
                        }

                    //if (allQuestionIsAnswered) {
                        out.println("Points:" + gui.getPoints());

                        out.flush();
                    System.out.println("Inuti Client, questions. Här är poängen när rundorna är slut:  " + gui.getPoints());

                    //}

                    //här läser vi väl in frågorna?

                } else if (fromServer instanceof String && ((String) fromServer).startsWith("Result")) {    //Hit borde vi komma nu
                    String opponentPoints = ((String) fromServer).substring(6).trim();


                    gui.showFinalPanel();
                    gui.playerPoints1.setText("Player1 poäng: " + gui.getPoints());
                   gui.playerPoints2.setText("Player2 poäng: " + opponentPoints);

                   int opponentP = Integer.parseInt(opponentPoints);



                   if(gui.getPoints() > opponentP) {
                       gui.winnerLabel.setText("Du vann!");
                  }else if (gui.getPoints() < opponentP) {
                     gui.winnerLabel.setText("Du förlorade!");
                  }else {
                       gui.winnerLabel.setText("Lika!");
                   }





                }
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
            // } catch (InterruptedException ex) {
            //  throw new RuntimeException(ex);


        } catch (Exception e) {  //FINALLY
            e.printStackTrace();

        }
    }


    public static void main(String[] args) {
        Client client = new Client();
        client.play();
    }
}