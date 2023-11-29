package Server;

import java.io.IOException;

public class ServerGame extends Thread {
    ServerPlayer player1;
    ServerPlayer player2;
    ServerPlayer currentPlayer;
    Database db = new Database();
    String player1name;
    String player2name;

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
        String inputStringFromClient = "";
        String opponentName = "";

        while (true) {
            inputStringFromClient = currentPlayer.receiveString();
            opponentName = currentPlayer.getOpponent().receiveString();
            // debugg JOptionPane.showMessageDialog(null, inputStringFromClient + "FRÅN SERVERGAME");
            System.out.println("RAD33" + inputStringFromClient);
            if (inputStringFromClient.startsWith("Name:")) {
                player1name = inputStringFromClient.substring(5).trim(); //Spara namn
                player2name = inputStringFromClient.substring(5).trim();
                System.out.println(player1name + "Här är namnet");

                currentPlayer.setPlayer(player1name);
                currentPlayer.getOpponent().setPlayer(player2name);
                try {
                    currentPlayer.sendString("Category");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                //debugg JOptionPane.showMessageDialog(null, "Name received " + name);
            } else if (inputStringFromClient.trim().equals("History")) {
                System.out.println("I else if history");
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

