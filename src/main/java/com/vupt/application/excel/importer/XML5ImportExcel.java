package com.vupt.application.excel.importer;

import com.vupt.application.exception.AppException;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML4Pack.CHI_TIET_CLS;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML4Pack.XML4;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML5Pack.CHI_TIET_DIEN_BIEN_BENH;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML5Pack.XML5;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class XML5ImportExcel {
    public static final int COLUMN_INDEX_MA_LK = 0;
    public static final int COLUMN_INDEX_STT = 1;
    public static final int COLUMN_INDEX_DIEN_BIEN_LS = 2;
    public static final int COLUMN_INDEX_GIAI_DOAN_BENH = 3;
    public static final int COLUMN_INDEX_HOI_CHAN = 4;
    public static final int COLUMN_INDEX_PHAU_THUAT = 5;
    public static final int COLUMN_INDEX_THOI_DIEM_DBLS = 6;
    public static final int COLUMN_INDEX_NGUOI_THUC_HIEN = 7;
    public static final int COLUMN_INDEX_DU_PHONG = 8;

    private Workbook workbook;
    private Sheet sheet;

    public XML5ImportExcel(Workbook workbook, Sheet sheet) {
        this.workbook = workbook;
        this.sheet = sheet;
    }

    public XML5 readExcel() throws IOException {

        Iterator<Row> iterator = sheet.iterator();
        Row firtsRow = iterator.next();
        XML5 xml5 = new XML5();
        List<CHI_TIET_DIEN_BIEN_BENH> ds_chi_tiet_dien_bien_benh = new ArrayList<>();

        while (iterator.hasNext()) {
            Row currentRow = iterator.next();
            CHI_TIET_DIEN_BIEN_BENH chi_tiet_dien_bien_benh = getValueFromRow(currentRow);
            ds_chi_tiet_dien_bien_benh.add(chi_tiet_dien_bien_benh);
        }

        xml5.dsach_chi_tiet_dien_bien_benh.ds_chi_tiet_dien_bien_benh = ds_chi_tiet_dien_bien_benh;
        return xml5;
    }

    private CHI_TIET_DIEN_BIEN_BENH getValueFromRow(Row currentRow) {
        try {
            DataFormatter fmt = new DataFormatter();
            CHI_TIET_DIEN_BIEN_BENH chi_tiet_dien_bien_benh = new CHI_TIET_DIEN_BIEN_BENH();
            chi_tiet_dien_bien_benh.MA_LK = currentRow.getCell(COLUMN_INDEX_MA_LK).getStringCellValue();
            chi_tiet_dien_bien_benh.STT = Integer.parseInt(fmt.formatCellValue(currentRow.getCell(COLUMN_INDEX_STT)));
            chi_tiet_dien_bien_benh.DIEN_BIEN_LS = currentRow.getCell(COLUMN_INDEX_DIEN_BIEN_LS).getStringCellValue();
            chi_tiet_dien_bien_benh.GIAI_DOAN_BENH = currentRow.getCell(COLUMN_INDEX_GIAI_DOAN_BENH).getStringCellValue();
            chi_tiet_dien_bien_benh.HOI_CHAN = currentRow.getCell(COLUMN_INDEX_HOI_CHAN).getStringCellValue();
            chi_tiet_dien_bien_benh.PHAU_THUAT = currentRow.getCell(COLUMN_INDEX_PHAU_THUAT).getStringCellValue();
            chi_tiet_dien_bien_benh.THOI_DIEM_DBLS = currentRow.getCell(COLUMN_INDEX_THOI_DIEM_DBLS).getStringCellValue();
            chi_tiet_dien_bien_benh.NGUOI_THUC_HIEN = currentRow.getCell(COLUMN_INDEX_NGUOI_THUC_HIEN).getStringCellValue();
            chi_tiet_dien_bien_benh.DU_PHONG = currentRow.getCell(COLUMN_INDEX_DU_PHONG).getStringCellValue();
            return chi_tiet_dien_bien_benh;
        } catch (Exception e) {
            throw new AppException("Đã có lỗi xảy ra khi truy xuất dữ liệu từ Excel bảng XML5 hàng thứ " + currentRow.getRowNum() + "\n" + e.toString() + ": " + e.getMessage(), e.getStackTrace());
        }
    }
}
