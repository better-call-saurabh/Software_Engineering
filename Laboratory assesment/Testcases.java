//To run this code,Download the junit file using this link : https://www.javatpoint.com/src/junit/junit4jars.zip
package project;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import java.util.*;
import org.junit.Test;


public class Test_otp {
	Scanner s = new Scanner(System.in);
	@Test
	// Test case for checking length of OTP
	public void test1() {
		String otp = Mail_OTP.generate_otp();
		int len = otp.length();
		int i = Mail_OTP.num_of_characters+Mail_OTP.num_of_numbers;
		assertTrue(len>=4);
		assertTrue(len<=10);
		}

	// To check if random OTP is generated every time
	@Test
	public void test2() {
		String previous_otp = Mail_OTP.generate_otp();
		String current_otp  = Mail_OTP.generate_otp();
		assertNotEquals(previous_otp, current_otp);
		
	
	}
	// Test case to check if email is valid or not
	@Test
	public void test3() {
		System.out.print("Enter receiver_email : ");
		 String email = s.nextLine();
		assertTrue( email.contains("@gmail.com"));
	}
//	 Test case to check the maximum limit
	@Test
	public void test4() {
		int max_limit = s.nextInt();
		assertTrue(max_limit < 3);
	}
}

