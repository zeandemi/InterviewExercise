import models.Contact;
import models.Hotel;
import org.junit.Assert;
import org.junit.Test;
import pageobjects.HotelListingPage;
import pageobjects.NavigationPage;
import java.util.ArrayList;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class PreInterviewTest extends TestSetup{

    @Test
    public void CreateNewHotel() throws InterruptedException
    {
        Hotel hotel = new Hotel("Richards Beach", "1 Richard Street", new Contact("Richard B", "07845745745", "rb456@rb.com"));


        driver.navigate().to(baseUrl);
        HotelListingPage hotelListingPage = new NavigationPage(driver)
                .ClickLogin()
                .PopulateUsername("admin")
                .PopulatePassword("password")
                .ClickLogin()
                .PopulateHoteName(hotel.getName())
                .PopulateAddress(hotel.getAddress())
                .PopulateOwner(hotel.getContact().getName())
                .PopulatePhone(hotel.getContact().getPhone())
                .PopulateEmail(hotel.getContact().getEmail())
                .ClickCreateHotel();

        Assert.assertThat(hotelListingPage.ReadHotelName(hotelListingPage.HotelCount()), is(equalTo(hotel.getName())));
    }

    @Test
    public void CreateAndDeleteNewHotelEntry() throws InterruptedException
    {
        Hotel hotel = new Hotel("Richards Ball", "111 Richard Street", new Contact("Richard Ball", "02045745745", "rb123@rb.com"));


        driver.navigate().to(baseUrl);
        HotelListingPage hotelListingPage = new NavigationPage(driver)
                .ClickLogin()
                .PopulateUsername("admin")
                .PopulatePassword("password")
                .ClickLogin()
                .PopulateHoteName(hotel.getName())
                .PopulateAddress(hotel.getAddress())
                .PopulateOwner(hotel.getContact().getName())
                .PopulatePhone(hotel.getContact().getPhone())
                .PopulateEmail(hotel.getContact().getEmail())
                .ClickCreateHotel().DeleteHotelEntry();

        Assert.assertThat(hotelListingPage.ReadHotelName(hotelListingPage.HotelCount()), is(equalTo(hotel.getName())));
    }


    @Test
    public void CreateHotels() throws InterruptedException
    {
        Hotel hotel1 = new Hotel("Richards A Beach", "10 Richard Street", new Contact("Richard A B", "07845745740", "rb456@rab.com"));
        Hotel hotel2 = new Hotel("Richards B Beach", "100 Richard Street", new Contact("Richard B B", "07845745745", "rb456@rbb.com"));

        ArrayList<Hotel> hotels = new ArrayList<Hotel>();
        hotels.add(hotel1);
        hotels.add(hotel2);

        for(Hotel hotel: hotels){

            driver.navigate().to(baseUrl);
            HotelListingPage hotelListingPage = new NavigationPage(driver)
                    .ClickLogin()
                    .PopulateUsername("admin")
                    .PopulatePassword("password")
                    .ClickLogin()
                    .PopulateHoteName(hotel.getName())
                    .PopulateAddress(hotel.getAddress())
                    .PopulateOwner(hotel.getContact().getName())
                    .PopulatePhone(hotel.getContact().getPhone())
                    .PopulateEmail(hotel.getContact().getEmail())
                    .ClickCreateHotel();

            Assert.assertThat(hotelListingPage.ReadHotelName(hotelListingPage.HotelCount()), is(equalTo(hotel.getName())));

        }

    }
}
