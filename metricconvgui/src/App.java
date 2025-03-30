import javafx.application.Application;
import javafx.scene.Scene;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.text.Font;

public class App extends Application {

    private TextField textfield;
    private Text text;
    private Text text2;

    public static void main(String[] args) throws Exception {
        launch(args);
    }

@Override
public void start (Stage stage1) {

    GridPane gridPane = new GridPane();

    gridPane.setAlignment(Pos.CENTER);
    gridPane.setVgap(15);
    gridPane.setHgap(10);
    gridPane.setPadding(new Insets(20, 20, 20, 20));

    text = new Text("Welcome to the metric converter! Please enter a number in the box below. Then click on the button for the conversion you would like.\nFor example, enter '12' (without the quotation marks) and then select 'cm to in' to see 12 cm converted to 4.724 in.");
    text.setFont(new Font(20));
    GridPane.setColumnSpan(text, 4);

    text2 = new Text("");
    text2.setFont(new Font(17));
    GridPane.setColumnSpan(text2, 4);

    textfield = new TextField();
    textfield.setPrefWidth(400);

    Button btn1 = new Button("cm to in");
    Button btn2 = new Button("cm to mm");
    Button btn3 = new Button("ft to yd");
    Button btn4 = new Button("m to ft");

    btn1.setStyle("-fx-font-size: 16px; -fx-padding: 10px 20px;");
    btn2.setStyle("-fx-font-size: 16px; -fx-padding: 10px 20px;");
    btn3.setStyle("-fx-font-size: 16px; -fx-padding: 10px 20px;");
    btn4.setStyle("-fx-font-size: 16px; -fx-padding: 10px 20px;");

    btn1.setOnAction(e -> cmToIn());
    btn2.setOnAction(e -> cmToMm());
    btn3.setOnAction(e -> ftToYd());
    btn4.setOnAction(e -> mToFt());

    gridPane.add(btn1, 0, 2);
    gridPane.add(btn2, 1, 2);
    gridPane.add(btn3, 2, 2);
    gridPane.add(btn4, 3, 2);
    gridPane.add(textfield, 0, 1, 4, 1);
    gridPane.add(text, 0, 0, 4, 1);
    gridPane.add(text2, 0, 3, 4, 1);

    Scene scene = new Scene(gridPane, 800, 500);

    stage1.setScene(scene);
    stage1.setTitle("Metric Converter");
    stage1.show();

}

private void cmToIn() {
    try {
        System.out.println("Button 1 was clicked.");
        double inputNum = Double.parseDouble(textfield.getText());
        double outputNum = inputNum / 2.54;
        text2.setText(inputNum + " cm = " + outputNum + " in");
    }
    catch (NumberFormatException e) {
        text2.setText("Please enter a valid input (a number).");
    }
}

private void cmToMm() {
    System.out.println("Button 2 was clicked.");
    try {
        double inputNum = Double.parseDouble(textfield.getText());
        double outputNum = inputNum * 10;
        text2.setText(inputNum + " cm = " + outputNum + " mm");
    }
    catch (NumberFormatException e) {
        text2.setText("Please enter a valid input (a number).");
    }
} 

private void ftToYd() {
    System.out.println("Button 3 was clicked.");
    try {
        double inputNum = Double.parseDouble(textfield.getText());
        double outputNum = inputNum / 3;
        text2.setText(inputNum + " ft = " + outputNum + " yd");
    }
    catch (NumberFormatException e) {
        text2.setText("Please enter a valid input (a number).");
    }
}

private void mToFt() {
    System.out.println("Button 4 was clicked.");
    try {
        double inputNum = Double.parseDouble(textfield.getText());
        double outputNum = inputNum * 3.28084;
        text2.setText(inputNum + " m = " + outputNum + " ft");
    }
    catch (NumberFormatException e) {
        text2.setText("Please enter a valid input (a number).");
    }
}

}
