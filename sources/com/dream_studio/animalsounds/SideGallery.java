package com.dream_studio.animalsounds;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.p000v4.media.session.PlaybackStateCompat;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HeaderViewListAdapter;
import android.widget.ListView;
import androidx.collection.LruCache;
import com.medio.myutilities.BitmapLoaderFromResource;
import java.util.ArrayList;

public class SideGallery {

    /* renamed from: a */
    Context f6823a;

    /* renamed from: b */
    Activity f6824b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public LruCache<String, Bitmap> f6825c = new C1446a(this, ((int) (Runtime.getRuntime().maxMemory() / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID)) / 4);

    /* renamed from: d */
    private DisplayMetrics f6826d;

    public class SideGalleryListViewAdapter extends BaseAdapter {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public ArrayList<ItemHolder> f6827a;

        SideGalleryListViewAdapter() {
            ArrayList<ItemHolder> arrayList = new ArrayList<>();
            this.f6827a = arrayList;
            arrayList.clear();
        }

        public void add(int i, String str, int i2) {
            this.f6827a.add(new ItemHolder(i, this.f6827a.size(), str, i2));
        }

        public void clear() {
            this.f6827a.clear();
        }

        public int getCount() {
            return this.f6827a.size();
        }

        public Object getItem(int i) {
            return null;
        }

        public long getItemId(int i) {
            return 0;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v15, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: android.graphics.Bitmap} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public android.view.View getView(int r9, android.view.View r10, android.view.ViewGroup r11) {
            /*
                r8 = this;
                r0 = 0
                if (r10 != 0) goto L_0x0012
                android.content.Context r10 = r11.getContext()
                android.view.LayoutInflater r10 = android.view.LayoutInflater.from(r10)
                r11 = 2131492928(0x7f0c0040, float:1.8609322E38)
                android.view.View r10 = r10.inflate(r11, r0)
            L_0x0012:
                r11 = 2131296487(0x7f0900e7, float:1.8210892E38)
                android.view.View r11 = r10.findViewById(r11)
                r3 = r11
                android.widget.ImageView r3 = (android.widget.ImageView) r3
                r11 = 2131296492(0x7f0900ec, float:1.8210902E38)
                android.view.View r11 = r10.findViewById(r11)
                com.dream_studio.animalsounds.FontTextView r11 = (com.dream_studio.animalsounds.FontTextView) r11
                java.util.ArrayList<com.dream_studio.animalsounds.ItemHolder> r1 = r8.f6827a
                java.lang.Object r1 = r1.get(r9)
                com.dream_studio.animalsounds.ItemHolder r1 = (com.dream_studio.animalsounds.ItemHolder) r1
                java.lang.String r1 = r1.itemText
                r11.setText(r1)
                com.dream_studio.animalsounds.SideGallery r11 = com.dream_studio.animalsounds.SideGallery.this
                androidx.collection.LruCache r11 = r11.f6825c
                if (r11 == 0) goto L_0x005a
                com.dream_studio.animalsounds.SideGallery r11 = com.dream_studio.animalsounds.SideGallery.this
                androidx.collection.LruCache r11 = r11.f6825c
                java.util.ArrayList<com.dream_studio.animalsounds.ItemHolder> r0 = r8.f6827a
                java.lang.Object r0 = r0.get(r9)
                com.dream_studio.animalsounds.ItemHolder r0 = (com.dream_studio.animalsounds.ItemHolder) r0
                int r0 = r0.itemResId
                java.lang.String r0 = java.lang.String.valueOf(r0)
                java.lang.Object r11 = r11.get(r0)
                r0 = r11
                android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0
                if (r0 == 0) goto L_0x005a
                r3.setImageBitmap(r0)
            L_0x005a:
                r11 = 2131296491(0x7f0900eb, float:1.82109E38)
                android.view.View r11 = r10.findViewById(r11)
                android.widget.ProgressBar r11 = (android.widget.ProgressBar) r11
                if (r0 != 0) goto L_0x0097
                com.medio.myutilities.ImageHolder r0 = new com.medio.myutilities.ImageHolder
                r0.<init>(r9, r11)
                r3.setTag(r0)
                r0 = 0
                r11.setVisibility(r0)
                com.dream_studio.animalsounds.SideGallery r11 = com.dream_studio.animalsounds.SideGallery.this
                android.content.Context r1 = r11.f6823a
                java.util.ArrayList<com.dream_studio.animalsounds.ItemHolder> r11 = r8.f6827a
                java.lang.Object r9 = r11.get(r9)
                com.dream_studio.animalsounds.ItemHolder r9 = (com.dream_studio.animalsounds.ItemHolder) r9
                int r2 = r9.itemResId
                android.view.ViewGroup$LayoutParams r9 = r3.getLayoutParams()
                int r4 = r9.width
                android.view.ViewGroup$LayoutParams r9 = r3.getLayoutParams()
                int r5 = r9.height
                android.graphics.Bitmap$Config r6 = android.graphics.Bitmap.Config.RGB_565
                com.dream_studio.animalsounds.SideGallery r9 = com.dream_studio.animalsounds.SideGallery.this
                androidx.collection.LruCache r7 = r9.f6825c
                com.medio.myutilities.BitmapLoaderFromResource.loadBitmap(r1, r2, r3, r4, r5, r6, r7)
                goto L_0x009b
            L_0x0097:
                r9 = 4
                r11.setVisibility(r9)
            L_0x009b:
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.dream_studio.animalsounds.SideGallery.SideGalleryListViewAdapter.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
        }
    }

    /* renamed from: com.dream_studio.animalsounds.SideGallery$a */
    class C1446a extends LruCache<String, Bitmap> {
        C1446a(SideGallery sideGallery, int i) {
            super(i);
        }

        @TargetApi(12)
        /* renamed from: b */
        public int mo10527b(Bitmap bitmap) {
            if (Build.VERSION.SDK_INT >= 12) {
                return bitmap.getByteCount();
            }
            return bitmap.getRowBytes() * bitmap.getHeight();
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public int sizeOf(String str, Bitmap bitmap) {
            return mo10527b(bitmap) / 1024;
        }
    }

    /* renamed from: com.dream_studio.animalsounds.SideGallery$b */
    class C1447b implements AdapterView.OnItemClickListener {
        C1447b() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (i > 0) {
                ((ImagesActivity) SideGallery.this.f6823a).setImageFromSideGalleryClick(((ItemHolder) ((SideGalleryListViewAdapter) ((HeaderViewListAdapter) adapterView.getAdapter()).getWrappedAdapter()).f6827a.get(i - 1)).switchedPosition);
            } else {
                ((ImagesActivity) SideGallery.this.f6823a).onHeaderSideGalleryClick();
            }
        }
    }

    public SideGallery(Context context, ArrayList<Integer> arrayList) {
        this.f6823a = context;
        this.f6824b = (Activity) context;
        View inflate = this.f6824b.getLayoutInflater().inflate(C1441R.layout.side_gallery_list_header, (ViewGroup) null);
        ListView listView = (ListView) this.f6824b.findViewById(C1441R.C1443id.side_gallery_list);
        listView.addHeaderView(inflate);
        this.f6826d = new DisplayMetrics();
        this.f6824b.getWindowManager().getDefaultDisplay().getMetrics(this.f6826d);
        int identifier = this.f6824b.getResources().getIdentifier("animal_sounds", "drawable", this.f6824b.getPackageName());
        Resources resources = this.f6824b.getResources();
        Context context2 = this.f6823a;
        Resources resources2 = this.f6824b.getResources();
        DisplayMetrics displayMetrics = this.f6826d;
        ((CustomImageView) this.f6824b.findViewById(C1441R.C1443id.bkg_listview)).setImageDrawable(new RecyclingBitmapDrawable(resources, BitmapLoaderFromResource.decodeSampledBitmapFromResourceMemOpt(context2, resources2, identifier, displayMetrics.widthPixels, displayMetrics.heightPixels, Bitmap.Config.ARGB_8888)));
        listView.setCacheColorHint(0);
        listView.setAdapter(new SideGalleryListViewAdapter());
        listView.setOnItemClickListener(new C1447b());
    }

    public void add(int i, String str, int i2) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        BitmapFactory.decodeResource(this.f6824b.getResources(), i, options);
        ((SideGalleryListViewAdapter) ((HeaderViewListAdapter) ((ListView) this.f6824b.findViewById(C1441R.C1443id.side_gallery_list)).getAdapter()).getWrappedAdapter()).add(i, str, i2);
    }

    public void destroy() {
        ((SideGalleryListViewAdapter) ((HeaderViewListAdapter) ((ListView) this.f6824b.findViewById(C1441R.C1443id.side_gallery_list)).getAdapter()).getWrappedAdapter()).clear();
        ((CustomImageView) this.f6824b.findViewById(C1441R.C1443id.bkg_listview)).setImageDrawable((Drawable) null);
        this.f6825c.evictAll();
    }

    public boolean isShown() {
        return ((ListView) this.f6824b.findViewById(C1441R.C1443id.side_gallery_list)).isShown();
    }

    public void setSelected(int i) {
        ((ListView) this.f6824b.findViewById(C1441R.C1443id.side_gallery_list)).setSelection(i);
    }
}
