package sample.model;

public class ModelA extends Entity{
    private int aId;

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    @Override
    public int getId() {
        return getaId();
    }

    @Override
    public void setId(int id) {
        setaId(id);
    }
}
