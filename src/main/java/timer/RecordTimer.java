package timer;

import button.DesignedButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static util.Constants.TOMATO_RED;

public class RecordTimer{
    private int recordedSeconds = 0;
    private Timer recordTimer;

    public RecordTimer(DesignedButton btn) {
        recordTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recordedSeconds++;
                if(recordedSeconds % 2 == 0) {
                    btn.setForeground(TOMATO_RED);
                } else {
                    btn.setForeground(Color.BLACK);
                }
                System.out.println(recordedSeconds);
            }
        });
    }

    public int getSecond() {
        return recordedSeconds;
    }

    public void start() {
        recordTimer.start();
    }

    public void stop() {
        recordTimer.stop();
    }

}
