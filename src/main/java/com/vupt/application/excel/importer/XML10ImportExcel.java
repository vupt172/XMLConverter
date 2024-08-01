package com.vupt.application.excel.importer;

import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML10Pack.XML10;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML1Pack.XML1;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.IOException;
import java.util.Iterator;

public class XML10ImportExcel {
    public static final int COLUMN_INDEX_MA_LK = 0;
    public static final int COLUMN_INDEX_SO_SERI = 1;
    public static final int COLUMN_INDEX_SO_CT = 2;
    public static final int COLUMN_INDEX_SO_NGAY = 3;
    public static final int COLUMN_INDEX_DON_VI = 4;
    public static final int COLUMN_INDEX_CHAN_DOAN_RV = 5;
    public static final int COLUMN_INDEX_TU_NGAY = 6;
    public static final int COLUMN_INDEX_DEN_NGAY = 7;
    public static final int COLUMN_INDEX_MA_TTDV = 8;
    public static final int COLUMN_INDEX_TEN_BS = 9;
    public static final int COLUMN_INDEX_MA_BS = 10;
    public static final int COLUMN_INDEX_NGAY_CT = 11;
    public static final int COLUMN_INDEX_DU_PHONG = 12;

    private Workbook workbook;
    private Sheet sheet;

    public XML10ImportExcel(Workbook workbook, Sheet sheet) {
        this.workbook = workbook;
        this.sheet = sheet;
    }
    public XML10 readExcel() throws IOException {

        DataFormatter fmt = new DataFormatter();
        Iterator<Row> iterator = sheet.iterator();
        Row firstRow = iterator.next();

        Row currentRow = iterator.next();
        XML10 xml10 = new XML10();
        xml10.MA_LK = currentRow.getCell(COLUMN_INDEX_MA_LK).getStringCellValue();
        xml10.SO_SERI = currentRow.getCell(COLUMN_INDEX_SO_SERI).getStringCellValue();
        xml10.SO_CT = currentRow.getCell(COLUMN_INDEX_SO_CT).getStringCellValue();
        xml10.SO_NGAY = Integer.parseInt(fmt.formatCellValue(currentRow.getCell(COLUMN_INDEX_SO_NGAY)));
        xml10.DON_VI = currentRow.getCell(COLUMN_INDEX_DON_VI).getStringCellValue();
        xml10.CHAN_DOAN_RV = currentRow.getCell(COLUMN_INDEX_CHAN_DOAN_RV).getStringCellValue();
        xml10.TU_NGAY = currentRow.getCell(COLUMN_INDEX_TU_NGAY).getStringCellValue();
        xml10.DEN_NGAY = currentRow.getCell(COLUMN_INDEX_DEN_NGAY).getStringCellValue();
        xml10.MA_TTDV = currentRow.getCell(COLUMN_INDEX_MA_TTDV).getStringCellValue();
        xml10.TEN_BS = currentRow.getCell(COLUMN_INDEX_TEN_BS).getStringCellValue();
        xml10.MA_BS = currentRow.getCell(COLUMN_INDEX_MA_BS).getStringCellValue();
        xml10.NGAY_CT = currentRow.getCell(COLUMN_INDEX_NGAY_CT).getStringCellValue();
        xml10.DU_PHONG = currentRow.getCell(COLUMN_INDEX_DU_PHONG).getStringCellValue();

        return xml10;
    }
}
