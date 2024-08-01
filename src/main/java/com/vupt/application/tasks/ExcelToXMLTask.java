package com.vupt.application.tasks;

import com.vupt.application.constant.DatetimePattern;
import com.vupt.application.constant.XMLType;
import com.vupt.application.excel.importer.GDHSImportExcel;
import com.vupt.application.model.gdhs.GIAMDINHHS;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.FILEHOSO;
import com.vupt.application.utils.DateTimeUtils;
import com.vupt.application.xml.GDHSConverter;
import com.vupt.application.xml.XMLConverter;
import javafx.concurrent.Task;
import org.apache.xmlbeans.impl.common.XMLChar;

public class ExcelToXMLTask extends Task<Void> {
    private String excelFilePath;

    public ExcelToXMLTask(String excelFilePath) {
        this.excelFilePath = excelFilePath;
    }

    @Override
    protected Void call() throws Exception {
        try {
            int totalSteps = 5;
            System.out.println("\n\n................................................................................................................................................................................................");
            System.out.println("Bắt đầu: "+ DateTimeUtils.getDateTimeNow(DatetimePattern.DATETIME0.getPattern()));
            System.out.println("Xuất dữ liệu từ Excel sang XML");
            System.out.println("Đường dẫn file Excel:  " + excelFilePath);
            System.out.println("Bắt đầu tiến trình ............");
            System.out.println("1. Chuyển đổi dữ liệu Excel sang GDHS");
            GIAMDINHHS giamdinhhs = GDHSImportExcel.importExcelToGDHS(excelFilePath);
            updateProgress(1, totalSteps);
            Thread.sleep(500);
            System.out.println("2. Xây dựng bảng kê dưới dạng chuỗi XML");
            giamdinhhs.thongtinhoso.danhsachhoso.dshoso.get(0).buildDecodedXMLFromXMLDetails();
            updateProgress(2, totalSteps);
            Thread.sleep(500);
            System.out.println("3. Mã hóa rút gọn chuỗi XML bảng kê ");
            giamdinhhs.thongtinhoso.danhsachhoso.dshoso.get(0).encodeXMLs();
            updateProgress(3, totalSteps);
            Thread.sleep(500);
            System.out.println("4. Chuyển đổi thành file XML");
            String outputFilePath = GDHSConverter.convertGDHSToXML(giamdinhhs);
            updateProgress(1, 1);
            Thread.sleep(500);
            System.out.println("Thành công!............");
            System.out.println("Đường dẫn file XML: " +outputFilePath);
//            System.out.println("................................................................................................................................................................................................");
            return null;
        }
      catch (Exception e){
            e.printStackTrace();
            cancel();
            updateProgress(0,1);
            return null;
      }
    }
}
