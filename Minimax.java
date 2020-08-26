package tictactoe;

public class Minimax {

    public char [][] board;
    public int row, col;
    public char player = 'x', opponent = 'o';

    public Minimax(char [][] board){
        this.board = board;
    }

    public Minimax findBestMove(){

        int bestVal = -1000;
        Minimax bestMove = new Minimax(this.board);
        bestMove.row = -1;
        bestMove.col = -1;

        for(int i = 0; i < board.length; i += 2){
            for(int j = 0; j < board[0].length; j += 2){
                if(board[i][j] == ' '){

                    board[i][j] = player;

                    int moveVal = minimax(board, 0, false);

                    board[i][j] = ' ';

                    if(moveVal > bestVal){
                        bestMove.row = i;
                        bestMove.col = j;
                        bestVal = moveVal;
                    }
                }
            }
        }
        //System.out.println("The best move is " + bestVal);
        return bestMove;
    }

    public int minimax(char[][] board, int depth, boolean isMax) {
        int score = evaluate(board);

        if(score == 10){
            return score;
        }

        if(score == -10){
            return score;
        }

        if(!isMoveLeft(board)){
            return 0;
        }

        //if maximiser turn
        if(isMax){
            int best = -1000;

            for(int i = 0; i < board.length; i += 2){
                for(int j = 0; j < board[0].length; j += 2){
                    if(board[i][j] == ' '){
                        board[i][j] = player;
                        best = Math.max(best, minimax(board,depth + 1, !isMax));
                        board[i][j] = ' ';
                    }
                }
            }
            return best;
        //if minimiser's turn
        }else{
            int best = 1000;

            for(int i = 0; i < board.length; i += 2){
                for(int j = 0; j < board[0].length; j += 2){
                    if(board[i][j] == ' '){
                        board[i][j] = opponent;
                        best = Math.min(best, minimax(board, depth + 1, !isMax));
                        board[i][j] = ' ';
                    }
                }
            }
            return best;
        }
    }

    public boolean isMoveLeft(char[][] board) {
        for(int i = 0; i < board.length; i += 2){
            for(int j = 0; j < board[0].length; j += 2){
                if(board[i][j] == ' '){
                    return true;
                }
            }
        }
        return false;
    }

    public int evaluate(char[][] board) {
        //check the rows
        for(int row = 0; row < board.length; row += 2){
            if(board[row][0] == board[row][1] && board[row][1] == board[row][2]){
                if(board[row][0] == player){
                    return 10;
                }else if(board[row][0] == opponent){
                    return -10;
                }
            }
        }

        //check the colums
        for(int col = 0; col < board.length; col += 2){
            if(board[0][col] == board[1][col] && board[1][col] == board[2][col]){
                if(board[0][col] == player){
                    return 10;
                }else if(board[0][col] == opponent){
                    return  -10;
                }
            }
        }

        //check the diagonals
        if(board[0][0] == board[2][2] && board[2][2] == board[4][4]){
            if(board[0][0] == player){
                return 10;
            }else if(board[0][0] == opponent){
                return -10;
            }
        }

        if(board[0][4] == board[2][2] && board[2][2] == board[4][0]){
            if(board[0][0] == player){
                return 10;
            }else if(board[0][0] == opponent){
                return -10;
            }
        }

        return 0;
    }
}
