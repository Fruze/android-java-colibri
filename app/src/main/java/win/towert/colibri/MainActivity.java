package win.towert.colibri;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.f2prateek.dart.HensonNavigable;

@HensonNavigable
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
