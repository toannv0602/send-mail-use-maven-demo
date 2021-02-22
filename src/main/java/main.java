
import java.util.*;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.*;
public class main {
    private static String USER_NAME = "toante0602cris@gmail.com";  // GMail user name (just the part before "@gmail.com")
    private static String PASSWORD = "jbllhkdoxjcllelq"; // GMail password zcwduspusxlwyafr
    private static String RECIPIENT = "toanvan2000t@gmail.com";
    private static Logger LOGGER = Logger.getLogger(main.class.getName());
    public static void main(String[] args) {
        String from = USER_NAME;
        String pass = PASSWORD;
        String to = RECIPIENT; // list oaf recipient email addresses
        String subject = "Thông báo từ HOU";
        String body = "Chúc mừng bạn đã trúng tuyển HOU \n Mời bạn truy cập vào link dưới đây:\n http://elc.ehou.edu.vn/";
        System.out.println(body);
        //LOGGER.info(body);
    //        sendFromGMail(from, pass, to, subject, body);
    }

    private static void sendFromGMail(String from, String pass, String to, String subject, String body) {
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        // lay doi tuong session mac  dinh
        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(from));
            InternetAddress toAddress = new InternetAddress(to);

//            // To get the array of addresses
//            for( int i = 0; i < to.length; i++ ) {
//                toAddress[i] = new InternetAddress(to[i]);
//            }

//            for( int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress);
//            }

            message.setSubject(subject);
            message.setText(body);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (AddressException ae) {
            ae.printStackTrace();
        }
        catch (MessagingException me) {
            me.printStackTrace();
        }
    }
}
