package com.tetris.main.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.tetris.main.Main;
import com.tetris.map.MapGrid;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = MapGrid.MAP_WIDTH;
		config.height = MapGrid.MAP_HEIGHT;
		new LwjglApplication(new Main(), config);
	}
}
