package fr.ecam;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;


public class TPJson {

	public void enrichirArbre() throws IOException {
		InputStream in = getClass().getResourceAsStream("contact.json");
		//lit le fichier dans une String, peu efficace mais suffisant pour notre exemple
		String data = new String(Files.readAllBytes(Paths.get("contact.json")));

		// crée un arbre depuis le flux JSON, dont la racine est le contact lu depuis le fichier json
		JSONObject root = new JSONObject(data);
				
		// recherche un attribut par son nom	
		System.out.println("Nom: " + root.getString("nom"));
		
		//TODO récupération du noeud adresses (tableau, de type JSONArray)
		
		// enrichissement de l'arbre JSON
		//TODO créer un nouvel objet de type JSONObject
		//ajouter les attributs type, ville et codePostal
		//ajouter cet élément au noeud adresses (via la méthode put)

		
		
		//TODO: affichager la liste d'adresses
		//via un iterator et une boucle while (cf cours slide 57)
		System.out.println("adresses: ");

		
		//TODO ajout au contact, d'un tableau de messages avec un message
		//créer JSONArray messages
		//l'ajouter à root sous le nom "messages"
		//créer un JSONObject message
		//y ajouter un attribut "texte" avec un texte quelconque
		//y ajouter un attribute "timestamp" avec la valeur: ew Date().toGMTString()
		//note: la méthode toGMTString() est deprecated, ça n'est pas grave pour cet exemple.
		
		
		
		
		
		//sauvegarde dans un nouveau fichier contact_mod.json à la racine du projet
		FileWriter fw = new FileWriter("contact_mod.json");
		root.write(fw,4,0);		
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
