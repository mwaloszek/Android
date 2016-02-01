//
// DO NOT EDIT THIS FILE.Generated using AndroidAnnotations 3.3.2.
//  You can create a larger work that contains this file and distribute that work under terms of your choice.
//


package pl.edu.ug.aib.firstApp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import org.androidannotations.api.SdkVersionHelper;
import org.androidannotations.api.builder.ActivityIntentBuilder;
import org.androidannotations.api.view.HasViews;
import org.androidannotations.api.view.OnViewChangedListener;
import org.androidannotations.api.view.OnViewChangedNotifier;
import pl.edu.ug.aib.firstApp.R.layout;
import pl.edu.ug.aib.firstApp.adapter.PersonListAdapter_;
import pl.edu.ug.aib.firstApp.data.Person;

public final class FirstActivity_
    extends FirstActivity
    implements HasViews, OnViewChangedListener
{

    private final OnViewChangedNotifier onViewChangedNotifier_ = new OnViewChangedNotifier();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        OnViewChangedNotifier previousNotifier = OnViewChangedNotifier.replaceNotifier(onViewChangedNotifier_);
        init_(savedInstanceState);
        super.onCreate(savedInstanceState);
        OnViewChangedNotifier.replaceNotifier(previousNotifier);
        setContentView(layout.activity_my);
    }

    private void init_(Bundle savedInstanceState) {
        OnViewChangedNotifier.registerOnViewChangedListener(this);
        adapter = PersonListAdapter_.getInstance_(this);
        if (restBackgroundTask == null) {
            restBackgroundTask = RestBackgroundTask_.getInstance_(this);
        }
        FirstActivity_.NonConfigurationInstancesHolder nonConfigurationInstance = ((FirstActivity_.NonConfigurationInstancesHolder) super.getLastCustomNonConfigurationInstance());
        if (nonConfigurationInstance!= null) {
            restBackgroundTask = nonConfigurationInstance.restBackgroundTask;
            ((RestBackgroundTask_) restBackgroundTask).rebind(this);
        }
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        onViewChangedNotifier_.notifyViewChanged(this);
    }

    @Override
    public void setContentView(View view, LayoutParams params) {
        super.setContentView(view, params);
        onViewChangedNotifier_.notifyViewChanged(this);
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        onViewChangedNotifier_.notifyViewChanged(this);
    }

    public static FirstActivity_.IntentBuilder_ intent(Context context) {
        return new FirstActivity_.IntentBuilder_(context);
    }

    public static FirstActivity_.IntentBuilder_ intent(Fragment supportFragment) {
        return new FirstActivity_.IntentBuilder_(supportFragment);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (((SdkVersionHelper.getSdkInt()< 5)&&(keyCode == KeyEvent.KEYCODE_BACK))&&(event.getRepeatCount() == 0)) {
            onBackPressed();
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onViewChanged(HasViews hasViews) {
        list = ((ListView) hasViews.findViewById(pl.edu.ug.aib.firstApp.R.id.list));
        {
            View view = hasViews.findViewById(pl.edu.ug.aib.firstApp.R.id.refresh);
            if (view!= null) {
                view.setOnClickListener(new OnClickListener() {


                    @Override
                    public void onClick(View view) {
                        FirstActivity_.this.refreshClicked();
                    }

                }
                );
            }
        }
        if (list!= null) {
            list.setOnItemClickListener(new OnItemClickListener() {


                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    FirstActivity_.this.listItemClicked(((Person) parent.getAdapter().getItem(position)));
                }

            }
            );
        }
        init();
    }

    @Override
    public Object getLastCustomNonConfigurationInstance() {
        FirstActivity_.NonConfigurationInstancesHolder nonConfigurationInstance = ((FirstActivity_.NonConfigurationInstancesHolder) super.getLastCustomNonConfigurationInstance());
        if (nonConfigurationInstance == null) {
            return null;
        }
        return nonConfigurationInstance.superNonConfigurationInstance;
    }

    @Override
    public FirstActivity_.NonConfigurationInstancesHolder onRetainCustomNonConfigurationInstance() {
        FirstActivity_.NonConfigurationInstancesHolder nonConfigurationInstanceState_ = new FirstActivity_.NonConfigurationInstancesHolder();
        nonConfigurationInstanceState_.superNonConfigurationInstance = super.onRetainCustomNonConfigurationInstance();
        nonConfigurationInstanceState_.restBackgroundTask = restBackgroundTask;
        return nonConfigurationInstanceState_;
    }

    public static class IntentBuilder_
        extends ActivityIntentBuilder<FirstActivity_.IntentBuilder_>
    {

        private Fragment fragmentSupport_;

        public IntentBuilder_(Context context) {
            super(context, FirstActivity_.class);
        }

        public IntentBuilder_(Fragment fragment) {
            super(fragment.getActivity(), FirstActivity_.class);
            fragmentSupport_ = fragment;
        }

        @Override
        public void startForResult(int requestCode) {
            if (fragmentSupport_!= null) {
                fragmentSupport_.startActivityForResult(intent, requestCode);
            } else {
                if (context instanceof Activity) {
                    Activity activity = ((Activity) context);
                    ActivityCompat.startActivityForResult(activity, intent, requestCode, lastOptions);
                } else {
                    context.startActivity(intent);
                }
            }
        }

    }

    private static class NonConfigurationInstancesHolder {

        public RestBackgroundTask restBackgroundTask;
        public Object superNonConfigurationInstance;

    }

}