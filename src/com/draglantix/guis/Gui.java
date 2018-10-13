package com.draglantix.guis;

import org.joml.Vector2f;
import org.joml.Vector4f;

import com.draglantix.renderEngine.models.Animation;
import com.draglantix.renderEngine.objects.Objects;

public class Gui extends Objects {

	private Animation anim;
	
	public Gui(int texture, Vector2f position, Vector2f rotation, Vector2f scale, Vector4f color) {
		super(texture, position, rotation, scale, color, false);
	}
	

	public Gui(Animation anim, Vector2f position, Vector2f rotation, Vector2f scale, Vector4f color) {
		super(null, position, rotation, scale, color, false);
		this.anim = anim;
	}

	@Override
	public void tick() {
		if(anim != null) {
			setTexture(anim.getTexture().getTextureID());
		}
	}
}
