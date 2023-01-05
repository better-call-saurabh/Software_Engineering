//Implementation OTP assignment as per OOP design described in classroom

//To run this code first you have to download the  JavaMail API 1.4.7 
// link to download : https://www.oracle.com/java/technologies/java-archive-eepla-downloads.html#javamail-1.4.5-oth-JPR

package project;

import java.util.Random;
import java.util.List;
import java.util.Properties;
import java.util.ArrayList;
import java.util.Date;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

// Class to represent an OTP
class OTP {
  private String value;
  private Date expiration;

  public OTP(String value, Date expiration) {
    this.value = value;
    this.expiration = expiration;
  }

  public String getValue() {
    return value;
  }

  public Date getExpiration() {
    return expiration;
  }
}

// Class to manage OTPs
class OTPManager {
  private List<OTP> otps;

  public OTPManager() {
    otps = new ArrayList<OTP>();
  }

  // Generate a new OTP and add it to the list
  public OTP generateOTP(Date expiration) {
    Random rand = new Random();
    String value = String.format("%06d", rand.nextInt(1000000));
    OTP otp = new OTP(value, expiration);
    otps.add(otp);
    return otp;
  }

  // Send an OTP to the recipient via email
  public void sendOTP(OTP otp, String recipientEmail) throws MessagingException {
    // Set up the email message
    MimeMessage message = new MimeMessage(Session.getDefaultInstance(new Properties()));
    message.setFrom(new InternetAddress("saurabhcs8802@gmail.com"));
    message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));
    message.setSubject("One_Time_app_password");
    message.setText("Your OTP is: " + otp.getValue());

    // Send the email
    Transport.send(message);
  }
  public static void main(String[] args) {
	    OTPManager otpManager = new OTPManager();
	    Date expiration = new Date(System.currentTimeMillis() + 1 * 60 * 1000); // OTP expires in 1 minutes
	    OTP otp = otpManager.generateOTP(expiration);
	    try {
	      otpManager.sendOTP(otp, "saurabhcs8802@dbatu.ac.in");
	    } catch (MessagingException e) {
	      System.out.println("Error sending OTP: " + e.getMessage());
	    }
	  }
}
