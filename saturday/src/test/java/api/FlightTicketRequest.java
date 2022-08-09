package api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;

import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.Root;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;


import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;


public class FlightTicketRequest {

    Response response;
    public FlightTicketRequest(){
        baseURI = "https://www.enuygun.com";
    }
    public static String flightTicketFromList(String kw) throws UnirestException, IOException {
        HttpResponse<JsonNode> response = Unirest.get("https://www.enuygun.com/ucak-bileti/trip-autocomplete/?term=" + kw)
                .header("cookie", "SERVERID-SH=shwww7; SERVERID-SAG=rdwww10")
                .asJson();
        ObjectMapper mapper = new ObjectMapper();
        Root[] flightList = mapper.readValue(response.getBody().toString(), Root[].class);
        return Arrays.stream(flightList).sorted().collect(Collectors.toList()).toString();
    }



    public static String flightTicketFromListByRest(String keyword) {

        return
                given()
                        .log().all()
                        .accept(ContentType.JSON)
                        .header("Content-type","application/json")
                .when()
                        .get("/ucak-bileti/trip-autocomplete/?term="+keyword).toString();

    }
}