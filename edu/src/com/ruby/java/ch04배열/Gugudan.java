package com.ruby.java.ch04배열;

import java.util.Scanner;

public class Gugudan {

    // 세로 출력
    public static void printVertical() {
        for (int i = 2; i <= 9; i++) {
            System.out.println(i + "단");
            for (int j = 1; j <= 9; j++) {
                System.out.println(i + " x " + j + " = " + (i * j));
            }
            System.out.println("-".repeat(20));
        }
    }

    // 가로 출력
    public static void printHorizontal() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 2; j <= 9; j++) {
                System.out.print(j + " x " + i + " = " + (i * j) + "\t");
            }
            System.out.println();
        }
    }

    // 특정 단 출력
    public static void printColumn(int col) {
        System.out.println(col + "단");
        for (int i = 1; i <= 9; i++) {
            System.out.println(col + " x " + i + " = " + (col * i));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("=== 구구단 출력 메뉴 ===");
            System.out.println("1. 세로 출력");
            System.out.println("2. 가로 출력");
            System.out.println("3. 특정 단 출력");
            System.out.println("0. 종료");
            System.out.print("선택: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    printVertical();
                    break;
                case 2:
                    printHorizontal();
                    break;
                case 3:
                    System.out.print("출력할 단 입력(2~9): ");
                    int col = sc.nextInt();
                    if (col >= 2 && col <= 9) {
                        printColumn(col);
                    } else {
                        System.out.println("잘못된 단 입력입니다.");
                    }
                    break;
                case 0:
                    System.out.println("프로그램 종료");
                    break;
                default:
                    System.out.println("잘못된 선택입니다.");
            }

            System.out.println(); // 줄 띄우기
        } while (choice != 0);

        sc.close();
    }
}
