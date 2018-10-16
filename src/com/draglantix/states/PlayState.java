package com.draglantix.states;

import java.util.List;

import org.lwjgl.opengl.GL11;

import com.draglantix.assets.PlayAssets;
import com.draglantix.engine.Engine;
import com.draglantix.engine.PhysicsEngine;
import com.draglantix.renderEngine.objects.Objects;

public class PlayState extends GameState {

	private float alpha;
	private boolean finished;

	public PlayState(GameStateManager gsm, List<Class<? extends Objects>> activeClasses) {
		super(gsm, activeClasses);
	}

	@Override
	protected void load(State state) {
		super.load(state);
		PlayAssets.world.init();
		System.out.println("Play init");
		alpha = 1;
		finished = false;
	}

	@Override
	protected void tick() {
		Engine.tickState(activeClasses);
		if(!finished) {
			alpha -= 0.01f;
		}

		if(alpha <= 0) {
			alpha = 0;
			finished = true;
		}
		PlayAssets.black.setA(alpha);
		
		PhysicsEngine.rotate(PlayAssets.sheep, 10);
	}

	protected void renderScene() {
		GL11.glClearColor(215 / 256f, 217 / 256f, 207 / 256f, 1);
		Engine.renderState(activeClasses);
	}

	protected void unload() {

	}

}
