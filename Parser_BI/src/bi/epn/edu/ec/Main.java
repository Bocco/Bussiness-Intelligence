package bi.epn.edu.ec;

import java.io.IOException;
import java.security.KeyStore.Entry.Attribute;
import java.util.HashSet;
import java.util.Set;

import parser.epn.edu.ec.Atributes;
import parser.epn.edu.ec.FileManager;
import rita.RiLexicon;
import rita.RiTa;
import rita.support.RiDynamic;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path_to_file = "D:/training.txt";      			//Path para el archivo de entrenamiento
		String path_to_positive = "D:/positive_words_en.txt";	//Path para el archivo de palabras positivas
		String path_to_negative = "D:/negative_words_en.txt";	//Path para el archivo de palabras negativas
		String path_to_savefile = "D:/model.txt";				//Path para el modelo
		String path_to_adverbe = "D:/conectors_en.txt";			//Path de conectores
		if (args.length!=0){
			path_to_file=args[0];
		}
		
		//Apertura de los documentos
		FileManager fm = new FileManager(path_to_file);
		FileManager fm_pos = new FileManager(path_to_positive);
		FileManager fm_neg = new FileManager(path_to_negative);
		FileManager fm_adv = new FileManager(path_to_adverbe);
		Set<Atributes> lattributes = new HashSet<Atributes>();
		String [] file;
		String [] positivewords;
		String [] negativewords;
		String [] connectors;
		RiLexicon lexicon = new RiLexicon();
		try {
			file = fm.openFile();
			positivewords = fm_pos.openFile();
			negativewords = fm_neg.openFile();
			connectors = fm_adv.openFile();
			
			//Recorrido del file linea por linea
			for(String line : file){
				Atributes attr = new Atributes();
				String [] splited=line.split("\\t");
				//Definicion de la polaridad
				if(splited[0].equals("1"))
					attr.setPolaridad("pos");
				
				else
					attr.setPolaridad("neg");
				
				//Atributo negativo dentro de la clase
				if(splited[1].contains("not") || splited[1].contains("n't"))
					attr.setNegacion("yes");
				else
					attr.setNegacion("no");
				
				//Conectores de frase que posee 
				for(String connector : connectors){
					if(splited[1].contains(connector))
						attr.setConector(connector);
				}
				
				
				for(String word : RiTa.tokenize(RiTa.trimPunctuation(splited[1]))){
						//Busqueda de palabras positivas dentro del archivo
						for(String positive_word : positivewords){
							if(positive_word.equals(word)){
								if(lexicon.isAdjective(word)){
								attr.setAdjetivo_1(word);
								}
								if(lexicon.isVerb(word)){
								attr.setVerbo_1(word);
								}
							}
						}
						//Busqueda de palabras negativas dentro del archivo
						for(String negative_word : negativewords){
							if(negative_word.equals(word)){
								if(lexicon.isAdjective(word)){
									attr.setAdjetivo_2(word);
									}
									if(lexicon.isVerb(word)){
									attr.setVerbo_2(word);
									}
							}
						}
				
					//System.out.println("");
					
				}
			
				if(!check(attr, lattributes))
				lattributes.add(attr);
				
			}
				//Guardar a archivo
				fm.savingFile(path_to_savefile, lattributes);
			
			System.out.println("What its done it's done");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public String chechWordPositiveNegative(String word){
		
		return null;
	}
	
	public static Boolean check(Atributes element, Set<Atributes> elements){
		
		for(Atributes ele : elements){
			if(element.equals(ele)) return true;
			
		}
		
		return false;
	}
	
	public static void printSet (Set<Atributes> elements){
		for(Atributes element : elements ){
			element.print();
		}
		
		
	}
	
	
	

}
