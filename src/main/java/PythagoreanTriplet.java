/*

Since this exercise has a difficulty of > 4 it doesn't come
with any starter implementation.
This is so that you get to practice creating classes and methods
which is an important part of programming in Java.

Please remove this comment when submitting your solution.

*/

import java.util.ArrayList;
import java.util.List;

class PythagoreanTriplet {

    private final int a;
    private final int b;
    private final int c;

    PythagoreanTriplet(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PythagoreanTriplet)) return false;
        PythagoreanTriplet other = (PythagoreanTriplet) o;
        return a == other.a &&
                b == other.b &&
                c == other.c;
    }

    static PythagoreanTripletBuilder makeTripletsList() {
        return new PythagoreanTripletBuilder();
    }

    static class PythagoreanTripletBuilder {

        private int limit;
        private int sumTo;

        PythagoreanTripletBuilder withFactorsLessThanOrEqualTo(int value) {
            limit = value;
            return this;
        }

        PythagoreanTripletBuilder thatSumTo(int value) {
            sumTo = value;
            return this;
        }

        List<PythagoreanTriplet> build() {
            List<PythagoreanTriplet> triplets = new ArrayList<>();
            for (int a = 1; a <= limit; a++)
                for (int b = a + 1; b <= limit; b++) {
                    int c = sumTo - (a + b);
                    if (c > b){
                        if (a * a + b * b == c * c){
                            triplets.add(new PythagoreanTriplet(a, b, c));
                        }
                    }
                }
            return triplets;
        }
    }
}
