package okhttp3.internal.connection;

import java.util.LinkedHashSet;
import java.util.Set;
import okhttp3.Route;

public final class RouteDatabase {

    /* renamed from: a */
    private final Set<Route> f21114a = new LinkedHashSet();

    public synchronized void connected(Route route) {
        this.f21114a.remove(route);
    }

    public synchronized void failed(Route route) {
        this.f21114a.add(route);
    }

    public synchronized boolean shouldPostpone(Route route) {
        return this.f21114a.contains(route);
    }
}
