package org.numismat.springboot.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.numismat.springboot.model.Coin;
import org.springframework.stereotype.Repository;

import com.github.pagehelper.Page;

@Repository
@Mapper
public interface CoinMapper {
	
	@Select("SELECT * FROM public.coin ORDER BY id ASC")
	Page<Coin> getAllCoins();
	
	@SelectProvider(type = SearchProvider.class, method = "search")
	Page<Coin> searchCoins(@Param("searchParams") Coin searchParams);
	
	@Insert("INSERT INTO public.coin(id, currency, value, year, mint) "
			+ "VALUES (#{id},#{currency},#{value},#{year},#{mint});")
	void addCoin(Coin coin);
	
	@Delete("DELETE FROM public.coin WHERE id=#{id};")
    void deleteCoinById(@Param("id") int id);
	
	@Update("UPDATE public.coin SET currency=#{currency}, value=#{value}, year=#{year}, mint=#{mint} " + 
			"WHERE id=#{id};")
    void updateCoin(Coin coin);
 
}
