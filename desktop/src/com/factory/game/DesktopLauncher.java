package com.factory.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.factory.game.MyGame;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		//config.title = "Drop";	// Задаем название окну игры
		//config.width = 800;	// Задаем размеры окна
		//config.height = 480;	// Вообще, в конфигурации есть ещё полезные вещи, но о них не в этот раз
		new Lwjgl3Application(new MyGame(), config);
	}
}
