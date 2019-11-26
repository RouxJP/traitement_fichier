package fr.diginamic.tests;

import java.io.IOException;
import java.util.Scanner;

import fr.diginamic.aliments.Stock;
import fr.diginamic.services.MenuOpenFood;
import fr.diginamics.exceptions.FileNotFoundException;

public class ApplicationOpenFoodFacts {

	public static void main(String[] args) {
		Stock stock = null;
		try {
			// J'ai changé les séparateurs "|" par des ";" dans le fichier ci-dessous
			stock = new Stock( "c:/tmp/open-food-facts.csv");
		} catch (FileNotFoundException e) {
			e.getMessage();
		} catch (IOException e) {
			e.getMessage();
		}
		
		Scanner sc = MenuOpenFood.getInitOpenFoodFacts( stock);
		
		Integer 	menu 		= 0;
		String		choixMenu 	= null;
		while( menu  != 9) {
			MenuOpenFood.afficherMenu();
			choixMenu = sc.next();
			try {
				menu = Integer.valueOf( choixMenu);
			}catch( NumberFormatException e) {
				menu = 0;
			}
			switch( menu ){
				case 0 :
					System.out.println( "Saisir un menu valide ( 1..9)");
				break;
				case 1 :
					MenuOpenFood.afficherMeilleursProduitsParMarque( sc, stock);
				break;
				case 2 :
					MenuOpenFood.afficherMeilleursProduitsParCategorie( sc, stock);
				break;
				case 3 :
					MenuOpenFood.afficherMeilleursProduitsParMarqueEtCategorie(sc, stock);
				break;
				case 4 :
					MenuOpenFood.afficherAllergenesLesPlusCourant();
				break;
				case 5 :
					MenuOpenFood.afficherAdditifsLesPlusCourant();
				break;
				case 9 :
					System.out.println( " Au revoir !!");
				break;
					
			}
			
		}
		sc.close();

	}

}
