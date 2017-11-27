package myYam;

public class ControlYam {
	
	public static void main(String[] args) {
		Joueur j1 = new Joueur(1);
		Joueur j2 = new Joueur(2);
		int i = 13;
		while(i-- > 0) {
			j1.jouer();
		}
		i = 13;
		while(i-- > 0) {
			j2.jouer();
		}
		System.out.println(j1);
		System.out.println(j1);
	}
}
