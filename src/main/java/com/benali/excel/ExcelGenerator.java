package com.benali.excel;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

@Service
public class ExcelGenerator {
	private static String[] columns = {"Nom", "Prix", "RAM"};
	private static List<ExcelPhone> ePhone = new ArrayList<>();
	public java.io.ByteArrayInputStream generateExcel(List<ExcelPhone> listphones){
		for(ExcelPhone p: listphones){
			ePhone.add(p);
		}
		//creating the workBook
		Workbook wb = new XSSFWorkbook();
		//creating the first page
		Sheet sheet = wb.createSheet("Phones");
		//crating a font
		Font headerFont = wb.createFont();
		headerFont.setBold(true);
		headerFont.setFontHeight((short) 14);
		headerFont.setColor(IndexedColors.RED.getIndex());
		//creating a cell style
		CellStyle headerCellStyle = wb.createCellStyle();
		headerCellStyle.setFont(headerFont);
		//creating a row
		Row headerRow = sheet.createRow(0);
		//creating cells
		for(int i=0; i< columns.length; i++){
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columns[i]);
			cell.setCellStyle(headerCellStyle);
		}
		//creating other rows
		int rowNum = 1;
		for(ExcelPhone ep : ePhone){
			Row row = sheet.createRow(rowNum);
			row.createCell(0).setCellValue(ep.getNomSmartEx());
			row.createCell(1).setCellValue(ep.getPrixSmartEx());
			row.createCell(2).setCellValue(ep.getRAMSmartEx());
		}
		//resizing columns width
		for(int i=0; i<columns.length; i++){
			sheet.autoSizeColumn(i);
		}
		//generating the output file
		ByteArrayOutputStream fos = new ByteArrayOutputStream();
		try {
			wb.write(fos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			wb.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new java.io.ByteArrayInputStream(fos.toByteArray());
	}

}
