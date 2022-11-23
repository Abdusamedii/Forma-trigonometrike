public class Punim extends MathHelp {
    MathHelp m = new MathHelp();

    public Punim() {
        double real = 3*Math.sqrt(3)/2.0;
        double img = 3/2.0;
        ComplexNumber c = new ComplexNumber(real, img);
        System.out.println(m.formaTrigonometrike(c));

    }


    public static void main(String[] args) {
        new Punim();
    }
}
