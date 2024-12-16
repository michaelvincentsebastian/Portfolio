import java.util.Scanner;
public class Tictactoe {
    public static Scanner input = new Scanner(System.in);
    private static char[][] boardGame = new char[3][3];
    private static char CurrentPlayer = 'O';
    private static int ScoreX = 0;
    private static int ScoreO = 0;
    
    private static void initialBoard(){
        for (int b=0; b<3; b++){
            for (int k=0; k<3; k++){
                boardGame[b][k] = ' ';
            }
        }
    }
    
    private static void cetakBoard(){
        for (int b=0; b<3; b++){
            for (int k=0; k<3; k++){
                System.out.print("  " + boardGame[b][k]);
                if (k<2){
                    System.out.print(" |");
                }
            }
            System.out.println();
            if (b<2){
                System.out.println(" ------------ ");
            }
        }
    }
    
    private static void inputPlayer(){
        int baris;
        int kolom;
        while(true){
            System.out.println(" Masukan Baris (0,1,2): ");
            System.out.print(" >>");
            baris = input.nextInt();
            System.out.println(" Masukan Kolom (0,1,2): ");
            System.out.print(" >>");
            kolom = input.nextInt();
            if (baris>=0 && baris<3 && kolom>=0 && kolom<3 && boardGame[baris][kolom]==' '){
                boardGame[baris][kolom]=CurrentPlayer;
                break;
            } else {
                System.out.print(" Baris atau Kolom Tidak Valid, ");
            }
        }
    }
    
    private static boolean checkBoard(){
        for (int i=0; i<3; i++){
            if ((boardGame[i][0]==CurrentPlayer && boardGame[i][1]==CurrentPlayer && boardGame[i][2]==CurrentPlayer && boardGame[0][i]==CurrentPlayer && boardGame[1][i]==CurrentPlayer && boardGame[2][i]==CurrentPlayer)){
                return true;
            }
        }
        return ((boardGame[0][0]==CurrentPlayer && boardGame[1][1]==CurrentPlayer && boardGame[2][2]==CurrentPlayer && boardGame[0][2]==CurrentPlayer && boardGame[1][1]==CurrentPlayer && boardGame[2][0]==CurrentPlayer));
    }
    
    private static boolean boardFull(){
        for (int b=0; b<3; b++){
            for (int k=0; k<3; k++){
                if (boardGame[b][k]==' '){
                    return false;
                }
            }
        }
        return true;
    }
    
    private static void switchPlayer(){
        if (CurrentPlayer=='O'){
            CurrentPlayer='X';
        } else {
            CurrentPlayer='O';
        }
    }
    
    private static void updateScore(){
        if (CurrentPlayer=='O'){
            ScoreO++;
        } else {
            ScoreX++;
        }
    }
    
    private static void cetakScore(){
        System.out.println(" Score Player O: " + ScoreO);
        System.out.println(" Score Player X: " + ScoreX);
    }
    
	public static void main(String[] args) {
		System.out.println(" =================== ");
		System.out.println(" Tictactoe Game Java ");
		System.out.println(" =================== ");
		
		while(true){
		    initialBoard();
		    while(true){
		        cetakBoard();
		        inputPlayer();
		        if (checkBoard()){
		            cetakBoard();
		            System.out.print(" Player " + CurrentPlayer + "Win");
		            updateScore();
		            cetakScore();
		            break;
		        }
		        if (boardFull()){
		            System.out.print(" Papan Penuh Hasil Seri");
		            break;
		        }
		        switchPlayer();
		    }
		    System.out.println(" Ingin mengulang lagi? (yes/no): ");
		    System.out.print(" >> ");
		    String Jawab = input.next();
		    if (Jawab.equalsIgnoreCase("no")){
		        break;
		    }
		}
	}
}
