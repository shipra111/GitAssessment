package source.codeSample;

public class StringCalculator {
	
	public int Add(String numbers) throws Exception {
		int sum=0;
		if(numbers != null && !numbers.equals("")) {
			
			String delimiter = ",", neg="";
			if(numbers.startsWith("//")) { //  //[delimiter]\n[numbers]
				int index = numbers.indexOf("\n");
				delimiter = "\\"+numbers.substring(index-1,index);
				numbers = numbers.substring(index+1);
			}else if(numbers.contains("\n")) { //  , and \n
				delimiter += "|\n";
			}
			
			String num[]=numbers.split(delimiter);
			for(int i=0;i<num.length;i++) {
				int n = Integer.parseInt(num[i]);
				if(n<0)
					neg +=num[i]+",";
				else if(n<=1000)
					sum+=n;
			}
			
			if(neg.length()>0) {
				throw new Exception("negatives not allowed: "+neg.substring(0,neg.length()-1));
			}
		}
		return sum;
	}
	

}
