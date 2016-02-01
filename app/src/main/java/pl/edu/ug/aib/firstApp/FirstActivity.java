package pl.edu.ug.aib.firstApp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.NonConfigurationInstance;
import org.androidannotations.annotations.ViewById;
import org.springframework.util.StringUtils;

import pl.edu.ug.aib.firstApp.adapter.PersonListAdapter;
import pl.edu.ug.aib.firstApp.data.Person;
import pl.edu.ug.aib.firstApp.data.PhoneBook;

@EActivity(R.layout.activity_my)
public class FirstActivity extends AppCompatActivity {

    @ViewById
    ListView list;

    @Bean
    PersonListAdapter adapter;


    @Bean
    @NonConfigurationInstance
    RestBackgroundTask restBackgroundTask;
    ProgressDialog ringProgressDialog;


    @AfterViews
    void init() {
        list.setAdapter(adapter);
        ringProgressDialog = new ProgressDialog(this);
        ringProgressDialog.setMessage("Loading...");
        ringProgressDialog.setIndeterminate(true);
    }

    @ItemClick
    void listItemClicked(Person item) {
        Toast.makeText(this, item.name, Toast.LENGTH_SHORT).show();
    }

    public void updatePhonebook(PhoneBook phoneBook) {
        ringProgressDialog.dismiss();
        adapter.update(phoneBook);
    }

    public void showError(Exception e) {
        ringProgressDialog.dismiss();
        Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        e.printStackTrace();
    }

    @Click
    void refreshClicked()    {
        ringProgressDialog.show();
        restBackgroundTask.getPhoneBook();
    }

    public void addItem(View view) {
        Intent intent = new Intent(this, SecondActivity_.class);
        startActivity(intent);
    }






}
