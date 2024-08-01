package com.vupt.application.tasks;

import com.vupt.application.constant.DatetimePattern;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.HOSO;
import com.vupt.application.excel.exporter.GDHSExportExcel;
import com.vupt.application.utils.DateTimeUtils;
import com.vupt.application.utils.FileUtils;
import javafx.concurrent.Task;
import lombok.Data;

import java.nio.file.Paths;

@Data
public class GDHSToExcelTask extends Task<Void> {
    private HOSO hoso;
    private String excelFilePath;

    public GDHSToExcelTask(HOSO hoso, String excelFilePathPath) {
        this.hoso = hoso;
        this.excelFilePath = excelFilePathPath;
    }

    @Override
    protected Void call() throws Exception {
        try {
            System.out.println("\n\n................................................................................................................................................................................................");
            System.out.println("Bắt đầu: "+ DateTimeUtils.getDateTimeNow(DatetimePattern.DATETIME0.getPattern()));
            System.out.println("Chuyển đổi hồ sơ XML  <" + hoso.hosoInfo.MA_BN + ":" + hoso.hosoInfo.HO_TEN + "> sang Excel");
            hoso.buildXMLDetails();
            GDHSExportExcel.exportGDHSToExcel(hoso, excelFilePath);
            System.out.println("Thành công!............");
            String absoluteFilePath = Paths.get(excelFilePath).toAbsolutePath().toString();
            System.out.println("Đường dẫn file Excel: " + absoluteFilePath);
//            System.out.println("................................................................................................................................................................................................");
            updateProgress(1, 1);
            FileUtils.openFile(absoluteFilePath);
        } catch (Exception e) {
            e.printStackTrace();
            cancel();
            updateProgress(0,1);
            return null;
        }
        return null;
    }
}
