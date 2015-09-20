package com.tetris.effects.audio;

import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.BeatDetect;

/**
 *
 * @author Douglas Rudolph
 */
public class MinimFactory
{
	//song location for Doug's Song file
	public static String DOUG_SONG_FILE_LOCATION="C:/Users/Douglas/Desktop/King_Krule-Easy_Easy.wav";
	
	//PUT A SONG HERE IF YOU WANT TO RUN IT ON YOUR COMPUTER
	public static String LUKE_SONG_FILE_LOCATION="PUTT YOUR STUFF HERE";
	
	/**
	 * Loads a song
	 * 
	 * @param song - Audio Buffer Object
	 * @param minim - File System Object
	 * @param fileLocation - File Path To Song Location
	 */
	public static void loadSong(AudioPlayer song, Minim minim, String fileLocation, MinimWrapper wrapper)
	{
		//change to luke if luke is running locally
		song=minim.loadFile(DOUG_SONG_FILE_LOCATION);
		
		wrapper.setSong(song);
	}
	
	/**
	 * Detects base notes from a playing song
	 * @param song
	 * @param beat
	 * @return
	 */
	public static boolean detect(AudioPlayer song, BeatDetect beat)
	{
		beat.detect(song.mix);
		if(beat.isOnset())
		{
			System.out.println("bass");
			return true;
		}
		return false;
	}
	
	public static int detectSize(BeatDetect beat)
	{
		return beat.dectectSize();
	}
	
	public static void playSong(AudioPlayer song)
	{
		song.play();
	}
	
	public static void playSong(AudioPlayer song, int secondsIn)
	{
		song.play(secondsIn*1000);
	}
	
	
	public static AudioPlayer getSong(AudioPlayer song)
	{
		return song;
	}
	
	
}
