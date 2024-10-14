package no.hvl.dat100ptc.oppgave1;

import no.hvl.dat100ptc.TODO;

public class GPSPoint {

	// TODO - objektvariable
	private int tid;
	private double lat;
	private double longi;
	private double høgde;
	
	public GPSPoint(int time, double latitude, double longitude, double elevation) {

		tid = time;
		lat = latitude;
		longi = longitude;
		høgde = elevation;
		
	}

	// TODO - get/set metoder
	public int getTime() {
		return tid;
	}

	public void setTime(int time) {
		tid = time;
	}

	public double getLatitude() {
		return lat;
	}

	public void setLatitude(double latitude) {
		lat = latitude;
	}

	public double getLongitude() {
		return longi;
	}

	public void setLongitude(double longitude) {
		longi = longitude;
	}

	public double getElevation() {
		return høgde;
	}

	public void setElevation(double elevation) {
		høgde = elevation;
	}
	
	public String toString() {
		
		String str = (tid +" (" + lat + "," + longi + ") " + høgde + "\n");
		return str;
		

		// TODO
		
	}
}
