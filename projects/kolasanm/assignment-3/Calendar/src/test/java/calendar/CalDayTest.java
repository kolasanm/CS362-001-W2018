package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import org.junit.Test;

import static org.junit.Assert.*;


/*
add appt
iterator
*/

public class CalDayTest {

	 @Test
	  public void test01()  throws Throwable  {
	  /*Tests the set and get methods*/

	  //Construct a new CalDay object with the default constructor 
	  CalDay calendar0 = new CalDay();
	  assertFalse(calendar0.isValid());
	  assertNull(calendar0.getAppts());

	  int day = 14;
	  int month = 11;
	  int year = 2018;
	 
	  GregorianCalendar cal = new GregorianCalendar(year, month, day);
	  CalDay calendar = new CalDay(cal);

	  assertEquals(14, calendar.getDay());
	  assertEquals(11, calendar.getMonth());
	  assertEquals(2018, calendar.getYear());
	  assertNotNull(calendar.getAppts());

	  assertNotNull(calendar.toString());

	 }

	 @Test
	  public void test02()  throws Throwable  {
	  /*Tests addAppt(), toString(), and Iterator()*/

	  int day = 14;
	  int month = 11;
	  int year = 2018;
	 
	  GregorianCalendar cal = new GregorianCalendar(year, month, day);
	  CalDay calendar = new CalDay(cal);

	  Appt first = new Appt(21, 30, 15, 01, 2018, "Birthday Party", "This is my birthday party");
	  Appt second = new Appt(22, 31, 16, 02, 2019, "Party Birthday", "This is my party birthday");

	  calendar.addAppt(first);
	  calendar.addAppt(second);

	  assertEquals(2, calendar.getSizeAppts());

	  Appt f1 = new Appt(21, 30, 15, 01, 2018, "Birthday Party", "This is my birthday party");
	  Appt f2 = new Appt(19, 31, 16, 02, 2019, "Party Birthday", "This is my party birthday");	  

	  calendar.addAppt(f1);
	  calendar.addAppt(f2);

	  //Killing a mutant that negated a boundary
	  int check = 0;
	  LinkedList<Appt> apt = calendar.getAppts();
	  if (apt.get(0).getStartHour() > apt.get(1).getStartHour())
			check = 1;
	  assertEquals(check, 0);

	  //Kill mutant that removed the addAppt call
	  assertEquals(4, calendar.getSizeAppts());  

	  calendar.toString();

	  CalDay invalidCal = new CalDay();
	  invalidCal.toString();

	  assertNotNull(calendar.iterator());

	  CalDay calendar2 = new CalDay();

	  assertNull(calendar2.iterator());
		 
	 }
//add more unit tests as you needed	
}
