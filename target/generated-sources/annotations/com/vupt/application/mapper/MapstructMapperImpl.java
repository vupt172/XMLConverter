package com.vupt.application.mapper;

import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.HoSoInfo;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML1Pack.XML1;
import java.text.ParseException;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-31T15:20:26+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 1.8.0_401 (Oracle Corporation)"
)
@Component
public class MapstructMapperImpl implements MapstructMapper {

    @Override
    public HoSoInfo XML1ToHoSoInfo(XML1 xml1) {
        if ( xml1 == null ) {
            return null;
        }

        HoSoInfo hoSoInfo = new HoSoInfo();

        try {
            hoSoInfo.NGAY_VAO = MapstructMapper.NGAY_VAO_Date( xml1.NGAY_VAO );
        }
        catch ( ParseException e ) {
            throw new RuntimeException( e );
        }
        try {
            hoSoInfo.NGAY_RA = MapstructMapper.NGAY_RA_Date( xml1.NGAY_RA );
        }
        catch ( ParseException e ) {
            throw new RuntimeException( e );
        }
        hoSoInfo.STT = xml1.STT;
        hoSoInfo.MA_LK = xml1.MA_LK;
        hoSoInfo.MA_BN = xml1.MA_BN;
        hoSoInfo.HO_TEN = xml1.HO_TEN;
        hoSoInfo.MA_THE_BHYT = xml1.MA_THE_BHYT;

        return hoSoInfo;
    }
}
