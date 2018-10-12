package com.draglantix.engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.draglantix.assets.Assets;
import com.draglantix.entities.Entity;
import com.draglantix.foregrounds.Foreground;
import com.draglantix.guis.Gui;
import com.draglantix.renderEngine.font.Message;
import com.draglantix.renderEngine.objects.Objects;
import com.draglantix.renderEngine.rectangle.Rectangle;

public class Engine {

	public static HashMap<Class<?>, List<Objects>> objects;

	private static Assets assets;

	public Engine(Assets asset) {
		assets = asset;
		objects = new HashMap<Class<?>, List<Objects>>();

		initObjects(Entity.class);
		initObjects(Gui.class);
		initObjects(Foreground.class);
	}

	public static void renderState(List<Class<? extends Objects>> classes) {
		for(Class<? extends Objects> clazz : classes) {
			renderMaster(clazz);
		}
		renderMessages(assets.messages);
	}

	public static void tickState(List<Class<? extends Objects>> classes) {
		for(Class<? extends Objects> clazz : classes) {
			tick(clazz);
		}
	}

	public static <T extends Objects> void addObject(Class<T> clazz, T obj) {
		objects.get(clazz).add(obj);

	}

	private static <T extends Objects> void tick(Class<T> clazz) {
		for(Objects obj : objects.get(clazz)) {
			obj.tick();
		}
	}

	private static <T extends Objects> void renderMaster(Class<T> clazz) {
		assets.graphics.prepare(assets.graphics.getRectShader());
		render(objects.get(clazz));
		assets.graphics.finish(assets.graphics.getRectShader());
	}

	private static <T extends Objects> void render(List<T> list) {
		for(Objects obj : list) {
			assets.graphics.drawRect(new Rectangle(obj));
		}
	}

	public static void renderMessages(List<Message> messages) {
		assets.graphics.prepare(assets.graphics.getRectShader());
		if(messages != null)
			for(Message msg : messages) {
				assets.graphics.drawFont(msg);
			}
		assets.graphics.finish(assets.graphics.getRectShader());
	}

	public static <T extends Objects> void initObjects(Class<T> clazz) {
		objects.put(clazz, new ArrayList<Objects>());
	}

	public static <T extends Objects> void removeObject(Class<T> clazz, T obj) {
		objects.get(clazz).remove(obj);
	}

	public static void unloadAll() {
		for(Class<?> clazz : objects.keySet()) {
			objects.get(clazz).clear();
		}
	}

	public static void cleanUp() {
		// Fix cleanup stuff in DragonFire.
	}

}