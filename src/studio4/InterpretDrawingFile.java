package studio4;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;

import edu.princeton.cs.introcs.StdDraw;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class InterpretDrawingFile {

	public static void main(String[] args) throws FileNotFoundException {
		JFileChooser chooser = new JFileChooser("resources");
		chooser.showOpenDialog(null);
		File f = new File(chooser.getSelectedFile().getPath());
		Scanner in = new Scanner(f); //making Scanner with a File
		
		String shape = in.next();
		System.out.println(shape);
		
		int r = in.nextInt();
		int g = in.nextInt();
		int b = in.nextInt();
		
		Color color = new Color(r, g, b);
		StdDraw.setPenColor(color);
		StdDraw.setPenRadius(0.015);
		
		boolean filled = in.nextBoolean();
		
		if(shape.equals("ellipse")) {
			double x = in.nextDouble();
			double y = in.nextDouble();
			double semiMajorAxis = in.nextDouble();
			double semiMinorAxis = in.nextDouble();
			if (filled == true) {
				StdDraw.filledEllipse(x, y, semiMajorAxis, semiMinorAxis);
			}
			else {
				StdDraw.ellipse(x, y, semiMajorAxis, semiMinorAxis);
			}
		}
		else if (shape.equals("rectangle")) {
			double x = in.nextDouble();
			double y = in.nextDouble();
			double semiHalfWidth = in.nextDouble();
			double semiHalfHeight = in.nextDouble();
			if (filled == true) {
				StdDraw.filledRectangle(x, y, semiHalfWidth, semiHalfHeight);
			}
			else {
				StdDraw.rectangle(x, y, semiHalfWidth, semiHalfHeight);
			}
		}
		else if (shape.equals("triangle")) {
			double x1 = in.nextDouble();
			double y1 = in.nextDouble();
			double x2 = in.nextDouble();
			double y2 = in.nextDouble();
			double x3 = in.nextDouble();
			double y3 = in.nextDouble();
			if (filled == true) {
				double[] x = {x1, x2, x3};
				double[] y = {y1, y2, y3};
				StdDraw.filledPolygon(x, y);
			}
			else {
				double[] x = {x1, x2, x3};
				double[] y = {y1, y2, y3};
				StdDraw.polygon(x, y);
			}
		}
	}
}
