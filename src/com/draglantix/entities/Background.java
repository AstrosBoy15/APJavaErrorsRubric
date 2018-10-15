package com.draglantix.entities;

import org.joml.Vector2f;
import org.joml.Vector4f;

import com.draglantix.assets.PlayAssets;

public class Background extends Entity {

	private float paralax;

	protected Vector2f relitivePos;
	
	protected Vector2f offset;
	
	public Background(int texture, Vector2f position, Vector2f rotation, Vector2f scale, Vector4f color, float paralax) {
		super(texture, position, rotation, scale, color);
		this.paralax = paralax;
		this.relitivePos = position;
	}

	@Override
	public void tick() {
		Vector2f cam = new Vector2f(PlayAssets.camera.getPosition());
		offset = cam.mul(paralax);
		position = offset;
		position.add(relitivePos);
	}

}
