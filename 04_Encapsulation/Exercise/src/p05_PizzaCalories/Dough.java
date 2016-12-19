package p05_PizzaCalories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private Double weight;
    private Double calories;

    public Dough(String flour, String technique, Double weight) {
        this.setFlourType(flour);
        this.setBakingTechnique(technique);
        this.setWeight(weight);
        this.setCalories(this.flourType, this.bakingTechnique, this.weight);
    }

    public Double getCalories() {
        return this.calories;
    }

    private void setFlourType(String flour) {
        if (!flour.equalsIgnoreCase("white") && !flour.equalsIgnoreCase("wholegrain")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        } else {
            this.flourType = flour;
        }
    }
    private void setBakingTechnique(String technique) {
        if (!technique.equalsIgnoreCase("crispy") && !technique.equalsIgnoreCase("chewy") && !technique.equalsIgnoreCase("homemade")) {
            throw new IllegalArgumentException("Invalid type of baking technique.");
        } else {
            this.bakingTechnique = technique;
        }
    }
    private void setWeight(Double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        } else {
            this.weight = weight;
        }
    }
    private void setCalories(String flour, String technique, Double weight) {
        Double doughModifier = 0d;
        Double techniqueModifier = 0d;
        switch (flour.toLowerCase()){
            case "white": doughModifier = 1.5d; break;
            case "wholegrain": doughModifier = 1.0d; break;
        }
        switch (technique.toLowerCase()){
            case "crispy": techniqueModifier = 0.9d; break;
            case "chewy": techniqueModifier = 1.1d; break;
            case "homemade": techniqueModifier = 1.0d; break;
        }
        Double calories = (weight* 2)* doughModifier* techniqueModifier;
        this.calories = calories;
    }
}
