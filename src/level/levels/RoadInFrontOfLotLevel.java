package level.levels;

import java.awt.Color;
import java.awt.Point;

import engine.TextIO;
import graphics.Sprite;
import level.Level;

public class RoadInFrontOfLotLevel extends Level {

	public RoadInFrontOfLotLevel() {
		super("/levels/roadInFrontOfLot.png", new Sprite(TextIO.load("roadInFrontOfLot"), Color.yellow, Color.gray, 10), null, null, new Point(27, 1));
	}
}
