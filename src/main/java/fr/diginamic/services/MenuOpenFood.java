package fr.diginamic.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import fr.diginamic.aliments.Additif;
import fr.diginamic.aliments.Allergene;
import fr.diginamic.aliments.Produit;
import fr.diginamic.aliments.Stock;

public class MenuOpenFood {
	
	public static Scanner getInitOpenFoodFacts( Stock stock) {
		Scanner	sc 		= new Scanner( System.in);
		return sc;
	}
	
	public static void afficherMenu() {
		System.out.println("Menu de l'application Open Food Facts : ");
		System.out.println(" - 1 : Rechercher les meilleurs produits pour une Marque");
		System.out.println(" - 2 : Rechercher les meilleurs produits pour une Catégorie");
		System.out.println(" - 3 : Rechercher les meilleurs produits pour une Marque et catégorie");
		System.out.println(" - 4 : Afficher les allergènes les plus courants.");
		System.out.println(" - 5 : Afficher les additifs les plus courants.");
		System.out.println(" - 9 : Sortir.");
	}
	/**
	 * Afficher les 20 meilleurs produits par marque
	 * @param sc
	 * @param stock
	 */
	public static void afficherMeilleursProduitsParMarque( Scanner sc, Stock stock) {
		String	nomMarque;
		System.out.println("Saisir la marque ( sans les blancs) : ");
		
		nomMarque = sc.next();
		
		System.out.println("Les 20 meilleurs produits de la marque " + nomMarque + " sont : ");
		int i = 0;
		String	nomMarqueSansBlanc;
		for( Produit produit : stock.getLstProduit()) {
			nomMarqueSansBlanc = produit.getMarque().getNom().replace(" ", "");
			if(nomMarqueSansBlanc.equalsIgnoreCase( nomMarque) ) {
				System.out.println( " - " + produit.getNomProduit());
				i++;
			}
			if( i == 20) break;
		}
	}
	/**
	 * Afficher les 20 meilleurs produits par catégorie
	 * @param sc
	 * @param stock
	 */
	public static void afficherMeilleursProduitsParCategorie( Scanner sc, Stock stock) {
		String	nomCategorie;
		System.out.println("Saisir la catégorie ( sans les blancs): ");
		
		nomCategorie = sc.next();
		
		System.out.println("Les 20 meilleurs produits de la catégorie " + nomCategorie + " sont : ");
		int 	i = 0;
		String	nomCategorieSansBlanc;
		for( Produit produit : stock.getLstProduit()) {
			nomCategorieSansBlanc = produit.getCategorie().getLibelle().replace(" ", "");
			if( nomCategorieSansBlanc.equalsIgnoreCase( nomCategorie)) {
				System.out.println( " - " + produit.getNomProduit());
				i++;
			}
			if( i == 20) break;
		}
		
	}
	/**
	 * Afficher les 20 meilleurs produits par marque et catégorie
	 * @param sc
	 * @param stock
	 */
	public static void afficherMeilleursProduitsParMarqueEtCategorie(Scanner sc, Stock stock) {
		String	nomMarque;
		String	nomCategorie;
		
		System.out.println("Saisir la marque ( sans les blancs) : ");
		nomMarque = sc.next();
		System.out.println("Saisir la catégorie ( sans les blancs): ");
		nomCategorie = sc.next();
		
		System.out.println("Les 20 meilleurs produits de " + nomMarque  + " / " + nomCategorie +  " sont : ");
		int 	i = 0;
		String	nomCategorieSansBlanc;
		String	nomMarqueSansBlanc;
		for( Produit produit : stock.getLstProduit()) {
			nomCategorieSansBlanc = produit.getCategorie().getLibelle().replace(" ", "");
			if( nomCategorieSansBlanc.equalsIgnoreCase( nomCategorie)) {
				nomMarqueSansBlanc = produit.getMarque().getNom().replace(" ", "");
				if(nomMarqueSansBlanc.equalsIgnoreCase( nomMarque) ) {
					System.out.println( " - " + produit.getNomProduit());
					i++;
				}
			}
			if( i == 20) break;
		}

		
	}
	/**
	 * Afficher les 20 Allerges les plus courant
	 */
	public static void afficherAllergenesLesPlusCourant() {
		List<Allergene> lstAllergeneTriee = new ArrayList<Allergene>();
		for( String key : ComposantsExistant.lstAllergeneExistant.keySet()) {
			lstAllergeneTriee.add( ComposantsExistant.lstAllergeneExistant.get(key));
		}
		Collections.sort( lstAllergeneTriee, new TrierAllergenePlusCourant());
		int i = 0;
		for( Allergene allergene : lstAllergeneTriee) {
			System.out.println( allergene.getLibelle() + " present " + allergene.getNbrFoisPresent());
			i++;
			if( i == 20) break;
		}
		
	}
	/**
	 * Afficher les 20 Additifs les plus courant
	 */
	public static void afficherAdditifsLesPlusCourant() {
		List<Additif> lstAdditifTriee = new ArrayList<Additif>();
		for( String key : ComposantsExistant.lstAdditifExistant.keySet()) {
			lstAdditifTriee.add( ComposantsExistant.lstAdditifExistant.get(key));
		}
		Collections.sort( lstAdditifTriee, new TrierAdditifPlusCourant());
		int i = 0;
		for( Additif additif : lstAdditifTriee) {
			System.out.println( additif.getLibelle() + " present " + additif.getNbrFoisPresent());
			i++;
			if( i == 20) break;
		}

	}


}
