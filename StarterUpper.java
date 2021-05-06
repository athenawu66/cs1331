//I worked on the homework assignment alone, using course materials and the API guide given.
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.util.ArrayList;
import java.util.Collections;
import java.io.File;
import javafx.scene.control.ButtonType;
import java.util.Optional;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.control.TextInputDialog;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.control.ListView;

/**
*This class represents a problem space to base the startup around.
*@author Athena Wu
* @version 1.0
*/
public class StarterUpper extends Application {
    /**
    * Creates a method that starts the creation of the startup form.
    * @param mainStage the stage that displays the scene created
    */
    public void start(Stage mainStage) throws FileNotFoundException, Exception {
        ArrayList<StartUpIdea> startupList = new ArrayList<StartUpIdea>();
        BorderPane borderPane = new BorderPane();
        File newFile = new File("newFileName.txt");
        Label label0 = new Label("What is the name of your startup company?");
        label0.setFont(Font.font("Verdana", 20));
        GridPane.setConstraints(label0, 0, 0);
        TextField textField0 = new TextField();
        GridPane.setConstraints(textField0, 1, 0);
        Label label1 = new Label("What is the problem?");
        label1.setFont(Font.font("Verdana", 20));
        GridPane.setConstraints(label1, 0, 1);
        TextField textField1 = new TextField();
        GridPane.setConstraints(textField1, 1, 1);
        Label label2 = new Label("Who is the target customer?");
        label2.setFont(Font.font("Verdana", 20));
        GridPane.setConstraints(label2, 0, 2);
        TextField textField2 = new TextField();
        GridPane.setConstraints(textField2, 1, 2);
        Label label3 = new Label("How badly does the customer NEED this problem fixed (1-10)?");
        label3.setFont(Font.font("Verdana", 20));
        GridPane.setConstraints(label3, 0, 3);
        TextField textField3 = new TextField();
        GridPane.setConstraints(textField3, 1, 3);
        Label label4 = new Label("How many people do you know who might experience this problem?");
        label4.setFont(Font.font("Verdana", 20));
        GridPane.setConstraints(label4, 0, 4);
        TextField textField4 = new TextField();
        GridPane.setConstraints(textField4, 1, 4);
        Label label5 = new Label("How big is the target market?");
        label5.setFont(Font.font("Verdana", 20));
        GridPane.setConstraints(label5, 0, 5);
        TextField textField5 = new TextField();
        GridPane.setConstraints(textField5, 1, 5);
        Label label6 = new Label("Who are the competitors/existing solutions?");
        label6.setFont(Font.font("Verdana", 20));
        GridPane.setConstraints(label6, 0, 6);
        TextField textField6 = new TextField();
        GridPane.setConstraints(textField6, 1, 6);
        Label label7 = new Label("What are some marketing tactics you have in mind?");
        label7.setFont(Font.font("Verdana", 20));
        GridPane.setConstraints(label7, 0, 7);
        TextField textField7 = new TextField();
        GridPane.setConstraints(textField7, 1, 7);
        GridPane root = new GridPane();
        Button btn1 = new Button("Add Idea");
        root.setVgap(30);
        root.setHgap(30);
        root.setAlignment(Pos.CENTER);
        root.setMinSize(800, 400);
        root.getChildren().addAll(label0, textField0, label1, textField1, label2, textField2, label3,
                textField3, label4, textField4, label5, textField5, label6, textField6, label7, textField7);
        root.setPadding(new Insets(10, 10, 10, 10));
        EventHandler<ActionEvent> handler = new EventHandler<>() {
            public void handle(ActionEvent event) {
                String name = textField0.getText();
                String theProblem = textField1.getText();
                String targetCustomer = textField2.getText();
                String customerBadly = textField3.getText();
                String peopleExperience = textField4.getText();
                String targetMarketSize = textField5.getText();
                String competitors = textField6.getText();
                String marketIdeas = textField7.getText();
                try {
                        if (name.equals("") || theProblem.equals("") || targetCustomer.equals("")
                            || customerBadly.equals("") || peopleExperience.equals("")
                            || targetMarketSize.equals("") || competitors.equals("") || marketIdeas.equals("")) {
                        Alert a = new Alert(AlertType.ERROR);
                        a.setTitle("ERROR");
                        a.setContentText("One of your text fields is empty. Please try again.");
                        a.show();
                    } else {
                        int b = Integer.parseInt(customerBadly);
                        int c = Integer.parseInt(peopleExperience);
                        int d = Integer.parseInt(targetMarketSize);
                        if (b > 10 || b < 1 || c < 0 || d < 0) {
                            Alert anAlert = new Alert(AlertType.ERROR);
                            anAlert.setTitle("ERROR");
                            anAlert.setContentText("The integer you provided as a response to "
                                + "one of the questions is out of bounds." + " Please try again.");
                            anAlert.show();
                        } else {
                            StartUpIdea anIdea = new StartUpIdea(name, theProblem, targetCustomer,
                                b, c, d, competitors, marketIdeas);
                            startupList.add(anIdea);
                            textField0.setText("");
                            textField1.setText("");
                            textField2.setText("");
                            textField3.setText("");
                            textField4.setText("");
                            textField5.setText("");
                            textField6.setText("");
                            textField7.setText("");
                        }

                    }
                } catch (NumberFormatException x) {
                    Alert e = new Alert(AlertType.ERROR);
                    e.setTitle("ERROR");
                    e.setContentText("What you have inputed is not a valid integer for a question."
                        + "Please try again.");
                    e.show();
                }
            }
            };
        btn1.setOnAction(handler);
        Button ideaSorter = new Button("Sort Ideas");
        GridPane.setConstraints(ideaSorter, 0, 7);
        ideaSorter.setOnAction((ActionEvent event) -> {
                Collections.sort(startupList);
            });
        Button deleter = new Button("Reset");
        EventHandler<ActionEvent> handler2 = new EventHandler<>() {
                public void handle(ActionEvent event) {
                    Alert warning =
                        new Alert(AlertType.WARNING, "This button resets the form. Are you sure "
                            + "you want to proceed?", ButtonType.OK, ButtonType.CANCEL);
                    warning.setTitle("WARNING");
                    warning.setContentText("This button resets the form. Are you sure you want to"
                            +  " proceed?");
                    Optional<ButtonType> display = warning.showAndWait();
                    if (display.get() == ButtonType.OK) {
                        if (newFile.exists()) {
                            newFile.delete();
                            startupList.clear();
                            textField0.setText("");
                            textField1.setText("");
                            textField2.setText("");
                            textField3.setText("");
                            textField4.setText("");
                            textField5.setText("");
                            textField6.setText("");
                            textField7.setText("");
                        }
                    }

                }
            };
        deleter.setOnAction(handler2);
        Button buttonSave = new Button("Save your ideas");
        buttonSave.setOnAction((ActionEvent event) -> {
                FileUtil.saveIdeasToFile(startupList, newFile);
            });
        Button delete = new Button("Delete a Previous Startup Idea");
        EventHandler<ActionEvent> handler3 = new EventHandler<>() {
                public void handle(ActionEvent event) {
                    TextInputDialog textDialog = new TextInputDialog();
                    textDialog.setHeaderText("What's the "
                        + "name of the startup idea that you want to delete?");
                    Optional<String> aResult = textDialog.showAndWait();
                    TextField input = textDialog.getEditor();
                    String theText = input.getText();
                    if (theText.equals("")) {
                        System.out.println("Please enter a valid name. You "
                            + "currently have not entered anything.");
                    } else {
                        int count = 0;
                        for (int i = 0; i < startupList.size(); i++) {
                            if (startupList.get(i).getName().equals(theText)) {
                                startupList.remove(i);
                                count++;
                            }
                        }
                        if (count == 0) {
                            System.out.println("The name of the startup idea cannot "
                                + "be found. Please try again.");
                        } else {
                            System.out.println("Deleted successfully!");
                        }
                    }
                    textDialog.show();
                }
            };
        delete.setOnAction(handler3);
        ObservableList<String> ideaString = FXCollections.observableArrayList();
        Button display = new Button("Display my Ideas");
        EventHandler<ActionEvent> handler5 = new EventHandler<>() {
            public void handle(ActionEvent event) {
                ListView listView = new ListView(ideaString);
                ideaString.clear();
                for (int i = 0; i < startupList.size(); i++) {
                    ideaString.add(startupList.get(i).toString());
                }
                listView.setItems(ideaString);
                listView.setStyle(("-fx-control-inner-background: pink;"));
                borderPane.setRight(listView);
                }
            };
        display.setOnAction(handler5);
        FileInputStream anImage = new FileInputStream("/Users/user/businessphoto.jpeg");
        Image image = new Image(anImage);
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setY(10);
        imageView.setX(10);
        imageView.setFitWidth(600);
        imageView.setPreserveRatio(true);
        Group imagePlacer = new Group(imageView);
        HBox box = new HBox(10);
        box.getChildren().addAll(btn1, ideaSorter, deleter, buttonSave, delete, display); //buttons, hbox
        box.setAlignment(Pos.CENTER);
        VBox box2 = new VBox(60);
        box2.setAlignment(Pos.CENTER);
        box2.getChildren().addAll(root, box);
        borderPane.setCenter(box2);
        VBox centerPhoto = new VBox(100);
        centerPhoto.setAlignment(Pos.CENTER);
        centerPhoto.getChildren().addAll(imagePlacer);
        borderPane.setBottom(centerPhoto);
        try {
            String song = "Recording.mp3";
            Media pathway = new Media(new File(song).toURI().toString());
            MediaPlayer playsBackgroundMusic = new MediaPlayer(pathway);
            playsBackgroundMusic.play();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        borderPane.setStyle("-fx-background-color:pink");
        Scene scene = new Scene(borderPane, 800, 800);
        mainStage.setTitle("Problem Ideation Form");
        mainStage.setScene(scene);
        mainStage.show();
    }
}
