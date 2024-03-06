package inheritance.sender;

import org.junit.Test;

import java.time.LocalTime;

public class Runner {

    @Test
    public void sendEmailOnMorning() {
        new EmailLetterSender(LocalTime.parse("10:00")).sendLetter();
    }

    @Test
    public void sendEmailOnAfternoon() {
        new EmailLetterSender(LocalTime.parse("12:30")).sendLetter();
    }

    @Test
    public void sendSmsOnEvening() {
        new SmsLetterSender(LocalTime.parse("19:30")).sendLetter();
    }

}
