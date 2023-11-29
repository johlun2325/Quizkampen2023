
package Client;

import javax.swing.Timer;

public class TimerClass {
    public Timer timer;
    public int timeRemaining;

    public GameGUI gamegui;

    public TimerClass() {
        timeRemaining = 20;

        timer = new Timer(1000, e -> {
            if (timeRemaining >0) {
                timeRemaining--;
            } else {

               timer.stop();
            }
        });
    }

    public void startTimer() {
        timeRemaining = 20;
        timer.start();
    }

    public int getTimeRemaining() {
        return timeRemaining;
    }
}
