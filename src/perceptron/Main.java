package perceptron;

public class Main {
	
	public static void main(String... args) {
		
		int epocas = 6;
		
		float taxaAprendizagem = 0.1f;
		
		float entradas[][] = {{0.0f, 0.0f}, 
							  {0.0f, 1.0f}, 
							  {1.0f, 0.0f}, 
							  {1.0f, 1.0f}};
		
		int saidasEsperadas[] = {0, 0, 0, 1}; 

		float conhecimento = new PerceptronSimples().treinar(epocas, saidasEsperadas, entradas, taxaAprendizagem);
		System.out.println("conhecimento="+conhecimento);
	}
}
