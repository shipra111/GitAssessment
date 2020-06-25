package source.codeSample;

public class StringCalculator {
	
	public int Add(String numbers) {
		int sum=0;
		if(numbers != null && !numbers.equals("")) {
			String delimiter = ",";
			if(numbers.contains("//")) { //  //[delimiter]\n[numbers]
				int index = numbers.indexOf("\n");
				delimiter = "\\"+numbers.substring(index-1,index);
				numbers = numbers.substring(index+1);
			}else if(numbers.contains("\n")) { //  , and \n
				delimiter += "|\n";
			}
			String num[]=numbers.split(delimiter);
			for(int i=0;i<num.length;i++) {
				sum+=Integer.parseInt(num[i]);
			}
		}
		return sum;
	}

}
