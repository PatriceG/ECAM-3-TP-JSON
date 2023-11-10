package fr.ecam;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;

import org.json.simple.parser.ParseException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class TPJson {

	public void enrichirArbre() throws IOException, ParseException {
		InputStream in = getClass().getResourceAsStream("contact.json");
		JSONParser jsonParser = new JSONParser();
		
		// crée un arbre depuis le flux JSON
		JSONObject  root = (JSONObject)jsonParser.parse(new InputStreamReader(in));
				
		// recherche un attribut par son nom	
		System.out.println("Nom: " + root.get("nom"));
		
		//récupération du noeud adresses (tableau, de type JSONArray)
		JSONArray  adresses = (JSONArray)root.get("adresses");
		
		// enrichissement de l'arbre JSON
		//TODO créer un nouvel objet de type JSONObjct
		//ajouter les attributs type, ville et codePostal
		//ajouter cet élément au noeud adresses

		
		
		//affichage de la liste d'adresses
		System.out.println("adresses: ");
		Iterator iterator = adresses.iterator();
		while (iterator.hasNext()) {
			JSONObject adresse = (JSONObject) iterator.next();
			System.out.println("Type: " + adresse.get("type"));
			System.out.println("Ville: " + adresse.get("ville"));
			System.out.println("CodePostal: " + adresse.get("codePostal"));
		}
		
		
		//sauvegarde dans un nouveau fichier contact_mod.json à la racine du projet
		FileWriter fw = new FileWriter("contact_mod.json");
		fw.write(root.toJSONString());		
		fw.close();

	}

	public static void main(String[] args) {
		try {
			TPJson tp = new TPJson();
			tp.enrichirArbre();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
