package inheritance.sender;

import java.time.LocalTime;

public class SmsLetterSender extends AbstractLetterSender {

    public SmsLetterSender(LocalTime currentTime) {
        super(currentTime);
    }

    public void sendLetter() {
        String greeting = "Good " + getTimeOfDayString();
        String contents = "Dead customer, ...";

        // simulate sending the sms

        System.out.println("Sending sms ...");
        System.out.println("Title: " + greeting);
        System.out.println("Text: " + contents);
    }
}
