package pl.edu.ug.aib.firstApp;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.NonConfigurationInstance;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.rest.RestService;
import org.androidannotations.api.view.HasViews;
import org.springframework.util.StringUtils;

import pl.edu.ug.aib.firstApp.data.Person;

/**
 * Created by Marcin on 31.01.2016.
 */
@EActivity(R.layout.activity_second)
public class AddTaskView extends AppCompatActivity {

    @Bean
    @NonConfigurationInstance
    RestBackgroundAddTask restBackgroundaddTask;

    @RestService
    PhoneBookRestClient prc;
    //region EditTexts
    @ViewById
    EditText name;



    @AfterViews
    void init() {

    }


    @Click
    void addTaskClicked(){
        if(StringUtils.hasText(name.getText().toString()) == true ){

            //new class
            Person person = new Person();
            person.name = name.getText().toString();
            person.status = "new";



            //POST operation
            restBackgroundaddTask.addItems(person);


        } else{
            Toast.makeText(this, "Uzupełnij wymagane pola!", Toast.LENGTH_LONG).show();
        }
    }


    public void showSuccess(){
        Toast.makeText(this,"Dodano nowe zadanie!",Toast.LENGTH_LONG).show();
        FirstActivity_.intent(this).start();
    }

    public void showError(Exception e){
        Toast.makeText(this, "Błąd\n" + e.getMessage(), Toast.LENGTH_LONG).show();
        e.printStackTrace(); //debug
    }

}
