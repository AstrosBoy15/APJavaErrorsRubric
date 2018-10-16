package com.draglantix.entities;

import org.joml.Vector2f;
import org.joml.Vector4f;
import org.lwjgl.glfw.GLFW;

import com.draglantix.assets.PlayAssets;
import com.draglantix.renderEngine.models.Animation;
import com.draglantix.renderEngine.window.Window;

public class Player extends Entity {

	private Animation animation;

	private float speed;

	private Vector2f currentSpeed = new Vector2f();

	public Player(int texture, Vector2f position, Vector2f rotation, Vector2f scale, Vector4f color, float speed) {
		super(texture, position, rotation, scale, color);
		animation = new Animation(12, 12, "character/Walking", true);
		this.speed = speed;
	}

	@Override
	public void tick() {
		super.tick();
		movePlayer();
	}

	private void movePlayer() {

		if(Window.getInput().isKeyDown(GLFW.GLFW_KEY_A) && position.x > -460) {
			currentSpeed.x -= speed;
		}
		if(Window.getInput().isKeyDown(GLFW.GLFW_KEY_D) && position.x < 487 * 11 * 2 - 10) {
			currentSpeed.x += speed;
		}

		move(currentSpeed);

		if(Window.getInput().isKeyDown(GLFW.GLFW_KEY_A) && !Window.getInput().isKeyDown(GLFW.GLFW_KEY_D)
				|| !Window.getInput().isKeyDown(GLFW.GLFW_KEY_A) && Window.getInput().isKeyDown(GLFW.GLFW_KEY_D)) {
			setTexture(animation.getTexture().getTextureID());
			flip(-currentSpeed.x);
		} else {
			setTexture(PlayAssets.playerTex.getTextureID());
		}
		currentSpeed = new Vector2f(0, 0);
	}

}
