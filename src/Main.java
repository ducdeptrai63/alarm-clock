import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        LocalTime alarmTime = null;
        LocalDateTime now = null;
        LocalDateTime alarmDateTime = null;

        String filePath = "resources/3dabrar-funny-alarm-317531.wav";

        while (alarmTime == null) {
            try {
                System.out.print("Enter alarm time (HH:mm:ss): ");
                String inputTime = scanner.nextLine();

                alarmTime = LocalTime.parse(inputTime, formatter); // convert string to LocalTime object
                System.out.println("Alarm set for " + alarmTime.format(formatter));

                now = LocalDateTime.now();
                alarmDateTime = LocalDateTime.of(now.toLocalDate(), alarmTime); // combine date and time
            } catch (DateTimeParseException e) {
                System.out.println("Invalid time format. Please try again.");
            }
        }

        Thread thread = new Thread(new AlarmClock(alarmDateTime, filePath));
        thread.start();

        scanner.close();
    }
}
