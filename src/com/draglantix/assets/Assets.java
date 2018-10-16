package com.draglantix.assets;


import java.util.ArrayList;
import java.util.List;

import com.draglantix.renderEngine.font.Font;
import com.draglantix.renderEngine.font.Message;
import com.draglantix.renderEngine.graphics.Graphics;
import com.draglantix.renderEngine.models.SpriteSheet;
import com.draglantix.states.State;

public class Assets {
	
	private SpriteSheet fontTex;
	public Font font;
	
	public Graphics graphics;
	
	public List<Message> messages;
	
	public Assets() {
		messages = new ArrayList<Message>();
		graphics = new Graphics();
		
		fontTex = new SpriteSheet("font");
		font = new Font(fontTex, 32);
		graphics.setFont(font);
		
	}
	
	public void load(State state) {
		switch(state) {
		case PLAY:
			PlayAssets.load(this);
			break;
		case INTRO:
			IntroAssets.load(this);
		default:
			MenuAssets.load(this);
			break;
		}
		
	}
	
	public void unload(State state) {
		switch(state) {
		case PLAY:
			PlayAssets.unload();
			break;
		default:
			MenuAssets.unload();
			break;
		}
	}
}
