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
    String name;

    public ServerGame(ServerPlayer player1, ServerPlayer player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
        this.player1.setOpponent(player2);
        this.player2.setOpponent(player1);
    }

    public void run() {

        try {
            player1.sendString("Ansluten");
            player2.sendString("Ansluten");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        //player1.sendString("Category");
        //currentPlayer = player1;
        
        
        String inputStringFromPlayer1 = "";
        String inputStringFromPlayer2 = "";

        while (true) {
            inputStringFromPlayer1 = currentPlayer.receiveString();
            //inputStringFromPlayer2 = currentPlayer.getOpponent().receiveString();

            // debugg JOptionPane.showMessageDialog(null, inputStringFromClient + "FRÅN SERVERGAME");
            System.out.println("RAD33" + inputStringFromPlayer1);

            if (inputStringFromPlayer1.startsWith("Name:")) {
                name = inputStringFromPlayer1.substring(5).trim(); //Spara namn
                currentPlayer.setPlayer(name);
                System.out.println(name + "Här är namnet spelare 1");

                //name = inputStringFromPlayer2.substring(5).trim();
                currentPlayer.getOpponent().setPlayer(name);
                System.out.println(name + "Här är namnet spelare 2");

                try {
                    currentPlayer.sendString("Category");
                    currentPlayer.getOpponent().sendString("Wait");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                //debugg JOptionPane.showMessageDialog(null, "Name received " + name);


            } else if (inputStringFromPlayer1.trim().equalsIgnoreCase("History")) {
                System.out.println("Inuti else if equals(History)");
                player1.sendObject(db.getHistory());
               // player2.sendObject(db.getHistory());

            } else if (inputStringFromPlayer1.equals("Music")) {
                player1.sendObject(db.getMusic());
                player2.sendObject(db.getMusic());
            }

            //if (inputStringFromClient.equals("Rätt"))


            //currentPlayer = currentPlayer.getOpponent();  //BYTER SPELARE
        }


        //currentPlayer = currentPlayer.getOpponent();  //BYTER SPELARE
    }

    public List<Question> getListOfQuestions (List<Question> listFromDatabase){
        return listFromDatabase;
    }
}


//ett spel emd båda spelarna

