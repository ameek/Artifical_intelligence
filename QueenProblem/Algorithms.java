package QueenProblem;

import java.util.Random;

public class Algorithms {

    static int monetcarloIter = 0;
    static int GibbsIter = 0;
    static int HillDescentIter = 0;
    static int HillDescentRWIter = 0;
    static int SimulatedAnnealingIter = 0;
    public static Random myRnd = new Random();

    public static void main(String[] args) {
        /*Solution s = new Solution(4);
		System.out.println(s);
		System.out.println(s.isGoal());
		Solution s1 = new Solution(
				new int []{1,3,0,2});
		
		System.out.println(s1);
		System.out.println(s1.isGoal());
		
		System.out.println(generateRandomNeighbor(s));
		System.out.println(generateRandomNeighbor(s1));
         */
//        System.out.println("HillDescent:  \n");
//        System.out.println(HillDescent(240000, 100) + "\n_________________________");
//        System.out.println("SimulatedAnnealing:  \n");
//        System.out.println(SimulatedAnnealing(240000, 100, 20000.00, .999999) + "\n_________________________");
        runThemAll();
    }

    public static void runThemAll() {
        /*
                System.out.println("Montecarlo : \n");
                System.out.println(MonteCarlo(500, numberOfqueen[i]) + "\n_________________________");
                System.out.println("Gibbs: \n");
                System.out.println(Gibbs(7000, numberOfqueen[i]) + "\n_________________________");
                System.out.println("HillDescent:  \n");
                System.out.println(HillDescent(7000, numberOfqueen[i]) + "\n_________________________");
                System.out.println("HillDescentRW: \n");
                System.out.println(HillDescentRW(7000, numberOfqueen[i], 0.05) + "\n_________________________");
                System.out.println("SimulatedAnnealing:  \n");
                System.out.println(SimulatedAnnealing(10000, numberOfqueen[i], 10000.00, .98) + "\n_________________________");
         */
        int[] numberOfqueen = new int[]{4, 6, 8, 10, 15, 20, 25, 30, 35, 40, 35, 40, 50, 60, 70, 80};
        int monetcarloSucess = 0;
        int GibbsSucess = 0;
        int HillDescentSucess = 0;
        int HillDescentRWSucess = 0;
        int SimulatedAnnealingSucess = 0;

        for (int i = 0; i < numberOfqueen.length; i++) {
            for (int j = 0; j < 100; j++) {
                Solution montecarlo = MonteCarlo(7000, numberOfqueen[i]);
                if (montecarlo != null) {
                    monetcarloSucess++;
                    monetcarloIter += monetcarloIter;
//                    System.out.println(monetcarloIter);
                }
                Solution gibbs = Gibbs(7000, numberOfqueen[i]);
                if (gibbs != null) {
                    GibbsSucess++;
                    GibbsIter += GibbsIter;
                }
                Solution hillDescent = HillDescent(70000, numberOfqueen[i]);
                if (hillDescent != null) {
                    HillDescentSucess++;
                    HillDescentIter += HillDescentIter;
                }
                Solution hillDescentRW = HillDescentRW(7000, numberOfqueen[i], 0.05);
                if (hillDescentRW != null) {
                    HillDescentRWSucess++;
                    HillDescentRWIter += HillDescentRWIter;
                }
                Solution simulatedAnnealing = SimulatedAnnealing(10000, numberOfqueen[i], 10000.00, .98);
                if (simulatedAnnealing != null) {
                    SimulatedAnnealingSucess++;
                    SimulatedAnnealingIter += SimulatedAnnealingIter;
                }
            }
            System.out.println(monetcarloIter);
            System.out.println(numberOfqueen[i] + " --> rate of monetcarloSucess:         " + monetcarloSucess + "  avarage itaration --> "+ getAvarageIter(monetcarloIter,monetcarloSucess));
            System.out.println(numberOfqueen[i] + " --> rate of GibbsSucess:              " + GibbsSucess  + "  avarage itaration --> "+ getAvarageIter(GibbsIter, GibbsSucess));
            System.out.println(numberOfqueen[i] + " --> rate of HillDescentSucess:        " + HillDescentSucess  + "  avarage itaration --> "+ getAvarageIter(HillDescentIter, HillDescentSucess));
            System.out.println(numberOfqueen[i] + " --> rate of HillDescentRWSucess:      " + HillDescentRWSucess  + "  avarage itaration --> "+ getAvarageIter(HillDescentRWIter, HillDescentRWSucess));
            System.out.println(numberOfqueen[i] + " --> rate of SimulatedAnnealingSucess: " + SimulatedAnnealingSucess + "  avarage itaration --> " + getAvarageIter(SimulatedAnnealingIter, SimulatedAnnealingSucess));
            System.out.println("\n \n \n");

            monetcarloSucess = 0;
            GibbsSucess = 0;
            HillDescentSucess = 0;
            HillDescentRWSucess = 0;
            SimulatedAnnealingSucess = 0;
            monetcarloIter = 0;
            GibbsIter = 0;
            HillDescentIter = 0;
            HillDescentRWIter = 0;
            SimulatedAnnealingIter = 0;
        }

    }

    public static double getAvarageIter(double totalIter, double rateOFsucess) {
        if (rateOFsucess <= 0) {
            return 0.0;
        } else {
            return totalIter / rateOFsucess;
        }
    }

    public static Solution generateRandomly(int n) {
        Solution temp = new Solution(n);
        for (int i = 0; i < n; i++) {
            temp.getQueens()[i] = (int) (myRnd.nextDouble() * n);
        }

        return temp;
    }

    public static Solution MonteCarlo(int maxIter, int n) {
        int iteration = 0;
        while (iteration++ < maxIter) {
            Solution x = generateRandomly(n);
            if (x.isGoal()) {
                monetcarloIter = iteration;
//                System.out.println(iteration);
                return x;

            }
        }
        return null;
    }

    public static Solution generateRandomNeighbor(Solution x) {
        Solution temp = new Solution(x);
        int n = temp.getQueens().length;
        int qindex = (int) (myRnd.nextDouble() * n);
        int qvalue = (int) (myRnd.nextDouble() * n);
        temp.getQueens()[qindex] = qvalue;

        return temp;
    }

    public static Solution Gibbs(int maxIter, int n) {
        int iteration = 0;
        Solution x = generateRandomly(n);
        if (x.isGoal()) {
            return x;
        }

        while (iteration++ < maxIter) {
            Solution xtemp = generateRandomNeighbor(x);
            if (xtemp.isGoal()) {
                GibbsIter = iteration;
//                System.out.println(iteration);
                return xtemp;

            }
            x = xtemp;
        }
        return null;
    }

    public static Solution HillDescent(int maxIter, int n) {
        int iteration = 0;
        Solution x = generateRandomly(n);
        if (x.isGoal()) {
            return x;
        }

        while (iteration++ < maxIter) {
            Solution xtemp = generateRandomNeighbor(x);
            if (xtemp.isGoal()) {
                HillDescentIter = iteration;
                System.out.println(iteration);
                return xtemp;

            }
            if (xtemp.getQuality() <= x.getQuality()) {
                x = xtemp;
            }
//			System.out.println(iteration +"--> "+x.getQuality());
        }
        return null;
    }

    public static Solution HillDescentRW(int maxIter, int n, double wp) {
        int iteration = 0;
        Solution x = generateRandomly(n);
        if (x.isGoal()) {
            return x;
        }

        while (iteration++ < maxIter) {
            Solution xtemp = generateRandomNeighbor(x);
            if (xtemp.isGoal()) {
                HillDescentRWIter = iteration;
//                System.out.println(iteration);
                return xtemp;

            }
            if (xtemp.getQuality() <= x.getQuality()) {
                x = xtemp;
            } else if (myRnd.nextDouble() < wp) {
                x = xtemp;
            }
            //System.out.println(x.getQuality());
        }
        return null;
    }

    public static double tempatureControl(double temp, double annealing,int iter) { //anik will implemnet ;) 
        return (temp * annealing);
//        return 
    }

    public static double getAnnealing(double t, Solution x, Solution xtemp) {
        double DellQuality = Math.abs(x.getQuality() - xtemp.getQuality());
        double e = Math.exp(DellQuality / t);
        double annealing = 1 / e;
//        double annealing =  e;

        return annealing;
    }

    public static Solution SimulatedAnnealing(int maxIter, int n, double T, double annealing) {
        int iteration = 0;
        Solution x = generateRandomly(n);
        if (x.isGoal()) {
            return x;
        }

        while (iteration++ < maxIter) {
            Solution xtemp = generateRandomNeighbor(x);
            if (xtemp.isGoal()) {
                SimulatedAnnealingIter = iteration;
                System.out.println(iteration);
                return xtemp;

            }
            if (xtemp.getQuality() <= x.getQuality()) {
                x = xtemp;
            } else if (myRnd.nextDouble() < getAnnealing(T, x, xtemp)) {
//                System.out.println("Annealing value:  " + getAnnealing(T, x, xtemp));
                T = tempatureControl(T, annealing,iteration);
//                System.out.println("temperture :: " + T);
                x = xtemp;
            }

            //System.out.println(x.getQuality());
        }
        return null;
    }

}
