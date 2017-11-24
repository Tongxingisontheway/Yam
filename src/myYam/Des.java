package myYam;
import java.util.Random;

public class Des {
	private int id;
	final int []face = {1,2,3,4,5,6};	
	private int up;
	
	public Des(int id) {
		this.id = id;
	}
	public void lancer() {
		Random random = new Random();
		int index = Math.abs(random.nextInt())%6;
		up = face[index];
	}
	
	public int getupface() {
		return up;
	}
	
	public String toString() {
		return "Le d¨¦ " + id + " est " + up;
	}
	
}

