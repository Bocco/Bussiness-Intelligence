package parser.epn.edu.ec;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

public class FileManager {
	
	
	private String path;
	
	public FileManager(String path){
		this.path=path;
	}
	//guarda el archivo
	public void savingFile(String path, Set<Atributes> attrs) throws IOException{
		File file =new File(path);
  	  if(!file.exists()){
  	 	file.createNewFile();
  	  }
  	  FileWriter fw = new FileWriter(file,true);
  	  BufferedWriter bw = new BufferedWriter(fw);
  	  PrintWriter pw = new PrintWriter(bw);
  	  
  	  for(Atributes attr : attrs){
  		  pw.println(attr.stringify());
  	  }
  	  pw.close();
	}
	
	//abre el archivo
	public String[] openFile() throws IOException{
		FileReader fr = new FileReader(path);
		BufferedReader textReader = new BufferedReader(fr);
		int lineas = countlines();
		String[] textData = new String[lineas];
		int i;
		for(i = 0 ; i<lineas; i++){
			textData[i] = textReader.readLine();
		}
		textReader.close();
		return textData;
	}
	
	//cuenta las lineas
	public int countlines(){
		BufferedReader reader;
		int lines = 0;
		try {
			reader = new BufferedReader(new FileReader(path));
			while (reader.readLine() != null) lines++;
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lines;
	}

}
