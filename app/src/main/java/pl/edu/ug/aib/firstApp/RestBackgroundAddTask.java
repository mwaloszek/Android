package pl.edu.ug.aib.firstApp;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.rest.RestService;

import pl.edu.ug.aib.firstApp.data.Person;

/**
 * Created by Marcin on 31.01.2016.
 */
@EBean
public class RestBackgroundAddTask {


    @RootContext
    AddTaskView activity; //activity with listview

    @RestService
    PhoneBookRestClient restClient; //use that cool interface



    @UiThread
    void publishSuccess(){activity.showSuccess(); }
    @UiThread
    void publishError(Exception e){activity.showError(e);}

    @Background
    public void addItems(Person person){
        try
        {
            //rest client headers for POST
            restClient.setHeader("X-DreamFactory-Api-Key", "5fbd4c24e49371d5871619d34a2aa0860b9df5109158e513a598e6b3888ac550");
            //recipe is filled in AddRecipeView so it only requires to pass it to restClient.addRecipe
            restClient.addItems(person);
            publishSuccess();
        }
        catch(Exception e)
        {
            publishError(e);
        }

    }



}
