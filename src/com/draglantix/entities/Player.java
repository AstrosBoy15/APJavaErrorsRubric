package com.draglantix.entities;

import org.joml.Vector2f;
import org.joml.Vector4f;
import org.lwjgl.glfw.GLFW;

import com.draglantix.assets.PlayAssets;
import com.draglantix.renderEngine.models.Animation;
import com.draglantix.renderEngine.window.Window;

public class Player extends Entity {
	
	private Animation animation;
	
	public Player(int texture, Vector2f position, Vector2f rotation, Vector2f scale, Vector4f color) {
		super(texture, position, rotation, scale, color);
		animation = new Animation(12, 12, "character/Walking");
	}

	@Override
	public void tick() {
		super.tick();
		movePlayer();
	}

	private void movePlayer() {

		if(Window.getInput().isKeyDown(GLFW.GLFW_KEY_A) && !Window.getInput().isKeyDown(GLFW.GLFW_KEY_D)
				|| !Window.getInput().isKeyDown(GLFW.GLFW_KEY_A) && Window.getInput().isKeyDown(GLFW.GLFW_KEY_D)) {
			setTexture(animation.getTexture().getTextureID());
			//flip(currentSpeed.x);
		} else {
			setTexture(PlayAssets.playerTex.getTextureID());
		}
	}

}
