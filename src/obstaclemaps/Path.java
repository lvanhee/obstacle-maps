package obstaclemaps;

import java.util.ArrayList;
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
	public String toString() {
		return startingPoint.x+","+startingPoint.y+":"+directions.toString();
	}

	public static Path parse(String string) {
		string = string.trim();
		int xStart = Integer.parseInt(string.substring(0,string.indexOf(",")));
		string = string.substring(string.indexOf(",")+1);
		int yStart = Integer.parseInt(string.substring(0,string.indexOf(":")));
		string = string.substring(string.indexOf(":"));
		
		List<Direction> directions = new ArrayList<Path.Direction>();
		string = string.substring(2,string.length()-1).replaceAll(" ", "");
		for(String s:string.split(","))
		{
			directions.add(Direction.valueOf(s));
		}
		
		return new Path(new Point(xStart, yStart), directions);
	}

	public static boolean isValidPathFormat(String last) {
		if(last.contains("current"))
			return false;
		if(last.toLowerCase().contains("from"))
			return false;
		if(last.startsWith("("))
			return true;
		if(last.startsWith("Path found:"))
			return true;
		if(last.endsWith("]"))
			return true;
		return false;
	}
	
}
