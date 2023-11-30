package me.r4bt.headsandtails;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView mainText;
    Button btnflip;
    ImageView coinImage;

    int count = 0;
    Random random = new Random();
    int[] array = new int[100];
    int rand1to100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initVal();
        setArray();
        count++;
    }

    private void setArray() {
        for (int i = 0; i < ((MyApplication) this.getApplication()).getProbabilityHeads(); i++) {
            array[i] = 1;
        }
    }

    private void initVal() {
        mainText = findViewById(R.id.mainText);
        btnflip = findViewById(R.id.btnFlip);
        coinImage = findViewById(R.id.coinImage);
    }

    public void onFlipClick(View view) {
        rand1to100 = random.nextInt(100);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.bounce);

        switch (array[rand1to100]) {
            case 1:
                mainText.setText("Орёл");
                coinImage.setImageResource(R.drawable.orel);
                coinImage.startAnimation(animation);
                break;
            case 0:
                mainText.setText("Решка");
                coinImage.setImageResource(R.drawable.reshka);
                coinImage.startAnimation(animation);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = new Intent(MainActivity.this, Settings.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }
}