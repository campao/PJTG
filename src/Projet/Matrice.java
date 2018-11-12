package Projet;



import java.util.ArrayList;



public class Matrice {

private int count;
private Boolean retry = false;

private int rang = 0, tmp = 0;

public int getCount() {
return count;
}



public void setCount(int count) {
this.count = count;
}



public int getrang() {
return rang;
}



public void setrang(int rang) {
this.rang = rang;
}



public int getTmp() {
return tmp;
}



public void setTmp(int tmp) {
this.tmp = tmp;
}



public ArrayList<Integer> getLsom() {
return Lsom;
}



public void setLsom(ArrayList<Integer> lsom) {
Lsom = lsom;
}



public ArrayList<Integer> getLrang() {
return Lrang;
}



public void setLrang(ArrayList<Integer> lrang) {
Lrang = lrang;
}



private ArrayList<Integer> Lsom = new ArrayList<Integer>();

private ArrayList<Integer> Lrang = new ArrayList<Integer>();



public Matrice(){


}


public char[][] editFind(char[][] T, int t){
	count = 0; 
	for(int j = 0; j < t; j++) {
		count=0;
		for (int i = 0; i < t; i++) {
			retry = false;
			for(int y = 0; y < t; y++) {
				for (int z = 0; z < t; z++) {
					if(T[y][z]!='*'){
						retry = true;
					}
				}
			}
			if(retry == false) { return T;	}
			if (T[i][j] == 'F') { count = count+1; }
			if (count == t-tmp) {
				tmp++;
				Lsom.add(j);
				Lrang.add(rang);
				System.out.println("Sommet entrant " + j +" - Rang : " + rang + "\n" );
				rang ++;
			//Put * instead of F.
				for(int p=0; p<t; p++){
					T[j][p] = '*';
				}
				for(int o=0; o<t;o++){
					T[o][j] = '*';
				}
			//Display to debug
				for(int q = 0; q < t; q++) {
					for (int r = 0; r < t; r++) {
						System.out.print(T[q][r]+"     ");
						if(r==t-1){
							System.out.println("\n");
						}
					}
				}
				j = 0;
			}
		}
	}
	return T;
	}
}
