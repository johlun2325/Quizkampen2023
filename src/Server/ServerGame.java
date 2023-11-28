package Server;

public class ServerGame extends Thread {
    ServerPlayer player1;
    ServerPlayer player2;
    ServerPlayer currentPlayer;
    Database db;

    public ServerGame (ServerPlayer player1, ServerPlayer player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
        this.player1.setOpponent(player2);
        this.player2.setOpponent(player1);
    }

    public void run() {

        player1.sendString("Ansluten");

        player2.sendString("Ansluten");

        player1.sendString("Kategori");

        //currentPlayer = player1;
        String inputStringFromClient;

        while (true) {
            inputStringFromClient = currentPlayer.receiveString();

            if (inputStringFromClient.startsWith("Name")) {
                currentPlayer.setPlayer(inputStringFromClient.substring(4)); //Spara namn

                currentPlayer.sendString("Kategori");

                if (inputStringFromClient.equals("Music") || inputStringFromClient.equals("History")) {
                    //prepareSendingQuestions()
                    //player1.sendString(db.getHistory());
                    player2.sendString("Music,History");

                }




                currentPlayer = currentPlayer.getOpponent();  //BYTER SPELARE
            }


            currentPlayer = currentPlayer.getOpponent();  //BYTER SPELARE


        }





    }

    //ett spel emd båda spelarna
}
