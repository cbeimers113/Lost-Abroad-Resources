package entity;

import graphics.Sprite;

public abstract class NPC extends Mob {

	public NPC(int x, int y, Sprite sprite, int speed, String name) {
		super(x, y, sprite, speed, name);
	}
}
