package pl.edu.ug.aib.firstApp;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.rest.RestService;

import pl.edu.ug.aib.firstApp.data.Person;
import pl.edu.ug.aib.firstApp.data.PhoneBook;

@EBean
public class RestBackgroundTask {

    @RootContext
    FirstActivity activity;

    @RestService
    PhoneBookRestClient restClient;

    @Background
    void getPhoneBook() {
        try {
            restClient.setHeader("X-DreamFactory-Api-Key", "5fbd4c24e49371d5871619d34a2aa0860b9df5109158e513a598e6b3888ac550");
            PhoneBook phoneBook = restClient.getPhoneBook();
            publishResult(phoneBook);
        } catch (Exception e) {
            publishError(e);
        }
    }
    

    @UiThread
    void publishResult(PhoneBook phoneBook) {
        activity.updatePhonebook(phoneBook);
    }

    @UiThread
    void publishError(Exception e) {
        activity.showError(e);
    }

}
