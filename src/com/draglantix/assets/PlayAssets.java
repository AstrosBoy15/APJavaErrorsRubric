package com.draglantix.assets;

import java.util.ArrayList;
import java.util.List;

import org.joml.Vector2f;
import org.joml.Vector4f;

import com.draglantix.engine.Camera;
import com.draglantix.engine.Engine;
import com.draglantix.entities.Entity;
import com.draglantix.entities.Player;
import com.draglantix.renderEngine.font.Message;
import com.draglantix.renderEngine.models.Texture;

public class PlayAssets {

	public static Camera camera = null;

	public static Player player;
	
	public static Texture playerTex;

	public static List<Message> messages;

	public static void load(Assets assets) {
		messages = new ArrayList<Message>();
		
		playerTex = new Texture("character/idle");
		
		player = new Player(playerTex.getTextureID(), new Vector2f(0, 0), new Vector2f(0, 0), new Vector2f(96, 96), new Vector4f(1, 1, 1, 1));
		Engine.addObject(Entity.class, player);
		
		
		camera = new Camera(new Vector2f(0, 0), 0, 0, 0.007f, player);
		assets.graphics.setCurrentCamera(camera);
	}

	public static void unload() {

	}
}
