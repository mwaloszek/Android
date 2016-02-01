package pl.edu.ug.aib.firstApp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;

/**
 * Created by Marcin on 31.01.2016.
 */
@EActivity(R.layout.activity_my)
public class MainActivity extends AppCompatActivity {

    @Click
    void addTaskClicked(){
        AddTaskView_.intent(this).start();

    }



}
