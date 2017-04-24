package trainedge.scoop;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by hp on 23-Apr-17.
 */

public class ConnectvityManager extends AppCompatActivity {
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

  public ConnectivityManager getSystemService(String connectivityService) {
        return null;
    }
}
