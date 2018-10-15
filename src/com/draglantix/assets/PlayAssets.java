package com.draglantix.assets;

import org.joml.Vector2f;
import org.joml.Vector4f;

import com.draglantix.engine.Camera;
import com.draglantix.entities.Player;
import com.draglantix.main.Configs;
import com.draglantix.renderEngine.models.SpriteSheet;
import com.draglantix.renderEngine.models.Texture;
import com.draglantix.world.World;

public class PlayAssets {

	public static Camera camera = null;

	public static Player player;

	public static SpriteSheet blackboard, table, window, objects;

	public static Texture playerTex;

	public static World world;

	public static void load(Assets assets) {

		playerTex = new Texture("character/idle");

		blackboard = new SpriteSheet("Blackboard");
		table = new SpriteSheet("Table");
		window = new SpriteSheet("Window");
		objects = new SpriteSheet("ScienceObjects");

		player = new Player(playerTex.getTextureID(), new Vector2f(0, 0), new Vector2f(0, 0), new Vector2f(128, 128),
				new Vector4f(1, 1, 1, 1), 10);

		camera = new Camera(
				new Vector2f(player.getPosition().x, player.getPosition().y + Configs.HEIGHT / 2 - player.getScale().y),
				0, 0, 0.07f, player);
		assets.graphics.setCurrentCamera(camera);

		world = new World();
	}

	public static void unload() {

	}
}
