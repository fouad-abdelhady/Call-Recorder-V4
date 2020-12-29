package hk.ust.cse.comp107x.stepbystep;

import android.media.MediaRecorder;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private TextView status;
    private MediaRecorder mRecorder;
    private String mFilePath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViews();
    }

    private void setViews() {
        status = findViewById(R.id.status);
    }


    public void stopRecording(View view) {
        mRecorder.stop();
        mRecorder.release();
        mRecorder = null;
    }

    public void startRecording(View view) {
        mFilePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        mFilePath += "/record1.3gp";
        mRecorder = new MediaRecorder();
        mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mRecorder.setOutputFile(mFilePath);
        mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

        try {
            mRecorder.prepare();
        } catch (IOException e) {
            Log.e("recorder", "prepare() failed");
        }

        mRecorder.start();
    }
}
