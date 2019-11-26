package fr.diginamic.services;

import java.util.Comparator;

import fr.diginamic.aliments.Produit;

public class TrierGradeNutritionnel implements Comparator<Produit>{

	public int compare(Produit o1, Produit o2) {
		if( o1.getGradeNutritionnel() > o2.getGradeNutritionnel()) return 1;
		if( o1.getGradeNutritionnel() < o2.getGradeNutritionnel()) return -1;	
		return 0;
	}
	

}
