package com.arodream.tripuratourism;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;

public class MainActivity extends AppCompatActivity {
    private SliderLayout imageSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageSlider = (SliderLayout)findViewById(R.id.img_slider);
        imageSlider.setIndicatorAnimation(IndicatorAnimations.FILL);
        imageSlider.setScrollTimeInSec(2);
        showSlider();
    }

    private void showSlider() {
        for (int i = 0; i < 4; i++) {
            DefaultSliderView sliderView = new DefaultSliderView(getApplicationContext());

            switch (i) {
                case 0:
                    sliderView.setImageUrl("http://gdp.nic.in/images/faculty.jpg");
                    break;
                case 1:
                    sliderView.setImageUrl("http://gdp.nic.in/images/admin.jpg");
                    break;
                case 2:
                    sliderView.setImageUrl("http://gdp.nic.in/photo/2.jpg");
                    break;
                case 3:
                    sliderView.setImageUrl("https://images.pexels.com/photos/929778/pexels-photo-929778.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
                    break;
            }
            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
            sliderView.setDescription("The quick brown fox jumps over the lazy dog.\n" +
                    ". " + (i + 1));
            final int finalI = i;

            sliderView.setOnSliderClickListener(new SliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(SliderView sliderView) {
                    Toast.makeText(getApplicationContext(), "This is slider " + (finalI + 1), Toast.LENGTH_SHORT).show();

                }
            });
            imageSlider.addSliderView(sliderView);
        }
    }


}
