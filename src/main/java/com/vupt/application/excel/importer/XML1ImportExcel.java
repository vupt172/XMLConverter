package com.vupt.application.excel.importer;


import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML1Pack.XML1;
import com.vupt.application.utils.DataUtils;
import jdk.nashorn.internal.runtime.regexp.joni.ast.ConsAltNode;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jfree.chart.title.ShortTextTitle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Locale;

import static com.vupt.application.excel.exporter.GDHSExportExcel.getWorkbook;

public class XML1ImportExcel {
    public static final int COLUMN_INDEX_MA_LK = 0;
    public static final int COLUMN_INDEX_STT = 1;
    public static final int COLUMN_INDEX_MA_BN = 2;
    public static final int COLUMN_INDEX_HO_TEN = 3;
    public static final int COLUMN_INDEX_SO_CCCD = 4;
    public static final int COLUMN_INDEX_NGAY_SINH = 5;
    public static final int COLUMN_INDEX_GIOI_TINH = 6;
    public static final int COLUMN_INDEX_NHOM_MAU = 7;
    public static final int COLUMN_INDEX_MA_QUOC_TICH = 8;
    public static final int COLUMN_INDEX_MA_DAN_TOC = 9;
    public static final int COLUMN_INDEX_MA_NGHE_NGHIEP = 10;
    public static final int COLUMN_INDEX_DIA_CHI = 11;
    public static final int COLUMN_INDEX_MATINH_CU_TRU = 12;
    public static final int COLUMN_INDEX_MAHUYEN_CU_TRU = 13;
    public static final int COLUMN_INDEX_MAXA_CU_TRU = 14;
    public static final int COLUMN_INDEX_DIEN_THOAI = 15;
    public static final int COLUMN_INDEX_MA_THE_BHYT = 16;
    public static final int COLUMN_INDEX_MA_DKBD = 17;
    public static final int COLUMN_INDEX_GT_THE_TU = 18;
    public static final int COLUMN_INDEX_GT_THE_DEN = 19;
    public static final int COLUMN_INDEX_NGAY_MIEN_CCT = 20;
    public static final int COLUMN_INDEX_LY_DO_VV = 21;
    public static final int COLUMN_INDEX_LY_DO_VNT = 22;
    public static final int COLUMN_INDEX_MA_LY_DO_VNT = 23;
    public static final int COLUMN_INDEX_CHAN_DOAN_VAO = 24;
    public static final int COLUMN_INDEX_CHAN_DOAN_RV = 25;
    public static final int COLUMN_INDEX_MA_BENH_CHINH = 26;
    public static final int COLUMN_INDEX_MA_BENH_KT = 27;
    public static final int COLUMN_INDEX_MA_BENH_YHCT = 28;
    public static final int COLUMN_INDEX_MA_PTTT_QT = 29;
    public static final int COLUMN_INDEX_MA_DOITUONG_KCB = 30;
    public static final int COLUMN_INDEX_MA_NOI_DI = 31;
    public static final int COLUMN_INDEX_MA_NOI_DEN = 32;
    public static final int COLUMN_INDEX_MA_TAI_NAN = 33;
    public static final int COLUMN_INDEX_NGAY_VAO = 34;
    public static final int COLUMN_INDEX_NGAY_VAO_NOI_TRU = 35;
    public static final int COLUMN_INDEX_NGAY_RA = 36;
    public static final int COLUMN_INDEX_GIAY_CHUYEN_TUYEN = 37;
    public static final int COLUMN_INDEX_SO_NGAY_DTRI = 38;
    public static final int COLUMN_INDEX_PP_DIEU_TRI = 39;
    public static final int COLUMN_INDEX_KET_QUA_DTRI = 40;
    public static final int COLUMN_INDEX_MA_LOAI_RV = 41;
    public static final int COLUMN_INDEX_GHI_CHU = 42;
    public static final int COLUMN_INDEX_NGAY_TTOAN = 43;
    public static final int COLUMN_INDEX_T_THUOC = 44;
    public static final int COLUMN_INDEX_T_VTYT = 45;
    public static final int COLUMN_INDEX_T_TONGCHI_BV = 46;
    public static final int COLUMN_INDEX_T_TONGCHI_BH = 47;
    public static final int COLUMN_INDEX_T_BNTT = 48;
    public static final int COLUMN_INDEX_T_BNCCT = 49;
    public static final int COLUMN_INDEX_T_BHTT = 50;
    public static final int COLUMN_INDEX_T_NGUONKHAC = 51;
    public static final int COLUMN_INDEX_T_BHTT_GDV = 52;
    public static final int COLUMN_INDEX_NAM_QT = 53;
    public static final int COLUMN_INDEX_THANG_QT = 54;
    public static final int COLUMN_INDEX_MA_LOAI_KCB = 55;
    public static final int COLUMN_INDEX_MA_KHOA = 56;
    public static final int COLUMN_INDEX_MA_CSKCB = 57;
    public static final int COLUMN_INDEX_MA_KHUVUC = 58;
    public static final int COLUMN_INDEX_CAN_NANG = 59;
    public static final int COLUMN_INDEX_CAN_NANG_CON = 60;
    public static final int COLUMN_INDEX_NAM_NAM_LIEN_TUC = 61;
    public static final int COLUMN_INDEX_NGAY_TAI_KHAM = 62;
    public static final int COLUMN_INDEX_MA_HSBA = 63;
    public static final int COLUMN_INDEX_MA_TTDV = 64;
    public static final int COLUMN_INDEX_DU_PHONG = 65;


    private Workbook workbook;
    private Sheet sheet;

    public XML1ImportExcel(Workbook workbook, Sheet sheet) {
        this.workbook = workbook;
        this.sheet = sheet;
    }

    public XML1 readExcel() throws IOException {
        DataFormatter fmt= DataUtils.getExcelDataFormatter();
        Iterator<Row> iterator = sheet.iterator();
        Row firstRow = iterator.next();

        Row rowXML1 = iterator.next();
        XML1 xml1 = new XML1();
        xml1.MA_LK = rowXML1.getCell(COLUMN_INDEX_MA_LK).getStringCellValue();

        xml1.STT = Integer.parseInt(fmt.formatCellValue(rowXML1.getCell(COLUMN_INDEX_STT)));

        xml1.MA_BN = rowXML1.getCell(COLUMN_INDEX_MA_BN).getStringCellValue();

        xml1.HO_TEN = rowXML1.getCell(COLUMN_INDEX_HO_TEN).getStringCellValue();

        xml1.SO_CCCD = rowXML1.getCell(COLUMN_INDEX_SO_CCCD).getStringCellValue();

        xml1.NGAY_SINH = rowXML1.getCell(COLUMN_INDEX_NGAY_SINH).getStringCellValue();

        xml1.GIOI_TINH = Integer.parseInt(fmt.formatCellValue(rowXML1.getCell(COLUMN_INDEX_GIOI_TINH)));

        xml1.NHOM_MAU = rowXML1.getCell(COLUMN_INDEX_NHOM_MAU).getStringCellValue();

        xml1.MA_QUOCTICH = rowXML1.getCell(COLUMN_INDEX_MA_QUOC_TICH).getStringCellValue();

        xml1.MA_DANTOC = rowXML1.getCell(COLUMN_INDEX_MA_DAN_TOC).getStringCellValue();

        xml1.MA_NGHE_NGHIEP = rowXML1.getCell(COLUMN_INDEX_MA_NGHE_NGHIEP).getStringCellValue();

        xml1.DIA_CHI = rowXML1.getCell(COLUMN_INDEX_DIA_CHI).getStringCellValue();

        xml1.MATINH_CU_TRU = rowXML1.getCell(COLUMN_INDEX_MATINH_CU_TRU).getStringCellValue();

        xml1.MAHUYEN_CU_TRU = rowXML1.getCell(COLUMN_INDEX_MAHUYEN_CU_TRU).getStringCellValue();

        xml1.MAXA_CU_TRU = rowXML1.getCell(COLUMN_INDEX_MAXA_CU_TRU).getStringCellValue();

        xml1.DIEN_THOAI = rowXML1.getCell(COLUMN_INDEX_DIEN_THOAI).getStringCellValue();

        xml1.MA_THE_BHYT = rowXML1.getCell(COLUMN_INDEX_MA_THE_BHYT).getStringCellValue();

        xml1.MA_DKBD = rowXML1.getCell(COLUMN_INDEX_MA_DKBD).getStringCellValue();

        xml1.GT_THE_TU = rowXML1.getCell(COLUMN_INDEX_GT_THE_TU).getStringCellValue();

        xml1.GT_THE_DEN = rowXML1.getCell(COLUMN_INDEX_GT_THE_DEN).getStringCellValue();

        xml1.NGAY_MIEN_CCT = rowXML1.getCell(COLUMN_INDEX_NGAY_MIEN_CCT).getStringCellValue();

        xml1.LY_DO_VV = rowXML1.getCell(COLUMN_INDEX_LY_DO_VV).getStringCellValue();

        xml1.LY_DO_VNT = rowXML1.getCell(COLUMN_INDEX_LY_DO_VNT).getStringCellValue();

        xml1.MA_LY_DO_VNT = rowXML1.getCell(COLUMN_INDEX_MA_LY_DO_VNT).getStringCellValue();

        xml1.CHAN_DOAN_VAO = rowXML1.getCell(COLUMN_INDEX_CHAN_DOAN_VAO).getStringCellValue();

        xml1.CHAN_DOAN_RV = rowXML1.getCell(COLUMN_INDEX_CHAN_DOAN_RV).getStringCellValue();

        xml1.MA_BENH_CHINH = rowXML1.getCell(COLUMN_INDEX_MA_BENH_CHINH).getStringCellValue();

        xml1.MA_BENH_KT = rowXML1.getCell(COLUMN_INDEX_MA_BENH_KT).getStringCellValue();

        xml1.MA_BENH_YHCT = rowXML1.getCell(COLUMN_INDEX_MA_BENH_YHCT).getStringCellValue();

        xml1.MA_PTTT_QT = rowXML1.getCell(COLUMN_INDEX_MA_PTTT_QT).getStringCellValue();

        xml1.MA_DOITUONG_KCB = rowXML1.getCell(COLUMN_INDEX_MA_DOITUONG_KCB).getStringCellValue();

        xml1.MA_NOI_DI = rowXML1.getCell(COLUMN_INDEX_MA_NOI_DI).getStringCellValue();

        xml1.MA_NOI_DEN = rowXML1.getCell(COLUMN_INDEX_MA_NOI_DEN).getStringCellValue();

        xml1.MA_TAI_NAN = Integer.parseInt(fmt.formatCellValue(rowXML1.getCell(COLUMN_INDEX_MA_TAI_NAN)));

        xml1.NGAY_VAO = rowXML1.getCell(COLUMN_INDEX_NGAY_VAO).getStringCellValue();

        xml1.NGAY_VAO_NOI_TRU = rowXML1.getCell(COLUMN_INDEX_NGAY_VAO_NOI_TRU).getStringCellValue();

        xml1.NGAY_RA = rowXML1.getCell(COLUMN_INDEX_NGAY_RA).getStringCellValue();

        xml1.GIAY_CHUYEN_TUYEN = rowXML1.getCell(COLUMN_INDEX_GIAY_CHUYEN_TUYEN).getStringCellValue();

        xml1.SO_NGAY_DTRI = Integer.parseInt(fmt.formatCellValue(rowXML1.getCell(COLUMN_INDEX_SO_NGAY_DTRI)));
        xml1.PP_DIEU_TRI = rowXML1.getCell(COLUMN_INDEX_PP_DIEU_TRI).getStringCellValue();

        xml1.KET_QUA_DTRI = Integer.parseInt(fmt.formatCellValue(rowXML1.getCell(COLUMN_INDEX_KET_QUA_DTRI)));

        xml1.MA_LOAI_RV = Integer.parseInt(fmt.formatCellValue(rowXML1.getCell(COLUMN_INDEX_MA_LOAI_RV)));
        xml1.GHI_CHU = rowXML1.getCell(COLUMN_INDEX_GHI_CHU).getStringCellValue();

        xml1.NGAY_TTOAN = rowXML1.getCell(COLUMN_INDEX_NGAY_TTOAN).getStringCellValue();

        xml1.T_THUOC = Double.parseDouble(fmt.formatCellValue(rowXML1.getCell(COLUMN_INDEX_T_THUOC)));

        xml1.T_VTYT = Double.parseDouble(fmt.formatCellValue(rowXML1.getCell(COLUMN_INDEX_T_VTYT)));

        xml1.T_TONGCHI_BV = Double.parseDouble(fmt.formatCellValue(rowXML1.getCell(COLUMN_INDEX_T_TONGCHI_BV)));

        xml1.T_TONGCHI_BH = Double.parseDouble(fmt.formatCellValue(rowXML1.getCell(COLUMN_INDEX_T_TONGCHI_BH)));

        xml1.T_BNTT = Double.parseDouble(fmt.formatCellValue(rowXML1.getCell(COLUMN_INDEX_T_BNTT)));

        xml1.T_BNCCT = Double.parseDouble(fmt.formatCellValue(rowXML1.getCell(COLUMN_INDEX_T_BNCCT)));

        xml1.T_BHTT = Double.parseDouble(fmt.formatCellValue(rowXML1.getCell(COLUMN_INDEX_T_BHTT)));

        xml1.T_NGUONKHAC = Double.parseDouble(fmt.formatCellValue(rowXML1.getCell(COLUMN_INDEX_T_NGUONKHAC)));

        xml1.T_BHTT_GDV = Double.parseDouble(fmt.formatCellValue(rowXML1.getCell(COLUMN_INDEX_T_BHTT_GDV)));

        xml1.NAM_QT = Integer.parseInt(fmt.formatCellValue(rowXML1.getCell(COLUMN_INDEX_NAM_QT)));

        xml1.THANG_QT = Integer.parseInt(fmt.formatCellValue(rowXML1.getCell(COLUMN_INDEX_THANG_QT)));

        xml1.MA_LOAI_KCB = rowXML1.getCell(COLUMN_INDEX_MA_LOAI_KCB).getStringCellValue();

        xml1.MA_KHOA = rowXML1.getCell(COLUMN_INDEX_MA_KHOA).getStringCellValue();

        xml1.MA_CSKCB = rowXML1.getCell(COLUMN_INDEX_MA_CSKCB).getStringCellValue();

        xml1.MA_KHUVUC = rowXML1.getCell(COLUMN_INDEX_MA_KHUVUC).getStringCellValue();

        xml1.CAN_NANG = Double.parseDouble(fmt.formatCellValue(rowXML1.getCell(COLUMN_INDEX_CAN_NANG)));

        xml1.CAN_NANG_CON = rowXML1.getCell(COLUMN_INDEX_CAN_NANG_CON).getStringCellValue();

        xml1.NAM_NAM_LIEN_TUC = rowXML1.getCell(COLUMN_INDEX_NAM_NAM_LIEN_TUC).getStringCellValue();

        xml1.NGAY_TAI_KHAM = rowXML1.getCell(COLUMN_INDEX_NGAY_TAI_KHAM).getStringCellValue();

        xml1.MA_HSBA = rowXML1.getCell(COLUMN_INDEX_MA_HSBA).getStringCellValue();

        xml1.MA_TTDV = rowXML1.getCell(COLUMN_INDEX_MA_TTDV).getStringCellValue();

        xml1.DU_PHONG = rowXML1.getCell(COLUMN_INDEX_DU_PHONG).getStringCellValue();

        return xml1;
    }

}
