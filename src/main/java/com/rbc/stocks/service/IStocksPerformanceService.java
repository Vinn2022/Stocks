package com.rbc.stocks.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.rbc.stocks.entity.StockPerformance;

public interface IStocksPerformanceService {

	public void save(MultipartFile file);
	
	public List<StockPerformance> getAllPerformingStocks();
	
	public List<StockPerformance> getByStockName(String stockName);
	
	public int save(StockPerformance stockPerformance);
}
