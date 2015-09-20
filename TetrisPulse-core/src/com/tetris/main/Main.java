package com.tetris.main;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.tetris.collision.CollisionHandler;
import com.tetris.entities.TetrisBlock;
import com.tetris.map.MapGrid;

public class Main extends ApplicationAdapter {
	
	public OrthographicCamera cam;
	
	public MapGrid mapGrid;
	public ShapeRenderer renderer;
	
	public TetrisBlock block;
	
	public CollisionHandler handle;
	
	@Override
	public void create () {
		
		
		block = new TetrisBlock();
		
		cam = new OrthographicCamera();
		cam.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		renderer = new ShapeRenderer();
		renderer.setAutoShapeType(true);
		
		mapGrid = new MapGrid(block);
		
		handle = new CollisionHandler(mapGrid, block);
		
		
	}

	@Override
	public void render () {
		handle.update();
		cam.update();
		mapGrid.update(true);
		block.update();
		
		renderer.setProjectionMatrix(cam.combined);
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		renderer.begin();
		mapGrid.render(renderer);
		renderer.end();
		
	}
}
