package com.vupt.application.event;

import com.vupt.application.model.gdhs.GIAMDINHHS;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.HOSO;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.HoSoInfo;
import com.vupt.application.views.XmlDetailController;
import javafx.event.EventHandler;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import lombok.SneakyThrows;

public class XmlDetailMouseClickHandler implements EventHandler<MouseEvent> {
    private TableView<HOSO> tbHoSo;
    private GIAMDINHHS giamdinhhs;
    public XmlDetailMouseClickHandler(GIAMDINHHS giamdinhhs,TableView<HOSO> tbView){
        this.giamdinhhs=giamdinhhs;
        tbHoSo=tbView;
    }

    @SneakyThrows
    @Override
    public void handle(MouseEvent event) {
        if(event.getClickCount()==2){
            HOSO hoSo=tbHoSo.getSelectionModel().getSelectedItem();
            if(hoSo!=null){
                XmlDetailController.loadView(giamdinhhs,hoSo);
            }
        }
    }
}
