package com.draglantix.states;

import java.util.List;

import com.draglantix.engine.Engine;
import com.draglantix.renderEngine.objects.Objects;

public class PlayState extends GameState{
	
	public PlayState(GameStateManager gsm, List<Class<? extends Objects>> activeClasses) {
		super(gsm, activeClasses);
	}

	@Override
	protected void load(State state) {
		super.load(state);
		System.out.println("Play init");
	}
	
	@Override
	protected void tick() {
		Engine.tickState(activeClasses);
	}
	
	protected void renderScene() {
		Engine.renderState(activeClasses);
	}
	
	protected void unload() {
		
	}

}
