package com.itcrazy.alanmall.common.client.lbs;

import com.itcrazy.alanmall.common.client.util.HttpRequest;

import java.util.HashMap;
import java.util.Map;

public class BaiDuAddress {

	public static String getAddressByLngLat(Double lng, Double lat) {
		String url = "http://api.map.baidu.com/geocoder/v2/?ak="
				+ BaiDuConfig.KEY_FOR_SERVER
				+ "&callback=renderReverse&location=" + lat + "," + lng
				+ "&output=xml&pois=1";
		String address = HttpRequest.sendUrl(url, null);
		String name = address.substring(address.indexOf("<name>") + 6,
				address.indexOf("</name>"));
		return name;
	}

	public static Map<String, String> getAddressMapByLngLat(Double lng,
			Double lat) {
		Map<String, String> map = new HashMap<String, String>();
		String url = "http://api.map.baidu.com/geocoder/v2/?ak="
				+ BaiDuConfig.KEY_FOR_SERVER
				+ "&callback=renderReverse&location=" + lat + "," + lng
				+ "&output=xml&pois=1";
		String address = HttpRequest.sendUrl(url, null);
		// String name=address;//district,city,province
		String province = address.substring(address.indexOf("<province>") + 10,
				address.indexOf("</province>"));
		map.put("province", province);
		String city = address.substring(address.indexOf("<city>") + 6,
				address.indexOf("</city>"));
		map.put("city", city);
		String district = address.substring(address.indexOf("<district>") + 10,
				address.indexOf("</district>"));
		map.put("district", district);
		return map;
	}

	public static void main(String[] args) {
		Map<String, String> map = BaiDuAddress.getAddressMapByLngLat(
				121.5281834416, 31.2276);
		System.out.println(map.get("province"));
		System.out.println(map.get("city"));
		System.out.println(map.get("district"));
	}
}
