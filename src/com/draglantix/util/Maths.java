package com.draglantix.util;

import java.util.Random;

public class Maths {
	
	private static Random rand = new Random();

	public static Random rand() {
		return rand;
	}
	
	public static float generateFloat(float amp) {
		return (rand.nextFloat() * amp) - (amp/2);
	}
	
	public static float clamp(float raw, float min, float max) {
		if(raw > max) {
			return max;
		}else if (raw < min) {
			return min;
		}else {
			return raw;
		}
	}
}
