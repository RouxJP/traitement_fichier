package fr.diginamic.aliments;


import java.util.HashSet;
import java.util.Set;

import fr.diginamic.services.ComposantsExistant;

public class Produit {
	private	String						nomProduit;
	private Categorie					categorie;
	private Marque						marque;
	private char						gradeNutritionnel; // a à f
	private Set<Ingredient>				lstIngredient ;
	private Set<Allergene>				lstAllergene ;
	private Set< Additif>				lstAdditif ;
	
	public Produit( String ligne) {
		String[] 	tabDonnees ;
		String[]	tabIngredient;
		String		ligneIngredient;
		String[]	tabAllergene;
		String		ligneAllergene;
		String[]	tabAdditif;
		String		ligneAdditif;
		Ingredient  ingredient;
		Allergene  	allergene;
		Additif  	additif;
		
		categorie 			= new Categorie();
		marque				= new Marque();
		gradeNutritionnel 	= ' '; 							// a à f
		lstIngredient 		= new HashSet<Ingredient>();
		lstAllergene 		= new HashSet<Allergene>();
		lstAdditif 			= new HashSet<Additif>();
		
		tabDonnees = ligne.split( ";");

		this.setNomProduit( tabDonnees[ 0].replace( "\"", ""));
		setGradeNutritionnel( tabDonnees[ 1].charAt(0));
		categorie.setLibelle( tabDonnees[ 2]);
		marque.setNom(tabDonnees[ 3]);
		
		if( tabDonnees[4].length() >= 2) {
			ligneIngredient 	= tabDonnees[4].substring( 1, tabDonnees[4].length()-1);
		}else {
			ligneIngredient 	= "" ;
		}
		tabIngredient		= ligneIngredient.split( ",");
		
		if( tabDonnees[30].length() >= 2) {
			ligneAllergene 		= tabDonnees[30].substring( 1, tabDonnees[30].length()-1);
		}else {
			ligneAllergene      = "";
		}
		tabAllergene		= ligneAllergene.split( ",");
		
		if( tabDonnees[31].length() >= 2) {
			ligneAdditif 		= tabDonnees[31].substring( 1, tabDonnees[31].length()-1);
		}else {
			ligneAdditif		= "" ;
		}
		tabAdditif			= ligneAdditif.split( ",");
			
		for( String curIngredient : tabIngredient) {
			ingredient = ComposantsExistant.lstIngredientExistant.get(curIngredient.trim());
			this.lstIngredient.add( ingredient);
		}
		for( String curAllergene : tabAllergene) {
			allergene = ComposantsExistant.lstAllergeneExistant.get(curAllergene.trim());
			this.lstAllergene.add( allergene);
		}
		for( String curAdditif : tabAdditif) {
			additif = ComposantsExistant.lstAdditifExistant.get(curAdditif.trim());
			this.lstAdditif.add( additif);
		}
		
	}

	public char getGradeNutritionnel() {
		return gradeNutritionnel;
	}

	public void setGradeNutritionnel(char gradeNutritionnel) {
		this.gradeNutritionnel = gradeNutritionnel;
	}

	public Categorie getCategorie() {
		return categorie;
	}


	public Marque getMarque() {
		return marque;
	}

	public String getNomProduit() {
		return nomProduit;
	}

	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}


}
