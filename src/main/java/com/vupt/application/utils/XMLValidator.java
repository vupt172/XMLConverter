package com.vupt.application.utils;

import com.vupt.application.constant.XMLType;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.FILEHOSO;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML10Pack.XML10;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML11Pack.XML11;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML1Pack.XML1;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML2Pack.CHI_TIET_THUOC;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML2Pack.XML2;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML3Pack.CHI_TIET_DVKT;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML3Pack.XML3;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML4Pack.CHI_TIET_CLS;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML4Pack.XML4;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML5Pack.CHI_TIET_DIEN_BIEN_BENH;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML5Pack.XML5;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML7Pack.XML7;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML8Pack.XML8;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML9Pack.DU_LIEU_GIAY_CHUNG_SINH;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML9Pack.XML9;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XMLDETAIL;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class XMLValidator {
    private List<FILEHOSO> dsfilehoso;
    private Validator validator;
    List<String> errorMessages;

    public XMLValidator(List<FILEHOSO> dsfilehoso) {
        this.dsfilehoso = dsfilehoso;
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        this.validator = factory.getValidator();
        errorMessages = new ArrayList<>();

    }

    public List<String> validate() {
        this.dsfilehoso.stream().forEach(fhs -> {
          this.errorMessages.addAll(validateXMLDetail(fhs));
        });
        return this.errorMessages;
    }

    public List<String> validateXMLDetail(FILEHOSO filehoso) {
        List<String> messages;
        switch (filehoso.LOAIHOSO) {
            case XML1:
                messages= validateXML1((XML1) filehoso.xmlDetail);
                break;
            case XML2:
                messages= validateXML2((XML2) filehoso.xmlDetail);
                break;
            case XML3:
                messages=validateXML3((XML3) filehoso.xmlDetail);
                break;
            case XML4:
                messages=validateXML4((XML4)filehoso.xmlDetail);
                break;
            case XML5:
                messages=validateXML5((XML5)filehoso.xmlDetail);
                break;
            case XML7:
                messages=validateXML7((XML7)filehoso.xmlDetail);
                break;
            case XML8:
                messages=validateXML8((XML8)filehoso.xmlDetail);
                break;
            case XML9:
                messages=validateXML9((XML9)filehoso.xmlDetail);
                break;
            case XML10:
                messages=validateXML10((XML10)filehoso.xmlDetail);
                break;
            case XML11:
                messages=validateXML11((XML11)filehoso.xmlDetail);
                break;
            default: messages=new ArrayList<>();
        }
        return messages;
    }

    public List<String> validateXML1(XML1 xml1) {
        List<String> messages;
        Set<ConstraintViolation<XML1>> violations;
        violations = this.validator.validate(xml1);
        messages = violations.stream().map(violation -> {
            String errorMessage = String.format("[%s] STT = %s , %s %s", XMLType.XML1,violation.getRootBean().STT, violation.getPropertyPath(), violation.getMessage());
            return errorMessage;
        }).collect(Collectors.toList());

        return messages;
    }

    public List<String> validateXML2(XML2 xml2) {
        List<String> messages = new ArrayList<>();

        xml2.dsach_chi_tiet_thuoc.ds_chi_tiet_thuoc.forEach(chi_tiet_thuoc -> {
            Set<ConstraintViolation<CHI_TIET_THUOC>> violations = this.validator.validate(chi_tiet_thuoc);
            List<String> results = new ArrayList<>();
            results = violations.stream().map(violation -> {
                String errorMessage = String.format("[%s] STT = %s , %s %s", XMLType.XML2,violation.getRootBean().STT, violation.getPropertyPath(), violation.getMessage());
                return errorMessage;
            }).collect(Collectors.toList());
            messages.addAll(results);
        });
        return messages;
    }
    public List<String> validateXML3(XML3 xml3){
        List<String> messages = new ArrayList<>();

        xml3.dsach_chi_tiet_dvkt.ds_chi_tiet_dvkt.forEach(chi_tiet_dvkt -> {
            Set<ConstraintViolation<CHI_TIET_DVKT>> violations = this.validator.validate(chi_tiet_dvkt);
            List<String> results = new ArrayList<>();
            results = violations.stream().map(violation -> {
                String errorMessage = String.format("[%s] STT = %s , %s %s", XMLType.XML3,violation.getRootBean().STT, violation.getPropertyPath(), violation.getMessage());
                return errorMessage;
            }).collect(Collectors.toList());
            messages.addAll(results);
        });
        return messages;
    }

    public List<String> validateXML4(XML4 xml4){
        List<String> messages = new ArrayList<>();

        xml4.dsach_chi_tiet_cls.ds_chi_tiet_cls.forEach(chi_tiet_cls -> {
            Set<ConstraintViolation<CHI_TIET_CLS>> violations = this.validator.validate(chi_tiet_cls);
            List<String> results = new ArrayList<>();
            results = violations.stream().map(violation -> {
                String errorMessage = String.format("[%s] STT = %s , %s %s", XMLType.XML4,violation.getRootBean().STT, violation.getPropertyPath(), violation.getMessage());
                return errorMessage;
            }).collect(Collectors.toList());
            messages.addAll(results);
        });
        return messages;
    }
    public List<String> validateXML5(XML5 xml5){
        List<String> messages = new ArrayList<>();

        xml5.dsach_chi_tiet_dien_bien_benh.ds_chi_tiet_dien_bien_benh.forEach(chi_tiet_dien_bien_benh -> {
            Set<ConstraintViolation<CHI_TIET_DIEN_BIEN_BENH>> violations = this.validator.validate(chi_tiet_dien_bien_benh);
            List<String> results = new ArrayList<>();
            results = violations.stream().map(violation -> {
                String errorMessage = String.format("[%s] STT = %s , %s %s", XMLType.XML5,violation.getRootBean().STT, violation.getPropertyPath(), violation.getMessage());
                return errorMessage;
            }).collect(Collectors.toList());
            messages.addAll(results);
        });
        return messages;
    }
    public List<String> validateXML7(XML7 xml7) {
        List<String> messages;
        Set<ConstraintViolation<XML7>> violations;
        violations = this.validator.validate(xml7);
        messages = violations.stream().map(violation -> {
            String errorMessage = String.format("[%s] %s %s", XMLType.XML7, violation.getPropertyPath(), violation.getMessage());
            return errorMessage;
        }).collect(Collectors.toList());

        return messages;
    }
    public List<String> validateXML8(XML8 xml8) {
        List<String> messages;
        Set<ConstraintViolation<XML8>> violations;
        violations = this.validator.validate(xml8);
        messages = violations.stream().map(violation -> {
            String errorMessage = String.format("[%s] %s %s", XMLType.XML8, violation.getPropertyPath(), violation.getMessage());
            return errorMessage;
        }).collect(Collectors.toList());

        return messages;
    }

    public List<String> validateXML9(XML9 xml9){
        List<String> messages = new ArrayList<>();

        xml9.dsach_giaychungsinh.ds_du_lieu_giay_chung_sinh.forEach(du_lieu_giay_chung_sinh -> {
            Set<ConstraintViolation<DU_LIEU_GIAY_CHUNG_SINH>> violations = this.validator.validate(du_lieu_giay_chung_sinh);
            List<String> results = new ArrayList<>();
            results = violations.stream().map(violation -> {
                String errorMessage = String.format("[%s] %s %s", XMLType.XML9, violation.getPropertyPath(), violation.getMessage());
                return errorMessage;
            }).collect(Collectors.toList());
            messages.addAll(results);
        });
        return messages;
    }
    public List<String> validateXML10(XML10 xml10) {
        List<String> messages;
        Set<ConstraintViolation<XML10>> violations;
        violations = this.validator.validate(xml10);
        messages = violations.stream().map(violation -> {
            String errorMessage = String.format("[%s] %s %s", XMLType.XML10, violation.getPropertyPath(), violation.getMessage());
            return errorMessage;
        }).collect(Collectors.toList());

        return messages;
    }
    public List<String> validateXML11(XML11 xml11) {
        List<String> messages;
        Set<ConstraintViolation<XML11>> violations;
        violations = this.validator.validate(xml11);
        messages = violations.stream().map(violation -> {
            String errorMessage = String.format("[%s] %s %s", XMLType.XML11, violation.getPropertyPath(), violation.getMessage());
            return errorMessage;
        }).collect(Collectors.toList());

        return messages;
    }

}
