package com.vupt.application.exception;

import com.vupt.application.constant.XMLType;
import lombok.Data;

@Data
public class XmlDetailNotFoundException extends AppException{
    private XMLType type;
    public XmlDetailNotFoundException(XMLType type, String message) {
        super(message);
        this.type=type;
    }
}
