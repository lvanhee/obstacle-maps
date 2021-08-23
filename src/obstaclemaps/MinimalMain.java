package obstaclemaps;

import java.awt.Color;
import java.awt.Point;
import java.util.Arrays;

import obstaclemaps.Path.Direction;

public class MinimalMain {
	
	public static void main(String[] args)
	{
		ObstacleMap om = MinimalExample.getExampleMap();
		MapDisplayer md = MapDisplayer.newInstance(om);
		md.setVisible(true);
		
		Point goalTile = new Point(25,30);
		Point startTile = new Point(15,17);
		
		
		Path examplePath = new Path(startTile, Arrays.asList(Direction.NORTH,
				Direction.NORTH,
				Direction.NORTH,
				Direction.EAST,
				Direction.EAST,
				Direction.SOUTH
				)); 
		/**
		 * This call sets the path to a given preset
		 */
		md.setPath(examplePath);
		
		/**
		 * This call sets the color for every tile.
		 * Notably, this function allows setting the color of the start tile as yellow
		 * and the color of the goal tile as green.
		 */
		md.setColorPerTile(x->
		{
			if(x.equals(goalTile))
				return Color.green;
			if(x.equals(startTile))
				return Color.yellow;
			else return Color.white;		
		});
		
		
		System.out.println();
	}

}
