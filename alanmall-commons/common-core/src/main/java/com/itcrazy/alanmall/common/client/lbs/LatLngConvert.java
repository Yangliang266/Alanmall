package com.itcrazy.alanmall.common.client.lbs;

import sun.misc.BASE64Decoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.text.ParseException;

/**
 * 不同
 */
@SuppressWarnings("restriction")
public class LatLngConvert {
	public static void main(String args[]) throws ParseException {
		LatLng ll = new LatLng();
		ll.setLat(39.90923);
		ll.setLng(116.397428);
		LatLng l = gps2BaiDu(ll);
		System.out.println(l.getLat() + "  " + l.getLng());
	}

	public static LatLng gps2BaiDu(LatLng latLng) {
		if (latLng == null || latLng.getLat() == null
				|| latLng.getLng() == null || latLng.getLat() < 10
				|| latLng.getLng() < 10) {
			return null;
		}
		Socket s = null;
		try {
			s = new Socket("api.map.baidu.com", 80);
			BufferedReader br = new BufferedReader(new InputStreamReader(
					s.getInputStream(), "UTF-8"));
			OutputStream out = s.getOutputStream();
			StringBuffer sb = new StringBuffer(
					"GET /ag/coord/convert?from=0&to=4");
			sb.append("&x=" + latLng.getLng() + "&y=" + latLng.getLat());
			sb.append("&callback=BMap.Convertor.cbk_3976 HTTP/1.1\r\n");
			sb.append("User-Agent: Java/1.6.0_20\r\n");
			sb.append("Host: api.map.baidu.com:80\r\n");
			sb.append("Accept: text/html, image/gif, image/jpeg, *; q=.2, */*; q=.2\r\n");
			sb.append("Connection: Close\r\n");
			sb.append("\r\n");
			out.write(sb.toString().getBytes());
			String json = "";
			String tmp = "";
			while ((tmp = br.readLine()) != null) {
				// System.out.println(tmp);
				json += tmp;
			}

			int start = json.indexOf("cbk_3976");
			int end = json.lastIndexOf("}");
			if (start != -1 && end != -1 && json.contains("\"x\":\"")) {
				json = json.substring(start, end);
				String[] point = json.split(",");
				String x = point[1].split(":")[1].replace("\"", "");
				String y = point[2].split(":")[1].replace("\"", "");
				String sx = new String(decode(x));
				String sy = new String(decode(y));
				LatLng ll = new LatLng();

				ll.setLat(Double.valueOf(sy));
				ll.setLng(Double.valueOf(sx));
				return ll;
			} else {
				System.out.println("gps坐标无效！！");
			}
			out.close();
			br.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (s != null) {
				try {
					s.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		return null;

	}

	/**
	 * 解码
	 *
	 * @param str
	 * @return string
	 */
	public static byte[] decode(String str) {

		byte[] bt = null;

		try {

			BASE64Decoder decoder = new BASE64Decoder();
			bt = decoder.decodeBuffer(str);
			// System.out.println(new String (bt));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return bt;
	}

}