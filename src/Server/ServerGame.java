package Server;

import javax.swing.*;

public class ServerGame extends Thread {
    ServerPlayer player1;
    ServerPlayer player2;
    ServerPlayer currentPlayer;
    Database db;

    public ServerGame(ServerPlayer player1, ServerPlayer player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
        this.player1.setOpponent(player2);
        this.player2.setOpponent(player1);
    }

    public void run() {

        player1.sendString("Ansluten");

        player2.sendString("Ansluten");

        //player1.sendString("Category");

        //currentPlayer = player1;
        String inputStringFromClient;

        while (true) {
            inputStringFromClient = currentPlayer.receiveString();
            JOptionPane.showMessageDialog(null, inputStringFromClient + "FRÅN SERVERGAME");

            if (inputStringFromClient.startsWith("Name:")) {
                String name = inputStringFromClient.substring(5).trim(); //Spara namn

                currentPlayer.setPlayer(name);
                currentPlayer.sendString("Category");
                JOptionPane.showMessageDialog(null, "Name received " + name);
            } else if (inputStringFromClient.equals("History")) {
                player1.sendObject(db.getHistory());
                player2.sendObject(db.getHistory());

            } else if (inputStringFromClient.equals("Music")) {
                player1.sendObject(db.getMusic());
                player2.sendObject(db.getMusic());
            }

            //if (inputStringFromClient.equals("Rätt"))


            //currentPlayer = currentPlayer.getOpponent();  //BYTER SPELARE
        }


        //currentPlayer = currentPlayer.getOpponent();  //BYTER SPELARE


    }


}

//ett spel emd båda spelarna

