package com.draglantix.assets;

import org.joml.Vector2f;
import org.joml.Vector4f;

import com.draglantix.renderEngine.font.Message;

public class MenuAssets {

	public static Assets assets;
	
	public static Message title, start;

	public static void load(Assets assets) {
		MenuAssets.assets = assets;
		
		title = new Message("AP Java Errors Rubric", new Vector2f(0, 100), new Vector2f(0, 0),
				new Vector2f(10, 10), new Vector4f(1, 0, 1, 1), false, assets.graphics);
		start = new Message("Start", new Vector2f(0, 30), new Vector2f(0, 0), new Vector2f(10, 10),
				new Vector4f(1, 1, 1, 1), false, assets.graphics);
		addObjects();
	}

	public static void addObjects() {
		assets.messages.add(title);
		assets.messages.add(start);
	}

	public static void unload() {
		assets.messages.remove(title);
		title = null;
		assets.messages.remove(start);
		start = null;
	}

}
