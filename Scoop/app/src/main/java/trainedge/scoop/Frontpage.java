package trainedge.scoop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Frontpage extends AppCompatActivity {

    private ImageView scoop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frontpage);
        scoop = (ImageView) findViewById(R.id.scoop);
        final Animation a1= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animation);

        Thread mythread = new Thread() {
            @Override
            public void run() {

                try {
                    scoop.startAnimation(a1);
                    Thread.sleep(3000);
                    ;

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    Intent abtIntent=new Intent(Frontpage.this,LoginActivity.class);
                    startActivity(abtIntent);
                    finish();
                }


            }
        };

        mythread.start();
    }
}
