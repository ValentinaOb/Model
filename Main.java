import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        System.out.println("Ex: ");

        try (Scanner in = new Scanner(System.in)) {
            int a = in.nextInt();

            switch (a) {
                case 1:
                    main1(args);
                    break;
                case 2:
                    main2(args);
                    break;
                case 3:
                    main3(args);
                    break;
                case 4:
                    main4(args);
                    break;
                case 5:
                    main5(args);
                    break;
            }
        }
    }

    public static void main1(String[] args) {
        try (Scanner in = new Scanner(System.in)) {

            {
                System.out.println("\nPyassonn\n");
                // Pyassonn
                int ksi;
                double z, prob, sum, lambda;

                System.out.println("L: ");
                lambda = 9;

                for (int i = 0; i < 200; i++) {
                    ksi = 0;

                    prob = Math.exp(-lambda);
                    sum = prob;

                    z = new Random().nextDouble();

                    while (z > sum) {
                        ksi += 1;
                        prob *= lambda / ksi;
                        sum += prob;
                    }
                    System.out.println("Ksi: " + ksi);
                }
            }

            {
                System.out.println("\nGeom\n ");
                // Geom
                int ksi1;
                double zg, probg, sumg, pg;

                pg = 0.8;

                for (int i = 0; i < 200; i++) {

                    ksi1 = 0;

                    probg = pg;
                    sumg = probg;

                    zg = new Random().nextDouble();

                    do {
                        ksi1 += 1;
                        probg *= (1 - pg);
                        sumg += probg;
                    } while (zg > sumg);

                    System.out.println("Ksi1: " + ksi1);

                }
            }

            {
                System.out.println("\nBinom\n ");
                // Binom
                int ksi2, n, min = 1, max = 100;
                double zb, pb = 0.5;

                for (int i = 0; i < 200; i++) {

                    ksi2 = 0;

                    n = (int) Math.floor(Math.random() * (max - min + 1) + min);

                    for (int j = 0; j < n; j++) {
                        zb = new Random().nextDouble();

                        if (zb < pb) {
                            ksi2 += 1;
                        }
                        System.out.println("Ksi: " + ksi2);
                    }
                }
            }
        }
    }

    public static void main2(String[] args) {

        try (Scanner in = new Scanner(System.in)) {

            System.out.println("\nEp\n ");
            {// EP
                double ksi, a, z;

                a = new Random().nextInt();

                for (int i = 0; i < 200; i++) {

                    Random rd = new Random();
                    z = rd.nextDouble();
                    ksi = ((-1 / a) * Math.log(1 - z));

                    System.out.println("Ksi: " + ksi);
                }
            }

            System.out.println("\nPareto\n ");
            {// Pareto
                double ksi, a, b, z;

                a = new Random().nextInt();
                b = new Random().nextInt();

                for (int i = 0; i < 200; i++) {

                    Random rd = new Random();
                    z = rd.nextDouble();

                    ksi = a * (Math.pow(1 - z, (-1 / b))) - a;

                    System.out.println("Ksi: " + ksi);
                }
            }

            System.out.println("\nPP\n ");
            {// PP
                int a = 5, b = 15;
                double ksi, z;

                for (int i = 0; i < 200; i++) {
                    Random rd = new Random();
                    z = rd.nextDouble();

                    ksi = ((b - a) * z + a);
                    System.out.println("Ksi: " + ksi);
                }
            }

            System.out.println("\nNP\n\n ");

            { // NP
                double sum, a = 5, b = 15, z;
                System.out.println("B: " + b);
                for (int i = 0; i < 100; i++) {

                    sum = 0;

                    for (int j = 0; j < 12; j++) {
                        Random rd = new Random();
                        z = rd.nextDouble();
                        sum += z;
                    }
                    sum = sum - 6;

                    sum = sum * b + a;
                    System.out.println("Sum: " + sum);
                }

            }
        }
    }

    public static void main3(String[] args) {

        try (Scanner in = new Scanner(System.in)) {

            int n = 10, k = 0, u = 150000;
            double b1 = 25000, b2 = 50000, sum = 0, z, p = 0.8, p1 = 0.15, p2 = 0.05;
            double r = 0.6;

            while (r > 0.05) {
                for (int i = 0; i < 10000; i++) {
                    sum = 0;
                    for (int j = 0; j < n; j++) {
                        z = new Random().nextDouble();

                        if ((z < p) && (z > 0)) {
                            sum += 0;
                        }

                        if ((z > p) && (z < p + p1)) {
                            sum += b1;
                        }
                        if (z > p + p1) {
                            sum += b2;
                        }

                        if (sum > u) {
                            k++;
                        }
                    }
                    r = k / 10000.0;
                }
                if (r > 0.5) {
                    u += 50000;
                } else
                    break;
            }
            System.out.println("U: " + u);
            System.out.println("K: " + k);
            System.out.println("R: " + r);

        }
    }

    public static void main4(String[] args) {

        try (Scanner in = new Scanner(System.in)) {
            {
                // Pyassonn
                int ksi;
                double z, prob, sum, lambda = 9;
                double ksi1 = 0, a, ze, se;
                a = 1 / 5000;
                int k = 0, u = 105000;

                for (int j = 0; j < 10000; j++) {
                    ksi = 0;

                    k = 0;

                    prob = Math.exp(-lambda);
                    sum = prob;

                    z = new Random().nextDouble();

                    while (z > sum) {
                        ksi += 1;
                        prob *= lambda / ksi;
                        sum += prob;
                    }

                    // EP
                    se = 0;

                    for (int i = 0; i < ksi; i++) {

                        Random rd = new Random();
                        ze = rd.nextDouble();

                        ksi1 = ((-1 / a) * Math.log(1 - ze));

                        se += ksi1;
                    }

                    if (se > u) {
                        k += 1;
                    }
                }
                System.out.println("K: " + k);
                double r = k / 10000.0;
                System.out.println("R: " + r);

            }
        }
    }

    public static void main5(String[] args) {

        try (Scanner in = new Scanner(System.in)) {

            double S0 = 100000, St;
            double ksi, a = 5, b = 15, x, m = 0;
            ksi = 0;

            for (int j = 0; j < 20; j++) {
                Random rd = new Random();
                x = rd.nextDouble();
                ksi += x;
                S0 += ksi;
                m = Math.exp(x - ((b * b) / 2));
            }
            ksi = ksi - 10;

            ksi = ksi * b + a;
            St = S0 * Math.exp(a) * m;

            System.out.println("St: " + St);
        }
    }

}
