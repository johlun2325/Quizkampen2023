
package Client;

import javax.swing.Timer;

public class TimerClass {
    public Timer timer;
    public int timeRemaining;

    public GameGUI gamegui;

    public TimerClass() {
        timeRemaining = 30;

        timer = new Timer(1000, e -> {
            if (timeRemaining > 0) {
                timeRemaining--;
            } else {
                // Restart the timer without stopping it
               timer.stop();
            }
        });
    }

    public void startTimer() {
        timeRemaining = 30;
        timer.start();
    }

    public int getTimeRemaining() {
        return timeRemaining;
    }
}
