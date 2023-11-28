package Server;

import java.io.IOException;
import java.net.ServerSocket;

public class ServerListener {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(44456);

        while (true) {

            try {
                ServerPlayer player1 = new ServerPlayer(ss.accept(), "Player1");
                ServerPlayer player2 = new ServerPlayer(ss.accept(),"Player2");
                ServerGame game = new ServerGame(player1, player2);
                game.start();

            } finally {
                ss.close();
            }
        }
    }
    //accepta anslutningar och starta game
}
