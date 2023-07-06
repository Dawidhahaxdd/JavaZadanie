package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] Monety = {
                {5.0, 1},
                {2.0, 3},
                {1.0, 5},
                {0.5, 10},
                {0.2, 20},
                {0.1, 200},
                {0.05, 100},
                {0.02, 100},
                {0.01, 10000},
        };
        String[] Monety2 = {"5 zł","2 zł","1 zł","50 gr","20 gr","10 gr","5 gr","2 gr","1 gr"};
        while(true) {
            String reszta = "";
            while(true) {
                System.out.print("Podaj resztę lub wpisz 'Koniec' w celu zakończenia programu: ");
                reszta = scanner.nextLine();
                System.out.println();
                if(reszta.equals("Koniec")){
                    break;
                }
                try {
                    double test = Double.parseDouble(reszta);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Błędnie wpisana reszta, przykład poprawnej reszty: 12.25");
                    System.out.println();
                }
            }
            if(reszta.equals("Koniec")){
                break;
            }

            else{
                System.out.println("    Dla reszty " + reszta + " zł:");
                System.out.println();
                double resztaDouble = Double.parseDouble(reszta);
                resztaDouble = resztaDouble + 0.0001;
                int uzyteMonety[] = {0,0,0,0,0,0,0,0,0};
                for (int i = 0; i <= 8; i++) {
                    for (int j = 1; j <= Monety[i][1]; j++) {
                        if(resztaDouble >= Monety[i][0])
                        {
                            uzyteMonety[i]++;
                            resztaDouble = resztaDouble - Monety[i][0];
                        }
                        else{
                            //System.out.println("TEST:" + resztaDouble);
                            break;
                        }
                    }
                }
                if(!(resztaDouble > 0.001)) {
                    for (int k = 0; k <= 8; k++) {
                        if (uzyteMonety[k] > 0) {
                            Monety[k][1] = Monety[k][1] - uzyteMonety[k];
                            System.out.println("Wydaj " + uzyteMonety[k] + " monet " + Monety2[k]);
                        }
                    }
                    System.out.println();
                }
                else{
                    System.out.println("Nie można wydać takiej reszty, gdyż brakuje monet.");
                    System.out.println();
                }

            }
        }
        System.out.print("W kasie zostało: ");
        System.out.println();
        for (int i = 0; i <= 8; i++) {
            if(Monety[i][1] > 0)
            {
                int monetyInt = (int) Monety[i][1];
                System.out.println(monetyInt + " monet " + Monety2[i]);
            }

        }




    }
}
