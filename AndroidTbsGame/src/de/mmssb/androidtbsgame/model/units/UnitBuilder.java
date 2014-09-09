// CHECKSTYLE:OFF
/**
 * Source code generated by Fluent Builders Generator
 * Do not modify this file
 * See generator home page at: http://code.google.com/p/fluent-builders-generator-eclipse-plugin/
 */

package de.mmssb.androidtbsgame.model.units;

import de.mmssb.androidtbsgame.model.armamentBehaviours.ArmamentBehaviour;
import de.mmssb.androidtbsgame.model.players.Player;
import de.mmssb.androidtbsgame.model.units.actionpointbehaviours.ActionPointBehaviour;
import de.mmssb.androidtbsgame.model.units.costbehaviours.CostBehaviour;
import de.mmssb.androidtbsgame.model.units.healthbehaviours.HealthBehaviour;
import de.mmssb.androidtbsgame.model.units.movementbehaviours.MovementBehaviour;
import de.mmssb.androidtbsgame.model.units.sightbehaviours.SightBehaviour;
import de.mmssb.androidtbsgame.model.units.weaponbehaviours.WeaponBehaviour;

public class UnitBuilder extends UnitBuilderBase<UnitBuilder> {
    public static UnitBuilder unit() {
        return new UnitBuilder();
    }

    public UnitBuilder() {
        super(new Unit());
    }

    public Unit build() {
        return getInstance();
    }
}

class UnitBuilderBase<GeneratorT extends UnitBuilderBase<GeneratorT>> {
    private Unit instance;

    protected UnitBuilderBase(Unit aInstance) {
        instance = aInstance;
    }

    protected Unit getInstance() {
        return instance;
    }

    @SuppressWarnings("unchecked")
    public GeneratorT withOwner(Player aValue) {
        instance.setOwner(aValue);

        return (GeneratorT) this;
    }

    @SuppressWarnings("unchecked")
    public GeneratorT withHealthBehaviour(HealthBehaviour aValue) {
        instance.setHealthBehaviour(aValue);

        return (GeneratorT) this;
    }

    @SuppressWarnings("unchecked")
    public GeneratorT withActionPointBehavior(ActionPointBehaviour aValue) {
        instance.setActionPointBehavior(aValue);

        return (GeneratorT) this;
    }

    @SuppressWarnings("unchecked")
    public GeneratorT withMovementBehaviour(MovementBehaviour aValue) {
        instance.setMovementBehaviour(aValue);

        return (GeneratorT) this;
    }

    @SuppressWarnings("unchecked")
    public GeneratorT withWeaponBehaviour(WeaponBehaviour aValue) {
        instance.setWeaponBehaviour(aValue);

        return (GeneratorT) this;
    }

    @SuppressWarnings("unchecked")
    public GeneratorT withSightBehaviour(SightBehaviour aValue) {
        instance.setSightBehaviour(aValue);

        return (GeneratorT) this;
    }

    @SuppressWarnings("unchecked")
    public GeneratorT withArmamentBehaviour(ArmamentBehaviour aValue) {
        instance.setArmamentBehaviour(aValue);

        return (GeneratorT) this;
    }

    @SuppressWarnings("unchecked")
    public GeneratorT withCostBehaviour(CostBehaviour aValue) {
        instance.setCostBehaviour(aValue);

        return (GeneratorT) this;
    }
}