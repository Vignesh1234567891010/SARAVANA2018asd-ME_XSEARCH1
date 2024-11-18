package _XSEARCH_Implementataion;

import java.net.MalformedURLException;

public class App {
	
	public void getGreeting() throws MalformedURLException,InterruptedException{
		
		TestCases tests=new TestCases();
		
		tests.testCase01();
		
		tests.testCase02();
		
		tests.testCase03();
		
		tests.endTest();
	}

	public static void main(String[] args) throws MalformedURLException,InterruptedException {
		// TODO Auto-generated method stub
		new App().getGreeting();
	}

}
