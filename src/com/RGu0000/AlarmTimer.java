package com.RGu0000;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class AlarmTimer {
    Toolkit toolkit;
    Timer timer;
    private static boolean isRunning;
    private static int min1;
    private static int min2;
    private static int sec1;
    private static int sec2;
    private java.util.Random random = new java.util.Random();
    private SoundTask sound = new SoundTask();
    private TrayTask tray = new TrayTask();
    private PopupTask popup = new PopupTask();
    private String[] commentList = new String[]{"Sit straight!","Watch your back!","Did you forget about something?","So close...","How about a cup of tea?","You look like a shrimp :D"};

    public AlarmTimer() {
        toolkit = Toolkit.getDefaultToolkit();
        timer = new Timer();
    }

    public void setAlarm(long m1, long s1, long m2, long s2, boolean[] b) {
        isRunning = true;
        this.min1 = (int) m1;
        this.min2 = (int) m2;
        this.sec1 = (int) s1;
        this.sec2 = (int) s2;

        if (b[0]) {
            int i = random.nextInt((min2 - min1) * 60 * 1000 + (sec2 - sec1) * 1000) + min1 * 60 * 1000 + sec1 * 1000;
            timer.schedule(sound, i);
        }
        if (b[1]) {
            int i = random.nextInt((min2 - min1) * 60 * 1000 + (sec2 - sec1) * 1000) + min1 * 60 * 1000 + sec1 * 1000;
            timer.schedule(tray, i);
        }
        if (b[2]) {
            int i = random.nextInt((min2 - min1) * 60 * 1000 + (sec2 - sec1) * 1000) + min1 * 60 * 1000 + sec1 * 1000;
            timer.schedule(popup, i);
        }
    }

    public void StopTimer() {
        isRunning = false;
    }

    private void setSoundAlarm() {
        int i = random.nextInt((min2 - min1) * 60 * 1000 + (sec2 - sec1) * 1000) + min1 * 60 * 1000 + sec1 * 1000;
        timer.schedule(sound, i);
    }
    private void setPopupAlarm() {
        int i = random.nextInt((min2 - min1) * 60 * 1000 + (sec2 - sec1) * 1000) + min1 * 60 * 1000 + sec1 * 1000;
        timer.schedule(popup, i);
    }

    private void setTrayAlarm() {
        int i = random.nextInt((min2 - min1) * 60 * 1000 + (sec2 - sec1) * 1000) + min1 * 60 * 1000 + sec1 * 1000;
        timer.schedule(tray, i);
    }

    public class SoundTask extends TimerTask {
        public void run() {
            if (isRunning) {
                try {
                    AudioStream as = new AudioStream(getClass().getClassLoader().getResourceAsStream("notification.wav"));
                    AudioPlayer.player.start(as);
                    sound.cancel();
                    new AlarmTimer().setSoundAlarm();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                sound.cancel();
            }
        }
    }

    public class PopupTask extends TimerTask {
        public void run() {
            if (isRunning) {



                JFrame popupFrame = new JFrame();
                int i = random.nextInt(3);
                BufferedImage myPicture = null;
                try {
                    myPicture = ImageIO.read(getClass().getResource("/photo"+i+".jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                JLabel picLabel = new JLabel(new ImageIcon(myPicture));
                popupFrame.add(picLabel);
                popupFrame.setVisible(true);
                popupFrame.setResizable(false);
                popupFrame.setAlwaysOnTop(true);
                popupFrame.pack();
                popupFrame.setLocationRelativeTo(null);
                popupFrame.toFront();
                popup.cancel();
                new AlarmTimer().setPopupAlarm();

            } else {
                popup.cancel();
            }
        }
    }

    public class TrayTask extends TimerTask {
        public void run() {
            if (isRunning) {
                try{
                    int i = random.nextInt(commentList.length);
                    StraightBack.trayIcon.displayMessage("", commentList[i], TrayIcon.MessageType.INFO);
                    tray.cancel();
                    new AlarmTimer().setTrayAlarm();
                }
                catch(NullPointerException npe){
                    npe.getStackTrace();
                }
            } else {
                tray.cancel();
            }
        }
    }
}













