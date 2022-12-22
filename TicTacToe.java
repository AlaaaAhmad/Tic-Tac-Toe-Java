import java.util.Scanner;

public class TicTacToe {
   private Scanner scanner;
   String player1, player2;
   int numOfMoves;
   String board[][];

    public TicTacToe()
    {
         scanner = new Scanner(System.in);
         board = new String[3][3];
         player1 = "O";
         player2 = "X";
         numOfMoves = 0;
    }
    public static void main(String[] args) {
          TicTacToe game = new TicTacToe();
          game.run();

    }
    public void run()
    {
        String input  = player1;
        String repeatingGame = "";
        boolean endGame = false;
        setUpBoard();
        do {
            displayUpdatedBoard();
            takeTurn(input);
            input = changeTurns(input);
            numOfMoves++;
            if (numOfMoves == 9 && winner().equals(" "))
            {
                displayUpdatedBoard();
                System.out.println("TIE!");
                repeatingGame = askToPlayAgain();
            }
            else if (numOfMoves <=9 &&  !winner().equals(" "))
            {
                displayUpdatedBoard();
                System.out.println("The winner is Player " + winner()+"!");
                repeatingGame = askToPlayAgain();

            }

            if (repeatingGame.equalsIgnoreCase("no"))
            {
                endGame = true;
            }
            else if (repeatingGame.equalsIgnoreCase("yes"))
            {
                repeatingGame = "";
                setUpBoard();
                numOfMoves = 0;
                input = player1;
            }

        } while (!endGame);


    }

    public void setUpBoard()
    {
        System.out.println("Welcome to the Tic Tac Toe game!");
        for (int i = 0; i < 3; i++)
         {
            for (int j = 0; j < 3; j++)
            {
                board[i][j] = " ";
            }
         }
    }

    public void displayUpdatedBoard()
    {
          for (int i = 0; i < 3; i++)
           {
              for (int j = 0; j < 3; j++)
              {
                  System.out.print("["+board[i][j]+"]");
              }
               System.out.print("\n");
           }

    }

    public String changeTurns (String turn)
    {
        if (turn == player1)
        {
            turn = player2;
        }
        else
        {
            turn = player1;
        }
          return turn;
    }

    public void takeTurn(String move)
    {
        int playerRow = 0, playerColumn = 0;
         boolean moveMade = false;
         do {
             System.out.println("Player "+ move+", Please enter a row number:1, 2, or 3 ");
             playerRow = scanner.nextInt();
             System.out.println("Player "+ move+", Please enter a column number:1, 2, or 3 ");
             playerColumn = scanner.nextInt();
             if (playerRow >= 1 && playerRow <= 3 && playerColumn >= 1 && playerColumn <= 3 && board[playerRow-1][playerColumn-1].equals(" "))
             {
                 board[playerRow-1][playerColumn-1] = move;
                 moveMade = true;
             }
             else
             {
                 System.out.println("Invalid input, Please try again");
             }

         }while (!moveMade);
    }

    public String winner()
    {
        //Checking rows
        for (int i = 0; i < 3; i++)
        {
            if(board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] != " ") {
                return board[i][0];
            }
        }
        //Checking columns
        for (int i = 0; i < 3; i++)
        {
            if(board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] != " ") {
                return board[i][0];
            }
        }
        //Checking Diagonals
        if (board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] != " ")
        {
            return board[0][0];
        }
        if (board[0][2] == board[1][1] && board[0][2] == board[2][0])
        {
            return board[0][2];
        }


        return " ";
    }
    public String askToPlayAgain()
    {
        String status = " ";
        while (!(status.equalsIgnoreCase("yes") || status.equalsIgnoreCase("no")) && !status.equals(""))
        {
            System.out.println("Do you want to play again? (yes/no)");
            status = scanner.next();
        }
         return status;
    }
}