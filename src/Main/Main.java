package Main;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static char[][] field = new char[12][12];

    public static void main(String[] args) {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                field[i][j] = '~';
            }
        }
        boolean nextShip = true;
        int ship = 0;
        do {
            ShipContainer Ship = ShipContainer.values()[ship];
            if (nextShip) {
                Main.showField();
                System.out.println("Enter the coordinates of the " + Ship.getShipName() + " (" + Ship.getNumberOfCells() + " cells):");
            }

            String pos1 = scanner.next();
            String pos2 = scanner.next();
            boolean isEmpty = true;
            char L1 = pos1.charAt(0);
            int D1 = Integer.parseInt(pos1.substring(1));
            char L2 = pos2.charAt(0);
            int D2 = Integer.parseInt(pos2.substring(1));

            if ((1 + Math.abs(D1 - D2) == Ship.getNumberOfCells() && L1 == L2)
                    || ((Math.abs(L1 - L2) + 1) == Ship.getNumberOfCells() && D1 == D2)) {

                if (L1 == L2) { //
                    int j;
                    char i;

                    if (D1 > D2) {
                        for (i = (char) (L1 - 1); i <= (char) (L1 + 1); i++) {
                            for (j = D2 - 1; j <= D1 + 1; j++) {
                                if (field[i - '@'][j] == '~') {
                                    isEmpty = true;
                                } else {
                                    isEmpty = false;
                                    break;
                                }
                            }
                            if (!isEmpty)
                                break;
                        }
                    } else {
                        for (i = (char) (L1 - 1); i <= (char) (L1 + 1); i++) {
                            for (j = D1 - 1; j <= D2 + 1; j++) {
                                if (field[i - '@'][j] == '~') {
                                    isEmpty = true;
                                } else {
                                    isEmpty = false;
                                    break;
                                }
                            }
                            if (!isEmpty)
                                break;
                        }
                    }
                } else if (D1 == D2) {
                    int j;
                    char i;
                    if (L1 > L2) {
                        for (j = D1 - 1; j <= D1 + 1; j++) {
                            for (i = (char) (L2 - 1); i <= (char) (L1 + 1); i++) {
                                if (field[i - '@'][j] == '~')
                                    isEmpty = true;
                                else {
                                    isEmpty = false;
                                    break;
                                }
                            }
                            if (!isEmpty)
                                break;
                        }
                    } else {
                        for (j = D1 - 1; j <= D1 + 1; j++) {
                            for (i = (char) (L1 - 1); i <= (char) (L2 + 1); i++) {
                                if (field[i - '@'][j] == '~') {
                                    isEmpty = true;
                                } else {
                                    isEmpty = false;
                                    break;
                                }
                            }
                            if (!isEmpty)
                                break;
                        }
                    }
                }
                if (isEmpty) {
                    char a = L1 < L2 ? L1 : L2;
                    char b = L1 < L2 ? L2 : L1;
                    int A = Math.min(D1, D2);
                    int B = Math.max(D1, D2);

                    for (char i = a; i <= b; i++) {
                        for (int j = A; j <= B; j++) {
                            field[i - '@'][j] = 'O';
                        }
                    }
                    ship++;
                    nextShip = true;
                } else {
                    System.out.println("Error! You placed it too close to another one. Try again:");
                    nextShip = false;
                }
            } else {
                if (L1 == L2 || D1 == D2)
                    System.out.println("Error! Wrong length of the " + Ship.getShipName() + "! Try again:");
                else {
                    System.out.println("Error! Wrong ship location! Try again:");
                }
                nextShip = false;
            }
        } while (ship != ShipContainer.values().length);

    }

    public static void showField() {
        System.out.print(" ");
        for (int i = 0; i < 10; i++) {
            System.out.print(" " + (i + 1));
        }
        System.out.println();
        for (char i = 'A'; i <= 'J'; i++) {
            System.out.print(i);
            for (int j = 1; j < 11; j++) {
                System.out.print(" " + field[i - '@'][j]);
            }
            System.out.println();
        }
    }
}

enum ShipContainer {
    AIRCRAFT_CARRIER("Aircraft Carrier", 5),
    BATTLESHIP("Battleship", 4),
    SUBMARINE("Submarine", 3),
    CRUISER("Cruiser", 3),
    DESTROYER("Destroyer", 2);
    private final String shipName;
    private final int numberOfCells;

    ShipContainer(String shipName, int numberOfCells) {
        this.shipName = shipName;
        this.numberOfCells = numberOfCells;
    }

    public String getShipName() {
        return shipName;
    }

    public int getNumberOfCells() {
        return numberOfCells;
    }
}


