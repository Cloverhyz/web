package org.book.dao.impl;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.junit.Test;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisSentinelPool;

public class JedisTest {

	@Test
	public void cluster() throws IOException {
		HostAndPort node = new HostAndPort("127.0.0.1", 7001);
		GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
		// JedisCluster jedisCluster = new JedisCluster(node, 10, 10, 10,
		// "123456",poolConfig);
		JedisCluster jedisCluster = new JedisCluster(node, 10, 10, 10, "123456", poolConfig);
		for (int i = 0; i < 100000; i++) {
			jedisCluster.set("{jkn}.name" + i, i + "123");
		}
		System.out.println(jedisCluster);
		jedisCluster.close();
	}
	
	@Test
	public void sentinelTest() throws InterruptedException {
		Set<String> sentinels = new HashSet<>();
		sentinels.add("127.0.0.1:27000");
		JedisSentinelPool jedisSentinelPool = new JedisSentinelPool("mymaster", sentinels, "123456");
		Jedis jedis = jedisSentinelPool.getResource();
		System.out.println(jedis.get("name"));
		for (int i = 0; i < 10000; i++) {
			System.out.println(jedis.get("{jkn}.name"+i));
			//Thread.sleep(2);
		}
		System.out.println(jedis.info());
		jedis.close();
		jedisSentinelPool.close();
	}

	@Test
	public void jedisPool() {
		GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
		JedisPool jedisPool = new JedisPool(poolConfig, "127.0.0.1", 7001, 10, "123456");
		Jedis jedis = jedisPool.getResource();
		for (int i = 0; i < 100000; i++) {
			jedis.set("{jkn}.name" + i,i+"123");
			jedis.waitReplicas(1, 10);
			//System.out.println(jedis.info());
		}
		jedis.close();
		jedisPool.close();

	}


	@Test
	public void jedisCluster() throws Exception {
		Set<HostAndPort> nodes = new HashSet<>();
		HostAndPort node3 = new HostAndPort("127.0.0.1", 7003);
		HostAndPort node1 = new HostAndPort("127.0.0.1", 7001);
		HostAndPort node2 = new HostAndPort("127.0.0.1", 7002);
		HostAndPort node4 = new HostAndPort("127.0.0.1", 7004);
		HostAndPort node5 = new HostAndPort("127.0.0.1", 7005);
		HostAndPort node6 = new HostAndPort("127.0.0.1", 7006);
		nodes.add(node1);
		nodes.add(node2);
		nodes.add(node3);
		nodes.add(node4);
		nodes.add(node5);
		nodes.add(node6);
		GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
		// JedisCluster jedisCluster = new JedisCluster(node, 10, 10, 10,
		// "123456",poolConfig);
		JedisCluster jedisCluster = new JedisCluster(nodes, 10, 10, 10, "123456", poolConfig);
		/*for (int i = 0; i < 100000; i++) {
			jedisCluster.set("{jkn}.name" + i, i + "123");
		}*/
		String result = jedisCluster.get("{jkn}.name1");
		System.out.println(result);
		System.out.println(jedisCluster.getClusterNodes());
		jedisCluster.close();
	}

}
