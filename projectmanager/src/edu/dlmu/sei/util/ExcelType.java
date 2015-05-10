package edu.dlmu.sei.util;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;

import edu.dlmu.sei.exception.ExcelParseException;

public class ExcelType {

	public static int CELL_TYPE_STRING = 1;

	public static int CELL_TYPE_NUMERIC = 2;

	public static int CELL_TYPE_DATE = 3;

	private int cellType;

	private boolean noblank;

	public ExcelType(int cellType, boolean noblank) {
		super();
		this.cellType = cellType;
		this.noblank = noblank;
	}

	public Object getCellValue(HSSFCell cell) throws ExcelParseException {

		if (cell == null) {
			throw new ExcelParseException();
		}

		try {
			switch (cell.getCellType()) {
			case HSSFCell.CELL_TYPE_BOOLEAN:
				if (CELL_TYPE_STRING == cellType)
					return new Boolean(cell.getBooleanCellValue()).toString();
				else
					throw new ExcelParseException();
			case HSSFCell.CELL_TYPE_NUMERIC:
				if (CELL_TYPE_STRING == cellType)
					return new BigDecimal(cell.getNumericCellValue() + "")
							.toString();
				else if (CELL_TYPE_NUMERIC == cellType)
					return new BigDecimal(cell.getNumericCellValue() + "");
				else if (CELL_TYPE_DATE == cellType)
					return cell.getDateCellValue();
				else
					throw new ExcelParseException();
			case HSSFCell.CELL_TYPE_STRING:
				if (CELL_TYPE_STRING == cellType)
					return cell.getRichStringCellValue().getString().trim();
				else if (CELL_TYPE_NUMERIC == cellType)
					return new BigDecimal(StringUtils.remove(cell
							.getRichStringCellValue().getString().trim(), ','));
				else if (CELL_TYPE_DATE == cellType) {
					Date d = CoreUtils.parseDate(cell.getRichStringCellValue()
							.getString().trim());
					if (d == null & noblank)
						throw new ExcelParseException();
					return d;
				}
				throw new ExcelParseException();
			case HSSFCell.CELL_TYPE_BLANK:
				if (noblank)
					throw new ExcelParseException();
				return null;
			case HSSFCell.CELL_TYPE_ERROR:
				throw new ExcelParseException();
			case HSSFCell.CELL_TYPE_FORMULA:
				if (CELL_TYPE_STRING == cellType)
					return cell.getRichStringCellValue().getString().trim();
				else if (CELL_TYPE_NUMERIC == cellType)
					return new BigDecimal(cell.getNumericCellValue());
				else if (CELL_TYPE_DATE == cellType)
					return cell.getDateCellValue();
				throw new ExcelParseException();
			default:
				if (CELL_TYPE_DATE == cellType)
					return cell.getDateCellValue();
				else
					throw new ExcelParseException();
			}
		} catch (NumberFormatException e) {
			throw new ExcelParseException(e.getMessage());
		} catch (Exception ex) {
			throw new ExcelParseException(ex.getMessage());
		}

	}
}
