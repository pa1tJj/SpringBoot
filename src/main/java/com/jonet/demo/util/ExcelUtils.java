package com.jonet.demo.util;

import org.apache.poi.ss.usermodel.Cell;

public class ExcelUtils {

	public static Object getValueCell(Cell cell) {
		if (cell == null)
			return null;
		switch (cell.getCellType()) {
		case STRING -> {
			return cell.getStringCellValue();
		}

		case NUMERIC -> {
			return cell.getNumericCellValue();
		}

		case BOOLEAN -> {
			return cell.getBooleanCellValue();
		}
		default -> {
			return cell.toString();
		}
		}
	}
}
