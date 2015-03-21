package ua.knure.kpp.Yakunina.lab1;

import java.util.Random;
import java.util.Scanner;

public class Matrix {

	public static int[][] generateMatrix(int N){
		int mas[][]=new int [N+15][N+15];
		Random rnd = new Random();
		for (int i = 0; i < mas.length; i++) {
			for (int j = 0; j < mas.length; j++) {
				mas[i][j] = rnd.nextInt() % 25 + 1;
			}
		}
		return mas;
	}
	
	public static void printMatrix(int[][] mas){
		for (int [] i : mas) {
		for (int j : i) {
			System.out.print(j + "\t");
		}
		System.out.print("\n");
	}
	}
		
	public static int[][] copyMatrix(int[][]mas, int N){
		int[][]mas1= new int[N+15][N+15];
		for (int i = 0; i < mas1.length; i++) {
			for (int j = 0; j < mas1.length; j++) {
				mas1[i][j] = mas[i][j];
			}
		}
		return mas1;
	}
	
	public static int findSumInChetCol(int[][] m, int N) {
		int sum = 0;
		for (int i = 0; i < N+15; i++) {
			for (int j = 0; j < N+15; j += 2) {
				sum = sum + m[i][j];
			}
		}
		return sum;
	}

	public static void sortMatrix(int[][] m, int N) {
		System.out.print("Отсортированная матрица:" + '\n');
		int t;
		for (int j = 1; j < (N + 15) * (N + 15); j++) {
			for (int i = 0; i < (N + 15); i++) {
				for (int k = 0; k < (N + 15) - 1; k++) {
					if (m[i][k] > m[i][k + 1]) {
						t = m[i][k];
						m[i][k] = m[i][k + 1];
						m[i][k + 1] = t;
					}
				}
				if (i != (N + 14)) {
					if (m[i + 1][0] < m[i][N + 14]) {
						t = m[i + 1][0];
						m[i + 1][0] = m[i][N + 14];
						m[i][N + 14] = t;
					}
				}
			}
		}
	}

	public static void taskResult(boolean b, int[][] mas, int[][] mas1){
		if (b==true) {
				System.out.println("Первая сумма больше второй или равная ей, потому возвращена исходная матрица и обнулены нечетные столбцы:" );
				for (int i = 0; i < mas1.length; i++) {
					for (int j = 0; j < mas1.length; j++) {
						if (j % 2 != 0) {
							mas1[i][j]=0;
							System.out.print(mas[i][j] + "\t");
						} else {
							System.out.print(mas1[i][j] + "\t");
						}
					}
					System.out.print("\n");
				}

			} else {
				System.out.println("Вторая сумма больше первой, потому возвращена отсортированная матрица и обнулены четные столбцы:");
				for (int i = 0; i < mas.length; i++) {
					for (int j = 0; j < mas.length; j++) {
						if (j % 2 == 0) {
							mas[i][j]=0;
							System.out.print(mas[i][j] + "\t");
						} else {
							System.out.print(mas[i][j] + "\t");
						}
					}
					System.out.print("\n");
				}
			}
	}
	public static void main(String[] args) {
		System.out.println("Размерность матрицы будет (N+15)*(N+15), введите N:");
		Scanner cin = new Scanner(System.in);
		int N, summa1 = 0, summa2 = 0;
		N = cin.nextInt();
		int[][] mas = new int[N + 15][N + 15];
		mas=generateMatrix(N);
		printMatrix(mas);
		int[][] mas1 = new int[N + 15][N + 15];
		mas1=copyMatrix(mas, N);
		summa1 = findSumInChetCol(mas, N);
		System.out.println("Сумма элементов в четных столбцах = " + summa1+'\n');
		sortMatrix(mas, N);
		printMatrix(mas);
		summa2 = findSumInChetCol(mas, N);
		System.out.println("Сумма элементов в четных столбцах отсортированной матрицы = "+ summa2+'\n');
		taskResult((summa1 >= summa2), mas, mas1);
	}
}
