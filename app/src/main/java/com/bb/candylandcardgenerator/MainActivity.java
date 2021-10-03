package com.bb.candylandcardgenerator;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends Activity {
    ArrayList<Integer> candy = new ArrayList<>(4);

    Integer[] doubles = {R.drawable.double_1, R.drawable.double_2, R.drawable.double_3, R.drawable.double_4,
            R.drawable.double_5, R.drawable.double_6};

    Integer[] singles = {R.drawable.single_1, R.drawable.single_2, R.drawable.single_3, R.drawable.single_4,
            R.drawable.single_5, R.drawable.single_6};

    final Random card = new Random();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        candy.add(R.drawable.candy_1);
        candy.add(R.drawable.candy_2);
        candy.add(R.drawable.candy_3);
        candy.add(R.drawable.candy_4);

        Button button = findViewById(R.id.button);
        ImageView imageView = findViewById(R.id.imageView);
        ImageView imageView2 = findViewById(R.id.imageView2);

        button.setOnClickListener(v -> cardSelector(imageView, imageView2));
    }

    void cardSelector(ImageView imageView, ImageView imageView2) {
        double deck = Math.random();
        imageView2.setImageDrawable(imageView.getDrawable());
        int listIndex;
        if(deck < .08 && !candy.isEmpty()) {
            listIndex = card.nextInt(candy.size());
            imageView.setImageResource(candy.get(listIndex));
            candy.remove(listIndex);

        }else if(deck > .85){
            imageView.setImageResource(doubles[card.nextInt(doubles.length)]);

        }else{
            imageView.setImageResource(singles[card.nextInt(singles.length)]);
        }
    }
}