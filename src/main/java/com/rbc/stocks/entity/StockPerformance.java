package com.rbc.stocks.entity;

import java.math.BigInteger;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name = "stock_performance")
public class StockPerformance {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "quarter")
	private int quarter;
	
	@Column(name = "stock")
	private String stock;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "open")
	private float open;
	
	@Column(name = "high")
	private float high;
	
	@Column(name = "low")
	private float low;
	
	@Column(name = "close")
	private float close;
	
	@Column(name = "volume")
	private BigInteger volume;
	
	@Column(name = "percent_change_price")
	private float percentChangePrice;
	
	@Column(name = "percent_change_volume_over_last_wk")
	private float percentChangeVolumeLastWk;
	
	@Column(name = "previous_weeks_volume")
	private BigInteger previousWeekVol;
	
	@Column(name = "next_weeks_open")
	private float nextWeekOpen;
	
	@Column(name = "next_weeks_close")
	private float nextWeekClose;
	
	@Column(name = "percent_change_next_weeks_price")
	private float percentChangeNxtWkPrice;
	
	@Column(name = "days_to_next_dividend")
	private int daysToNxtDvnd;
	
	@Column(name = "percent_return_next_dividend")
	private float percentReturnNxtDvnd;

	public StockPerformance() {
	
	}

	public StockPerformance(int quarter, String stock, Date date, float open, float high, float low,
			float close, BigInteger volume, float percentChangePrice, float percentChangeVolumeLastWk,
			BigInteger previousWeekVol, float nextWeekOpen, float nextWeekClose, float percentChangeNxtWkPrice,
			int daysToNxtDvnd, float percentReturnNxtDvnd) {
		this.quarter = quarter;
		this.stock = stock;
		this.date = date;
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.volume = volume;
		this.percentChangePrice = percentChangePrice;
		this.percentChangeVolumeLastWk = percentChangeVolumeLastWk;
		this.previousWeekVol = previousWeekVol;
		this.nextWeekOpen = nextWeekOpen;
		this.nextWeekClose = nextWeekClose;
		this.percentChangeNxtWkPrice = percentChangeNxtWkPrice;
		this.daysToNxtDvnd = daysToNxtDvnd;
		this.percentReturnNxtDvnd = percentReturnNxtDvnd;
	}
	
	public StockPerformance(int id, int quarter, String stock, Date date, float open, float high, float low,
			float close, BigInteger volume, float percentChangePrice, float percentChangeVolumeLastWk,
			BigInteger previousWeekVol, float nextWeekOpen, float nextWeekClose, float percentChangeNxtWkPrice,
			int daysToNxtDvnd, float percentReturnNxtDvnd) {
		this.id = id;
		this.quarter = quarter;
		this.stock = stock;
		this.date = date;
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.volume = volume;
		this.percentChangePrice = percentChangePrice;
		this.percentChangeVolumeLastWk = percentChangeVolumeLastWk;
		this.previousWeekVol = previousWeekVol;
		this.nextWeekOpen = nextWeekOpen;
		this.nextWeekClose = nextWeekClose;
		this.percentChangeNxtWkPrice = percentChangeNxtWkPrice;
		this.daysToNxtDvnd = daysToNxtDvnd;
		this.percentReturnNxtDvnd = percentReturnNxtDvnd;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuarter() {
		return quarter;
	}

	public void setQuarter(int quarter) {
		this.quarter = quarter;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public float getOpen() {
		return open;
	}

	public void setOpen(float open) {
		this.open = open;
	}

	public float getHigh() {
		return high;
	}

	public void setHigh(float high) {
		this.high = high;
	}

	public float getLow() {
		return low;
	}

	public void setLow(float low) {
		this.low = low;
	}

	public float getClose() {
		return close;
	}

	public void setClose(float close) {
		this.close = close;
	}

	public BigInteger getVolume() {
		return volume;
	}

	public void setVolume(BigInteger volume) {
		this.volume = volume;
	}

	public float getPercentChangePrice() {
		return percentChangePrice;
	}

	public void setPercentChangePrice(float percentChangePrice) {
		this.percentChangePrice = percentChangePrice;
	}

	public float getPercentChangeVolumeLastWk() {
		return percentChangeVolumeLastWk;
	}

	public void setPercentChangeVolumeLastWk(float percentChangeVolumeLastWk) {
		this.percentChangeVolumeLastWk = percentChangeVolumeLastWk;
	}

	public BigInteger getPreviousWeekVol() {
		return previousWeekVol;
	}

	public void setPreviousWeekVol(BigInteger previousWeekVol) {
		this.previousWeekVol = previousWeekVol;
	}

	public float getNextWeekOpen() {
		return nextWeekOpen;
	}

	public void setNextWeekOpen(float nextWeekOpen) {
		this.nextWeekOpen = nextWeekOpen;
	}

	public float getNextWeekClose() {
		return nextWeekClose;
	}

	public void setNextWeekClose(float nextWeekClose) {
		this.nextWeekClose = nextWeekClose;
	}

	public float getPercentChangeNxtWkPrice() {
		return percentChangeNxtWkPrice;
	}

	public void setPercentChangeNxtWkPrice(float percentChangeNxtWkPrice) {
		this.percentChangeNxtWkPrice = percentChangeNxtWkPrice;
	}

	public int getDaysToNxtDvnd() {
		return daysToNxtDvnd;
	}

	public void setDaysToNxtDvnd(int daysToNxtDvnd) {
		this.daysToNxtDvnd = daysToNxtDvnd;
	}

	public float getPercentReturnNxtDvnd() {
		return percentReturnNxtDvnd;
	}

	public void setPercentReturnNxtDvnd(float percentReturnNxtDvnd) {
		this.percentReturnNxtDvnd = percentReturnNxtDvnd;
	}
	
}
