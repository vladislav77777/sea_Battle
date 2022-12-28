package Main;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static char[][] field = new char[12][12];
    static char[][] field2 = new char[12][12];


    public static void main(String[] args) {
        System.out.println("Player 1, place your ships on the game field");
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
                Main.showField(); // rex
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
        Main.showField();
        System.out.println("Press Enter and pass the move to another player");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Player 2, place your ships on the game field");
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                field2[i][j] = '~';
            }
        }
        nextShip = true;
        ship = 0;
        do {
            ShipContainer Ship = ShipContainer.values()[ship];
            if (nextShip) {
                Main.showField2(); // rex
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
                                if (field2[i - '@'][j] == '~') {
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
                                if (field2[i - '@'][j] == '~') {
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
                                if (field2[i - '@'][j] == '~')
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
                                if (field2[i - '@'][j] == '~') {
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
                            field2[i - '@'][j] = 'O';
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
        Main.showField2();

        boolean isAllSunk = false;

        while (!isAllSunk) {
            System.out.println("Press Enter and pass the move to another player");
            try {
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Main.showEmptyField2();
            System.out.println("---------------------");
            Main.showField();
            System.out.println("Player 1, it's your turn:");

            String pos = scanner.next();
            char L = pos.charAt(0);
            int D = Integer.parseInt(String.valueOf(pos.substring(1)));
            while (!(('A' <= L) && (L <= 'J')) || !(1 <= D && D <= 10)) {
                System.out.println("Error! You entered the wrong coordinates! Try again:");
                pos = scanner.next();
                L = pos.charAt(0);
                D = Integer.parseInt(String.valueOf(pos.substring(1)));
            }
            if (field2[L - '@'][D] == 'O' || field2[L - '@'][D] == 'X') {
                field2[L - '@'][D] = 'X';
                boolean isEntireShipSank = true;
                for (int i = L - '@' - 1; i <= L - '@' + 1; i++) {
                    for (int j = D - 1; j <= D + 1; j++) {
                        if (field2[i][j] == 'O'){
                            isEntireShipSank = false;
                            break;
                        }
                    }
                    if (!isEntireShipSank)
                        break;
                }
                Main.showEmptyField();
                if (!isEntireShipSank) {
                    System.out.println("You hit a ship!");
                } else{
                    System.out.println("You sank a ship!");
                }
            } else if (field2[L - '@'][D] == '~' || field2[L - '@'][D] == 'M') {
                field2[L - '@'][D] = 'M';
                Main.showEmptyField();
                System.out.println("You missed!");
            }
            isAllSunk = checkAllShipsSank() | checkAllShipsSank2();
            if (isAllSunk)
                break;
            System.out.println("Press Enter and pass the move to another player");
            try {
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Main.showEmptyField();
            System.out.println("---------------------");
            Main.showField2();
            System.out.println("Player 2, it's your turn:");
            pos = scanner.next();
            L = pos.charAt(0);
            D = Integer.parseInt(String.valueOf(pos.substring(1)));
            while (!(('A' <= L) && (L <= 'J')) || !(1 <= D && D <= 10)) {
                System.out.println("Error! You entered the wrong coordinates! Try again:");
                pos = scanner.next();
                L = pos.charAt(0);
                D = Integer.parseInt(String.valueOf(pos.substring(1)));
            }
            if (field[L - '@'][D] == 'O' || field[L - '@'][D] == 'X') {
                field[L - '@'][D] = 'X';
                boolean isEntireShipSank = true;
                for (int i = L - '@' - 1; i <= L - '@' + 1; i++) {
                    for (int j = D - 1; j <= D + 1; j++) {
                        if (field[i][j] == 'O'){
                            isEntireShipSank = false;
                            break;
                        }
                    }
                    if (!isEntireShipSank)
                        break;
                }
                Main.showEmptyField();
                if (!isEntireShipSank) {
                    System.out.println("You hit a ship!");
                } else{
                    System.out.println("You sank a ship!");
                }
            } else if (field[L - '@'][D] == '~' || field[L - '@'][D] == 'M') {
                field[L - '@'][D] = 'M';
                Main.showEmptyField();
                System.out.println("You missed!");
            }
            isAllSunk = checkAllShipsSank() | checkAllShipsSank2();
        }
        System.out.println("You sank the last ship. You won. Congratulations!");
    }

    public static boolean checkAllShipsSank() {
        boolean isSank = false;
        for (char i = 'A'; i <= 'J'; i++) {
            for (int j = 1; j < 11; j++) {
                if (field[i - '@'][j] != 'O') {
                    isSank = true;
                } else {
                    isSank = false;
                    break;
                }
            }
            if (!isSank)
                break;
        }
        return isSank;
    }

    public static boolean checkAllShipsSank2() {
        boolean isSank = false;
        for (char i = 'A'; i <= 'J'; i++) {
            for (int j = 1; j < 11; j++) {
                if (field2[i - '@'][j] != 'O') {
                    isSank = true;
                } else {
                    isSank = false;
                    break;
                }
            }
            if (!isSank)
                break;
        }
        return isSank;
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

    public static void showField2() {
        System.out.print(" ");
        for (int i = 0; i < 10; i++) {
            System.out.print(" " + (i + 1));
        }
        System.out.println();
        for (char i = 'A'; i <= 'J'; i++) {
            System.out.print(i);
            for (int j = 1; j < 11; j++) {
                System.out.print(" " + field2[i - '@'][j]);
            }
            System.out.println();
        }
    }

    public static void showEmptyField() {
        System.out.print(" ");
        for (int i = 0; i < 10; i++) {
            System.out.print(" " + (i + 1));
        }
        System.out.println();
        for (char i = 'A'; i <= 'J'; i++) {
            System.out.print(i);
            for (int j = 1; j < 11; j++) {
                if (field[i - '@'][j] == 'M' || field[i - '@'][j] == 'X')
                    System.out.print(" " + field[i - '@'][j]);
                else
                    System.out.print(" ~");
            }
            System.out.println();
        }
    }

    public static void showEmptyField2() {
        System.out.print(" ");
        for (int i = 0; i < 10; i++) {
            System.out.print(" " + (i + 1));
        }
        System.out.println();
        for (char i = 'A'; i <= 'J'; i++) {
            System.out.print(i);
            for (int j = 1; j < 11; j++) {
                if (field2[i - '@'][j] == 'M' || field2[i - '@'][j] == 'X')
                    System.out.print(" " + field2[i - '@'][j]);
                else
                    System.out.print(" ~");
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


