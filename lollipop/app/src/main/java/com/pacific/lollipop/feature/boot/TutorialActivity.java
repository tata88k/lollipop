package com.pacific.lollipop.feature.boot;

import android.os.Bundle;

import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.slide.SimpleSlide;
import com.pacific.lollipop.R;
import com.pacific.lollipop.util.LevelUtil;

public class TutorialActivity extends IntroActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setButtonBackVisible(true);
        setButtonNextVisible(true);
        setButtonCtaVisible(false);
        setButtonCtaTintMode(BUTTON_CTA_TINT_MODE_TEXT);

        setButtonCtaLabel(getString(R.string.get_start));

        if (LevelUtil.level21()) {
            setPageScrollInterpolator(android.R.interpolator.fast_out_slow_in);
        }

        addSlide(new SimpleSlide.Builder()
                .title(R.string.title_canteen_intro1)
                .description(R.string.description_canteen_intro1)
                .image(R.drawable.art_splash_slide1)
                .background(R.color.color_green)
                .backgroundDark(R.color.color_dark_green)
                .layout(R.layout.tutorial_slide)
                .build());

        addSlide(new SimpleSlide.Builder()
                .title(R.string.title_canteen_intro2)
                .description(R.string.description_canteen_intro2)
                .image(R.drawable.art_canteen_intro2)
                .background(R.color.color_green)
                .backgroundDark(R.color.color_dark_green)
                .layout(R.layout.tutorial_slide)
                .build());

        addSlide(new SimpleSlide.Builder()
                .title(R.string.title_canteen_intro3)
                .description(R.string.description_canteen_intro3)
                .image(R.drawable.art_canteen_intro3)
                .background(R.color.color_green)
                .backgroundDark(R.color.color_dark_green)
                .layout(R.layout.tutorial_slide)
                .build());
    }
}
