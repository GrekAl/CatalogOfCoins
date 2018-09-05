package org.numismat.springboot.mapper;

import java.util.Map;

import org.numismat.springboot.model.Coin;

public class SearchProvider {
	
	public static String search(Map parameters) {

        String query = "SELECT * FROM public.coin WHERE ";
        Coin coin = (Coin) parameters.get("searchParams");
        if (coin.getCurrency()!=null) {
            query += "currency='" + coin.getCurrency() + "' AND ";
        }
        if (coin.getValue()!= 0) {
            query += "value=" + coin.getValue() + " AND ";
        }
        if (coin.getYear()!= 0) {
            query += "year="+ coin.getYear() + " AND ";
        }
        if (coin.getMint()!=null) {
            query += "mint='" + coin.getMint() + "' ORDER BY id ASC";
        }
        return query;

    }

}
