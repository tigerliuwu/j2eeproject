package edu.dlmu.sei.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import edu.dlmu.sei.exception.ExcelParseException;

public class ExcelParser {

	private ExcelType[] excelTypes;

	private List results = new ArrayList();

	private List errorresults = new ArrayList();

	public ExcelParser(ExcelType[] excelTypes) {
		super();
		this.excelTypes = excelTypes;
	}

	public void run(InputStream inputstream) {

		POIFSFileSystem fs = null;

		HSSFWorkbook wb = null;

		try {

			fs = new POIFSFileSystem(inputstream);

			wb = new HSSFWorkbook(fs);

		} catch (IOException e) {

			throw new ExcelParseException();

		}

		HSSFSheet sheet = wb.getSheetAt(0);

		int lastRow = sheet.getLastRowNum();

		for (int i = 1; i <= lastRow; i++) {

			HSSFRow row = sheet.getRow(i);

			if (row == null)
				continue;

			List cols = new ArrayList();
			
			for (short j = 0; j < excelTypes.length; j++) {
				try {
					cols.add(excelTypes[j].getCellValue(row.getCell(j)));
				} catch (ExcelParseException e) {
					errorresults.add("row[" + i + "],col[" + (j + 1) + "]"
							+ e.getMessage());
				}
			}

			results.add(cols);
		}

	}

	public List getErrorresults() {
		return errorresults;
	}

	public List getResults() {
		return results;
	}

	public static void main(String[] args) {

		InputStream in = null;
		try {
			in = new FileInputStream("d:/polines.XLS");

			ExcelType[] types = new ExcelType[] {
					new ExcelType(ExcelType.CELL_TYPE_STRING, true),
					new ExcelType(ExcelType.CELL_TYPE_STRING, true),
					new ExcelType(ExcelType.CELL_TYPE_NUMERIC, true),
					new ExcelType(ExcelType.CELL_TYPE_NUMERIC, true),
					new ExcelType(ExcelType.CELL_TYPE_DATE, true),
					new ExcelType(ExcelType.CELL_TYPE_STRING, true) };

			ExcelParser parser = new ExcelParser(types);

			parser.run(in);

			List errorresults = parser.getErrorresults();

			for (int i = 0; i < errorresults.size(); i++) {

				System.out.println(i + ":" + errorresults.get(i));

			}

			List results = parser.getResults();

			for (int i = 0; i < results.size(); i++) {
				System.out.println(i + ":" + results.get(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null)
					in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
