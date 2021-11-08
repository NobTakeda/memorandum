import java.util.*;
public class StrangeAddition{
	public static void main(String[] args){

		Scanner sc=new Scanner(System.in);
		System.out.print("最初の整数を入力してください>");
		String strDataA=sc.nextLine();
		System.out.print("次の整数を入力してください>");
		String strDataB=sc.nextLine();

		char[] charDataA=strDataA.toCharArray();
		char[] charDataB=strDataB.toCharArray();
		int[] numsA=new int[charDataA.length];
		for(int i = 0; i < numsA.length; i++){
			numsA[i] = Character.getNumericValue(charDataA[i]);
		}
		int[] numsB=new int[charDataB.length];
		for(int i = 0; i < numsB.length; i++){
			numsB[i] = Character.getNumericValue(charDataB[i]);
		}

		System.out.print("A+B=");
		int ans=0;
		if(numsA.length == numsB.length){
			for(int i = 0; i < numsA.length; i++){
				ans = numsA[i] + numsB[i];
				if(ans >= 10){
					ans -= 10;
				}
				System.out.print(ans);
			}
		}else if(numsA.length < numsB.length){
			if(numsB.length == 3 && numsA.length == 2){
				System.out.print(numsB[0]);
				for(int i = 0; i< 2; i++){
					ans=numsA[i] + numsB[i+1];
					if(ans >= 10){
						ans -= 10;
					}
					System.out.print(ans);
				}
			}else if(numsB.length == 3 && numsA.length == 1){
				System.out.print(numsB[0]);
				System.out.print(numsB[1]);
				ans = numsA[0] + numsB[2];
				if(ans >= 10){
					ans -= 10;
				}
				System.out.print(ans);
			}else if(numsB.length == 2 && numsA.length == 1){
				System.out.print(numsB[0]);
				ans=numsA[0] + numsB[1];
				if(ans >= 10){
					ans -= 10;
				}
				System.out.print(ans);
			}
		}else{
			if(numsA.length == 3 && numsB.length == 2){
				System.out.print(numsA[0]);
				for(int i = 0; i< 2; i++){
					ans=numsA[i+1] + numsB[i];
					if(ans >= 10){
						ans -= 10;
					}
					System.out.print(ans);
				}
			}else if(numsB.length == 3 && numsA.length == 1){
				System.out.print(numsA[0]);
				System.out.print(numsA[1]);
				ans = numsA[0] + numsB[2];
				if(ans >= 10){
					ans -= 10;
				}
				System.out.print(ans);
			}else if(numsA.length ==2 && numsB.length ==1){
				System.out.print(numsA[0]);
				ans=numsA[1] + numsB[0];
				if(ans >= 10){
					ans -= 10;
				}
				System.out.print(ans);
			}
		}
		System.out.println();
	}
}
