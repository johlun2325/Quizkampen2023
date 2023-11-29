package Server;

import UtilityClass.Question;

import javax.swing.*;
import java.io.IOException;
import java.util.List;

public class ServerGame extends Thread {
    ServerPlayer player1;
    ServerPlayer player2;
    ServerPlayer currentPlayer;
    Database db = new Database();


    public ServerGame(ServerPlayer player1, ServerPlayer player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
        this.player1.setOpponent(player2);
        this.player2.setOpponent(player1);
    }

    public void run() {

        try {
            player1.sendString("AnslutenPlayer1");
            player2.sendString("AnslutenPlayer2");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        String inputStringFromPlayer1 = "";

        while (true) {
            inputStringFromPlayer1 = currentPlayer.receiveString();

            if (inputStringFromPlayer1.startsWith("NamePlayer1:")) {
                String name = inputStringFromPlayer1.substring(12).trim(); //Spara namn
                player1.setPlayer(name);
                System.out.println(name + " Här är namnet för spelare 1");

                try {
                    currentPlayer.sendString("Category");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                currentPlayer = currentPlayer.getOpponent();  //BYTER CURRENT-PLAYER

            } else if (inputStringFromPlayer1.startsWith("NamePlayer2:")) {
                String name = inputStringFromPlayer1.substring(12).trim(); //Spara namn
                player2.setPlayer(name);
                System.out.println(name + " Här är namnet för spelare 2");

                try {
                    currentPlayer.sendString("Wait");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                currentPlayer = currentPlayer.getOpponent(); //BYTER CURRENT-PLAYER

            } else if (inputStringFromPlayer1.trim().equalsIgnoreCase("History")) {
                System.out.println("Inuti else if equals(History)");
                player1.sendObject(db.getHistory());
                player2.sendObject(db.getHistory());

            } else if (inputStringFromPlayer1.equals("Music")) {
                player1.sendObject(db.getMusic());
                player2.sendObject(db.getMusic());
            }

            //if (inputStringFromClient.equals("Rätt"))


            //currentPlayer = currentPlayer.getOpponent();  //BYTER SPELARE
        }


        //currentPlayer = currentPlayer.getOpponent();  //BYTER SPELARE
    }

    public List<Question> getListOfQuestions(List<Question> listFromDatabase) {
        return listFromDatabase;
    }
}