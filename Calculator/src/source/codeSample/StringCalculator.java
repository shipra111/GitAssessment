package source.codeSample;

public class StringCalculator {
	
	public int Add(String numbers) {
		int sum=0;
		if(numbers != null && !numbers.equals("")) {
			String num[]=numbers.split(",");
			for(int i=0;i<num.length;i++) {
				sum+=Integer.parseInt(num[i]);
			}
		}
		return sum;
	}
}
