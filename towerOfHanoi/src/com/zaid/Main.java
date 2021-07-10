// 3 DISC TOWER OF HANOI PUZZLE

package com.zaid;

import java.util.List;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static Scanner in = new Scanner(System.in);

    static Disc d1 = new Disc(1, "-");     // Size 1 disc
    static Disc d2 = new Disc(2, "--");    // Size 2 disc
    static Disc d3 = new Disc(3, "---");   // Size 3 disc
    static Disc d0 = new Disc(0, "|");     /* Size 0 disc
                                                   [0 sized disc's are used for printing a '|' character
                                                   if the index at the array is NULL, so that we can see the sticks]
                                                 */
    /*
    Create 3 arrays and copy them in Arrays.asList(here) in order to make the 3 towers we need with '|' shown
    where needed
    */
    static Disc[] tempArray1 = {d0, d1, d2, d3};
    static Disc[] tempArray2 = {d0, d0, d0, d0};
    static Disc[] tempArray3 = {d0, d0, d0, d0};

    // Create 3 serializable arrays, which cannot modify it's length unlike ArrayList
    static List<Disc> tower1 = Arrays.asList(tempArray1);
    static List<Disc> tower2 = Arrays.asList(tempArray2);
    static List<Disc> tower3 = Arrays.asList(tempArray3);

    // Draw to console the current positions of the discs
    static void drawState() {

        System.out.println("\n");
        int numOfFloors = 4;
        for (int i = 0; i < numOfFloors; i++) {
            System.out.println(tempArray1[i].getArt() + "\t" + tempArray2[i].getArt() + "\t" + tempArray3[i].getArt());
        }
        System.out.println("\n");
    }

    // Check whether tower2 elements are d0, d1, d2, d3 in order
    static boolean checkTowerTwo() {

        int count = 0;
        for (int i = 0; i < tower2.size(); i++) {
            if (tower2.get(i).getSize() == i) {
                count++;
            }
        }
        return (count == 4);
    }

    // Check whether tower3 elements are d0, d1, d2, d3 in order
    static boolean checkTowerThree() {

        int count = 0;
        for (int i = 0; i < tower3.size(); i++) {
            if (tower3.get(i).getSize() == i) {
                count++;
            }
        }
        return (count == 4);
    }

    // Check whether player won, this method uses checkTowerTow() && checkTowerThree() methods
    static boolean Win() {
        return ((checkTowerTwo()) || (checkTowerThree()));
    }

    // Function to return the index of the Disc which sits on top of the respective tower, if the tower is empty it will return the lowest disc a.k.a disc index = 3
    static int whoIsAtTheTopOfTower(int towerNumber) {

        if (towerNumber == 1) {
            if (tower1.get(3).equals(d0)) {
                return 3;
            }
            for (int i = tower1.size() - 1; i >= 0 ; i--) {
                if ((tower1.get(i-1).equals(d0))) {
                    return i;
                }
            }
        } else if (towerNumber == 2) {
            if (tower2.get(3).equals(d0)) {
                return 3;
            }
            for (int i = tower2.size() - 1; i >= 0 ; i--) {
                if ((tower2.get(i-1).equals(d0))) {
                    return i;
                }
            }
        } else {    // [towerNumber == 3]
            if (tower3.get(3).equals(d0)) {
                return 3;
            }
            for (int i = tower3.size() - 1; i >= 0 ; i--) {
                if ((tower3.get(i-1).equals(d0))) {
                    return i;
                }
            }
        }
        return -1;
    }

    // check whether tower is empty, i.e. whether tower is containing all d0 objects
    static boolean isTowerEmpty(int tower) {

        int d0Count = 0;

        if (tower == 1) {
            for (Disc i : tower1) {
                if (i.equals(d0)) {
                    d0Count++;
                }
            }
            return (d0Count == 4);
        } else if (tower == 2) {
            for (Disc i : tower2) {
                if (i.equals(d0)) {
                    d0Count++;
                }
            }
            return (d0Count == 4);
        } else {    // tower = 3
            for (Disc i : tower3) {
                if (i.equals(d0)) {
                    d0Count++;
                }
            }
            return (d0Count == 4);
        }
    }

    // check validity of the move
    static boolean isValid(int from, int to) {

        if ((from == 1) && (to == 2)) {
            if (tower1.get(whoIsAtTheTopOfTower(1)).getSize() > tower2.get(whoIsAtTheTopOfTower(2)).getSize()) {
                if (tower2.get(3).getSize() == 0) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        if ((from == 1) && (to == 3)) {
            if (tower1.get(whoIsAtTheTopOfTower(1)).getSize() > tower3.get(whoIsAtTheTopOfTower(3)).getSize()) {
                if (tower3.get(3).getSize() == 0) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        if ((from == 2) && (to == 1)) {
            if (tower2.get(whoIsAtTheTopOfTower(2)).getSize() > tower1.get(whoIsAtTheTopOfTower(1)).getSize()) {
                if (tower1.get(3).getSize() == 0) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        if ((from == 2) && (to == 3)) {
            if (tower2.get(whoIsAtTheTopOfTower(2)).getSize() > tower3.get(whoIsAtTheTopOfTower(3)).getSize()) {
                if (tower3.get(3).getSize() == 0) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        if ((from == 3) && (to == 1)) {
            if (tower3.get(whoIsAtTheTopOfTower(3)).getSize() > tower1.get(whoIsAtTheTopOfTower(1)).getSize()) {
                if (tower1.get(3).getSize() == 0) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        if ((from == 3) && (to == 2)) {
            if (tower3.get(whoIsAtTheTopOfTower(3)).getSize() > tower2.get(whoIsAtTheTopOfTower(2)).getSize()) {
                if (tower2.get(3).getSize() == 0) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    // This method is used in moveDisc(), swap the two disc's in this method
    static void  moveSOS(int from, int to) {

        if ((from == 1) && (to == 2)) {
            Disc dTemp = tower1.get(whoIsAtTheTopOfTower(1));
            tower1.set(whoIsAtTheTopOfTower(1), tower2.get(whoIsAtTheTopOfTower(2)-1));
            if (!(isTowerEmpty(2))) {
                tower2.set(whoIsAtTheTopOfTower(2)-1, dTemp);
            } else {
                tower2.set(whoIsAtTheTopOfTower(2), dTemp);
            }
        }
        if ((from == 1) && (to == 3)) {
            Disc dTemp = tower1.get(whoIsAtTheTopOfTower(1));
            tower1.set(whoIsAtTheTopOfTower(1), tower3.get(whoIsAtTheTopOfTower(3)-1));
            if (!(isTowerEmpty(3))) {
                tower3.set(whoIsAtTheTopOfTower(3)-1, dTemp);
            } else {
                tower3.set(whoIsAtTheTopOfTower(3), dTemp);
            }
        }
        if ((from == 2) && (to == 1)) {
            Disc dTemp = tower2.get(whoIsAtTheTopOfTower(2));
            tower2.set(whoIsAtTheTopOfTower(2), tower1.get(whoIsAtTheTopOfTower(1)-1));
            if (!(isTowerEmpty(1))) {
                tower1.set(whoIsAtTheTopOfTower(1)-1, dTemp);
            } else {
                tower1.set(whoIsAtTheTopOfTower(1), dTemp);
            }
        }
        if ((from == 2) && (to == 3)) {
            Disc dTemp = tower2.get(whoIsAtTheTopOfTower(2));
            tower2.set(whoIsAtTheTopOfTower(2), tower3.get(whoIsAtTheTopOfTower(3)-1));
            if (!(isTowerEmpty(3))) {
                tower3.set(whoIsAtTheTopOfTower(3)-1, dTemp);
            } else {
                tower3.set(whoIsAtTheTopOfTower(3), dTemp);
            }
        }
        if ((from == 3) && (to == 1)) {
            Disc dTemp = tower3.get(whoIsAtTheTopOfTower(3));
            tower3.set(whoIsAtTheTopOfTower(3), tower1.get(whoIsAtTheTopOfTower(1)-1));
            if (!(isTowerEmpty(1))) {
                tower1.set(whoIsAtTheTopOfTower(1)-1, dTemp);
            } else {
                tower1.set(whoIsAtTheTopOfTower(1), dTemp);
            }
        }
        if ((from == 3) && (to == 2)) {
            Disc dTemp = tower3.get(whoIsAtTheTopOfTower(3));
            tower3.set(whoIsAtTheTopOfTower(3), tower2.get(whoIsAtTheTopOfTower(2)-1));
            if (!(isTowerEmpty(2))) {
                tower2.set(whoIsAtTheTopOfTower(2)-1, dTemp);
            } else {
                tower2.set(whoIsAtTheTopOfTower(2), dTemp);
            }
        }
    }

    // Perform a legal move, i.e. swap legally abiding to the 2 rules of the game
    static void moveDisc(int fromThisTower, int toThisTower) {

        if (!((fromThisTower > 0) && (fromThisTower <= 3)) && !((toThisTower > 0) && (toThisTower <= 3))) { // cannot be out of range(0 - 3)
            System.out.println("Enter valid tower numbers [1-3] ");
        } else if (fromThisTower == toThisTower) {
            System.out.println("You just petted your disc");
        } else {
            moveSOS(fromThisTower, toThisTower);
        }

    }









    public static void main(String[] args) {

        System.out.print("Are you sure you wanna play? Y/N : ");
        String userResponse = in.nextLine();
        int numOfMoves = 0;
        String level;

        if (!(userResponse.toUpperCase().equals("Y"))) {
            System.out.println("Good choice! ;)");
            System.exit(0);
        }

        while (userResponse.toUpperCase().equals("Y")) {

            drawState();    // Show current state of game
            System.out.println("Enter your move... ");
            System.out.println("From Tower? ");
            int fromTower = in.nextInt();
            System.out.println("To Tower? ");
            int toTower = in.nextInt();
            if (isValid(fromTower, toTower)) { // check validity of move
                moveDisc(fromTower, toTower); // Move the discs
            } else {
                System.out.println("\nINVALID MOVE!!!");
            }

            if (Win()) {

                drawState();
                if (numOfMoves < 8) {
                    level = "Pro";
                } else if (numOfMoves < 10) {
                    level = "Amateur";
                } else {
                    level = "Noob";
                }
                numOfMoves++;
                System.out.println("YOU WIN, Congratulations " + level + "!\n");
                System.out.println("Total #moves played = " + (numOfMoves));
                break;
            } else {
                System.out.println("#moves played : " + (++numOfMoves) + "\n");
            }
        }
        in.close();
    }
}
