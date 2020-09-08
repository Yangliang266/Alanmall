package com.itcrazy.alanmall.common.client.lbs;

import com.itcrazy.alanmall.common.client.util.HttpRequest;

/**
 * 计算地图距离
 * 
 * @author DDD
 * 
 */
public class MapDistance {

	private static double EARTH_RADIUS = 6378137;

	private static double rad(double d) {
		return d * Math.PI / 180.0;
	}

	/**
	 * 计算经纬度之间距离
	 * 
	 * @param lat1
	 * @param lng1
	 * @param lat2
	 * @param lng2
	 * @return
	 */
	public static double getDistance(double lat1, double lng1, double lat2,
			double lng2) {
		double radLat1 = rad(lat1);
		double radLat2 = rad(lat2);
		double a = radLat1 - radLat2;
		double b = rad(lng1) - rad(lng2);
		double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
				+ Math.cos(radLat1) * Math.cos(radLat2)
				* Math.pow(Math.sin(b / 2), 2)));
		s = s * EARTH_RADIUS;
		s = Math.round(s * 10000) / 10000;
		return s;

	}

	/**
	 * 获取两个地名之间的距离
	 * 
	 * @param address1
	 * @param address2
	 * @return
	 */
	public static Double getAddressDistince(String address1, String address2) {

		LatLng ltg1 = getAddressLatLng(address1);
		if (ltg1 == null) {
			return null;
		}

		LatLng ltg2 = getAddressLatLng(address2);
		if (ltg2 == null) {
			return null;
		}
		return MapDistance.getDistance(ltg1.getLat(), ltg1.getLng(),
				ltg2.getLat(), ltg2.getLng());

	}

	/**
	 * 获取一个地名的经纬度
	 * 
	 * @param address
	 * @return
	 */
	public static LatLng getAddressLatLng(String address) {
		if (address == null || "".equals(address.trim())) {
			return null;
		}

		LatLng l = new LatLng();
		String url = "http://api.map.baidu.com/geocoder/v2/?address="
				+ address.trim() + "&output=xml&ak="
				+ BaiDuConfig.KEY_FOR_SERVER + "&callback=showLocation";

		String content = HttpRequest.sendGet(url, "");

		/*
		 * System.out.println("url==="+url);
		 * System.out.println("out=="+content);
		 */
		if (content == null || !content.contains("<lat>")) {
			return null;
		}
		String lat = content.substring(content.indexOf("<lat>") + 5,
				content.indexOf("</lat>"));
		String lng = content.substring(content.indexOf("<lng>") + 5,
				content.indexOf("</lng>"));
		if (lat != null && lng != null) {
			l.setLat(Double.valueOf(lat));
			l.setLng(Double.valueOf(lng));
			return l;
		}
		return null;
	}

	public static void main(String[] args) {
		/*
		 * System.out.println(MapDistance.getAddressDistince("上海市浦东新区浦东南路2305号",
		 * "上海市浦东新区张家浜路京城37号"));
		 */
		LatLng ll = MapDistance.getAddressLatLng("上海市人民广场");
		System.out.println("lat=" + ll.getLat() + " lng=" + ll.getLng());
	}

}
