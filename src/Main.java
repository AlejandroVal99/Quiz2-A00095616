import java.util.*;

import Exceptions.CuadradoTocado;
import processing.core.PApplet;

public class Main extends PApplet {

	Cuadrado mapa[][] = new Cuadrado[4][6];

	boolean mensajeExp = false;

	boolean muevoCuadro = false;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("Main");
	}

	public void settings() {
		size(600, 400);

	}

	public void setup() {

		llenarMapa();
		
		/*profe nunca lo corri pero espero funciones cuando vos lo hagas, se hizo lo que se pudo*/

	}

	public void draw() {
		background(255);
		pintarMapa();

		if (mensajeExp == true) {
			fill(0, 80, 255);
			textSize(15);
			text("Este hilo ya no esta disponible", 120, 220);
		}
	}

	public void mousePressed() {

		if (muevoCuadro == false) {
			muevoCuadro = true;
		}
		if (mensajeExp == true) {
			mensajeExp = false;
		}

		try {
			validarClick();
		} catch (CuadradoTocado e) {
			mensajeExp = true;
		}

	}

	public void validarClick() throws CuadradoTocado {

		for (int columnas = 0; columnas < 4; columnas++) {

			for (int filas = 0; filas < 6; filas++) {
				if (mouseX >= mapa[columnas][filas].getPosx() && mouseX <= (mapa[columnas][filas].getPosx() + 100)
						&& (mouseY >= mapa[columnas][filas].getPosy()
								&& mouseY <= (mapa[columnas][filas].getPosy() + 100))) {

					if (mapa[columnas][filas].getR() == 0) {

						mapa[columnas][filas].setSigueH(false);
						mapa[columnas][filas].setR(255);
						mapa[columnas][filas].setG(0);
						mapa[columnas][filas].setB(0);

					} else if (mapa[columnas][filas].getR() == 255 && mapa[columnas][filas].getG() == 0) {
						throw new CuadradoTocado("Ya has tocado este caudrado");
					}

				}

			}

		}

	}

	public void pintarMapa() {

		for (int columnas = 0; columnas < 4; columnas++) {

			for (int filas = 0; filas < 6; filas++) {

				mapa[columnas][filas].pintar();

				if (muevoCuadro == true) {
					Thread nuevoH = new Thread(mapa[columnas][filas]);
					nuevoH.start();
				}

			}
		}

	}

	public void llenarMapa() {

		for (int columnas = 0; columnas < 6; columnas++) {

			for (int filas = 0; filas < 4; filas++) {

				if (filas % 2 == 0) {
					// System.out.println("entre");
					if (columnas % 2 == 0) {
						mapa[filas][columnas] = new Cuadrado(100 * columnas, 100 * filas, 0, 0, 0, this);
						// System.out.println(mapa[columnas][filas].getPosx());
					} else {
						mapa[filas][columnas] = new Cuadrado(100 * columnas, 100 * filas, 255, 255, 255, this);
					}
				} else {

					if (columnas % 2 != 0) {
						mapa[filas][columnas] = new Cuadrado(100 * columnas, 100 * filas, 0, 0, 0, this);
						// System.out.println(mapa[columnas][filas].getPosx());
					} else {
						mapa[filas][columnas] = new Cuadrado(100 * columnas, 100 * filas, 255, 255, 255, this);
					}

				}
			}
		}

	}

}
