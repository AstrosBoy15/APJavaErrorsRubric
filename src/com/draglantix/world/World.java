package com.draglantix.world;

import org.joml.Vector2f;
import org.joml.Vector4f;

import com.draglantix.assets.PlayAssets;
import com.draglantix.engine.Engine;
import com.draglantix.engine.PhysicsEngine;
import com.draglantix.entities.Entity;
import com.draglantix.entities.General;
import com.draglantix.renderEngine.models.Texture;

public class World {

	public final int SCALE = 2;

	public void init() {
		
		//Blackboard
		General blackboardTopLeft = new General(
				new Texture(PlayAssets.blackboard.crop(new Vector2f(0, 0), new Vector2f(32, 32))).getTextureID(),
				new Vector2f(0, 320 * SCALE), new Vector2f(0, 0), new Vector2f(32 * SCALE), new Vector4f(1, 1, 1, 1));
		General blackboardTopMiddle = new General(
				new Texture(PlayAssets.blackboard.crop(new Vector2f(32, 0), new Vector2f(32, 32))).getTextureID(),
				new Vector2f(64 * SCALE, 320 * SCALE), new Vector2f(0, 0), new Vector2f(32 * SCALE),
				new Vector4f(1, 1, 1, 1));
		General blackboardTopRight = new General(
				new Texture(PlayAssets.blackboard.crop(new Vector2f(0, 0), new Vector2f(32, 32))).getTextureID(),
				new Vector2f(640 * SCALE, 320 * SCALE), new Vector2f(0, 0), new Vector2f(32 * SCALE),
				new Vector4f(1, 1, 1, 1));
		General blackboardRight = new General(
				new Texture(PlayAssets.blackboard.crop(new Vector2f(32, 0), new Vector2f(32, 32))).getTextureID(),
				new Vector2f(640 * SCALE, 128 * SCALE), new Vector2f(0, 0), new Vector2f(32 * SCALE),
				new Vector4f(1, 1, 1, 1));
		General blackboardLeft = new General(
				new Texture(PlayAssets.blackboard.crop(new Vector2f(32, 0), new Vector2f(32, 32))).getTextureID(),
				new Vector2f(0 * SCALE, 128 * SCALE), new Vector2f(0, 0), new Vector2f(32 * SCALE),
				new Vector4f(1, 1, 1, 1));
		General blackboardMiddle = new General(
				new Texture(PlayAssets.blackboard.crop(new Vector2f(64, 0), new Vector2f(32, 32))).getTextureID(),
				new Vector2f(64 * SCALE, 128 * SCALE), new Vector2f(0, 0), new Vector2f(32 * SCALE),
				new Vector4f(1, 1, 1, 1));
		General blackboardBottomLeft = new General(
				new Texture(PlayAssets.blackboard.crop(new Vector2f(0, 0), new Vector2f(32, 32))).getTextureID(),
				new Vector2f(0, 64 * SCALE), new Vector2f(0, 0), new Vector2f(32 * SCALE), new Vector4f(1, 1, 1, 1));
		General blackboardBottomMiddle = new General(
				new Texture(PlayAssets.blackboard.crop(new Vector2f(32, 0), new Vector2f(32, 32))).getTextureID(),
				new Vector2f(64 * SCALE, 64 * SCALE), new Vector2f(0, 0), new Vector2f(32 * SCALE),
				new Vector4f(1, 1, 1, 1));
		General blackboardBottomRight = new General(
				new Texture(PlayAssets.blackboard.crop(new Vector2f(0, 0), new Vector2f(32, 32))).getTextureID(),
				new Vector2f(640 * SCALE, 64 * SCALE), new Vector2f(0, 0), new Vector2f(32 * SCALE),
				new Vector4f(1, 1, 1, 1));
		PhysicsEngine.flip(blackboardTopRight);
		PhysicsEngine.rotate(blackboardBottomLeft, 90);
		PhysicsEngine.rotate(blackboardBottomRight, 180);
		PhysicsEngine.rotate(blackboardBottomMiddle, 180);
		PhysicsEngine.rotate(blackboardLeft, 90);
		PhysicsEngine.rotate(blackboardRight, 270);

		Engine.addObject(Entity.class, blackboardTopLeft);
		Engine.addObject(Entity.class, blackboardTopMiddle);
		Engine.addObject(Entity.class, blackboardTopRight);
		Engine.addObject(Entity.class, blackboardBottomLeft);
		Engine.addObject(Entity.class, blackboardBottomMiddle);
		Engine.addObject(Entity.class, blackboardBottomRight);
		Engine.addObject(Entity.class, blackboardRight);
		Engine.addObject(Entity.class, blackboardLeft);
		Engine.addObject(Entity.class, blackboardMiddle);

		for(int i = 2; i < 10; i++) {

			for(int j = 1; j <= 3; j++) {
				Engine.addObject(Entity.class,
						new General(blackboardMiddle, new Vector2f(64 * i * SCALE, 128 + 64 * j * SCALE)));
			}

			Engine.addObject(Entity.class, new General(blackboardTopMiddle, new Vector2f(64 * i * SCALE, 320 * SCALE)));
			Engine.addObject(Entity.class,
					new General(blackboardBottomMiddle, new Vector2f(64 * i * SCALE, 64 * SCALE)));
		}

		for(int j = 1; j < 3; j++) {
			Engine.addObject(Entity.class, new General(blackboardRight,
					new Vector2f(blackboardRight.getPosition().x, blackboardRight.getPosition().y + 64 * j * SCALE)));
			Engine.addObject(Entity.class, new General(blackboardLeft,
					new Vector2f(blackboardLeft.getPosition().x, blackboardLeft.getPosition().y + 64 * j * SCALE)));
			Engine.addObject(Entity.class, new General(blackboardMiddle,
					new Vector2f(blackboardMiddle.getPosition().x, blackboardMiddle.getPosition().y + 64 * j * SCALE)));
		}
		
		
		//Player
		Engine.addObject(Entity.class, PlayAssets.player);

		
		//Table
		General tableTopLeft = new General(
				new Texture(PlayAssets.table.crop(new Vector2f(32, 0), new Vector2f(32, 32))).getTextureID(),
				new Vector2f(0, 0), new Vector2f(0, 0), new Vector2f(32 * SCALE), new Vector4f(1, 1, 1, 1));
		General tableTopMiddle = new General(
				new Texture(PlayAssets.table.crop(new Vector2f(0, 0), new Vector2f(32, 32))).getTextureID(),
				new Vector2f(64 * SCALE, 0), new Vector2f(0, 0), new Vector2f(32 * SCALE), new Vector4f(1, 1, 1, 1));
		General tableTopRight = new General(
				new Texture(PlayAssets.table.crop(new Vector2f(32, 0), new Vector2f(32, 32))).getTextureID(),
				new Vector2f(64 * 32 * SCALE, 0), new Vector2f(0, 0), new Vector2f(32 * SCALE), new Vector4f(1, 1, 1, 1));
		General tableBottomLeft = new General(
				new Texture(PlayAssets.table.crop(new Vector2f(64, 0), new Vector2f(32, 32))).getTextureID(),
				new Vector2f(0, -64 * SCALE), new Vector2f(0, 0), new Vector2f(32 * SCALE), new Vector4f(1, 1, 1, 1));
		General tableBottomMiddle = new General(
				new Texture(PlayAssets.table.crop(new Vector2f(96, 0), new Vector2f(32, 32))).getTextureID(),
				new Vector2f(64 * SCALE, -64 * SCALE), new Vector2f(0, 0), new Vector2f(32 * SCALE),
				new Vector4f(1, 1, 1, 1));
		General tableBottomRight = new General(
				new Texture(PlayAssets.table.crop(new Vector2f(64, 0), new Vector2f(32, 32))).getTextureID(),
				new Vector2f(64 * 32 * SCALE, -64 * SCALE), new Vector2f(0, 0), new Vector2f(32 * SCALE),
				new Vector4f(1, 1, 1, 1));
		PhysicsEngine.flip(tableTopRight);
		PhysicsEngine.flip(tableBottomRight);

		Engine.addObject(Entity.class, tableTopLeft);
		Engine.addObject(Entity.class, tableTopMiddle);
		Engine.addObject(Entity.class, tableTopRight);
		Engine.addObject(Entity.class, tableBottomLeft);
		Engine.addObject(Entity.class, tableBottomMiddle);
		Engine.addObject(Entity.class, tableBottomRight);

		for(int i = 2; i < 32; i++) {
			Engine.addObject(Entity.class, new General(tableTopMiddle, new Vector2f(64 * i * SCALE, 0)));
			Engine.addObject(Entity.class, new General(tableBottomMiddle, new Vector2f(64 * i * SCALE, -64 * SCALE)));
		}

		
		//Science Objects
		General beakerR = new General(
				new Texture(PlayAssets.objects.crop(new Vector2f(0, 0), new Vector2f(16, 16))).getTextureID(),
				new Vector2f(0 * SCALE, 16 * SCALE), new Vector2f(0, 0), new Vector2f(16 * SCALE),
				new Vector4f(1, 0, 0, 1));
		General beakerG = new General(
				new Texture(PlayAssets.objects.crop(new Vector2f(0, 0), new Vector2f(16, 16))).getTextureID(),
				new Vector2f(12 * SCALE, 16 * SCALE), new Vector2f(0, 0), new Vector2f(16 * SCALE),
				new Vector4f(0, 1, 0, 1));
		General beakerB = new General(
				new Texture(PlayAssets.objects.crop(new Vector2f(0, 0), new Vector2f(16, 16))).getTextureID(),
				new Vector2f(24 * SCALE, 16 * SCALE), new Vector2f(0, 0), new Vector2f(16 * SCALE),
				new Vector4f(0, 0, 1, 1));
		General testTubes = new General(
				new Texture(PlayAssets.objects.crop(new Vector2f(16, 0), new Vector2f(16, 16))).getTextureID(),
				new Vector2f(240 * SCALE, 18 * SCALE), new Vector2f(0, 0), new Vector2f(16 * SCALE),
				new Vector4f(1, 1, 1, 1));
		General computer = new General(
				new Texture(PlayAssets.objects.crop(new Vector2f(32, 0), new Vector2f(16, 16))).getTextureID(),
				new Vector2f(480 * SCALE, 24 * SCALE), new Vector2f(0, 0), new Vector2f(24 * SCALE),
				new Vector4f(1, 1, 1, 1));
		General microscope = new General(
				new Texture(PlayAssets.objects.crop(new Vector2f(48, 0), new Vector2f(16, 16))).getTextureID(),
				new Vector2f(560 * SCALE, 16 * SCALE), new Vector2f(0, 0), new Vector2f(16 * SCALE),
				new Vector4f(1, 1, 1, 1));
		Engine.addObject(Entity.class, beakerR);
		Engine.addObject(Entity.class, beakerB);
		Engine.addObject(Entity.class, beakerG);
		Engine.addObject(Entity.class, testTubes);
		Engine.addObject(Entity.class, computer);
		Engine.addObject(Entity.class, microscope);
	}
}
