package com.draglantix.world;

import org.joml.Vector2f;
import org.joml.Vector4f;

import com.draglantix.assets.MenuAssets;
import com.draglantix.assets.PlayAssets;
import com.draglantix.engine.Engine;
import com.draglantix.entities.Background;
import com.draglantix.entities.Entity;
import com.draglantix.entities.General;
import com.draglantix.renderEngine.font.Message;
import com.draglantix.renderEngine.models.Texture;

public class World {

	public final int SCALE = 2;

	public static String r_, r0, r1,r2,r3,r4,r5,r6,r7,r8,r9;
	
	public void init() {
		
		r9 = "9 - Logic Error";
		r8 = "8 - Core Dump";
		r7 = "7 - File Not Found";
		r6 = "6 - Concurrent Modification";
		r5 = "5 - Array out of Bounds";
		r4 = "4 - Static Access";
		r3 = "3 - Null Pointer Exception";
		r2 = "2 - Cast Exception"; 
		r1 = "1 - Syntax Error";
		r0 = "0 - Warning";
		r_ = "NA - Code works perfectly.";
		
		for(int z = 0; z < 10; z ++) {
			Background wall = new Background(PlayAssets.wallTex.getTextureID(), new Vector2f(512*z*SCALE, 205), new Vector2f(0, 0), new Vector2f(512, 270), new Vector4f(1, 1, 1, 1), 0f);
			Engine.addObject(Entity.class, wall);
			
			switch(z) {
			
			case 0:
				Message a = new Message(r_, new Vector2f(85 * SCALE, 200), new Vector2f(0, 0), new Vector2f(5, 5), new Vector4f(1, 1, 1, 1), true, PlayAssets.assets.graphics);	
				PlayAssets.assets.messages.add(a);
				break;
			case 1:	
				Message b = new Message(r0, new Vector2f(z*-532*SCALE, 200), new Vector2f(0, 0), new Vector2f(5, 5), new Vector4f(1, 1, 1, 1), true, PlayAssets.assets.graphics);	
				PlayAssets.assets.messages.add(b);
				break;
			case 2:
				Message c = new Message(r1, new Vector2f(z*-532*SCALE, 200), new Vector2f(0, 0), new Vector2f(5, 5), new Vector4f(1, 1, 1, 1), true, PlayAssets.assets.graphics);	
				PlayAssets.assets.messages.add(c);
				break;
			case 3:
				Message d = new Message(r2, new Vector2f(z*-532*SCALE, 200), new Vector2f(0, 0), new Vector2f(5, 5), new Vector4f(1, 1, 1, 1), true, PlayAssets.assets.graphics);	
				PlayAssets.assets.messages.add(d);
				break;
			case 4:
				Message e = new Message(r3, new Vector2f(z*-532*SCALE, 200), new Vector2f(0, 0), new Vector2f(5, 5), new Vector4f(1, 1, 1, 1), true, PlayAssets.assets.graphics);	
				PlayAssets.assets.messages.add(e);
				break;
			case 5:
				Message f = new Message(r4, new Vector2f(z*-532*SCALE, 200), new Vector2f(0, 0), new Vector2f(5, 5), new Vector4f(1, 1, 1, 1), true, PlayAssets.assets.graphics);	
				PlayAssets.assets.messages.add(f);
				break;
			case 6:
				Message g = new Message(r5, new Vector2f(z*-532*SCALE, 200), new Vector2f(0, 0), new Vector2f(5, 5), new Vector4f(1, 1, 1, 1), true, PlayAssets.assets.graphics);	
				PlayAssets.assets.messages.add(g);
				break;
			case 7:
				Message h = new Message(r6, new Vector2f(z*-532*SCALE, 200), new Vector2f(0, 0), new Vector2f(5, 5), new Vector4f(1, 1, 1, 1), true, PlayAssets.assets.graphics);	
				PlayAssets.assets.messages.add(h);
				break;
			case 8:
				Message i = new Message(r7, new Vector2f(z*-532*SCALE, 200), new Vector2f(0, 0), new Vector2f(5, 5), new Vector4f(1, 1, 1, 1), true, PlayAssets.assets.graphics);	
				PlayAssets.assets.messages.add(i);
				break;
			case 9:
				Message j = new Message(r8, new Vector2f(z*-532*SCALE, 200), new Vector2f(0, 0), new Vector2f(5, 5), new Vector4f(1, 1, 1, 1), true, PlayAssets.assets.graphics);	
				PlayAssets.assets.messages.add(j);
				break;
			default:
				Message k = new Message(r9, new Vector2f(z*-532*SCALE, 200), new Vector2f(0, 0), new Vector2f(5, 5), new Vector4f(1, 1, 1, 1), true, PlayAssets.assets.graphics);	
				PlayAssets.assets.messages.add(k);
				break;
			}
		}
		
		//Player
		Engine.addObject(Entity.class, PlayAssets.player);

		for(int z = 0; z < 9; z ++) {
			Background table = new Background(PlayAssets.tableTex.getTextureID(), new Vector2f(z * 512 * SCALE, -70), new Vector2f(0, 0), new Vector2f(420, 64), new Vector4f(1, 1, 1, 1), 0f);
			Engine.addObject(Entity.class, table);
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
