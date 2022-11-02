package org.exampleUtils01.poi;

public class FootCell {

	private int cellNum;
	
	private Object cellVal;

	public FootCell(){
		
	}
	
	public FootCell(int cellNum,Object cellVal){
		this.cellNum =cellNum;
		this.cellVal =cellVal;
	}
	
	public int getCellNum() {
		return cellNum;
	}

	public void setCellNum(int cellNum) {
		this.cellNum = cellNum;
	}

	public Object getCellVal() {
		return cellVal;
	}

	public void setCellVal(Object cellVal) {
		this.cellVal = cellVal;
	}
	
	
}
