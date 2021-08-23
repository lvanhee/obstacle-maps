package obstaclemaps;

import java.awt.Component;
import java.awt.Point;
import java.util.Set;

public class ObstacleMap {
	
	private final Set<Point> obstacles;
	private final int width;
	private final int height;
	
	public ObstacleMap(int width, int height, Set<Point> obstacles2) {
		this.obstacles = obstacles2;
		this.width = width;
		this.height = height;
	}

	public static ObstacleMap newInstance(int width, int height,Set<Point> obstacles) {
		return new ObstacleMap(width, height, obstacles);
	}

	public Set<Point> getObstacles() {
		return obstacles;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

}
