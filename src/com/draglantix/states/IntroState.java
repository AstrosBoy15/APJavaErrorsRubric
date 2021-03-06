package com.draglantix.states;

import java.util.List;

import com.draglantix.assets.IntroAssets;
import com.draglantix.engine.Engine;
import com.draglantix.renderEngine.objects.Objects;

public class IntroState extends GameState {

	private float alpha;
	private boolean increase, changeState;

	public IntroState(GameStateManager gsm, List<Class<? extends Objects>> activeClasses) {
		super(gsm, activeClasses);
	}

	@Override
	protected void load(State state) {
		super.load(state);

		System.out.println("Intro init");
		IntroAssets.assets.messages.add(IntroAssets.create);
		IntroAssets.assets.messages.add(IntroAssets.names);
		alpha = 0;
		increase = true;
		changeState = false;
	}

	@Override
	protected void tick() {
		Engine.tickState(activeClasses);
		if(changeState) {
			gsm.setState(State.MENU);
		}

		if(increase) {
			alpha += 0.01f;
		} else {
			alpha -= 0.01f;
		}

		if(alpha >= 1) {
			alpha = 1;
			increase = false;
		}

		if(alpha <= 0) {
			alpha = 0;
			if(!increase) {
				changeState = true;
			}
			increase = true;
		}
		IntroAssets.create.setA(alpha);
		IntroAssets.names.setA(alpha);
	}

	protected void renderScene() {
		Engine.renderState(activeClasses);
	}

	protected void unload() {
		IntroAssets.unload();
	}

}
