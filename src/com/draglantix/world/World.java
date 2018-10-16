package com.draglantix.world;

import org.joml.Vector2f;
import org.joml.Vector4f;

import com.draglantix.assets.PlayAssets;
import com.draglantix.engine.Engine;
import com.draglantix.entities.Background;
import com.draglantix.entities.Entity;
import com.draglantix.entities.General;
import com.draglantix.renderEngine.models.Texture;

public class World {

	public final int SCALE = 2;

	public void init() {
	
		Background sky = new Background(PlayAssets.skyTex.getTextureID(), new Vector2f(0, 40), new Vector2f(0, 0), new Vector2f(400, 250), new Vector4f(1, 1, 1, 1), 1f);
		Engine.addObject(Entity.class, sky);
		Background mnts = new Background(PlayAssets.mntTex.getTextureID(), new Vector2f(512, 40), new Vector2f(0, 0), new Vector2f(512*2, 64*2), new Vector4f(1, 1, 1, 1), 0.9f);
		Engine.addObject(Entity.class, mnts);
		
		for(int z = 0; z < 11; z ++) {
			Background wall = new Background(PlayAssets.wallTex.getTextureID(), new Vector2f(512*z*SCALE, 205), new Vector2f(0, 0), new Vector2f(512, 270), new Vector4f(1, 1, 1, 1), 0f);
			Engine.addObject(Entity.class, wall);
			
			switch(z) {
				case 0:
					Engine.addObject(Entity.class, new General(PlayAssets.tex0.getTextureID(), new Vector2f(-200 + (z*512*SCALE), 200), new Vector2f(0, 0), new Vector2f(PlayAssets.tex0.getWidth()/2, PlayAssets.tex0.getHeight()/2), new Vector4f(1, 1, 1, 1)));
					break;
				case 1:
					Engine.addObject(Entity.class, new General(PlayAssets.tex1.getTextureID(), new Vector2f(-200 + (z*512*SCALE), 200), new Vector2f(0, 0), new Vector2f(PlayAssets.tex9.getWidth()/2, PlayAssets.tex1.getHeight()/2), new Vector4f(1, 1, 1, 1)));
					break;
				case 2:
					Engine.addObject(Entity.class, new General(PlayAssets.tex2.getTextureID(), new Vector2f(-200 + (z*512*SCALE), 200), new Vector2f(0, 0), new Vector2f(PlayAssets.tex9.getWidth()/2, PlayAssets.tex2.getHeight()/2), new Vector4f(1, 1, 1, 1)));
					break;
				case 3:
					Engine.addObject(Entity.class, new General(PlayAssets.tex3.getTextureID(), new Vector2f(-200 + (z*512*SCALE), 200), new Vector2f(0, 0), new Vector2f(PlayAssets.tex9.getWidth()/2, PlayAssets.tex3.getHeight()/2), new Vector4f(1, 1, 1, 1)));
					break;
				case 4:
					Engine.addObject(Entity.class, new General(PlayAssets.tex4.getTextureID(), new Vector2f(-200 + (z*512*SCALE), 200), new Vector2f(0, 0), new Vector2f(PlayAssets.tex9.getWidth()/2, PlayAssets.tex4.getHeight()/2), new Vector4f(1, 1, 1, 1)));
					break;
				case 5:
					Engine.addObject(Entity.class, new General(PlayAssets.tex5.getTextureID(), new Vector2f(-200 + (z*512*SCALE), 200), new Vector2f(0, 0), new Vector2f(PlayAssets.tex9.getWidth()/2, PlayAssets.tex5.getHeight()/2), new Vector4f(1, 1, 1, 1)));
					break;
				case 6:
					Engine.addObject(Entity.class, new General(PlayAssets.tex6.getTextureID(), new Vector2f(-200 + (z*512*SCALE), 200), new Vector2f(0, 0), new Vector2f(PlayAssets.tex9.getWidth()/2, PlayAssets.tex6.getHeight()/2), new Vector4f(1, 1, 1, 1)));
					break;
				case 7:
					Engine.addObject(Entity.class, new General(PlayAssets.tex7.getTextureID(), new Vector2f(-200 + (z*512*SCALE), 200), new Vector2f(0, 0), new Vector2f(PlayAssets.tex9.getWidth()/2, PlayAssets.tex7.getHeight()/2), new Vector4f(1, 1, 1, 1)));
					break;
				case 8:
					Engine.addObject(Entity.class, new General(PlayAssets.tex8.getTextureID(), new Vector2f(-200 + (z*512*SCALE), 200), new Vector2f(0, 0), new Vector2f(PlayAssets.tex9.getWidth()/2, PlayAssets.tex8.getHeight()/2), new Vector4f(1, 1, 1, 1)));
					break;
				case 9:
					Engine.addObject(Entity.class, new General(PlayAssets.tex9.getTextureID(), new Vector2f(-200 + (z*512*SCALE), 200), new Vector2f(0, 0), new Vector2f(PlayAssets.tex9.getWidth()/2, PlayAssets.tex9.getHeight()/2), new Vector4f(1, 1, 1, 1)));
					break;
				default:
					Engine.addObject(Entity.class, new General(PlayAssets.tex_.getTextureID(), new Vector2f(-200 + (z*512*SCALE), 200), new Vector2f(0, 0), new Vector2f(PlayAssets.tex_.getWidth()/2, PlayAssets.tex_.getHeight()/2), new Vector4f(1, 1, 1, 1)));
					break;
			}
		}
		
		//Player
		Engine.addObject(Entity.class, PlayAssets.player);

		for(int z = 0; z < 11; z ++) {
			Background table = new Background(PlayAssets.tableTex.getTextureID(), new Vector2f(z * 512 * SCALE, -70), new Vector2f(0, 0), new Vector2f(420, 64), new Vector4f(1, 1, 1, 1), 0f);
			Engine.addObject(Entity.class, table);
		}
		
		//Science Objects
		General beakerR = new General(
				new Texture(PlayAssets.objects.crop(new Vector2f(0, 0), new Vector2f(16, 16))).getTextureID(),
				new Vector2f(0 * SCALE, 12 * SCALE), new Vector2f(0, 0), new Vector2f(16 * SCALE),
				new Vector4f(1, 0, 0, 1));
		General beakerG = new General(
				new Texture(PlayAssets.objects.crop(new Vector2f(0, 0), new Vector2f(16, 16))).getTextureID(),
				new Vector2f(12 * SCALE, 12 * SCALE), new Vector2f(0, 0), new Vector2f(16 * SCALE),
				new Vector4f(0, 1, 0, 1));
		General beakerB = new General(
				new Texture(PlayAssets.objects.crop(new Vector2f(0, 0), new Vector2f(16, 16))).getTextureID(),
				new Vector2f(24 * SCALE, 12 * SCALE), new Vector2f(0, 0), new Vector2f(16 * SCALE),
				new Vector4f(0, 0, 1, 1));
		General testTubes = new General(
				new Texture(PlayAssets.objects.crop(new Vector2f(16, 0), new Vector2f(16, 16))).getTextureID(),
				new Vector2f(240 * SCALE, 12 * SCALE), new Vector2f(0, 0), new Vector2f(16 * SCALE),
				new Vector4f(1, 1, 1, 1));
		General computer = new General(
				new Texture(PlayAssets.objects.crop(new Vector2f(32, 0), new Vector2f(16, 16))).getTextureID(),
				new Vector2f(480 * SCALE, 20 * SCALE), new Vector2f(0, 0), new Vector2f(24 * SCALE),
				new Vector4f(1, 1, 1, 1));
		General microscope = new General(
				new Texture(PlayAssets.objects.crop(new Vector2f(48, 0), new Vector2f(16, 16))).getTextureID(),
				new Vector2f(560 * SCALE, 12 * SCALE), new Vector2f(0, 0), new Vector2f(16 * SCALE),
				new Vector4f(1, 1, 1, 1));
		Engine.addObject(Entity.class, beakerR);
		Engine.addObject(Entity.class, beakerB);
		Engine.addObject(Entity.class, beakerG);
		Engine.addObject(Entity.class, testTubes);
		Engine.addObject(Entity.class, computer);
		Engine.addObject(Entity.class, microscope);
	}
}
