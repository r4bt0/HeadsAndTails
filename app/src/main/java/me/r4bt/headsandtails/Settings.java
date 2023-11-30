package me.r4bt.headsandtails;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Settings extends AppCompatActivity {
    TextView textView;
    SeekBar percHeads;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        initVal();

        percHeads.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textView.setText("Процент выпадение орла: " + i + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void initVal() {
        textView = findViewById(R.id.textView);
        textView.setText("Процент выпадение орла: " + ((MyApplication) this.getApplication()).getProbabilityHeads() + "%");
        percHeads = findViewById(R.id.percHeads);
        percHeads.setProgress(((MyApplication) this.getApplication()).getProbabilityHeads());
    }

    public void setProb(View view) {
        ((MyApplication) this.getApplication()).setProbabilityHeads(percHeads.getProgress());
        Intent intent = new Intent(Settings.this, MainActivity.class);
        startActivity(intent);
    }
}
