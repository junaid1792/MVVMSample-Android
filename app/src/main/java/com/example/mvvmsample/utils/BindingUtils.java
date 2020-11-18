package com.example.mvvmsample.utils;

import android.content.Context;
import android.widget.ImageView;
import androidx.databinding.BindingAdapter;



/**
 *  Created by junaid on 17/07/20.
 */

public final class BindingUtils {

    private BindingUtils() {
        // This class is not publicly instantiable
    }


    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        Context context = imageView.getContext();
        GlideApp.with(context).load(url).into(imageView);
    }
}
