import java.util.Scanner;

/*
BOARD DESIGN REFERENCE (MADE WITH UNICODE CHARACTERS)
System.out.println("╔═══╦═══╦═══╗");
System.out.println("║ 1 ║ 2 ║ 3 ║");
System.out.println("╠═══╬═══╬═══╣");
System.out.println("║ 4 ║ 5 ║ 6 ║");
System.out.println("╠═══╬═══╬═══╣");
System.out.println("║ 7 ║ 8 ║ 9 ║");
System.out.println("╚═══╩═══╩═══╝");
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String TL = "1";
        String TM = "2";
        String TR = "3";
        String ML = "4";
        String MM = "5";
        String MR = "6";
        String BL = "7";
        String BM = "8";
        String BR = "9";
        boolean game = true;
        boolean player = true;
        String mark = "";


        System.out.println("WELCOME TO TIC TAC TOE!");
        System.out.println("Player One is X, the other is O.");
        System.out.println();
        while(game){
            System.out.println("╔═══╦═══╦═══╗");
            System.out.println("║ " + TL + " ║ " + TM + " ║ " + TR + " ║");
            System.out.println("╠═══╬═══╬═══╣");
            System.out.println("║ " + ML + " ║ " + MM + " ║ " + MR + " ║");
            System.out.println("╠═══╬═══╬═══╣");
            System.out.println("║ " + BL + " ║ " + BM + " ║ " + BR + " ║");
            System.out.println("╚═══╩═══╩═══╝");
            System.out.println();

            if(player){
                mark = "X";
                System.out.println("Player One, what is your move? (1-9)");
            } else{
                mark = "O";
                System.out.println("Player Two, what is your move (1-9)");
            }
            int move = scanner.nextInt();
            scanner.nextLine();

            boolean move_bad = true;
            while(move_bad) {
                if (move == 1) {
                    if (TL.equals("1")){
                        TL = mark;
                        move_bad = false;
                    }
                    else System.out.println("That space isn't empty! Error forever since handling not required.");
                } else if (move == 2) {
                    if (TM.equals("2")){
                        TM = mark;
                        move_bad = false;
                    }
                    else System.out.println("That space isn't empty! Error forever since handling not required.");
                } else if (move == 3) {
                    if (TR.equals("3")){
                        TR = mark;
                        move_bad = false;
                    }
                    else System.out.println("That space isn't empty! Error forever since handling not required.");
                } else if (move == 4) {
                    if (ML.equals("4")){
                        ML = mark;
                        move_bad = false;
                    }
                    else System.out.println("That space isn't empty! Error forever since handling not required.");
                } else if (move == 5) {
                    if (MM.equals("5")){
                        MM = mark;
                        move_bad = false;
                    }
                    else System.out.println("That space isn't empty! Error forever since handling not required.");
                } else if (move == 6) {
                    if (MR.equals("6")){
                        MR = mark;
                        move_bad = false;
                    }
                    else System.out.println("That space isn't empty! Error forever since handling not required.");
                } else if (move == 7) {
                    if (BL.equals("7")){
                        BL = mark;
                        move_bad = false;
                    }
                    else System.out.println("That space isn't empty! Error forever since handling not required.");
                } else if (move == 8) {
                    if (BM.equals("8")){
                        BM = mark;
                        move_bad = false;
                    }
                    else System.out.println("That space isn't empty! Error forever since handling not required.");
                } else if (move == 9) {
                    if (BR.equals("9")){
                        BR = mark;
                        move_bad = false;
                    }
                    else System.out.println("That space isn't empty! Error forever since handling not required.");
                } else {
                    System.out.println("Move is out of bounds! Error forever since handling not required.");
                }
            }

            for(int i=0; i<50; i++){
                System.out.println();
            }

            if ((TL.equals(TM) && TL.equals(TR) && !TL.equals("1")) ||
                (ML.equals(MM) && ML.equals(MR) && !ML.equals("4")) ||
                (BL.equals(BM) && BL.equals(BR) && !BL.equals("7")) ||
                (TL.equals(ML) && TL.equals(BL) && !TL.equals("1")) ||
                (TM.equals(MM) && TM.equals(BM) && !TM.equals("2")) ||
                (TR.equals(MR) && TR.equals(BR) && !TR.equals("3")) ||
                (TL.equals(MM) && TL.equals(BR) && !TL.equals("1")) ||
                (TR.equals(MM) && TR.equals(BL) && !TR.equals("3")))
            { // THIS IS A WIN CASE

                System.out.println("╔═══╦═══╦═══╗");
                System.out.println("║ " + TL + " ║ " + TM + " ║ " + TR + " ║");
                System.out.println("╠═══╬═══╬═══╣");
                System.out.println("║ " + ML + " ║ " + MM + " ║ " + MR + " ║");
                System.out.println("╠═══╬═══╬═══╣");
                System.out.println("║ " + BL + " ║ " + BM + " ║ " + BR + " ║");
                System.out.println("╚═══╩═══╩═══╝");
                System.out.println();

                System.out.print("Player ");
                if(player) System.out.println("One wins! (X)");
                else System.out.println("Two wins! (O)");
                System.out.println("\nGame over.");
                game = false;

            } else {
                if (!TL.equals("1") && !TM.equals("2") && !TR.equals("3") &&
                    !ML.equals("4") && !MM.equals("5") && !MR.equals("6") &&
                    !BL.equals("7") && !BM.equals("8") && !BR.equals("9"))
                {  // THIS IS A DRAW CASE
                    System.out.println("╔═══╦═══╦═══╗");
                    System.out.println("║ " + TL + " ║ " + TM + " ║ " + TR + " ║");
                    System.out.println("╠═══╬═══╬═══╣");
                    System.out.println("║ " + ML + " ║ " + MM + " ║ " + MR + " ║");
                    System.out.println("╠═══╬═══╬═══╣");
                    System.out.println("║ " + BL + " ║ " + BM + " ║ " + BR + " ║");
                    System.out.println("╚═══╩═══╩═══╝");
                    System.out.println();

                    System.out.println("It's a draw!");
                    game = false;
                } else {
                    player = !player; // Switch players
                }
        }
}}}
