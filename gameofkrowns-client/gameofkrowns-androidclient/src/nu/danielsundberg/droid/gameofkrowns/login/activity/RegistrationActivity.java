package nu.danielsundberg.droid.gameofkrowns.login.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gcm.GCMRegistrar;

import static nu.danielsundberg.droid.gameofkrowns.CommonUtils.CLIENT_ID;

public class RegistrationActivity extends Activity {

    private String TAG = "** RegistrationActivity **";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        GCMRegistrar.checkDevice(this);
        GCMRegistrar.checkManifest(this);

        final String regId = GCMRegistrar.getRegistrationId(this);
        Log.i(TAG, "registration id =====  " + regId);

        if (regId.equals("")) {
            GCMRegistrar.register(this, CLIENT_ID);
        } else {
            Log.v(TAG, "Already registered");
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        GCMRegistrar.unregister(this);
    }

}
