package com.book.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.book.model.AccountInfoMd;
import com.book.service.utils.SerializeUtils;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

public class JedisTest {

	@Test
	public void cluster() throws IOException {
		HostAndPort node = new HostAndPort("127.0.0.1", 7001);
		GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
		// JedisCluster jedisCluster = new JedisCluster(node, 10, 10, 10,
		// "123456",poolConfig);
		JedisCluster jedisCluster = new JedisCluster(node, 10, 10, 10, "123456", poolConfig);
		AccountInfoMd accountInfoMd = new AccountInfoMd();
		accountInfoMd.setAccountId(131L);
		accountInfoMd.setAccountName("Clover");
		accountInfoMd.setAccountPassword("123456");
		accountInfoMd.setBindEmail("123@163.com");
		accountInfoMd.setBindPhone("120");
		accountInfoMd.setPicPath("");
		jedisCluster.set(SerializeUtils.serialize(accountInfoMd.getAccountId(), Long.class),
				SerializeUtils.serialize(accountInfoMd, AccountInfoMd.class));
		byte[] bytes = jedisCluster.get(SerializeUtils.serialize(accountInfoMd.getAccountId(), Long.class));
		AccountInfoMd aInfoMd = (AccountInfoMd) SerializeUtils.decodeSerialize(bytes, AccountInfoMd.class);
		System.out.println(aInfoMd.getAccountName());
		jedisCluster.close();
	}

	@Test
	public void testMath() {
		int i;
		for (i = 1; !(i % 2 == 1 && i % 3 == 0 && i % 4 == 1 && i % 5 == 4 && i % 6 == 3 && i % 7 == 0 && i % 8 == 1
				&& i % 9 == 0); i++) {
		}
		System.out.println(i);
	}
	
	@Test
	public void testList(){
		List<AccountInfoMd> accountInfoMds = new ArrayList<>();
		for(int i = 0;i<2;i++){
			AccountInfoMd sAccountInfoMd = new AccountInfoMd();
			sAccountInfoMd.setAccountId(1L);
			sAccountInfoMd.setAccountName("aaa");
			sAccountInfoMd.setAccountPassword("123");
			accountInfoMds.add(sAccountInfoMd);
		}
		for(int i = 2;i<10;i++){
			AccountInfoMd sAccountInfoMd = new AccountInfoMd();
			sAccountInfoMd.setAccountId(1L);
			sAccountInfoMd.setAccountName("sss");
			sAccountInfoMd.setAccountPassword("123");
			accountInfoMds.add(sAccountInfoMd);
		}
		List<AccountInfoMd> sAccountInfoMds = new ArrayList<>();
		for(AccountInfoMd accountInfoMd : accountInfoMds){
			if("aaa".equals(accountInfoMd.getAccountName())){
				sAccountInfoMds.add(accountInfoMd);
				continue;
			}
		}
		accountInfoMds.removeAll(sAccountInfoMds);
		
		System.out.println(accountInfoMds);
		
	}
	
	@Test
	public void testDouble(){
		double md = 0.0;
		Double d = md;
		Double e = (Double) JSONObject.parse(JSONObject.toJSONString(d));	
		System.out.println(JSONObject.toJSONString(e));
	}
	
	
	
	
	

}
