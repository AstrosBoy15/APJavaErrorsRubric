package com.draglantix.main;

import com.draglantix.engine.Engine;
import com.draglantix.renderEngine.audio.AudioMaster;
import com.draglantix.renderEngine.engine.FPSHandler;
import com.draglantix.renderEngine.window.Window;
import com.draglantix.states.GameStateManager;
import com.draglantix.states.State;

public class Main {

	private Window window;
	public static GameStateManager gsm;
	private FPSHandler fpsHandler;

	public Main() {
		init();
		run();
	}

	private void init() {
		window = new Window(Configs.WIDTH, Configs.HEIGHT, Configs.TITLE, false);
		AudioMaster.init();
		gsm = new GameStateManager(State.INTRO, window);
		fpsHandler = new FPSHandler(Configs.PRINT_FPS);
	}

	private void run() {
		while(!window.shouldClose()) {
			fpsHandler.sync(Configs.FPS_CAP);
			gsm.update();

		}
		cleanUp();
	}
	
	private void cleanUp() {
		Window.cleanUp();
		Engine.cleanUp();
		gsm.getAssets().graphics.cleanUp();
		AudioMaster.cleanUp();
	}

	public static void main(String[] args) {
		new Main();
	}
}
