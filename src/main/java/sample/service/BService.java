package sample.service;

import sample.model.ModelB;

public class BService extends AbstractService<ModelB> {
    @Override
    protected void subProcess(int id) {
        System.out.println("BService subProcess ->"+id);

    }
}
