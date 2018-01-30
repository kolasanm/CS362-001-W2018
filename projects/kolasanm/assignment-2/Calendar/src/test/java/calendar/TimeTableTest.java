package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

//permute


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

	 @Test
	  public void test01()  throws Throwable  {
	  /*Tests the getApptRange() function and deleteAppt() function*/

	  TimeTable t = new TimeTable();

	  LinkedList<Appt> appts = new LinkedList<Appt>();
	  Appt first = new Appt(21, 30, 14, 11, 2018, "Birthday Party", "This is my birthday party");
	  Appt second = new Appt(22, 31, 21, 11, 2018, "Party Birthday", "This is my party birthday");

	  //add invalid appt to delete
	  Appt third = new Appt(23, 32, 22, 11, 2018, "Party Birthday2", "This is my party birthday2");
	  third.setStartHour(24);
	  assertFalse(third.getValid());
	  assertNull(t.deleteAppt(appts, third));

	  appts.add(first);
	  appts.add(second);
	  appts.add(third);

	  //add null app to delete
	  assertNull(t.deleteAppt(appts, null));

	  //add valid appt to delete
	  Appt fourth = new Appt(23, 32, 22, 11, 2018, "Party Birthday2", "This is my party birthday2");
	  assertNull(t.deleteAppt(appts, fourth));

	  GregorianCalendar firstday = new GregorianCalendar(2018, 11, 14);
	  GregorianCalendar lastday = new GregorianCalendar(2018, 11, 21);

	  assertNotNull(t.getApptRange(appts, firstday, lastday));

	  //add last day before first day appt to check getApptRange()
	  GregorianCalendar badfirst = new GregorianCalendar(2018, 11, 24);
	  GregorianCalendar badlast = new GregorianCalendar(2018, 11, 21);

	  assertNotNull(t.getApptRange(appts,badfirst, badlast));

	 }
	 @Test
	  public void test02()  throws Throwable  {
	  /*Tests the permute() function */
		 
	  TimeTable t = new TimeTable();

	  LinkedList<Appt> appts = new LinkedList<Appt>();
	  Appt first = new Appt(21, 30, 14, 11, 2018, "Birthday Party", "This is my birthday party");
	  Appt second = new Appt(22, 31, 21, 11, 2018, "Party Birthday", "This is my party birthday");

	  appts.add(first);
	  appts.add(second);


	  int [] pv= {1, 0};
	  assertNotNull(t.permute(appts, pv));

	  int [] pv2= {0, 1, 2};
	  assertNotNull(t.permute(appts, pv2));
	 }

	 @Test
	  public void test03()  throws Throwable  {
	  /*Tests the getApptOccurences() function */
		 
	  TimeTable t = new TimeTable();

	  LinkedList<Appt> appts = new LinkedList<Appt>();
	  Appt first = new Appt(21, 30, 14, 11, 2018, "Birthday Party", "This is my birthday party");

	  GregorianCalendar initial = new GregorianCalendar(2018, 11, 14);
	  GregorianCalendar last = new GregorianCalendar(2018, 11, 21);

	  int[]recurDays = {2, 4, 6};
	  //set recurrence to call private method
	  first.setRecurrence(recurDays, 1, 2, 3);

	  appts.add(first);

	  assertNotNull(t.getApptRange(appts,initial, last));

	  
	 }
	}