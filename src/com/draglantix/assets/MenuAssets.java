package com.draglantix.assets;

import org.joml.Vector2f;
import org.joml.Vector4f;

import com.draglantix.engine.Engine;
import com.draglantix.guis.Gui;
import com.draglantix.main.Configs;
import com.draglantix.renderEngine.font.Message;
import com.draglantix.renderEngine.models.Animation;
import com.draglantix.renderEngine.models.SpriteSheet;
import com.draglantix.util.FileReader;

public class MenuAssets {

	public static Assets assets;

	public static Message start, java;

	public static SpriteSheet title;
	public static Animation titleAnim;
	public static Gui titleGUI;
	public static Gui black;

	public static void load(Assets assets) {

		MenuAssets.assets = assets;

		title = new SpriteSheet(FileReader.loadImage("title"));
		titleAnim = new Animation(3, 3, 64, 20, title, false);

		titleGUI = new Gui(titleAnim, new Vector2f(0, 0), new Vector2f(0, 0), new Vector2f(128, 128),
				new Vector4f(1, 1, 1, 1));

		black = new Gui(-1, new Vector2f(0, 0), new Vector2f(0, 0),
				new Vector2f(Configs.WIDTH, Configs.HEIGHT), new Vector4f(0, 0, 0, 0));

		start = new Message("-Press Space-", new Vector2f(0, -100), new Vector2f(0, 0), new Vector2f(10, 10),
				new Vector4f(1, 1, 1, 0), false, assets.graphics);

		java = new Message("Made with JAVA!", new Vector2f(250, 0), new Vector2f(45, 0), new Vector2f(6, 6),
				new Vector4f(1f, 0, 1f, 0), false, assets.graphics);

		addObjects();
	}

	public static void addObjects() {
		Engine.addObject(Gui.class, titleGUI);
		Engine.addObject(Gui.class, black);
	}

	public static void unload() {
		title = null;
		titleAnim = null;
		titleGUI = null;
		black = null;
		assets.messages.remove(start);
		assets.messages.remove(java);
		start = null;
	}

}
