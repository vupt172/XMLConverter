package com.vupt.application.utils;

import org.apache.poi.ss.usermodel.DataFormatter;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/*
* Class DataUtils có các phương thức liên quan tới định dạng số
* */
public class DataUtils {
    // Method getExcelDataFormatter trả về DataFormatter - một lớp của apache excel
    public static DataFormatter getExcelDataFormatter(){
        // Tạo một DataFormatter với locale English
        Locale englishLocale = new Locale("en", "US");
        DataFormatter fmt = new DataFormatter(englishLocale);
        return fmt;
    }
    // method getDecimalFormat trẻ về DecimalFormat format double thành chuỗi có định dạng yêu cầu
    public static DecimalFormat getDecimalFormat(){
        DecimalFormat decimalFormat = new DecimalFormat("0.00", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
        return decimalFormat;
    }


}
