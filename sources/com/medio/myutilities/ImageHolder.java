package com.medio.myutilities;

import android.widget.ProgressBar;

public class ImageHolder {
    public int position;
    public ProgressBar progress;

    public ImageHolder() {
        this.position = 0;
        this.progress = null;
    }

    public ImageHolder(int i, ProgressBar progressBar) {
        this.position = i;
        this.progress = progressBar;
    }
}
