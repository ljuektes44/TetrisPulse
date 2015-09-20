package com.tetris.collision;

import com.tetris.entities.TetrisBlock;
import com.tetris.map.MapGrid;

public class CollisionHandler {

	private MapGrid grid;
	private TetrisBlock block;

	public CollisionHandler(MapGrid grid, TetrisBlock block) {
		this.grid = grid;
		this.block = block;
	}

	public void update() {
		if ((int) (block.getGridPosition().y - 1) >= 0) {
			if (grid.getGrid()[(int) (block.getGridPosition().x)][(int) (block.getGridPosition().y - 1)] ||
					grid.getGrid()[(int) (block.getGridPosition().x - 1)][(int) (block.getGridPosition().y - 1)] ||
					grid.getGrid()[(int) (block.getGridPosition().x + 1)][(int) (block.getGridPosition().y - 1)]) {
				block.setIsAlive(false);
				block.reset();
				System.out.println("true");
			}
		}
		
		
	}

}
