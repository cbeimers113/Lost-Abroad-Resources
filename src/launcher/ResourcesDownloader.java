package launcher;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ResourcesDownloader {

	public static final String resPath = System.getProperty("user.home") + "/LostAbroad/res/";

	public static final HashMap<String, URL> files = new HashMap<String, URL>();

	public static boolean downloading;

	public static void init() throws MalformedURLException {
		// Textures
		files.put("textures/terrain.png", new URL("https://github.com/daveyognaught/LLRR-Game/raw/master/res/textures/terrain.png"));
		files.put("textures/uiElements.png", new URL("https://github.com/daveyognaught/LLRR-Game/raw/master/res/textures/uiElements.png"));
		files.put("textures/player1.png", new URL("https://github.com/daveyognaught/LLRR-Game/raw/master/res/textures/player1.png"));

		// Levels
		files.put("levels/emptyLot.png", new URL("https://github.com/daveyognaught/LLRR-Game/raw/master/res/levels/emptyLot.png"));
		files.put("levels/roadInFrontOfLot.png", new URL("https://github.com/daveyognaught/LLRR-Game/raw/master/res/levels/roadInFrontOfLot.png"));

		// Text

		// English
		files.put("text/English/emptyLot.header", new URL("https://github.com/daveyognaught/LLRR-Game/raw/master/res/text/English/emptyLot.header"));
		files.put("text/English/roadInFrontOfLot.header", new URL("https://github.com/daveyognaught/LLRR-Game/raw/master/res/text/English/roadInFrontOfLot.header"));

		// Esperanto
		files.put("text/Esperanto/emptyLot.header", new URL("https://github.com/daveyognaught/LLRR-Game/raw/master/res/text/Esperanto/emptyLot.header"));
		files.put("text/Esperanto/roadInFrontOfLot.header", new URL("https://github.com/daveyognaught/LLRR-Game/raw/master/res/text/Esperanto/roadInFrontOfLot.header"));
	}

	public static int getFiles() {
		downloading = true;
		for (String fileName : files.keySet())
			try {
				System.out.println("Getting file: \"" + fileName + "\"");
				download(fileName, files.get(fileName));
			} catch (IOException e) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error getting required resources!");
				alert.setHeaderText("There was an error downloading game resources!");
				alert.setContentText("Make sure you have a reliable internet connection and try again. If the problem persists, contact the developer at daveoverzero@gmail.com");
				alert.showAndWait();
				return 1;
			}
		System.out.println("Getting files done");
		downloading = false;
		return 0;
	}

	public static boolean needsUpdate() {
		for (String fileName : files.keySet()) {
			File file = new File(resPath + fileName);
			if (!file.exists()) return true;
		}
		return false;
	}

	public static void download(String fileName, URL url) throws MalformedURLException, IOException {
		File file = new File(resPath + fileName);
		if (file.getParentFile() != null) file.getParentFile().mkdirs();
		if (!file.exists()) file.createNewFile();
		FileUtils.copyURLToFile(url, file);
	}
}
