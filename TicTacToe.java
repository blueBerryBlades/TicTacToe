package TicTacToe;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TicTacToe extends Application {

	private String playerMark;
	private String adversaryMark;
	private int activeButtons = 9;

	@Override
	public void start(Stage primaryStage) {

		VBox vbox = new VBox(10);
		vbox.setAlignment(Pos.TOP_CENTER);
		vbox.setPadding(new Insets(20, 20, 20, 20));

		Button labelBut = new Button("TIC TAC TOE");
		labelBut.setFont(Font.font("Verdana", 20));
		Button xbut = new Button("X");
		Button obut = new Button("O");
		HBox hbox = new HBox();
		hbox.setAlignment(Pos.TOP_CENTER);
		hbox.getChildren().add(xbut);
		hbox.getChildren().add(labelBut);
		hbox.getChildren().add(obut);
		hbox.setMinHeight(70);
		hbox.setMinWidth(70);
		xbut.setMinWidth(hbox.getMinWidth());
		xbut.setMinHeight(hbox.getMinHeight());
		obut.setMinWidth(hbox.getMinWidth());
		obut.setMinHeight(hbox.getMinHeight());
		labelBut.setMinHeight(hbox.getMinHeight());
		labelBut.setMinWidth(160);

		int val = 100;

		GridPane gridpane = new GridPane();
		gridpane.setAlignment(Pos.TOP_CENTER);
		gridpane.setPrefHeight(val);
		gridpane.setPrefWidth(val);
		gridpane.getColumnConstraints().add(new ColumnConstraints(val));
		gridpane.getColumnConstraints().add(new ColumnConstraints(val));
		gridpane.getColumnConstraints().add(new ColumnConstraints(val));
		gridpane.getRowConstraints().add(new RowConstraints(val));
		gridpane.getRowConstraints().add(new RowConstraints(val));
		gridpane.getRowConstraints().add(new RowConstraints(val));

		Button but00 = new Button();
		but00.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 25));
		but00.setMinHeight(val);
		but00.setMinWidth(val);
		Button but01 = new Button();
		but01.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 25));
		but01.setMinHeight(val);
		but01.setMinWidth(val);
		Button but02 = new Button();
		but02.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 25));
		but02.setMinHeight(val);
		but02.setMinWidth(val);
		Button but10 = new Button();
		but10.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 25));
		but10.setMinHeight(val);
		but10.setMinWidth(val);
		Button but11 = new Button();
		but11.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 25));
		but11.setMinHeight(val);
		but11.setMinWidth(val);
		Button but12 = new Button();
		but12.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 25));
		but12.setMinHeight(val);
		but12.setMinWidth(val);
		Button but20 = new Button();
		but20.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 25));
		but20.setMinHeight(val);
		but20.setMinWidth(val);
		Button but21 = new Button();
		but21.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 25));
		but21.setMinHeight(val);
		but21.setMinWidth(val);
		Button but22 = new Button();
		but22.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 25));
		but22.setMinHeight(val);
		but22.setMinWidth(val);

		but00.setOnAction(
				e -> gridButMethod(but00, gridpane, but00, but01, but02, but10, but11, but12, but20, but21, but22));
		but01.setOnAction(
				e -> gridButMethod(but01, gridpane, but00, but01, but02, but10, but11, but12, but20, but21, but22));
		but02.setOnAction(
				e -> gridButMethod(but02, gridpane, but00, but01, but02, but10, but11, but12, but20, but21, but22));
		but10.setOnAction(
				e -> gridButMethod(but10, gridpane, but00, but01, but02, but10, but11, but12, but20, but21, but22));
		but11.setOnAction(
				e -> gridButMethod(but11, gridpane, but00, but01, but02, but10, but11, but12, but20, but21, but22));
		but12.setOnAction(
				e -> gridButMethod(but12, gridpane, but00, but01, but02, but10, but11, but12, but20, but21, but22));
		but20.setOnAction(
				e -> gridButMethod(but20, gridpane, but00, but01, but02, but10, but11, but12, but20, but21, but22));
		but21.setOnAction(
				e -> gridButMethod(but21, gridpane, but00, but01, but02, but10, but11, but12, but20, but21, but22));
		but22.setOnAction(
				e -> gridButMethod(but22, gridpane, but00, but01, but02, but10, but11, but12, but20, but21, but22));

		gridpane.add(but00, 0, 0);
		gridpane.add(but01, 0, 1);
		gridpane.add(but02, 0, 2);
		gridpane.add(but10, 1, 0);
		gridpane.add(but11, 1, 1);
		gridpane.add(but12, 1, 2);
		gridpane.add(but20, 2, 0);
		gridpane.add(but21, 2, 1);
		gridpane.add(but22, 2, 2);

		ObservableList<Node> children = gridpane.getChildren();
		for (Node child : children) {
			if (child instanceof Button) {
				child.setDisable(true);
			}
		}

		labelBut.setOnAction(e -> labelButMethod(labelBut, xbut, obut, but00, but01, but02, but10, but11, but12, but20,
				but21, but22));
		xbut.setOnAction(e -> xbutMethod(xbut, obut, but00, but01, but02, but10, but11, but12, but20, but21, but22));
		obut.setOnAction(e -> obutMethod(xbut, obut, but00, but01, but02, but10, but11, but12, but20, but21, but22));

		vbox.getChildren().add(hbox);
		vbox.getChildren().add(gridpane);

		Scene scene = new Scene(vbox, 350, 420);
		primaryStage.setTitle("TTT");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();

	}

	public void xbutMethod(Button xbut, Button obut, Button but00, Button but01, Button but02, Button but10,
			Button but11, Button but12, Button but20, Button but21, Button but22) {
		this.playerMark = "X";
		this.adversaryMark = "O";

		xbut.setStyle("-fx-background-color: #5F9EA0");
		obut.setStyle("-fx-background-color: #F08080");

		xbut.setDisable(true);
		obut.setDisable(true);

		but00.setDisable(false);
		but01.setDisable(false);
		but02.setDisable(false);
		but10.setDisable(false);
		but11.setDisable(false);
		but12.setDisable(false);
		but20.setDisable(false);
		but21.setDisable(false);
		but22.setDisable(false);
	}

	public void obutMethod(Button xbut, Button obut, Button but00, Button but01, Button but02, Button but10,
			Button but11, Button but12, Button but20, Button but21, Button but22) {
		this.playerMark = "O";
		this.adversaryMark = "X";
		xbut.setDisable(true);
		obut.setDisable(true);

		obut.setStyle("-fx-background-color: #5F9EA0");
		xbut.setStyle("-fx-background-color: #F08080");

		but00.setDisable(false);
		but01.setDisable(false);
		but02.setDisable(false);
		but10.setDisable(false);
		but11.setDisable(false);
		but12.setDisable(false);
		but20.setDisable(false);
		but21.setDisable(false);
		but22.setDisable(false);

	}

	public void labelButMethod(Button labelBut, Button xbut, Button obut, Button but00, Button but01, Button but02,
			Button but10, Button but11, Button but12, Button but20, Button but21, Button but22) {

		xbut.setDisable(false);
		obut.setDisable(false);

		obut.setStyle("-fx-background-color: transparent");
		xbut.setStyle("-fx-background-color: transparent");

		this.adversaryMark = "";
		this.playerMark = "";
		this.activeButtons = 9;

		but00.setDisable(true);
		but00.setText("");
		but00.setStyle("-fx-backgroud-color: transparent");
		but01.setDisable(true);
		but01.setText("");
		but01.setStyle("-fx-backgroud-color: transparent");
		but02.setDisable(true);
		but02.setText("");
		but02.setStyle("-fx-backgroud-color: transparent");
		but10.setDisable(true);
		but10.setText("");
		but10.setStyle("-fx-backgroud-color: transparent");
		but11.setDisable(true);
		but11.setText("");
		but11.setStyle("-fx-backgroud-color: transparent");
		but12.setDisable(true);
		but12.setText("");
		but12.setStyle("-fx-backgroud-color: transparent");
		but20.setDisable(true);
		but20.setText("");
		but20.setStyle("-fx-backgroud-color: transparent");
		but21.setDisable(true);
		but21.setText("");
		but21.setStyle("-fx-backgroud-color: transparent");
		but22.setDisable(true);
		but22.setText("");
		but22.setStyle("-fx-backgroud-color: transparent");

		if (labelBut.getText() == "TIC TAC TOE") {
			labelBut.setText("TIC");
			labelBut.setFont(Font.font("Verdana", 20));
		} else if (labelBut.getText() == "TIC") {
			labelBut.setText("TAC");
			labelBut.setFont(Font.font("Verdana", 20));
		} else if (labelBut.getText() == "TAC") {
			labelBut.setText("TOE");
			labelBut.setFont(Font.font("Verdana", 20));
		} else if (labelBut.getText() == "TOE") {
			labelBut.setText("TIC TAC TOE");
			labelBut.setFont(Font.font("Verdana", 20));
		}

	}

	public void gridButMethod(Button button, GridPane gridpane, Button but00, Button but01, Button but02, Button but10,
			Button but11, Button but12, Button but20, Button but21, Button but22) {

		button.setText(this.playerMark);
		button.setDisable(true);

		this.activeButtons = this.activeButtons - 1;
		if (this.activeButtons == 0) {
			but00.setDisable(true);
			but01.setDisable(true);
			but02.setDisable(true);
			but10.setDisable(true);
			but11.setDisable(true);
			but12.setDisable(true);
			but20.setDisable(true);
			but21.setDisable(true);
			but22.setDisable(true);
		}

		checkWin(gridpane, but00, but01, but02, but10, but11, but12, but20, but21, but22);
	}

	public void checkWin(GridPane gridpane, Button but00, Button but01, Button but02, Button but10, Button but11,
			Button but12, Button but20, Button but21, Button but22) {

		if ((but00.getText().equals(this.playerMark)) && (but01.getText().equals(this.playerMark))
				&& (but02.getText().equals(this.playerMark))) {
			but00.setStyle("-fx-background-color: #00ff00");
			but01.setStyle("-fx-background-color: #00ff00");
			but02.setStyle("-fx-background-color: #00ff00");

			ObservableList<Node> children = gridpane.getChildren();
			for (Node child : children) {
				if (child instanceof Button) {
					child.setDisable(true);
				}

			}

		} else if ((but10.getText().equals(this.playerMark)) && (but11.getText().equals(this.playerMark))
				&& (but12.getText().equals(this.playerMark))) {
			but10.setStyle("-fx-background-color: #00ff00");
			but11.setStyle("-fx-background-color: #00ff00");
			but12.setStyle("-fx-background-color: #00ff00");

			ObservableList<Node> children = gridpane.getChildren();
			for (Node child : children) {
				if (child instanceof Button) {
					child.setDisable(true);
				}

			}

		} else if ((but20.getText().equals(this.playerMark)) && (but21.getText().equals(this.playerMark))
				&& (but22.getText().equals(this.playerMark))) {
			but20.setStyle("-fx-background-color: #00ff00");
			but21.setStyle("-fx-background-color: #00ff00");
			but22.setStyle("-fx-background-color: #00ff00");

			ObservableList<Node> children = gridpane.getChildren();
			for (Node child : children) {
				if (child instanceof Button) {
					child.setDisable(true);
				}

			}

		} else if ((but00.getText().equals(this.playerMark)) && (but10.getText().equals(this.playerMark))
				&& (but20.getText().equals(this.playerMark))) {
			but00.setStyle("-fx-background-color: #00ff00");
			but10.setStyle("-fx-background-color: #00ff00");
			but20.setStyle("-fx-background-color: #00ff00");

			ObservableList<Node> children = gridpane.getChildren();
			for (Node child : children) {
				if (child instanceof Button) {
					child.setDisable(true);
				}

			}

		} else if ((but01.getText().equals(this.playerMark)) && (but11.getText().equals(this.playerMark))
				&& (but21.getText().equals(this.playerMark))) {
			but01.setStyle("-fx-background-color: #00ff00");
			but11.setStyle("-fx-background-color: #00ff00");
			but21.setStyle("-fx-background-color: #00ff00");

			ObservableList<Node> children = gridpane.getChildren();
			for (Node child : children) {
				if (child instanceof Button) {
					child.setDisable(true);
				}

			}

		} else if ((but02.getText().equals(this.playerMark)) && (but12.getText().equals(this.playerMark))
				&& (but22.getText().equals(this.playerMark))) {
			but02.setStyle("-fx-background-color: #00ff00");
			but12.setStyle("-fx-background-color: #00ff00");
			but22.setStyle("-fx-background-color: #00ff00");

			ObservableList<Node> children = gridpane.getChildren();
			for (Node child : children) {
				if (child instanceof Button) {
					child.setDisable(true);
				}

			}

		} else if ((but00.getText().equals(this.playerMark)) && (but11.getText().equals(this.playerMark))
				&& (but22.getText().equals(this.playerMark))) {
			but00.setStyle("-fx-background-color: #00ff00");
			but11.setStyle("-fx-background-color: #00ff00");
			but22.setStyle("-fx-background-color: #00ff00");

			ObservableList<Node> children = gridpane.getChildren();
			for (Node child : children) {
				if (child instanceof Button) {
					child.setDisable(true);
				}

			}

		} else if ((but02.getText().equals(this.playerMark)) && (but11.getText().equals(this.playerMark))
				&& (but20.getText().equals(this.playerMark))) {
			but02.setStyle("-fx-background-color: #00ff00");
			but11.setStyle("-fx-background-color: #00ff00");
			but20.setStyle("-fx-background-color: #00ff00");

			ObservableList<Node> children = gridpane.getChildren();
			for (Node child : children) {
				if (child instanceof Button) {
					child.setDisable(true);
				}

			}

		} else {

			if (this.activeButtons > 0) {

				List<Button> butList = Arrays.asList(but00, but01, but02, but10, but11, but12, but20, but21, but22);
				Random random = new Random();

				while (true) {
					int index = random.nextInt(butList.size());
					Button button = butList.get(index);

					if (button.isDisable() != true) {
						button.setText(this.adversaryMark);
						button.setDisable(true);

						this.activeButtons = this.activeButtons - 1;

						checkWinA(gridpane, but00, but01, but02, but10, but11, but12, but20, but21, but22);
						break;

					}

				}

			}
		}
	}

	public void checkWinA(GridPane gridpane, Button but00, Button but01, Button but02, Button but10, Button but11,
			Button but12, Button but20, Button but21, Button but22) {

		if ((but00.getText().equals(this.adversaryMark)) && (but01.getText().equals(this.adversaryMark))
				&& (but02.getText().equals(this.adversaryMark))) {
			but00.setStyle("-fx-background-color: #CD5C5C");
			but01.setStyle("-fx-background-color: #CD5C5C");
			but02.setStyle("-fx-background-color: #CD5C5C");

			ObservableList<Node> children = gridpane.getChildren();
			for (Node child : children) {
				if (child instanceof Button) {
					child.setDisable(true);
				}

			}

		} else if ((but10.getText().equals(this.adversaryMark)) && (but11.getText().equals(this.adversaryMark))
				&& (but12.getText().equals(this.adversaryMark))) {
			but10.setStyle("-fx-background-color: #CD5C5C");
			but11.setStyle("-fx-background-color: #CD5C5C");
			but12.setStyle("-fx-background-color: #CD5C5C");

			ObservableList<Node> children = gridpane.getChildren();
			for (Node child : children) {
				if (child instanceof Button) {
					child.setDisable(true);
				}

			}

		} else if ((but20.getText().equals(this.adversaryMark)) && (but21.getText().equals(this.adversaryMark))
				&& (but22.getText().equals(this.adversaryMark))) {
			but20.setStyle("-fx-background-color: #CD5C5C");
			but21.setStyle("-fx-background-color: #CD5C5C");
			but22.setStyle("-fx-background-color: #CD5C5C");

			ObservableList<Node> children = gridpane.getChildren();
			for (Node child : children) {
				if (child instanceof Button) {
					child.setDisable(true);
				}

			}

		} else if ((but00.getText().equals(this.adversaryMark)) && (but10.getText().equals(this.adversaryMark))
				&& (but20.getText().equals(this.adversaryMark))) {
			but00.setStyle("-fx-background-color: #CD5C5C");
			but10.setStyle("-fx-background-color: #CD5C5C");
			but20.setStyle("-fx-background-color: #CD5C5C");

			ObservableList<Node> children = gridpane.getChildren();
			for (Node child : children) {
				if (child instanceof Button) {
					child.setDisable(true);
				}

			}

		} else if ((but01.getText().equals(this.adversaryMark)) && (but11.getText().equals(this.adversaryMark))
				&& (but21.getText().equals(this.adversaryMark))) {
			but01.setStyle("-fx-background-color: #CD5C5C");
			but11.setStyle("-fx-background-color: #CD5C5C");
			but21.setStyle("-fx-background-color: #CD5C5C");

			ObservableList<Node> children = gridpane.getChildren();
			for (Node child : children) {
				if (child instanceof Button) {
					child.setDisable(true);
				}

			}

		} else if ((but02.getText().equals(this.adversaryMark)) && (but12.getText().equals(this.adversaryMark))
				&& (but22.getText().equals(this.adversaryMark))) {
			but02.setStyle("-fx-background-color: #CD5C5C");
			but12.setStyle("-fx-background-color: #CD5C5C");
			but22.setStyle("-fx-background-color: #CD5C5C");

			ObservableList<Node> children = gridpane.getChildren();
			for (Node child : children) {
				if (child instanceof Button) {
					child.setDisable(true);
				}

			}

		} else if ((but00.getText().equals(this.adversaryMark)) && (but11.getText().equals(this.adversaryMark))
				&& (but22.getText().equals(this.adversaryMark))) {
			but00.setStyle("-fx-background-color: #CD5C5C");
			but11.setStyle("-fx-background-color: #CD5C5C");
			but22.setStyle("-fx-background-color: #CD5C5C");

			ObservableList<Node> children = gridpane.getChildren();
			for (Node child : children) {
				if (child instanceof Button) {
					child.setDisable(true);
				}

			}

		} else if ((but02.getText().equals(this.adversaryMark)) && (but11.getText().equals(this.adversaryMark))
				&& (but20.getText().equals(this.adversaryMark))) {
			but02.setStyle("-fx-background-color: #CD5C5C");
			but11.setStyle("-fx-background-color: #CD5C5C");
			but20.setStyle("-fx-background-color: #CD5C5C");

			ObservableList<Node> children = gridpane.getChildren();
			for (Node child : children) {
				if (child instanceof Button) {
					child.setDisable(true);
				}

			}

		}

	}

	public static void main(String[] args) {
		Application.launch(args);

	}
}