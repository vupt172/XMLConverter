package com.vupt.application.utils;

import java.util.List;

public class PrinterUtils {
    public static void printXMLErrors(List<String> messages){
        messages.forEach(e-> System.err.println(e));
    }
}
