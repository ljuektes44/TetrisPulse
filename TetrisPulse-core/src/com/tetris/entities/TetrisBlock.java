package com.tetris.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;
import com.tetris.map.MapGrid;

public class TetrisBlock {
	
	float elapsedTime;
	
	private Vector2 position, gridPosition, oldGridPosition;
	
	private boolean hasMoved, isAlive;
	
	private int startX, startY;
	public TetrisBlock(){
		isAlive = true;
		position = new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() - MapGrid.CELL_SIZE * 2);
		gridPosition = new Vector2((int) (position.x / MapGrid.CELL_SIZE), (int) (position.y / MapGrid.CELL_SIZE));
		oldGridPosition = new Vector2((int) (position.x / MapGrid.CELL_SIZE), (int) (position.y / MapGrid.CELL_SIZE));
		
		startX = (int) (Gdx.graphics.getWidth() / 2);
		startY = (int) (Gdx.graphics.getHeight() - MapGrid.CELL_SIZE * 2);
		
	}
	
	public void update(){
		hasMoved = false;
		elapsedTime += 2 * Gdx.graphics.getDeltaTime();
		
		
		gridPosition.x = (int) (position.x / MapGrid.CELL_SIZE);
		gridPosition.y = (int) (position.y / MapGrid.CELL_SIZE);
		oldGridPosition.y = (int) (position.y / MapGrid.CELL_SIZE);
		oldGridPosition.x = (int) (position.x / MapGrid.CELL_SIZE);
		
		if(Gdx.input.isKeyJustPressed(Keys.D)){
			position.x += MapGrid.CELL_SIZE;
			hasMoved = true;
		}
		if(Gdx.input.isKeyJustPressed(Keys.A)){
			position.x -= MapGrid.CELL_SIZE;
			hasMoved = true;
		}
		if(Gdx.input.isKeyJustPressed(Keys.S)){
			position.y -= MapGrid.CELL_SIZE;
			hasMoved = true;
		}
		
		if(elapsedTime >= 3 && isAlive){
			System.out.println("Move");
			elapsedTime = 0;
			hasMoved = true;
			position.y -= MapGrid.CELL_SIZE;
		}
		
		
	}
	
	public Vector2 getGridPosition(){
		return gridPosition;
	}
	
	public Vector2 getOldGridPosition(){
		return oldGridPosition;
	}
	
	public void setIsAlive(boolean can){ isAlive = can; }
	
	public boolean hasMoved(){ return hasMoved; }

	public boolean isAlive(){ return isAlive; }
	
	public void reset(){
		position.x = startX;
		position.y = startY;
		isAlive = true;
	}
}
