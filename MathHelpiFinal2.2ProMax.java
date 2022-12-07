package Matematikë;

import javax.swing.*;
import java.text.DecimalFormat;

public class MathHelp {
    DecimalFormat d = new DecimalFormat("0.00");

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
            return "z = " + ""+c.real;
        } else if (c.img == 1) {
            if (c.real == 0) {
                return "z = " + "i";
            }
            return "z = " + c.real + " + i";
        } else if (c.img == -1) {
            if (c.real == 0) {
                return "z = " + "-i";
            }
            return "z = " + c.real + " - i";
        } else if (c.img < 0) {
            if (c.real == 0) {
                return "z = " + "-i" + Math.abs(c.img);
            }
            return "z = " + c.real + " - i" + Math.abs(c.img);
        }
        return "z = " + c.real + " + i" + c.img;
    }

    /*
    * Shkruan formën trigonometrike të një numri kompleks.
    * Rastet e veçanta janë shqyrtuar për një formë kompakte.
    * @param: ComplexNumber.
    * @return: String.
    * z = r(cosx + isinx).
    * */

     public String formaTrigonometrike(ComplexNumber c) {
        double r = c.real * c.real + c.img * c.img;
        double theta = Math.atan(c.img / c.real);
        r = Double.parseDouble(d.format(r));

        float thetaDegrees = (float)Math.toDegrees(theta);
        if (thetaDegrees == (int)thetaDegrees) {
            int  thetaInt = (int)thetaDegrees;
            if (r == 0) {
                return "z = " + "0";
            }else if (r == 1) {
                return "z = " + "(cos(" + thetaInt + "°) + isin(" + thetaInt + "°))";
            }else if (r == -1) {
                return "z = " + "-(cos(" + thetaInt + "°) + isin(" + thetaInt + "°))";
            }

            return "z = " + rrenjaR(r) + "(cos(" + thetaInt + "°) + isin(" + thetaInt + "°))";
        }


        if (r == 0) {
            return "z = " + "0";
        }else if (r == 1) {
            return "z = " + "(cos(" + d.format(thetaDegrees) + "°) + isin(" + d.format(thetaDegrees) + "°))";
        }else if (r == -1) {
            return "z = " + "-(cos(" + d.format(thetaDegrees) + "°) + isin(" + d.format(thetaDegrees) + "°))";
        }

        return "z = " + rrenjaR(r) + "(cos(" + d.format(thetaDegrees) + "°) + isin(" + d.format(thetaDegrees) + "°))";
    }



    /*
    * Shkruan numrin kompleks në formë trigonometrike, por që është i ngritur në fuqi.
    * Çdo gjë tjetër është njejtë si metoda e saj motër.
    *
    *
    * */



    public String rrenjezimiNumritKompleks(ComplexNumber c, int power) {
        // z^(1/n) = r^(1/n)(cos(x/2) + isin(x/n))
        if (power == 0) {
            JOptionPane.showMessageDialog(null, "Nuk guxojmë që fuqia të jetë zero");
            return null;
        }
        else if (power < 0){
            JOptionPane.showMessageDialog(null, "Nuk guxojmë që fuqia të jetë negative");
            return null;
        }


        double r = c.real*c.real + c.img * c.img;
        r = Double.parseDouble(d.format(r));
        double theta = Math.atan(c.img / c.real);
        float thetaDegrees = (float)Math.toDegrees(theta);
        if (thetaDegrees == (int)thetaDegrees) {
            int  thetaInt = (int)thetaDegrees;
            if (r == 0) {
                return "w_k = " + "0";
            }else if (r == 1) {
                return "w_k = " + "(cos((" + thetaInt + "° + 2k*π )/" +power+ " ) + isin((" + thetaInt + "° + 2k*π )/" +power+ "))";
            }

            return "w_k = " + rrenjaR(r, power) + "(cos((" + thetaInt + "° + 2k*π)/" +power+ ") + isin((" + thetaInt + "° + 2k*π)/" +power+ "))";
        }


        if (r == 0) {
            return "w_k = " + "0";
        }else if (r == 1) {
            return "w_k = " + "(cos((" + d.format(thetaDegrees) + "° + 2k*π)/" +power+ ") + isin((" + d.format(thetaDegrees) + "° + 2k*π)/" +power+ "))";
        }else if (r == -1) {
            return "w_k = " + "-(cos((" + d.format(thetaDegrees) + "° + 2k*π)/" +power+ ") + isin(" + d.format(thetaDegrees) + "°))";
        }

        return "w_k = " + rrenjaR(r, power) + "(cos((" + d.format(thetaDegrees) + "° + 2k*π)/ " +power+ ") + isin((" + d.format(thetaDegrees) + "° + 2k*π)/" +power+ "))";



    }






    public static long gcd(long a, long b) {

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
            double sqrt = Math.pow(r, 1.0/power);
            System.out.println(sqrt);
            if (sqrt == (int)sqrt){
                return "" + (int)sqrt;
            }
            return (int)r + "^(1/" + power + ")";
        }
        return r + "^(1/" + power + ")";
    }

    // Deri ketu.


}
