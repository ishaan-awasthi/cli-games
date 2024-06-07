import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //making board
        String[][] board = new String[6][7];
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
                board[row][col] = " ";
            }
        }

        boolean game_on = true;
        boolean player = true;
        String mark = "";

        while(game_on) // main game loop
        {
            display_board(board);

            if(player){
                System.out.println("Player One's turn!");
                mark = "X";
            } else{
                System.out.println("Player Two's turn!");
                mark = "O";
            }

            int turn = choose_turn();
            boolean check = true;
            for(int i = 5; i>-1; i--){
                if(check && board[i][turn-1].equals(" ")){
                    board[i][turn-1] = mark;
                    check = false;
                }
            }

            display_board(board);

            if (check_win(board, mark).equals("true")) {
                display_board(board);
                if (player) {
                    System.out.println("Player One wins!");
                } else {
                    System.out.println("Player Two wins!");
                }
                game_on = false;
            } else if (check_draw(board).equals("true")) {
                display_board(board);
                System.out.println("It's a draw!");
                game_on = false;
            } else {
                player = !player; // switch players and continue game
            }
        }
    }

    public static String check_win(String[][] board, String mark) {
        // any horizontal?
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 4; col++) {
                boolean win = true;
                for (int i = 0; i < 4; i++) {
                    if (win && !board[row][col + i].equals(mark)) {
                        win = false;
                    }
                }
                if (win) {
                    return "true";
                }
            }
        }

        // any vertical?
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 7; col++) {
                boolean win = true;
                for (int i = 0; i < 4; i++) {
                    if (win && !board[row + i][col].equals(mark)) {
                        win = false;
                    }
                }
                if (win) {
                    return "true";
                }
            }
        }

        // diagonal one?
        for (int row = 3; row < 6; row++) {
            for (int col = 0; col < 4; col++) {
                boolean win = true;
                for (int i = 0; i < 4; i++) {
                    if (win && !board[row - i][col + i].equals(mark)) {
                        win = false;
                    }
                }
                if (win) {
                    return "true";
                }
            }
        }

        // diag two?
        for (int row = 3; row < 6; row++) {
            for (int col = 3; col < 7; col++) {
                boolean win = true;
                for (int i = 0; i < 4; i++) {
                    if (win && !board[row - i][col - i].equals(mark)) {
                        win = false;
                    }
                }
                if (win) {
                    return "true";
                }
            }
        }

        return "false"; // no win (aka continue)
    }

    public static String check_draw(String[][] board) {
        // if full board
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
                if (board[row][col].equals(" ")) {
                    return "false"; // not a draw yet since open space
                }
            }
        }
        return "true"; // == yes, full and draw
    }

    public static void display_board(String[][] board){
        for (int i = 0; i < 50; i++) System.out.println();
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
                System.out.print("| " + board[row][col] + " ");
            }
            System.out.println("|");
        }
        System.out.println("  1   2   3   4   5   6   7");
    }

    public static int choose_turn(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pick a column (1-7): ");
        int turn = scanner.nextInt();
        scanner.nextLine();
        while(turn!=1 && turn!=2 && turn!=3 && turn!=4 && turn!=5 && turn!=6 && turn!=7){
            turn = scanner.nextInt();
            scanner.nextLine();
        }
        return turn;
    }
}
