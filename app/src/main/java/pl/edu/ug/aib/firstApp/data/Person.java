package pl.edu.ug.aib.firstApp.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {

    public  int id;
    public String name;
    public String status;

}
