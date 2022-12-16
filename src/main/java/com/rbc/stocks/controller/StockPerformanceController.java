package com.rbc.stocks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.rbc.stocks.entity.StockPerformance;
import com.rbc.stocks.service.IStocksPerformanceService;

@Controller
@RequestMapping("/api/stock-performance")
public class StockPerformanceController {

	@Autowired
	IStocksPerformanceService iStocksPerformanceService;

	@PostMapping("/upload")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {

		String message = "";
		try {
			iStocksPerformanceService.save(file);
			message = "Uploaded the file successfully: " + file.getOriginalFilename();
			return ResponseEntity.status(HttpStatus.OK).body(message);
		} catch (Exception e) {
			e.printStackTrace();
			message = "Could not upload the file: " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
		}
	}

	@GetMapping("")
	public ResponseEntity<List<StockPerformance>> getAllPerformingStocks() {
		try {
		
			List<StockPerformance> stockPerformances = iStocksPerformanceService.getAllPerformingStocks();
			if (stockPerformances.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(stockPerformances, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{stockName}")
	public ResponseEntity<List<StockPerformance>> getByStockName(@PathVariable("stockName") String stockName) {
		try {
			List<StockPerformance> stockPerformances = iStocksPerformanceService.getByStockName(stockName);
			if (stockPerformances.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(stockPerformances, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/save")
	public ResponseEntity<Integer> save(StockPerformance stockPerformance) {
		try {
			int id = iStocksPerformanceService.save(stockPerformance);
			return new ResponseEntity<>(id, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(0, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
