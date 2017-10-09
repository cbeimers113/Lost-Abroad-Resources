package event;

import engine.Main;

public interface Event {

	public static final Event defaultEvent = new Event() {

		public void occur() {
			Main.game.popup.push("...");
		}
	};

	public static final Event emptyEvent = new Event() {

		public void occur() {
			Main.game.popup.push("Empty Event");
		}
	};

	public void occur();
}
