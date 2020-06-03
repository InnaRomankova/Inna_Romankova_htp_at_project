package runners;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.booking.moscow.BookingMoskowHouseTest;
import tests.booking.oslo.BookingOsloHouseTest;
import tests.booking.paris.BookingParisHouseTest;


@RunWith(Suite.class)
@Suite.SuiteClasses({BookingParisHouseTest.class, BookingMoskowHouseTest.class, BookingOsloHouseTest.class})

public class BookingRunner {
}
