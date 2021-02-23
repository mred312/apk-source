package com.dream_studio.animalsounds;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HeaderViewListAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import java.util.ArrayList;

public class BottomGallery {

    /* renamed from: a */
    Context f6551a;

    /* renamed from: b */
    ImagesActivity f6552b;

    /* renamed from: c */
    DisplayMetrics f6553c;

    public class BottomGalleryListViewAdapter extends BaseAdapter {

        /* renamed from: a */
        private ArrayList<String> f6554a;

        /* renamed from: com.dream_studio.animalsounds.BottomGallery$BottomGalleryListViewAdapter$a */
        class C1374a implements RequestListener<Drawable> {

            /* renamed from: a */
            final /* synthetic */ ProgressBar f6556a;

            /* renamed from: b */
            final /* synthetic */ String f6557b;

            /* renamed from: c */
            final /* synthetic */ TextView f6558c;

            C1374a(ProgressBar progressBar, String str, TextView textView) {
                this.f6556a = progressBar;
                this.f6557b = str;
                this.f6558c = textView;
            }

            /* renamed from: a */
            public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
                this.f6556a.setVisibility(4);
                this.f6558c.setVisibility(4);
                return false;
            }

            public boolean onLoadFailed(@Nullable GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
                this.f6556a.setVisibility(4);
                if (glideException != null) {
                    String message = glideException.getMessage();
                    if (message.contains("HTTP 404") || message.contains("java.io.FileNotFoundException")) {
                        BottomGalleryListViewAdapter.this.remove(this.f6557b);
                    } else if (message.contains("HTTP 504")) {
                        this.f6558c.setText(String.format("%s\n%s", new Object[]{BottomGallery.this.f6551a.getString(C1441R.string.internet_connection_error), message}));
                        this.f6558c.setVisibility(0);
                    } else {
                        this.f6558c.setText(message);
                        this.f6558c.setVisibility(0);
                    }
                }
                return false;
            }
        }

        BottomGalleryListViewAdapter() {
            ArrayList<String> arrayList = new ArrayList<>();
            this.f6554a = arrayList;
            arrayList.clear();
        }

        public void add(String str) {
            this.f6554a.add(str);
        }

        public void clear() {
            this.f6554a.clear();
        }

        public int getCount() {
            return this.f6554a.size();
        }

        public Object getItem(int i) {
            return null;
        }

        public long getItemId(int i) {
            return 0;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(C1441R.layout.bottom_gallery_list_item, (ViewGroup) null);
            }
            ImageView imageView = (ImageView) view.findViewById(C1441R.C1443id.bottom_gallery_image);
            ProgressBar progressBar = (ProgressBar) view.findViewById(C1441R.C1443id.bottom_gallery_progress);
            TextView textView = (TextView) view.findViewById(C1441R.C1443id.bottom_gallery_error_msg);
            String str = this.f6554a.get(i);
            textView.setVisibility(4);
            progressBar.setVisibility(0);
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            BottomGallery bottomGallery = BottomGallery.this;
            layoutParams.width = bottomGallery.f6553c.widthPixels;
            if (bottomGallery.f6552b.getResources().getConfiguration().orientation == 1) {
                double d = (double) BottomGallery.this.f6553c.widthPixels;
                Double.isNaN(d);
                layoutParams.height = (int) (d * 0.66d);
            } else {
                int i2 = BottomGallery.this.f6553c.heightPixels;
                double d2 = (double) i2;
                Double.isNaN(d2);
                layoutParams.height = (int) (d2 * 0.525d * 1.3d);
                double d3 = (double) i2;
                Double.isNaN(d3);
                layoutParams.width = (int) (d3 * 1.25d);
            }
            ((RequestBuilder) Glide.with((Activity) BottomGallery.this.f6552b).load(str).centerCrop()).listener(new C1374a(progressBar, str, textView)).into(imageView);
            return view;
        }

        public void remove(String str) {
            for (int i = 0; i < this.f6554a.size(); i++) {
                if (this.f6554a.get(i).equals(str)) {
                    this.f6554a.remove(i);
                    notifyDataSetChanged();
                    return;
                }
            }
        }
    }

    /* renamed from: com.dream_studio.animalsounds.BottomGallery$a */
    class C1375a implements AdapterView.OnItemClickListener {
        C1375a() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (i > 0) {
                ((ImagesActivity) BottomGallery.this.f6551a).setImageFromBottomGalleryClick(i - 1);
            } else {
                ((ImagesActivity) BottomGallery.this.f6551a).onHeaderBottomGalleryClick();
            }
        }
    }

    /* renamed from: com.dream_studio.animalsounds.BottomGallery$b */
    class C1376b implements View.OnTouchListener {

        /* renamed from: a */
        final /* synthetic */ GestureDetector f6561a;

        C1376b(BottomGallery bottomGallery, GestureDetector gestureDetector) {
            this.f6561a = gestureDetector;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            return this.f6561a.onTouchEvent(motionEvent);
        }
    }

    public BottomGallery(Context context, DisplayMetrics displayMetrics) {
        this.f6551a = context;
        ImagesActivity imagesActivity = (ImagesActivity) context;
        this.f6552b = imagesActivity;
        this.f6553c = displayMetrics;
        View inflate = imagesActivity.getLayoutInflater().inflate(C1441R.layout.bottom_gallery_list_header, (ViewGroup) null);
        ListView listView = (ListView) this.f6552b.findViewById(C1441R.C1443id.bottom_gallery_list);
        listView.addHeaderView(inflate);
        listView.setCacheColorHint(0);
        listView.setAdapter(new BottomGalleryListViewAdapter());
        GestureDetector gestureDetector = new GestureDetector(this.f6551a, new C1470c((ImagesActivity) this.f6551a));
        listView.setOnItemClickListener(new C1375a());
        listView.setOnTouchListener(new C1376b(this, gestureDetector));
    }

    public void add(String str) {
        ((BottomGalleryListViewAdapter) ((HeaderViewListAdapter) ((ListView) this.f6552b.findViewById(C1441R.C1443id.bottom_gallery_list)).getAdapter()).getWrappedAdapter()).add(str);
    }

    public void clear() {
        ListView listView = (ListView) this.f6552b.findViewById(C1441R.C1443id.bottom_gallery_list);
        ((BottomGalleryListViewAdapter) ((HeaderViewListAdapter) listView.getAdapter()).getWrappedAdapter()).clear();
        ((BottomGalleryListViewAdapter) ((HeaderViewListAdapter) listView.getAdapter()).getWrappedAdapter()).notifyDataSetChanged();
    }

    public void destroy() {
        ((BottomGalleryListViewAdapter) ((HeaderViewListAdapter) ((ListView) this.f6552b.findViewById(C1441R.C1443id.bottom_gallery_list)).getAdapter()).getWrappedAdapter()).clear();
    }

    public boolean isShown() {
        return ((ListView) this.f6552b.findViewById(C1441R.C1443id.bottom_gallery_list)).isShown();
    }

    public void notifyDataSetChanged() {
        ((BottomGalleryListViewAdapter) ((HeaderViewListAdapter) ((ListView) this.f6552b.findViewById(C1441R.C1443id.bottom_gallery_list)).getAdapter()).getWrappedAdapter()).notifyDataSetChanged();
    }

    public void setSelected(int i) {
        ((ListView) this.f6552b.findViewById(C1441R.C1443id.bottom_gallery_list)).setSelection(i);
    }
}
