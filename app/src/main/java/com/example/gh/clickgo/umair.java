package com.example.gh.clickgo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by GH on 4/5/2017.
 */

public class umair extends AppCompatActivity {
    ImageView imageView,imagSeatSelslected;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.umair);
        imageView=(ImageView)findViewById(R.id.img_seat);
        imagSeatSelslected=(ImageView)findViewById(R.id.img_seat_selected);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(imagSeatSelslected.getVisibility()==View.INVISIBLE){
                    imagSeatSelslected.setVisibility(View.VISIBLE);
                    imageView.setVisibility(View.INVISIBLE);
                }else{
                    imagSeatSelslected.setVisibility(View.INVISIBLE);
                    imageView.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
