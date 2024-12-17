package com.vupt.application.excel.importer;

import com.vupt.application.exception.AppException;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML1Pack.XML1;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML7Pack.XML7;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.IOException;
import java.util.Iterator;

public class XML7ImportExcel {
    public static final int COLUMN_INDEX_MA_LK = 0;
    public static final int COLUMN_INDEX_SO_LUU_TRU = 1;
    public static final int COLUMN_INDEX_MA_YTE = 2;
    public static final int COLUMN_INDEX_MA_KHOA_RV = 3;
    public static final int COLUMN_INDEX_NGAY_VAO = 4;
    public static final int COLUMN_INDEX_NGAY_RA = 5;
    public static final int COLUMN_INDEX_MA_DINH_CHI_THAI = 6;
    public static final int COLUMN_INDEX_NGUYENNHAN_DINHCHI = 7;
    public static final int COLUMN_INDEX_THOIGIAN_DINHCHI = 8;
    public static final int COLUMN_INDEX_TUOI_THAI = 9;
    public static final int COLUMN_INDEX_CHAN_DOAN_RV = 10;
    public static final int COLUMN_INDEX_PP_DIEUTRI = 11;
    public static final int COLUMN_INDEX_GHI_CHU = 12;
    public static final int COLUMN_INDEX_MA_TTDV = 13;
    public static final int COLUMN_INDEX_MA_BS = 14;
    public static final int COLUMN_INDEX_TEN_BS = 15;
    public static final int COLUMN_INDEX_NGAY_CT = 16;
    public static final int COLUMN_INDEX_MA_CHA = 17;
    public static final int COLUMN_INDEX_MA_ME = 18;
    public static final int COLUMN_INDEX_MA_THE_TAM = 19;
    public static final int COLUMN_INDEX_HO_TEN_CHA = 20;
    public static final int COLUMN_INDEX_HO_TEN_ME = 21;
    public static final int COLUMN_INDEX_SO_NGAY_NGHI = 22;
    public static final int COLUMN_INDEX_NGOAITRU_TUNGAY = 23;
    public static final int COLUMN_INDEX_NGOAITRU_DENNGAY = 24;
    public static final int COLUMN_INDEX_DU_PHONG = 25;
    private Workbook workbook;
    private Sheet sheet;

    public XML7ImportExcel(Workbook workbook, Sheet sheet) {
        this.workbook = workbook;
        this.sheet = sheet;
    }

    public XML7 readExcel() throws IOException {
        Iterator<Row> iterator = sheet.iterator();
        Row firstRow = iterator.next();
        Row currentRow = iterator.next();
        XML7 xml7 = getValueFromRow(currentRow);
        return xml7;
    }

    private XML7 getValueFromRow(Row currentRow) {
        try {
            DataFormatter fmt = new DataFormatter();
            XML7 xml7 = new XML7();
            xml7.MA_LK = currentRow.getCell(COLUMN_INDEX_MA_LK).getStringCellValue();
            xml7.SO_LUU_TRU = currentRow.getCell(COLUMN_INDEX_SO_LUU_TRU).getStringCellValue();
            xml7.MA_YTE = currentRow.getCell(COLUMN_INDEX_MA_YTE).getStringCellValue();
            xml7.MA_KHOA_RV = currentRow.getCell(COLUMN_INDEX_MA_KHOA_RV).getStringCellValue();
            xml7.NGAY_VAO = currentRow.getCell(COLUMN_INDEX_NGAY_VAO).getStringCellValue();
            xml7.NGAY_RA = currentRow.getCell(COLUMN_INDEX_NGAY_RA).getStringCellValue();
            xml7.MA_DINH_CHI_THAI = Integer.parseInt(fmt.formatCellValue(currentRow.getCell(COLUMN_INDEX_MA_DINH_CHI_THAI)));
            xml7.NGUYENNHAN_DINHCHI = currentRow.getCell(COLUMN_INDEX_NGUYENNHAN_DINHCHI).getStringCellValue();
            xml7.THOIGIAN_DINHCHI = currentRow.getCell(COLUMN_INDEX_THOIGIAN_DINHCHI).getStringCellValue();

            String TUOI_THAI_STR = fmt.formatCellValue(currentRow.getCell(COLUMN_INDEX_TUOI_THAI));
            if (!TUOI_THAI_STR.trim().isEmpty())
                xml7.TUOI_THAI = Integer.parseInt(TUOI_THAI_STR);

            xml7.CHAN_DOAN_RV = currentRow.getCell(COLUMN_INDEX_CHAN_DOAN_RV).getStringCellValue();
            xml7.PP_DIEUTRI = currentRow.getCell(COLUMN_INDEX_PP_DIEUTRI).getStringCellValue();
            xml7.GHI_CHU = currentRow.getCell(COLUMN_INDEX_GHI_CHU).getStringCellValue();
            xml7.MA_TTDV = currentRow.getCell(COLUMN_INDEX_MA_TTDV).getStringCellValue();
            xml7.MA_BS = currentRow.getCell(COLUMN_INDEX_MA_BS).getStringCellValue();
            xml7.TEN_BS = currentRow.getCell(COLUMN_INDEX_TEN_BS).getStringCellValue();
            xml7.NGAY_CT = currentRow.getCell(COLUMN_INDEX_NGAY_CT).getStringCellValue();
            xml7.MA_CHA = currentRow.getCell(COLUMN_INDEX_MA_CHA).getStringCellValue();
            xml7.MA_ME = currentRow.getCell(COLUMN_INDEX_MA_ME).getStringCellValue();
            xml7.MA_THE_TAM = currentRow.getCell(COLUMN_INDEX_MA_THE_TAM).getStringCellValue();
            xml7.HO_TEN_CHA = currentRow.getCell(COLUMN_INDEX_HO_TEN_CHA).getStringCellValue();
            xml7.HO_TEN_ME = currentRow.getCell(COLUMN_INDEX_HO_TEN_ME).getStringCellValue();

            String SO_NGAY_NGHI_STR = fmt.formatCellValue(currentRow.getCell(COLUMN_INDEX_SO_NGAY_NGHI));
            if (!SO_NGAY_NGHI_STR.trim().isEmpty())
                xml7.SO_NGAY_NGHI = Integer.parseInt(SO_NGAY_NGHI_STR);

            xml7.NGOAITRU_TUNGAY = currentRow.getCell(COLUMN_INDEX_NGOAITRU_TUNGAY).getStringCellValue();
            xml7.NGOAITRU_DENNGAY = currentRow.getCell(COLUMN_INDEX_NGOAITRU_DENNGAY).getStringCellValue();
            xml7.DU_PHONG = currentRow.getCell(COLUMN_INDEX_DU_PHONG).getStringCellValue();
            return xml7;
        } catch (Exception e) {
            throw new AppException("Đã có lỗi xảy ra khi truy xuất dữ liệu từ Excel bảng XML7 hàng thứ " + currentRow.getRowNum() + "\n" + e.toString() + ": " + e.getMessage(), e.getStackTrace());
        }
    }
}
