package com.itcrazy.alanmall.common.cache.memcached;

import com.itcrazy.alanmall.common.client.file.PropertyUtil;
import com.itcrazy.alanmall.common.client.project.WebProjectName;
import com.whalin.MemCached.MemCachedClient;
import com.whalin.MemCached.SockIOPool;

public class MemSessionProxy {

	private static MemCachedClient mcc = null;

	private static final String SESSION_POOL = "sessionPool";

	private MemSessionProxy() {

	}

	@SuppressWarnings("static-access")
	public void init() {
		PropertyUtil p = new PropertyUtil(System.getenv("meishi_config_path")
				+ "/" + WebProjectName.getProjectName()
				+ "/memcache_session.properties");
		Integer maxIdle = Integer.parseInt(p
				.getCommonConf("memcache_session.maxIdle"));
		Integer maintSleep = Integer.parseInt(p
				.getCommonConf("memcache_session.maintSleep"));
		Boolean nagle = Boolean.parseBoolean(p
				.getCommonConf("memcache_session.nagle"));
		Integer socketTO = Integer.parseInt(p
				.getCommonConf("memcache_session.socketTO"));
		String serverIP = p.getCommonConf("memcache_session.server");
		Integer initConn = Integer.parseInt(p
				.getCommonConf("memcache_session.initConn"));
		Integer minConn = Integer.parseInt(p
				.getCommonConf("memcache_session.minConn"));
		Integer maxConn = Integer.parseInt(p
				.getCommonConf("memcache_session.maxConn"));

		String[] servers = { serverIP };

		SockIOPool pool = SockIOPool.getInstance(SESSION_POOL);

		pool.setServers(servers);

		pool.setInitConn(initConn);
		pool.setMinConn(minConn);
		pool.setMaxConn(maxConn);
		pool.setMaxIdle(maxIdle * 60 * 60);
		pool.setMaintSleep(maintSleep);
		pool.setNagle(nagle);
		pool.setSocketTO(socketTO);
		pool.setSocketConnectTO(0);
		pool.initialize();
	}

	public static synchronized MemCachedClient getInstance() {
		if (mcc == null) {
			MemSessionProxy m = new MemSessionProxy();
			m.init();
			mcc = new MemCachedClient(SESSION_POOL);

		}
		return mcc;
	}

	public static void main(String[] args) {
		MemSessionProxy.getInstance();
	}
}