package com.vupt.application.tasks;

import com.vupt.application.constant.DatetimePattern;
import com.vupt.application.model.gdhs.GIAMDINHHS;
import com.vupt.application.utils.DateTimeUtils;
import com.vupt.application.xml.GDHSConverter;
import javafx.concurrent.Task;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class XMLToGDHSTask extends Task<GIAMDINHHS> {
    private String filePath;

    public XMLToGDHSTask(String filePath) {
        this.filePath = filePath;
    }

    @Override
    protected GIAMDINHHS call() throws Exception {
        try {
            updateProgress(0, 1);
            System.out.println("\n\n................................................................................................................................................................................................");
            System.out.println("Bắt đầu: " + DateTimeUtils.getDateTimeNow(DatetimePattern.DATETIME0.getPattern()));
            System.out.println("Mở file XML: " + this.filePath);
            System.out.println("1. Chuyển đổi dữ liệu XML sang GDHS");
            GIAMDINHHS giamdinhhs = GDHSConverter.convertXMLToGDHS(filePath);
            Thread.sleep(200);
            System.out.println("2. Xây dựng thông tin cơ bản");
            int max = giamdinhhs.thongtinhoso.danhsachhoso.dshoso.size();
            AtomicInteger i = new AtomicInteger();
            giamdinhhs.thongtinhoso.danhsachhoso.dshoso.stream()
                    .forEach(hoso -> {
                        hoso.decodeXMLs();
                        hoso.buildHoSoInfo();
                        updateProgress(i.getAndIncrement(), max);
                    });
            System.out.println("Thành công!............");
            giamdinhhs.showInformationConsole();
//            System.out.println("................................................................................................................................................................................................");
            return giamdinhhs;
        } catch (Exception e) {
            e.printStackTrace();
            cancel();
            updateProgress(0, 1);
            return null;
        }
    }
}
