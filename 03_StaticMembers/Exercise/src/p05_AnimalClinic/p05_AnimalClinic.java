package p05_AnimalClinic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Animal {
    private String name;
    private String breed;

    public Animal (String name, String breed) {
        this.name = name;
        this.breed = breed;
    }

    public String getName () {
        return this.name;
    }

    public String getBreed () {
        return this.breed;
    }
}

class AnimalClinic {
    private static Integer patientID;
    private static Integer healedAnimalsCount;
    private static Integer rehabilitatedAnimalsCount;

    private List<Animal> healedAnimals;
    private List<Animal> rehabilitatedAnimals;

    static {
        patientID = 0;
        healedAnimalsCount = 0;
        rehabilitatedAnimalsCount = 0;
    }

    public AnimalClinic () {
        this.healedAnimals = new ArrayList<>();
        this.rehabilitatedAnimals = new ArrayList<>();
    }

    public void addHealedAnimals (Animal animal) {
        healedAnimals.add(animal);
        healedAnimalsCount ++;
        patientID ++;
    }

    public void addRehabilitatedAnimals (Animal animal) {
        rehabilitatedAnimals.add(animal);
        rehabilitatedAnimalsCount ++;
        patientID ++;
    }

    public Integer getPatientID () {
        return patientID;
    }

    public Integer getHealedAnimalsCount () {
        return healedAnimalsCount;
    }

    public Integer getRehabilitatedAnimalsCount () {
        return rehabilitatedAnimalsCount;
    }

    public List<Animal> getHealedAnimals() {
        return healedAnimals;
    }

    public List<Animal> getRehabilitatedAnimals () {
        return rehabilitatedAnimals;
    }
}

public class p05_AnimalClinic {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        AnimalClinic clinic = new AnimalClinic();

        while (true) {
            String[] tokens = reader.readLine().split("[\\s]+");
            if (tokens[0].equals("End")) {
                System.out.printf("Total healed animals: %d\n", clinic.getHealedAnimalsCount());
                System.out.printf("Total rehabilitated animals: %d\n", clinic.getRehabilitatedAnimalsCount());
                break;
            } else {
                String animalName = tokens[0];
                String animalBreed = tokens[1];
                String procedure = tokens[2];

                Animal animal = new Animal(animalName, animalBreed);
                switch (procedure) {
                    case "heal":
                        clinic.addHealedAnimals(animal);
                        System.out.printf("Patient %d: [%s (%s)] has been healed!\n",
                                clinic.getPatientID(), animal.getName(), animal.getBreed());
                        break;
                    case "rehabilitate":
                        clinic.addRehabilitatedAnimals(animal);
                        System.out.printf("Patient %d: [%s (%s)] has been rehabilitated!\n",
                                clinic.getPatientID(), animal.getName(), animal.getBreed());
                        break;
                }
            }
        }

        String command = reader.readLine();
        switch (command) {
            case "heal":
                clinic.getHealedAnimals().stream()
                        .forEach(animal -> System.out.println(animal.getName()
                        + " " + animal.getBreed()));
                break;
            case "rehabilitate":
                clinic.getRehabilitatedAnimals().stream()
                        .forEach(animal -> System.out.println(animal.getName()
                                + " " + animal.getBreed()));
                break;
        }
    }
}
