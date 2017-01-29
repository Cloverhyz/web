package com.book.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

public class TestMain {

	public static void main(String[] args) {
		HostAndPort node = new HostAndPort("127.0.0.1", 7001);
		GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
		Runtime runtime = Runtime.getRuntime();
		final String cmd = "cmd /c start D:/redis/";
		List<String> list = new ArrayList<>();
		try {
			String encoding = "GBK";
			File file = new File("D://redis//redisCluster.txt");
			if (file.isFile() && file.exists()) { // 判断文件是否存在
				InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);// 考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					list.add(lineTxt);
					System.out.println(lineTxt);
				}
				read.close();
				new Thread(new Runnable() {
					@Override
					public void run() {
						int i = 0;
						while (true) {
							JedisCluster jedisCluster = new JedisCluster(node, 10, 10, 10, "123456", poolConfig);
							Map<String, JedisPool> nodes = jedisCluster.getClusterNodes();
							System.out.println(nodes.toString());
							if (nodes.size() < list.size()) {
								for (String port : list) {
									if (!nodes.containsKey(port)) {
										String[] a = port.split(":");
										String portcmd = cmd + a[1] + "/start.bat";
										Process process;
										try {
											System.out.println("执行cmd");
											process = runtime.exec(portcmd);
											/*BufferedReader br = new BufferedReader(
													new InputStreamReader(process.getInputStream()));
											String line = null;
											while ((line = br.readLine()) != null) {
												System.out.println(line);
											}*/
											Thread.sleep(2000);
											if (null != process) {
												process.destroy();
												process = null;
											}
										} catch (Exception e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									}
								}
							}
							try {
								jedisCluster.close();
								Thread.sleep(2000);
								System.out.println("集群检测完毕" + (i++));
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}).start();
			} else {
				System.out.println("找不到指定的文件");
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}
	}

}
