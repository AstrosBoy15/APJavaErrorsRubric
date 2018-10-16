package com.draglantix.states;

import java.util.List;

import org.lwjgl.glfw.GLFW;

import com.draglantix.assets.MenuAssets;
import com.draglantix.engine.Engine;
import com.draglantix.renderEngine.objects.Objects;
import com.draglantix.renderEngine.window.Window;

public class MenuState extends GameState{

	private boolean startAdded = false;
	private float alpha3;
	private boolean increase, changeState, shouldChange;
	
	public MenuState(GameStateManager gsm, List<Class<? extends Objects>> activeClasses) {
		super(gsm, activeClasses);
	}

	@Override
	protected void load(State state) {
		super.load(state);
		System.out.println("Menu init");
		alpha3 = 0;
		increase = true;
		changeState = false;
		shouldChange = false;
	}
	
	@Override
	protected void tick() {
		Engine.tickState(activeClasses);
		if(Window.getInput().isKeyPressed(GLFW.GLFW_KEY_SPACE)) {
			shouldChange = true;
		}else {
		
			if(MenuAssets.titleAnim.hasPlayed()) {
				if(!startAdded) {
					MenuAssets.assets.messages.add(MenuAssets.start);
					MenuAssets.assets.messages.add(MenuAssets.java);
					startAdded = true;
				}else {
					
					float alpha = MenuAssets.start.getColor().w;
					float alpha2 = MenuAssets.java.getColor().w;
					
					if(alpha < 1) {
						MenuAssets.start.setA(alpha + 0.005f);
					}
					
					if(alpha2 < 1) {
						MenuAssets.java.setA(alpha + 0.05f);
					}
				}
			}
		}
		if(shouldChange) {
			if(increase && !changeState) {
				alpha3 += 0.01f;
			} else {
				alpha3 -= 0.01f;
			}

			if(alpha3 >= 1) {
				alpha3 = 1;
				increase = false;
				changeState = true;
			}
			MenuAssets.black.setA(alpha3);
		}
		if(changeState) {
			gsm.setState(State.PLAY);
		}
	}
	
	protected void renderScene() {
		Engine.renderState(activeClasses);
	}
	
	protected void unload() {
		MenuAssets.unload();
	}

}
