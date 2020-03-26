package sample;

import org.junit.Test;
import sample.model.ModelA;
import sample.model.ModelB;
import sample.service.AService;
import sample.service.BService;

public class SampleTest {
    private AService aService = new AService();
    private BService bService = new BService();

    @Test
    public void testA() {
        ModelA modelA = new ModelA();
        modelA.setaId(1);
        aService.deal(modelA);
    }

    @Test
    public void testB() {
        ModelB modelB = new ModelB();
        modelB.setbId(2);
        bService.deal(modelB);
    }
}
