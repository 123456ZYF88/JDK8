package org.exampleUtils01.poi;

import java.util.List;

public class FootRow {
	private Integer rowNum;
	private List<FootCell> arrFootCell;
	
	public Integer getRowNum() {
		return rowNum;
	}
	public void setRowNum(Integer rowNum) {
		this.rowNum = rowNum;
	}
	public List<FootCell> getArrFootCell() {
		return arrFootCell;
	}
	public void setArrFootCell(List<FootCell> arrFootCell) {
		this.arrFootCell = arrFootCell;
	}
}
