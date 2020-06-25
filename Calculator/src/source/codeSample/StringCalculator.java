package source.codeSample;

public class StringCalculator {
	
	public int Add(String numbers) {
		int sum=0;
		if(numbers != null && !numbers.equals("")) {
			if(numbers.contains(",")) {
				int index = numbers.indexOf(",");				
				sum=Integer.parseInt(numbers.substring(0,index))
						+Integer.parseInt(numbers.substring(index+1));
			}else {
				sum=Integer.parseInt(numbers);
			}
		}
		return sum;
	}
}
