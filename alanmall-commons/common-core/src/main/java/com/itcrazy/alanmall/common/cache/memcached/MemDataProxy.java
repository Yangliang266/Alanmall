package com.itcrazy.alanmall.common.cache.memcached;

import com.itcrazy.alanmall.common.client.file.PropertyUtil;
import com.itcrazy.alanmall.common.client.project.WebProjectName;
import com.whalin.MemCached.MemCachedClient;
import com.whalin.MemCached.SockIOPool;

public class MemDataProxy {

	private static MemCachedClient mcc = null;

	private static final String DATA_POOL = "dataPool";

	private MemDataProxy() {

	}

	@SuppressWarnings("static-access")
	public void init() {
		PropertyUtil p = new PropertyUtil(System.getenv("meishi_config_path")
				+ "/" + WebProjectName.getProjectName()
				+ "/memcache_data.properties");

		String serverIP = p.getCommonConf("memcache_data.server");

		Integer maxConn = Integer.parseInt(p.getCommonConf(
				"memcache_data.maxConn").trim());
		Integer maxIdle = Integer.parseInt(p.getCommonConf(
				"memcache_data.maxIdle").trim());
		Integer maintSleep = Integer.parseInt(p.getCommonConf(
				"memcache_data.maintSleep").trim());
		Integer initConn = Integer.parseInt(p.getCommonConf(
				"memcache_data.initConn").trim());
		Integer minConn = Integer.parseInt(p.getCommonConf(
				"memcache_data.minConn").trim());

		boolean nagle = Boolean.parseBoolean(p.getCommonConf(
				"memcache_data.nagle").trim());

		Integer socketTO = Integer.parseInt(p.getCommonConf(
				"memcache_data.socketTO").trim());

		SockIOPool pool = SockIOPool.getInstance(DATA_POOL);

		String[] servers = { serverIP };
		pool.setServers(servers);

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
			MemDataProxy m = new MemDataProxy();
			m.init();
			mcc = new MemCachedClient(DATA_POOL);

		}
		return mcc;
	}

	public static void main(String[] args) {
		WebProjectName p = new WebProjectName();
		p.setName("test");
		MemDataProxy.getInstance();
	}

}