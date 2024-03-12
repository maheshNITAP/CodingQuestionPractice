import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BackTracking {
    public static void printPermutationes(String str, int indx, String permu){
        if(str.length() == 0 ){
            System.out.println(permu);
            return;
        }
        for(int i=0;i<str.length();i++){
            String newString = str.substring(0,i)+str.substring(i+1);
            printPermutationes(newString,indx+1,permu+str.charAt(i));
        }
    }

    private static void printMatrix(List<List<String>> allBoards) {
        for(int i=0;i<allBoards.size();i++){
            List<String> board= allBoards.get(i);
            board.stream().forEach(item-> System.out.print(item));
            System.out.println();
        }
    }
    public static void solveNQueens(int n) {
        List<List<String>> allBoards = new ArrayList<>();
        char[][] board= new char[n][n];
        helper(board,allBoards,0);
        printMatrix(allBoards);
    }

    public static boolean isSafe(char[][] board,int row, int col){
        // check the column
        for(int i=0;i<board.length;i++){
            if(board[row][i]== 'Q')
                return false;
        }
        // check all the rows
        for(int i=0;i<board.length;i++){
            if(board[i][col]=='Q')
                return  false;
        }
        // check upper left daigonal
        int r= row;
         for(int c=col;c>=0 && r>=0;c--, r--){
             if(board[r][c]== 'Q')
                 return false;
         }
         // check upper right;
        r= row;
         for(int c=col;c<board.length && r>=0;c++,r--){
            if(board[r][c]=='Q')
                return false;
         }
         //check lower left
        r=row;
         for(int c=col;r<board.length && c>=0;c--,r++){
             if(board[r][c]=='Q')
                 return false;
         }
        //check lower right
        r=row;
         for(int c=col;c<board.length && r<board.length;c++,r++){
             if(board[r][c]=='Q')
                 return false;
         }
         return  true;
    }
    private static void saveBoard(char[][] board, List<List<String>> allBoards) {
        String row ="";
        List<String> newBoard= new ArrayList<>();
        for(int i=0;i<board.length;i++){
            row="";
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='Q'){
                    row+="Q";
                }
                else {
                    row+=".";
                }
            }
            newBoard.add(row);
        }
        allBoards.add(newBoard);
    }
    private static void helper(char[][] board, List<List<String>> allBoards, int col) {
        // base case
        if(col== board.length){
            saveBoard(board,allBoards);
            return;
        }
        //recursive
        for (int row = 0; row < board[0].length; row++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                helper(board, allBoards, col + 1);
                board[row][col] = '.';
            }
        }
    }

    public static boolean IsSafeNumberforthisNumber(char[][] board, int number,int row,int col){
        //check in row and column
        for(int i=0;i<board.length;i++){
            if(board[i][col]== (char) (number+'0')){ // check in  col
                return false;
            }
            if(board[row][i] == (char) (number+'0')){ //  check in row
                return false;
            }
        }
        //check in sub metrix
        int sr=(row/3)*3;
        int sc =(col/3)*3;
        for(int i=sr;i<sr+3;i++){
            for(int j=sc;j<sc+3;j++){
                if(board[i][j]== (char) (number+'0')){
                    return false;
                }
            }
        }
        return  true;
    }



    public static boolean sudokuHelper(char[][] board,int row,int col){
        //base condition
        if(row==board.length){ // if we filled all the row with coorect order and we reached to end
            return true;
        }
        int nrow=0;
        int ncol=0;
        if(col != board.length-1){
            nrow= row;
            ncol=col+1;
        }else{
            nrow= row+1;
            ncol= 0;
        }
        if(board[row][col] !='.'){ // if board[row][col]==='Q'
            if(sudokuHelper(board,nrow,ncol)){
                return true;
            }
        }else{
            for(int i=1;i<=9;i++){
                if(IsSafeNumberforthisNumber(board,i,row,col)){
                    board[row][col]=(char)(i+'0');
                    if(sudokuHelper(board,nrow,ncol)){
                        return true;
                    }else{
                        board[row][col]='.';
                    }
                }
            }
        }
        return  false;
    }
    //Sudoku Solver
    public static void sudokuSolver(char[][] board){
        sudokuHelper(board,0,0);
    }

    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
//        String s= sc.nextLine();
//        printPermutationes(s,0,"");
//        int n= sc.nextInt();
//        solveNQueens(n);



    }

}
