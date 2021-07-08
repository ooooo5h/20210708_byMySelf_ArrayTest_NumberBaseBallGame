package codes;

import java.util.Scanner;

public class MainDrive {

	public static void main(String[] args) {
		
//		숫자야구게임
		int[] randomNumbers = new int[3];
		
		for(int i = 0 ; i < randomNumbers.length; i++) {
			
			while(true) {
				
				int randomNum = (int)(Math.random()*9+1);
				
				boolean isDupOk = true;
				
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
			
			System.out.print("3자리 숫자를 입력하세요 : ");
			int inputNum = myScan.nextInt();
			
			tryCounts++;
			
			int[] inputNumbers = new int[3];
			
			inputNumbers[0] = inputNum / 100;
			inputNumbers[1] = inputNum / 10 % 10;
			inputNumbers[2] = inputNum % 10;
			
			int strikeCounts = 0;
			int ballCounts = 0;
			
			for(int i = 0 ; i < inputNumbers.length; i++) {
				for(int j = 0 ; j < randomNumbers.length; j++) {
					
					if(randomNumbers[i] == inputNumbers[j]) {
						if(i==j) {
							strikeCounts++;
						}
						else {
							ballCounts++;   // 2번째 시도. 빼먹음.. 나는 암기해서 코드를 썻나보다 이걸 빼먹다니
						}
						
					}
				}
			}
			System.out.println(strikeCounts + "S" + ballCounts + "B");
			
			if(strikeCounts==3) {
				System.out.print("정답입니다.");
				System.out.print(tryCounts + "회만에 맞추셨습니다.");
				break;
			}
			
		}
		
		

	}
}
