import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Card ace_hearts = new Card(1, "Hearts", "Ace");
        Card two_hearts = new Card(2, "Hearts", "Two");
        Card three_hearts = new Card(3, "Hearts", "Three");
        Card four_hearts = new Card(4, "Hearts", "Four");
        Card five_hearts = new Card(5, "Hearts", "Five");
        Card six_hearts = new Card(6, "Hearts", "Six");
        Card seven_hearts = new Card(7, "Hearts", "Seven");
        Card eight_hearts = new Card(8, "Hearts", "Eight");
        Card nine_hearts = new Card(9, "Hearts", "Nine");
        Card ten_hearts = new Card(10, "Hearts", "Ten");
        Card jack_hearts = new Card(10, "Hearts", "Jack");
        Card queen_hearts = new Card(10, "Hearts", "Queen");
        Card king_hearts = new Card(10, "Hearts", "King");

        Card ace_diamonds = new Card(1, "Diamonds", "Ace");
        Card two_diamonds = new Card(2, "Diamonds", "Two");
        Card three_diamonds = new Card(3, "Diamonds", "Three");
        Card four_diamonds = new Card(4, "Diamonds", "Four");
        Card five_diamonds = new Card(5, "Diamonds", "Five");
        Card six_diamonds = new Card(6, "Diamonds", "Six");
        Card seven_diamonds = new Card(7, "Diamonds", "Seven");
        Card eight_diamonds = new Card(8, "Diamonds", "Eight");
        Card nine_diamonds = new Card(9, "Diamonds", "Nine");
        Card ten_diamonds = new Card(10, "Diamonds", "Ten");
        Card jack_diamonds = new Card(10, "Diamonds", "Jack");
        Card queen_diamonds = new Card(10, "Diamonds", "Queen");
        Card king_diamonds = new Card(10, "Diamonds", "King");

        Card ace_clubs = new Card(1, "Clubs", "Ace");
        Card two_clubs = new Card(2, "Clubs", "Two");
        Card three_clubs = new Card(3, "Clubs", "Three");
        Card four_clubs = new Card(4, "Clubs", "Four");
        Card five_clubs = new Card(5, "Clubs", "Five");
        Card six_clubs = new Card(6, "Clubs", "Six");
        Card seven_clubs = new Card(7, "Clubs", "Seven");
        Card eight_clubs = new Card(8, "Clubs", "Eight");
        Card nine_clubs = new Card(9, "Clubs", "Nine");
        Card ten_clubs = new Card(10, "Clubs", "Ten");
        Card jack_clubs = new Card(10, "Clubs", "Jack");
        Card queen_clubs = new Card(10, "Clubs", "Queen");
        Card king_clubs = new Card(10, "Clubs", "King");

        Card ace_spades = new Card(1, "Spades", "Ace");
        Card two_spades = new Card(2, "Spades", "Two");
        Card three_spades = new Card(3, "Spades", "Three");
        Card four_spades = new Card(4, "Spades", "Four");
        Card five_spades = new Card(5, "Spades", "Five");
        Card six_spades = new Card(6, "Spades", "Six");
        Card seven_spades = new Card(7, "Spades", "Seven");
        Card eight_spades = new Card(8, "Spades", "Eight");
        Card nine_spades = new Card(9, "Spades", "Nine");
        Card ten_spades = new Card(10, "Spades", "Ten");
        Card jack_spades = new Card(10, "Spades", "Jack");
        Card queen_spades = new Card(10, "Spades", "Queen");
        Card king_spades = new Card(10, "Spades", "King");

        Card[] deck = {
                ace_hearts, two_hearts, three_hearts, four_hearts, five_hearts, six_hearts, seven_hearts, eight_hearts, nine_hearts, ten_hearts, jack_hearts, queen_hearts, king_hearts,
                ace_diamonds, two_diamonds, three_diamonds, four_diamonds, five_diamonds, six_diamonds, seven_diamonds, eight_diamonds, nine_diamonds, ten_diamonds, jack_diamonds, queen_diamonds, king_diamonds,
                ace_clubs, two_clubs, three_clubs, four_clubs, five_clubs, six_clubs, seven_clubs, eight_clubs, nine_clubs, ten_clubs, jack_clubs, queen_clubs, king_clubs,
                ace_spades, two_spades, three_spades, four_spades, five_spades, six_spades, seven_spades, eight_spades, nine_spades, ten_spades, jack_spades, queen_spades, king_spades
        };
        int[] discarded = new int[52];


        System.out.println("""
██████╗░██╗░░░░░░█████╗░░█████╗░██╗░░██╗░░░░░██╗░█████╗░░█████╗░██╗░░██╗
██╔══██╗██║░░░░░██╔══██╗██╔══██╗██║░██╔╝░░░░░██║██╔══██╗██╔══██╗██║░██╔╝
██████╦╝██║░░░░░███████║██║░░╚═╝█████═╝░░░░░░██║███████║██║░░╚═╝█████═╝░
██╔══██╗██║░░░░░██╔══██║██║░░██╗██╔═██╗░██╗░░██║██╔══██║██║░░██╗██╔═██╗░
██████╦╝███████╗██║░░██║╚█████╔╝██║░╚██╗╚█████╔╝██║░░██║╚█████╔╝██║░╚██╗
╚═════╝░╚══════╝╚═╝░░╚═╝░╚════╝░╚═╝░░╚═╝░╚════╝░╚═╝░░╚═╝░╚════╝░╚═╝░░╚═╝
                """);


        double player_balance = 1000;
        int dealer_score = 0;
        int player_score = 0;
        boolean game_on = true;

        while(game_on){
            System.out.println("\nPlayer, your current balance is $" + player_balance + ". Place a bet: ");

            Card dealer_current;
            Card player_current;

            // PLAYER PLACES BET
            double bet = scanner.nextDouble();
            scanner.nextLine();
            while(bet>player_balance || bet<=0){
                System.out.println("Please enter a proper bet within your balance ($" + player_balance + ")!");
                bet = scanner.nextInt();
                scanner.nextLine();
            }

            // DEALER IS DEALT TWO CARDS
            dealer_current = deck[draw_random(discarded)];
            if(dealer_current == ace_clubs ||
               dealer_current  == ace_diamonds ||
               dealer_current == ace_hearts ||
               dealer_current == ace_spades)
            {
                if(dealer_score+11 < 21) dealer_current.setValue(11);
            }
            dealer_score += dealer_current.getValue();
            System.out.println("Dealer's first card: " + dealer_current.getName() + " of " + dealer_current.getSuit());
            dealer_current = deck[draw_random(discarded)];
            if(dealer_current == ace_clubs ||
               dealer_current  == ace_diamonds ||
               dealer_current == ace_hearts ||
               dealer_current == ace_spades)
            {
                if(dealer_score+11 < 21) dealer_current.setValue(11);
            }
            dealer_score += dealer_current.getValue();
            System.out.println("Dealer's second card: *********");
            System.out.println();

            // PLAYER IS DEALT TWO CARDS
            player_current = deck[draw_random(discarded)];
            if(player_current == ace_clubs ||
               player_current == ace_diamonds ||
               player_current == ace_hearts ||
               player_current == ace_spades)
            {
                if(player_score+11 < 21) player_current.setValue(11);
            }
            player_score += player_current.getValue();
            System.out.println("Your first card: " + player_current.getName() + " of " + player_current.getSuit());
            player_current = deck[draw_random(discarded)];
            if(player_current == ace_clubs ||
               player_current == ace_diamonds ||
               player_current == ace_hearts ||
               player_current == ace_spades)
            {
                if(player_score+11 < 21) player_current.setValue(11);
            }
            player_score += player_current.getValue();
            System.out.println("Your second card: " + player_current.getName() + " of " + player_current.getSuit());
            System.out.println("Your score: " + player_score);
            System.out.println();

            // PLAYER PLAYS HIT UNTIL STAND
            boolean hit_or_stand = true;
            boolean player_bust = false;

            while(hit_or_stand)
            {
                System.out.println("Player, hit or stand?");
                if(scanner.nextLine().equals("hit")){
                    System.out.println("Dealer deals you a card...");
                    player_current = deck[draw_random(discarded)];
                    if(player_current == ace_clubs ||
                       player_current == ace_diamonds ||
                       player_current == ace_hearts ||
                       player_current == ace_spades)
                    {
                        if(player_score+11 < 21) player_current.setValue(11);
                    }
                    player_score += player_current.getValue();
                    System.out.println("You were dealt: " + player_current.getName() + " of " + player_current.getSuit());
                    System.out.println("Your score: " + player_score);
                    System.out.println();

                    if(player_score>21){
                        player_bust = true;
                        hit_or_stand = false;
                    }
                }
                else{
                    hit_or_stand = false;
                }
            }

            // DEALER PLAYS
            boolean dealer_go = true;
            boolean dealer_bust = false;
            System.out.println("The dealer flips his card... " + dealer_current.getName() + " of " + dealer_current.getSuit() + "!");
            if(!player_bust) System.out.println("Dealer's score: " + dealer_score);
            while(dealer_go && !player_bust)
            {
                if(dealer_score<17){
                    dealer_current = deck[draw_random(discarded)];
                    if(dealer_current == ace_clubs ||
                       dealer_current  == ace_diamonds ||
                       dealer_current == ace_hearts ||
                       dealer_current == ace_spades)
                    {
                        if(dealer_score+11 < 21) dealer_current.setValue(11);
                    }
                    dealer_score += dealer_current.getValue();
                    System.out.println("Dealer draws a card...");
                    System.out.println("Dealer drew: " + dealer_current.getName() + " of " + dealer_current.getSuit());
                    System.out.println();
                }

                if(dealer_score >= 17 && dealer_score < 22){
                    dealer_go = false;
                }

                if(dealer_score > 21){
                    dealer_bust = true;
                    dealer_go = false;
                }
            }

            // CHECK WIN
            System.out.println("------------------");
            System.out.println("Your score: " + player_score);
            System.out.println("Dealer's score: " + dealer_score);
            System.out.println();
            if(dealer_bust) {
                System.out.println("Dealer busts, player wins!");
                player_balance += bet;
                System.out.println("Balance: $" + player_balance);
            } else if(player_bust){
                System.out.println("Player busts and loses!");
                player_balance -= bet;
                System.out.println("New balance: $" + player_balance);
            } else if(player_score==dealer_score){
                System.out.println("Tie!");
                System.out.println("Balance: $" + player_balance);
            } else if(player_score>dealer_score){
                System.out.println("Player wins!");
                player_balance += bet;
                System.out.println("New balance: $" + player_balance);
            } else{
                System.out.println("Player loses!");
                player_balance -= bet;
                System.out.println("New balance: $" + player_balance);
            }
            System.out.println("------------------");

            if(player_balance<=0){
                System.out.println("Your balance is too low to continue playing.");
                game_on = false;
            }

            if(game_on){
                System.out.println("Play again? (y/n)");
                if(scanner.nextLine().equals("n")){
                    game_on = false;
                } else{
                    bet = 0;
                    player_score = 0;
                    dealer_score = 0;
                    discarded = new int[52];
                }
            }
        }

        System.out.println();
        System.out.println("Cashing out with $" + player_balance + "...");
        System.out.println("Thank you for playing blackjack!");
        System.out.println("------------------");
    }

    public static int draw_random(int[] discarded) {
        int index = 0;
        boolean yes = false;
        while (!yes) {
            index = (int) (Math.random() * 51) + 1;
            yes = true;
            int i = 0;
            while (i < discarded.length && yes) {
                if (discarded[i] == index) yes = false;
                i++;
            }
        }
        if (yes) {
            int i = 0;
            while (i < discarded.length && discarded[i] != 0) i++;
            if (i < discarded.length) discarded[i] = index;
        }
        return index;
    }


}
