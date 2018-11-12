package Projet;

import java.util.Scanner;

public class Main {
static Boolean bool = false;
static int cpt1 = 0, cpt2 = 0, cpt3 = 0, cpt4 = 0;
static String valPrec;

public static void main(String[] args) {

   System.out.println("Saisir le nom du fichier\t");
   Scanner sc = new Scanner(System.in);
   Lecture l;
   
   String file = sc.nextLine();
   sc.close();
   
   l = new Lecture("./"+file);
   System.out.println("\n");
   
   l.displayMatrices();
   
   System.out.println("\n");


   int t = l.getSommet();
   char[][] T = l.getMatAdj();

   Matrice m = new Matrice();
   T=m.editFind(T, t);
   // Parcours de la matrice m
   for(int y = 0; y < t; y++) {
	   for (int z = 0; z < t; z++) {
		   if(T[y][z]!='*'){
			   bool = true;
		   }
	   }
   }

   //Affichage de la présence d'un circuit ou non + liste des sommets et rangs
   if(bool == false){

System.out.println("Il n'y a pas de circuit !");
l.setConditions(l.getConditions()+1);

System.out.println("Sommet -  Rang");

for(int i =0 ; i < m.getLrang().size(); i++){

System.out.println("  "+m.getLsom().get(i)+"    -   "+m.getLrang().get(i));

}

}

else{

System.out.println("Il y a au moins un circuit !");

System.out.println("Sommet -  Rang");

for(int i =0 ; i < m.getLrang().size(); i++){

System.out.println("  "+m.getLsom().get(i)+"    -   "+m.getLrang().get(i));

}

}

System.out.println("\n\n");

//1 seule entrée
for(int i =0 ; i < m.getLrang().size(); i++){
if(m.getLrang().get(i) == 0) cpt1 ++;
}
if(cpt1 == 1) {
System.out.println("Il n'y a bien qu'une seule entrée !\n");
l.setConditions(l.getConditions()+1);
}
else System.out.println("Il y a plusieurs entrées ou un problème est survenu !\n");
//1 seule sortie
for(int i =0 ; i < m.getLrang().size(); i++){
if(m.getLrang().get(i) == m.getLrang().size()-1) cpt2 ++;
}
if(cpt2 == 1) {
System.out.println("Il n'y a bien qu'une seule sortie !\n");
l.setConditions(l.getConditions()+1);
}
else System.out.println("Il y a plusieurs sorties ou un problème est survenu !\n");
//Vérification valeurs nulles ligne du premier rang
for(int i=0;i<l.getSommet();i++) {
if(l.getMatArcs()[m.getLsom().get(0)][i].compareTo("0") == 1 && l.getMatArcs()[m.getLsom().get(0)][i] != "*") {
cpt3 = 1;
break;
}
}
if(cpt3 == 1) System.out.println("Un arc incidant vers l'extérieur au point d'entrée n'est pas de valeur nulle !\n");
else{
System.out.println("Les arcs incidant vers l'extérieur au point d'entrée sont de valeur nulle !\n");
l.setConditions(l.getConditions()+1);
}
//Vérification valeur des arcs qui partent d'un même sommet toujours la même
for(int y = 0; y < l.getSommet(); y++) {
for (int z = 0; z < l.getSommet(); z++) {
if(l.getMatArcs()[y][z] != "*") {
valPrec = l.getMatArcs()[y][z];
for (int w = 0; w < l.getSommet(); w++) {
if(l.getMatArcs()[y][w] != "*" && l.getMatArcs()[y][w].compareTo(valPrec) == valPrec.length()) {
cpt4 = 1;
break;
}
}
}
}
}
if(cpt4 == 1) System.out.println("Tous les arcs partant d'un meme sommmet n'ont pas la même valeur !\n");
else{
System.out.println("Tous les arcs partant d'un meme sommmet ont bien la même valeur !\n");
l.setConditions(l.getConditions()+1);
}
//Vérification : toutes les conditions sont elles remplies ?
if(l.getConditions() == 6) {
System.out.println("Le graphe respecte les conditions d'un graphe d'ordonnancement !\n");
}
else System.out.println("Le graphe ne respecte donc pas les conditions d'un graphe d'ordonnancement !\n");
//System.out.println(l.getConditions());
}

}