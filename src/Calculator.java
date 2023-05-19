public class Calculator {
    public int factorial(int num){
        if(!(num > -1)){
            throw new IllegalArgumentException("Number must be positive");
        }

        int a = 1;
        for(int i = 1; i <= num; i++){
            a *= i;
        }
        return a;
    }

    public int binomialCoefficent(int subsetSize, int setSize) {
        if(!(subsetSize > -1) && subsetSize > setSize){
            throw new IllegalArgumentException("Invalid numbers");
        }

        int num = factorial(setSize);
        int den = factorial(subsetSize) * factorial(setSize - subsetSize);

        return num/den;
    }
}
