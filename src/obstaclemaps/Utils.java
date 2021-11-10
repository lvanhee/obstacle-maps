package obstaclemaps;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import obstaclemaps.Path.Direction;

public class Utils {
	
	public void exportToFile(String fileName, JPanel jp) {
		BufferedImage bu = new BufferedImage(jp.getWidth(),jp.getHeight(), BufferedImage.TYPE_INT_ARGB);

		jp.paint(bu.getGraphics());
		File outputfile = Paths.get(fileName).toFile();
		try {
			if(!outputfile.exists())
				outputfile.createNewFile();
			ImageIO.write(bu, "png", outputfile);
		} catch (IOException e) {
			e.printStackTrace();
			throw new Error();
		}
	}

	public static enum PathCorrectnessOutcome{
		PATH_HITS_AN_OBSTACLE, CORRECT_PATH, PATH_DOES_NOT_REACH_THE_GOAL}
	public static PathCorrectnessOutcome isPathCorrect(ObstacleMap om, obstaclemaps.Path selectedPath, Point goal) {
		Point start = selectedPath.getStartingPoint();
		for(Direction d:selectedPath.getDirections())
		{
			switch(d)
			{
			case EAST: start = new Point(start.x+1, start.y); break;
			case WEST: start = new Point(start.x-1, start.y); break;
			case SOUTH: start = new Point(start.x, start.y+1); break;
			case NORTH: start = new Point(start.x, start.y-1); break;
			}
			if(om.getObstacles().contains(start))return PathCorrectnessOutcome.PATH_HITS_AN_OBSTACLE;
		}
		if(start.equals(goal)) return PathCorrectnessOutcome.CORRECT_PATH;
		else return PathCorrectnessOutcome.PATH_DOES_NOT_REACH_THE_GOAL;
	}
}

