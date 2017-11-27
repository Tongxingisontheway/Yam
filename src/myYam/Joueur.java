package myYam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Joueur {
	private int id;
	private FeuilleDeScore feuilleDeScore = new FeuilleDeScore();
	private Des [] des = new Des[] {
				new Des(1),
				new Des(2),
				new Des(3),
				new Des(4),
				new Des(5),
	};
	public Joueur(int id) {
		this.id = id;
	}
	public void jouer() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in); //输入流控制（输入int）
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //输入流控制（输入String）
		int wantChange;	// 控制是否重新摇骰子
		int timeofchange = 2; // 控制重新摇骰子的次数
		List<Integer> change = new ArrayList<Integer>(); // 存放要重新摇的骰子的编号
		
		int [] count = { 0, 0, 0, 0, 0, 0}; // 存放骰子信息
		int maxofcount = 0;
		int indexofmax = 0;
		int minofcount = 6;
		
		boolean isPetiteSuite = false;
		boolean isGrandeSuite = false;
		boolean haveCase = false;
		
		for(int i = 0; i < 5; i ++)
			des[i].lancer();
		for(int i = 0; i < des.length; i++)
			System.out.println(des[i]);
		while(timeofchange > 0) {
			System.out.println("Est-ce que vous voulez reprendre un(des) dé(s)? saisir 1 pour 'oui' et 0 pour 'non': ");
			wantChange = sc.nextInt();
			if (wantChange == 1)  {
				System.out.println("Veuillez saisir le(s) numéro de dés que vous voulez reprendre: ");
				String a = null;
				try {
					a = br.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				Pattern p = Pattern.compile("[^1-5]");
				Matcher m = p.matcher(a);
				String result = m.replaceAll("");
				for(int i = 0; i < result.length(); i++)
					change.add(Integer.parseInt(result.substring(i,i+1)));
				for(int i = 0; i < change.size(); i++)
					des[change.get(i) - 1].lancer();
				for(int i = 0; i < des.length; i++)
					System.out.println(des[i]);
				timeofchange--;
				change.clear(); // 清空重新摇骰子的数组
			}
			else 
				break;
		}
		//把骰子结果存入数组,每个元素代表相应的点数的个数
		for(int i = 0; i < 5; i++){
			int x = des[i].getupface();
			count[x - 1] ++;
		}
		for(int i = 0; i < 6; i++) {
			//
//			System.out.println(count[i]);
			if(count[i] > maxofcount) {
				maxofcount = count[i];
				indexofmax = i;
			}
			if((count[i] < minofcount)&&(count[i] != 0)) {
				minofcount = count[i];
			}
				
		}
		//test
//		System.out.println(maxofcount);
//		System.out.println(minofcount);
//		System.out.println(indexofmax);
		
		if ((count[0]*count[1]*count[2]*count[3] != 0)||(count[1]*count[2]*count[3]*count[4] != 0)||(count[2]*count[3]*count[4]*count[5] != 0) )
			isPetiteSuite = true;
		if ( (count[0]*count[1]*count[2]*count[3]*count[4] != 0)||(count[1]*count[2]*count[3]*count[4]*count[5] != 0) )
			isGrandeSuite = true;
		//打印选择格子信息
		System.out.println("Voici les probablités que vous pouvez choisir: ");
		if (!feuilleDeScore.getIsFinish(0)) {
			System.out.println(feuilleDeScore.getCombinaison(0));
			haveCase = true;
		}
		if (!feuilleDeScore.getIsFinish(1)) {
			System.out.println(feuilleDeScore.getCombinaison(1));
			haveCase = true;
		}
		if (!feuilleDeScore.getIsFinish(2)) {
			System.out.println(feuilleDeScore.getCombinaison(2));
			haveCase = true;
		}
		if (!feuilleDeScore.getIsFinish(3)) {
			System.out.println(feuilleDeScore.getCombinaison(3));
			haveCase = true;
		}
		if (!feuilleDeScore.getIsFinish(4)) {
			System.out.println(feuilleDeScore.getCombinaison(4));
			haveCase = true;
		}
		if (!feuilleDeScore.getIsFinish(5)) {
			System.out.println(feuilleDeScore.getCombinaison(5));
			haveCase = true;
		}
		switch (maxofcount) {
		case 5:
			if (!feuilleDeScore.getIsFinish(6)) {
				System.out.println(feuilleDeScore.getCombinaison(6));
				haveCase = true;
			}
			if (!feuilleDeScore.getIsFinish(7)) {
				System.out.println(feuilleDeScore.getCombinaison(7));
				haveCase = true;
			}
			if (!feuilleDeScore.getIsFinish(8)) {
				System.out.println(feuilleDeScore.getCombinaison(8));
				haveCase = true;
			}
			if (!feuilleDeScore.getIsFinish(11)) {
				System.out.println(feuilleDeScore.getCombinaison(11));
				haveCase = true;
			}
			break;
		case 4:
			if (!feuilleDeScore.getIsFinish(6)) {
				System.out.println(feuilleDeScore.getCombinaison(6));
				haveCase = true;
			}
			if (!feuilleDeScore.getIsFinish(7)) {
				System.out.println(feuilleDeScore.getCombinaison(7));
				haveCase = true;
			}
			break;
		case 3:
			if(minofcount == 2) {
				if (!feuilleDeScore.getIsFinish(6)) {
					System.out.println(feuilleDeScore.getCombinaison(6));
					haveCase = true;
				}
				if (!feuilleDeScore.getIsFinish(8)) {
					System.out.println(feuilleDeScore.getCombinaison(8));
					haveCase = true;
				}
			}
			else {
				if (!feuilleDeScore.getIsFinish(6)) {
					System.out.println(feuilleDeScore.getCombinaison(6));
					haveCase = true;
				}
			}

		default:
			break;
		}

		if(isPetiteSuite && !feuilleDeScore.getIsFinish(9)) {
			System.out.println(feuilleDeScore.getCombinaison(9));
			haveCase = true;
		}
		if(isGrandeSuite && !feuilleDeScore.getIsFinish(10)) {
			System.out.println(feuilleDeScore.getCombinaison(10));
			haveCase = true;
		}
		if (!feuilleDeScore.getIsFinish(12)) {
			System.out.println(feuilleDeScore.getCombinaison(12));
			haveCase = true;
		}
		
		if(haveCase) {
			System.out.println("Veuillez saisir le numéro de la case: ");
			int choix = sc.nextInt();
			feuilleDeScore.calculateCase(choix, des, indexofmax);
		}
		else
			System.out.println("Désolé, vous n'avez pas de choix pour aucune combinaison. ");
		
	}
	
	public String toString() {
		return "Le total score du joueur " + id + " est " + feuilleDeScore.getTotalScore();
	}
}


