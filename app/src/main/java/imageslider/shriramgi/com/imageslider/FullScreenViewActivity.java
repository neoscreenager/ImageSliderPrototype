package imageslider.shriramgi.com.imageslider;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import imageslider.shriramgi.com.adapter.FullScreenImageAdapter;
import imageslider.shriramgi.com.helper.Utils;

/**
 * Created by neo on 10/2/15.
 */
public class FullScreenViewActivity extends AppCompatActivity {
    private Utils utils;
    private FullScreenImageAdapter adapter;
    private ViewPager viewPager;

    Button btnEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //making it truly full screen by hiding the title
       /* requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);*/

        setContentView(R.layout.activity_fullscreen_view);

        viewPager = (ViewPager) findViewById(R.id.pager);

        utils = new Utils(getApplicationContext());

        Intent i = getIntent();
        int position = i.getIntExtra("position", 0);
        Uri imageFileUri = i.getData();

        adapter = new FullScreenImageAdapter(FullScreenViewActivity.this,
                utils.getFilePaths());

        viewPager.setAdapter(adapter);

        // displaying selected image first
        viewPager.setCurrentItem(position);


    }

    public boolean onTouch(View arg0, MotionEvent arg1) {
        return false;
    }
}
