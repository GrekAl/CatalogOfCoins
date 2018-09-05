package org.numismat.springboot.service;

import org.numismat.springboot.mapper.CoinMapper;
import org.numismat.springboot.model.Coin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class CoinService {

	@Autowired
	private CoinMapper coinMapper;

	public Page<Coin> findByPage(int pageNo, int pageSize) {
		PageHelper.startPage(pageNo, pageSize); 
		return coinMapper.getAllCoins();
	}
	
	

}
