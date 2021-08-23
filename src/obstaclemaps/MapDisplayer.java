package obstaclemaps;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.function.Function;

import javax.swing.JFrame;

public class MapDisplayer extends JFrame {

	public static final int TILEWIDTH = 10;
	public static final int TILEHEIGHT = 10;
	public static final int LEFTTILTPANEL = 1;
	
	
	private final ObstacleMap om;
	private final MapDisplayerPanel panel;
	
	private MapDisplayer(ObstacleMap om)
	{
		this.om = om;
		panel = new MapDisplayerPanel(om);
		this.add(panel);

		repaint();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(panel.getTotalPanelWidth(),
				panel.getTotalPanelHeight()));
	}

	
	public void setPath(Path p) {
		panel.setPath(p);
	}
	
	



	public static MapDisplayer newInstance(ObstacleMap om) {
		return new MapDisplayer(om);
	}


	public void setColorPerTile(Function<Point, Color> object) {
		panel.setColorPerTile(object);
	}

}
