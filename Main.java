import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {
	private static void hangmanImage(int live){
		JFrame frame = new JFrame(" Hangman Game ");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);

		if (live == 5){
			ImageIcon imageIcon = new ImageIcon("1.jpg");
			Image originalImage = imageIcon.getImage();
			Image scaledImage = originalImage.getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
			ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
			JLabel label = new JLabel(scaledImageIcon);
			frame.add(label);
			frame.setVisible(true);
		} else if (live == 4){
			ImageIcon imageIcon = new ImageIcon("2.jpg");
			Image originalImage = imageIcon.getImage();
			Image scaledImage = originalImage.getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
			ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
			JLabel label = new JLabel(scaledImageIcon);
			frame.add(label);
			frame.setVisible(true);
		} else if (live == 3){
			ImageIcon imageIcon = new ImageIcon("3.jpg");
			Image originalImage = imageIcon.getImage();
			Image scaledImage = originalImage.getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
			ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
			JLabel label = new JLabel(scaledImageIcon);
			frame.add(label);
			frame.setVisible(true);
		} else if (live == 2){
			ImageIcon imageIcon = new ImageIcon("4.jpg");
			Image originalImage = imageIcon.getImage();
			Image scaledImage = originalImage.getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
			ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
			JLabel label = new JLabel(scaledImageIcon);
			frame.add(label);
			frame.setVisible(true);
		} else if (live == 1){
			ImageIcon imageIcon = new ImageIcon("5.jpg");
			Image originalImage = imageIcon.getImage();
			Image scaledImage = originalImage.getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
			ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
			JLabel label = new JLabel(scaledImageIcon);
			frame.add(label);
			frame.setVisible(true);
		} else {
			ImageIcon imageIcon = new ImageIcon("6.jpg");
			Image originalImage = imageIcon.getImage();
			Image scaledImage = originalImage.getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
			ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
			JLabel label = new JLabel(scaledImageIcon);
			frame.add(label);
			frame.setVisible(true);
		}
	}
    private static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
	    Random random = new Random();
		
	    //String[] word = {"Hardware", "Software", "Antivirus", "Python", "Java", "Windows"};
	    ArrayList<String> wordList = new ArrayList<>();
	    BufferedReader br = null;
	    try {
	        br = new BufferedReader(new FileReader("Kamus.txt"));
	        String row;
	        while ((row = br.readLine()) != null){
	            wordList.add(row.trim());
	        }
	    } catch (FileNotFoundException e){
	        System.out.println(" File doesn't found: "+ e.getMessage());
	        return;
	    } catch (IOException e){
	        System.out.println(" An Error Occured while reading File: "+ e.getMessage());
	        return;
	    } finally {
	        try {
	            if (br != null){
	                br.close();
	            } 
	        } catch (IOException e) {
	            System.out.println(" An Error Occured While Closing File: "+ e.getMessage());
	        }
	    }
	    if (wordList.isEmpty()) {
	        System.out.println(" Word List was Empty, Can't Play the Game! ");
	        return;
	    }
	    
		while (true){
		    String wordGuess = wordList.get(random.nextInt(wordList.size()));
		    
		    String tampungWordGuess = "";
		    for (int i=0; i<wordGuess.length(); i++){
		        tampungWordGuess+='_';
		    }
		    System.out.println(" Hangman Word Guess: ");
		    
		    for (int i=0; i<tampungWordGuess.length(); i++){
		        System.out.print(tampungWordGuess.charAt(i)+" ");
		    }
		    System.out.println(" ");
	    
	        int live = 5;
		    boolean find;
			hangmanImage(live);
		    while (live >= 1 && tampungWordGuess.contains("_")){
		        System.out.println("\nGuess The Word: ");
		        System.out.print(" >> ");
	    	    char guess = Character.toLowerCase(input.next().charAt(0));
	    	    find = false;
		        for (int i=0; i<wordGuess.length(); i++){
		            if (guess == Character.toLowerCase(wordGuess.charAt(i))){
		                StringBuilder tampung = new StringBuilder(tampungWordGuess);
		                tampung.setCharAt(i, guess);
		                tampungWordGuess = tampung.toString();
		                find = true;
		            }
		        }
		        for (int i=0; i<tampungWordGuess.length(); i++){
		            System.out.print(tampungWordGuess.charAt(i)+" ");
		        }
		        if (!find){
		            live = live - 1;
		        }
		        System.out.println(" Nyawa Anda: "+live);
				hangmanImage(live);
			}
		    if (live == 0){
		        System.out.println(" You Lose ");
		    } else {
		        System.out.println(" You Win ");
		    }
		    System.out.print(" Want to Play Again ");
		    System.out.println(" Yes/No ");
		    String play = input.next();
		    if (play.equalsIgnoreCase("No")){
		        break;
		    }
		}
	}
}
