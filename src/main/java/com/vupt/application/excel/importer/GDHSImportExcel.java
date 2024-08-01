package com.vupt.application.excel.importer;

import com.vupt.application.builder.GDHSBuilder;
import com.vupt.application.constant.DatetimePattern;
import com.vupt.application.constant.XMLType;
import com.vupt.application.exception.GDHSException;
import com.vupt.application.model.gdhs.GIAMDINHHS;
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
import com.vupt.application.utils.DateTimeUtils;
import com.vupt.application.utils.PrinterUtils;
import com.vupt.application.utils.XMLValidator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * Class GDHSImportExcel nhập dữ liệu từ Excel ra đối tượng GIAMDINHHS java
 * */
public class GDHSImportExcel {

    public static GIAMDINHHS importExcelToGDHS(String excelFilePath) throws IOException {
        Workbook workbook = GDHSImportExcel.getWorkbook(excelFilePath);

        List<FILEHOSO> dsfilehoso = new ArrayList<>();

        Sheet sheetXML1 = workbook.getSheet("XML1");
        if (sheetXML1 != null) {
            XML1ImportExcel xml1ImportExcel = new XML1ImportExcel(workbook, sheetXML1);
            XML1 xml1 = xml1ImportExcel.readExcel();
            FILEHOSO fhs1 = new FILEHOSO(XMLType.XML1, xml1);
            dsfilehoso.add(fhs1);
        }

        Sheet sheetXML2 = workbook.getSheet("XML2");
        if (sheetXML2 != null) {
            XML2ImportExcel xml2ImportExcel = new XML2ImportExcel(workbook, sheetXML2);
            XML2 xml2 = xml2ImportExcel.readExcel();
            FILEHOSO fhs2 = new FILEHOSO(XMLType.XML2, xml2);
            dsfilehoso.add(fhs2);
        }

        Sheet sheetXML3 = workbook.getSheet("XML3");
        if (sheetXML3 != null) {
            XML3ImportExcel xml3ImportExcel = new XML3ImportExcel(workbook, sheetXML3);
            XML3 xml3 = xml3ImportExcel.readExcel();
            FILEHOSO fhs3 = new FILEHOSO(XMLType.XML3, xml3);
            dsfilehoso.add(fhs3);
        }

        Sheet sheetXML4 = workbook.getSheet("XML4");
        if (sheetXML4 != null) {
            XML4ImportExcel xml4ImportExcel = new XML4ImportExcel(workbook, sheetXML4);
            XML4 xml4 = xml4ImportExcel.readExcel();
            FILEHOSO fhs4 = new FILEHOSO(XMLType.XML4, xml4);
            dsfilehoso.add(fhs4);
        }

        Sheet sheetXML5 = workbook.getSheet("XML5");
        if (sheetXML5 != null) {
            XML5ImportExcel xml5ImportExcel = new XML5ImportExcel(workbook, sheetXML5);
            XML5 xml5 = xml5ImportExcel.readExcel();
            FILEHOSO fhs5 = new FILEHOSO(XMLType.XML5, xml5);
            dsfilehoso.add(fhs5);
        }

        Sheet sheetXML7 = workbook.getSheet("XML7");
        if (sheetXML7 != null) {
            XML7ImportExcel xml7ImportExcel = new XML7ImportExcel(workbook, sheetXML7);
            XML7 xml7 = xml7ImportExcel.readExcel();
            FILEHOSO fhs7 = new FILEHOSO(XMLType.XML7, xml7);
            dsfilehoso.add(fhs7);
        }

        Sheet sheetXML8 = workbook.getSheet("XML8");
        if (sheetXML8 != null) {
            XML8ImportExcel xml8ImportExcel = new XML8ImportExcel(workbook, sheetXML8);
            XML8 xml8 = xml8ImportExcel.readExcel();
            FILEHOSO fhs8 = new FILEHOSO(XMLType.XML8, xml8);
            dsfilehoso.add(fhs8);
        }

        Sheet sheetXML9 = workbook.getSheet("XML9");
        if (sheetXML9 != null) {
            XML9ImportExcel xml9ImportExcel = new XML9ImportExcel(workbook, sheetXML9);
            XML9 xml9 = xml9ImportExcel.readExcel();
            FILEHOSO fhs9 = new FILEHOSO(XMLType.XML9, xml9);
            dsfilehoso.add(fhs9);
        }

        Sheet sheetXML10 = workbook.getSheet("XML10");
        if (sheetXML10 != null) {
            XML10ImportExcel xml10ImportExcel = new XML10ImportExcel(workbook, sheetXML10);
            XML10 xml10 = xml10ImportExcel.readExcel();
            FILEHOSO fhs10 = new FILEHOSO(XMLType.XML10, xml10);
            dsfilehoso.add(fhs10);
        }

        Sheet sheetXML11 = workbook.getSheet("XML11");
        if (sheetXML11 != null) {
            XML11ImportExcel xml11ImportExcel = new XML11ImportExcel(workbook, sheetXML11);
            XML11 xml11 = xml11ImportExcel.readExcel();
            FILEHOSO fhs11 = new FILEHOSO(XMLType.XML11, xml11);
            dsfilehoso.add(fhs11);
        }

        List<String> errorMessages;
        XMLValidator xmlValidator=new XMLValidator(dsfilehoso);
        errorMessages=xmlValidator.validate();

       if(errorMessages.size()>0){
           PrinterUtils.printXMLErrors(errorMessages);
           throw new GDHSException("Validate XML data error occurred!");
       }

        HOSO hoso = new HOSO(dsfilehoso);
        GIAMDINHHS giamdinhhs = GDHSBuilder.getInstance()
                .setMACSKCB("75008")
                .setNGAYLAP(DateTimeUtils.getDateNow(DatetimePattern.DATE1.getPattern()))
                .setSOLUONGHOSO(1)
                .addHOSO(hoso)
                .getResult();
        return giamdinhhs;
    }

    public static Workbook getWorkbook(String excelFilePath) throws IOException {
        FileInputStream excelFile = new FileInputStream(new File(excelFilePath));
        Workbook workbook = null;
        if (excelFilePath.endsWith("xlsx")) {
            workbook = new XSSFWorkbook(excelFile);
        } else if (excelFilePath.endsWith("xls")) {
            workbook = new HSSFWorkbook(excelFile);
        } else {
            throw new IllegalArgumentException("The specified file is not Excel file");
        }
        excelFile.close();
        return workbook;
    }
}
