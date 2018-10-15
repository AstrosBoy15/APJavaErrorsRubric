package com.draglantix.entities;

import org.joml.Vector2f;
import org.joml.Vector4f;

public class General extends Entity {
	
	public General(int texture, Vector2f position, Vector2f rotation, Vector2f scale, Vector4f color) {
		super(texture, position, rotation, scale, color);
	}
	
	public General(General g, Vector2f position) {
		super(g, position);
	}

	@Override
	public void tick() {
		super.tick();
	}	

}
