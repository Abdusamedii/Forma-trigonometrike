import javax.swing.*;
import java.text.DecimalFormat;

public class MathHelp {
    DecimalFormat d = new DecimalFormat("0.00");
    double tol = 0.000001;


    // Klasat


    public static class ComplexNumber {
        public double real;
        public double img;
        public ComplexNumber(double real, double img) {
            this.real = real;
            this.img = img;
        }
    }






    // Mbarimi i klasave




    /*
    * Metodë për të gjetur faktorialin e një numri.
    * Numri duhet të jetë pozitiv në mënyrë që t'mos shfaqet error.
    * @returns një numër int.
    * */


    public int faktorial(int a) {
        if (a < 0) {

            JOptionPane.showMessageDialog(null, "Numri a duhet te jete me i madh se zero", "Gabim ne te dhena", JOptionPane.ERROR_MESSAGE);

            return -1;
        }
        else if (a == 1 || a == 0) {
            return 1;
        }
        else {
            return a * faktorial(a-1);
        }
    }

    /*
    * Gjen shumën e numrave kompleksë.
    * Numri i numrave kompleksë nuk është i limituar sepse metoda e merr sasinë e tyre në mënyrë dinamike.
    * Numri kompleks ka dy parametra, pjesën reale, dhe pjesën imagjinare.
    * */


    public ComplexNumber shuma(ComplexNumber ... c1) {

        ComplexNumber c = new ComplexNumber(0, 0);
        for (ComplexNumber value: c1) {
            c.real = c.real + value.real;
            c.img = c.img + value.img;
        }
        c.real = Double.parseDouble(d.format(c.real));
        c.img = Double.parseDouble(d.format(c.img));
        return c;
    }

    /*
    * Për të shumëzuar dy apo më shumë numra kompleksë.
    * Numri i parametrave s'është i kufizuar, jepet në mënyrë dinamike metodës.
    * */


    public ComplexNumber prodhimi(ComplexNumber ... c1) {
        ComplexNumber c = new ComplexNumber(1, 0);
        double re = 0;
        double im = 0;
        for (ComplexNumber value: c1) {
            re = c.real * value.real - c.img * value.img;
            im = c.real * value.img + c.img * value.real;
            c.real = re;
            c.img = im;
        }

        c.real = Double.parseDouble(d.format(c.real));
        c.img = Double.parseDouble(d.format(c.img));
        return c;
    }



    /*
     * Për të pjesëtuar dy numra kompleksë me njëri-tjetrin.
     * */

    public ComplexNumber pjesetimi(ComplexNumber c1, ComplexNumber c2) {
        ComplexNumber c = new ComplexNumber(0, 0);
        c.real = (c1.real * c2.real + c1.img * c2.img)/(c2.real * c2.real + c2.img * c2.img);
        c.img = (c1.img * c2.real - c1.real * c2.img)/(c2.real * c2.real + c2.img * c2.img);
        c.real = Double.parseDouble(d.format(c.real));
        c.img = Double.parseDouble(d.format(c.img));

        return c;
    }


    /*
    * Shkruan formën algjebrike të një numri kompleks.
    * Teston nëse pjesa reale apo imagjinare janë 0, 1 ose -1 që të duket pastër në printim.
    * Merren vetëm dy vlera pas presjes dhjetore.
    * @param: ComplexNumber.
    * @return: String.
    * */


    public String formaAlgjebrike (ComplexNumber c) {
        // z = a + bi
        c.real = Double.parseDouble(d.format(c.real));
        c.img = Double.parseDouble(d.format(c.img));


        if (c.img == 0) {
            return ""+c.real;
        } else if (c.img == 1) {
            if (c.real == 0) {
                return "i";
            }
            return c.real + " + i";
        } else if (c.img == -1) {
            if (c.real == 0) {
                return "-i";
            }
            return c.real + " - i";
        } else if (c.img < 0) {
            if (c.real == 0) {
                return "-i" + Math.abs(c.img);
            }
            return c.real + " - i" + Math.abs(c.img);
        }
        return c.real + " + i" + c.img;
    }

    /*
    * Shkruan formën trigonometrike të një numri kompleks.
    * Rastet e veçanta janë shqyrtuar për një formë kompakte.
    * @param: ComplexNumber.
    * @return: String.
    * z = r(cosx + isinx).
    * */

    int num;
    public String formaTrigonometrike(ComplexNumber c) {
        double r = c.real * c.real + c.img * c.img;
        double theta = Math.atan(c.img / c.real);
        r = Double.parseDouble(d.format(r));
        num = kuadranti(c);


        if (r == 0) {
            return "0";
        }else if (r == 1) {
            return "(cos(" + nePiRadian(theta) + ") + isin(" + nePiRadian(theta) + "))";
        }else if (r == -1) {
            return "-(cos(" + nePiRadian(theta) + ") + isin(" + nePiRadian(theta) + "))";
        }

        return rrenjaR(r) + "(cos(" + nePiRadian(theta) + ") + isin(" + nePiRadian(theta) + "))";
    }

    /*
    * Shkruan numrin kompleks në formë trigonometrike, por që është i ngritur në fuqi.
    * Çdo gjë tjetër është njejtë si metoda e saj motër.
    *
    *
    * */



    public String formaTrigonometrike(ComplexNumber c, int power) {
        // z = r(cosx + isinx)
        double r = c.real * c.real + c.img * c.img;
        double theta = Math.atan(c.img / c.real);
        r = Double.parseDouble(d.format(r));
        num = kuadranti(c);


        if (r == 0) {
            return "0";
        }else if (r == 1) {
            return "(cos(" + nePiRadian(theta, power) + ") + isin(" + nePiRadian(theta, power) + "))";
        }else if (r == -1) {
            return "-(cos(" + nePiRadian(theta, power) + ") + isin(" + nePiRadian(theta, power) + "))";
        }

        return rrenjaR(r, power) + "(cos(" + nePiRadian(theta, power) + ") + isin(" + nePiRadian(theta, power) + "))";
    }



    /*
    * Gjen kuadrantin ku ndodhet këndi fi.
    * @param: ComplexNumber
    * @return: int, indeksin e kuadrantit.
    * */

    public int kuadranti (ComplexNumber c) {
        double r = c.real;
        double i = c.img;

        if (r>0 && i>0) {
            return 1;
        }else if (r<0 && i>0) {
            return 2;
        }else if (r<0 && i<0) {
            return 3;
        }else if (r>0 && i<0) {
            return 4;
        }else {
            return 0;
        }
    }









    //Mos u merr me keto metoda.
    private String nePiRadian (double r) {
        double x = (Math.PI / r);
        String numeruesi = "";
        String emeruesi = "";
        double xTol = Math.abs(Math.abs(x) - Math.round(Math.abs(x)));
        double yTol23 = Math.abs(Math.abs(x+1) - Math.round(Math.abs(x+1)));
        double yTol4 = Math.abs(Math.abs(2*x+1) - Math.round(Math.abs(2*x+1)));
        switch (num) {
            case 1 -> {
                if (xTol < tol) {
                    numeruesi = "";
                    emeruesi = "" + Math.round(x);
                }
                else {
                    numeruesi = "";
                    emeruesi = "" + x;
                }
            }
            case 2, 3 -> {
                if (yTol23 < tol && xTol < tol) {
                    numeruesi = "" + Math.round(Math.abs(x + 1));
                    emeruesi = "" + Math.round(Math.abs(x));
                }else{
                    numeruesi = "" + Math.abs(x + 1);
                    emeruesi = "" + Math.abs(x);
                }
            }
            case 4 -> {
                if (yTol4 < tol && xTol < tol) {
                    numeruesi = "" + Math.round(Math.abs(2 * x + 1));
                    emeruesi = "" + Math.round(Math.abs(x));
                }
                else {
                    numeruesi = "" + Math.abs(2 * x + 1);
                    emeruesi = "" + Math.abs(x);
                }
            }
        }


        return numeruesi + "π/" + emeruesi;
    }
    private String nePiRadian (double r, int power) {
        /*
        * Ka nevoje rregullu keta mire dhe me e optimizu kodin qe tashti vec e kom fshi.
        * */



        return null;
    }

    private static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }


    private String rrenjaR(double r) {
        if (r == (int)r) {
            double sqrt = Math.sqrt(r);
            if (sqrt == (int)sqrt){
                return "" + (int)sqrt;
            }
            return "√" + (int)r;
        }
        return "√" + r;
    }

    private String rrenjaR(double r, int power) {
        if (r == (int)r) {
            double sqrt = Math.sqrt(r);
            if (sqrt == (int)sqrt){
                return (int)sqrt + "^(" + power + ")";
            }
            return "√" + (int)r + "^(" + power + ")";
        }
        return "√" + r + "^(" + power + ")";
    }

    // Deri ketu.


    public static void main(String[] args) {
        MathHelp m = new MathHelp();
    }
}
