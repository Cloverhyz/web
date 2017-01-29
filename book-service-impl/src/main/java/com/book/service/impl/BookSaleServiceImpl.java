package com.book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.model.BookListMd;
import com.book.service.BookSaleService;

import redis.clients.jedis.JedisCluster;

/*@Service("bookSaleService")*/
public class BookSaleServiceImpl implements BookSaleService {

	/*@Autowired
	private JedisCluster jedisCluster;
	@Override
	public void addToCart(BookListMd bookListMd) throws Exception {
		jedisCluster.hset(bookListMd.getAccountId().toString(), bookListMd.getBookId().toString(), bookListMd.getBookNum().toString());
		System.out.println(jedisCluster.hget(bookListMd.getAccountId().toString(), bookListMd.getBookId().toString()));
	}*/

}
