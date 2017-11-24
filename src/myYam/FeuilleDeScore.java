package myYam;


public class FeuilleDeScore {
	private int [] score = new int[14];
	private boolean [] isfinish = new boolean[13];
	private String[] combinaison = new String[] {
			"1: Total de 1",
			"2: Total de 2",
			"3: Total de 3",
			"4: Total de 4",
			"5: Total de 5",
			"6: Total de 6",
			"7:Brelan(Total des 3 d¨¦s)",
			"8:Carr¨¦(Total des 4 d¨¦s)",
			"9:Full(25 points)",
			"10:Petite Suite(30 points)",
			"11:Grande Suite(40 points)",
			"12:Yams(50 points)",
			"13:Chance(Total des 5 d¨¦s)",
					};
	
	public FeuilleDeScore() {
		for(int i = 0; i < score.length; i++)
			score[i] = 0;
		for(int i = 0; i < isfinish.length; i++)
			isfinish[i] = false;
	}
	
	public int getTotalScore() {
		int n = 0;
		for(int i = 0; i < 6; i++)
			n += score[i];
		if (n > 63)
			score[6] = 35;
		else
			score[6] = 0;
		for(int i = 6; i < 14; i++)
			n += score[i];
		return n;
	}
	
	public String getCombinaison(int n) {
		return combinaison[n];
	}
	
	public boolean getIsFinish(int n) {
		return isfinish[n];
	}
	
	public void calculateCase(int n, Des []des, int indexofmax) {
		switch (n) {
		case 1:
			int total = 0;
			for(int i = 0; i < 5; i++) {
				if(des[i].getupface() == 1)
					total ++;
			}
			score[n-1] = total*1;
			isfinish[n-1] = true;
			break;
		case 2:
			total = 0;
			for(int i = 0; i < 5; i++) {
				if(des[i].getupface() == 2)
					total ++;
			}
			score[n-1] = total*2;
			isfinish[n-1] = true;
			break;
		case 3:
			total = 0;
			for(int i = 0; i < 5; i++) {
				if(des[i].getupface() == 3)
					total ++;
			}
			score[n-1] = total*3;
			isfinish[n-1] = true;
			break;
		case 4:
			total = 0;
			for(int i = 0; i < 5; i++) {
				if(des[i].getupface() == 4)
					total ++;
			}
			score[n-1] = total*4;
			isfinish[n-1] = true;
			break;
		case 5:
			total = 0;
			for(int i = 0; i < 5; i++) {
				if(des[i].getupface() == 5)
					total ++;
			}
			score[n-1] = total*5;
			isfinish[n-1] = true;
			break;
		case 6:
			total = 0;
			for(int i = 0; i < 5; i++) {
				if(des[i].getupface() == 6)
					total ++;
			}
			score[n-1] = total*6;
			isfinish[n-1] = true;
			break;
		case 7:
			score[n] = (indexofmax + 1) * 3;
			isfinish[n-1] = true;
			break;
		case 8:
			score[n] = (indexofmax + 1) * 4;
			isfinish[n-1] = true;
			break;
		case 9:
			score[n] = 25;
			isfinish[n-1] = true;
			break;
		case 10:
			score[n] = 30;
			isfinish[n-1] = true;
			break;
		case 11:
			score[n] = 40;
			isfinish[n-1] = true;
			break;
		case 12:
			score[n] = 50;
			isfinish[n-1] = true;
			break;
		case 13:
			total = 0;
			for(int i = 0; i < 5; i++) {
				total += des[i].getupface();
			}
			score[n] = total;
			isfinish[n-1] = true;
			break;
		default:
			break;
		}
	}
}
