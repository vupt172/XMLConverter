package com.vupt.application.excel.importer;

import com.vupt.application.exception.AppException;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML2Pack.XML2;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML3Pack.CHI_TIET_DVKT;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML3Pack.XML3;
import com.vupt.application.utils.DataUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class XML3ImportExcel {
    public static final int COLUMN_INDEX_MA_LK = 0;
    public static final int COLUMN_INDEX_STT = 1;
    public static final int COLUMN_INDEX_MA_DICH_VU = 2;
    public static final int COLUMN_INDEX_MA_PTTT_QT = 3;
    public static final int COLUMN_INDEX_MA_VAT_TU = 4;
    public static final int COLUMN_INDEX_MA_NHOM = 5;
    public static final int COLUMN_INDEX_GOI_VTYT = 6;
    public static final int COLUMN_INDEX_TEN_VAT_TU = 7;
    public static final int COLUMN_INDEX_TEN_DICH_VU = 8;
    public static final int COLUMN_INDEX_MA_XANG_DAU = 9;
    public static final int COLUMN_INDEX_DON_VI_TINH = 10;
    public static final int COLUMN_INDEX_PHAM_VI = 11;
    public static final int COLUMN_INDEX_SO_LUONG = 12;
    public static final int COLUMN_INDEX_DON_GIA_BV = 13;
    public static final int COLUMN_INDEX_DON_GIA_BH = 14;
    public static final int COLUMN_INDEX_TT_THAU = 15;
    public static final int COLUMN_INDEX_TYLE_TT_DV = 16;
    public static final int COLUMN_INDEX_TYLE_TT_BH = 17;
    public static final int COLUMN_INDEX_THANH_TIEN_BV = 18;
    public static final int COLUMN_INDEX_THANH_TIEN_BH = 19;
    public static final int COLUMN_INDEX_T_TRANTT = 20;
    public static final int COLUMN_INDEX_MUC_HUONG = 21;
    public static final int COLUMN_INDEX_T_NGUONKHAC_NSNN = 22;
    public static final int COLUMN_INDEX_T_NGUONKHAC_VTNN = 23;
    public static final int COLUMN_INDEX_T_NGUONKHAC_VTTN = 24;
    public static final int COLUMN_INDEX_T_NGUONKHAC_CL = 25;
    public static final int COLUMN_INDEX_T_NGUONKHAC = 26;
    public static final int COLUMN_INDEX_T_BNTT = 27;
    public static final int COLUMN_INDEX_T_BNCCT = 28;
    public static final int COLUMN_INDEX_T_BHTT = 29;
    public static final int COLUMN_INDEX_MA_KHOA = 30;
    public static final int COLUMN_INDEX_MA_GIUONG = 31;
    public static final int COLUMN_INDEX_MA_BAC_SI = 32;
    public static final int COLUMN_INDEX_NGUOI_THUC_HIEN = 33;
    public static final int COLUMN_INDEX_MA_BENH = 34;
    public static final int COLUMN_INDEX_MA_BENH_YHCT = 35;
    public static final int COLUMN_INDEX_NGAY_YL = 36;
    public static final int COLUMN_INDEX_NGAY_TH_YL = 37;
    public static final int COLUMN_INDEX_NGAY_KQ = 38;
    public static final int COLUMN_INDEX_MA_PTTT = 39;
    public static final int COLUMN_INDEX_VET_THUONG_TP = 40;
    public static final int COLUMN_INDEX_PP_VO_CAM = 41;
    public static final int COLUMN_INDEX_VI_TRI_TH_DVKT = 42;
    public static final int COLUMN_INDEX_MA_MAY = 43;
    public static final int COLUMN_INDEX_MA_HIEU_SP = 44;
    public static final int COLUMN_INDEX_TAI_SU_DUNG = 45;
    public static final int COLUMN_INDEX_DU_PHONG = 46;

    private Workbook workbook;
    private Sheet sheet;

    public XML3ImportExcel(Workbook workbook, Sheet sheet) {
        this.workbook = workbook;
        this.sheet = sheet;
    }


    public XML3 readExcel() throws IOException {

        Iterator<Row> iterator = sheet.iterator();
        Row firstRow = iterator.next();
        XML3 xml3 = new XML3();

        List<CHI_TIET_DVKT> ds_chi_tiet_dvkt = new ArrayList<>();
        while (iterator.hasNext()) {
            Row currentRow = iterator.next();
            CHI_TIET_DVKT chi_tiet_dvkt=getValueFromRow(currentRow);
            ds_chi_tiet_dvkt.add(chi_tiet_dvkt);
        }
        xml3.dsach_chi_tiet_dvkt.ds_chi_tiet_dvkt = ds_chi_tiet_dvkt;
        return xml3;
    }
    private CHI_TIET_DVKT getValueFromRow(Row currentRow){

        DataFormatter fmt = DataUtils.getExcelDataFormatter();
        try {
            CHI_TIET_DVKT chi_tiet_dvkt = new CHI_TIET_DVKT();
            chi_tiet_dvkt.MA_LK = currentRow.getCell(COLUMN_INDEX_MA_LK).getStringCellValue();

            chi_tiet_dvkt.STT = Integer.parseInt(fmt.formatCellValue(currentRow.getCell(COLUMN_INDEX_STT)));

            chi_tiet_dvkt.MA_DICH_VU = currentRow.getCell(COLUMN_INDEX_MA_DICH_VU).getStringCellValue();

            chi_tiet_dvkt.MA_PTTT_QT = currentRow.getCell(COLUMN_INDEX_MA_PTTT_QT).getStringCellValue();

            chi_tiet_dvkt.MA_VAT_TU = currentRow.getCell(COLUMN_INDEX_MA_VAT_TU).getStringCellValue();

            chi_tiet_dvkt.MA_NHOM = Integer.parseInt(fmt.formatCellValue(currentRow.getCell(COLUMN_INDEX_MA_NHOM)));

            chi_tiet_dvkt.GOI_VTYT = currentRow.getCell(COLUMN_INDEX_GOI_VTYT).getStringCellValue();

            chi_tiet_dvkt.TEN_VAT_TU = currentRow.getCell(COLUMN_INDEX_TEN_VAT_TU).getStringCellValue();

            chi_tiet_dvkt.TEN_DICH_VU = currentRow.getCell(COLUMN_INDEX_TEN_DICH_VU).getStringCellValue();

            chi_tiet_dvkt.MA_XANG_DAU = currentRow.getCell(COLUMN_INDEX_MA_XANG_DAU).getStringCellValue();

            chi_tiet_dvkt.DON_VI_TINH = currentRow.getCell(COLUMN_INDEX_DON_VI_TINH).getStringCellValue();

            chi_tiet_dvkt.PHAM_VI = Integer.parseInt(fmt.formatCellValue(currentRow.getCell(COLUMN_INDEX_PHAM_VI)));

            chi_tiet_dvkt.SO_LUONG = Double.parseDouble(fmt.formatCellValue(currentRow.getCell(COLUMN_INDEX_SO_LUONG)));

            chi_tiet_dvkt.DON_GIA_BV = Double.parseDouble(fmt.formatCellValue(currentRow.getCell(COLUMN_INDEX_DON_GIA_BV)));

            chi_tiet_dvkt.DON_GIA_BH = Double.parseDouble(fmt.formatCellValue(currentRow.getCell(COLUMN_INDEX_DON_GIA_BH)));

            chi_tiet_dvkt.TT_THAU = currentRow.getCell(COLUMN_INDEX_TT_THAU).getStringCellValue();

            chi_tiet_dvkt.TYLE_TT_DV = Integer.parseInt(fmt.formatCellValue(currentRow.getCell(COLUMN_INDEX_TYLE_TT_DV)));

            chi_tiet_dvkt.TYLE_TT_BH = Integer.parseInt(fmt.formatCellValue(currentRow.getCell(COLUMN_INDEX_TYLE_TT_BH)));

            chi_tiet_dvkt.THANH_TIEN_BV = Double.parseDouble(fmt.formatCellValue(currentRow.getCell(COLUMN_INDEX_THANH_TIEN_BV)));

            chi_tiet_dvkt.THANH_TIEN_BH = Double.parseDouble(fmt.formatCellValue(currentRow.getCell(COLUMN_INDEX_THANH_TIEN_BH)));

            chi_tiet_dvkt.T_TRANTT = currentRow.getCell(COLUMN_INDEX_T_TRANTT).getStringCellValue();

            chi_tiet_dvkt.MUC_HUONG = Integer.parseInt(fmt.formatCellValue(currentRow.getCell(COLUMN_INDEX_MUC_HUONG)));

            chi_tiet_dvkt.T_NGUONKHAC_NSNN = Double.parseDouble(fmt.formatCellValue(currentRow.getCell(COLUMN_INDEX_T_NGUONKHAC_NSNN)));

            chi_tiet_dvkt.T_NGUONKHAC_VTNN = Double.parseDouble(fmt.formatCellValue(currentRow.getCell(COLUMN_INDEX_T_NGUONKHAC_VTNN)));

            chi_tiet_dvkt.T_NGUONKHAC_VTTN = Double.parseDouble(fmt.formatCellValue(currentRow.getCell(COLUMN_INDEX_T_NGUONKHAC_VTTN)));

            chi_tiet_dvkt.T_NGUONKHAC_CL = Double.parseDouble(fmt.formatCellValue(currentRow.getCell(COLUMN_INDEX_T_NGUONKHAC_CL)));

            chi_tiet_dvkt.T_NGUONKHAC = Double.parseDouble(fmt.formatCellValue(currentRow.getCell(COLUMN_INDEX_T_NGUONKHAC)));

            chi_tiet_dvkt.T_BNTT = Double.parseDouble(fmt.formatCellValue(currentRow.getCell(COLUMN_INDEX_T_BNTT)));

            chi_tiet_dvkt.T_BNCCT = Double.parseDouble(fmt.formatCellValue(currentRow.getCell(COLUMN_INDEX_T_BNCCT)));

            chi_tiet_dvkt.T_BHTT = Double.parseDouble(fmt.formatCellValue(currentRow.getCell(COLUMN_INDEX_T_BHTT)));

            chi_tiet_dvkt.MA_KHOA = currentRow.getCell(COLUMN_INDEX_MA_KHOA).getStringCellValue();

            chi_tiet_dvkt.MA_GIUONG = currentRow.getCell(COLUMN_INDEX_MA_GIUONG).getStringCellValue();

            chi_tiet_dvkt.MA_BAC_SI = currentRow.getCell(COLUMN_INDEX_MA_BAC_SI).getStringCellValue();

            chi_tiet_dvkt.NGUOI_THUC_HIEN = currentRow.getCell(COLUMN_INDEX_NGUOI_THUC_HIEN).getStringCellValue();

            chi_tiet_dvkt.MA_BENH = currentRow.getCell(COLUMN_INDEX_MA_BENH).getStringCellValue();

            chi_tiet_dvkt.MA_BENH_YHCT = currentRow.getCell(COLUMN_INDEX_MA_BENH_YHCT).getStringCellValue();

            chi_tiet_dvkt.NGAY_YL = currentRow.getCell(COLUMN_INDEX_NGAY_YL).getStringCellValue();

            chi_tiet_dvkt.NGAY_TH_YL = currentRow.getCell(COLUMN_INDEX_NGAY_TH_YL).getStringCellValue();

            chi_tiet_dvkt.NGAY_KQ = currentRow.getCell(COLUMN_INDEX_NGAY_KQ).getStringCellValue();

            chi_tiet_dvkt.MA_PTTT = Integer.parseInt(fmt.formatCellValue(currentRow.getCell(COLUMN_INDEX_MA_PTTT)));

            String VET_THUONG_TP_STR = fmt.formatCellValue(currentRow.getCell(COLUMN_INDEX_VET_THUONG_TP));
            if (!VET_THUONG_TP_STR.trim().isEmpty()) {
                chi_tiet_dvkt.VET_THUONG_TP = Integer.parseInt(VET_THUONG_TP_STR);
            }
            String PP_VO_CAM_STR = fmt.formatCellValue(currentRow.getCell(COLUMN_INDEX_PP_VO_CAM));
            if (!PP_VO_CAM_STR.trim().isEmpty()) {
                chi_tiet_dvkt.PP_VO_CAM = Integer.parseInt(PP_VO_CAM_STR);
            }

            chi_tiet_dvkt.VI_TRI_TH_DVKT = Integer.parseInt(fmt.formatCellValue(currentRow.getCell(COLUMN_INDEX_VI_TRI_TH_DVKT)));

            chi_tiet_dvkt.MA_MAY = currentRow.getCell(COLUMN_INDEX_MA_MAY).getStringCellValue();

            chi_tiet_dvkt.MA_HIEU_SP = currentRow.getCell(COLUMN_INDEX_MA_HIEU_SP).getStringCellValue();

            String TAI_SU_DUNG_STR = fmt.formatCellValue(currentRow.getCell(COLUMN_INDEX_TAI_SU_DUNG));
            if (!TAI_SU_DUNG_STR.trim().isEmpty()) {
                chi_tiet_dvkt.TAI_SU_DUNG = Integer.parseInt(TAI_SU_DUNG_STR);
            }
            chi_tiet_dvkt.DU_PHONG = currentRow.getCell(COLUMN_INDEX_DU_PHONG).getStringCellValue();
            return chi_tiet_dvkt;
        }
        catch (Exception e){
            throw new AppException("Đã có lỗi xảy ra khi truy xuất dữ liệu từ Excel bảng XML3 hàng thứ "+currentRow.getRowNum() + "\n"+e.toString()+": "+e.getMessage(), e.getStackTrace());
        }
    }
}
