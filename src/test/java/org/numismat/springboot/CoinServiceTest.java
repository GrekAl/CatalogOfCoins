package org.numismat.springboot;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.numismat.springboot.mapper.CoinMapper;
import org.numismat.springboot.model.Coin;
import org.numismat.springboot.service.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.pagehelper.Page;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoinServiceTest {
    @Autowired
    private CoinMapper mapper;
/*    @Test
    public void testFindByPage() {
        Page<Coin> students = coinService.findByPage(1, 10);//Query pageNo=1, pageSize=2
        assertEquals(students.getTotal(),16);
        assertEquals(students.getPages(),2);
        System.out.println(students.toString());
    }*/
    @Test
    public void testSearch() {
    	Coin coin = new Coin();
    	coin.setCurrency("1");
    	Page<Coin> coins = mapper.searchCoins(coin);
    	assertEquals(coin.getId(),null);
    }
    
    
}