import java.util.Arrays;

class cd {
    double re;
    double im;

    cd(double r, double i) {
        re = r;
        im = i;
    }

    cd add(cd b) {
        return new cd(re + b.re, im + b.im);
    }

    cd sub(cd b) {
        return new cd(re - b.re, im - b.im);
    }

    cd mul(cd b) {
        return new cd(re * b.re - im * b.im, re * b.im + im * b.re);
    }
}

class FFT {
    int n;
    cd[] a, w;

    FFT(int n) {
        this.n = n;
        a = new cd[n];
        w = new cd[n];
    }

    void fft() {
        // if input contains just one element
        if (n == 1)
            return;

        for (int i = 0; i < n; i++) {
            double alpha = -2 * Math.PI * i / n;
            w[i] = new cd(Math.cos(alpha), Math.sin(alpha));
        }

        cd[] A0 = Arrays.copyOfRange(a, 0, n / 2);
        cd[] A1 = Arrays.copyOfRange(a, n / 2, n);

        // Recursive call for even indexed coefficients
        FFT y0 = new FFT(n / 2);
        y0.a = Arrays.copyOf(A0, n / 2);
        y0.fft();

        // Recursive call for odd indexed coefficients
        FFT y1 = new FFT(n / 2);
        y1.a = Arrays.copyOf(A1, n / 2);
        y1.fft();

        // for storing values of y0, y1, y2, ..., yn-1.
        cd[] y = new cd[n];
        for (int k = 0; k < n / 2; k++) {
            y[k] = y0.a[k].add(w[k].mul(y1.a[k]));
            y[k + n / 2] = y0.a[k].sub(w[k].mul(y1.a[k]));
        }
        System.arraycopy(y, 0, a, 0, n);
    }
}

public class FFT1 {
    public static void main(String[] args) {
        double[] A = {9, -10, 7, 6};
        double[] B = {-5, 4, 0, -2};

        int resultDegree = A.length + B.length - 1;
        int fftSize = 1;
        while (fftSize < resultDegree) {
            fftSize *= 2;
        }

        FFT fftA = new FFT(fftSize);
        FFT fftB = new FFT(fftSize);

        Arrays.fill(fftA.a, new cd(0, 0));
        Arrays.fill(fftB.a, new cd(0, 0));

        System.arraycopy(Arrays.stream(A).mapToObj(x -> new cd(x, 0)).toArray(cd[]::new), 0, fftA.a, 0, A.length);
        System.arraycopy(Arrays.stream(B).mapToObj(x -> new cd(x, 0)).toArray(cd[]::new), 0, fftB.a, 0, B.length);

        fftA.fft();
        fftB.fft();

        cd[] result = new cd[fftSize];
        for (int i = 0; i < fftSize; i++) {
            result[i] = fftA.a[i].mul(fftB.a[i]);
        }

        FFT fftResult = new FFT(fftSize);
        fftResult.a = Arrays.copyOf(result, result.length);
        fftResult.fft();

        double[] finalResult = new double[resultDegree];
        for (int i = 0; i < resultDegree; i++) {
            finalResult[i] = fftResult.a[i].re / fftSize; // Scaling by 1/n
        }

        // Printing the result polynomial coefficients
        System.out.print("Output : ");
        for (int i = finalResult.length - 1; i >= 0; i--) {
            if (finalResult[i] != 0) {
                if (i == 0) {
                    System.out.print(finalResult[i]);
                } else {
                    System.out.print(finalResult[i] + "x^" + i + " + ");
                }
            }
        }
    }
}
