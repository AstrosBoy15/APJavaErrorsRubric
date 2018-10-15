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

	public static Assets assets;
	
	public static Camera camera = null;

	public static Player player;

	public static SpriteSheet objects;

	public static Texture playerTex, wallTex, tableTex;
	
	public static Texture tex9, tex8, tex7, tex6, tex5, tex4, tex3, tex2, tex1, tex0, tex_;

	public static World world;
	
	public static void load(Assets assets) {
		
		PlayAssets.assets = assets;
		
		playerTex = new Texture("character/idle");
		wallTex = new Texture("wall");
		tableTex = new Texture("table");
		
		tex9 = new Texture("9");
		tex8 = new Texture("8");
		tex7 = new Texture("7");
		tex6 = new Texture("6");
		tex5 = new Texture("5");
		tex4 = new Texture("4");
		tex3 = new Texture("3");
		tex2 = new Texture("2");
		tex1 = new Texture("1");
		tex0 = new Texture("0");
		tex_ = new Texture("na");
		
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
