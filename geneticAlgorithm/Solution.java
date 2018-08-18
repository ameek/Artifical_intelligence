package geneticAlgorithm;

import java.util.*;
public class Solution {

    private int[] queens;

    public boolean isGoal() {
        for (int i = 0; i < queens.length; i++) {
            for (int j = i + 1; j < queens.length; j++) {
                if (queens[i] == queens[j]) {
                    return false;
                }
                if (Math.abs(i - j) == Math.abs(queens[i] - queens[j])) {
                    return false;
                }
            }
        }
        return true;
    }

    public int getQuality() {
        int quality = 0;
        for (int i = 0; i < queens.length; i++) {
            for (int j = i + 1; j < queens.length; j++) {
                if (queens[i] == queens[j]) {
                    quality++;
                }
                if (Math.abs(i - j) == Math.abs(queens[i] - queens[j])) {
                    quality++;
                }
            }
        }
        return quality;
    }

    public Solution(int n) {
        queens = new int[n];
    }

    public int[] getQueens() {
        return queens;
    }

    public void setQueens(int[] queens) {
        this.queens = queens;
    }

    public Solution(int[] queens) {
        this.queens = new int[queens.length];
        for (int i = 0; i < queens.length; i++) {
            this.queens[i] = queens[i];
        }
    }

    public Solution(Solution s) {
        this.queens = new int[s.getQueens().length];
        for (int i = 0; i < queens.length; i++) {
            this.queens[i] = s.getQueens()[i];
        }
    }

    @Override
    public String toString() {
        return "Solution [queens=" + Arrays.toString(queens) + "]";
    }

    public int compareTo(Solution o1) {
        int o1Value = ((Solution) o1).getQuality();
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        return this.getQuality() - o1Value;
        return o1Value - this.getQuality();
    }

}
