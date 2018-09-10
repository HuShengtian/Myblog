package pojo;

import java.util.List;

public class YearLine {
	private String year;
	private List<MonthLine> months;
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public List<MonthLine> getMonths() {
		return months;
	}
	public void setMonths(List<MonthLine> months) {
		this.months = months;
	}
}
