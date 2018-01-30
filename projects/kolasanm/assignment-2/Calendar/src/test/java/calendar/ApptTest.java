package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
    /*
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {
		 
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";

		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);

		 //set remaining appointment variables with initial data
		 int[] recurDays = {1, 3, 7};
		 int recurBy = 4;
		 int recurIncrement = 2; 
		 int recurNumber = 6;
		 appt.setRecurrence(recurDays, recurBy, recurIncrement, recurNumber);


		//assertions
		 assertTrue(appt.getValid());
		 assertEquals(21, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(15, appt.getStartDay());
		 assertEquals(01, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());
		 assertNotNull(appt.getRecurDays()); 
		 assertEquals(4, appt.getRecurBy());
		 assertEquals(2, appt.getRecurIncrement());
		 assertEquals(6, appt.getRecurNumber());
		 assertTrue(appt.isRecurring());
	 }

	 @Test
	  public void test02()  throws Throwable  {
    /*
     * Test that the sets methods work as expected.
     */
	  	 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";

		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);

		 //set object variables with new data
		 appt.setStartHour(22);
		 appt.setStartMinute(31);
		 appt.setStartDay(16);
		 appt.setStartMonth(02);
		 appt.setStartYear(2019);
		 appt.setTitle("Party Birthday");
		 appt.setDescription("This is my party birthday");

		//assertions
		 assertTrue(appt.getValid());
		 assertEquals(22, appt.getStartHour());
		 assertEquals(31, appt.getStartMinute());
		 assertEquals(16, appt.getStartDay());
		 assertEquals(02, appt.getStartMonth());
		 assertEquals(2019, appt.getStartYear());
		 assertEquals("Party Birthday", appt.getTitle());
		 assertEquals("This is my party birthday", appt.getDescription());

		 appt.setTitle(null);
		 assertEquals("", appt.getTitle());

		 appt.setDescription(null);
		 assertEquals("", appt.getDescription());

		 int[] recurDays = {};
		 int recurBy = 4;
		 int recurIncrement = 2; 
		 int recurNumber = 6;
		 appt.setRecurrence(null, recurBy, recurIncrement, recurNumber);

		 
	 }

	/*
     * Test that the isValid() function is working as expected
     */
	 @Test
	  public void test03()  throws Throwable  {
		 
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		

		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);

		 //set remaining appointment variables with initial data
		 int[] recurDays = {1, 3, 7};
		 int recurBy = 4;
		 int recurIncrement = 2; 
		 int recurNumber = 6;
		 appt.setRecurrence(recurDays, recurBy, recurIncrement, recurNumber);


		 //set variables with incorrect data and assert that isValid returns false
		 appt.setStartHour(24);
		 assertFalse(appt.getValid());
		 appt.setStartHour(21);

		 appt.setStartMinute(60);
		 assertFalse(appt.getValid());
		 appt.setStartMinute(30);

		 appt.setStartMonth(20);
		 assertFalse(appt.getValid());
		 appt.setStartMonth(01);

		 appt.setStartDay(0);
		 assertFalse(appt.getValid());
		 appt.setStartDay(15);


	 }


	
}