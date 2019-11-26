package fr.diginamic.aliments;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;

import fr.diginamic.services.ComposantsExistant;
import fr.diginamic.services.TrierGradeNutritionnel;
import fr.diginamics.exceptions.FileNotFoundException;

public class Stock {
	private String					fileName;
	private ArrayList<Produit>		lstProduit;
	
	public  void chargerFichier( String fileName) throws FileNotFoundException, IOException {
		Produit 		produit;
		List<String>	lignes;
		
		// Ouvrir le fichier des données Open Food Facts
		File 	file = new File( fileName);
		if( !file.exists() ) {
			throw new FileNotFoundException( "Le fichier " + fileName + " n'existe pas");
		}
		
		// Charger la liste des existants
		lignes = FileUtils.readLines( file, "UTF-8");	
		ComposantsExistant.chargerExistant( lignes);
		
		
		// Charger la liste de Produits
		boolean enteteLu 	= false;
		for (String ligne: lignes){
			if( enteteLu) {
				produit = new Produit( ligne);
				this.lstProduit.add( produit);
			}
			else {
				enteteLu = true;
			}
		}
		System.out.println("Nombre de lignes :" + lignes.size());	
		
		// Trier les produits par qualité
		Collections.sort( this.lstProduit, new TrierGradeNutritionnel());

		
	}
	
	public Stock( String fileName) throws FileNotFoundException, IOException {
		this.fileName 	= fileName ;
		this.lstProduit = new ArrayList<Produit>();
		this.chargerFichier( fileName);
	}
	
	public String getFileName() {
		return fileName;
	}

	public ArrayList<Produit> getLstProduit() {
		return lstProduit;
	}



}
