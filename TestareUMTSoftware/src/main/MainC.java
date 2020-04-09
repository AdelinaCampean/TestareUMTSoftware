package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class MainC {

	public static void main(String[] args) {

		ArrayList<Coordinates> points = new ArrayList<>();
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Introduceti numarul de puncte pe care doriti sa le introduceti:");
		int nr = keyboard.nextInt();
		System.out.println("Numarul de puncte este: "+nr);
		
		for(int i=0; i<nr;i++)
		{
			System.out.println("Introduceti valoarea lui x:");
			int x = keyboard.nextInt();
			System.out.println("Introduceti valoarea lui y:");
			int y = keyboard.nextInt();
			System.out.println("("+x+","+y+")");
		
		Coordinates c1 = new Coordinates(x,y); 
		points.add(c1);  //in acest arrayList sunt acum toate punctele(Obiecte de tip x,y) introduse de la tastatura
		
		}
		
		for(Coordinates c: points)
		{
			System.out.println("p -> "+c.toString() );
		}

		int dist[] = new int[31];
		int diag[] = new int[31];
		int p=0,l=0;
		//pentru a verifica daca punctele formeaza un dreptunghi, am parcurs lista de puncte si am calculat distanta dintre 2 puncte, pentru toate cele existente
		for(int i=0; i<points.size(); i++)
		{
			for(int j=i+1; j<points.size(); j++) //am parcurs incepand de la i+1 deoarece am calculat doar distanta de la punctul p la punctul q, nu si de la q la p, sa nu existe duplicate
			{
				if(points.get(i).getY() == points.get(j).getY() || points.get(i).getX() == points.get(j).getX()) //am pus initial o conditite sa fie doar pentru punctele care au fie coordonata x, fie y comuna
																												//pentru a calcula diagonalele separat
				{	
					int a = points.get(i).distanceBetweenP(points.get(i), points.get(j)); //am apelat metoda care implementeaza distanta dintre 2 puncte, din clasa Coordinates
				
					dist[p] = a; //am adaugat acea valoare intr-un sir
					
					p++;
				}
				else 
				{
					int a1 = points.get(i).distanceBetweenP(points.get(i), points.get(j));
					dist[p] = a1;
					diag[l] = a1;
					p++;
					l++;
					
				}
			
			}
		}
		
		ArrayList<Integer> ver = new ArrayList<>(); //in acest arrayList se vor afla doar valorile care indeplinesc conditiile unui dreptunghi
		for(int o = 0; o<dist.length; o++)
		{
			for(int u = 0; u<dist.length; u++)
				{
				for(int y = 0; y<dist.length; y++)
				
					if(dist[o]*dist[o] == (dist[u]*dist[u] + dist[y]*dist[u])) //pentru a verifica cate dreptughiuri se pot forma din punctele introduse de la tastatura, vom aplica formula 
																			  //A^2 = B^2+C^2 si daca sunt egale, inseamna ca exista un dreptunghi
					{
						
						if(!ver.contains(dist[o]*dist[o])) //adaugam valoarea doar o data, deoarece un dreptunghi are 2 diagonale si nu vrem sa adaugam de 2 ori
						{
				
							ver.add(dist[o]*dist[o]);
							
						}
					}
				}
		}
		
		int rectangles =0;
		for(Integer i: ver)
		{
			if(i > 1)
			{
				rectangles ++;
			}
		}
		System.out.println("Number of rectangles: "+rectangles);
		
		//Programul functioneaza pentru primul input din cerinta, daca se sterge un punct, cum se specifica in al doilea exemplu, rezultatul va fi 2, deoarece gaseste o diagonala care indeplineste conditia
	
	}

}
