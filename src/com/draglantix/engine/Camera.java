package com.draglantix.engine;

import org.joml.Matrix4f;
import org.joml.Vector2f;

import com.draglantix.entities.Player;
import com.draglantix.main.Configs;
import com.draglantix.renderEngine.engine.ICamera;

public class Camera implements ICamera {

	private Vector2f position;
	private float roll, lerp, zoom;
	
	private Player player;

	public Camera(Vector2f position, float roll, float zoom, float lerp, Player player) {
		this.position = position;
		this.roll = roll;
		this.zoom = zoom;
		this.lerp = lerp;
		this.player = player;
	}
	
	@Override
	public void update() {
		move();
	}

	public void move() {
		position.lerp(new Vector2f(player.getPosition().x, player.getPosition().y + Configs.HEIGHT/2 - player.getScale().y), lerp);
	}
	
	@Override
	public Matrix4f createViewMatrix() {
		Matrix4f view = new Matrix4f();
		view.scale((float) Math.exp(zoom));
		view.rotate((float) (Math.toRadians(roll)), 0, 0, 1);
		view.translate(-position.x, -position.y, 0);
		return view;
	}

	@Override
	public Vector2f getPosition() {
		return position;
	}

	@Override
	public float getZoom() {
		return (float) Math.exp(zoom);
	}

}