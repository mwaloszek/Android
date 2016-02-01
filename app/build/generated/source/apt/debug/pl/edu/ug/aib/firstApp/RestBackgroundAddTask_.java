//
// DO NOT EDIT THIS FILE.Generated using AndroidAnnotations 3.3.2.
//  You can create a larger work that contains this file and distribute that work under terms of your choice.
//


package pl.edu.ug.aib.firstApp;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import org.androidannotations.api.BackgroundExecutor;
import pl.edu.ug.aib.firstApp.data.Person;

public final class RestBackgroundAddTask_
    extends RestBackgroundAddTask
{

    private Context context_;
    private Handler handler_ = new Handler(Looper.getMainLooper());

    private RestBackgroundAddTask_(Context context) {
        context_ = context;
        init_();
    }

    public static RestBackgroundAddTask_ getInstance_(Context context) {
        return new RestBackgroundAddTask_(context);
    }

    private void init_() {
        restClient = new PhoneBookRestClient_(context_);
        if (context_ instanceof AddTaskView) {
            activity = ((AddTaskView) context_);
        } else {
            Log.w("RestBackgroundAddTask_", (("Due to Context class "+ context_.getClass().getSimpleName())+", the @RootContext AddTaskView won't be populated"));
        }
    }

    public void rebind(Context context) {
        context_ = context;
        init_();
    }

    @Override
    public void publishError(final Exception e) {
        handler_.post(new Runnable() {


            @Override
            public void run() {
                RestBackgroundAddTask_.super.publishError(e);
            }

        }
        );
    }

    @Override
    public void publishSuccess() {
        handler_.post(new Runnable() {


            @Override
            public void run() {
                RestBackgroundAddTask_.super.publishSuccess();
            }

        }
        );
    }

    @Override
    public void addItems(final Person person) {
        BackgroundExecutor.execute(new BackgroundExecutor.Task("", 0, "") {


            @Override
            public void execute() {
                try {
                    RestBackgroundAddTask_.super.addItems(person);
                } catch (Throwable e) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), e);
                }
            }

        }
        );
    }

}
