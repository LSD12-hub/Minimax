package tictactoe;

import java.util.ArrayList;
import java.util.*;

public class Difficulty {

    tictactoe t = new tictactoe();

    public Difficulty(){

    }
    //Ask player if they want to play with another player
    public void playerToPlayer(Scanner in){
        for(char [] c : t.board) System.out.println(c);
        ArrayList<Integer> record = new ArrayList<>();

        while(true){

            int pos = in.nextInt();
            while(record.contains(pos)){
                System.out.println("Enter new number");
                pos = in.nextInt();
            }
            record.add(pos);
            t.players(pos,"Player");
            if(!t.check()){
                System.out.println("You have won");
                break;
            }else if(record.size() == 9){
                System.out.println("It's a tie");
                break;
            }

            //this is for the weak player
            pos = in.nextInt();
            while(record.contains(pos)){
                System.out.println("Enter new Number");
                pos = in.nextInt();
            }
            record.add(pos);
            t.players(pos, "CPU");

            if(!t.check()){
                System.out.println("The CPU won");
                break;
            }else if(record.size() == 9){
                System.out.println("It's a tie");
                break;
            }
        }
    }

    //Ask player to play with random difficulty
    public void playerToRandom(Random rand, Scanner in){
        for(char [] c : t.board) System.out.println(c);
        ArrayList<Integer> record = new ArrayList<>();

        while(true){

            int pos = in.nextInt();
            while(record.contains(pos)){
                System.out.println("Enter new number");
                pos = in.nextInt();
            }
            record.add(pos);
            t.players(pos,"Player");
            if(!t.check()){
                System.out.println("You have won");
                break;
            }else if(record.size() == 9){
                System.out.println("It's a tie");
                break;
            }

            //this is for the weak player
            pos = rand.nextInt(9) + 1;
            while(record.contains(pos)){
                pos = rand.nextInt(9) + 1;
            }
            record.add(pos);
            t.players(pos, "CPU");

            if(!t.check()){
                System.out.println("The CPU won");
                break;
            }else if(record.size() == 9){
                System.out.println("It's a tie");
                break;
            }
        }
    }

    //Ask player tp play with smarter difficulty
    public void playerToAI(Scanner in){
        for(char [] c : t.board) System.out.println(c);
        ArrayList<Integer> record = new ArrayList<>();

        while(true){

            int pos = in.nextInt();
            while(record.contains(pos)){
                System.out.println("Enter new number");
                pos = in.nextInt();
            }
            record.add(pos);
            t.players(pos,"CPU");
            if(!t.check()){
                System.out.println("You have won");
                break;
            }else if(record.size() == 9){
                System.out.println("It's a tie");
                break;
            }

            //the strong player
            Minimax Move = new Minimax(t.board);
            Minimax bestMove = Move.findBestMove();
            t.board[bestMove.row][bestMove.col] = 'x';
            for(char [] c : t.board) System.out.println(c);
            if(!t.check()){
                System.out.println("The CPU won");
                break;
            }else if(record.size() == 9){
                System.out.println("It's a tie");
                break;
            }
        }
    }
}
