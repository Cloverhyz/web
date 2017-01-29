package com.book.service.impl;

import java.io.IOException;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.junit.Test;

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
			jedisCluster.set(SerializeUtils.serialize(accountInfoMd.getAccountId(),Long.class), SerializeUtils.serialize(accountInfoMd, AccountInfoMd.class));
			byte[] bytes = jedisCluster.get(SerializeUtils.serialize(accountInfoMd.getAccountId(),Long.class));
			AccountInfoMd aInfoMd = (AccountInfoMd)SerializeUtils.decodeSerialize(bytes, AccountInfoMd.class);
			System.out.println(aInfoMd.getAccountName());
			jedisCluster.close();
		}

}
