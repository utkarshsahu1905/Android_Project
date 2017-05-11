package trainedge.scoop;


import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.squareup.picasso.Picasso;


public class GetProfile extends AppCompatActivity {


    public static final String TAG = "Profile";
    private ImageView imageView;
    private FirebaseAuth auth;
    private TextView email;
    private TextView name;
    private ProgressBar progressBar;
    private String username;
    private String email1;
    private boolean emailVerified;
    private String uid;
    private String providerId;
    private UserInfo profile;
    private Uri photoUrl;
    private FirebaseUser user;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private SharedPreferences pref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pref = getSharedPreferences("setting_pref", MODE_PRIVATE);
        String theme = pref.getString("theme", "Default");
        if (theme.equals("Blue")) {
            setTheme(R.style.Bluetheme);
        } else if (theme.equals("Black")) {
            setTheme(R.style.BlackTheme);
        } else if (theme.equals("White")) {
            setTheme(R.style.WhiteTheme);
        }
        else if (theme.equals("Pink")) {
            setTheme(R.style.PinkTheme);
        }else {
            setTheme(R.style.AppTheme_NoActionBar);
        }
        setContentView(R.layout.activity_get_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Profile Info");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // create object
        imageView = (ImageView) findViewById(R.id.imageView);
        name = (TextView) findViewById(R.id.name);
        email = (TextView) findViewById(R.id.email);
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        if (user == null) {
            finish();


        }
        email.setText(user.getEmail());
        name.setText(user.getDisplayName());

        //Loading image from below url into imageView
        Picasso.with(this)
                .load(user.getPhotoUrl())
                .into(imageView);

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null) {
                    //user is signed in
                    // dialog.dismiss();
                    Intent detail = new Intent(GetProfile.this,LoginActivity.class);
                    startActivity(detail);
                    finish();
                    detail.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(detail);
                }

            }
        };
    }
}