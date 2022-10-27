package HomophonicCipher;

public interface SimpleHomophonesArrayGenerator {

    /**
     * Generates a new random array.
     *
     * @param numberOfHomophones number of homophones to generate for each letter
     * @return randomly generated array of homophones
     */
    HomophonesArray generate(int numberOfHomophones);

}
