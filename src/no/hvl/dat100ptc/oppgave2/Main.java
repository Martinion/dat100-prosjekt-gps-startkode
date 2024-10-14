package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class Main {

	
	public static void main(String[] args) {

		String tid = "2017-08-13T08:52:26.000Z";
		int sekund = GPSDataConverter.toSeconds(tid);
		System.out.println(sekund);
		
	}
}
