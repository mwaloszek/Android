package pl.edu.ug.aib.firstApp.itemView;

import android.content.Context;
import android.media.Image;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import pl.edu.ug.aib.firstApp.R;
import pl.edu.ug.aib.firstApp.data.Person;

@EViewGroup(R.layout.list_item)
public class PersonItemView extends RelativeLayout {

    @ViewById
    ImageView acronym;

    @ViewById
    TextView name;

    @ViewById
    TextView status;

    public PersonItemView(Context context) {
        super(context);
    }

    public void bind(Person person) {
        name.setText(person.name);
        status.setText(person.status);

    }
}