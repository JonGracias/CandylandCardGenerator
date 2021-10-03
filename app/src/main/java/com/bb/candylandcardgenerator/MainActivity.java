package com.bb.candylandcardgenerator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends Activity {
    Integer[] candy = {R.drawable.candy_1, R.drawable.candy_2, R.drawable.candy_3, R.drawable.candy_4,
            R.drawable.candy_5, R.drawable.candy_6};

    Integer[] doubles = {R.drawable.double_1, R.drawable.double_2, R.drawable.double_3, R.drawable.double_4,
            R.drawable.double_5, R.drawable.double_6};

    Integer[] singles = {R.drawable.single_1, R.drawable.single_2, R.drawable.single_3, R.drawable.single_4,
            R.drawable.single_5, R.drawable.single_6};

    final Random card = new Random();
    final double deck = Math.random();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        ImageView imageView = (ImageView) findViewById(R.id.imageView);

        button.setOnClickListener(v -> cardSelector(imageView));
    }

    void cardSelector(ImageView imageView) {
        if(deck < .2) {
            imageView.setImageResource(candy[card.nextInt(candy.length)]);
        }else if(deck > .7){
            imageView.setImageResource(doubles[card.nextInt(doubles.length)]);
        }else{
            imageView.setImageResource(singles[card.nextInt(singles.length)]);
        }
    }
}