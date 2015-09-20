package com.tetris.map;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.tetris.entities.TetrisBlock;

public class MapGrid {
	
	
	public static final int CELL_SIZE = 25;
	public static final int ROWS = 10;
	public static final int COLUMNS = 22;
	
	public static final int MAP_WIDTH = ROWS * CELL_SIZE;
	public static final int MAP_HEIGHT = COLUMNS * CELL_SIZE;
	
	public ArrayList<TetrisBlock> blockList;
	
	public boolean [][] mapGrid;
	
	private TetrisBlock block;
	
	public MapGrid(TetrisBlock block){
		this.block = block;
		mapGrid = new boolean[ROWS][COLUMNS];
		
		
	}
	
	
	public void update(boolean can){
			setTrue();			
		if(block.hasMoved() && block.isAlive())
			setFalse();
		
		if(block.getGridPosition().y == 0){
			block.setIsAlive(false);
			block.reset();
		}
			
			
		}
		
	public void setTrue(){

		mapGrid[(int) (block.getGridPosition().x) + 1]
				   [(int) (block.getGridPosition().y)] = true;
		
		mapGrid[(int) (block.getGridPosition().x) - 1]
				   [(int) (block.getGridPosition().y)] = true;
		
		mapGrid[(int) (block.getGridPosition().x)]
				   [(int) (block.getGridPosition().y)] = true;
		
		mapGrid[(int) (block.getGridPosition().x)]
				   [(int) (block.getGridPosition().y) + 1] = true;
	}
	
	public void setFalse(){
		mapGrid[(int) (block.getOldGridPosition().x)]
				   [(int) (block.getOldGridPosition().y)] = false;
		mapGrid[(int) (block.getOldGridPosition().x) + 1]
				   [(int) (block.getOldGridPosition().y)] = false;
		mapGrid[(int) (block.getOldGridPosition().x) - 1]
				   [(int) (block.getOldGridPosition().y)] = false;
		mapGrid[(int) (block.getOldGridPosition().x)]
				   [(int) (block.getOldGridPosition().y) + 1] = false;
	}
	
	
	public void render(ShapeRenderer render){
		render.set(ShapeType.Filled);
		render.setColor(Color.RED);
		for(int x = 0; x < mapGrid.length; x++)
			for(int y = 0; y < mapGrid[x].length; y++){
				if(mapGrid[x][y]){
					render.rect(x * CELL_SIZE, y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
				}
			}
		
		render.setColor(Color.GRAY);
		render.set(ShapeType.Line);
		for(int x = 0; x < MAP_WIDTH; x += CELL_SIZE){
			for(int y = 0; y < MAP_HEIGHT; y += CELL_SIZE){
				render.rect(x, y, CELL_SIZE, CELL_SIZE);
			}
		}
		
	}

	public boolean[][] getGrid(){ return mapGrid; }
	
}
