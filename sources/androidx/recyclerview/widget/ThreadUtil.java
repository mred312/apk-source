package androidx.recyclerview.widget;

import androidx.recyclerview.widget.TileList;

interface ThreadUtil<T> {

    public interface BackgroundCallback<T> {
        void loadTile(int i, int i2);

        void recycleTile(TileList.Tile<T> tile);

        void refresh(int i);

        void updateRange(int i, int i2, int i3, int i4, int i5);
    }

    public interface MainThreadCallback<T> {
        void addTile(int i, TileList.Tile<T> tile);

        void removeTile(int i, int i2);

        void updateItemCount(int i, int i2);
    }

    /* renamed from: a */
    BackgroundCallback<T> mo7603a(BackgroundCallback<T> backgroundCallback);

    /* renamed from: b */
    MainThreadCallback<T> mo7604b(MainThreadCallback<T> mainThreadCallback);
}
