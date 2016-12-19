package p08_PokemonTrainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Trainer {
    String name;
    int badges;
    List<Pokemon> pokemons;

    Trainer(String name) {
        this.name = name;
        this.badges = 0;
        this.pokemons = new ArrayList<>();
    }
}

class Pokemon {
    String name;
    String element;
    int health;

    Pokemon(String name, String element, int health) {
        this.name = name;
        this.element = element;
        this.health = health;
    }
}

public class p08_PokemonTrainer {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Trainer> trainersMap = new LinkedHashMap<>();
        String input;
        String[] tokens;

        while (true) {
            input = reader.readLine();
            if (input.equals("Tournament")) {
                break;
            } else {
                tokens = input.split("[\\s]+");
                String name = tokens[0];
                String pokemonName = tokens[1];
                String pokemonElement = tokens[2];
                int pokemonHealth = Integer.parseInt(tokens[3]);
                Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
                if (!trainersMap.containsKey(name)) {
                    Trainer trainer = new Trainer(name);
                    trainersMap.put(name, trainer);
                    trainer.pokemons.add(pokemon);
                } else {
                    trainersMap.get(name).pokemons.add(pokemon);
                }
            }
        }

        while (true) {
            input = reader.readLine();
            if (input.equals("End")) {
                break;
            } else {
                List<Pokemon> currPokemonEls = new ArrayList<>();
                for (Map.Entry<String, Trainer> trainer : trainersMap.entrySet()) {
                    boolean isFind = false;
                    currPokemonEls = trainer.getValue().pokemons;
                    for (Pokemon pokemon : currPokemonEls) {
                        if (pokemon.element.equals(input)) {
                            trainer.getValue().badges += 1;
                            isFind = true;
                            break;
                        }
                    }
                    if (!isFind) {
                        trainer.getValue().pokemons.stream().forEach(pokemon1 -> pokemon1.health -= 10);
                    }
                    trainer.getValue().pokemons.removeIf(pokemon -> pokemon.health <= 0);
                }
            }
        }

        trainersMap.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue().badges, e1.getValue().badges))
                .forEach(entry -> System.out.println(entry.getKey() + " " +
                        entry.getValue().badges + " " +
                        entry.getValue().pokemons.size()));
    }
}
