package com.itcrazy.alanmall.common.client.mail;

import com.itcrazy.alanmall.common.client.file.SysConfig;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class MailSendUtil {
	public static void send(MailConfig mailConfig) throws MessagingException {

		String host = SysConfig.getCommonConf("mail.host").trim();
		String from = SysConfig.getCommonConf("mail.from").trim();
		String pass = SysConfig.getCommonConf("mail.password").trim();

		// String[] to = SysConfig.getCommonConf("mail.to").split(","); // 在本行添加

		Properties props = System.getProperties();
		props.put("mail.smtp.starttls.enable", "true"); // 在本行添加
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.user", from);
		props.put("mail.smtp.password", pass);
		props.put("mail.smtp.auth", "true"); // 需要请求认证

		Session session = Session.getDefaultInstance(props, null);
		MimeMessage message = new MimeMessage(session);

		message.setFrom(new InternetAddress(from));

		InternetAddress[] toAddress = new InternetAddress[mailConfig.getTo().length];

		// 获取地址的array
		for (int i = 0; i < mailConfig.getTo().length; i++) { // 从while循环更改而成
			toAddress[i] = new InternetAddress(mailConfig.getTo()[i]);
		}

		for (int i = 0; i < toAddress.length; i++) { // 从while循环更改而成
			message.addRecipient(Message.RecipientType.TO, toAddress[i]);
		}
		message.setSubject(mailConfig.getSubject());

		// MiniMultipart类是一个容器类，包含MimeBodyPart类型的对象
		Multipart mainPart = new MimeMultipart();
		// 创建一个包含HTML内容的MimeBodyPart
		BodyPart html = new MimeBodyPart();
		// 设置HTML内容 建立第一部分： 文本正文
		html.setContent(mailConfig.getContent(), "text/html; charset=utf-8");
		mainPart.addBodyPart(html);
		// 将MiniMultipart对象设置为邮件内容 建立第二部分：附件
		message.setContent(mainPart);

		// message.setText(content);
		Transport transport = session.getTransport("smtp"); // 使用smtp协议

		transport.connect(host, from, pass);
		transport.sendMessage(message, message.getAllRecipients());
		transport.close();
	}

}
