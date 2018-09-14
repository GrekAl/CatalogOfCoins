package org.numismat.springboot.controller;

import java.util.List;

import javax.validation.Valid;

import org.numismat.springboot.model.Coin;
import org.numismat.springboot.model.DataTableResultInfo;
import org.apache.ibatis.session.RowBounds;
import org.numismat.springboot.mapper.CoinMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@RestController
@RequestMapping("api/coins")
public class MainRESTController {

	// private CoinDAO CoinDAO;
	@Autowired
	private CoinMapper mapper;


	@GetMapping(value = "/all")
	public DataTableResultInfo getCoinsByPage(
			@RequestParam(value = "start", required = false, defaultValue = "0") Integer start,
			@RequestParam(value = "length", required = false, defaultValue = "10") Integer length,
			@RequestParam(value = "draw", required = false, defaultValue = "0") Integer draw) {

		int pageNo = (start) / length + 1;
		PageHelper.startPage(pageNo, length); 
		Page<Coin> pageInfo = mapper.getAllCoins();

		DataTableResultInfo dataTableResultInfo = new DataTableResultInfo();
		dataTableResultInfo.setData(pageInfo);
		dataTableResultInfo.setDraw(draw);
		dataTableResultInfo.setLength(length);
		dataTableResultInfo.setRecordsTotal(pageInfo.getTotal());
		dataTableResultInfo.setRecordsFiltered(pageInfo.getTotal());

		return dataTableResultInfo;
	}
	
	@PostMapping(value = "/search")
	public DataTableResultInfo searchCoinsByPage(
			@ModelAttribute Coin coin,
			@RequestParam(value = "start", required = false, defaultValue = "0") Integer start,
			@RequestParam(value = "length", required = false, defaultValue = "10") Integer length,
			@RequestParam(value = "draw", required = false, defaultValue = "0") Integer draw) {

		int pageNo = (start) / length + 1;
		PageHelper.startPage(pageNo, length); 
		Page<Coin> pageInfo = mapper.searchCoins(coin);
		System.out.println(coin.getId());
		System.out.println(coin.getCurrency().equals("") ? "true" : "false");

		DataTableResultInfo dataTableResultInfo = new DataTableResultInfo();
		dataTableResultInfo.setData(pageInfo);
		dataTableResultInfo.setDraw(draw);
		dataTableResultInfo.setLength(length);
		dataTableResultInfo.setRecordsTotal(pageInfo.getTotal());
		dataTableResultInfo.setRecordsFiltered(pageInfo.getTotal());

		return dataTableResultInfo;
	}

	
	 /* @RequestMapping(value = "/coin",  method = RequestMethod.POST, produces
	  = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	  
	  @ResponseBody*/
	 
	@PostMapping(value = "/add")
	public void addCoin(@ModelAttribute Coin coin) {
		mapper.addCoin(coin);
	}

	/*
	 * @RequestMapping(value = "/coins/{id}", // method = RequestMethod.DELETE, //
	 * produces = { MediaType.APPLICATION_JSON_VALUE,
	 * MediaType.APPLICATION_XML_VALUE })
	 * 
	 * @ResponseBody
	 */
	@DeleteMapping(value = "/delete/{id}")
	public void deleteCoin(@PathVariable("id") int id) {
		mapper.deleteCoinById(id);
	}

	/*
	 * @RequestMapping(value = "/coin", // method = RequestMethod.PUT, // produces =
	 * { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	 * 
	 * @ResponseBody
	 */
	@PostMapping(value = "/edit")
	public void updateCoin(@ModelAttribute @Valid Coin coin) {
		mapper.updateCoin(coin);
	}
	/*
	 * @RequestMapping(value = "/coin/{id}", // method = RequestMethod.GET, //
	 * produces = { MediaType.APPLICATION_JSON_VALUE,
	 * MediaType.APPLICATION_XML_VALUE })
	 * 
	 * @ResponseBody public Coin getCoin(@PathVariable("id") String empNo) { return
	 * CoinDAO.getCoin(empNo); }
	 * 
	 * 
	 */

}
