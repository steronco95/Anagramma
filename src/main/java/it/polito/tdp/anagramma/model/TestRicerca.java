package it.polito.tdp.anagramma.model;

import java.util.ArrayList;
import java.util.List;

public class TestRicerca {

	public static void main(String[] args) {
		Ricerca ric = new Ricerca() ;
		
		List<String> ana_dog = ric.anagrammi("dog") ;
		System.out.println(ana_dog) ;
		
		System.out.println("\n");
		
		Ricerca ric1 = new Ricerca();
		
		List<String> ana_vac = new ArrayList<>(); 
		ana_vac = ric1.anagrammi("vacanzevwe") ;
		for(String s : ana_vac) {
			System.out.println(s);
		}
//		System.out.println(ana_vac) ;
		
		
	}

}
