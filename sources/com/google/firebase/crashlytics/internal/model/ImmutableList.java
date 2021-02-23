package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class ImmutableList<E> implements List<E>, RandomAccess {

    /* renamed from: a */
    private final List<E> f19259a;

    private ImmutableList(List<E> list) {
        this.f19259a = Collections.unmodifiableList(list);
    }

    @NonNull
    public static <E> ImmutableList<E> from(E... eArr) {
        return new ImmutableList<>(Arrays.asList(eArr));
    }

    public boolean add(@NonNull E e) {
        return this.f19259a.add(e);
    }

    public boolean addAll(@NonNull Collection<? extends E> collection) {
        return this.f19259a.addAll(collection);
    }

    public void clear() {
        this.f19259a.clear();
    }

    public boolean contains(@Nullable Object obj) {
        return this.f19259a.contains(obj);
    }

    public boolean containsAll(@NonNull Collection<?> collection) {
        return this.f19259a.containsAll(collection);
    }

    public boolean equals(@Nullable Object obj) {
        return this.f19259a.equals(obj);
    }

    @NonNull
    public E get(int i) {
        return this.f19259a.get(i);
    }

    public int hashCode() {
        return this.f19259a.hashCode();
    }

    public int indexOf(@Nullable Object obj) {
        return this.f19259a.indexOf(obj);
    }

    public boolean isEmpty() {
        return this.f19259a.isEmpty();
    }

    @NonNull
    public Iterator<E> iterator() {
        return this.f19259a.iterator();
    }

    public int lastIndexOf(@Nullable Object obj) {
        return this.f19259a.lastIndexOf(obj);
    }

    @NonNull
    public ListIterator<E> listIterator() {
        return this.f19259a.listIterator();
    }

    public boolean remove(@Nullable Object obj) {
        return this.f19259a.remove(obj);
    }

    public boolean removeAll(@NonNull Collection<?> collection) {
        return this.f19259a.removeAll(collection);
    }

    public boolean retainAll(@NonNull Collection<?> collection) {
        return this.f19259a.retainAll(collection);
    }

    @NonNull
    public E set(int i, @NonNull E e) {
        return this.f19259a.set(i, e);
    }

    public int size() {
        return this.f19259a.size();
    }

    @NonNull
    public List<E> subList(int i, int i2) {
        return this.f19259a.subList(i, i2);
    }

    @Nullable
    public Object[] toArray() {
        return this.f19259a.toArray();
    }

    @NonNull
    public static <E> ImmutableList<E> from(@NonNull List<E> list) {
        return new ImmutableList<>(list);
    }

    public void add(int i, @NonNull E e) {
        this.f19259a.add(i, e);
    }

    public boolean addAll(int i, @NonNull Collection<? extends E> collection) {
        return this.f19259a.addAll(i, collection);
    }

    @NonNull
    public ListIterator<E> listIterator(int i) {
        return this.f19259a.listIterator(i);
    }

    public E remove(int i) {
        return this.f19259a.remove(i);
    }

    public <T> T[] toArray(@Nullable T[] tArr) {
        return this.f19259a.toArray(tArr);
    }
}
