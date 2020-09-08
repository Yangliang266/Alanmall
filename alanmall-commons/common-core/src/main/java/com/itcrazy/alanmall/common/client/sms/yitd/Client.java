package com.itcrazy.alanmall.common.client.sms.yitd;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.net.URLEncoder;

/**
 * 壹通道
 * <p>
 * <date>2012-03-01</date><br/>
 * <span>软维提供的JAVA接口信息（短信，彩信）调用API</span><br/>
 * <span>----------发送短信 & 查询余额-------------</span>
 * </p>
 * 
 * @author LIP
 * @version 1.0.1
 */
public class Client {

	/**
	 * 短信发送&余额获取接口URL
	 */
	// private static final String SMS_URL =
	// "http://120.76.213.253:8888/sms.aspx";
	private static final String SMS_URL = "http://ytd.yitd.cn/sms.aspx";

	/**
	 * 用户ID
	 */
	private String uid;

	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 密码
	 */
	private String password;

	public Client(String _uid, String _username, String _password) {
		this.uid = _uid;
		this.username = _username;
		this.password = _password;
	}

	/**
	 * <p>
	 * <date>2012-03-01</date><br/>
	 * <span>发送信息方法1--必须传入必填内容</span><br/>
	 * <p>
	 * 其一：发送方式，默认为POST<br/>
	 * 其二：发送内容编码方式，默认为UTF-8
	 * </p>
	 * <br/>
	 * </p>
	 * 
	 * @param mobile
	 *            ：必填--发送的手机号码，多个可以用逗号隔比如>13512345678,13612345678
	 * @param content
	 *            ：必填--实际发送内容，
	 * @return 返回发送信息之后返回字符串
	 */
	public String sendSms(String mobile, String content) {

		return sendSms(mobile, content, null, null, null, null, null, null,
				null, "POST", "UTF-8", "UTF-8");
	}

	/**
	 * <p>
	 * <date>2012-03-01</date><br/>
	 * <span>发送信息方法--暂时私有化，这里仅仅是提供用户接口而已。其实用不了那么复杂</span><br/>
	 * <span>发送信息最终的组合形如：http://118.145.30.35/sms.aspx?action=send</span>
	 * </p>
	 * 
	 * @param mobile
	 *            ：必填--发送的手机号码，多个可以用逗号隔比如>13512345678,13612345678
	 * @param content
	 *            ：必填--实际发送内容，
	 * @param action
	 *            ：选填--访问的事件，默认为send
	 * @param sendTime
	 *            ：选填--定时发送时间，不填则为立即发送，时间格式如>2011-11-11 11:11:11
	 * @param checkContent
	 *            ：选填--检查是否包含非法关键字，1--表示需要检查，0--表示不检查
	 * @param taskName
	 *            ：选填--任务名称，本次任务描述，100字内
	 * @param countNumber
	 *            ：选填--提交号码总数
	 * @param mobileNumber
	 *            ：选填--手机号码总数
	 * @param telephoneNumber
	 *            ：选填--小灵通（和）或座机总数
	 * @param sendType
	 *            ：选填--发送方式，默认为POST
	 * @param codingType
	 *            ：选填--发送内容编码方式，默认为UTF-8
	 * @param backEncodType
	 *            ：选填--返回内容编码方式，默认为UTF-8
	 * @return 返回发送之后收到的信息
	 */
	private String sendSms(String mobile, String content, String action,
			String sendTime, String checkContent, String taskName,
			String countNumber, String mobileNumber, String telephoneNumber,
			String sendType, String codingType, String backEncodType) {

		try {
			if (codingType == null || codingType.equals("")) {
				codingType = "UTF-8";
			}
			if (backEncodType == null || backEncodType.equals("")) {
				backEncodType = "UTF-8";
			}
			StringBuffer send = new StringBuffer();
			if (action != null && !action.equals("")) {
				send.append("action=").append(action);
			} else {
				send.append("action=send");
			}

			send.append("&userid=").append(uid);
			send.append("&account=").append(
					URLEncoder.encode(username, codingType));
			send.append("&password=").append(
					URLEncoder.encode(password, codingType));
			send.append("&mobile=").append(mobile);
			send.append("&content=").append(
					URLEncoder.encode(content, codingType));
			if (sendTime != null && !sendTime.equals("")) {
				send.append("&sendTime=").append(
						URLEncoder.encode(sendTime, codingType));
			}
			if (checkContent != null && !checkContent.equals("")) {
				send.append("&checkContent=").append(checkContent);
			}
			if (taskName != null && !taskName.equals("")) {
				send.append("&taskName=").append(
						URLEncoder.encode(taskName, codingType));
			}
			if (countNumber != null && !countNumber.equals("")) {
				send.append("&countNumber=").append(countNumber);
			}
			if (mobileNumber != null && !mobileNumber.equals("")) {
				send.append("&mobileNumber=").append(mobileNumber);
			}
			if (telephoneNumber != null && !telephoneNumber.equals("")) {
				send.append("&telephoneNumber=").append(telephoneNumber);
			}

			if (sendType != null && (sendType.toLowerCase()).equals("get")) {
				return SmsClientAccessTool.getInstance().doAccessHTTPGet(
						SMS_URL + "?" + send.toString(), backEncodType);
			} else {
				return SmsClientAccessTool.getInstance().doAccessHTTPPost(
						SMS_URL, send.toString(), backEncodType);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "未发送，编码异常";
		}
	}

	/**
	 * <p>
	 * <date>2012-03-01</date><br/>
	 * <span>余额获取方法</span><br/>
	 * <p>
	 * 其一：发送方式，默认为POST<br/>
	 * 其二：发送内容编码方式，默认为UTF-8
	 * </p>
	 * <br/>
	 * </p>
	 * 
	 * @return 返回余额查询字符串
	 */
	public String queryOverage() {
		try {
			StringBuffer sendParam = new StringBuffer();
			sendParam.append("action=overage");
			sendParam.append("&userid=").append(uid);
			sendParam.append("&account=").append(
					URLEncoder.encode(username, "UTF-8"));
			sendParam.append("&password=").append(
					URLEncoder.encode(password, "UTF-8"));

			String rs = SmsClientAccessTool.getInstance().doAccessHTTPPost(
					SMS_URL, sendParam.toString(), "UTF-8");
			if (StringUtils.isNotBlank(rs)) {
				try {
					Document doc = DocumentHelper.parseText(rs);
					Element rootElt = doc.getRootElement();
					String reStatus = rootElt.elementText("returnstatus");
					if ("Success".equalsIgnoreCase(reStatus)
							|| "Sucess".equalsIgnoreCase(reStatus)) {// 服务商拼写错误：Sucess
						String overage = rootElt.elementText("overage");
						return overage;
					} else {
						String msg = rootElt.elementText("message");
						return msg;
					}
				} catch (DocumentException e) {
					e.printStackTrace();
					return "返回XML结果格式错误";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "异常-->" + e.getMessage();
		}
		return "";
	}

	public static void main(String[] args) {
		Client c = new Client("2143", "tltshy", "Mn10vJvt");
		String rs = c.queryOverage();
		System.out.println(rs);
		// 营销账户：ID：2452 账户名：tltstyx ，密码：b1Goen
		c = new Client("2452", "tltstyx", "b1Goen");
		rs = c.queryOverage();
		System.out.println(rs);
		rs = c.sendSms("15900552799", "【5i美食】测试营销短信");
		System.out.println(rs);
	}
}
