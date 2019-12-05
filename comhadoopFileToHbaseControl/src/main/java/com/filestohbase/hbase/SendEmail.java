package com.filestohbase.hbase;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class SendEmail {
    static String mailFrom = null;// 指明邮件的发件人
    static String password_mailFrom = null;// 指明邮件的发件人登陆密码
    static String mailTo = null;	// 指明邮件的收件人
    static String mailTittle = null;// 邮件的标题
    static String mailText =null;	// 邮件的文本内容
    static String mail_host =null;	// 邮件的服务器域名
    // 测试用
//    public static void main(String[] args) throws Exception {
//        SendEmail sendmail = new SendEmail();
//        Tomail(sendmail,"nihao");
//
//    }
//
//    public static void Tomail(SendEmail sendemail,String mailtext){
//        sendemail.mailFrom = "InformError@163.com";
//        sendemail.password_mailFrom="NLP111111";
//        sendemail.mailTo = "InformError@163.com";
//        sendemail.mailTittle="ERROR !!!";
//        sendemail.mailText = "test";
//        sendemail.mail_host="smtp.163.com";
//
//        try {
//            Properties prop = new Properties();
//            prop.setProperty("mail.host", sendemail.mail_host);
//            prop.setProperty("mail.transport.protocol", "smtp");
//            prop.setProperty("mail.smtp.auth", "true");
//
//            // 使用JavaMail发送邮件的5个步骤
//
//            // 1、创建session
//            Session session = Session.getInstance(prop);
//            // 开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
//            session.setDebug(true);
//            // 2、通过session得到transport对象
//            Transport ts = session.getTransport();
//            // 3、使用邮箱的用户名和密码连上邮件服务器，发送邮件时，发件人需要提交邮箱的用户名和密码给smtp服务器，用户名和密码都通过验证之后才能够正常发送邮件给收件人。
//            ts.connect(sendemail.mail_host,sendemail.mailFrom, sendemail.password_mailFrom);
//            // 4、创建邮件
//            Message message = createSimpleMail(session,sendemail.mailFrom,sendemail.mailTo,sendemail.mailTittle,sendemail.mailText);
//            // 5、发送邮件
//            ts.sendMessage(message, message.getAllRecipients());
//            ts.close();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//    }

    /**
     * @Method: createSimpleMail
     * @Description: 创建一封只包含文本的邮件
     */
    public static MimeMessage createSimpleMail(Session session, String mailfrom, String mailTo, String mailTittle,
                                               String mailText) throws Exception {
        // 创建邮件对象
        MimeMessage message = new MimeMessage(session);
        // 指明邮件的发件人
        message.setFrom(new InternetAddress(mailfrom));
        // 指明邮件的收件人，现在发件人和收件人是一样的，那就是自己给自己发
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(mailTo));
        // 邮件的标题
        message.setSubject(mailTittle);
        // 邮件的文本内容
        message.setContent(mailText, "text/html;charset=UTF-8");
        // 返回创建好的邮件对象
        return message;
    }

}
