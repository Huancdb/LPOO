package TDEUnidade2;

public class Bola {

	public static int vida = 3;
	private int posx, posy;

	public Bola(int posx, int posy) {
		super();
		this.posx = posx;
		this.posy = posy;

	}

	public int getPosx() {
		return posx;
	}

	public void setPosx(int posx) {
		this.posx = posx;
	}

	public int getPosy() {
		return posy;
	}

	public void setPosy(int posy) {
		this.posy = posy;
	}

	public static int getVida() {
		return vida;
	}

	@Override
	public String toString() {
		return "Bola [posx=" + posx + ", posy=" + posy + "]";
	}

	public boolean acerta(int x, int y) {

		boolean acertou = false;

		if ((this.posx == x) && (this.posy == y)) {

			acertou = true;

		}

		return acertou;

	}

}
