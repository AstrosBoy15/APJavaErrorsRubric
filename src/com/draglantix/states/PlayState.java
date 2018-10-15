package com.draglantix.states;

import java.util.List;

import org.lwjgl.opengl.GL11;

import com.draglantix.assets.PlayAssets;
import com.draglantix.engine.Engine;
import com.draglantix.renderEngine.objects.Objects;

public class PlayState extends GameState{
	
	public PlayState(GameStateManager gsm, List<Class<? extends Objects>> activeClasses) {
		super(gsm, activeClasses);
	}

	@Override
	protected void load(State state) {
		super.load(state);
		PlayAssets.world.init();
		System.out.println("Play init");
	}
	
	@Override
	protected void tick() {
		Engine.tickState(activeClasses);
	}
	
	protected void renderScene() {
		GL11.glClearColor(215/256f, 217/256f, 207/256f, 1);
		Engine.renderState(activeClasses);
	}
	
	protected void unload() {
		
	}

}
