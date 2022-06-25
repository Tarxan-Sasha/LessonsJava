import java.util.Scanner;
public class ProgramTask {
    public static void main (String[]args) {
    	char array[][]= {{'Q','W','Q','E','T','Y','X'},{'Q','W','Q','E','T','X','X'}};
    	char symbol ='X';
    	int x=0;
    	for(int i=0; i<=array.length-1; i++) {
    		for(int j=0; j<=array[i].length-1; j++) {
        		if(array[i][j]==symbol) {
        			x++;
        			System.out.println(array[i][j]+" + 1");
        		}
        	}
    	}
    	System.out.println(x);   	
    }
}
/*
 * Программа ищет по всему двухмерному массиву указанный символ:
 *  char symbol ='X';
 * и считает сколько раз он повторяеться 
 * 
 */
