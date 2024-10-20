package no.hvl.dat100ptc.oppgave5;

import javax.swing.JOptionPane;

import easygraphics.EasyGraphics;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave3.GPSUtils;
import no.hvl.dat100ptc.oppgave4.GPSComputer;
import java.util.concurrent.TimeUnit;

import no.hvl.dat100ptc.TODO;

public class ShowRoute extends EasyGraphics {

	private static int MARGIN = 50;
	private static int MAPXSIZE = 800;
	private static int MAPYSIZE = 800;

	private GPSPoint[] gpspoints;
	private GPSComputer gpscomputer;
	
	private double minlon, minlat, maxlon, maxlat;

	private double xstep, ystep;
	
	public ShowRoute() {

		String filename = JOptionPane.showInputDialog("GPS data filnavn: ");
		gpscomputer = new GPSComputer(filename);

		gpspoints = gpscomputer.getGPSPoints();

	}

	public static void main(String[] args) {
		launch(args);
	}

	public void run() {

		makeWindow("Route", MAPXSIZE + 2 * MARGIN, MAPYSIZE + 2 * MARGIN);

		minlon = GPSUtils.findMin(GPSUtils.getLongitudes(gpspoints));
		minlat = GPSUtils.findMin(GPSUtils.getLatitudes(gpspoints));

		maxlon = GPSUtils.findMax(GPSUtils.getLongitudes(gpspoints));
		maxlat = GPSUtils.findMax(GPSUtils.getLatitudes(gpspoints));
		
		xstep = scale(MAPXSIZE, minlon, maxlon);
		ystep = scale(MAPYSIZE, minlat, maxlat);
		
		showStatistics();
		
		showRouteMap(MARGIN + MAPYSIZE);

		replayRoute(MARGIN + MAPYSIZE);
	}

	public double scale(int maxsize, double minval, double maxval) {

		double step = maxsize / (Math.abs(maxval - minval));

		return step;
	}

	public void showRouteMap(int ybase) {

		setColor(0,0,255);
		for(GPSPoint coord : gpspoints)
		{
			fillCircle(MARGIN + (int) (xstep * (coord.getLongitude()-minlon)), ybase - (int) (ystep * (coord.getLatitude()-minlat)), 4);
		}
		
	}

	public void showStatistics() {

		int TEXTDISTANCE = 20;

		setColor(0,0,0);
		setFont("Courier",12);
		
		int time = gpscomputer.totalTime();
		
		drawString(String.format("Total Time:             %02d:%02d:%02d", time / 3600, (time%3600)/60, time%60) , MARGIN, TEXTDISTANCE);
		drawString(String.format("Total Distance:      %.2f km",  gpscomputer.totalDistance()/1000), MARGIN, TEXTDISTANCE*2);
		drawString(String.format("Total Elevation:      %.2f m",  gpscomputer.totalElevation()), MARGIN, TEXTDISTANCE*3);
		drawString(String.format("Max Speed:             %.2f km/t",  gpscomputer.maxSpeed()*3.6), MARGIN, TEXTDISTANCE*4);
		drawString(String.format("Average Speed:     %.2f km/t",  gpscomputer.averageSpeed()*3.6), MARGIN, TEXTDISTANCE*5);
		drawString(String.format("Calories burned:   %.2f kcal",  gpscomputer.totalKcal(135)), MARGIN, TEXTDISTANCE*6);
		
	}

	public void replayRoute(int ybase) {
		
		int id = fillCircle(MARGIN + (int) (xstep * (gpspoints[0].getLongitude()-minlon)), ybase - (int) (ystep * (gpspoints[0].getLatitude()-minlat)), 6);
		setColor(0,0,255);
		setSpeed(2);
		for(GPSPoint coord : gpspoints)
		{
			moveCircle(id, MARGIN + (int) (xstep * (coord.getLongitude()-minlon)), ybase - (int) (ystep * (coord.getLatitude()-minlat)));
		}
		
	}

}
