package com.draglantix.states;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.draglantix.assets.Assets;
import com.draglantix.assets.PlayAssets;
import com.draglantix.engine.Engine;
import com.draglantix.entities.Entity;
import com.draglantix.foregrounds.Foreground;
import com.draglantix.guis.Gui;
import com.draglantix.renderEngine.objects.Objects;
import com.draglantix.renderEngine.window.Window;
import com.draglantix.renderEngine.window.WindowHandler;

public class GameStateManager {

	private Assets assets;

	private State currentState;
	private Window window;

	private GameState currentStateClass;
	
	private MenuState menuState;
	private PlayState playState;
	
	private List<Class<? extends Objects>> menuActiveClasses = new ArrayList<Class<? extends Objects>>(
			Arrays.asList(Gui.class));
	private List<Class<? extends Objects>> playActiveClasses = new ArrayList<Class<? extends Objects>>(
			Arrays.asList(Entity.class, Foreground.class, Gui.class));

	public GameStateManager(State startState, Window window) {
		currentState = startState;
		this.window = window;

		assets = new Assets();

		new Engine(assets);

		menuState = new MenuState(this, menuActiveClasses);
		playState = new PlayState(this, playActiveClasses);

		setState(currentState);
	}

	public void update() {
		WindowHandler.handle(window, PlayAssets.camera);
		currentStateClass.tick();
		currentStateClass.render();
	}

	public void setState(State state) {
		if(currentStateClass != null && currentState != null) {
			currentStateClass.unload(currentState);
		}

		currentState = state;

		switch(currentState) {
		case PLAY:
			currentStateClass = playState;
			break;
		default:
			currentStateClass = menuState;
			break;
		}

		currentStateClass.load(currentState);
	}

	public State getState() {
		return currentState;
	}

	public Window getWindow() {
		return window;
	}

	public Assets getAssets() {
		return assets;
	}

}
