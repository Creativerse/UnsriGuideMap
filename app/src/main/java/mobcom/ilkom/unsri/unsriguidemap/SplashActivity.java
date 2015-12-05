package mobcom.ilkom.unsri.unsriguidemap;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    public void masuk(View view){
        Intent masukIntent = new Intent(this, MapActivity.class);
        startActivity(masukIntent);
    }
}
