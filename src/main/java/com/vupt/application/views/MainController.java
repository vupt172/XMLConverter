package com.vupt.application.views;


import com.vupt.application.MyApplication;
import com.vupt.application.constant.DatetimePattern;
import com.vupt.application.constant.XMLType;
import com.vupt.application.event.XmlDetailMouseClickHandler;
import com.vupt.application.model.gdhs.GIAMDINHHS;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.HOSO;
import com.vupt.application.tasks.ExcelToXMLTask;
import com.vupt.application.tasks.GDHSToExcelTask;
import com.vupt.application.tasks.XMLToGDHSTask;
import com.vupt.application.utils.DateTimeUtils;
import com.vupt.application.xml.GDHSConverter;
import javafx.application.Platform;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;


import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class MainController {
    @Value("${config.app.info}")
    private String appInfo;
    @Value("${config.app.update}")
    private String appUpdate;
    @FXML
    TextField tfFilePath;
    @FXML
    TableView<HOSO> tbHoSo;
    @FXML
    TableColumn<HOSO, Integer> colSTT;
    @FXML
    TableColumn<HOSO, String> colMALK;
    @FXML
    TableColumn<HOSO, String> colMAYT;
    @FXML
    TableColumn<HOSO, String> colHOTEN;
    @FXML
    TableColumn<HOSO, Date> colNGAYVAO;
    @FXML
    TableColumn<HOSO, Date> colNGAYRA;
    @FXML
    TableColumn<HOSO, String> colMATHEBHYT;

    @FXML
    private ComboBox<XMLType> cbXMLType;
    @FXML
    private TextField tfMA_YT;
    @FXML
    private TextField tfHO_TEN;
    @FXML
    private TextField tfMA_THE_BHYT;
    @FXML
    private TextField tfMA_LK;
    @FXML
    private Button btnSearch;
    @FXML
    TextArea taConsole;
    public static TextArea staticTaConsole;
    @FXML
    ProgressBar progressBar;

    private GIAMDINHHS giamdinhhs;
    private List<HOSO> dsHoSo;


    public static void loadView(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainController.class.getResource("/main.fxml"));
        loader.setControllerFactory(MyApplication.getApplicationContext()::getBean);
        Parent view = loader.load();

        MainController mainController = loader.getController();
        MainController.staticTaConsole = mainController.taConsole;

        stage.setMaximized(true);
        stage.getIcons().add(new Image(MainController.class.getResourceAsStream("/images/logo.png")));
        stage.setTitle("XML Converter");
        stage.setScene(new Scene(view));
        stage.show();
    }

    @FXML
    public void initialize() {
        initTableView();
        tfHO_TEN.setTextFormatter(new TextFormatter<>((change) -> {
            change.setText(change.getText().toUpperCase());
            return change;
        }));
        cbXMLType.setItems(FXCollections.observableArrayList(XMLType.values()));

    }
    @FXML
    public void showApplicationInfo(){
        Alert alert=new Alert(Alert.AlertType.INFORMATION,appUpdate,ButtonType.OK);
        alert.setTitle("Thông tin ứng dụng");
        alert.setHeaderText(appInfo);
        alert.show();
    }

    public void initTableView() {
        initTableViewCellFactory();

    }

    private void initTableViewCellFactory() {
        colSTT.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().hosoInfo.STT));
        colMALK.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().hosoInfo.MA_LK));
        colMAYT.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().hosoInfo.MA_BN));
        colHOTEN.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().hosoInfo.HO_TEN));
        colNGAYRA.setCellValueFactory(cellData -> new SimpleObjectProperty<Date>(cellData.getValue().hosoInfo.NGAY_RA));
        colNGAYRA.setCellFactory(column -> {
            return new TableCell<HOSO, Date>() {
                @Override
                protected void updateItem(Date item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null || empty) {
                        setText(null);
                    } else {
                        setText(DateTimeUtils.format(DatetimePattern.DATETIME0, item)); // Hiển thị tên sản phẩm
                    }
                }
            };
        });
        colNGAYVAO.setCellValueFactory(cellData -> new SimpleObjectProperty<Date>(cellData.getValue().hosoInfo.NGAY_VAO));
        colNGAYVAO.setCellFactory(column -> {
            return new TableCell<HOSO, Date>() {
                @Override
                protected void updateItem(Date item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null || empty) {
                        setText(null);
                    } else {
                        setText(DateTimeUtils.format(DatetimePattern.DATETIME0, item)); // Hiển thị tên sản phẩm
                    }
                }
            };
        });
        colMATHEBHYT.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().hosoInfo.MA_THE_BHYT));

    }

    @FXML
    public void filter(){
        XMLType type=cbXMLType.getValue();
        String MA_LK=tfMA_LK.getText();
        String MA_YT=tfMA_YT.getText();
        String HO_TEN=tfHO_TEN.getText();
        String MA_THE_BHYT=tfMA_THE_BHYT.getText();
       List<HOSO> resultList=  dsHoSo.stream()
               .filter(hs->MA_LK.isEmpty()||hs.hosoInfo.MA_LK.equals(MA_LK))
               .filter(hs->MA_YT.isEmpty()|| hs.hosoInfo.MA_BN.equals(MA_YT))
               .filter(hs->HO_TEN.isEmpty()||hs.hosoInfo.HO_TEN.contains(HO_TEN))
               .filter(hs->MA_THE_BHYT.isEmpty()||hs.hosoInfo.MA_THE_BHYT.equals(MA_THE_BHYT))
               .filter(hs->type==null || hs.containXMLFileWithType(type))
               .collect(Collectors.toList());
       tbHoSo.setItems(FXCollections.observableList(resultList));
    }
    @FXML
    public void clear(){
        cbXMLType.setValue(null);
        tfMA_YT.setText("");
        tfMA_LK.setText("");
        tfHO_TEN.setText("");
        tfMA_THE_BHYT.setText("");
    }

    @FXML
    public void openXmlFile() {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML File(*.xml)","*.xml"));
        File initialDirectory = new File("output");
        fc.setInitialDirectory(initialDirectory);
        File file = fc.showOpenDialog(tbHoSo.getScene().getWindow());
        if (file != null) {
            XMLToGDHSTask xmlToGDHSTask=new XMLToGDHSTask(file.getPath());
            xmlToGDHSTask.setOnSucceeded((WorkerStateEvent event) -> {
                    this.giamdinhhs=xmlToGDHSTask.getValue();
                    this.dsHoSo=giamdinhhs.thongtinhoso.danhsachhoso.dshoso;
                    tbHoSo.setItems(FXCollections.observableList(dsHoSo));
                    tbHoSo.setOnMouseClicked(new XmlDetailMouseClickHandler(this.giamdinhhs,tbHoSo));
                    tfFilePath.setText(file.getPath());
            });
            progressBar.progressProperty().bind(xmlToGDHSTask.progressProperty());
            new Thread(xmlToGDHSTask).start();
        }
    }
    @FXML
    public void XMLToExcel() throws Exception {
        HOSO hoso = tbHoSo.getSelectionModel().getSelectedItem();
        if (hoso != null) {
            String name=hoso.hosoInfo.MA_BN+"_"+hoso.hosoInfo.HO_TEN;
            name=name.replaceAll("/",".");
            String filePath=String.format("output/%s.xlsx", DateTimeUtils.includeTimeToString(name));
            GDHSToExcelTask exportXMLToExcelTask=new GDHSToExcelTask(hoso,filePath);
            progressBar.progressProperty().bind(exportXMLToExcelTask.progressProperty());
            new Thread(exportXMLToExcelTask).start();
        }
        else {
            Alert alert=new Alert(Alert.AlertType.WARNING,"Chưa chọn hồ sơ để chuyển đổi!",ButtonType.OK);
            alert.setHeaderText(null);
            alert.show();
        }

    }
    @FXML
    public void ExcelToXML(){

        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Excel File(*.xlsx)","*.xlsx"),
        new FileChooser.ExtensionFilter("Excel File(*.xls)","*.xls")
        );
        File initialDirectory = new File("output");
        fc.setInitialDirectory(initialDirectory);
        File file = fc.showOpenDialog(tbHoSo.getScene().getWindow());
        if (file != null) {
            ExcelToXMLTask excelToXMLTask=new ExcelToXMLTask(file.getPath());
            excelToXMLTask.setOnSucceeded((WorkerStateEvent event) -> {

            });
            progressBar.progressProperty().bind(excelToXMLTask.progressProperty());
            new Thread(excelToXMLTask).start();
        }
    }


}
