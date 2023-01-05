
//Sending and generating OTP as a program without Functional decomposition
//To run this code first you have to download the  JavaMail API 1.4.7 
// link to download : https://www.oracle.com/java/technologies/java-archive-eepla-downloads.html#javamail-1.4.5-oth-JPR
package project;

import java.util.Properties;    
import javax.mail.*;    
import javax.mail.internet.*; 
import java.util.*;
class SendMail{  
    public static void send(final String from,final String password,final String to,String sub,String msg){  
          //Get properties object    
          Properties props = new Properties(); 
          props.put("mail.smtp.starttls.enable", "true");
          props.put("mail.smtp.host", "smtp.gmail.com");    
          props.put("mail.smtp.socketFactory.port", "587");    
          props.put("mail.smtp.socketFactory.class",    
                    "javax.net.ssl.SSLSocketFactory");    
          props.put("mail.smtp.auth", "true");    
          props.put("mail.smtp.port", "587");    
          props.put("mail.smtp.ssl.protocols", "TLSv1.2");
          //get Session   
          Session session = Session.getDefaultInstance(props,    
           new javax.mail.Authenticator() {    
           protected PasswordAuthentication getPasswordAuthentication() {    
           return new PasswordAuthentication(from,password);  
           }    
          });    
          //compose message    
          try {    
           MimeMessage message = new MimeMessage(session);    
           message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
           message.setSubject(sub);    
           message.setText(msg);    
           //send message  
           Transport.send(message);    
           System.out.println("message sent successfully");    
          } catch (MessagingException e) {throw new RuntimeException(e);}    
             
    }  
}  
public class Send_OTP{    
      public static void main(String[] args) {    
     //from,password,to,subject,message  
	  Random random = new Random();
      String s = "0123456789";
      String otp ="";

    int length = 6;
	for(int i=0;i<length;i++){
          int index = random.nextInt(9);
          otp += s.charAt(index);
      }
      
  
     Mailer.send("saurabhcs8802@gmail.com","ehxsvwmofwicxfhi","saurabhcs8802@dbatu.ac.in","OTP",otp);  
     //change from, password and to  
 }    
}
