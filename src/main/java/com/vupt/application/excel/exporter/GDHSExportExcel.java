package com.vupt.application.excel.exporter;

import com.vupt.application.constant.XMLType;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.HOSO;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.FILEHOSO;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML10Pack.XML10;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML11Pack.XML11;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML1Pack.XML1;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML2Pack.XML2;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML3Pack.XML3;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML4Pack.XML4;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML5Pack.XML5;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML7Pack.XML7;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML8Pack.XML8;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML9Pack.XML9;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import com.vupt.application.excel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/*
 * Class GDHSExportExcel xuất bản dữ liệu GDHS thành ra Excel
 * */
public class GDHSExportExcel {
    public static CellStyle formatNumberCellStyle;

    public static void exportGDHSToExcel(HOSO hoso, String excelFilePath) throws Exception {

        Workbook workbook = getWorkbook(excelFilePath);
        formatNumberCellStyle = ExcelSheetDesigner.createCellStyleFormatNumber(workbook);


        FILEHOSO fhs1 = hoso.findXMLFile(XMLType.XML1);
        if (fhs1 != null) {
            Sheet sheetXMl1 = workbook.createSheet("XML1");
            XML1ExportExcel xml1ExportExcel = new XML1ExportExcel(workbook, sheetXMl1);
            xml1ExportExcel.writeExcel((XML1) fhs1.xmlDetail);
        }

        FILEHOSO fhs2 = hoso.findXMLFile(XMLType.XML2);
        if (fhs2 != null) {
            Sheet sheetXML2 = workbook.createSheet("XML2");
            XML2ExportExcel xml2ExportExcel = new XML2ExportExcel(workbook, sheetXML2);
            xml2ExportExcel.writeExcel((XML2) fhs2.xmlDetail);
        }

        FILEHOSO fhs3 = hoso.findXMLFile(XMLType.XML3);
        if (fhs3 != null) {
            Sheet sheetXML3 = workbook.createSheet("XML3");
            XML3ExportExcel xml3ExportExcel = new XML3ExportExcel(workbook, sheetXML3);
            xml3ExportExcel.writeExcel((XML3) fhs3.xmlDetail);
        }

        FILEHOSO fhs4 = hoso.findXMLFile(XMLType.XML4);
        if (fhs4 != null) {
            Sheet sheetXML4 = workbook.createSheet("XML4");
            XML4ExportExcel xml4ExportExcel = new XML4ExportExcel(workbook, sheetXML4);
            xml4ExportExcel.writeExcel((XML4) fhs4.xmlDetail);
        }

        FILEHOSO fhs5 = hoso.findXMLFile(XMLType.XML5);
        if (fhs5 != null) {
            Sheet sheetXML5 = workbook.createSheet("XML5");
            XML5ExportExcel xml5ExportExcel = new XML5ExportExcel(workbook, sheetXML5);
            xml5ExportExcel.writeExcel((XML5) fhs5.xmlDetail);
        }

        FILEHOSO fhs7 = hoso.findXMLFile(XMLType.XML7);
        if (fhs7 != null) {
            Sheet sheetXML7 = workbook.createSheet("XML7");
            XML7ExportExcel xml7ExportExcel = new XML7ExportExcel(workbook, sheetXML7);
            xml7ExportExcel.writeExcel((XML7) fhs7.xmlDetail);
        }

        FILEHOSO fhs8 = hoso.findXMLFile(XMLType.XML8);
        if (fhs8 != null) {
            Sheet sheetXML8 = workbook.createSheet("XML8");
            XML8ExportExcel xml8ExportExcel = new XML8ExportExcel(workbook, sheetXML8);
            xml8ExportExcel.writeExcel((XML8) fhs8.xmlDetail);
        }

        FILEHOSO fhs9 = hoso.findXMLFile(XMLType.XML9);
        if (fhs9 != null) {
            Sheet sheetXML9 = workbook.createSheet("XML9");
            XML9ExportExcel xml9ExportExcel = new XML9ExportExcel(workbook, sheetXML9);
            xml9ExportExcel.writeExcel((XML9) fhs9.xmlDetail);
        }

        FILEHOSO fhs10 = hoso.findXMLFile(XMLType.XML10);
        if (fhs10 != null) {
            Sheet sheetXML10 = workbook.createSheet("XML10");
            XML10ExportExcel xml10ExportExcel = new XML10ExportExcel(workbook, sheetXML10);
            xml10ExportExcel.writeExcel((XML10) fhs10.xmlDetail);
        }

        FILEHOSO fhs11 = hoso.findXMLFile(XMLType.XML11);
        if (fhs11 != null) {
            Sheet sheetXML9 = workbook.createSheet("XML11");
            XML11ExportExcel xml11ExportExcel = new XML11ExportExcel(workbook, sheetXML9);
            xml11ExportExcel.writeExcel((XML11) fhs11.xmlDetail);
        }
        //Export
        createOutputFile(workbook, excelFilePath);
    }


    private static void createOutputFile(Workbook workbook, String excelFilePath) throws IOException {
        try (OutputStream os = new FileOutputStream(excelFilePath)) {
            workbook.write(os);
        }
    }

    public static Workbook getWorkbook(String excelFilePath) {
        Workbook workbook = null;
        if (excelFilePath.endsWith("xlsx")) {
            workbook = new XSSFWorkbook();
        } else if (excelFilePath.endsWith("xls")) {
            workbook = new HSSFWorkbook();
        } else {
            throw new IllegalArgumentException("The specified file is not Excel file");
        }
        return workbook;
    }
}
