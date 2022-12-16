package com.rbc.stocks.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.rbc.stocks.entity.StockPerformance;
import com.rbc.stocks.repository.StockPerformanceRepository;
import com.rbc.stocks.util.CSVHelper;

@Service
public class StocksPerformanceService implements IStocksPerformanceService {

	@Autowired
	StockPerformanceRepository stockPerformanceRepository;

	public void save(MultipartFile file) {
		try {
			List<StockPerformance> stockPerformances = CSVHelper.csvToEntity(file.getInputStream());
			stockPerformanceRepository.saveAll(stockPerformances);
		} catch (Exception e) {
			throw new RuntimeException("fail to store csv data: " + e.getMessage());
		} 
	}

	public List<StockPerformance> getAllPerformingStocks() {
		return stockPerformanceRepository.findAll();
	}
	
	public List<StockPerformance> getByStockName(String stockName) {
		return stockPerformanceRepository.findByStockName(stockName);
	}
	
	public int save(StockPerformance stockPerformance) {
		return stockPerformanceRepository.save(stockPerformance).getId();
	}
}
