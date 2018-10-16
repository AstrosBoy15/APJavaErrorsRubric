package com.draglantix.util;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

import com.draglantix.renderEngine.audio.WaveData;

public class FileReader {

	public static BufferedImage loadImage(String path) {
		try {
			return ImageIO.read(Class.class.getResource("/res/textures/" + path + ".png"));
		} catch (IOException e) {
			System.err.println("File not found!");
			return null;
		}
	}

	public static WaveData loadAudio(String path) {
		AudioInputStream audioStream = null;
		try {
			audioStream = AudioSystem.getAudioInputStream(Class.class.getResource("/res/" + path));
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		WaveData waveStream = new WaveData(audioStream);
		return waveStream;
	}

}
