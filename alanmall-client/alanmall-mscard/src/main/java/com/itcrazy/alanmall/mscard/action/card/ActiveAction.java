package com.itcrazy.alanmall.mscard.action.card;

import com.itcrazy.alanmall.common.client.file.SysConfig;
import com.itcrazy.alanmall.common.client.util.MD5Util;
import com.itcrazy.alanmall.common.client.util.RandomNumUtil;
import com.itcrazy.alanmall.mscard.action.base.InterfaceBaseAction;
import com.itcrazy.alanmall.mscard.model.MemberLevel;
import com.itcrazy.alanmall.mscard.model.RegisteredCard;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

/**
 * 5i实体卡激活
 *
 * @author zhangli
 *
 */
public class ActiveAction extends InterfaceBaseAction {
	private static final long serialVersionUID = 1832862343555997350L;

	private RegisteredCard registeredCard;

	private static Log log=LogFactory.getLog(ActiveAction.class);
	public static String sendUrl(String urlStr, String params) {
		log.info(urlStr + "?" + params);
		PrintWriter out = null;
		BufferedReader in = null;
		StringBuffer result = new StringBuffer();
		try {
			URL realUrl = new URL(urlStr);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			out.print(params);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream(),"UTF-8"));
			String line = "";
			while ((line = in.readLine()) != null) {
				result.append(line);
			}
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
					out = null;
				}
				if (in != null) {
					in.close();
					in = null;
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return result.toString();
	}

	/**
	 * 获取会员等级
	 * @return
	 */
	public String getActiveList(){
		String interfaceUrl = SysConfig.getCommonConf("INTERFACE_5IMEISHI");
		String userName = SysConfig.getCommonConf("INTERFACE_USERNAME");
		String password = SysConfig.getCommonConf("INTERFACE_PASSWORD");

		String urlStr = interfaceUrl + "/erp/getMemberLevel.action";
		Long t = System.currentTimeMillis() / 1000;
		String random = RandomNumUtil.getCharacterAndNumber(4);
		String s = MD5Util.MD5(password + random);
		String content = "<xml><MsgType><![CDATA[searchMemberLevel]]></MsgType>" +
				"<StoreId><![CDATA[" +  user.getStoreId() + "]]></StoreId><Self>true</Self></xml>";
		String params = "username=" + userName + "&randomnum=" + random + "&timestamp=" +
				t + "&signature=" + MD5Util.MD5(s + t) + "&content=" + content;

		String retValue = sendUrl(urlStr, params);
		if(!StringUtils.isBlank(retValue)) {
			JSONObject jObject = JSONObject.fromObject(retValue);

			List<MemberLevel> memberList = (List<MemberLevel>) JSONArray.toCollection(JSONArray.fromObject(jObject.get("memberLevelList")), MemberLevel.class);
			pageData.rows = memberList;
			JSONObject resultVal = (JSONObject) jObject.get("result");
			result.setCode((Integer)resultVal.get("code"));
			result.setMsg((String)resultVal.get("msg"));
		}else {
			result.setCode(1);
			result.setMsg("未取到会员等级数据");
		}

		return SUCCESS;
	}

	/**
	 * 5i实体卡激活
	 * @return
	 */
	public String updateActive(){
		String interfaceUrl = SysConfig.getCommonConf("INTERFACE_5IMEISHI");
		String userName = SysConfig.getCommonConf("INTERFACE_USERNAME");
		String password = SysConfig.getCommonConf("INTERFACE_PASSWORD");

		String urlStr = interfaceUrl + "/erp/activateCardMember.action";
		Long t = System.currentTimeMillis() / 1000;
		String random = RandomNumUtil.getCharacterAndNumber(4);
		String s = MD5Util.MD5(password + random);
		String content = "<xml><MsgType><![CDATA[activateCardMember]]></MsgType>" +
				"<StoreId><![CDATA[" + user.getStoreId() + "]]></StoreId>" +
				"<Code><![CDATA[" + registeredCard.getCardNo() + "]]></Code>" +
				"<MemberLevelId><![CDATA[" + registeredCard.getMemberLevelId() + "]]>" +
				"</MemberLevelId><Self>true</Self></xml>";
		String params = "username=" + userName + "&randomnum=" + random + "&timestamp=" +
				t + "&signature=" + MD5Util.MD5(s + t) + "&content=" + content;

		String retValue = sendUrl(urlStr, params);
		JSONObject jObject = (JSONObject)JSONObject.fromObject(retValue).get("result");

		result.setCode((Integer)jObject.get("code"));
		result.setMsg((String)jObject.get("msg"));
		return SUCCESS;
	}

	public RegisteredCard getRegisteredCard() {
		return registeredCard;
	}

	public void setRegisteredCard(RegisteredCard registeredCard) {
		this.registeredCard = registeredCard;
	}

}
