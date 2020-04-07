package it.polito.tdp.anagramma.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Ricerca {

	private List<String> soluzione = new ArrayList<>();
	
	/**
	 * genera tutti gli anagrammi della parola specificata in ingresso
	 * @param string parola da anagrammare
	 * @return lista contenente tutti gli anagrammi della parola passata come parametro
	 */
	public List<String> anagrammi(String string) {
		
		List<Character> disponibili = new ArrayList<>();
		
		string = string.toUpperCase();
		
		for(int i=0; i<string.length(); i++) {
			disponibili.add(string.charAt(i));
		}
		
		cerca("",0,disponibili);
		
		return soluzione;
	}
	
	/**
	 * procedura dircorsiva per il calcolo dell'anagramma
	 * @param parziale parte iniziale dell'anagramma costruito fino ad ora;
	 * @param livello livello della ricorsione, sempre uguale a parziale.length
	 * @param disponibili insieme delle lettere non ancora utilizzate
	 */
	private void cerca(String parziale, int livello, List<Character> disponibili) {
		
		if(disponibili.size() == 0) {
			//guardo se sono nel caso terminale
			this.soluzione.add(parziale);
			
		}
		
		//caso normale
		//devo provare ad aggiungere alla soluzione parziale tutti i caratteri presenti tra i disponibili
		
		for(Character ch : disponibili) {
			String tentativo = parziale + ch;
			//costruisco un altra lista per poter eliminare il carattere usato e cosi lo posso passare di nuovo come parametro alla funzione ricorsiva
			List<Character> rimanenti = new ArrayList<>(disponibili);
			rimanenti.remove(ch);
			cerca(tentativo, livello+1,rimanenti);
		}
		
	}
	

}

/*
 *DATO DI PARTENZA: parola da anagrammare di lunghezza N
 *SOLUZIONE PARZIALE : una parte dell'anagramma gia costruito ( i primi caratteri)
 *LIVELLO : num lettere di cui è composta la soluzione parziale
 *SOLUZIONE FINALE : soluzione di lunghezza N -> CASO TERMINALE
 *CASO TERMINALE : salvare le soluzioni trovate!
 *GENERAZIONE NUOVE SOLUZIONI : provare ad aggiungere una lettera, scegliendola tra quelle che non sono ancora state utilizzate(nella soluzione parziale)
 * 
 */
