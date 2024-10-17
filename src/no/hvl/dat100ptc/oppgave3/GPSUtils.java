package no.hvl.dat100ptc.oppgave3;

import static java.lang.Math.*;

import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.TODO;

public class GPSUtils {

	public static double findMax(double[] da) {

		double max; 
		
		max = da[0];
		
		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}
		
		return max;
	}

	public static double findMin(double[] da) {
		
		double min = da[0];  
		
		for (double d : da) {
			if (d < min) {
				min = d;
					}
		        }
		
		        return min;
	}

	 public static double[] getLatitudes(GPSPoint[] gpspoints) {
		 
	 double[] latitudes = new double[gpspoints.length];
	 
	    for (int i = 0; i < gpspoints.length; i++) {
	    	latitudes[i] = gpspoints[i].getLatitude();  
	        		    }
	     return latitudes;
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {

	double[] longitudes = new double[gpspoints.length];  
        
		for (int i = 0; i < gpspoints.length; i++) {
            longitudes[i] = gpspoints[i].getLongitude();  
						}
        return longitudes;
    }

	private static final int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double lat1 = toRadians(gpspoint1.getLatitude());
        double lon1 = toRadians(gpspoint1.getLongitude());
        double lat2 = toRadians(gpspoint2.getLatitude());
        double lon2 = toRadians(gpspoint2.getLongitude());
        
        double deltaLat = lat2 - lat1;
        double deltaLon = lon2 - lon1;
        
        double a = compute_a(lat1, lat2, deltaLat, deltaLon);
        double c = compute_c(a);

        return R * c;
	}
	
	private static double compute_a(double phi1, double phi2, double deltaphi, double deltadelta) {
	
		 return sin(deltaphi / 2) * sin(deltaphi / 2) +
	               cos(phi1) * cos(phi2) *
	               sin(deltadelta / 2) * sin(deltadelta / 2);
	}
	

	private static double compute_c(double a) {

		return 2 * atan2(sqrt(a), sqrt(1 - a));
    }

	
	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {
		
		 double distance = distance(gpspoint1, gpspoint2); 
	     int timeDifference = gpspoint2.getTime() - gpspoint1.getTime();  

	     return distance / timeDifference;  
	    }
	
	private static int TEXTWIDTH = 10;
	
	public static String formatTime(int secs) {

		  int hours = secs / 3600;  
	      int minutes = (secs % 3600) / 60;  
	      int seconds = secs % 60;  
	        
	      return String.format("%" + TEXTWIDTH + "s", String.format("%02d:%02d:%02d", hours, minutes, seconds));
	}
	
	public static String formatDouble(double d) {

		return String.format("%" + TEXTWIDTH + "s", String.format("%.2f", d));
	}
}
