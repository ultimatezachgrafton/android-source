package io.bloc.android.blocly.api.model;

/**
 * Created by Zach on 6/18/2015.
 */
public abstract class Model {

    private final long rowId;

    public Model(long rowId) {
        this.rowId = rowId;
    }

    public long getRowId() {
        return rowId;
    }
}