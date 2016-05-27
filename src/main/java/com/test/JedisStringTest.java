package com.test;

import net.sf.json.JSONObject;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import redis.clients.jedis.Jedis;

import com.utils.JedisUtil;

public class JedisStringTest {

	private static final String ipAddr = "192.168.16.233";
	private static final int port = 6387;
	private static Jedis jedis = null;

	@BeforeClass
	public static void init() {
		jedis = JedisUtil.getInstance().getJedis(ipAddr, port);
	}

	@AfterClass
	public static void close() {
		JedisUtil.getInstance().closeJedis(jedis, ipAddr, port);
	}
	@Test
	public void testCookieString(){
		JSONObject jsonObject = JSONObject.fromObject("{}");
		jsonObject.put("_he_life_v_100856", "{\"value\":\"{\\\"c\\\":3,\\\"m\\\":3,\\\"e\\\":1464537599000}\",\"expire\":1464537599000}");
		jsonObject.put("_he_custom_v_97078", "{\"value\":\"{\\\"c\\\":3,\\\"m\\\":3,\\\"e\\\":1465142400000}\",\"expire\":1465142400000}");
		jsonObject.put("_he_life_v_101931", "{\"value\":\"{\\\"c\\\":3,\\\"m\\\":5,\\\"e\\\":1465142399000}\",\"expire\":1465142399000}");
		jsonObject.put("_he_life_v_102369", "{\"value\":\"{\\\"c\\\":3,\\\"m\\\":5,\\\"e\\\":1468771199000}\",\"expire\":1468771199000}");
		jsonObject.put("_he_life_v_105916", "{\"value\":\"{\\\"c\\\":2,\\\"m\\\":2,\\\"e\\\":1465747199000}\",\"expire\":1465747199000}");
		jsonObject.put("_he_life_v_99142", "{\"value\":\"{\\\"c\\\":3,\\\"m\\\":5,\\\"e\\\":1465142399000}\",\"expire\":1465142399000}");
		jsonObject.put("_he_life_r_101749", "{\"value\":\"{\\\"c\\\":2,\\\"m\\\":2,\\\"e\\\":1464710399000}\",\"expire\":1464710399000}");
		jsonObject.put("_he_life_v_105917", "{\"value\":\"{\\\"c\\\":2,\\\"m\\\":2,\\\"e\\\":1465142399000}\",\"expire\":1465142399000}");
		jsonObject.put("_he_life_v_104322", "{\"value\":\"{\\\"c\\\":2,\\\"m\\\":3,\\\"e\\\":1465228799000}\",\"expire\":1465228799000}");
		for(int i=0;i<100000;i++){
			jedis.set("ck:14638426354436c:"+i+":pub.funshion.com:/",jsonObject.toString());
		}
	}
}
