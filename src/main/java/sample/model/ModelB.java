package sample.model;

public class ModelB extends Entity{
    private int bId;

    public int getbId() {
        return bId;
    }

    public void setbId(int bId) {
        this.bId = bId;
    }

    @Override
    public int getId() {
        return getbId();
    }

    @Override
    public void setId(int id) {
        setbId(id);
    }
}
