public class NjeProv {

    public NjeProv() {
        Matrica m = new Matrica(4, 4);
        m.lexoElementet();
        m.printoMatricen();
        m.Sarusit(m);
    }

    public static void main(String[] args) {
        new NjeProv();
    }

}
