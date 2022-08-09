package model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Root {

    @SerializedName("label")
    String label;

    @SerializedName("slug")
    String slug;

    @SerializedName("id")
    String id;

    @SerializedName("country_code")
    String countryCode;

    @SerializedName("country_name")
    String countryName;

    @SerializedName("city_code")
    String cityCode;

    @SerializedName("city_name")
    String cityName;

    @SerializedName("is_city")
    boolean isCity;

    @SerializedName("airport")
    String airport;

    @SerializedName("ghost_label")
    String ghostLabel;

}