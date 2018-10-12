package com.draglantix.guis;

import org.joml.Vector2f;
import org.joml.Vector4f;

import com.draglantix.renderEngine.objects.Objects;

public class Gui extends Objects {

	public Gui(int texture, Vector2f position, Vector2f rotation, Vector2f scale, Vector4f color) {
		super(texture, position, rotation, scale, color, false);
	}

	@Override
	public void tick() {
	
	}
}
