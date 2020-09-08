package com.itcrazy.alanmall.common.client.mail;

public class MailConfig {

	private String host; // 发件人的邮箱服务器地址
	private String from;
	private String password;
	private String[] to;
	private String subject;
	private String content;

	public String getHost() {
		return host;
	}

	public String getFrom() {
		return from;
	}

	public String getPassword() {
		return password;
	}

	public String[] getTo() {
		return to;
	}

	public String getSubject() {
		return subject;
	}

	public String getContent() {
		return content;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setTo(String[] to) {
		this.to = to;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
