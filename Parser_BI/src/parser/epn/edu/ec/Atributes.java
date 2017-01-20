package parser.epn.edu.ec;

import java.security.KeyStore.Entry.Attribute;
import java.util.Set;

public class Atributes {

	//atributos usados
	private String Adjetivo_1;
	private String Adjetivo_2;
	private String Verbo_1;
	private String Verbo_2;
	private String Negacion;
	private String Conector;
	private String Polaridad;
	
	
	public Atributes(){
		Adjetivo_1="?";
		Adjetivo_2="?";
		Verbo_1="?";
		Verbo_2="?";
		Negacion="?";
		Conector="?";
		Polaridad="?";
	}
	

	
	@Override
	   public boolean equals(Object obj){
		if (this == obj)
	         return true;
	      if (obj == null)
	         return false;
	      if (getClass() != obj.getClass())
	         return false;
	
		Atributes other = (Atributes) obj;
		
		
		
		return other.Adjetivo_1.equals(this.Adjetivo_1)&&other.Adjetivo_2.equals(this.Adjetivo_2)&&other.Verbo_1.equals(this.Verbo_1)&&
				other.Verbo_2.equals(this.Verbo_2)&&other.Negacion.equals(this.Negacion)&&other.Polaridad.equals(this.Polaridad)&&other.Conector.equals(this.Conector);
		
		
	}
	
	public static void printSet (Set<Atributes> elements){
		for(Atributes element : elements ){
			element.print();
		}	
	}
	
	public void print(){
		System.out.println(Adjetivo_1+","+Adjetivo_2+","+Verbo_1+","+Verbo_2+","+Negacion+","+Conector+","+Polaridad);
	}
	//atributos
	public String stringify(){
		return  Adjetivo_1+","+Adjetivo_2+","+Verbo_1+","+Verbo_2+","+Negacion+","+Conector+","+Polaridad;
	}
	
	public String getAdjetivo_1() {
		return Adjetivo_1;
	}
	public void setAdjetivo_1(String adjetivo_1) {
		Adjetivo_1 = adjetivo_1;
	}
	public String getAdjetivo_2() {
		return Adjetivo_2;
	}
	public void setAdjetivo_2(String adjetivo_2) {
		Adjetivo_2 = adjetivo_2;
	}
	public String getVerbo_1() {
		return Verbo_1;
	}
	public void setVerbo_1(String verbo_1) {
		Verbo_1 = verbo_1;
	}
	public String getVerbo_2() {
		return Verbo_2;
	}
	public void setVerbo_2(String verbo_2) {
		Verbo_2 = verbo_2;
	}
	public String getNegacion() {
		return Negacion;
	}
	public void setNegacion(String negacion) {
		Negacion = negacion;
	}
	public String getConector() {
		return Conector;
	}
	public void setConector(String conector) {
		Conector = conector;
	}
	public String getPolaridad() {
		return Polaridad;
	}
	public void setPolaridad(String polaridad) {
		Polaridad = polaridad;
	}
	
}
