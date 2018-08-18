package Astarsearch;

import java.util.*;

public class Node implements Comparator<Node>{

    
    public int state[][] = new int[3][3];
    public ArrayList<Integer> actions = new ArrayList<Integer>();

    public boolean equals(Node other) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (state[i][j] != other.state[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public Node() {

    }

    public boolean isGoal() {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (state[i][j] == count) {
                    count++;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public int getTotalCost() {
        int gOFx = this.actions.size();
//        System.out.println(gOFx);
        int hOFx = manhatanDistance();
//        System.out.println(hOFx);

        return gOFx + hOFx;
    }

    public int manhatanDistance() {
        int totalManhatan = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (state[i][j] != 0) {
                    int goal = state[i][j];
                    int goal_I = goal / 3;
                    int goal_J = goal % 3;
                    int goalDistance = Math.abs(goal_I - i) + Math.abs(goal_J - j);
                    totalManhatan = totalManhatan + goalDistance;
                }
            }
        }
        return totalManhatan;
    }

    public Node performUp() {
        int row = -1;
        int column = -1;
        int found = 0;
        for (row = 0; row < 3; row++) {
            for (column = 0; column < 3; column++) {
                if (state[row][column] == 0) {
                    found = 1;
                    break;
                }

            }
            if (found == 1) {
                break;
            }
        }
        if (row == 0) {
            return null; // up not possible
        } else {
            Node upChild = new Node();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    upChild.state[i][j]
                            = this.state[i][j];
                }
            }
            upChild.state[row][column]
                    = upChild.state[row - 1][column];
            upChild.state[row - 1][column] = 0;

            upChild.actions = new ArrayList<Integer>(this.actions);
            upChild.actions.add(0);

            return upChild;
        }
    }

    public Node performDown() {
        int row = -1;
        int column = -1;
        int found = 0;
        for (row = 0; row < 3; row++) {
            for (column = 0; column < 3; column++) {
                if (state[row][column] == 0) {
                    found = 1;
                    break;
                }

            }
            if (found == 1) {
                break;
            }
        }
        if (row == 2) {
            return null; // down not possible
        } else {
            Node upChild = new Node();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    upChild.state[i][j]
                            = this.state[i][j];
                }
            }
            upChild.state[row][column]
                    = upChild.state[row + 1][column];
            upChild.state[row + 1][column] = 0;

            upChild.actions
                    = new ArrayList<Integer>(this.actions);
            upChild.actions.add(1);

            return upChild;
        }
    }

    public Node performLeft() {
        int row = -1;
        int column = -1;
        int found = 0;
        for (row = 0; row < 3; row++) {
            for (column = 0; column < 3; column++) {
                if (state[row][column] == 0) {
                    found = 1;
                    break;
                }

            }
            if (found == 1) {
                break;
            }
        }
        if (column == 0) {
            return null; // up not possible
        } else {
            Node upChild = new Node();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    upChild.state[i][j]
                            = this.state[i][j];
                }
            }
            upChild.state[row][column]
                    = upChild.state[row][column - 1];
            upChild.state[row][column - 1] = 0;

            upChild.actions
                    = new ArrayList<Integer>(this.actions);
            upChild.actions.add(2);

            return upChild;
        }
    }

    public Node performRight() {
        int row = -1;
        int column = -1;
        int found = 0;
        for (row = 0; row < 3; row++) {
            for (column = 0; column < 3; column++) {
                if (state[row][column] == 0) {
                    found = 1;
                    break;
                }

            }
            if (found == 1) {
                break;
            }
        }
        if (column == 2) {
            return null; // up not possible
        } else {
            Node upChild = new Node();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    upChild.state[i][j]
                            = this.state[i][j];
                }
            }
            upChild.state[row][column]
                    = upChild.state[row][column + 1];
            upChild.state[row][column + 1] = 0;

            upChild.actions
                    = new ArrayList<Integer>(this.actions);
            upChild.actions.add(3);

            return upChild;
        }
    }

        public String stateString() {
        String temp = "";
        for (int[] x : state) {
            for (int y : x) {
                temp = temp + y + " ";
            }
            temp = temp + " ";
        }
        return temp;
    }

    @Override
    public String toString() {
        return "Node [state=" + stateString() + ", actions=" + actions + "]";
    }

    @Override
    public int compare(Node o1, Node o2) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return o1.getTotalCost()-o2.getTotalCost();
    }

}
