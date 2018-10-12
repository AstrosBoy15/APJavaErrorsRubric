package com.draglantix.assets;

import java.util.ArrayList;
import java.util.List;

import org.joml.Vector2f;

import com.draglantix.engine.Camera;
import com.draglantix.renderEngine.font.Message;

public class PlayAssets {

	public static Camera camera = null;

	public static List<Message> messages;

	public static void load(Assets assets) {
		messages = new ArrayList<Message>();
		
		camera = new Camera(new Vector2f(0, 0), 0, 0);
		assets.graphics.setCurrentCamera(camera);
	}

	public static void unload() {

	}
}
