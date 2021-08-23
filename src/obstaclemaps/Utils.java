package obstaclemaps;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

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

}
