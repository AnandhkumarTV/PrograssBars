package tv.anandhkumar.progressbars;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar,progressBarHorizontal;
    Button start,stop,upload;
    int progress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);
        progressBarHorizontal = findViewById(R.id.progressBarHorizontal);
        start = findViewById(R.id.start);
        stop = findViewById(R.id.stop);
        upload = findViewById(R.id.upload);

        progressBar.setVisibility(View.GONE);

    }

    public void upload(View view) {
        fakeProgess(progress);
    }

    private void fakeProgess( final int progress) {
        progressBarHorizontal.setProgress(progress);
        if (progress == 100){
            setProgress(0);
        }else {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    fakeProgess(progress + 10);
                }
            });
            thread.start();
        }
    }

    public void start(View view) {
        progressBar.setVisibility(View.VISIBLE);
    }

    public void stop(View view) {
        progressBar.setVisibility(View.GONE);
    }
}
