package fr.diginamic.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.diginamic.aliments.Additif;
import fr.diginamic.aliments.Allergene;
import fr.diginamic.aliments.Ingredient;
/**
 * Optimisation de la place mémoire pour les ingredients, additifs, allergenes
 * @author acer
 *
 */
public class ComposantsExistant {
	static public Map<String, Ingredient>			lstIngredientExistant;
	static public Map<String, Allergene>			lstAllergeneExistant;
	static public Map<String, Additif>				lstAdditifExistant;
	
	public static void chargerExistant( List<String> lignes) {
		String[]		tabDonnees;
		String[]		tabIngredient;
		String			ligneIngredient;
		String[]		tabAllergene;
		String			ligneAllergene;
		String[]		tabAdditif;
		String			ligneAdditif;
		
		lstIngredientExistant 	= new HashMap<String, Ingredient>();
		lstAllergeneExistant 	= new HashMap<String, Allergene>();
		lstAdditifExistant 		= new HashMap<String, Additif>();

		boolean enteteLu = false;
		for (String ligne: lignes){
			if( enteteLu) {
				// Supprimer les [ ...] de liste
				tabDonnees 			= ligne.split( ";");
				
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
					if( ( curIngredient != null) 
						&& 
						( !curIngredient.trim().contentEquals( "") )){
							if( lstIngredientExistant.get( curIngredient.trim()) == null){
								lstIngredientExistant.put( curIngredient.trim(), 
														new Ingredient( curIngredient.trim()));
								
							}
					}
					
				}
				
				Allergene allergeneExistant ;
				Long		nbrAllergenePresent;
				for( String curAllergene : tabAllergene) {
					if( ( curAllergene != null) 
							&& 
							( !curAllergene.trim().contentEquals( "") )){
						if( lstAllergeneExistant.get( curAllergene.trim()) == null){
							lstAllergeneExistant.put( curAllergene.trim(), 
													new Allergene( curAllergene.trim()));
							
						}else {
							allergeneExistant = lstAllergeneExistant.get( curAllergene.trim());
							nbrAllergenePresent = allergeneExistant.getNbrFoisPresent() + 1 ;
							allergeneExistant.setNbrFoisPresent( nbrAllergenePresent);
							lstAllergeneExistant.put( curAllergene.trim(), allergeneExistant);
						}
						
					}
					
				}

				
				Additif additifExistant ;
				Long	nbrAdditifPresent;
				for( String curAdditif : tabAdditif) {
					if( ( curAdditif != null) 
							&& 
							( !curAdditif.trim().contentEquals( "") )){
						if( lstAdditifExistant.get( curAdditif.trim()) == null){
							lstAdditifExistant.put( curAdditif.trim(), 
													new Additif( curAdditif.trim()));
							
						}else {
							additifExistant = lstAdditifExistant.get( curAdditif.trim());
							nbrAdditifPresent = additifExistant.getNbrFoisPresent() + 1 ;
							additifExistant.setNbrFoisPresent( nbrAdditifPresent);
							lstAdditifExistant.put( curAdditif.trim(), additifExistant);
						}
						
					}
				}
			
			}else {
				enteteLu = true;
			}
			
		}
		System.out.println( "Taille lstIngredientExistant : " + lstIngredientExistant.size());
		System.out.println( "Taille lstAllergeneExistant : " + lstAllergeneExistant.size());
		System.out.println( "Taille lstAdditifExistant : " + lstAdditifExistant.size());
	
		
	}

}
