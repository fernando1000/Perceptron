package perceptron;

import java.util.Random;

public class PerceptronSimples {

	private float funcaoSoma(float entradas[], float pesos[]) {
		float rs = 0;
		for(int i=0; i<entradas.length; i++) {
			rs = rs + (entradas[i] * pesos[i]);
		}
		return rs;
	}
	private int funcaoDegrau(float resultadoDaSoma) {
		return (resultadoDaSoma >= 1)? 1:0;
	}
	private int calculaErro(int resultadoEsperado, int resultadoObtido) {
		return resultadoEsperado - resultadoObtido;
	}
	private float novoPeso(float pesoAtual, float taxaAprendizagem, float entrada, int erro) {
		return pesoAtual + (taxaAprendizagem * entrada * erro);
	}
	private float[] carregaPesosRandomicamente(float entradas[][]) {
		float nextFloat = new Random().nextFloat();
		float random = 0.01f + nextFloat * (0.4f - 0.01f);
		System.out.println("Peso inicial aleatório="+random);
		
		int qtd = entradas[0].length;
		float pesos[] = new float[qtd];
		for(int i=0; i<qtd; i++) {
			pesos[i] = random;
		}
		return pesos;
	}
	public float treinar(int epocas, int saidasEsperadas[], float entradas[][], float taxaAprendizagem) {
		
		float pesos[] = carregaPesosRandomicamente(entradas);
		
		for(int e=1; e<=epocas; e++) {
			System.out.println("Época atual="+e);
			for(int i=0; i<saidasEsperadas.length; i++) {
				
				float rs = funcaoSoma(entradas[i], pesos);
				
				int resultadoObtido = funcaoDegrau(rs);
				
				int erro = calculaErro(saidasEsperadas[i], resultadoObtido);
				if(erro > 0) {
					for(int j=0; j<pesos.length; j++) {
						float novoPeso = novoPeso(pesos[j], taxaAprendizagem, entradas[i][j], erro);
						System.out.println("novoPeso="+novoPeso+" para o valor="+entradas[i][j]);
						pesos[j] = novoPeso;
					}
				}
			}
		}
		return pesos[0];
	}
}
