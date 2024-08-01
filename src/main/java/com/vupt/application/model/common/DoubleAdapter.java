package com.vupt.application.model.common;

import com.vupt.application.utils.DataUtils;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.crypto.Data;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class DoubleAdapter extends XmlAdapter<String, Double> {

    @Override
    public Double unmarshal(String v) throws Exception {
        return Double.valueOf(v);
    }

    @Override
    public String marshal(Double v) throws Exception {
        DecimalFormat decimalFormat= DataUtils.getDecimalFormat();
        return decimalFormat.format(v);
    }
}
