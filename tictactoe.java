package tictactoe;

import java.util.*;

public class tictactoe {

    static Scanner in = new Scanner(System.in);
    static Random rand = new Random();
    static Difficulty d = new Difficulty();

    public char [][] board = {{' ','|',' ','|',' '},
            {'-','+','-','+','-'},
            {' ','|',' ','|',' '},
            {'-','+','-','+','-'},
            {' ','|',' ','|',' '},};

    public static void main(String[] args) {
        System.out.print("press (p) to play against a person (e) to play against easier CPU (m) to play against harder CPU: ");
        String ans = in.nextLine();
        if(ans.equals("p"))d.playerToPlayer(in);
        else if(ans.equals("e"))d.playerToRandom(rand, in);
        else if(ans.equals("m"))d.playerToAI(in);
        else System.exit(0);
    }

    public boolean check(){

        if(board[0][0] == 'x' && board[0][2] == 'x' && board[0][4] == 'x')return false;
        else if(board[2][0] == 'x' && board[2][2] == 'x' && board[2][4] == 'x')return false;
        else if(board[4][0] == 'x' && board[4][2] == 'x' && board[4][4] == 'x')return false;
        else if(board[0][0] == 'x' && board[2][0] == 'x' && board[4][0] == 'x')return false;
        else if(board[0][2] == 'x' && board[2][2] == 'x' && board[4][2] == 'x')return false;
        else if(board[0][4] == 'x' && board[2][4] == 'x' && board[4][4] == 'x')return false;
        else if(board[0][0] == 'x' && board[2][2] == 'x' && board[4][4] == 'x')return false;
        else if(board[4][0] == 'x' && board[2][2] == 'x' && board[0][4] == 'x')return false;

        if(board[0][0] == 'o' && board[0][2] == 'o' && board[0][4] == 'o')return false;
        else if(board[2][0] == 'o' && board[2][2] == 'o' && board[2][4] == 'o')return false;
        else if(board[4][0] == 'o' && board[4][2] == 'o' && board[4][4] == 'o')return false;
        else if(board[0][0] == 'o' && board[2][0] == 'o' && board[4][0] == 'o')return false;
        else if(board[0][2] == 'o' && board[2][2] == 'o' && board[4][2] == 'o')return false;
        else if(board[0][4] == 'o' && board[2][4] == 'o' && board[4][4] == 'o')return false;
        else if(board[0][0] == 'o' && board[2][2] == 'o' && board[4][4] == 'o')return false;
        else if(board[4][0] == 'o' && board[2][2] == 'o' && board[0][4] == 'o')return false;

        return true;
    }

    public void players(int pos, String player){

        char character = ' ';
        if(player.equals("Player"))character = 'x';
        else if(player.equals("CPU"))character = 'o';

        switch(pos){
            case 1:
                board[4][0] = character;
                break;
            case 2:
                board[4][2] = character;
                break;
            case 3:
                board[4][4] = character;
                break;
            case 4:
                board[2][0] = character;
                break;
            case 5:
                board[2][2] = character;
                break;
            case 6:
                board[2][4] = character;
                break;
            case 7:
                board[0][0] = character;
                break;
            case 8:
                board[0][2] = character;
                break;
            case 9:
                board[0][4] = character;
                break;
            default:
                break;
        }

        for(char [] c : board) System.out.println(c);
    }
}
