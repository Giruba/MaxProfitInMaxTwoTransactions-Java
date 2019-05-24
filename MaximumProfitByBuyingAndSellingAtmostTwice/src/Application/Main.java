package Application;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("Maximum profit by buying and selling shares at most twice");
		System.out.println("----------------------------------------------------------");
		
		try {
			System.out.println("Enter the number of stock prices that would be entered");
			Scanner scanner = new Scanner(System.in); 
			int numberOfElements = scanner.nextInt();
			int[] stockArray = new int[numberOfElements];
			for(int index = 0; index < numberOfElements; index++) {
				System.out.println("Enter the element "+(index+1));
				stockArray[index] = scanner.nextInt();
			}
			PrintMaximumProfitInTwoTransactions(stockArray);
		}catch(Exception exception) {
			System.out.println("Thrown exception is "+exception.getMessage());
		}		
	}
	
	public static void PrintMaximumProfitInTwoTransactions(int[] stockArray) {
		int stockArrayLength = stockArray.length;
		int[] profitArray = new int[stockArrayLength];
				
		int maxStockPrice = stockArray[stockArrayLength -1]; 
		for(int index = stockArrayLength - 2; index >=0 ; index--) {
			
			if(stockArray[index] > maxStockPrice) {
				maxStockPrice = stockArray[index];
			}
			profitArray[index] = Math.max(profitArray[index+1], 
					maxStockPrice - stockArray[index]);
		}
		
		int minStockPrice = stockArray[0];
		for(int startIndex = 1; startIndex < stockArrayLength; startIndex++) {
			if(stockArray[startIndex] < minStockPrice) {
				minStockPrice = stockArray[startIndex];
			}
			
			profitArray[startIndex] = Math.max(profitArray[startIndex-1], profitArray[startIndex]+
					(stockArray[startIndex] - minStockPrice));
		}
		
		System.out.println("The maximum profit got is "+profitArray[profitArray.length-1]);
	}
}
