package fxsmirnoff;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
/**
 * @author Bhupesh Bhatia & Manprit Dhanoa
 * @version 1.0
 * Program: FXSmirnoff.java
 * Date: April 10, 2016
 */
public class FXSmirnoff extends Application
{
    private Stage addStage = new Stage();
    private Stage addConfirmStage = new Stage();
    private Stage viewStage = new Stage();
    private Stage searchStage = new Stage();
    private Stage deleteStage = new Stage();
    private Stage modifyStage = new Stage();
    private Stage viewStage2 = new Stage();

    private ArrayList<String> productList = new ArrayList();
    private ArrayList<Integer> idList = new ArrayList();

    private Image image3 = new Image("images/logo.png");
    private ImageView logo = new ImageView(image3);

    private Button btnAdd = new Button("Add");
    private Button btnSearch = new Button("Search");
    private Button btnView = new Button("View");
    private Button btnBack = new Button("Back to Main");
    private Button btnBack2 = new Button("Back to Main");
    private Button btnAdd2 = new Button("Add");
    private Button btnCancel = new Button("Cancel");
    private Button btnOK1 = new Button("Okay");
    private Button btnFirst = new Button("First");
    private Button btnPrev = new Button("Previous");
    private Button btnNext = new Button("Next");
    private Button btnLast = new Button("Last");
    private Button btnSearch2 = new Button("Search");
    private Button btnModify = new Button("Modify");
    private Button btnDel = new Button("Delete");
    private Button btnOK2 = new Button("Okay");
    private Button btnOK3 = new Button("Okay");
    private Button btnOK4 = new Button("Okay");
    private Button btnExit = new Button("Save & Exit");

    private MediaPlayer mediaPlayer1;
    private MediaPlayer mediaPlayer2;

    private Label lblId = new Label("Product ID ");
    private Label lblType = new Label("Product Type ");
    private Label lblFlavour = new Label("Flavour ");
    private Label lblSize = new Label("Size ");
    private Label lblPlace = new Label("Place ");
    private Label lblYear = new Label("Year ");
    private Label lblPrice = new Label("Price ");
    private Label lblQuantity = new Label("Quantity ");
    private Label lblSearch = new Label("Field Type ");
    private Label lblSearchCount = new Label();

    private TextField txtId = new TextField();
    private TextField txtFlavour = new TextField();
    private TextField txtPlace = new TextField();
    private TextField txtYear = new TextField();
    private TextField txtPrice = new TextField();
    private TextField txtQuantity = new TextField();
    private TextField txtSearch = new TextField();

    private ObservableList<String> types
            = FXCollections.observableArrayList(
                    "Classic Vodka",
                    "Flavoured Vodka",
                    "Smirnoff Sours",
                    "Smirnoff Ice");
    private ComboBox cbType = new ComboBox(types);

    private RadioButton radSizeS = new RadioButton("500 mL");
    private RadioButton radSizeM = new RadioButton("750 mL");
    private RadioButton radSizeL = new RadioButton("1000 mL");
    private RadioButton radSizeXL = new RadioButton("1500 mL");
    private ToggleGroup group = new ToggleGroup();

    private String record;
    private int id;
    private int oldId;
    private String type;
    private String flavour;
    private int size;
    private String place;
    private int year;
    private double price;
    private String priceF;
    private int qty;

    private int recordPos = 0;
    private int recordNum = 0;

    private ObservableList<String> idData = FXCollections.observableArrayList();
    private ListView<String> idListView = new ListView<String>(idData);

    private ObservableList<String> fields
            = FXCollections.observableArrayList(
                    "Product ID",
                    "Product Type",
                    "Product Flavour",
                    "Product Size",
                    "Place",
                    "Year",
                    "Price",
                    "Quantity");
    private ComboBox fieldType = new ComboBox(fields);

    private TableView<TableRecord> table = new TableView<>();
    private ObservableList<TableRecord> searchData = FXCollections.observableArrayList();

    private String searchResult;
    private int searchCount;

    @Override
    public void start (Stage primaryStage)
    {
        fillArrayWithProductList("smirnoffProducts.dat"); //file contents loaded into array
        arrayCheck(); //array holding records is checked to see if it has any empty rows

        btnAdd.setStyle("-fx-font-weight: bold;"); //does not work in external csss
        btnSearch.setStyle("-fx-font-weight: bold;");
        btnView.setStyle("-fx-font-weight: bold;");
        btnBack.setStyle("-fx-font-weight: bold;");
        btnBack2.setStyle("-fx-font-weight: bold;");
        btnAdd2.setStyle("-fx-font-weight: bold;");
        btnCancel.setStyle("-fx-font-weight: bold;");
        btnOK1.setStyle("-fx-font-weight: bold;");
        btnOK2.setStyle("-fx-font-weight: bold;");
        btnOK3.setStyle("-fx-font-weight: bold;");
        btnOK4.setStyle("-fx-font-weight: bold;");
        btnFirst.setStyle("-fx-font-weight: bold;");
        btnLast.setStyle("-fx-font-weight: bold;");
        btnPrev.setStyle("-fx-font-weight: bold;");
        btnNext.setStyle("-fx-font-weight: bold;");
        btnSearch2.setStyle("-fx-font-weight: bold;");
        btnModify.setStyle("-fx-font-weight: bold;");
        btnDel.setStyle("-fx-font-weight: bold;");
        lblSearchCount.setStyle("-fx-font-weight: bold;");
        btnExit.setStyle("-fx-font-weight: bold;");

        btnAdd.setId("add");  //some buttons have their id set.
        btnSearch.setId("search");
        btnView.setId("view");
        btnExit.setId("exit");
        btnBack.setId("back");
        btnBack2.setId("back2");
        lblSearchCount.setId("searchCount");
        cbType.setId("type");
        fieldType.setId("field");
        table.setId("sTable");

        radSizeS.setToggleGroup(group);
        radSizeM.setToggleGroup(group);
        radSizeL.setToggleGroup(group);
        radSizeXL.setToggleGroup(group);

        String path = FXSmirnoff.class.getResource("smirnoff1.mp3").toString();
        Media music1 = new Media(path);
        mediaPlayer1 = new MediaPlayer(music1);
        mediaPlayer1.setAutoPlay(true);

        Image image1 = new Image("images/smirnoffProducts.png");
        ImageView view1 = new ImageView(image1);

        Image image2 = new Image("images/smirgif.gif");
        ImageView view2 = new ImageView(image2);

        HBox hb1 = new HBox();
        hb1.getChildren().addAll(view1, view2);
        hb1.setPadding(new Insets(100, 100, 125, 0));

        HBox hb2 = new HBox();
        hb2.getChildren().addAll(btnAdd, btnSearch, btnView, btnExit);
        hb2.setSpacing(55);
        hb2.setAlignment(Pos.CENTER);

        VBox vb1 = new VBox();
        vb1.getChildren().addAll(hb1, hb2);

        Scene scene = new Scene(vb1, 1220, 700);

        scene.getStylesheets()
                .add(FXSmirnoff.class
                        .getResource("MainCSS.css")
                        .toExternalForm());

        primaryStage.setTitle("Smirnoff Products");
        primaryStage.setScene(scene);

        primaryStage.setResizable(false);
        addStage.setResizable(false);
        addConfirmStage.setResizable(false);
        viewStage.setResizable(false);
        searchStage.setResizable(true);
        deleteStage.setResizable(false);
        modifyStage.setResizable(false);

        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();

        //This button closes the program and saves the records to a file
        btnExit.setOnAction((e) -> {
            saveToFile("smirnoffProducts.dat");
            closeStages();
            primaryStage.close();
        });
//This button leads to the add page
        btnAdd.setOnAction((e) -> {
            addScene();
            mediaPlayer1.stop();
            mediaPlayer2.play();
            closeStages();
            addStage.show();
            clearForm();
        });
//This button is for submitting the add record page. Handles error checking,
        btnAdd2.setOnAction((e) -> {
            try {
                if (txtId.getText() == null || cbType.getValue() == null || cbType.getValue().toString().equals("") || txtFlavour.getText() == null || txtPlace == null || txtYear == null || txtPrice == null || txtQuantity == null) {
                    throw new Exception("Please fill out all fields");
                }
                setIdList();
                for (int i = 0; i < idList.size(); i++) {
                    if (txtId.getText().equals(idList.get(i))) {
                        throw new Exception("Product Id already taken. Please choose another one");
                    }
                }
                if (!radSizeS.isSelected() && !radSizeM.isSelected() && !radSizeL.isSelected() && !radSizeXL.isSelected()) {
                    throw new Exception("Please select a size");
                }
                id = Integer.parseInt(txtId.getText());
                year = Integer.parseInt(txtYear.getText());
                price = Double.parseDouble(txtPrice.getText());
                qty = Integer.parseInt(txtQuantity.getText());
                if (year < 2011) {
                    throw new Exception("Vodka is too old. Throw it out. Year must be between 2011 - 2016.");
                }
                if (year > 2016) {
                    throw new Exception("Return to the present and enter a valid year.");
                }

                if (price < 4) {
                    throw new Exception("Price is too low. Minimum price is $4.");
                }
                if (qty < 1) {
                    throw new Exception("Quantity must be at least 1.");
                }
                type = cbType.getValue().toString();
                flavour = txtFlavour.getText();
                place = txtPlace.getText();
                if (radSizeS.isSelected()) {
                    size = 500;
                }
                else if (radSizeM.isSelected()) {
                    size = 750;
                }
                else if (radSizeL.isSelected()) {
                    size = 1000;
                }
                else {
                    size = 1500;
                }
                DecimalFormat df = new DecimalFormat("#.00");
                priceF = df.format(price);
                price = Double.parseDouble(priceF);
                record = id + ", " + type + ", " + flavour + ", " + size + ", " + place + ", " + year + ", " + priceF + ", " + qty;
                productList.add(record);
                Collections.sort(productList);
                addStage.close();
                addConfirm();
                addConfirmStage.show();
            }
            catch (NumberFormatException error) {
                String err = "Make sure ID, year, price and quantity are numbers";
                showError(err);
            }
            catch (Exception error) {
                showError(error.getMessage());
            }
        });
//This event controls what happens to the form depending on what is selected in the ComboBox
        cbType.setOnAction((e) -> {
            if (cbType.getValue().toString().equals("Classic Vodka")) {
                txtFlavour.setText("Regular");
                txtFlavour.setDisable(true);
                txtFlavour.setStyle("-fx-text-fill: red");
            }
            else {
                txtFlavour.setText("");
                txtFlavour.setDisable(false);
                txtFlavour.setStyle("-fx-text-fill: black");
            }
            if (cbType.getValue().toString().equals("Smirnoff Ice")) {
                radSizeS.setSelected(true);
                radSizeM.setDisable(true);
                radSizeL.setDisable(true);
                radSizeXL.setDisable(true);
            }
            else {
                radSizeS.setSelected(false);
                radSizeM.setDisable(false);
                radSizeL.setDisable(false);
                radSizeXL.setDisable(false);
            }
        });
//Text field for id does not allow any letters or periods
        txtId.setOnKeyReleased((e) -> {
            if (!isNumber1(e.getCode())) {
                txtId.selectPreviousWord();
            }
        });
//Text field for flavour does not allow any numbers or periods
        txtFlavour.setOnKeyReleased((e) -> {
            if (isNumber2(e.getCode())) {
                txtFlavour.selectPreviousWord();
            }
        });
//Text field for place does not allow any numbers or periods
        txtPlace.setOnKeyReleased((e) -> {
            if (isNumber2(e.getCode())) {
                txtPlace.selectPreviousWord();
            }
        });
//Text field for year only allows numbers and no periods
        txtYear.setOnKeyReleased((e) -> {
            if (!isNumber1(e.getCode())) {
                txtYear.selectPreviousWord();
            }
        });
//Text field for price only allows numbers (decimals allowed)
        txtPrice.setOnKeyReleased((e) -> {
            if (!isNumber2(e.getCode())) {
                txtPrice.selectPreviousWord();
            }
        });
//Text field for quantity only allows numbers
        txtQuantity.setOnKeyReleased((e) -> {
            if (!isNumber1(e.getCode())) {
                txtQuantity.selectPreviousWord();
            }
        });
//Back button closes all the stages except for main
        btnBack.setOnAction((e) -> {
            closeStages();
        });
//Another back button closes all the stages except for main
        //This one is used inside search page as the view page can be opened at the same time and their respective
        //back buttons have different formatting.
        btnBack2.setOnAction((e) -> {
            closeStages();
        });
//Button to close add confirmation stage
        btnOK1.setOnAction((e) -> {
            addConfirmStage.close();
        });
//button to open view page and formats the page when clicked.
        btnView.setOnAction((e) -> {
            closeStages();
            arrayCheck();
            if (productList.size() == 0) {
                noRecords();
            }
            else {
                mediaPlayer1.stop();
                recordPos = 0;
                clearForm();
                viewScene();
                setTextFields(recordPos);
                viewStage.show();
            }
        });
        //Navigates to first record
        btnFirst.setOnAction((e) -> {
            recordPos = 0;
            setTextFields(recordPos);
        });
        //Navigates to the last record
        btnLast.setOnAction((e) -> {
            recordPos = productList.size() - 1;
            setTextFields(recordPos);
        });
        //shows previous record
        btnPrev.setOnAction((e) -> {
            if (recordPos != 0) {
                recordPos -= 1;
            }
            setTextFields(recordPos);
        });
        //shows next record
        btnNext.setOnAction((e) -> {
            if (recordPos != productList.size() - 1) {
                recordPos += 1;
            }
            setTextFields(recordPos);
        });
        //When a row in ListView is clicked, its respective record is displayed in the form.
        idListView.setOnMouseClicked((e) -> {
            recordNum = idListView.getSelectionModel().getSelectedIndex();
            recordPos = recordNum;
            setTextFields(recordNum);
        });
        //Button to delete a record
        btnDel.setOnAction((e) -> {
            deleteRecord();
            deleteStage.show();
        });
        //When modify button is clicked, proper error checking is done to see if modification is valid. If so, record is updated.
        btnModify.setOnAction((e) -> {
            try {
                if (txtId.getText() == null || cbType.getValue() == null || cbType.getValue().toString().equals("") || txtFlavour.getText() == null || txtPlace == null || txtYear == null || txtPrice == null || txtQuantity == null) {
                    throw new Exception("Please fill out all fields");
                }
                oldId = idList.get(this.recordPos);
                for (int i = 0; i < idList.size(); i++) {
                    if (txtId.getText().equals(idList.get(i)) && Integer.parseInt(txtId.getText()) != oldId) {
                        throw new Exception("Product Id already taken. Please choose another one");
                    }
                }

                if (!radSizeS.isSelected() && !radSizeM.isSelected() && !radSizeL.isSelected() && !radSizeXL.isSelected()) {
                    throw new Exception("Please select a size");
                }

                id = Integer.parseInt(txtId.getText());
                year = Integer.parseInt(txtYear.getText());
                price = Double.parseDouble(txtPrice.getText());
                qty = Integer.parseInt(txtQuantity.getText());

                if (year < 2011) {
                    throw new Exception("Vodka is too old. Throw it out. Year must be between 2011 - 2016.");
                }
                if (year > 2016) {
                    throw new Exception("Return to the present and enter a valid year.");
                }

                if (price < 4) {
                    throw new Exception("Price is too low. Minimum price is $4");
                }
                if (qty < 1) {
                    throw new Exception("Quantity must be at least 1.");
                }

                type = cbType.getValue().toString();
                flavour = txtFlavour.getText();
                place = txtPlace.getText();
                if (radSizeS.isSelected()) {
                    size = 500;
                }
                else if (radSizeM.isSelected()) {
                    size = 750;
                }
                else if (radSizeL.isSelected()) {
                    size = 1000;
                }
                else {
                    size = 1500;
                }
                DecimalFormat df = new DecimalFormat("#.00");
                priceF = df.format(price);
                price = Double.parseDouble(priceF);
                record = id + ", " + type + ", " + flavour + ", " + size + ", " + place + ", " + year + ", " + priceF + ", " + qty;

                modifyRecord();
                modifyStage.show();
            }
            catch (NumberFormatException error) {
                String err = "Make sure ID, year, price and quantity are numbers";
                showError(err);
            }
            catch (Exception error) {
                showError(error.getMessage());
            }
        });
        btnOK2.setOnAction((e) -> {
            deleteStage.close();
        });
        btnOK3.setOnAction((e) -> {
            modifyStage.close();
        });
        //button to open the search page
        btnSearch.setOnAction((e) -> {
            closeStages();
            searchScene();
            mediaPlayer1.stop();
            txtSearch.setText("");
            fieldType.setValue("");
            lblSearchCount.setText("");
            searchStage.show();
        });
        //Search fields are retrieved when search button is clicked
        btnSearch2.setOnAction((e) -> {
            try {
                if (fieldType.getValue().toString().equals("")) {
                    throw new Exception("Please select a field type.");
                }
                if (txtSearch.getText().equals("")) {
                    throw new Exception("Please enter a search criteria");
                }
                getSearch();
                txtSearch.setText("");
                fieldType.setValue("");
                viewStage.close();
            }
            catch (Exception err) {
                showError(err.getMessage());
            }
        });
        //when a row in the table is clicked, program tries to find and open the record in the view page.
        table.setOnMouseClicked((e) -> {
            if (e.getClickCount() == 2) {
                int rowIndex = table.getSelectionModel().getSelectedIndex();
                if (rowIndex >= 0) {
                    TableRecord row = table.getSelectionModel().getSelectedItem();
                    String id = row.getProductId();
                    int idCount = 0;
                    for (int i = 0; i < idList.size(); i++) {
                        if (Integer.parseInt(id) == idList.get(i)) {
                            idCount += 1;
                            viewScene();
                            setTextFields(i);
                            viewStage.show();
                            recordPos = i;
                        }
                    }
                    if (idCount == 0) {
                        showError("Exact record not found.");
                    }
                }
            }
        });
        //Button to close the view page pop-up window.
        btnOK4.setOnAction((e) -> {
            viewStage2.close();
        });
    }

    /**
     * This method (addScene()) sets the scene for the add page.
     * Sets up the form for records to be added.
     */
    private void addScene ()
    {
        Image image5 = new Image("images/logo2.png");
        ImageView logo2 = new ImageView(image5);
        HBox hbA1 = new HBox();
        hbA1.getChildren().addAll(radSizeS, radSizeM);
        hbA1.setSpacing(10);
        hbA1.setPadding(new Insets(0, 0, 15, 0));

        HBox hbA2 = new HBox();
        hbA2.getChildren().addAll(radSizeL, radSizeXL);
        hbA2.setSpacing(10);

        VBox vbARads = new VBox();
        vbARads.getChildren().addAll(hbA1, hbA2);

        GridPane paneA = new GridPane();
        paneA.setHgap(25);
        paneA.setVgap(15);
        paneA.setPadding(new Insets(40, 25, 50, 135));

        paneA.add(lblId, 0, 1);
        paneA.add(txtId, 1, 1);
        txtId.setMaxWidth(190);

        paneA.add(lblType, 0, 2);
        paneA.add(cbType, 1, 2);
        cbType.setMaxWidth(190);

        paneA.add(lblFlavour, 0, 3);
        paneA.add(txtFlavour, 1, 3);
        txtFlavour.setMaxWidth(190);

        paneA.add(lblSize, 0, 4);
        paneA.add(vbARads, 1, 4);

        paneA.add(lblPlace, 0, 5);
        paneA.add(txtPlace, 1, 5);
        txtPlace.setMaxWidth(190);

        paneA.add(lblYear, 0, 6);
        paneA.add(txtYear, 1, 6);
        txtYear.setMaxWidth(190);

        paneA.add(lblPrice, 0, 7);
        paneA.add(txtPrice, 1, 7);
        txtPrice.setMaxWidth(190);

        paneA.add(lblQuantity, 0, 8);
        paneA.add(txtQuantity, 1, 8);
        txtQuantity.setMaxWidth(190);

        VBox vbA = new VBox();
        vbA.getChildren().addAll(logo2, paneA);

        ColumnConstraints c1 = new ColumnConstraints();
        c1.setHalignment(HPos.RIGHT);
        paneA.getColumnConstraints().add(c1);

        ColumnConstraints c2 = new ColumnConstraints();
        c2.setHalignment(HPos.LEFT);
        paneA.getColumnConstraints().add(c2);

        HBox hbA3 = new HBox();
        hbA3.setSpacing(170);
        hbA3.getChildren().addAll(btnBack, btnAdd2);
        hbA3.setPadding(new Insets(10, 0, 25, 85));

        VBox vbA2 = new VBox();
        vbA2.getChildren().addAll(vbA, hbA3);

        Text titleA = new Text(218, 105, "New Record");
        titleA.setFill(Color.WHITE);
        titleA.setFont(Font.font("Courier", FontWeight.BOLD, 45));

        Pane paneA2 = new Pane();
        paneA2.getChildren().addAll(vbA2, titleA);

        Scene scene = new Scene(paneA2, 600, 690);

        scene.getStylesheets()
                .add(FXSmirnoff.class
                        .getResource("MainCSS.css")
                        .toExternalForm());

        String path = FXSmirnoff.class.getResource("smirnoff2.mp3").toString();
        Media music1 = new Media(path);
        mediaPlayer2 = new MediaPlayer(music1);

        addStage.setScene(scene);
        addStage.setTitle("Smirnoff Products: New Record");
    }

    /**
     * This method (addConfirm()) sets the scene for the record added confirmation pop-up.
     */
    private void addConfirm ()
    {
        String recordSum = "Product ID: " + id + "\n"
                + "Product Type: " + type + "\n"
                + "Flavour: " + flavour + "\n"
                + "Size: " + size + "\n"
                + "Place: " + place + "\n"
                + "Year: " + year + "\n"
                + "Price: " + "$" + priceF + "\n"
                + "Quantity: " + qty;

        Text title = new Text(105, 135, "New Record Added");
        title.setFill(Color.WHITE);
        title.setFont(Font.font("Courier", FontWeight.BOLD, 45));

        Text recSum = new Text(210, 205, recordSum);
        recSum.setFill(Color.WHITE);
        recSum.setFont(Font.font("Courier", FontWeight.BOLD, 19));


        Pane pane = new Pane();
        pane.getChildren().addAll(logo, title, recSum);

        HBox hb1 = new HBox();
        hb1.getChildren().add(btnOK1);
        hb1.setPadding(new Insets(75, 45, 25, 450));

        VBox vb1 = new VBox();
        vb1.getChildren().addAll(pane, hb1);

        Scene scene = new Scene(vb1, 600, 585);

        scene.getStylesheets()
                .add(FXSmirnoff.class
                        .getResource("MainCSS.css")
                        .toExternalForm());

        addConfirmStage.setScene(scene);
        addConfirmStage.setTitle("Smirnoff: New Record Added");
    }

    /**
     * This method (searchScene()) sets the scene for the search page.
     */
    private void searchScene ()
    {
        setListView();

        Image image6 = new Image("images/logo3.png");
        ImageView logo3 = new ImageView(image6);
        Text sTitle = new Text(330, 85, "Search Records");
        sTitle.setFill(Color.WHITE);
        sTitle.setFont(Font.font("Courier", FontWeight.BOLD, 45));

        HBox hbS = new HBox();
        hbS.getChildren().addAll(lblSearch, fieldType, txtSearch);
        hbS.setSpacing(35);
        hbS.setAlignment(Pos.CENTER);
        hbS.setPadding(new Insets(55, 0, 35, 0));

        HBox hbS2 = new HBox();
        hbS2.getChildren().addAll(btnBack2, btnSearch2);
        hbS2.setPadding(new Insets(0, 0, 30, 0));
        hbS2.setAlignment(Pos.CENTER);
        hbS2.setSpacing(520);

        Rectangle rectS = new Rectangle();
        rectS.setWidth(950);
        rectS.setHeight(10);
        rectS.setFill(Color.WHITE);

        HBox hbS3 = new HBox();
        hbS3.getChildren().add(lblSearchCount);
        hbS3.setPadding(new Insets(35, 0, 15, 60));

        table.setVisible(false);
        table.scrollTo(0);

        HBox hbS4 = new HBox();
        hbS4.getChildren().add(table);
        hbS4.setPadding(new Insets(35, 0, 0, 0));
        hbS4.setAlignment(Pos.CENTER);

        VBox vbS = new VBox();
        vbS.getChildren().addAll(logo3, hbS, hbS2, rectS, hbS3, table);

        Pane paneS = new Pane();
        paneS.getChildren().addAll(vbS, sTitle);

        Scene searchScene = new Scene(paneS, 950, 830);

        searchScene.getStylesheets()
                .add(FXSmirnoff.class
                        .getResource("MainCSS.css")
                        .toExternalForm());

        searchStage.setScene(searchScene);
        searchStage.setTitle("Smirnoff: Record Search");
    }

    /**
     * This method (getSearch()) is executed after the user submits the search form after passing the exceptions.
     * This method looks to see if there are any records matching the search criteria the user enters.
     * If there are records matching the search criteria, a table is created with TableView to display the data.
     */
    private void getSearch ()
    {
        searchCount = 0;
        searchResult = txtSearch.getText();
        String type = fieldType.getValue().toString();
        int typeNum;
        if (type.equals("Product ID")) {
            typeNum = 0;
        }
        else if (type.equals("Product Type")) {
            typeNum = 1;
        }
        else if (type.equals("Product Flavour")) {
            typeNum = 2;
        }
        else if (type.equals("Product Size")) {
            typeNum = 3;
        }
        else if (type.equals("Place")) {
            typeNum = 4;
        }
        else if (type.equals("Year")) {
            typeNum = 5;
        }
        else if (type.equals("Price")) {
            typeNum = 6;
        }
        else {
            typeNum = 7;
        }

        Collections.sort(productList);

        searchData.clear();
        table.getItems().clear();
        table.getColumns().clear();

        for (int i = 0; i < productList.size(); i++) {
            String[] searchRec = productList.get(i).split(", ");
            if (searchResult.equalsIgnoreCase(searchRec[typeNum])) {
                searchCount += 1;
                String productId = searchRec[0];
                String productType = searchRec[1];
                String flavour = searchRec[2];
                String size = searchRec[3];
                String place = searchRec[4];
                String year = searchRec[5];
                String price = searchRec[6];
                String quantity = searchRec[7];
                searchData.add(new TableRecord(productId, productType, flavour, size, place, year, price, quantity));
            }
        }
        String resultNum = "Search Results: " + searchCount;
        lblSearchCount.setText(resultNum);
        if (searchCount > 0) {
            table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
            TableColumn<TableRecord, String> productIdColumn = new TableColumn<>("Product ID");
            productIdColumn.setCellValueFactory(new PropertyValueFactory<>("productId"));
            productIdColumn.setMinWidth(35);

            TableColumn<TableRecord, String> productTypeColumn = new TableColumn<>("Product Type");
            productTypeColumn.setCellValueFactory(new PropertyValueFactory<>("productType"));
            productTypeColumn.setMinWidth(60);

            TableColumn<TableRecord, String> flavourColumn = new TableColumn<>("Flavour");
            flavourColumn.setCellValueFactory(new PropertyValueFactory<>("flavour"));
            flavourColumn.setMinWidth(60);

            TableColumn<TableRecord, String> sizeColumn = new TableColumn<>("Size");
            sizeColumn.setCellValueFactory(new PropertyValueFactory<>("size"));
            sizeColumn.setPrefWidth(20);

            TableColumn<TableRecord, String> placeColumn = new TableColumn<>("Place");
            placeColumn.setCellValueFactory(new PropertyValueFactory<>("place"));
            placeColumn.setMinWidth(50);

            TableColumn<TableRecord, String> yearColumn = new TableColumn<>("Year");
            yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));

            TableColumn<TableRecord, String> priceColumn = new TableColumn<>("Price");
            priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
            priceColumn.setStyle("-fx-alignment: CENTER-RIGHT");

            TableColumn<TableRecord, String> quantityColumn = new TableColumn<>("Quantity");
            quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
            quantityColumn.setStyle("-fx-alignment: CENTER-RIGHT");

            table.getColumns().addAll(productIdColumn, productTypeColumn, flavourColumn, sizeColumn, placeColumn, yearColumn, priceColumn, quantityColumn);
            table.setItems(searchData);
            table.setVisible(true);
        }
        else {
            table.setVisible(false);
        }
    }

    /**
     * This method (viewScene()) sets the scene for the view records page.
     */
    private void viewScene ()
    {
        Image image4 = new Image("images/logo1.png");
        ImageView logo1 = new ImageView(image4);
        HBox hbM1 = new HBox();
        hbM1.getChildren().addAll(radSizeS, radSizeM);
        hbM1.setSpacing(10);
        hbM1.setPadding(new Insets(0, 0, 15, 0));

        HBox hbM2 = new HBox();
        hbM2.getChildren().addAll(radSizeL, radSizeXL);
        hbM2.setSpacing(10);

        VBox vbRads = new VBox();
        vbRads.getChildren().addAll(hbM1, hbM2);

        GridPane paneM = new GridPane();
        paneM.setHgap(25);
        paneM.setVgap(15);
        paneM.setPadding(new Insets(40, 25, 50, 135));

        paneM.add(lblId, 0, 1);
        paneM.add(txtId, 1, 1);
        txtId.setMaxWidth(190);

        paneM.add(lblType, 0, 2);
        paneM.add(cbType, 1, 2);
        cbType.setMaxWidth(190);

        paneM.add(lblFlavour, 0, 3);
        paneM.add(txtFlavour, 1, 3);
        txtFlavour.setMaxWidth(190);

        paneM.add(lblSize, 0, 4);
        paneM.add(vbRads, 1, 4);

        paneM.add(lblPlace, 0, 5);
        paneM.add(txtPlace, 1, 5);
        txtPlace.setMaxWidth(190);

        paneM.add(lblYear, 0, 6);
        paneM.add(txtYear, 1, 6);
        txtYear.setMaxWidth(190);

        paneM.add(lblPrice, 0, 7);
        paneM.add(txtPrice, 1, 7);
        txtPrice.setMaxWidth(190);

        paneM.add(lblQuantity, 0, 8);
        paneM.add(txtQuantity, 1, 8);
        txtQuantity.setMaxWidth(190);

        ColumnConstraints c1 = new ColumnConstraints();
        c1.setHalignment(HPos.RIGHT);
        paneM.getColumnConstraints().add(c1);

        ColumnConstraints c2 = new ColumnConstraints();
        c2.setHalignment(HPos.LEFT);
        paneM.getColumnConstraints().add(c2);

        VBox vbVF = new VBox();

        vbVF.getChildren().addAll(logo1, paneM);

        HBox hbV1 = new HBox();
        hbV1.getChildren().addAll(btnFirst, btnPrev, btnNext, btnLast, btnBack);
        hbV1.setSpacing(20);
        hbV1.setAlignment(Pos.CENTER);
        hbV1.setPadding(new Insets(25, 0, 25, 0));

        Rectangle rect1 = new Rectangle();
        rect1.setWidth(762);
        rect1.setHeight(10);
        rect1.setFill(Color.WHITE);

        HBox hbV3 = new HBox();
        hbV3.getChildren().addAll(btnDel, btnModify);
        hbV3.setSpacing(170);
        hbV3.setPadding(new Insets(10, 0, 25, 85));

        VBox vbV1 = new VBox();
        vbV1.getChildren().addAll(vbVF, hbV3);
        vbV1.setPadding(new Insets(25, 0, 25, 85));

        VBox vbV2 = new VBox();
        vbV2.getChildren().addAll(hbV1, rect1, vbV1);

        setListView();

        HBox hbV4 = new HBox();
        hbV4.getChildren().addAll(idListView, vbV2);

        idListView.setPrefSize(150, 700);
        idListView.setEditable(false);

        Scene viewscene = new Scene(hbV4, 900, 850);
        viewscene.getStylesheets()
                .add(FXSmirnoff.class
                        .getResource("MainCSS.css")
                        .toExternalForm());
        viewStage.setScene(viewscene);
        viewStage.setTitle("Smirnoff Products: View Products");
    }

    /**
     * This method (noRecords()) sets up the pop-up window for users who click on view button and there are no records.
     */
    private void noRecords ()
    {
        Text rTitle = new Text("No records to view.");
        rTitle.setFill(Color.WHITE);
        rTitle.setFont(Font.font("Courier", FontWeight.BOLD, 45));

        HBox rhb1 = new HBox();
        rhb1.getChildren().add(rTitle);
        rhb1.setAlignment(Pos.CENTER);
        rhb1.setPadding(new Insets(25, 0, 85, 0));

        HBox rhb2 = new HBox();
        rhb2.getChildren().add(btnOK4);
        rhb2.setPadding(new Insets(0, 25, 30, 220));

        VBox rvb = new VBox();
        rvb.getChildren().addAll(rhb1, rhb2);

        Scene rScene = new Scene(rvb, 500, 300);

        rScene.getStylesheets()
                .add(FXSmirnoff.class
                        .getResource("MainCSS.css")
                        .toExternalForm());
        viewStage2.setScene(rScene);
        viewStage2.setTitle("Smirnoff Products: No Records to View");
        viewStage2.setResizable(false);
        viewStage2.show();
    }

    /**
     * This method (deleteRecord()) deletes the displayed record when user clicks the delete button.
     */
    private void deleteRecord ()
    {
        String record[] = productList.get(recordPos).split(", ");
        id = Integer.parseInt(record[0]);
        productList.remove(recordPos);
        viewScene();
        recordPos = 0;
        clearForm();
        setTextFields(recordPos);
        deleteScene();
    }

    /**
     * This method (deleteScene()) sets up the message pop-up for when a record is deleted.
     */
    private void deleteScene ()
    {
        String message = "Original record of \nproduct ID #" + id + "\nhas been deleted.";

        Text delTitle = new Text(155, 135, "Record Deleted");
        delTitle.setFill(Color.WHITE);
        delTitle.setFont(Font.font("Courier", FontWeight.BOLD, 45));

        Text delSum = new Text(250, 205, message);
        delSum.setFill(Color.WHITE);
        delSum.setFont(Font.font("Courier", FontWeight.BOLD, 19));

        Pane paneDel = new Pane();
        paneDel.getChildren().addAll(logo, delTitle, delSum);

        HBox hbD1 = new HBox();
        hbD1.getChildren().add(btnOK2);
        hbD1.setPadding(new Insets(105, 45, 25, 400));

        VBox vbD1 = new VBox();
        vbD1.getChildren().addAll(paneDel, hbD1);

        Scene delScene = new Scene(vbD1, 600, 500);

        delScene.getStylesheets()
                .add(FXSmirnoff.class
                        .getResource("MainCSS.css")
                        .toExternalForm());

        deleteStage.setScene(delScene);
        deleteStage.setTitle("Smirnoff: Record Deleted");
    }

    /**
     * This method modifyRecord() is used to modify records. After modified has been saved to the
     * productList ArrayList, the new modified record is found in the ListView and is highlighted.
     */
    public void modifyRecord ()
    {
        productList.remove(this.recordPos);
        productList.add(this.record);
        Collections.sort(productList);
        setListView();
        String recordFind[] = this.record.split(", ");
        for (int i = 0; i < idList.size(); i++) {
            if (idList.get(i) == Integer.parseInt(recordFind[0])) {
                this.recordPos = i;
            }
        }
        idListView.getSelectionModel().select(this.recordPos);
        idListView.scrollTo(this.recordPos);

        modifyScene();
    }

    /**
     * This method modifyScene() is used to set up the record modified pop-up message.
     */
    public void modifyScene ()
    {
        String message = "Original record of \nproduct ID #" + oldId + "\nhas been modified.";

        Text modTitle = new Text(155, 135, "Record Modified");
        modTitle.setFill(Color.WHITE);
        modTitle.setFont(Font.font("Courier", FontWeight.BOLD, 45));

        Text modSum = new Text(250, 205, message);
        modSum.setFill(Color.WHITE);
        modSum.setFont(Font.font("Courier", FontWeight.BOLD, 19));

        Pane paneMod = new Pane();
        paneMod.getChildren().addAll(logo, modTitle, modSum);

        HBox hbMod = new HBox();
        hbMod.getChildren().add(btnOK3);
        hbMod.setPadding(new Insets(105, 45, 25, 400));

        VBox vbM1 = new VBox();
        vbM1.getChildren().addAll(paneMod, hbMod);

        Scene modScene = new Scene(vbM1, 600, 500);

        modScene.getStylesheets()
                .add(FXSmirnoff.class
                        .getResource("MainCSS.css")
                        .toExternalForm());

        modifyStage.setScene(modScene);
        modifyStage.setTitle("Smirnoff: Record Modified");
    }

    /**
     * This method setIdList() stores the product Ids in an ArrayList.
     */
    private void setIdList ()
    {
        arrayCheck();
        idList.clear();
        Collections.sort(productList);

        for (int i = 0; i < productList.size(); i++) {
            String data1 = productList.get(i);
            String[] data2 = data1.split(", ");  //StringTokenizer had issues; causing program to crash
            idList.add(Integer.parseInt(data2[0]));
        }
    }

    /**
     * This method setListView() is used to update the ListView chart.
     */
    private void setListView ()
    {
        setIdList();

        idData.clear();

        for (int i = 0; i < idList.size(); i++) {
            idData.add(Integer.toString(idList.get(i)));
        }
        idListView.setItems(idData);
    }

    /**
     * This method clearForm() is used to clear the form for the add new record page.
     */
    private void clearForm ()
    {
        txtId.setText(null);
        cbType.setValue("");
        txtFlavour.setText(null);
        radSizeS.setSelected(false);
        radSizeM.setSelected(false);
        radSizeL.setSelected(false);
        radSizeXL.setSelected(false);
        txtPlace.setText(null);
        txtYear.setText(null);
        txtPrice.setText(null);
        txtQuantity.setText(null);
        txtFlavour.setDisable(false);
        txtFlavour.setStyle("-fx-text-fill: black");
        radSizeM.setDisable(false);
        radSizeL.setDisable(false);
        radSizeXL.setDisable(false);
    }

    /**
     * This method setTextFields(int recordNum) accepts an argument for the record that is being searched for.
     * After finding the record by its index number in the productList ArrayList, it sets up the form in view page with
     * the record information.
     * <p>
     * @param recordNum
     */
    private void setTextFields (int recordNum)
    {
        clearForm();
        String[] getRecord = productList.get(recordNum).split(", ");
        txtId.setText(getRecord[0]);
        cbType.setValue(getRecord[1]);
        txtFlavour.setText(getRecord[2]);
        if (Integer.parseInt(getRecord[3]) == 500) {
            radSizeS.setSelected(true);
        }
        else if (Integer.parseInt(getRecord[3]) == 750) {
            radSizeM.setSelected(true);
        }
        else if (Integer.parseInt(getRecord[3]) == 1000) {
            radSizeL.setSelected(true);
        }
        else {
            radSizeXL.setSelected(true);
        }
        txtPlace.setText(getRecord[4]);
        txtYear.setText(getRecord[5]);
        txtPrice.setText(getRecord[6]);
        txtQuantity.setText(getRecord[7]);

        idListView.getSelectionModel().select(recordNum);
        idListView.scrollTo(recordNum);
    }

    /**
     * This method showError(String error) accepts a String argument as a message to pass onto the alert pop-up window.
     * <p>
     * @param error
     */
    private void showError (String error)
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Something went wrong ...");
        alert.setContentText(error);
        alert.showAndWait();
    }

    /**
     * This method fillArrayWithProductList is used at the beginning when the program loads up. It accepts an argument
     * of type String as a file name to get the contents of the data file to be saved in an array.
     * <p>
     * @param filename
     */
    private void fillArrayWithProductList (String filename)
    {
        try {
            FileReader smirnoffFile = new FileReader(filename);
            BufferedReader buffer = new BufferedReader(smirnoffFile);

            String preliminaryLineReader = buffer.readLine();

            if (preliminaryLineReader == null) {
                throw new Exception("No data found. please check file.");
            }

            while (preliminaryLineReader != null) {
                productList.add(preliminaryLineReader);
                preliminaryLineReader = buffer.readLine();
            }
        }

        catch (FileNotFoundException error) {
            String err = "File not found, please check for data file";
            showError(err);
        }

        catch (IOException error) {
            showError(error.getMessage());
        }
        catch (Exception error) {
            showError(error.getMessage());
        }
    }

    /**
     * This method arrayCheck() checks to see if the productList array has any empty lines
     */
    private void arrayCheck ()
    {
        productList.removeAll(Collections.singleton(""));
        productList.removeAll(Collections.singleton(" "));
        productList.removeAll(Collections.singleton(null));
    }

    /**
     * This method saveToFile(String filename) is used a the end of the program when user clicks on save & exit button.
     * It saves all the records to the file name passed as an argument.
     * <p>
     * @param filename
     */
    private void saveToFile (String filename)
    {
        Collections.sort(productList);
        try {
            FileWriter smirnoffProducts = new FileWriter(filename);
            BufferedWriter buffer = new BufferedWriter(smirnoffProducts);
            for (int sub = 0; sub < this.productList.size(); sub++) {
                buffer.write(this.productList.get(sub));
                buffer.newLine();
            }
            buffer.close();
        }
        catch (IOException error) {
            showError(error.getMessage());
        }
    }

    /**
     * This method closes all of the stages except for the main(primary) stage.
     */
    private void closeStages ()
    {
        addStage.close();
        viewStage.close();
        searchStage.close();
        addConfirmStage.close();
        deleteStage.close();
        modifyStage.close();
        viewStage2.close();
    }

    /**
     * This method returns true if the KeyCode passed as argument is a number
     * <p>
     * @param code
     * @return
     */
    private boolean isNumber1 (KeyCode code)
    {
        switch (code) {
            case DIGIT0:
            case DIGIT1:
            case DIGIT2:
            case DIGIT3:
            case DIGIT4:
            case DIGIT5:
            case DIGIT6:
            case DIGIT7:
            case DIGIT8:
            case DIGIT9:
            case DELETE:
            case RIGHT:
            case NUMPAD0:
            case NUMPAD1:
            case NUMPAD2:
            case NUMPAD3:
            case NUMPAD4:
            case NUMPAD5:
            case NUMPAD6:
            case NUMPAD7:
            case NUMPAD8:
            case NUMPAD9:
            case LEFT:
            case BACK_SPACE:
                return true;
        }
        return false;
    }

    /**
     * This method returns true if the KeyCode passed as an argument is a number (which can have a period/decimal)
     * <p>
     * @param code
     * @return
     */
    private boolean isNumber2 (KeyCode code)
    {
        switch (code) {
            case DIGIT0:
            case DIGIT1:
            case DIGIT2:
            case DIGIT3:
            case DIGIT4:
            case DIGIT5:
            case DIGIT6:
            case DIGIT7:
            case DIGIT8:
            case DIGIT9:
            case NUMPAD0:
            case NUMPAD1:
            case NUMPAD2:
            case NUMPAD3:
            case NUMPAD4:
            case NUMPAD5:
            case NUMPAD6:
            case NUMPAD7:
            case NUMPAD8:
            case NUMPAD9:
            case BACK_SPACE:
            case DECIMAL:
            case DELETE:
            case RIGHT:
            case LEFT:
            case CONTROL:
            case ALT:
            case PERIOD:
            case TAB:
                return true;
        }
        return false;
    }

    public static void main (String[] args)
    {
        launch(args);
    }
}
