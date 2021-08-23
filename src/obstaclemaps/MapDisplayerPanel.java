package obstaclemaps;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.function.Function;

import javax.swing.JPanel;

import obstaclemaps.Path.Direction;

public class MapDisplayerPanel extends JPanel{
	
	private final ObstacleMap om;
	private Function<Point, Color> colorPerTile = (x)->Color.white;
	private Path p;

	
	public MapDisplayerPanel(ObstacleMap om)
	{
		this.om = om;
	}
	
	public int getTotalPanelWidth() {
		return om.getWidth()*MapDisplayer.TILEWIDTH+MapDisplayer.TILEWIDTH+10;
	}

	public int getTotalPanelHeight() {
		return om.getHeight()*MapDisplayer.TILEHEIGHT+MapDisplayer.TILEHEIGHT+28;
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		paintGrid(g);
		paintObstacles(g);
		paintPath((Graphics2D) g);
	}
	
	private void paintPath(Graphics2D g) {
		if(p==null)return;
		
		Point start = tileToDisplay(p.getStartingPoint());
		Point previous = start;
		
		g.setColor(Color.BLUE);
		
		for(int i = 0 ; i < p.getDirections().size() ; i++)
		{
			
			Point current = previous; 
			int shiftX = 0;
			int shiftY = 0;
			if(p.getDirections().get(i).equals(Direction.EAST))
				shiftX = 10;
			if(p.getDirections().get(i).equals(Direction.WEST))
				shiftX = -10;
			if(p.getDirections().get(i).equals(Direction.SOUTH))
				shiftY = 10;
			if(p.getDirections().get(i).equals(Direction.NORTH))
				shiftY = -10;

			g.setStroke(new BasicStroke(3));
			g.drawLine(current.x, current.y, current.x+shiftX, current.y+shiftY);
			
			previous = new Point(current.x+shiftX, current.y+shiftY);
		}
		
	}

	private Point tileToDisplay(Point startingPoint) {
		return new Point(startingPoint.x*MapDisplayer.TILEWIDTH+MapDisplayer.TILEWIDTH/2, startingPoint.y*MapDisplayer.TILEHEIGHT+MapDisplayer.TILEHEIGHT/2);
	}

	private void paintGrid(Graphics g) {
		for(int i = 0 ;  i < om.getWidth(); i++)
			for(int j = 0 ;  j < om.getHeight(); j++)
			{
				paintTile(g, i, j, colorPerTile.apply(new Point(i, j)));

				g.setColor(Color.black);
				g.drawRect(MapDisplayer.LEFTTILTPANEL+i*MapDisplayer.TILEWIDTH, j*MapDisplayer.TILEHEIGHT, MapDisplayer.TILEWIDTH, MapDisplayer.TILEHEIGHT);
			}
	}
	
	private void paintObstacles(Graphics g) {
		for(int i = 0 ;  i < om.getWidth(); i++)
			for(int j = 0 ;  j < om.getHeight(); j++)
				if(om.getObstacles().contains(new Point(i, j)))
					paintTile(g,i,j,Color.black);
	}

	private void paintTile(Graphics g, int i, int j, Color c) {
		g.setColor(c);
		g.fillRect(MapDisplayer.LEFTTILTPANEL+i*MapDisplayer.TILEWIDTH, j*MapDisplayer.TILEHEIGHT, MapDisplayer.TILEWIDTH, MapDisplayer.TILEHEIGHT);
	}

	public void setPath(Path p2) {
		this.p = p2;
		repaint();
	}

	public void setColorPerTile(Function<Point, Color> cpt) {
		this.colorPerTile = cpt;
		repaint();
	}


}
