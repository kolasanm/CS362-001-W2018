package calendar;

import java.util.*;
import java.util.Calendar;
import java.util.Random;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;
    /**
     * Generate Random Tests that tests TimeTable Class.
     */
	  @Test
	  public void randomtest()  throws Throwable  {

		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		 GregorianCalendar cal = new GregorianCalendar();
		 CalDay day = new CalDay(cal);
		 TimeTable time = new TimeTable();

		 LinkedList<Appt> appts = new LinkedList<Appt>();

		 GregorianCalendar firstDay = new GregorianCalendar(2016, 10, 10);
		 GregorianCalendar lastDay = new GregorianCalendar(2017, 10, 10);

		 GregorianCalendar firstAfter = new GregorianCalendar(2017, 11, 11);
		 
		 System.out.println("Start testing...");
		 
		try{ 
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed =System.currentTimeMillis(); //10
	//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);
				
				 int startHour=ValuesGenerator.RandInt(random);
				 int startMinute=ValuesGenerator.RandInt(random);
				 int startDay=ValuesGenerator.RandInt(random);
				 int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int startYear=ValuesGenerator.RandInt(random);
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

				 Appt appt1 = new Appt(10, 34, 12, 10, 2018, "test", "test");

				 appts.add(appt);
				 appts.add(appt1); 

				 time.deleteAppt(appts, appt);

				 time.deleteAppt(null, appt1);
				 time.deleteAppt(appts, null);

				 
				 assertNull(time.deleteAppt(appts, appt1));

				 time.deleteAppt(null, null);

				 assertNotNull(time.getApptRange(appts, firstDay, lastDay));
				 assertNotEquals(5, time.getApptRange(appts, firstDay, lastDay).size());
				 assertNotNull(time.getApptRange(appts, firstAfter, lastDay));

				Appt mutant2 = new Appt(23, 32, 22, 11, 2018, "Party Birthday2", "This is my party birthday2");
				appts.add(mutant2);
				assertNull(time.deleteAppt(appts, mutant2));

			if(!appt.getValid())continue;
			for (int i = 0; i < NUM_TESTS; i++) {
					String methodName = ApptRandomTest.RandomSelectMethod(random);
					   if (methodName.equals("setTitle")){
						   String newTitle=(String) ValuesGenerator.getString(random);
						   appt.setTitle(newTitle);						   
						}
					   else if (methodName.equals("setRecurrence")){
						   int sizeArray=ValuesGenerator.getRandomIntBetween(random, 0, 8);
						   int[] recurDays=ValuesGenerator.generateRandomArray(random, sizeArray);
						   int recur=ApptRandomTest.RandomSelectRecur(random);
						   int recurIncrement = ValuesGenerator.RandInt(random);
						   int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random);
						   appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
						   appt.setRecurrence(null, recur, recurIncrement, recurNumber);
						}				
				}

				
				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			        if((iteration%10000)==0 && iteration!=0 )
			              System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
			 
			}

		}catch(NullPointerException e){
			
		}
	 
		 System.out.println("Done testing...");
	 }	

	  @Test
	  public void randomtest02()  throws Throwable  {

		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		 GregorianCalendar cal = new GregorianCalendar();
		 CalDay day = new CalDay(cal);
		 TimeTable time = new TimeTable();

		 LinkedList<Appt> appts = new LinkedList<Appt>();
		 
		 System.out.println("Start testing...");
		 
		try{ 
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed =System.currentTimeMillis(); //10
	//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);
				
				GregorianCalendar firstDay = new GregorianCalendar(2016, 10, 10);
				GregorianCalendar lastDay = new GregorianCalendar(2017, 10, 10);

				assertNotEquals(367, time.getApptRange(appts, firstDay, lastDay).size());

				GregorianCalendar firstDay1 = new GregorianCalendar(2016, 10, 10);
				GregorianCalendar lastDay1 = new GregorianCalendar(2016, 10, 11);

				assertEquals(1, time.getApptRange(appts, firstDay1, lastDay1).size());
				
				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			       if((iteration%10000)==0 && iteration!=0 )
			             System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
			 
			}

		}catch(NullPointerException e){
			
		}
	 
		 System.out.println("Done testing...");
	 }	
}