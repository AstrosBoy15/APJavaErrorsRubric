package com.draglantix.assets;

import org.joml.Vector2f;
import org.joml.Vector4f;

import com.draglantix.renderEngine.audio.AudioMaster;
import com.draglantix.renderEngine.audio.Source;
import com.draglantix.renderEngine.font.Message;

public class IntroAssets {
	
	public static Assets assets;

	public static Message create, names;

	public static void load(Assets assets) {
		IntroAssets.assets = assets;

		int buffer = AudioMaster.loadSound("circuitous_tune.wav");
		Source source = new Source(1.5f, 1000);
		source.setLooping(true);
		source.play(buffer);
		source.setPosition(64, 64, 0);
		AudioMaster.sources.add(source);
		
		create = new Message("Created By", new Vector2f(0, 100), new Vector2f(0, 0), new Vector2f(10, 10),
			new Vector4f(1, 0.5f, 0, 0), false, assets.graphics);
		names = new Message("-Alex, Aidan, and Andrew-", new Vector2f(0, 50), new Vector2f(0, 0), new Vector2f(10, 10),
				new Vector4f(0.5f, 0, 1, 0), false, assets.graphics);
		addObjects();
	}

	public static void addObjects() {
	}

	public static void unload() {
	}

}
