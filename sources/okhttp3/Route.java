package okhttp3;

import java.net.InetSocketAddress;
import java.net.Proxy;
import javax.annotation.Nullable;

public final class Route {

    /* renamed from: a */
    final Address f20004a;

    /* renamed from: b */
    final Proxy f20005b;

    /* renamed from: c */
    final InetSocketAddress f20006c;

    public Route(Address address, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (address == null) {
            throw new NullPointerException("address == null");
        } else if (proxy == null) {
            throw new NullPointerException("proxy == null");
        } else if (inetSocketAddress != null) {
            this.f20004a = address;
            this.f20005b = proxy;
            this.f20006c = inetSocketAddress;
        } else {
            throw new NullPointerException("inetSocketAddress == null");
        }
    }

    public Address address() {
        return this.f20004a;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Route) {
            Route route = (Route) obj;
            return route.f20004a.equals(this.f20004a) && route.f20005b.equals(this.f20005b) && route.f20006c.equals(this.f20006c);
        }
    }

    public int hashCode() {
        return ((((527 + this.f20004a.hashCode()) * 31) + this.f20005b.hashCode()) * 31) + this.f20006c.hashCode();
    }

    public Proxy proxy() {
        return this.f20005b;
    }

    public boolean requiresTunnel() {
        return this.f20004a.f19728i != null && this.f20005b.type() == Proxy.Type.HTTP;
    }

    public InetSocketAddress socketAddress() {
        return this.f20006c;
    }

    public String toString() {
        return "Route{" + this.f20006c + "}";
    }
}
