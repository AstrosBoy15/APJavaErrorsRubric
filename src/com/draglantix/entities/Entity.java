package com.draglantix.entities;

import org.joml.Vector2f;
import org.joml.Vector4f;

import com.draglantix.engine.PhysicsEngine;
import com.draglantix.renderEngine.objects.Objects;

public abstract class Entity extends Objects {
	private float lastDirX = -1;

	public Entity(int texture, Vector2f position, Vector2f rotation, Vector2f scale, Vector4f color) {
		super(texture, position, rotation, scale, color, true);
		this.scale = scale;
	}

	public Entity(int texture, Vector2f position, Vector2f rotation, Vector2f scale, Vector4f[] colors) {
		super(texture, position, rotation, scale, colors, true);
		this.scale = new Vector2f(scale);
	}

	@Override
	public void tick() {
		//move();
	}

	private void move(Vector2f dir) {
		PhysicsEngine.move(dir, this);
	}

	protected void flip(float dirX) {
		float facing;
		if(dirX == 0) {
			facing = 0;
		} else {
			facing = dirX / Math.abs(dirX);
		}
		if(lastDirX != facing && facing != 0) {
			PhysicsEngine.flip(this);
			lastDirX = facing;
		}

	}

}
