package com.pokeCalc.chi_yu.Entities;
import com.pokeCalc.chi_yu.Entities.Enums.Type;
import java.util.EnumMap;
import java.util.Map;
import static com.pokeCalc.chi_yu.Entities.Enums.Type.*;


public class TypeWeaknessChart {

    private static final double SUPER_EFFECTIVE = 2.0;
    private static final double NOT_VERY_EFFECTIVE = 0.5;
    private static final double IMMUNE = 0.0;


    private static final Map<Type, Map<Type, Double>> chart = new EnumMap<>(Type.class);

    static {

        for(Type type : Type.values()){
            chart.put(type, new EnumMap<>(Type.class));
        }

        //NORMAL
        set(NORMAL, IMMUNE, GHOST);
        set(NORMAL, NOT_VERY_EFFECTIVE, ROCK, STEEL);

        //FIRE
        set(FIRE, SUPER_EFFECTIVE, GRASS, ICE, BUG, STEEL);
        set(FIRE, NOT_VERY_EFFECTIVE, FIRE, WATER, ROCK, DRAGON);

        //WATER
        set(WATER, SUPER_EFFECTIVE, FIRE, GROUND, ROCK);
        set(WATER, NOT_VERY_EFFECTIVE, WATER, GRASS, DRAGON);

        //ELETRIC
        set(ELETRIC, IMMUNE, GROUND);
        set(ELETRIC, SUPER_EFFECTIVE, WATER, FLYING);
        set(ELETRIC, NOT_VERY_EFFECTIVE, ELETRIC, GRASS, DRAGON);

        //GRASS
        set(GRASS, SUPER_EFFECTIVE, WATER, GROUND, ROCK);
        set(GRASS, NOT_VERY_EFFECTIVE, FIRE, GRASS, POISON, FLYING, BUG, DRAGON, STEEL);

        //ICE
        set(ICE, SUPER_EFFECTIVE, GRASS, GROUND, FLYING, DRAGON);
        set(ICE, NOT_VERY_EFFECTIVE, FIRE, WATER, ICE, STEEL);

        //FIGHTING
        set(FIGHTING, IMMUNE, GHOST);
        set(FIGHTING, SUPER_EFFECTIVE, NORMAL, ICE, ROCK, DARK, STEEL);
        set(FIGHTING, NOT_VERY_EFFECTIVE, POISON, FLYING, PSYCHIC, BUG, FAIRY);

        //POISON
        set(POISON, IMMUNE, STEEL);
        set(POISON, SUPER_EFFECTIVE, GRASS, FAIRY);
        set(POISON, NOT_VERY_EFFECTIVE, POISON, GROUND, ROCK, GHOST);

        //GROUND
        set(GROUND, IMMUNE, FLYING);
        set(GROUND, SUPER_EFFECTIVE, FIRE, ELETRIC, POISON, ROCK, STEEL);
        set(GROUND, NOT_VERY_EFFECTIVE, GRASS, BUG);

        //FLYING
        set(FLYING, SUPER_EFFECTIVE, GRASS, FIGHTING, BUG);
        set(FLYING, NOT_VERY_EFFECTIVE, ELETRIC, ROCK, STEEL);

        //PSYCHIC
        set(PSYCHIC, IMMUNE, DARK);
        set(PSYCHIC, SUPER_EFFECTIVE, FIGHTING, POISON);
        set(PSYCHIC, NOT_VERY_EFFECTIVE, PSYCHIC, STEEL);

        //BUG
        set(BUG, SUPER_EFFECTIVE, GRASS, PSYCHIC, DARK);
        set(BUG, NOT_VERY_EFFECTIVE, FIRE, FIGHTING, POISON, FLYING, GHOST, STEEL, FAIRY);

        //ROCK
        set(ROCK, SUPER_EFFECTIVE, FIRE, ICE, FLYING, BUG);
        set(ROCK, NOT_VERY_EFFECTIVE, FIGHTING, GROUND, STEEL);

        //GHOST
        set(GHOST, IMMUNE, NORMAL);
        set(GHOST, SUPER_EFFECTIVE, PSYCHIC, GHOST);
        set(GHOST, NOT_VERY_EFFECTIVE, DARK);

        //DRAGON
        set(DRAGON, IMMUNE, FAIRY);
        set(DRAGON, SUPER_EFFECTIVE, DRAGON);
        set(DRAGON , NOT_VERY_EFFECTIVE, STEEL);

        //DARK
        set(DARK, SUPER_EFFECTIVE, PSYCHIC, GHOST);
        set(DARK, NOT_VERY_EFFECTIVE, FIGHTING, DARK, FAIRY);

        //STEEL
        set(STEEL, SUPER_EFFECTIVE, FAIRY, ROCK, ICE);
        set(STEEL, NOT_VERY_EFFECTIVE, FIRE, WATER, ELETRIC, STEEL);

        //FAIRY
        set(FAIRY, SUPER_EFFECTIVE, FIGHTING, DRAGON, DARK);
        set(FAIRY, NOT_VERY_EFFECTIVE, FIRE, POISON, STEEL);
    }

    private static void set(Type attacker, double multiplier, Type... defenders){
        for(Type defender : defenders){
            chart.get(attacker).put(defender,multiplier);
        }
    }

    private static double getMultiplier(Type attackType, Type defenderType){
        if(attackType == null || defenderType == null){
            return 1.0;
        }

        return chart.get(attackType).getOrDefault(defenderType, 1.0);
    }
}
