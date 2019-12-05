package cn.fzkj.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

//邮件发送
public class MailUtils {

	/**
	 * 发送邮件
	 * 
	 * @param to：收件人
	 * @param code：激活码
	 */
	public static void sendMail(String to, String code) {
		/**
		 * 1.获得一个Session对象 2.创建一个代理对象Message 3.发送邮件Tansport
		 */
		// 获得连接对象
		Properties props = new Properties();
		props.setProperty("mail.host", "localhost");
		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication("mrStudio@mr.com", "111");
			}
		});

		// 2.创建邮件对象
		Message message = new MimeMessage(session);

		try {
			// 设置发件人
			message.setFrom(new InternetAddress("mrStudio@mr.com"));
			// 设置收件人
			message.addRecipient(RecipientType.TO, new InternetAddress(to));
			// 设置标题
			message.setSubject("来自莫冉工作室的官方邮件...");
			// 设置正文
			message.setContent(
					"<h1>莫冉工作室官方邮件...</h1><br><h2><font color='red'>点此链接完成账号激活操作！</font></h2><h3><a href='http://127.0.0.1:8080/ssmshop/user_Active.action?code="
							+ code + "'>http://127.0.0.1:8080/ssmshop/user_Active.action?code=" + code + "</a></h3>",
					"text/html;charset=UTF-8");
			// 3.发送邮件:
			Transport.send(message);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
