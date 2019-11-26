package fr.diginamic.services;

import java.util.Comparator;

import fr.diginamic.aliments.Additif;

public class TrierAdditifPlusCourant implements Comparator<Additif>{

	public int compare(Additif o1, Additif o2) {
		if( o1.getNbrFoisPresent() < o2.getNbrFoisPresent()) return 1;
		if( o1.getNbrFoisPresent() > o2.getNbrFoisPresent()) return -1;
		return 0;
	}

}
