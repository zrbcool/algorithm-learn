package sample.service;

import sample.model.Entity;

public abstract class AbstractService<T extends Entity> {
    public void deal(T t) {
        System.out.println(this.getClass() + "->AbstractService->" + t.getId());
        subProcess(t.getId());
    }

    protected abstract void subProcess(int id);
}
