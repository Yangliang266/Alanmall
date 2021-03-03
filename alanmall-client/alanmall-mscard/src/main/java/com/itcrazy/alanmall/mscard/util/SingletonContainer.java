package com.itcrazy.alanmall.mscard.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;


public class SingletonContainer {

	private static Log log = LogFactory.getLog(SingletonContainer.class);
	private static SingletonContainer instance = new SingletonContainer();
	private ConcurrentHashMap<String, Object> map;
	private Timer timer;  
	private final static long TIMER_DELAY = 3600L;
	private long keepSec = TIMER_DELAY;
	private Date origStartTime;
	private Date startTime;
	private static boolean isClear = true;
	
	private SingletonContainer() {
		map = new ConcurrentHashMap<String, Object>();
	}
	
	private static synchronized SingletonContainer getInstance() {
		return instance;
	}
	
	public static void put(String key, Object obj) {
		if (isClear) {
			getInstance().timer = new Timer();  
			getInstance().timer.schedule(getInstance().new MyTask(), getInstance().keepSec * 1000);
			getInstance().origStartTime = new Date();
		}
		isClear = false;
		getInstance().map.put(key, obj);
		getInstance().startTime = new Date();
	}
	
	public static Object get(String key) {
		getInstance().startTime = new Date();
		return getInstance().map.get(key);
	}
	
	public static void remove(String key) {
		getInstance().startTime = new Date();
		getInstance().map.remove(key);
	}
	
	public static void clear() {
		getInstance().map.clear();
		isClear = true;
	}
	
	class MyTask extends TimerTask {  
		
		@Override  
		public void run() {  
			System.out.println("timeOut");
			log.error("SingletonContainer time Out");
			
			timer.cancel();
			timer.purge();
			
			long deta = startTime.getTime() - origStartTime.getTime();
			if (deta > 0) {
				timer = new Timer();  
				getInstance().timer.schedule(getInstance().new MyTask(), deta);
				origStartTime = new Date();
				System.out.println("new task");
				log.error("SingletonContainer new task");
			} else {
				clear();
				System.out.println("end");
				log.error("SingletonContainer end");
			}
		}  
	}  

}
