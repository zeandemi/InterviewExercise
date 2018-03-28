import model.BookingDates;
import org.junit.Test;

import java.util.Date;
import java.util.GregorianCalendar;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BookingDatesTest {

    // We add the @Test annotation so that when JUnit runs it knows which
    // methods to run as tests
    @Test
    // We give the check a clear name to ensure that it is descriptive in
    // what it is checking
    public void testCreatingBookingDates(){
        // First we want to create two dates to add to our BookingDates object
        Date checkin = new GregorianCalendar(2018, 1, 1).getTime();
        Date checkout = new GregorianCalendar(2018, 1, 2).getTime();

        // Next we create our BookingDates object with the dates we've created
        BookingDates bookingDates = new BookingDates(checkin, checkout);

        // Finally we assertThat the correct date and dateformat can be retrieved by
        // using hamcrest. We assertThat the checkin/out dates match expected strings
        // in the second parameter
        assertThat(bookingDates.getCheckin().toString(), is("Thu Feb 01 00:00:00 GMT 2018"));
        assertThat(bookingDates.getCheckout().toString(), is("Fri Feb 02 00:00:00 GMT 2018"));
    }

}
