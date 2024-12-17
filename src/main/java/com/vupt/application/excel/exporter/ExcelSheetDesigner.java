package com.vupt.application.excel.exporter;

import org.apache.poi.ss.usermodel.*;

public class ExcelSheetDesigner {
    public static CellStyle createCellStyleFormatNumber(Workbook workbook) {
        CellStyle formatNumber;
        short format = (short) BuiltinFormats.getBuiltinFormat("0.00");
        formatNumber = createStyleForData(workbook);
        formatNumber.setDataFormat(format);
        return formatNumber;
    }

    public static CellStyle createStyleForHeader(Workbook workbook) {
        // Create CellStyle
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle.setBorderRight(BorderStyle.THIN);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        return cellStyle;
    }

    public static CellStyle createStyleForData(Workbook workbook) {
        CellStyle cellStyle = workbook.createCellStyle();
//        cellStyle.setWrapText(true);
        cellStyle.setAlignment(HorizontalAlignment.LEFT);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        return cellStyle;
    }

    public static void autosizeColumn(Sheet sheet, int lastColumn) {
        for (int columnIndex = 0; columnIndex < lastColumn; columnIndex++) {
            sheet.autoSizeColumn(columnIndex);
        }
    }
}
