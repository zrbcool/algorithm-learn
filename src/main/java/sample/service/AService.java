package sample.service;

import sample.model.ModelA;

public class AService extends AbstractService<ModelA> {

    @Override
    protected void subProcess(int id) {
        System.out.println("AService subProcess ->"+id);
    }
}
