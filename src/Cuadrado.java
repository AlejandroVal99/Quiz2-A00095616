import processing.core.PApplet;

class Cuadrado implements Runnable{
	
	int posx,posy,r,g,b;
	PApplet app;
	boolean sigueH;
	private int direc;
	private int limitearr;
	private int limiteaba;

	public Cuadrado(int posx,int posy,int r,int g, int b, PApplet app) {
		
		this.posx= posx;
		this.posy = posy;
		this.r = r;
		this.g = g;
		this.b = b;
		this.app = app;
		this.sigueH = true; 
		this.direc = 5;
		this.limitearr = posy+100;
		this.limiteaba = posy-100;
		
	}

	
	public void run() {
		
		while(sigueH) {
			
			posy += direc;
			
			if(posy <= limiteaba || posy >= limitearr) {
				direc*=-1;
			}
			
			
		}
		
	}
	
	public void pintar() {
		app.fill(r,g,b);
		app.rect(posx,posy,100,100);
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


	public int getR() {
		return r;
	}


	public void setR(int r) {
		this.r = r;
	}


	public int getG() {
		return g;
	}


	public void setG(int g) {
		this.g = g;
	}


	public int getB() {
		return b;
	}


	public void setB(int b) {
		this.b = b;
	}


	public PApplet getApp() {
		return app;
	}


	public void setApp(PApplet app) {
		this.app = app;
	}


	public boolean isSigueH() {
		return sigueH;
	}


	public void setSigueH(boolean sigueH) {
		this.sigueH = sigueH;
	}

}
