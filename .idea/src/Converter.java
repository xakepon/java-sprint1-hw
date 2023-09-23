public class Converter {
    int convertToKm(int steps) {
        return Math.toIntExact(Math.round(steps * 0.075));

    }
    int convertStepsToKilocalories(int steps){
        return Math.toIntExact(Math.round(steps * 0.05));
    }
}
