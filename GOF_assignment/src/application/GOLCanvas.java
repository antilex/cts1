package application;

import javafx.scene.canvas.*;
import javafx.scene.paint.*;

import foundation.CellState;
import foundation.GOLBoard;

public class GOLCanvas extends Canvas {

	private static final int CELLSIZE = 5;
	private static final int GAP = 2;

	private GraphicsContext gc = null;

	public GOLCanvas() {
		super(GOLBoard.CELLSHORIZONTAL * (CELLSIZE + GAP) + GAP, GOLBoard.CELLSVERTICAL * (CELLSIZE + GAP) + GAP);

		// Get the graphics context for the canvas & clear. 
		gc = getGraphicsContext2D();
		clear();
	}

	// shows the contents of 'board' on the canvas
	
	public void show(GOLBoard board) {
        //******************************************************************
        // Alex: implement drawing on the canvas according to the layout of the board
        //******************************************************************
		
		

		//sample array
		char[] array = {'+', '.', '+','+','.','.','.','+'};

		//sample initial x, y values (to be implemented when centering image on board)
		int XCOORDINATE = 80;
		int YCOORDINATE = 90; 

		//for loop to traverse array 
		for (int i = 0; (i < array.length); i++) {
			if (array[i] == GOLBoard.REPRESENTATIONLIVECELL) {
				//draw rectangles on canvas 
				//requires x,y, width and height 
				gc.setStroke(Color.BLACK);
				gc.strokeRect(XCOORDINATE, YCOORDINATE, CELLSIZE, CELLSIZE);
				XCOORDINATE += 7;
				//if cell is dead display empty space 
			} else if (array[i] == GOLBoard.REPRESENTATIONDEADCELL) {
				gc.clearRect(XCOORDINATE, YCOORDINATE, CELLSIZE, CELLSIZE);
				XCOORDINATE += 7;
			}
		}

	}

	public void clear() {
		gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
		gc.setStroke(Color.LIGHTSLATEGRAY);
		gc.strokeRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
	}

}
