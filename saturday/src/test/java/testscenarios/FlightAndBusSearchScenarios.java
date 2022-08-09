package testscenarios;

import api.FlightTicketRequest;
import com.mashape.unirest.http.exceptions.UnirestException;
import framework.ConfigReader;
import framework.DriverSetup;
import model.Root;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;

import java.io.IOException;
import java.util.*;

public class FlightAndBusSearchScenarios {

    static WebDriver driver;
    static Properties properties;
    HomePage homePage;
    FlightTicketRequest flightTicketRequest;
    String keyword = "ada";

    @BeforeClass
    public void setup(){
        properties = ConfigReader.initialize_Properties();
        driver = DriverSetup.initialize_Driver("chrome");
        homePage = new HomePage(driver);
        flightTicketRequest = new FlightTicketRequest();

    }

    @Test(priority = 1, enabled = true)
    public void searchForKeyword() throws InterruptedException {

        homePage.searchForFlightTicket(keyword);

    }
    @Test(priority = 2, enabled = true)
    public void checkListForSearch() throws UnirestException, IOException {
        Map<String, Root> flightMap = new HashMap();
        Map<String, Root> flightMapAPi = new HashMap();

        List< String > flightList = homePage.listForFlightTicketSearchByStream();
        for(int i=2;i<flightList.size();i=i+2){
            Root root = new Root();
            root.setAirport(flightList.get(i-1).split("\n")[1]);
            root.setCityName(flightList.get(i-2).split(",")[0]);
            root.setCountryName(flightList.get(i-2).split(",")[1].split("\n")[0]);
            flightMap.put(flightList.get(i).split("\n")[2],
                    root);

        }


        List< String > flightListApi = Collections.singletonList(flightTicketRequest.flightTicketFromListByRest(keyword));


        for(int i=0;i<flightListApi.size();i++){
            Root root = new Root();
            //IZM,Türkiye:Adnan Menderes Havalimanı:İzmir
            root.setAirport(flightListApi.get(i));
            root.setCountryName(flightListApi.get(i).split(":")[0]);
            root.setAirport(flightListApi.get(i).split(":")[1]);
            root.setCityName(flightListApi.get(i).split(":")[2]);
            flightMapAPi.put(flightListApi.get(i).split(",")[0],
                    root);
        }
        Assert.assertEquals(flightMap.get("ADT"),flightMapAPi.get("ADT"));

    }
}


