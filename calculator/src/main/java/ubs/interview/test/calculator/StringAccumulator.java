package ubs.interview.test.calculator;

import java.util.Arrays;

public class StringAccumulator {
	private static final String DEF_DEL = ",";
	private static final String NEW_LINE = "\n";
	private static final String CHANGE_DEL ="//";
	private static String cusDelimiter = "";
	private static String cusDelimiter2 = "";
	private static final String MUL_DEL = "|";
	
	public static int add(String numbers) throws Exception {
		int total = 0;
		
		switch (numbers.trim()) {
			case "" :
				return 0 ;
				
			default:
				String filteredString = stringFilter(numbers);
				String[] num= filteredString.split(DEF_DEL);
				
				try {
					if(stringChecker(filteredString, num)) {				
						for(String n: num) {
							if(Integer.parseInt(n) <= 1000)
								total += Integer.parseInt(n);			
						}						
						return total;
					} else {
						return -1;
					}			
				}catch(NumberFormatException nfe) {
					throw new Exception("Incorrect syntax of input string.");
				} 				
				catch (Exception e) {
					throw e;					
				}
				
		} //end switch
		
	} //end add

	
	private static String stringFilter(String s) {
		//the minimum length of custom delimiter number : //;n1 (5)
		//the minimum length of multiple delimiter numbeR: //$|%\n1 (8)
		if(s.length() > 5) {
			//check if the string is start with //
			if (s.substring(0, 2).equals(CHANGE_DEL)) {
				//in case there is multiple delimiter
				if(s.indexOf(MUL_DEL) > 0) {
					cusDelimiter = s.substring(2, s.indexOf(MUL_DEL));
					cusDelimiter2 = s.substring(s.indexOf(MUL_DEL)+1, s.indexOf(NEW_LINE));
					return 		s.replace(CHANGE_DEL,"")										//remove the //
								.replace(cusDelimiter+MUL_DEL+cusDelimiter2+NEW_LINE,"")		//remove delimiter1 | delimiter2 + \n
								.replace(cusDelimiter, DEF_DEL)									//replace delimiter 1 with ,
								.replace(cusDelimiter2, DEF_DEL)								//replace delimiter 2 with ,
								.replace(" ","");												//remove empty space in the string
				} else {	
					//single delimiter
					cusDelimiter = s.substring(2, s.indexOf(NEW_LINE));
					return 		s.replace(CHANGE_DEL, "")							//remove the //
								.replace(cusDelimiter+NEW_LINE, "")					//remove delimiter + \n
								.replace(cusDelimiter, DEF_DEL)						//replace delimiter with ,
								.replaceAll(" ", "");								//remove empty space in the string
				}
				
			}else {
				//default delimiter
				return s.replace(NEW_LINE, DEF_DEL);
			}
		} else {
			//default delimiter
			return s.replace(NEW_LINE, DEF_DEL);			
		}		
	}
	
	private static Boolean stringChecker(String s, String[] num) throws Exception {
		//check any negative numbers in array
		try {
			if(Arrays.stream(num).filter(i -> Integer.valueOf(i.trim()) < 0).count() > 0) {
				try {
					String negNum = "";
					for(String n : num) {
						if (Integer.valueOf(n.trim()) < 0)
							negNum += n+",";
					}
					throw new Exception("negatives not allowed : " + negNum.substring(0, negNum.length()-1));				
				}catch(Exception e) {
					throw e;			
				}			
			}else{				
				//count number of delimiter appears
				String filteredString = stringFilter(s);
				long countDeli = filteredString.chars().filter(ch -> ch == DEF_DEL.charAt(0)).count() + 1;		
				return ((num.length) == (int)countDeli)? true : false;
			}
		}catch(Exception e) {
			throw e;
		}		
	}	
	
}
