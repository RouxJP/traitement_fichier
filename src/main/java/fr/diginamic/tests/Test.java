package fr.diginamic.tests;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class Test {

	public static void main(String[] args) {
		List<String> 	lignes = null;
		String[] 		tabDonnees;
		boolean 		enteteLu = false;
		File			file = null;
	
		try {
			file = new File("c:/tmp/open-food-facts.csv");
			lignes = FileUtils.readLines(file, "UTF-8");
			
			for (String ligne: lignes){
				System.out.println(ligne);
			}
			System.out.println("Nombre de lignes :" + lignes.size());
			
		}catch( IOException ie) {
			System.out.println( ie.getMessage());
		};
		
		try {
			lignes = FileUtils.readLines( file, "UTF-8");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		for (String ligne: lignes){
			if( enteteLu) {
				// Supprimer les [ ...] de liste
				System.out.println(ligne);				
				tabDonnees 			= ligne.split( ";");
				System.out.println(tabDonnees[0]);	
			}else {
				enteteLu = true;
			}
		}

	}

}
