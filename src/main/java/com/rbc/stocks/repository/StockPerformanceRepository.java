package com.rbc.stocks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rbc.stocks.entity.StockPerformance;

public interface StockPerformanceRepository extends JpaRepository<StockPerformance, Integer>{

	@Query( "select o from StockPerformance o where stock = :stockName" )
	List<StockPerformance> findByStockName(@Param("stockName") String stockName);
}
