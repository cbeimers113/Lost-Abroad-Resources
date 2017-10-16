package launcher;

import engine.GameEngine;
import engine.Main;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import level.editor.Editor;

public class Launcher extends Application {

	public static String lang;

	private static boolean noUpdate;

	public static final String[] supportedLanguages = new String[] {
			"English", "Esperanto", "Frisian"
	};

	public static void begin(boolean noUpdate) {
		Launcher.noUpdate = noUpdate;
		launch();
	}

	public void start(Stage primaryStage) throws Exception {
		Pane pane = new Pane();
		TextField userName = new TextField();
		Button startButton = new Button("Start");
		Button exitButton = new Button("Close");
		Button editorLaunch = new Button("Level Editor");
		Button forceUpdate = new Button("Force Update");
		Label langLabel = new Label("Language:");
		Label credits = new Label("Created by Chris Beimers for Carleton University");
		ListView<String> languages = new ListView<String>();

		userName.relocate(10, 300);
		userName.setPrefSize(380, 20);

		startButton.relocate(10, 340);
		startButton.setPrefSize(122, 20);

		editorLaunch.relocate(139, 340);
		editorLaunch.setPrefSize(122, 20);

		exitButton.relocate(269, 340);
		exitButton.setPrefSize(122, 20);

		langLabel.relocate(10, 380);
		credits.relocate(40, 190);

		forceUpdate.relocate(269, 260);
		forceUpdate.setPrefSize(122, 20);

		languages.relocate(100, 380);
		languages.setPrefSize(290, 210);

		userName.setText(System.getProperty("user.name"));

		languages.setItems(FXCollections.observableArrayList(supportedLanguages));
		languages.getSelectionModel().select(0);

		pane.getChildren().addAll(userName, startButton, editorLaunch, exitButton, langLabel, languages, credits, forceUpdate);

		Scene scene = new Scene(pane, 400, 600);

		primaryStage.setTitle(GameEngine.TITLE + " Launcher");
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();

		startButton.setOnAction(e -> {
			primaryStage.hide();
			lang = languages.getSelectionModel().getSelectedItem();
			Main.game = new GameEngine(userName.getText().trim());
		});

		exitButton.setOnAction(e -> {
			System.exit(0);
		});

		editorLaunch.setOnAction(e -> {
			lang = languages.getSelectionModel().getSelectedItem();
			primaryStage.hide();
			new Editor();
		});

		forceUpdate.setOnAction(e -> {
			ResourcesDownloader.getFiles();
		});

		userName.setOnAction(startButton.getOnAction());
		lang = supportedLanguages[0];

		ResourcesDownloader.init();

		if (!noUpdate && ResourcesDownloader.needsUpdate() && ResourcesDownloader.getFiles() == 1) System.exit(1);
	}
}
