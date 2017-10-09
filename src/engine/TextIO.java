package engine;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import launcher.Launcher;

public class TextIO {

	public static String addSpacesAtCapitals(String s) {
		String caps = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String r = "";
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (caps.contains(c + "")) r += " ";
			r += c;
		}
		return r.trim();
	}

	private static String pixelToString(int col) {
		Color c = new Color(col);
		return ("" + (char) c.getRed() + (char) c.getGreen() + (char) c.getBlue()).replaceAll("ÿ", "\n");
	}

	public static String load(String fileName) {
		String s = "";
		try {
			BufferedImage img = ImageIO.read(TextIO.class.getResource("/text/" + Launcher.lang + "/" + fileName + ".png"));
			for (int y = 0; y < img.getHeight(); y++)
				for (int x = 0; x < img.getWidth(); x++)
					s += pixelToString(img.getRGB(x, y));
		} catch (IOException | IllegalArgumentException e) {
			System.err.println("There was no file \"" + fileName + "\" found for " + Launcher.lang);
			s = "Read Error";
		}
		return s.trim();
	}
}
