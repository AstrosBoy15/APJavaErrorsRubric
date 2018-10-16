package com.draglantix.assets;

import org.joml.Vector2f;
import org.joml.Vector4f;

import com.draglantix.engine.Camera;
import com.draglantix.engine.Engine;
import com.draglantix.entities.Player;
import com.draglantix.guis.Gui;
import com.draglantix.main.Configs;
import com.draglantix.renderEngine.models.SpriteSheet;
import com.draglantix.renderEngine.models.Texture;
import com.draglantix.util.FileReader;
import com.draglantix.world.World;

public class PlayAssets {

	public static Assets assets;

	public static Camera camera = null;

	public static Player player;

	public static SpriteSheet objects;

	public static Texture playerTex, wallTex, tableTex, skyTex, mntTex;

	public static Texture tex9, tex8, tex7, tex6, tex5, tex4, tex3, tex2, tex1, tex0, tex_;

	public static Gui black;
	
	public static World world;

	public static void load(Assets assets) {

		PlayAssets.assets = assets;

		playerTex = new Texture(FileReader.loadImage("character/idle"));
		wallTex = new Texture(FileReader.loadImage("wall"));
		tableTex = new Texture(FileReader.loadImage("table"));
		skyTex = new Texture(FileReader.loadImage("sky"));
		mntTex = new Texture(FileReader.loadImage("mountains"));

		tex9 = new Texture(FileReader.loadImage("9"));
		tex8 = new Texture(FileReader.loadImage("8"));
		tex7 = new Texture(FileReader.loadImage("7"));
		tex6 = new Texture(FileReader.loadImage("6"));
		tex5 = new Texture(FileReader.loadImage("5"));
		tex4 = new Texture(FileReader.loadImage("4"));
		tex3 = new Texture(FileReader.loadImage("3"));
		tex2 = new Texture(FileReader.loadImage("2"));
		tex1 = new Texture(FileReader.loadImage("1"));
		tex0 = new Texture(FileReader.loadImage("0"));
		tex_ = new Texture(FileReader.loadImage("na"));

		objects = new SpriteSheet(FileReader.loadImage("ScienceObjects"));

		player = new Player(playerTex.getTextureID(), new Vector2f(-110, 0), new Vector2f(0, 0), new Vector2f(128, 128),
				new Vector4f(1, 1, 1, 1), 10);

		black = new Gui(-1, new Vector2f(0, 0), new Vector2f(0, 0),
				new Vector2f(Configs.WIDTH, Configs.HEIGHT), new Vector4f(0, 0, 0, 1));

		camera = new Camera(
				new Vector2f(player.getPosition().x, player.getPosition().y + Configs.HEIGHT / 2 - player.getScale().y),
				0, 0, 0.07f, player);
		assets.graphics.setCurrentCamera(camera);

		world = new World();
		addObjects();
	}
	
	public static void addObjects() {
		Engine.addObject(Gui.class, black);
	}

	public static void unload() {
		
	}
}
