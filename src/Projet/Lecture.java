package Projet;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Lecture {
private int sommet, arc, line = 0, colonne = 0, graphe[][], negArc = 0, conditions = 0;
//private Boolean succ = true, pred = true;
private char[][] matAdj;
private String[][] matArcs;
private String ligne;
Scanner sc;
public Lecture() {
}
public Lecture(String file) {
   try{
   // Lecture du fichier saisi en sortie 
   InputStream flux=new FileInputStream(file); 
   InputStreamReader lecture=new InputStreamReader(flux);
   BufferedReader buff=new BufferedReader(lecture);
   
   //stockage du nombre de sommets du graphe
   ligne = buff.readLine();
   sommet = Integer.parseInt(ligne.trim());
   System.out.println("nombre de sommets : " + sommet);
   
   //stockage du nombre d'arcs du graphe
   ligne = buff.readLine();
   arc = Integer.parseInt(ligne.trim());
   System.out.println("nombre d'arcs : " + arc);
   
   matArcs = new String[sommet][sommet];
   matAdj = new char[sommet][sommet];
   
   graphe = new int[arc][3];
   
   //stockage du reste du fichier, ligne par ligne 
   while ((ligne=buff.readLine())!=null){ 
    
   sc = new Scanner(ligne);
   graphe[line][colonne]=sc.nextInt();
   colonne++;
   graphe[line][colonne]=sc.nextInt();
   colonne++;
   graphe[line][colonne]=sc.nextInt();
   line++;
   colonne=0;
   
    
   }
   buff.close(); 
   } 
catch (Exception e){
   System.out.println(e.toString());
   }
   for(int i=0; i < arc; i++) {
   String affichage = "";
   for(int j=0; j <= 2; j++) {
   if(j==0) affichage += graphe[i][j] + " -> ";
   else if(j==1) affichage += graphe[i][j] + " = ";
   else affichage += graphe[i][j];
   }
   System.out.println(affichage);
      
   }
   
}
public void displayMatrices() {
//Verif arcs négatifs
for(int i=0; i<sommet; i++) {
if(graphe[i][2] < 0) {
negArc ++;
}
}
if(negArc > 0) System.out.println("Il y a " + negArc + " arc(s) à valeur négative !\n");
else{
System.out.println("Il n'y a pas d'arc à valeur négative !\n");
conditions ++;
}
/*Verif predecesseurs
for(int i=0; i<arc; i++) {
if(pred == false) break;
for(int j =0; j<arc; j++) {
if(graphe[i][1] == graphe[j][0]) {
pred = false;
}
}
}
if(pred == false) {
System.out.println("Au moins un sommet sans prédécesseur !");
conditions ++;
}
else System.out.println("Tous les sommets ont un prédécesseur !");
//Vérif successeurs
for(int i=0; i<arc; i++) {
if(succ == false) break;
for(int j =0; j<arc; j++) {
if(graphe[i][0] == graphe[j][1]) {
succ = false;
}
}
}
if(succ == false) {
System.out.println("Au moins un sommet sans successeur !");
conditions ++;
}
else System.out.println("Tous les sommets ont un successeur !");*/
System.out.println("\nVoici la matrice de valeurs des arcs :\n");
for(int i=0; i<sommet; i++) {
for(int j=0; j<sommet;j++) {
matArcs[i][j] = "*";
}
}
for(int i=0; i<arc; i++) {
matArcs[graphe[i][0]][graphe[i][1]] = String.valueOf(graphe[i][2]);
}

for(int i=0; i<sommet; i++) {
for(int j=0; j<sommet;j++) {
System.out.print(matArcs[i][j]+"     ");
if(j==sommet-1) System.out.println("\n");
}
}
System.out.println("\nVoici la matrice d'adjacence :\n");
for(int i=0; i<sommet; i++) {
for(int j=0; j<sommet;j++) {
if(matArcs[i][j] != "*") matAdj[i][j] = 'V';
else matAdj[i][j] = 'F';
}
}
for(int i=0; i<sommet; i++) {
for(int j=0; j<sommet;j++) {
System.out.print(matAdj[i][j]+"     ");
if(j==sommet-1) System.out.println("\n");
}
}
}
public int getSommet() {
return sommet;
}

public void setSommet(int sommet) {
this.sommet = sommet;
}

public int getArc() {
return arc;
}

public void setArc(int arc) {
this.arc = arc;
}
public char[][] getMatAdj() {
return matAdj;
}
public void setMatAdj(char[][] matAdj) {
this.matAdj = matAdj;
}
public String[][] getMatArcs() {
return matArcs;
}
public void setMatArcs(String[][] matArcs) {
this.matArcs = matArcs;
}
public int getConditions() {
return conditions;
}

public void setConditions(int conditions) {
this.conditions = conditions;
}




}