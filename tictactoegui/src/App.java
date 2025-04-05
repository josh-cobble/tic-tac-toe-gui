import javafx.application.Application;
import javafx.scene.Scene;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.control.*;


public class App extends Application {

    private char playerTurn = 'X';

    private Square[][] board = new Square[5][5];

    private Label bottomLabel = new Label("Player X's turn"); {

        bottomLabel.setFont(new Font (30));
        bottomLabel.setAlignment(Pos.CENTER);
        }
    private boolean ongoingGame = true;

    public static void main(String[] args) throws Exception {
        launch(args);
     }

    Text title = new Text("5x5 TicTacToe"); {

    title.setFont(new Font(40));
    title.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
    }


@Override
public void start (Stage stage1) {

    GridPane gridPane = new GridPane();
    gridPane.setAlignment(Pos.CENTER);

    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
            board[i][j] = new Square();
            gridPane.add(board[i][j], j, i);
    }
    }

    Button btn1 = new Button("New game");
    btn1.setOnAction(e -> finishGame());
    btn1.setPrefWidth(150);
    btn1.setPrefHeight(50);
    btn1.setFont(new Font(20));

    BorderPane borderPane = new BorderPane();
    borderPane.setCenter(gridPane);
    borderPane.setBottom(bottomLabel);
    borderPane.setTop(title);
    BorderPane.setAlignment(title, Pos.CENTER);
    borderPane.setLeft(btn1);
    BorderPane.setAlignment(btn1, Pos.CENTER);
    BorderPane.setAlignment(bottomLabel, Pos.CENTER);
    BorderPane.setMargin(bottomLabel, new Insets(10, 0, 10, 0));
    BorderPane.setMargin(btn1, new Insets(0, 10, 0, 20));

    Scene scene = new Scene(borderPane, 800, 500);
    stage1.setScene(scene);
    stage1.setTitle("5x5 TicTacToe Board");
    stage1.show();

}

public boolean shape() {
    for (int i = 0; i < 5; i++) {
    for (int j = 0; j < 5; j++) {
    if (board[i][j].returnShapeType() == ' ') {
    return false;
    }
    }
}
    return true;
}

public class Square extends Pane {

private char shapeType = ' ';
private Text determineShape = new Text();

public Square() {
    setStyle("-fx-border-color: black");
    setPrefSize(100, 100);
    setOnMouseClicked(e -> userMouseClick());
    getChildren().add(determineShape);
    }

    public char returnShapeType() {
        return shapeType;
    }

    public void setShapeType(char type) {
        shapeType = type;

        determineShape.setText(String.valueOf(type));
        determineShape.setFont(new Font(40));
        determineShape.setX(getWidth() / 2 - 10);
        determineShape.setY(getHeight() / 2 + 10);

    }

    private void userMouseClick() {
        if (!ongoingGame) return;
        
        if (shapeType == ' ' && playerTurn != ' ' && ongoingGame) {
            setShapeType(playerTurn);

            if (victory(playerTurn)) {
                bottomLabel.setText(playerTurn + " wins!");
                ongoingGame = false;
                return;
            }

            if (shape() && !victory(playerTurn)) {
                bottomLabel.setText("It's a tie!");
                ongoingGame = false;
                return;
            }

            if (playerTurn == 'X') {
                playerTurn = 'O';
            }
            else {
                playerTurn = 'X';
            }

            bottomLabel.setText("Player " + playerTurn + "'s turn.");
        }
    }

}


private boolean victory(char userShapeType) {
    for (int i = 0; i < 5; i++) {
        if (board[i][0].returnShapeType() == userShapeType &&
            board[i][1].returnShapeType() == userShapeType &&
            board[i][2].returnShapeType() == userShapeType &&
            board[i][3].returnShapeType() == userShapeType &&
            board[i][4].returnShapeType() == userShapeType) {
            return true;
            }
    }

    for (int j = 0; j < 5; j++) {
            if (board[0][j].returnShapeType() == userShapeType &&
                board[1][j].returnShapeType() == userShapeType &&
                board[2][j].returnShapeType() == userShapeType &&
                board[3][j].returnShapeType() == userShapeType &&
                board[4][j].returnShapeType() == userShapeType) {
                return true;
                }
        }

            if (board[0][0].returnShapeType() == userShapeType &&
                board[1][1].returnShapeType() == userShapeType &&
                board[2][2].returnShapeType() == userShapeType &&
                board[3][3].returnShapeType() == userShapeType &&
                board[4][4].returnShapeType() == userShapeType) {
                return true;
                }

            if (board[0][4].returnShapeType() == userShapeType &&
                board[1][3].returnShapeType() == userShapeType &&
                board[2][2].returnShapeType() == userShapeType &&
                board[3][1].returnShapeType() == userShapeType &&
                board[4][0].returnShapeType() == userShapeType) {
                return true;
                }
                return false;
}


private void finishGame() {
    
    ongoingGame = true;
    
    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
            board[i][j].setShapeType(' ');
        }
    }

    playerTurn = 'X';
}

}
