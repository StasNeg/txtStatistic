package com.text.model;

public class AbstractBase {
    public static final int START_SEQ = 100000;

    protected Integer id;

    protected AbstractBase() {
    }

    protected AbstractBase(Integer id) {
        this.id = id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("Entity %s (%s)", getClass().getName(), getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractBase)) return false;

        AbstractBase that = (AbstractBase) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return isNew() ? 0 : getId().hashCode();
    }

    public boolean isNew() {
        return getId() == null;
    }


}
