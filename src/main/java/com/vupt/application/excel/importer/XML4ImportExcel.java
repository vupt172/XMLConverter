package com.vupt.application.excel.importer;

import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML3Pack.XML3;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML4Pack.CHI_TIET_CLS;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML4Pack.XML4;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class XML4ImportExcel {
    public static final int COLUMN_INDEX_MA_LK = 0;
    public static final int COLUMN_INDEX_STT = 1;
    public static final int COLUMN_INDEX_MA_DICH_VU = 2;
    public static final int COLUMN_INDEX_MA_CHI_SO = 3;
    public static final int COLUMN_INDEX_TEN_CHI_SO = 4;
    public static final int COLUMN_INDEX_GIA_TRI = 5;
    public static final int COLUMN_INDEX_DON_VI_DO = 6;
    public static final int COLUMN_INDEX_MO_TA = 7;
    public static final int COLUMN_INDEX_KET_LUAN = 8;
    public static final int COLUMN_INDEX_NGAY_KQ = 9;
    public static final int COLUMN_INDEX_MA_BS_DOC_KQ = 10;
    public static final int COLUMN_INDEX_DU_PHONG = 11;

    private Workbook workbook;
    private Sheet sheet;

    public XML4ImportExcel(Workbook workbook, Sheet sheet) {
        this.workbook = workbook;
        this.sheet = sheet;
    }

    public XML4 readExcel() throws IOException {

        DataFormatter fmt = new DataFormatter();
        Iterator<Row> iterator = sheet.iterator();
        Row firstRow = iterator.next();
        XML4 xml4 = new XML4();
        List<CHI_TIET_CLS> ds_chi_tiet_cls = new ArrayList<>();

        while (iterator.hasNext()) {
            Row currentRow = iterator.next();
            CHI_TIET_CLS chi_tiet_cls = new CHI_TIET_CLS();

            chi_tiet_cls.MA_LK = currentRow.getCell(COLUMN_INDEX_MA_LK).getStringCellValue();
            chi_tiet_cls.STT = Integer.parseInt(fmt.formatCellValue(currentRow.getCell(COLUMN_INDEX_STT)));
            chi_tiet_cls.MA_DICH_VU = currentRow.getCell(COLUMN_INDEX_MA_DICH_VU).getStringCellValue();
            chi_tiet_cls.MA_CHI_SO = currentRow.getCell(COLUMN_INDEX_MA_CHI_SO).getStringCellValue();
            chi_tiet_cls.TEN_CHI_SO = currentRow.getCell(COLUMN_INDEX_TEN_CHI_SO).getStringCellValue();
            chi_tiet_cls.GIA_TRI = currentRow.getCell(COLUMN_INDEX_GIA_TRI).getStringCellValue();
            chi_tiet_cls.DON_VI_DO = currentRow.getCell(COLUMN_INDEX_DON_VI_DO).getStringCellValue();
            chi_tiet_cls.MO_TA = currentRow.getCell(COLUMN_INDEX_MO_TA).getStringCellValue();
            chi_tiet_cls.KET_LUAN = currentRow.getCell(COLUMN_INDEX_KET_LUAN).getStringCellValue();
            chi_tiet_cls.NGAY_KQ = currentRow.getCell(COLUMN_INDEX_NGAY_KQ).getStringCellValue();
            chi_tiet_cls.MA_BS_DOC_KQ = currentRow.getCell(COLUMN_INDEX_MA_BS_DOC_KQ).getStringCellValue();
            chi_tiet_cls.DU_PHONG = currentRow.getCell(COLUMN_INDEX_DU_PHONG).getStringCellValue();

            ds_chi_tiet_cls.add(chi_tiet_cls);

        }
        xml4.dsach_chi_tiet_cls.ds_chi_tiet_cls = ds_chi_tiet_cls;
        return xml4;
    }
}
