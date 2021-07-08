package codes;

import java.util.Scanner;

public class MainDrive {
	
	public static void main(String[] args) {
		
//		숫자 야구 게임 혼자 만들어보기 

		
		int[] randomNumbers = new int[3];
		
		for(int i = 0 ; i < randomNumbers.length; i++) {
			
			while(true) { 
// while문이 여기 들어가는 이유 : 올바른 숫자가 나올 때 까지 해당 자리를 다시 뽑아야함.
// => 반복문 몇번 돌려야하는지 모르니까 while을 이용한 무한반복!!!				           
				int randomNum = (int)(Math.random()*9+1); 
				
				boolean isDupOk = true;  		
				
//				while(true) { #1.잘못
					
					for(int num : randomNumbers) {
						
						if(randomNum == num) {
							isDupOk = false;
						}
					}
					
					if(isDupOk) {
						randomNumbers[i] = randomNum;
						break;
					}							
			}						
		}				

			Scanner myScan = new Scanner(System.in);
			
			int tryCounts = 0;
			
			while(true) {
				
				int strikCounts = 0;
				int ballCounts = 0;
				
				System.out.print("정답을 맞춰보세요 : ");
				int inputNumber = myScan.nextInt();
				
				tryCounts++;
				
				int[] inputNumbers = new int[3];
				
				inputNumbers[0] = inputNumber / 100;
				inputNumbers[1] = inputNumber / 10 % 10;
				inputNumbers[2] = inputNumber % 10;
				
				for(int i = 0 ; i < randomNumbers.length; i++) {
					for(int j = 0; j < inputNumbers.length; j++) {
						
						if(randomNumbers[i] == inputNumbers[j] ) {
//						if(randomNum == inputNumber) { 수식이 잘못 된 이유 : 배열들의 자리에 들어온 숫자!들이 같아야함 
							if(i==j) {
								strikCounts++;
							}
							else {
								ballCounts++;
							}
						
						}
					}
				}
				System.out.println(strikCounts + "S" + ballCounts + "B입니다.");
				
				if(strikCounts ==3) {
					System.out.print("축하합니다 정답입니다.");
					System.out.print(tryCounts + "번 만에 맞췄습니다.");
					break;
				}
				
			
			
			
		}
	}

}
