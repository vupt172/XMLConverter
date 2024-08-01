package com.vupt.application.constant;

public enum XMLType {
    DEFAULT("DEFAULT"),
    XML_ALL("XML_ALL"),
    XML1("XML1"),
    XML2("XML2"),
    XML3("XML3"),
    XML4("XML4"),
    XML5("XML5"),
    XML6("XML6"),
    XML7("XML7"),
    XML8("XML8"),
    XML9("XML9"),
    XML10("XML10"),
    XML11("XML11"),
    XML12("XML12"),
    XML13("XML13"),
    XML14("XML14"),
    XML15("XML15");

    private String type;

    XMLType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
