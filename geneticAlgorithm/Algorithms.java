package geneticAlgorithm;

import java.util.*;

public class Algorithms {

    static int monetcarloIter = 0;
    static int GibbsIter = 0;
    static int HillDescentIter = 0;
    static int HillDescentRWIter = 0;
    static int SimulatedAnnealingIter = 0;
    static int GeneticAlgorithmIter = 0;
    public static Random myRnd = new Random();
    public static void calculation() {
        
        int[] value = {9, -5, 3, 2};
        
        Arrays.sort(value);
        
        for(int i=0; i<value.length; i++)
        {
            System.out.println(value[i]);
        }
    }
    
    public static void main(String[] args) {
       
        runThemAll();
//             crossOver(new Solution(new int[]{0,1,2,3,4}),new Solution(new int[]{2,3,4,1,3}));
//        System.out.println(GA(10000, 6, 10));;
    }

    public static void runThemAll() {
        int[] numberOfqueen = new int[]{4, 6, 8, 10, 15, 20, 25, 30, 35, 40, 50, 60, 70, 80};
        int monetcarloSucess = 0;
        int GibbsSucess = 0;
        int HillDescentSucess = 0;
        int HillDescentRWSucess = 0;
        int SimulatedAnnealingSucess = 0;
        int GeneticAlgorithmSucess = 0;
        int Iter = 2000;

        for (int i = 0; i < numberOfqueen.length; i++) {
            for (int j = 0; j < 100; j++) {
                Solution montecarlo = MonteCarlo(Iter, numberOfqueen[i]);
                if (montecarlo != null) {
                    monetcarloSucess++;
                    monetcarloIter += monetcarloIter;
//                    System.out.println(monetcarloIter);
                }
                Solution gibbs = Gibbs(Iter, numberOfqueen[i]);
                if (gibbs != null) {
                    GibbsSucess++;
                    GibbsIter += GibbsIter;
                }
                Solution hillDescent = HillDescent(Iter, numberOfqueen[i]);
                if (hillDescent != null) {
                    HillDescentSucess++;
                    HillDescentIter += HillDescentIter;
                }
                Solution hillDescentRW = HillDescentRW(Iter, numberOfqueen[i], 0.05);
                if (hillDescentRW != null) {
                    HillDescentRWSucess++;
                    HillDescentRWIter += HillDescentRWIter;
                }
                Solution simulatedAnnealing = SimulatedAnnealing(Iter*2, numberOfqueen[i], 10000.00, .98);
                if (simulatedAnnealing != null) {
                    SimulatedAnnealingSucess++;
                    SimulatedAnnealingIter += SimulatedAnnealingIter;
                }
//                Solution GeneticAlgorithm = GA(Iter*2, numberOfqueen[i], 80);
//                if (GeneticAlgorithm != null) {
//                    GeneticAlgorithmSucess++;
//                    GeneticAlgorithmIter += GeneticAlgorithmIter;
//                }
            }
//            System.out.println(monetcarloIter);
            System.out.println(numberOfqueen[i] + " --> rate of monetcarloSucess:         " + monetcarloSucess + "  avarage itaration --> " + getAvarageIter(monetcarloIter, monetcarloSucess));
            System.out.println(numberOfqueen[i] + " --> rate of GibbsSucess:              " + GibbsSucess + "  avarage itaration --> " + getAvarageIter(GibbsIter, GibbsSucess));
            System.out.println(numberOfqueen[i] + " --> rate of HillDescentSucess:        " + HillDescentSucess + "  avarage itaration --> " + getAvarageIter(HillDescentIter, HillDescentSucess));
            System.out.println(numberOfqueen[i] + " --> rate of HillDescentRWSucess:      " + HillDescentRWSucess + "  avarage itaration --> " + getAvarageIter(HillDescentRWIter, HillDescentRWSucess));
            System.out.println(numberOfqueen[i] + " --> rate of SimulatedAnnealingSucess: " + SimulatedAnnealingSucess + "  avarage itaration --> " + getAvarageIter(SimulatedAnnealingIter, SimulatedAnnealingSucess));
            System.out.println(numberOfqueen[i] + " --> rate of GeneticAlgorithmSucess: " + SimulatedAnnealingSucess + "  avarage itaration --> " + getAvarageIter(GeneticAlgorithmIter, GeneticAlgorithmSucess));
            System.out.println("\n \n \n");

            monetcarloSucess = 0;
            GibbsSucess = 0;
            HillDescentSucess = 0;
            HillDescentRWSucess = 0;
            SimulatedAnnealingSucess = 0;
            GeneticAlgorithmSucess = 0;
            monetcarloIter = 0;
            GibbsIter = 0;
            HillDescentIter = 0;
            HillDescentRWIter = 0;
            SimulatedAnnealingIter = 0;
            GeneticAlgorithmIter = 0;
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

    public static Solution generateRandomNeighbor(Solution x) {
        Solution temp = new Solution(x);
        int n = temp.getQueens().length;
        int qindex = (int) (myRnd.nextDouble() * n);
        int qvalue = (int) (myRnd.nextDouble() * n);
        temp.getQueens()[qindex] = qvalue;

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
//                System.out.println(iteration);
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

    public static double tempatureControl(double temp, double annealing, int iter) { //anik will implemnet ;) 
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
//                System.out.println(iteration);
                return xtemp;

            }
            if (xtemp.getQuality() <= x.getQuality()) {
                x = xtemp;
            } else if (myRnd.nextDouble() < getAnnealing(T, x, xtemp)) {
//                System.out.println("Annealing value:  " + getAnnealing(T, x, xtemp));
                T = tempatureControl(T, annealing, iteration);
//                System.out.println("temperture :: " + T);
                x = xtemp;
            }

            //System.out.println(x.getQuality());
        }
        return null;
    }

    public static Solution[] crossOver(Solution p0, Solution p1) {

        int n = p0.getQueens().length;

        Solution[] children = new Solution[2];
        children[0] = new Solution(n);
        children[1] = new Solution(n);

        int crossPoint = (int) (myRnd.nextDouble() * (n - 1)) + 1;
//		System.out.println(p0+ " "+p1);
//		System.out.println(crossPoint);

        for (int i = 0; i < n; i++) {
            if (i < crossPoint) {
                children[0].getQueens()[i] = p0.getQueens()[i];
            } else {
                children[1].getQueens()[i] = p0.getQueens()[i];
            }
        }

        for (int i = 0; i < n; i++) {
            if (i < crossPoint) {
                children[1].getQueens()[i] = p1.getQueens()[i];
            } else {
                children[0].getQueens()[i] = p1.getQueens()[i];
            }
        }

//		System.out.println(Arrays.toString(children));
        return children;
    }

    public static Solution[] generateOffSpring(Solution[] parent) {
        int indexOfOfspring = 0;
        Solution[] offspring = new Solution[parent.length * 2];
        
        int n = parent.length;
        
        for (int i = 0; i < parent.length / 2; i++) {
            int x0 = (int) (myRnd.nextDouble() * (n - 1));
//            System.out.println(x0);
            Solution p0 = parent[x0];
            Solution p1 = parent[(int) (myRnd.nextDouble() * (n - 1))];
            Solution[] COchild;

            COchild = crossOver(p0, p1);

            offspring[indexOfOfspring] = COchild[0];
            indexOfOfspring++;
            offspring[indexOfOfspring] = COchild[1];
            indexOfOfspring++;

            Solution Mchild1 = generateRandomNeighbor(COchild[0]);
            offspring[indexOfOfspring] = Mchild1;
            indexOfOfspring++;

            Solution Mchild2 = generateRandomNeighbor(COchild[1]);
            offspring[indexOfOfspring] = Mchild2;
            indexOfOfspring++;
        }

        return offspring;
    }

    public static Solution[] sortIt(Solution[] a) {
//        System.out.println("sort started");
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i].getQuality() > a[i + 1].getQuality()) {
                    Solution temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                }
            }
//            System.out.println("loop end");
        }
        return a;
    }

    public static Solution[] elitism(Solution[] parent, Solution[] offspring) {
        Solution[] selection = new Solution[parent.length + offspring.length];
        int index = 0;
        for (int i = 0; i < parent.length; i++) {
            selection[index++] = parent[i];
        }
        for (int i = 0; i <offspring.length; i++) {
            selection[index++] = offspring[i];
        }
        
//        Arrays.sort(selection);
        selection = sortIt(selection);
        for (int i = 0; i < parent.length; i++) {
            parent[i] = selection[i];
        }
//        System.out.println(parent[0]);
//        System.out.println(parent[1]);

        return parent;
    }

    public static Solution GA(int maxGen, int n, int populationSize) {
        int gen = 0;

        Solution[] p = new Solution[populationSize];//generateRandomly(n);

        for (int i = 0; i < populationSize; i++) {
            p[i] = generateRandomly(n);
        }

//        System.out.println(Arrays.toString(p));
        for (Solution x : p) {
            if (x.isGoal()) {
                return x;
            }
        }

        while (gen++ < maxGen) {
            // step 1: generate children
            
            Solution[] ptemp = generateOffSpring(p);
//            System.out.println("offsprings \n" + Arrays.toString(ptemp));
            // step 2: check goal
            for (Solution x : ptemp) {
                if (x.isGoal()) {
                    GeneticAlgorithmIter = gen;
                    return x;
                }
            }

            // step 3: select
            p = elitism(p, ptemp);
            //p = select(p,ptemp);
        }
        return null;
    }

}
