package graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {

	public static final SpriteSheet terrain = new SpriteSheet("/textures/terrain.png");
	public static final SpriteSheet player1 = new SpriteSheet("/textures/player1.png");
	public static final SpriteSheet uiElements = new SpriteSheet("/textures/uiElements.png");

	public int width;
	public int height;
	public int[] pixels;

	public SpriteSheet(String path) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(SpriteSheet.class.getResource(path));
		} catch (IOException e) {
			System.err.println("This spritesheet doesn't exist: \"" + path + "\"\nShutting down.");
			System.exit(1);
		}
		width = img.getWidth();
		height = img.getHeight();
		pixels = new int[width * height];
		for (int y = 0; y < height; y++)
			for (int x = 0; x < width; x++)
				pixels[x + y * width] = img.getRGB(x, y);
	}
}
