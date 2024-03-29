package com.michalurban;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static org.apache.commons.lang3.text.WordUtils.*;

@SuppressWarnings("all")
public class Character {

    private String name;
    private String race;
    private String gender;
    private String role;
    private String alignment;

    private Map<String, Integer> stats;

    public Character() {}

    void setupCharacter(Map<String, String[]> characterData) throws UnsupportedEncodingException {

        this.name = createName(characterData.get("name")[0]);
        this.race = createRace(characterData.get("race")[0]);
        this.gender = characterData.get("gender")[0];
        this.role = createRole(characterData.get("role")[0]);
        this.alignment = createAlignment(characterData.get("alignment1")[0],
                                         characterData.get("alignment2")[0]);
        this.stats = createStats(characterData.get("stats1")[0],
                                 characterData.get("stats2")[0],
                                 characterData.get("stats3")[0]);
    }

    private String createName(String name) throws UnsupportedEncodingException {

        int length = name.length();
        int firstIndex = (new Random()).nextInt(length - 1) + 1;
        int secondIndex = (new Random()).nextInt(length - 1) + 1;

        StringBuilder epicName = new StringBuilder(URLDecoder.decode(name, "UTF-8"));
        epicName.insert(firstIndex, "h").insert(secondIndex, "h").append("ex");

        return epicName.toString();
    }

    private String createRace(String race) {

        switch (race) {
            case "ugly":
                return "Dwarf";
            case "pretty":
                return "Elf";
            default:
                return "Human";
        }
    }

    private String createRole(String role) {

        switch (role) {
            case "melee":
                return "Warrior";
            case "ranged":
                return "Archer";
            case "spec":
                return "Mage";
            default:
                return "Priest";
        }
    }

    private String createAlignment(String alignment1, String alignment2) {

        if (alignment1.equals(alignment2)) {
            return "Truly Neutral";
        } else {
            return capitalize(alignment2) + " " + capitalize(alignment1);
        }
    }

    private Map<String, Integer> createStats(String stats1, String stats2, String stats3) {

        Map<String, Integer> stats = new HashMap<>();

        stats.put("strength", 24 - Integer.parseInt(stats1));
        stats.put("dexterity", 24 - Integer.parseInt(stats3));
        stats.put("stamina", Integer.parseInt(stats3) + 2);
        stats.put("intelligence", Integer.parseInt(stats2) + 2);
        stats.put("wisdom", 24 - Integer.parseInt(stats2));
        stats.put("charisma", Integer.parseInt(stats1) + 2);

        return stats;
    }

    String getName() {

        return name;
    }

    String getRace() {

        return race;
    }

    String getRole() {

        return role;
    }

    String getAlignment() {

        return alignment;
    }

    Map<String, Integer> getStats() {

        return stats;
    }

    String getGender() {

        return gender;
    }
}
