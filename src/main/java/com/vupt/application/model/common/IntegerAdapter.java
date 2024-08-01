package com.vupt.application.model.common;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class IntegerAdapter extends XmlAdapter<String,Integer> {
    @Override
    public Integer unmarshal(String v) throws Exception {
        if (v == null || v.isEmpty()) {
            return null;
        }
        return Integer.parseInt(v);
    }

    @Override
    public String marshal(Integer v) throws Exception {
        if (v == null) {
             return "";
        }
        return v.toString();
    }
}
