package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class Main {

	
	public static void main(String[] args) {
		GPSData gpsdata = new GPSData(2);
		GPSPoint[] gpspoint = new GPSPoint[2];
		GPSPoint gpspoint1 = new GPSPoint(1, 2.5, 3.6, 4.3);
		GPSPoint gpspoint2 = new GPSPoint(2, 4.5, 6.9, 9.3);
		
		gpsdata.insertGPS(gpspoint1);
		gpsdata.insertGPS(gpspoint2);
		
		gpsdata.print();
	}
}
