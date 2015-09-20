package com.tetris.effects.audio;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.BeatDetect;

/**
 * 
 * @author Douglas Rudolph
 */
public class MinimWrapper 
{
	//Instance of Song that will be playing
	private AudioPlayer song;
	
	//Beat detection object
	private BeatDetect beat;
	
	//File Loading object
	private Minim minim;
	
	/**
	 * 
	 * @param fileName
	 */
	public MinimWrapper()
	{
		song =null;
		minim = new Minim(this);
		beat = new BeatDetect();		
		beat.setSensitivity(5);
	}
	
	public String sketchPath(String fileName)
	{
		return fileName;
	}
	
	public InputStream createInput(String fileName)
	{
		try
		{
			InputStream stream = new FileInputStream(fileName);
			BufferedInputStream bufferedStream = new BufferedInputStream(stream);
			
			return bufferedStream;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	public AudioPlayer getSong() 
	{
		return song;
	}

	public void setSong(AudioPlayer song) 
	{
		this.song = song;
	}

	public BeatDetect getBeat() 
	{
		return beat;
	}

	public void setBeat(BeatDetect beat) 
	{
		this.beat = beat;
	}

	public Minim getMinim() 
	{
		return minim;
	}

	public void setMinim(Minim minim) 
	{
		this.minim = minim;
	}
	
}