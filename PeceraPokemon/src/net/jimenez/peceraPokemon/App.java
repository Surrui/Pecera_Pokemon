package net.jimenez.peceraPokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import acm.graphics.GImage;
import acm.program.GraphicsProgram;

/**
 * 
 * @author Surrui
 *
 */
public class App extends GraphicsProgram {

	private static final long serialVersionUID = 4266158358432665610L;
	private static final int TOTAL_PEIXOS = 60;
	private static final int TOTAL_TORTUGUES = 6;
	private static final int TOTAL_TAURONS = 4;
	private static final int TOTAL_POPS = 6;
	private static final int TOTAL_DOFINS = 10;
	private static final int TOTAL_ESTRELLES = 14;
	private static final int PEIXERA_AMP = 1900;
	private static final int PEIXERA_ALT = 940;
	private static final int[] DIRECCIO = {0, 90, 180, 270};
	private static final int[] DIAGONAL = {45, 135, 225, 315};
	List<Animal> Animals = new ArrayList<Animal>();
	Random rnd = new Random();

	/**
	 * Metode on creem variables que no variaran mentre fem servir el programa.
	 */
	public void init() {

		setSize(PEIXERA_AMP, PEIXERA_ALT);
		GImage fons = new GImage("fondo.jpg");
		fons.setSize(PEIXERA_AMP, PEIXERA_ALT);
		add(fons);

	}

	/**
	 * Metode principal del programa, on creem tots els objectes.
	 */
	public void run() {
		
		totalAnimals();

		Peixera peixera = new Peixera(Animals, this);
		boolean noAnimals = peixera.inici();

		if (noAnimals) {
			GImage fi = new GImage("fi.png");
			fi.setLocation(((getWidth()/2)-(fi.getWidth()/2)), ((getHeight()/2)-(fi.getHeight()/2)));
			add(fi);
		}
	}

	private void totalAnimals() {
		
		for (int i = 0; i < TOTAL_ESTRELLES; i++) {
			Animals.add(crearEstrella("asexual"));
		}
		for (int i = 0; i < TOTAL_DOFINS; i++) {

			if (i < (TOTAL_DOFINS / 2)) {
				Animals.add(crearDofi("mascle"));

			} else {
				Animals.add(crearDofi("femella"));
			}
		}
		for (int i = 0; i < TOTAL_POPS; i++) {
			Animals.add(crearPop());
		}
		for (int i = 0; i < TOTAL_PEIXOS; i++) {

			if (i < (TOTAL_PEIXOS / 2)) {
				Animals.add(crearPeix("mascle"));

			} else {
				Animals.add(crearPeix("femella"));
			}
		}
		for (int i = 0; i < TOTAL_TAURONS; i++) {

			if (i < (TOTAL_TAURONS / 2)) {
				Animals.add(crearTauro("mascle"));

			} else {
				Animals.add(crearTauro("femella"));
			}
		}
		for (int i = 0; i < TOTAL_TORTUGUES; i++) {

			if (i < (TOTAL_TORTUGUES / 2)) {
				Animals.add(crearTortuga("mascle"));

			} else {
				Animals.add(crearTortuga("femella"));
			}
		}
	}

	/**
	 * Metode que s'encarrega de crear objectes Tauro, als quals els hi dona la
	 * direcció del moviment, la GImage i un String amb el seu sexe.
	 * 
	 * @param sexe
	 *            String que dona el sexe al objecte Tauro.
	 * @return
	 */
	public Animal crearTauro(String sexe) {

		int pos = rnd.nextInt(4);
		int angle = DIRECCIO[pos];
		
		GImage img;

		if (sexe.equals("mascle")) {
			img = new GImage("Sharpedo.png");
			add(img);
		} else {
			img = new GImage("S_Sharpedo.png");
			add(img);
		}

		Tauro T = new Tauro(img, sexe, angle);

		if(pos > 1){
			T.flipHorizontal();
		}
		
		return T;
	}

	/**
	 * Metode que s'encarrega de crear objectes Peix_Fantasma, als quals els hi
	 * dona la direcció del moviment, la GImage i un String amb el seu sexe.
	 * 
	 * @param sexe
	 *            String que dona el sexe al objecte Peix_Fantasma.
	 * @return
	 */
	public Peix crearPeix(String sexe) {

		int pos = rnd.nextInt(4);
		int angle = DIRECCIO[pos];
		
		GImage img;

		if (sexe.equals("mascle")) {
			img = new GImage("Magikarp.png");
			add(img);
		} else {
			img = new GImage("S_Magikarp.png");
			add(img);
		}

		Peix P = new Peix(img, sexe, angle);
		
		if(pos > 1){
			P.flipHorizontal();
		}
		
		return P;
	}

	public Tortuga crearTortuga(String sexe) {

		int pos = rnd.nextInt(4);
		int angle = DIRECCIO[pos];
		
		GImage img;

		if (sexe.equals("mascle")) {
			img = new GImage("Tirtouga.png");
			add(img);
		} else {
			img = new GImage("S_Tirtouga.png");
			add(img);
		}

		Tortuga T = new Tortuga(img, sexe, angle);
		
		if(pos > 1){
			T.flipHorizontal();
		}
		
		return T;
	}
	
	public Pop crearPop() {

		GImage img;

		img = new GImage("Octillery.png");
		add(img);

		Pop P = new Pop(img, "asexual", 90);
		
		return P;
	}

	public Animal crearDofi(String sexe) {
		int pos = rnd.nextInt(4);
		int angle = DIAGONAL[pos];
		
		GImage img;

		if (sexe.equals("mascle")) {
			img = new GImage("Lanturn.png");
			add(img);
		} else {
			img = new GImage("S_Lanturn.png");
			add(img);
		}

		Dofi D = new Dofi(img, sexe, angle);
		
		if(pos == 1 || pos == 2){
			D.flipHorizontal();
		}
		
		return D;
	}
	public Animal crearEstrella(String sexe) {
		int pos = rnd.nextInt(4);
		int angle = DIAGONAL[pos];
		
		GImage img;

		img = new GImage("Staryu.png");
		add(img);
		

		Estrella E = new Estrella(img, sexe, angle);
		
		if(pos == 1 || pos == 2){
			E.flipHorizontal();
		}
		
		return E;
	}
}
