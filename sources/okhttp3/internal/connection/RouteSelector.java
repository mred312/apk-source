package okhttp3.internal.connection;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.Route;
import okhttp3.internal.Util;

public final class RouteSelector {

    /* renamed from: a */
    private final Address f21117a;

    /* renamed from: b */
    private final RouteDatabase f21118b;

    /* renamed from: c */
    private final Call f21119c;

    /* renamed from: d */
    private final EventListener f21120d;

    /* renamed from: e */
    private List<Proxy> f21121e = Collections.emptyList();

    /* renamed from: f */
    private int f21122f;

    /* renamed from: g */
    private List<InetSocketAddress> f21123g = Collections.emptyList();

    /* renamed from: h */
    private final List<Route> f21124h = new ArrayList();

    public static final class Selection {

        /* renamed from: a */
        private final List<Route> f21125a;

        /* renamed from: b */
        private int f21126b = 0;

        Selection(List<Route> list) {
            this.f21125a = list;
        }

        public List<Route> getAll() {
            return new ArrayList(this.f21125a);
        }

        public boolean hasNext() {
            return this.f21126b < this.f21125a.size();
        }

        public Route next() {
            if (hasNext()) {
                List<Route> list = this.f21125a;
                int i = this.f21126b;
                this.f21126b = i + 1;
                return list.get(i);
            }
            throw new NoSuchElementException();
        }
    }

    public RouteSelector(Address address, RouteDatabase routeDatabase, Call call, EventListener eventListener) {
        this.f21117a = address;
        this.f21118b = routeDatabase;
        this.f21119c = call;
        this.f21120d = eventListener;
        m14236e(address.url(), address.proxy());
    }

    /* renamed from: a */
    static String m14232a(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        if (address == null) {
            return inetSocketAddress.getHostName();
        }
        return address.getHostAddress();
    }

    /* renamed from: b */
    private boolean m14233b() {
        return this.f21122f < this.f21121e.size();
    }

    /* renamed from: c */
    private Proxy m14234c() {
        if (m14233b()) {
            List<Proxy> list = this.f21121e;
            int i = this.f21122f;
            this.f21122f = i + 1;
            Proxy proxy = list.get(i);
            m14235d(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.f21117a.url().host() + "; exhausted proxy configurations: " + this.f21121e);
    }

    /* renamed from: d */
    private void m14235d(Proxy proxy) {
        String str;
        int i;
        this.f21123g = new ArrayList();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            str = this.f21117a.url().host();
            i = this.f21117a.url().port();
        } else {
            SocketAddress address = proxy.address();
            if (address instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                str = m14232a(inetSocketAddress);
                i = inetSocketAddress.getPort();
            } else {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + address.getClass());
            }
        }
        if (i < 1 || i > 65535) {
            throw new SocketException("No route to " + str + ":" + i + "; port is out of range");
        } else if (proxy.type() == Proxy.Type.SOCKS) {
            this.f21123g.add(InetSocketAddress.createUnresolved(str, i));
        } else {
            this.f21120d.dnsStart(this.f21119c, str);
            List<InetAddress> lookup = this.f21117a.dns().lookup(str);
            if (!lookup.isEmpty()) {
                this.f21120d.dnsEnd(this.f21119c, str, lookup);
                int size = lookup.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.f21123g.add(new InetSocketAddress(lookup.get(i2), i));
                }
                return;
            }
            throw new UnknownHostException(this.f21117a.dns() + " returned no addresses for " + str);
        }
    }

    /* renamed from: e */
    private void m14236e(HttpUrl httpUrl, Proxy proxy) {
        List<Proxy> list;
        if (proxy != null) {
            this.f21121e = Collections.singletonList(proxy);
        } else {
            List<Proxy> select = this.f21117a.proxySelector().select(httpUrl.uri());
            if (select == null || select.isEmpty()) {
                list = Util.immutableList((T[]) new Proxy[]{Proxy.NO_PROXY});
            } else {
                list = Util.immutableList(select);
            }
            this.f21121e = list;
        }
        this.f21122f = 0;
    }

    public void connectFailed(Route route, IOException iOException) {
        if (!(route.proxy().type() == Proxy.Type.DIRECT || this.f21117a.proxySelector() == null)) {
            this.f21117a.proxySelector().connectFailed(this.f21117a.url().uri(), route.proxy().address(), iOException);
        }
        this.f21118b.failed(route);
    }

    public boolean hasNext() {
        return m14233b() || !this.f21124h.isEmpty();
    }

    public Selection next() {
        if (hasNext()) {
            ArrayList arrayList = new ArrayList();
            while (m14233b()) {
                Proxy c = m14234c();
                int size = this.f21123g.size();
                for (int i = 0; i < size; i++) {
                    Route route = new Route(this.f21117a, c, this.f21123g.get(i));
                    if (this.f21118b.shouldPostpone(route)) {
                        this.f21124h.add(route);
                    } else {
                        arrayList.add(route);
                    }
                }
                if (!arrayList.isEmpty()) {
                    break;
                }
            }
            if (arrayList.isEmpty()) {
                arrayList.addAll(this.f21124h);
                this.f21124h.clear();
            }
            return new Selection(arrayList);
        }
        throw new NoSuchElementException();
    }
}
