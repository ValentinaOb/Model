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

            System.out.println("\nPyassonn\n");
            { // Pyassonn
                int ksi;
                double s = 0, s1 = 0, sa, sa1, z, prob, sum, lambda, d = 0;

                System.out.println("L: ");
                lambda = in.nextInt();

                System.out.println("Lambda: " + lambda);

                for (int i = 0; i < 200; i++) {

                    ksi = 0;

                    prob = Math.exp(-25);
                    sum = prob;
                    System.out.println("Pr: " + prob);

                    z = new Random().nextDouble();
                    System.out.println("Z: " + z);

                    do {
                        ksi += 1;
                        prob *= lambda / ksi;
                        sum += prob;
                    } while (z > sum);

                    System.out.println("Pr: " + prob);
                    System.out.println("Ksi: " + ksi);

                    s += ksi;
                    s1 += Math.pow(ksi, 2);

                }

                sa = s / 200.0;
                sa1 = s1 / 200.0;

                d = sa1 - Math.pow(sa, 2);

                System.out.println("S: " + s);
                System.out.println("S1: " + s1);
                System.out.println("Sa: " + sa);
                System.out.println("Sa1: " + sa1);
                System.out.println("D: " + d);
            }

            {
                System.out.println("\nGeom\n ");
                // Geom
                int ksi1;
                double sg = 0, s1g = 0, sag, sa1g, zg, probg, sumg, pg, dg = 0;

                System.out.println("P: ");
                pg = in.nextDouble();

                for (int i = 0; i < 100; i++) {

                    ksi1 = 0;

                    probg = pg;
                    sumg = probg;
                    System.out.println("Pr: " + probg);

                    zg = new Random().nextDouble();
                    System.out.println("Z: " + zg);

                    do {
                        ksi1 += 1;
                        probg *= (1 - pg);
                        sumg += probg;
                    } while (zg > sumg);

                    System.out.println("Ksi1: " + ksi1);
                    System.out.println("P: " + pg);
                    System.out.println("Pr: " + probg);
                    System.out.println("Sum: " + sumg);

                    sg += ksi1;
                    s1g += Math.pow(ksi1, 2);
                    System.out.println("Ksi1: " + ksi1);

                }

                sag = sg / 200.0;
                sa1g = s1g / 200.0;

                dg = sa1g - Math.pow(sag, 2);

                System.out.println("S: " + sg);
                System.out.println("S1: " + s1g);
                System.out.println("Sa: " + sag);
                System.out.println("Sa1: " + sa1g);
                System.out.println("D: " + dg);

            }

            {
                System.out.println("\nBinom\n ");
                // Binom
                int ksi2, n, min = 1, max = 100;
                double sb = 0, s1b = 0, sab, sa1b;
                double zb, pb, db = 0;

                System.out.println("P: ");
                pb = in.nextDouble();

                for (int i = 0; i < 200; i++) {

                    ksi2 = 0;

                    n = (int) Math.floor(Math.random() * (max - min + 1) + min);
                    System.out.println("N: " + n);

                    for (int j = 0; j < n; j++) {
                        zb = new Random().nextDouble();
                        System.out.println("Z: " + zb);

                        if (zb < pb) {
                            ksi2 += 1;
                        }
                        System.out.println("Ksi: " + ksi2);
                    }

                    sb += ksi2;
                    s1b += Math.pow(ksi2, 2);
                    System.out.println("Ksi: " + ksi2);

                }

                sab = (int) sb / 200.0;
                sa1b = (int) s1b / 200.0;

                db = sa1b - Math.pow(sab, 2);

                System.out.println("S: " + sb);
                System.out.println("S1: " + s1b);
                System.out.println("Sa: " + sab);
                System.out.println("Sa1: " + sa1b);
                System.out.println("D: " + db);
            }

        }
    }

    public static void main2(String[] args) {

        try (Scanner in = new Scanner(System.in)) {

            System.out.println("\nEp\n ");
            {// EP
                double ksi = 0, a, sa, sa1, z = 0, d = 0, s = 0, s1 = 0;

                a = new Random().nextInt();

                System.out.println("A: " + a);

                for (int i = 0; i < 100; i++) {

                    Random rd = new Random();
                    z = rd.nextDouble();
                    System.out.println("Z: " + z);

                    ksi = ((-1 / a) * Math.log(1 - z));

                    s += ksi;
                    s1 += Math.pow(ksi, 2);

                    System.out.println("Ksi: " + ksi);
                }

                sa = s / 100.0;
                sa1 = s1 / 100.0;

                d = sa1 - Math.pow(sa, 2);

                System.out.println("S: " + sa);
                System.out.println("S1: " + sa1);
                System.out.println("D: " + d);
            }

            System.out.println("\nPareto\n ");
            {// Pareto
                double ksi = 0, a, sa, sa1, z = 0, d = 0, s = 0, s1 = 0;

                a = new Random().nextInt();

                System.out.println("A: " + a);

                for (int i = 0; i < 200; i++) {

                    Random rd = new Random();
                    z = rd.nextDouble();
                    System.out.println("Z: " + z);

                    ksi = a * (Math.pow(1 - z, (1 / a))) - a;

                    s += ksi;
                    s1 += Math.pow(ksi, 2);

                    System.out.println("Ksi: " + ksi);
                }

                sa = s / 200.0;
                sa1 = s1 / 200.0;

                d = sa1 - Math.pow(sa, 2);

                System.out.println("S: " + sa);
                System.out.println("S1: " + sa1);
                System.out.println("D: " + d);
            }

            System.out.println("\nPP\n ");
            {// PP
                int a = 5, b = 15;
                double s = 0, s1 = 0, ksi, z, sa, sa1, d = 0;

                System.out.println("A: " + a);
                System.out.println("B: " + b);

                for (int i = 0; i < 100; i++) {
                    Random rd = new Random();
                    z = rd.nextDouble();
                    System.out.println("Z: " + z);

                    ksi = ((b - a) * z + a);
                    System.out.println("Ksi: " + ksi);

                    s += ksi;
                    s1 += Math.pow(ksi, 2);
                }

                sa = s / 100.0;
                sa1 = s1 / 100.0;

                d = sa1 - Math.pow(sa, 2);

                System.out.println("S: " + s);
                System.out.println("S1: " + s1);
                System.out.println("Sa: " + sa);
                System.out.println("Sa1: " + sa1);
                System.out.println("D: " + d);

            }

            System.out.println("\nNP\n\n ");

            { // NP
                int ksi;
                double a, Sn = 0, S = 0, S1 = 0, b, z = 0.0, sa, sa1, d;

                a = new Random().nextInt();
                b = new Random().nextInt();

                System.out.println("A: " + a);
                System.out.println("B: " + b);

                for (int i = 0; i < 100; i++) {

                    ksi = 0;

                    for (int j = 0; j < 100; j++) {
                        Random rd = new Random();
                        z = rd.nextDouble();
                        System.out.println("Z: " + z);
                    }

                    Sn = (S - 50) / Math.sqrt(100 / 12);
                    ksi = (int) (Sn * b + a);

                    S += ksi;
                    S1 += Math.pow(ksi, 2);

                    System.out.println("S: " + S);
                    System.out.println("S1: " + S1);
                    System.out.println("Sn: " + Sn);
                    System.out.println("Ksi: " + ksi);
                }

                sa = S / 100.0;
                sa1 = S1 / 100.0;

                d = sa1 - Math.pow(sa, 2);

                System.out.println("SA: " + sa);
                System.out.println("SA1: " + sa1);
                System.out.println("D: " + d);
            }
        }
    }

    public static void main3(String[] args) {

        try (Scanner in = new Scanner(System.in)) {

            int n = 10, k = 0, u = 150000;
            double b1 = 25000, b2 = 50000, sum = 0;
            double z, p = 0.8, p1 = 0.15, p2 = 0.05;

            System.out.println("P: " + p);
            System.out.println("P1: " + p1);
            System.out.println("P2: " + p2);

            System.out.println("U: " + u);
            System.out.println("B1: " + b1);
            System.out.println("B2: " + b2);

            for (int i = 0; i < 100; i++) {

                for (int j = 0; j < n; j++) {
                    z = new Random().nextDouble();
                    System.out.println("Z: " + z);

                    if ((z < p) && (z > 0)) {
                        sum += 0;
                    }

                    if ((z > p) && (z < p + p1)) {
                        sum += b1;
                    }
                    if (z > p + p1) {
                        sum += b2;
                    }

                    System.out.println("Sum: " + sum);

                    if (sum > u) {
                        k++;
                        sum = 0;
                    }
                }

            }

            double r = k / 100.00;

            System.out.println("K: " + k);
            System.out.println("R: " + r);

        }
    }

    public static void main4(String[] args) {

        try (Scanner in = new Scanner(System.in)) {
            System.out.println("\nPyassonn\n\n ");
            {
                // Pyassonn
                int ksi;
                double z, prob, sum;
                double lambda = 9;

                System.out.println("Lambda: " + lambda);

                ksi = 0;

                prob = 0.00014;
                // prob = Math.exp(-25);
                System.out.println("Prob: " + prob);

                sum = prob;
                System.out.println("Pr: " + prob);

                z = new Random().nextFloat();
                System.out.println("Z: " + z);

                do {
                    ksi += 1;
                    prob *= lambda / ksi;
                    // System.out.println("Pr: " + prob);
                    sum += prob;
                    // System.out.println("Sum: " + sum);
                } while (z > sum);

                System.out.println("Pr: " + prob);
                System.out.println("Ksi: " + ksi);

                //
                //

                System.out.println("\nEp\n\n ");
                // EP
                double ksi1 = 0, a, ze = 0, de = 0, se = 0, s1e = 0;
                a = 5000;

                System.out.println("A: " + a);

                for (int i = 0; i < ksi; i++) {

                    Random rd = new Random();
                    ze = rd.nextDouble();
                    System.out.println("Z: " + ze);

                    ksi1 = ((-1 / a) * Math.log(1 - ze));

                    se += ksi1;
                    s1e += Math.pow(ksi1, 2);

                    System.out.println("Ksi1: " + ksi1);
                }

                de = s1e - Math.pow(se, 2);

                System.out.println("D: " + de);
                System.out.println("S: " + se);
                System.out.println("S1: " + s1e);

                //

                int k = 0, u = 105000;
                double b1 = s1e, sumr = 0;
                double zr, p = 0.75, p1 = 0.25;

                System.out.println("P: " + p);
                System.out.println("P1: " + p1);

                System.out.println("U: " + u);
                System.out.println("B1: " + b1);

                for (int j = 0; j < ksi; j++) {
                    zr = new Random().nextFloat();
                    System.out.println("Z: " + z);

                    if ((zr > 0) && (zr < p)) {
                        sumr += 0;
                    }
                    if ((zr > p) && (zr < p1 + p)) {
                        sumr += b1;
                    }

                    System.out.println("Sum: " + sumr);

                    if (sumr > u) {
                        k++;
                    }
                }

                double r = k / ksi;

                System.out.println("K: " + k);
                System.out.println("R: " + r);
            }

        }

    }

    public static void main5(String[] args) {

        try (Scanner in = new Scanner(System.in)) {

            System.out.println("D: ");

        }
    }

}
