package pl.edu.ug.aib.firstApp;

import org.androidannotations.annotations.rest.Get;
import org.androidannotations.annotations.rest.Post;
import org.androidannotations.annotations.rest.RequiresHeader;
import org.androidannotations.annotations.rest.Rest;
import org.androidannotations.api.rest.RestClientHeaders;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import pl.edu.ug.aib.firstApp.data.Person;
import pl.edu.ug.aib.firstApp.data.PhoneBook;


@Rest(rootUrl = "http://kangur.wzr.pl:8080/api/v2",
        converters = { MappingJackson2HttpMessageConverter.class })
@RequiresHeader({"X-DreamFactory-Api-Key"})
public interface PhoneBookRestClient extends RestClientHeaders {

    @Get("/db/_table/person")
    PhoneBook getPhoneBook();

    @RequiresHeader({"X-DreamFactory-Api-Key"})
    @Post("/db/_table/note")
    void addItems(Person person);

}
