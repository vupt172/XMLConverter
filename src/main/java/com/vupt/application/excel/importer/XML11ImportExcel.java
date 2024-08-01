package com.vupt.application.excel.importer;

import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML10Pack.XML10;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML11Pack.XML11;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.IOException;
import java.util.Iterator;

public class XML11ImportExcel {
    public static final int COLUMN_INDEX_MA_LK = 0;
    public static final int COLUMN_INDEX_SO_CT = 1;
    public static final int COLUMN_INDEX_SO_SERI = 2;
    public static final int COLUMN_INDEX_SO_KCB = 3;
    public static final int COLUMN_INDEX_DON_VI = 4;
    public static final int COLUMN_INDEX_MA_BHXH = 5;
    public static final int COLUMN_INDEX_MA_THE_BHYT = 6;
    public static final int COLUMN_INDEX_CHAN_DOAN_RV = 7;
    public static final int COLUMN_INDEX_PP_DIEUTRI = 8;
    public static final int COLUMN_INDEX_MA_DINH_CHI_THAI = 9;
    public static final int COLUMN_INDEX_NGUYENNHAN_DINHCHI = 10;
    public static final int COLUMN_INDEX_TUOI_THAI = 11;
    public static final int COLUMN_INDEX_SO_NGAY_NGHI = 12;
    public static final int COLUMN_INDEX_TU_NGAY = 13;
    public static final int COLUMN_INDEX_DEN_NGAY = 14;
    public static final int COLUMN_INDEX_HO_TEN_CHA = 15;
    public static final int COLUMN_INDEX_HO_TEN_ME = 16;
    public static final int COLUMN_INDEX_MA_TTDV = 17;
    public static final int COLUMN_INDEX_MA_BS = 18;
    public static final int COLUMN_INDEX_NGAY_CT = 19;
    public static final int COLUMN_INDEX_MA_THE_TAM = 20;
    public static final int COLUMN_INDEX_MAU_SO = 21;
    public static final int COLUMN_INDEX_DU_PHONG = 22;

    private Workbook workbook;
    private Sheet sheet;

    public XML11ImportExcel(Workbook workbook, Sheet sheet) {
        this.workbook = workbook;
        this.sheet = sheet;
    }
    public XML11 readExcel() throws IOException {

        DataFormatter fmt = new DataFormatter();
        Iterator<Row> iterator = sheet.iterator();
        Row firstRow = iterator.next();

        Row currentRow = iterator.next();
        XML11 xml11 = new XML11();

        xml11.MA_LK = currentRow.getCell(COLUMN_INDEX_MA_LK).getStringCellValue();
        xml11.SO_CT = currentRow.getCell(COLUMN_INDEX_SO_CT).getStringCellValue();
        xml11.SO_SERI = currentRow.getCell(COLUMN_INDEX_SO_SERI).getStringCellValue();
        xml11.SO_KCB = currentRow.getCell(COLUMN_INDEX_SO_KCB).getStringCellValue();
        xml11.DON_VI = currentRow.getCell(COLUMN_INDEX_DON_VI).getStringCellValue();
        xml11.MA_BHXH = currentRow.getCell(COLUMN_INDEX_MA_BHXH).getStringCellValue();
        xml11.MA_THE_BHYT = currentRow.getCell(COLUMN_INDEX_MA_THE_BHYT).getStringCellValue();
        xml11.CHAN_DOAN_RV = currentRow.getCell(COLUMN_INDEX_CHAN_DOAN_RV).getStringCellValue();
        xml11.PP_DIEUTRI = currentRow.getCell(COLUMN_INDEX_PP_DIEUTRI).getStringCellValue();
        xml11.MA_DINH_CHI_THAI = Integer.parseInt(fmt.formatCellValue(currentRow.getCell(COLUMN_INDEX_MA_DINH_CHI_THAI)));
        xml11.NGUYENNHAN_DINHCHI = currentRow.getCell(COLUMN_INDEX_NGUYENNHAN_DINHCHI).getStringCellValue();

       String TUOI_THAI_STR=fmt.formatCellValue(currentRow.getCell(COLUMN_INDEX_TUOI_THAI));
        if(!TUOI_THAI_STR.trim().isEmpty())
            xml11.TUOI_THAI = Integer.parseInt(TUOI_THAI_STR);

        xml11.SO_NGAY_NGHI = Integer.parseInt(fmt.formatCellValue(currentRow.getCell(COLUMN_INDEX_SO_NGAY_NGHI)));
        xml11.TU_NGAY = currentRow.getCell(COLUMN_INDEX_TU_NGAY).getStringCellValue();
        xml11.DEN_NGAY = currentRow.getCell(COLUMN_INDEX_DEN_NGAY).getStringCellValue();
        xml11.HO_TEN_CHA = currentRow.getCell(COLUMN_INDEX_HO_TEN_CHA).getStringCellValue();
        xml11.HO_TEN_ME = currentRow.getCell(COLUMN_INDEX_HO_TEN_ME).getStringCellValue();
        xml11.MA_TTDV = currentRow.getCell(COLUMN_INDEX_MA_TTDV).getStringCellValue();
        xml11.MA_BS = currentRow.getCell(COLUMN_INDEX_MA_BS).getStringCellValue();
        xml11.NGAY_CT = currentRow.getCell(COLUMN_INDEX_NGAY_CT).getStringCellValue();
        xml11.MA_THE_TAM = currentRow.getCell(COLUMN_INDEX_MA_THE_TAM).getStringCellValue();
        xml11.MAU_SO = currentRow.getCell(COLUMN_INDEX_MAU_SO).getStringCellValue();
        xml11.DU_PHONG = currentRow.getCell(COLUMN_INDEX_DU_PHONG).getStringCellValue();
        return xml11;
    }
}
