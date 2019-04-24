import java.util.ArrayList;
import java.util.Arrays;

class LeftRecursionMine{
	final static String production = "A=Ab|c|d|Ad";
	final static String eps = "eps";
	final static String A = "A'";
	static ArrayList<String> alpha = new ArrayList<>();
	static ArrayList<String> beta = new ArrayList<>();
	
	static String[] getProduction(String production){
		String arr[] = production.split("\\||=");
		return arr;
	}
	
	static boolean checkLR(String arr[]){
		String lhs = arr[0];
		boolean bool = false;
		for(int j=1;j<arr.length;j++){
			if(lhs.charAt(0)==arr[j].charAt(0)){
				alpha.add(arr[j].substring(1));
				bool = true;
			}
			else{
				beta.add(arr[j]);
			}
		}
		return bool;
	}
	
	static void print(String s){
		System.out.printf(s);
	}
	
	public static void main(String [] args){
		String arr[] = getProduction(production);
		print(production);
		print(Arrays.toString(arr));
		if(checkLR(arr)){
			for(int i=0;i<beta.size();i++){
				print("\nA="+beta.get(i)+A);
			}
			String s = A+"=";
			for(int i=0;i<alpha.size();i++){
				s = s + alpha.get(i) + A + " | ";
			}
			print("\n"+s+eps);
		}
		else{
			print("No left recursion found");
		}
	}	
}
	