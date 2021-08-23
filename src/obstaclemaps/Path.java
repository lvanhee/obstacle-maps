package obstaclemaps;

import java.util.List;
import java.awt.Component;
import java.awt.Point;

public class Path {
	public enum Direction{NORTH, SOUTH, EAST, WEST}
	
	private Point startingPoint;
	private List<Direction> directions;
	
	public Path(Point startingPoint, List<Direction> directions)
	{
		this.startingPoint = startingPoint;
		this.directions = directions;
	}

	public List<Direction> getDirections() {
		return directions;
	}

	public Point getStartingPoint() {
		return startingPoint;
	}
	
}
