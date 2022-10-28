package app.model;

public class Coup {

	private Position pos;


	public Coup(Position posDepart) {
		this.pos = posDepart;
	}

	public Position getPos() {
		return pos;
	}

	public void setPosDepart(Position pos) {
		this.pos = pos;
	}


	@Override
	public String toString() {
		return "Coup [pos=" + pos +"]";
	}

	
}
