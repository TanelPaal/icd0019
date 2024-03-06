package inheritance.sender;

import java.time.LocalTime;

public class EmailLetterSender extends AbstractLetterSender {

    public EmailLetterSender(LocalTime currentTime) {
        super(currentTime);
    }

    public void sendLetter() {
        String greeting = "Good " + getTimeOfDayString();
        String contents = "Dead customer, ...";

        // simulate sending the email

        System.out.println("Sending email ...");
        System.out.println("Title: " + greeting);
        System.out.println("Text: " + contents);
    }
}