import java.util.*;
public class ImprovedStrangeAddition{
	static int isTwoDigit(int num){
		int ans=num;
		if(ans >= 10){
			ans -= 10;	
		}
		return ans;
	}
	static void calcResult(int[] largeArray,int[] smallArray){
		int ans = 0;
		int digitDiff = largeArray.length - smallArray.length;
		for(int i = 0; i < digitDiff; i++){
			System.out.print(largeArray[i]);
		}
		for(int i = 0; i < smallArray.length; i++){
			ans = isTwoDigit(largeArray[i+digitDiff] + smallArray[i]);
			System.out.print(ans);
		}
	}

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

		System.out.print(strDataA+"+"+strDataB+"=");
		if(numsA.length == numsB.length){
			int ans=0;
			for(int i = 0; i < numsA.length; i++){
				ans = isTwoDigit(numsA[i] + numsB[i]);
				System.out.print(ans);
			}
		}else if(numsA.length < numsB.length){
			calcResult(numsB,numsA);
		}else{
			calcResult(numsA,numsB);
		}
		System.out.println();
	}
}
