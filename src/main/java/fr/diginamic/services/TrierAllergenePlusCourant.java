package fr.diginamic.services;

import java.util.Comparator;

import fr.diginamic.aliments.Allergene;

public class TrierAllergenePlusCourant implements Comparator <Allergene> {

	public int compare(Allergene o1, Allergene o2) {
		if( o1.getNbrFoisPresent() < o2.getNbrFoisPresent()) return 1 ;
		if( o1.getNbrFoisPresent() > o2.getNbrFoisPresent()) return -1 ;
		return 0;
	}

}
