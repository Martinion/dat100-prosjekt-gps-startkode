package no.hvl.dat100ptc.oppgave1;

public class Main {

	public static void main(String[] args) {
		GPSPoint[] gps = new GPSPoint[1];
		gps[0] = new GPSPoint(1, 2.0, 3.0, 5.0);
		int time = gps[0].getTime();
		System.out.println(time);
		gps[0].setTime(2);
		System.out.println(gps[0].toString());
		
	}

}
