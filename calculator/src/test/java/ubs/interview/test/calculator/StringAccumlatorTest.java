package ubs.interview.test.calculator;

import junit.framework.TestCase;

public class StringAccumlatorTest extends TestCase
{
		
    public void testCase_1() {
    	//Input: empty string
    	//Expect: 0
    	//Fulfill Question: 1 
    	try {
			assertEquals(0, StringAccumulator.add(""));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    	
    }
    
    public void testCase_2a() {
    	//Input: 1
    	//Expect: 1
    	//Fulfill Question: 1
    	try {
			assertEquals(1, StringAccumulator.add("1"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void testCase_2b() {
    	//Input: 1000
    	//Expect: 1000
    	//Fulfill Question: 1
    	try {
			assertEquals(1000, StringAccumulator.add("1000"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void testCase_2c() {
    	//Input: 6000
    	//Expect: 0
    	//Fulfill Question: 6
    	try {
			assertEquals(0, StringAccumulator.add("6000"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void testCase_3a() {
    	//Input: two numbers (1,2)
    	//Expect: 3
    	//Fulfill Question: 1
    	try {
			assertEquals(3, StringAccumulator.add("1,2"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void testCase_3b() {
    	//Input: two numbers (111,2222)
    	//Expect: 111
    	//Fulfill Question: 1,6
    	try {
			assertEquals(111, StringAccumulator.add("111,2222"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void testCase_4a(){
    	//Input: five numbers (to handle an unknown amount of numbers)
    	//Expect: 15
    	//Fulfill Question: 2
    	try {
			assertEquals(15, StringAccumulator.add("1,2,3,4,5"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    	
    }
    
    public void testCase_4b(){
    	//Input: ten numbers (to handle an unknown amount of numbers)
    	//Expect: 50
    	//Fulfill Question: 2, 6
    	try {
			assertEquals(50, StringAccumulator.add("1,2,3,4,5,9999999,10,20,3,2"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    	
    }
    
    public void testCase_5a() {
    	//Input: 1\n2,3
    	//Expect: 6
    	//Fulfill Question: 3a
    	try {
			assertEquals(6, StringAccumulator.add("1\n2,3"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void testCase_5b() {
    	//Input: 1,\n
    	//Expect: -1
    	//Fulfill Question: 3b
    	try {
			assertEquals(-1, StringAccumulator.add("1,\n"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void testCase_5c() {
    	//Input: 1\n2,3\n4
    	//Expect: 10
    	//Fulfill Question: 3a
    	try {
			assertEquals(10, StringAccumulator.add("1\n2,3\n4"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
        
    public void testCase_5d() {
    	//Input: 1,\n3
    	//Expect: Incorrect syntax of input string.
    	//Fulfill Question: 3b
    	try {
			StringAccumulator.add("1,\n3");
		} catch (Exception e) {
			assertEquals("Incorrect syntax of input string.", e.getMessage());			
		}
    }    
    
    public void testCase_6a() {
    	//Input: //;\n1;2
    	//Expect: 3
    	//Fulfill Question: 4a, b
    	try {
			assertEquals(3, StringAccumulator.add("//;\n1;2"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
      
    public void testCase_6b() {
    	//Input: //aa\n1aa2aa10
    	//Expect: 13
    	//Fulfill Question: 4a, b
    	try {
			assertEquals(13, StringAccumulator.add("//aa\n1aa2aa10"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void testCase_6c() {
    	//Input: //aa\n1aa2aa10aa
    	//Expect: -1 (Reason: extra , at the end)
    	//Fulfill Question: 4a, b
    	try {
			assertEquals(-1, StringAccumulator.add("//aa\n1aa2aa10aa"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void testCase_6d() {
    	//Input: //*\n1*2*10*1*10
    	//Expect: 23
    	//Fulfill Question: 4a, b
    	try {
			assertEquals(24, StringAccumulator.add("//*\n1*2*10*1*10"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    public void testCase_7a() {
    	//Input: 5,6,-1
    	//Expect: throw an exception with the message "negatives not allowed" - and the negative that was passed
    	//Fulfill Question: 5a
    	try {
    		StringAccumulator.add("5,6,-1");    		
    	} catch(Exception e) {
    		assertEquals("negatives not allowed : -1", e.getMessage());	
    	}   	    	
    }
    
    public void testCase_7b() {
    	//Input: 5,6,-1,7,8,-2
    	//Expect: throw an exception with the message "negatives not allowed" - and the negative that was passed
    	//Fulfill Question: 5b
    	try {
    		StringAccumulator.add("5,6,-1,7,8, -2");    		
    	} catch(Exception e) {
    		assertEquals("negatives not allowed : -1, -2", e.getMessage());	
    	}	
    }
    
    public void testCase_7c() {
    	//Input: 5,6,-1,7,8,-2,-3, 22
    	//Expect: throw an exception with the message "negatives not allowed" - and the negative that was passed
    	//Fulfill Question: 5b
    	try {
    		StringAccumulator.add("5,6,-1,7,8, -2,-3, 22");    		
    	} catch(Exception e) {
    		assertEquals("negatives not allowed : -1, -2,-3", e.getMessage());	
    	}	
    }
    
    public void testCase_7d() {
    	//Input: -5,6,-1,7,8,-2,-3, 22
    	//Expect: throw an exception with the message "negatives not allowed" - and the negative that was passed
    	//Fulfill Question: 5b
    	try {
    		StringAccumulator.add("-5,6,-1,7,8, -2,-3, 22");    		
    	} catch(Exception e) {
    		assertEquals("negatives not allowed : -5,-1, -2,-3", e.getMessage());	
    	}	
    }
    
    public void testCase_8a() {
    	//Input: 2,1001
    	//Expect: 2
    	//Fulfill Question: 6
    	try {
    		assertEquals(2,StringAccumulator.add("2,1001"));    		
    	}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void testCase_8b() {
    	//Input: 2,1001,999999,222222222,1
    	//Expect: 3
    	//Fulfill Question: 6
    	try {
    		assertEquals(3,StringAccumulator.add("2,1001,999999,222222222,1"));    		
    	}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void testCase_9a() {
    	//Input: "//***\n1***2***3"
    	//Expect: 6
    	//Fulfill Question: 7
    	try {
    		assertEquals(6,StringAccumulator.add("//***\n1***2***3"));    		
    	}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void testCase_9b() {
    	//Input: "//^^%%\n88^^%%2^^%%10"
    	//Expect: 100
    	//Fulfill Question: 7
    	try {
    		assertEquals(100,StringAccumulator.add("//^^%%\n88^^%%2^^%%10"));    		
    	}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void testCase_10a() {
    	//Input: "//*|%\n1*2%3"
    	//Expect: 6
    	//Fulfill Question: 8
    	try {
    		assertEquals(6,StringAccumulator.add("//*|%\n1*2%3"));    		
    	}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void testCase_10b() {
    	//Input: "//*********|%%\n1*********2%%3"
    	//Expect: 6
    	//Fulfill Question: 9
    	try {
    		assertEquals(6,StringAccumulator.add("//*********|%%\n1*********2%%3"));    		
    	}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void testCase_10c() {
    	//Input: "//*|%\n1*2%3*1111"
    	//Expect: 6
    	//Fulfill Question: 8
    	try {
    		assertEquals(6,StringAccumulator.add("//*|%\n1*2%3*1111"));    		
    	}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void testCase_10d() {
    	//Input: "//*|%\n1*2%3*1111%4"
    	//Expect: 10
    	//Fulfill Question: 8
    	try {
    		assertEquals(10,StringAccumulator.add("//*|%\n1*2%3*1111%4"));    		
    	}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
}
