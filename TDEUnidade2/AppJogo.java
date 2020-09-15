package TDEUnidade2;

import io.InOut;

public class AppJogo {

	public static void main(String[] args) {

		Bola[] bolas = new Bola[5];
		int posx, posy;
		int tiro = 10;

		cria(bolas);

		while (tiro > 0) {

			posx = InOut.leInt("Informe a posição x (1 a 5)");
			posy = InOut.leInt("Informe a posição y (1 a 5)");

			atira(bolas, posx, posy);

			// Caso acerte 3x, ganha.
			if (Bola.vida == 0) {
				System.out.println("You won!");
				break;
			}

			tiro--;
			System.out.println("Faltam " + tiro + " tentativas");

		}

		// Caso acabe as tentativas e vida maior que 0, perde.
		if (Bola.vida > 0) {
			System.out.println("GAME OVER");

		}
		for (int i = 0; i < bolas.length; i++) {
			System.out.println(bolas[i].toString());
		}
	}

	private static void cria(Bola[] bolas) {

		for (int i = 0; i < bolas.length; i++) {
			bolas[i] = new Bola(gerarNumAleatorio(1, 5), gerarNumAleatorio(1, 5));

			// Checar no vetor se as posições das bola repetem
			if (i > 0) {

				// Caso repita, gerar uma nova posicao e comparar com as existentes no vetor
				if (comparaPosBola(bolas, i)) {
					do {
						bolas[i].setPosx(gerarNumAleatorio(1, 5));
						bolas[i].setPosy(gerarNumAleatorio(1, 5));
						comparaPosBola(bolas, i);

					} while (comparaPosBola(bolas, i));

				}
			}

		}
	}

	private static int gerarNumAleatorio(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("Máximo menor que o mínimo");
		}

		return (int) (Math.random() * ((max - min) + 1)) + min;
	}

	private static void atira(Bola[] bolas, int x, int y) {

		boolean acertou = false;
		for (int i = 0; i < bolas.length; i++) {
			//Se acertou a posicao
			if (bolas[i].acerta(x, y)) {
				Bola.vida--;
				acertou = true;
				do {
					reporBola(bolas[i]);
					comparaPosBola(bolas, i);
				} while (comparaPosBola(bolas, i)); //enquanto a nova posicao ja existir no vetor
			}
		}
		if (acertou) {
			System.out.println("Acertou o alvo");
			System.out.println("Vida restante: " + Bola.vida);
		} else {

			System.out.println("Errou o alvo");
		}
	}

	private static void reporBola(Bola bola) {
		bola.setPosx(gerarNumAleatorio(1, 5));
		bola.setPosy(gerarNumAleatorio(1, 5));

	}

	private static boolean comparaPosBola(Bola[] bolas, int i) {
		boolean achou = false;
		
		//Roda o vetor e procura posicao igual
		for (int j = i - 1; j == 0; j--) {
			if ((bolas[i].getPosx() == bolas[j].getPosx()) && (bolas[i].getPosy() == bolas[j].getPosy())) {
				achou = true;

			}

		}
		return achou;
	}
}
