import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class StopWatch extends JFrame implements ActionListener {
    private Timer timer;
    private int seconds = 0;
    private boolean isRunning = false;
    private JLabel timeLabel = new JLabel("00:00:00");

    public StopWatch() {
        super("Stop Watch");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 100);
        timeLabel.setHorizontalAlignment(JLabel.CENTER);
        add(timeLabel);
        setVisible(true);
    }

    public void start() {
        if (timer == null) {
            timer = new Timer(1000, this);
            timer.start();
            isRunning = true;
        }
    }

    public void stop() {
        if (timer != null) {
            timer.stop();
            timer = null;
            isRunning = false;
        }
    }

    public void reset() {
        seconds = 0;
        updateDisplay();
    }

    private void updateDisplay() {
        int hours = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        int secs = seconds % 60;
        String time = String.format("%02d:%02d:%02d", hours, minutes, secs);
        timeLabel.setText(time);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        seconds++;
        updateDisplay();
    }

    public static void main(String[] args) {
        StopWatch stopwatch = new StopWatch();

        // Let the stopwatch run for 10 seconds
        stopwatch.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        stopwatch.stop();

        // Reset the stopwatch
        stopwatch.reset();
    }
}