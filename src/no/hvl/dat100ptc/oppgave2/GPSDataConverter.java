package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSDataConverter {

	
	
	private static int TIME_STARTINDEX = 11; 

	public static int toSeconds(String timestr) {
		String tid = timestr;
		int secs;
		int hr, min, sec;
		
		hr = Integer.parseInt(tid.substring(11,13));
		min = Integer.parseInt(tid.substring(14,16));
		sec = Integer.parseInt(tid.substring(17,19));
		secs = hr*3600 + min * 60 + sec;
		// TODO
		return secs;
		
	}

	
	
	public static GPSPoint convert(String timeStr, String latitudeStr, String longitudeStr, String elevationStr) {
		int tid = toSeconds(timeStr);
		double lat = Double.parseDouble(latitudeStr);
		double longi = Double.parseDouble(longitudeStr);
		double høgde = Double.parseDouble(elevationStr);
		
		GPSPoint gpspoint = new GPSPoint(tid, lat, longi, høgde);
		return gpspoint;
		// TODO 
	
		
	}




	
}
