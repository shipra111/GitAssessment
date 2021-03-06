package source.codeSample;

public class StringCalculator {
	
	private static int count = 0;
	
	public int Add(String numbers) throws Exception {
		count++;
		int sum=0;
		if(numbers != null && !numbers.equals("")) {
			
			String delimiter = "[^0-9\\-]", neg="";
			if(numbers.startsWith("//")) { //  //[delimiter]\n[numbers]
				int index = numbers.indexOf("\n");
				numbers = numbers.substring(index+1);
			}
			
			String num[]=numbers.split(delimiter);
			for(int i=0;i<num.length;i++) {
				if(!num[i].equals("")) {
					int n = Integer.parseInt(num[i]);
					if(n<0)
						neg +=num[i]+",";
					else if(n<=1000)
						sum+=n;
				}
			}
			
			if(neg.length()>0) {
				throw new Exception("negatives not allowed: "+neg.substring(0,neg.length()-1));
			}
		}
		return sum;
	}
	
	public int GetCalledCount() {
		return count;
	}
	

}
