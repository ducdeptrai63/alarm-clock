import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AlarmClock implements Runnable {
    private LocalDateTime alarmDateTime;
    private final String filePath;

    public AlarmClock(LocalDateTime alarmDateTime, String filePath) {
        this.alarmDateTime = alarmDateTime;
        this.filePath = filePath;
    }

    @Override
    public void run() {
        LocalDateTime now = LocalDateTime.now();

        // plus one day if the alarm time is before the current time
        if (alarmDateTime.isBefore(now)) {
            alarmDateTime = alarmDateTime.plusDays(1);
        }

        long timeRemaining = 0;
        long sleepTime = 0;

        while (true) {
            now = LocalDateTime.now();

            System.out.printf("\r%02d:%02d:%02d",
                    now.getHour(), now.getMinute(), now.getSecond());

            if (now.isAfter(alarmDateTime) || now.isEqual(alarmDateTime)) {
                break;
            }

            timeRemaining = Duration.between(now, alarmDateTime).toMillis();
            sleepTime = timeRemaining > 1000 ? 1000 : timeRemaining;

            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted");
                return;
            }
        }

        System.out.println("\nAlarm sound!");
        playSound(filePath);
    }

    private void playSound(String filePath) {
        File audioFile = new File(filePath);

        if (!audioFile.exists()) {
            System.out.println("Audio file not found");
            return;
        }

        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

            // get audio format and info
            javax.sound.sampled.AudioFormat format = audioStream.getFormat();
            javax.sound.sampled.DataLine.Info info = new javax.sound.sampled.DataLine.Info(Clip.class, format);

            if (!AudioSystem.isLineSupported(info)) {
                System.out.println("Audio line not supported");
                return;
            }

            // get clip
            Clip clip = (Clip) AudioSystem.getLine(info);
            clip.open(audioStream);
            clip.start();

            // wait for the sound to finish
            Thread.sleep(clip.getMicrosecondLength() / 1000);

            clip.close();
            audioStream.close();

        } catch (UnsupportedAudioFileException e) {
            System.out.println("Unsupported audio file");
        } catch (IOException e) {
            System.out.println("Error reading audio file");
        } catch (LineUnavailableException e) {
            System.out.println("Audio line unavailable");
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted");
        }
    }
}
