package pl.edu.ug.aib.firstApp.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PhoneBook {

    @JsonProperty("resource")
    public List<Person> records = new ArrayList<Person>();
}
