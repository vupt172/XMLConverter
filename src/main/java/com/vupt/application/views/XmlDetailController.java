package com.vupt.application.views;

import com.vupt.application.MyApplication;
import com.vupt.application.constant.XMLType;
import com.vupt.application.exception.XmlDetailNotFoundException;
import com.vupt.application.model.gdhs.GIAMDINHHS;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.HOSO;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.FILEHOSO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
public class XmlDetailController {

    @FXML
    TreeView<XMLType> tvXmlMenu;
    @FXML
    TextArea taXmlDetail;
    @FXML
    TextField tfKeyword;
    @FXML
    Button btnSearch;

    private GIAMDINHHS giamdinhhs;
    private HOSO hoSo;
    TreeItem<XMLType> rootItem = new TreeItem<>(XMLType.DEFAULT);
    TreeItem<XMLType> itemXML_ALL = new TreeItem<>(XMLType.XML_ALL);
    TreeItem<XMLType> itemXML1 = new TreeItem<>(XMLType.XML1);
    TreeItem<XMLType> itemXML2 = new TreeItem<>(XMLType.XML2);
    TreeItem<XMLType> itemXML3 = new TreeItem<>(XMLType.XML3);
    TreeItem<XMLType> itemXML4 = new TreeItem<>(XMLType.XML4);
    TreeItem<XMLType> itemXML5 = new TreeItem<>(XMLType.XML5);
    TreeItem<XMLType> itemXML6 = new TreeItem<>(XMLType.XML6);
    TreeItem<XMLType> itemXML7 = new TreeItem<>(XMLType.XML7);
    TreeItem<XMLType> itemXML8 = new TreeItem<>(XMLType.XML8);
    TreeItem<XMLType> itemXML9 = new TreeItem<>(XMLType.XML9);
    TreeItem<XMLType> itemXML10 = new TreeItem<>(XMLType.XML10);
    TreeItem<XMLType> itemXML11 = new TreeItem<>(XMLType.XML11);
    TreeItem<XMLType> itemXML12 = new TreeItem<>(XMLType.XML12);
    TreeItem<XMLType> itemXML13 = new TreeItem<>(XMLType.XML13);
    TreeItem<XMLType> itemXML14 = new TreeItem<>(XMLType.XML14);
    TreeItem<XMLType> itemXML15 = new TreeItem<>(XMLType.XML15);

    public static void loadView(GIAMDINHHS giamdinhhs, HOSO hoso) throws IOException {
        FXMLLoader loader = new FXMLLoader(XmlDetailController.class.getResource("/XmlDetail.fxml"));
        loader.setControllerFactory(MyApplication.getApplicationContext()::getBean);

        Parent view = loader.load();
        Stage stage = new Stage();
        stage.setTitle("XML Converter");
        stage.setScene(new Scene(view));
        stage.setMaximized(true);
        XmlDetailController controller = loader.getController();
        controller.init(giamdinhhs, hoso);
        stage.show();
    }

    public void init(GIAMDINHHS giamdinhhs, HOSO hoSo) {

        this.hoSo = hoSo;
        this.giamdinhhs = giamdinhhs;
        removeNotFoundXMLTreeItems();
    }

    @FXML
    public void initialize() {
        initTreeView();
    }

    @FXML
    public void search() {
        String searchText = tfKeyword.getText().toLowerCase();
        String text = taXmlDetail.getText().toLowerCase();

        if (searchText != null && !searchText.isEmpty()) {
            int index = text.indexOf(searchText);
            if (index >= 0) {
                taXmlDetail.positionCaret(index);
                taXmlDetail.selectRange(index, index + searchText.length());
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Text not found");
                alert.show();
            }
        }
    }

    public void initTreeView() {
        rootItem.getChildren().clear();
        rootItem.getChildren().addAll(itemXML_ALL, itemXML1, itemXML2, itemXML3, itemXML4, itemXML5, itemXML6, itemXML7, itemXML8, itemXML9, itemXML10, itemXML11, itemXML12, itemXML13, itemXML14, itemXML15);
        rootItem.setExpanded(true);
        tvXmlMenu.setRoot(rootItem);
        tvXmlMenu.setShowRoot(false);

        initTreeViewEvent();


    }

    private void initTreeViewEvent() {
        tvXmlMenu.setOnMouseClicked(event -> {
            TreeItem<XMLType> selectedItem = tvXmlMenu.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                try {
                    switch (selectedItem.getValue()) {
                        case XML_ALL:
                            String xmlAll = giamdinhhs.getXMLAll(hoSo);
                            taXmlDetail.setText(xmlAll);
                            break;
                        case XML1:
                            FILEHOSO fhs1 = hoSo.findXMLFile(XMLType.XML1);
                            taXmlDetail.setText(fhs1.decodedXML);
                            break;
                        case XML2:
                            FILEHOSO fhs2 = hoSo.findXMLFile(XMLType.XML2);
                            taXmlDetail.setText(fhs2.decodedXML);
                            break;
                        case XML3:
                            FILEHOSO fhs3 = hoSo.findXMLFile(XMLType.XML3);
                            taXmlDetail.setText(fhs3.decodedXML);
                            break;
                        case XML4:
                            FILEHOSO fhs4 = hoSo.findXMLFile(XMLType.XML4);
                            taXmlDetail.setText(fhs4.decodedXML);
                            break;
                        case XML5:
                            FILEHOSO fhs5 = hoSo.findXMLFile(XMLType.XML5);
                            taXmlDetail.setText(fhs5.decodedXML);
                            break;
                        case XML6:
                            FILEHOSO fhs6 = hoSo.findXMLFile(XMLType.XML6);
                            taXmlDetail.setText(fhs6.decodedXML);
                            break;
                        case XML7:
                            FILEHOSO fhs7 = hoSo.findXMLFile(XMLType.XML7);
                            taXmlDetail.setText(fhs7.decodedXML);
                            break;
                        case XML8:
                            FILEHOSO fhs8 = hoSo.findXMLFile(XMLType.XML8);
                            taXmlDetail.setText(fhs8.decodedXML);
                            break;
                        case XML9:
                            FILEHOSO fhs9 = hoSo.findXMLFile(XMLType.XML9);
                            taXmlDetail.setText(fhs9.decodedXML);
                            break;
                        case XML10:
                            FILEHOSO fhs10 = hoSo.findXMLFile(XMLType.XML10);
                            taXmlDetail.setText(fhs10.decodedXML);
                            break;
                        case XML11:
                            FILEHOSO fhs11 = hoSo.findXMLFile(XMLType.XML11);
                            taXmlDetail.setText(fhs11.decodedXML);
                            break;
                        case XML12:
                            FILEHOSO fhs12 = hoSo.findXMLFile(XMLType.XML12);
                            taXmlDetail.setText(fhs12.decodedXML);
                            break;
                        case XML13:
                            FILEHOSO fhs13 = hoSo.findXMLFile(XMLType.XML13);
                            taXmlDetail.setText(fhs13.decodedXML);
                            break;
                        case XML14:
                            FILEHOSO fhs14 = hoSo.findXMLFile(XMLType.XML14);
                            taXmlDetail.setText(fhs14.decodedXML);
                            break;
                        case XML15:
                            FILEHOSO fhs15 = hoSo.findXMLFile(XMLType.XML15);
                            taXmlDetail.setText(fhs15.decodedXML);
                            break;
                        default:
                    }
                } catch (XmlDetailNotFoundException e) {
                    /*    TreeItem<XmlDetailType> item1= tvXmlMenu.getRoot().getChildren().stream().filter(item->item.getValue()== e.getType()).findFirst().get();*/
                    taXmlDetail.setText(e.getMessage());
                }

            }
        });

    }

    private void removeNotFoundXMLTreeItems() {
        if (!hoSo.dsfilehoso.stream().anyMatch(filehoso -> filehoso.LOAIHOSO == XMLType.XML1))
            rootItem.getChildren().remove(itemXML1);
        if (!hoSo.dsfilehoso.stream().anyMatch(filehoso -> filehoso.LOAIHOSO == XMLType.XML2))
            rootItem.getChildren().remove(itemXML2);
        if (!hoSo.dsfilehoso.stream().anyMatch(filehoso -> filehoso.LOAIHOSO == XMLType.XML3))
            rootItem.getChildren().remove(itemXML3);
        if (!hoSo.dsfilehoso.stream().anyMatch(filehoso -> filehoso.LOAIHOSO == XMLType.XML4))
            rootItem.getChildren().remove(itemXML4);
        if (!hoSo.dsfilehoso.stream().anyMatch(filehoso -> filehoso.LOAIHOSO == XMLType.XML5))
            rootItem.getChildren().remove(itemXML5);
        if (!hoSo.dsfilehoso.stream().anyMatch(filehoso -> filehoso.LOAIHOSO == XMLType.XML6))
            rootItem.getChildren().remove(itemXML6);
        if (!hoSo.dsfilehoso.stream().anyMatch(filehoso -> filehoso.LOAIHOSO == XMLType.XML7))
            rootItem.getChildren().remove(itemXML7);
        if (!hoSo.dsfilehoso.stream().anyMatch(filehoso -> filehoso.LOAIHOSO == XMLType.XML8))
            rootItem.getChildren().remove(itemXML8);
        if (!hoSo.dsfilehoso.stream().anyMatch(filehoso -> filehoso.LOAIHOSO == XMLType.XML9))
            rootItem.getChildren().remove(itemXML9);
        if (!hoSo.dsfilehoso.stream().anyMatch(filehoso -> filehoso.LOAIHOSO == XMLType.XML10))
            rootItem.getChildren().remove(itemXML10);
        if (!hoSo.dsfilehoso.stream().anyMatch(filehoso -> filehoso.LOAIHOSO == XMLType.XML11))
            rootItem.getChildren().remove(itemXML11);
        if (!hoSo.dsfilehoso.stream().anyMatch(filehoso -> filehoso.LOAIHOSO == XMLType.XML12))
            rootItem.getChildren().remove(itemXML12);
        if (!hoSo.dsfilehoso.stream().anyMatch(filehoso -> filehoso.LOAIHOSO == XMLType.XML13))
            rootItem.getChildren().remove(itemXML13);
        if (!hoSo.dsfilehoso.stream().anyMatch(filehoso -> filehoso.LOAIHOSO == XMLType.XML14))
            rootItem.getChildren().remove(itemXML14);
        if (!hoSo.dsfilehoso.stream().anyMatch(filehoso -> filehoso.LOAIHOSO == XMLType.XML15))
            rootItem.getChildren().remove(itemXML15);
    }
}
