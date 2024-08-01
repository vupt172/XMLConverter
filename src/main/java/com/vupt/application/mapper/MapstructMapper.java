package com.vupt.application.mapper;

import com.vupt.application.constant.DatetimePattern;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.HoSoInfo;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML1Pack.XML1;
import com.vupt.application.utils.DateTimeUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.text.ParseException;
import java.util.Date;

@Mapper(componentModel = "spring")
public interface MapstructMapper {
    @Mapping(source ="NGAY_VAO",target ="NGAY_VAO",qualifiedByName = "NGAY_VAO_Date")
    @Mapping(source = "NGAY_RA",target = "NGAY_RA",qualifiedByName = "NGAY_RA_Date")
    HoSoInfo XML1ToHoSoInfo(XML1 xml1);

    @Named("NGAY_VAO_Date")
    public static Date NGAY_VAO_Date(String NGAY_VAO_Str) throws ParseException {
        return DateTimeUtils.parse(DatetimePattern.DATETIME1,NGAY_VAO_Str);
    }
    @Named("NGAY_RA_Date")
    public static Date NGAY_RA_Date(String NGAY_RA_Str) throws ParseException {
        return DateTimeUtils.parse(DatetimePattern.DATETIME1,NGAY_RA_Str);
    }
}
