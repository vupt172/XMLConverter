package com.vupt.application.excel.importer;

import com.vupt.application.exception.AppException;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML7Pack.XML7;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML8Pack.XML8;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.IOException;
import java.util.Iterator;

public class XML8ImportExcel {
    public static final int COLUMN_INDEX_MA_LK = 0;
    public static final int COLUMN_INDEX_MA_LOAI_KCB = 1;
    public static final int COLUMN_INDEX_HO_TEN_CHA = 2;
    public static final int COLUMN_INDEX_HO_TEN_ME = 3;
    public static final int COLUMN_INDEX_NGUOI_GIAM_HO = 4;
    public static final int COLUMN_INDEX_DON_VI = 5;
    public static final int COLUMN_INDEX_NGAY_VAO = 6;
    public static final int COLUMN_INDEX_NGAY_RA = 7;
    public static final int COLUMN_INDEX_CHAN_DOAN_VAO = 8;
    public static final int COLUMN_INDEX_CHAN_DOAN_RV = 9;
    public static final int COLUMN_INDEX_QT_BENHLY = 10;
    public static final int COLUMN_INDEX_TOMTAT_KQ = 11;
    public static final int COLUMN_INDEX_PP_DIEUTRI = 12;
    public static final int COLUMN_INDEX_NGAY_SINHCON = 13;
    public static final int COLUMN_INDEX_NGAY_CONCHET = 14;
    public static final int COLUMN_INDEX_SO_CONCHET = 15;
    public static final int COLUMN_INDEX_KET_QUA_DTRI = 16;
    public static final int COLUMN_INDEX_GHI_CHU = 17;
    public static final int COLUMN_INDEX_MA_TTDV = 18;
    public static final int COLUMN_INDEX_NGAY_CT = 19;
    public static final int COLUMN_INDEX_MA_THE_TAM = 20;
    public static final int COLUMN_INDEX_DU_PHONG = 21;

    private Workbook workbook;
    private Sheet sheet;

    public XML8ImportExcel(Workbook workbook, Sheet sheet) {
        this.workbook = workbook;
        this.sheet = sheet;
    }

    public XML8 readExcel() throws IOException {

        Iterator<Row> iterator = sheet.iterator();
        Row firstRow = iterator.next();
        Row currentRow = iterator.next();
        XML8 xml8 = getValueFromRow(currentRow);
        return xml8;

    }

    private XML8 getValueFromRow(Row currentRow) {
        try {
            DataFormatter fmt = new DataFormatter();
            XML8 xml8 = new XML8();
            xml8.MA_LK = currentRow.getCell(COLUMN_INDEX_MA_LK).getStringCellValue();
            xml8.MA_LOAI_KCB = currentRow.getCell(COLUMN_INDEX_MA_LOAI_KCB).getStringCellValue();
            xml8.HO_TEN_CHA = currentRow.getCell(COLUMN_INDEX_HO_TEN_CHA).getStringCellValue();
            xml8.HO_TEN_ME = currentRow.getCell(COLUMN_INDEX_HO_TEN_ME).getStringCellValue();
            xml8.NGUOI_GIAM_HO = currentRow.getCell(COLUMN_INDEX_NGUOI_GIAM_HO).getStringCellValue();
            xml8.DON_VI = currentRow.getCell(COLUMN_INDEX_DON_VI).getStringCellValue();
            xml8.NGAY_VAO = currentRow.getCell(COLUMN_INDEX_NGAY_VAO).getStringCellValue();
            xml8.NGAY_RA = currentRow.getCell(COLUMN_INDEX_NGAY_RA).getStringCellValue();
            xml8.CHAN_DOAN_VAO = currentRow.getCell(COLUMN_INDEX_CHAN_DOAN_VAO).getStringCellValue();
            xml8.CHAN_DOAN_RV = currentRow.getCell(COLUMN_INDEX_CHAN_DOAN_RV).getStringCellValue();
            xml8.QT_BENHLY = currentRow.getCell(COLUMN_INDEX_QT_BENHLY).getStringCellValue();
            xml8.TOMTAT_KQ = currentRow.getCell(COLUMN_INDEX_TOMTAT_KQ).getStringCellValue();
            xml8.PP_DIEUTRI = currentRow.getCell(COLUMN_INDEX_PP_DIEUTRI).getStringCellValue();
            xml8.NGAY_SINHCON = currentRow.getCell(COLUMN_INDEX_NGAY_SINHCON).getStringCellValue();
            xml8.NGAY_CONCHET = currentRow.getCell(COLUMN_INDEX_NGAY_CONCHET).getStringCellValue();

            String SO_CONCHET_STR = fmt.formatCellValue(currentRow.getCell(COLUMN_INDEX_SO_CONCHET));
            if (!SO_CONCHET_STR.trim().isEmpty())
                xml8.SO_CONCHET = Integer.parseInt(SO_CONCHET_STR);

            xml8.KET_QUA_DTRI = Integer.parseInt(fmt.formatCellValue(currentRow.getCell(COLUMN_INDEX_KET_QUA_DTRI)));
            xml8.GHI_CHU = currentRow.getCell(COLUMN_INDEX_GHI_CHU).getStringCellValue();
            xml8.MA_TTDV = currentRow.getCell(COLUMN_INDEX_MA_TTDV).getStringCellValue();
            xml8.NGAY_CT = currentRow.getCell(COLUMN_INDEX_NGAY_CT).getStringCellValue();
            xml8.MA_THE_TAM = currentRow.getCell(COLUMN_INDEX_MA_THE_TAM).getStringCellValue();
            xml8.DU_PHONG = currentRow.getCell(COLUMN_INDEX_DU_PHONG).getStringCellValue();
            return xml8;
        } catch (Exception e) {
            throw new AppException("Đã có lỗi xảy ra khi truy xuất dữ liệu từ Excel bảng XML8 hàng thứ " + currentRow.getRowNum() + "\n" + e.toString() + ": " + e.getMessage(), e.getStackTrace());
        }

    }
}
