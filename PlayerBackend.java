package backend;

public class PlayerBackend extends Entity {

    // Creating a variable called head of type Armor.
    private Armor head;
    // Creating a variable called body that is of type Armor.
    private Armor body;
    // Creating a variable called legs of type Armor.
    private Armor legs;
    // Declaring a variable of type Weapon.
    private Weapon weapon;
    // Creating a variable called shield that is of type Shield.
    private Shield shield;

    // Setting the default values for the player.
    public PlayerBackend() {
        setHp(100);
        setMaxHp(100);
        setDefense(0);
        setDamage("");
        setHead(null);
        setBody(null);
        setLegs(null);
        setWeapon(null);
        setShield(null);
    }

    // Creating a constructor for the PlayerBackend class.
    public PlayerBackend(int h, Armor he, Armor b,
            Armor le, Weapon w, Shield s) {
        setHead(he);
        setBody(b);
        setLegs(le);
        setWeapon(w);
        setShield(s);
    }

    /**
     * This function returns the player backend.
     * 
     * @return The player object.
     */
    public PlayerBackend getPlayer() {
        return this;
    }

    // may be phased out alongside levels

    /*
     * public int getXp() {
     * return xp;
     * }
     * 
     * //^
     * public void setXp(int newxp) {
     * //xp cannot be less than 0
     * if(newxp >= 0) {
     * xp = newxp;
     * //if newxp is less than 0
     * //default to 0
     * } else {
     * xp = 0;
     * }
     * }
     */

    // may be phased out
    // public void levelUp() {
    // setLevel(getLevel() + 1);
    // }

    // may be phased out alongside NPCs
    /*
     * public int getGold() {
     * return gold;
     * }
     */

    // ^
    /*
     * public void setGold(int newgold) {
     * //cannot have debt
     * if(newgold >= 0) {
     * gold = newgold;
     * //if newgold is negative
     * //default to 0
     * } else {
     * gold = 0;
     * }
     * }
     */

    // player funtionality for equipping armor
    /**
     * If the armor's slot is empty, equip it, otherwise unequip the current armor
     * in that slot and
     * equip the new armor
     * 
     * @param armor the armor that the player is trying to equip
     * @param inv   inv.getInventory()
     */
    public void equipArmor(Armor armor, Inventory inv) {
        // cannot equip nothing
        if (armor == null) {
            return;
        }
        // if armor's slot is head
        if (armor.getSlot().equals("Head")) {
            // if head slot is empty
            if (head == null) {
                // updates player head slot
                head = armor;
                // removes armor from inv
                inv.getInventory().remove(armor);
                // updates player defense
                addDefense(armor.getDefense());
                // if head slot is not empty
            } else {
                // unequips current head armor
                unequipArmor(head, inv);
                // updates player head slot
                head = armor;
                // removes armor from inv
                inv.getInventory().remove(armor);
                // updates player defense
                addDefense(armor.getDefense());
            }
            // if armor's slot is body
        } else if (armor.getSlot().equals("Body")) {
            // if the body slot is empty
            if (body == null) {
                // updates player body slot
                body = armor;
                // removes armor from inv
                inv.getInventory().remove(armor);
                // updates player defense
                addDefense(armor.getDefense());
                // if body slot is not empty
            } else {
                // unequips current body armor
                unequipArmor(body, inv);
                // updates player body slot
                body = armor;
                // removes armor from inv
                inv.getInventory().remove(armor);
                // updates player defense
                addDefense(armor.getDefense());
            }
            // if armor's slot is legs
        } else if (armor.getSlot().equals("Legs")) {
            // if the legs slot is empty
            if (legs == null) {
                // updates the player legs slot
                legs = armor;
                // removes armor from inv
                inv.getInventory().remove(armor);
                // updates player defense
                addDefense(armor.getDefense());
                // if legs slot is not empty
            } else {
                // unequips current legs armor
                unequipArmor(legs, inv);
                // updates player legs slot
                legs = armor;
                // removes armor from inv
                inv.getInventory().remove(armor);
                // updates player defense
                addDefense(armor.getDefense());
            }
        }
    }

    // player functionality for unequipping armor
    /**
     * This function unequips an armor piece from the player and adds it to the
     * player's inventory
     * 
     * @param armor the armor to be unequipped
     * @param inv   the inventory of the player
     */
    public void unequipArmor(Armor armor, Inventory inv) {
        // cannot unequip nothing
        if (armor == null || head == null) {
            return;
        }
        // if armor's slot is head
        if (armor.getSlot().equals("Head")) {
            // verifies armor is actually equipped
            if (head.equals(armor)) {
                // updates player head slot
                head = null;
                // adds armor to inv
                inv.getInventory().add(armor);
                // updates player defense
                removeDefense(armor.getDefense());
                // cannot unequp armor that isn't equipped
            } else {
                return;
            }
            // if armor's slot is body
        } else if (armor.getSlot().equals("Body")) {
            // verifies armor is actually equipped
            if (body.equals(armor)) {
                // updates player body slot
                body = null;
                // adds armor to inv
                inv.getInventory().add(armor);
                // updates player defense
                removeDefense(armor.getDefense());
                // cannot unequip armor that isn't equipped
            } else {
                return;
            }
            // if armor's slot is legs
        } else if (armor.getSlot().equals("Legs")) {
            // verifies armor is actually equipped
            if (legs.equals(armor)) {
                // updates player legs slot
                legs = null;
                // adds armor to inv
                inv.getInventory().add(armor);
                // updates player defense
                removeDefense(armor.getDefense());
                // cannot unequip armor that isn't equipped
            } else {
                return;
            }
        }
    }

    // player functionality for equipping weapons
    /**
     * If the player's weapon slot is empty, equip the new weapon. If the player's
     * weapon slot is not
     * empty, unequip the current weapon and equip the new weapon
     * 
     * @param newWeapon the weapon that the player is trying to equip
     * @param inv       the inventory of the player
     */
    public void equipWeapon(Weapon newWeapon, Inventory inv) {
        // cannot equip nothing
        if (newWeapon == null) {
            return;
        }
        // if weapon slot is empty
        if (weapon == null) {
            // update player weapon slot
            weapon = newWeapon;
            // remove newWeapon from inv
            inv.getInventory().remove(newWeapon);
            // update player damage
            setDamage(newWeapon.getDamage());
            // if weapon slot is not empty
        } else {
            // unequips current weapon
            unequipWeapon(weapon, inv);
            // updates player weapon slot
            weapon = newWeapon;
            // remove newWeapon from inv
            inv.getInventory().remove(newWeapon);
            // update player damage
            setDamage(newWeapon.getDamage());
        }

    }

    // player functionality for unequipping weapons
    /**
     * This function unequips a weapon from the player's weapon slot and adds it to
     * the player's
     * inventory
     * 
     * @param oldWeapon the weapon to be unequipped
     * @param inv       the inventory of the player
     */
    public void unequipWeapon(Weapon oldWeapon, Inventory inv) {
        // cannot unequip nothing
        if (oldWeapon == null) {
            return;
        }
        // verifies weapon is actually equipped
        if (weapon.equals(oldWeapon)) {
            // update player weapon slot
            weapon = null;
            // adds weapon to inv
            inv.getInventory().add(oldWeapon);
            // update player damage
            setDamage("");
            // cannot unequip weapon that isn't equipped
        } else {
            return;
        }
    }

    // player functionality for equipping shields
    /**
     * If the player's shield slot is empty, equip the new shield, otherwise unequip
     * the current shield
     * and equip the new shield
     * 
     * @param newShield the shield that the player wants to equip
     * @param inv       the inventory of the player
     */
    public void equipShield(Shield newShield, Inventory inv) {
        // cannot equip nothing
        if (newShield == null) {
            return;
        }
        // if shield slot is empty
        if (shield == null) {
            // update player shield slot
            shield = newShield;
            // remove newShield from inv
            inv.getInventory().remove(newShield);
            // updates player defense
            addDefense(newShield.getDefense());
            // if shield slot is not empty
        } else {
            // unequips current shield
            unequipShield(shield, inv);
            // updates player shield slot
            shield = newShield;
            // remove newShield from inv
            inv.getInventory().remove(newShield);
            // updates player defense
            addDefense(newShield.getDefense());
        }
    }

    // player functionality for unequipping shields
    /**
     * This function unequips a shield from the player and adds it to the inventory
     * 
     * @param oldShield the shield to be unequipped
     * @param inv       the inventory of the player
     */
    public void unequipShield(Shield oldShield, Inventory inv) {
        // cannot unequip nothing
        if (oldShield == null) {
            return;
        }
        // verifies oldShield is actually equipped
        if (shield.equals(oldShield)) {
            // update player shield slot
            shield = null;
            // adds oldShield to inv
            inv.getInventory().add(oldShield);
            // update player defense
            removeDefense(oldShield.getDefense());
            // cannot unequip shield that isn't equipped
        } else {
            return;
        }
    }

    /**
     * This function returns the head armor of the player.
     * 
     * @return The head armor.
     */
    public Armor getHead() {
        return head;
    }

    /**
     * This function returns the body armor of the player.
     * 
     * @return The body armor.
     */
    public Armor getBody() {
        return body;
    }

    /**
     * @return Armor
     */
    /**
     * This function returns the legs variable.
     * 
     * @return The legs variable is being returned.
     */
    public Armor getLegs() {
        return legs;
    }

    /**
     * @return Weapon
     */
    /**
     * This function returns the weapon that the player is currently holding.
     * 
     * @return The weapon object.
     */
    public Weapon getWeapon() {
        return weapon;
    }

    /**
     * @return Shield
     */
    /**
     * This function returns the shield.
     * 
     * @return The shield object.
     */
    public Shield getShield() {
        return shield;
    }

    // Not to be used by player, underlying code for testing(does not manipulate
    // inventory)
    /**
     * If the armor is null, set the head slot to null. If the armor is not null,
     * set the head slot to
     * the armor
     * 
     * @param armor The armor to be set to the head slot.
     */
    public void setHead(Armor armor) {
        // set head slot to null
        if (armor == null) {
            // head slot is not empty
            if (head != null) {
                // update player defense
                removeDefense(head.getDefense());
                // update player head slot
                head = null;
            }
            // may be wrong
            return;
        }
        // can only set head slot to head armor
        if (armor.getSlot().equals("Head")) {
            // head slot is empty
            if (head == null) {
                // update player head slot
                head = armor;
                // update player defense
                addDefense(armor.getDefense());
                // head slot is not empty
            } else {
                // update player defense
                removeDefense(head.getDefense());
                addDefense(armor.getDefense());
                // update player head slot
                head = armor;
            }
        }
    }

    // Not to be used by player, underlying code for testing(does not manipulate
    // inventory)
    /**
     * If the armor is null, set the body slot to null. If the armor is not null,
     * set the body slot to
     * the armor
     * 
     * @param armor The armor object that will be set to the body slot.
     */
    public void setBody(Armor armor) {
        // set body slot to null
        if (armor == null) {
            // body slot is not empty
            if (body != null) {
                // update player defense
                removeDefense(body.getDefense());
                // update player body slot
                body = null;
            }
            // may be wrong
            return;
        }
        // can only set body slot to body armor
        if (armor.getSlot().equals("Body")) {
            // body slot is empty
            if (body == null) {
                // update player body slot
                body = armor;
                // update player defense
                addDefense(armor.getDefense());
                // body slot is not empty
            } else {
                // update player defense
                removeDefense(body.getDefense());
                addDefense(armor.getDefense());
                // update player body slot
                body = armor;
            }
        }
    }

    // Not to be used by player, underlying code for testing(does not manipulate
    // inventory)
    /**
     * If the armor is null, set the legs slot to null. If the armor is not null,
     * and the armor is a
     * legs armor, set the legs slot to the armor
     * 
     * @param armor The armor to be set to the legs slot.
     */
    public void setLegs(Armor armor) {
        // set legs slot to null
        if (armor == null) {
            // legs slot is not empty
            if (legs != null) {
                // update player defense
                removeDefense(legs.getDefense());
                // update player legs slot
                legs = null;
            }
            // may be wrong
            return;
        }
        // can only set legs slot to legs armor
        if (armor.getSlot().equals("Legs")) {
            // legs slot is empty
            if (legs == null) {
                // update player legs slot
                legs = armor;
                // update player defense
                addDefense(armor.getDefense());
                // legs slot is not empty
            } else {
                // update player defense
                removeDefense(legs.getDefense());
                addDefense(armor.getDefense());
                // update player legs slot
                legs = armor;
            }
        }
    }

    // Not to be used by player, underlying code for testing(does not manipulate
    // inventory)
    /**
     * This function sets the player's weapon to the new weapon, and updates the
     * player's damage.
     * 
     * @param newWeapon The weapon that the player is equipping.
     */
    public void setWeapon(Weapon newWeapon) {
        // updates player weapon slot
        weapon = newWeapon;
        // update player damage
        if (newWeapon != null) {
            setDamage(newWeapon.getDamage());
        } else {
            setDamage("");
        }

    }

    // Not to be used by player, underlying code for testing(does not manipulate
    // inventory)
    /**
     * If the player's shield slot is empty, then update the player's shield slot
     * and defense. If the
     * player's shield slot is not empty, then update the player's defense and
     * shield slot
     * 
     * @param newShield The new shield to be equipped.
     */
    public void setShield(Shield newShield) {
        // shield slot is empty
        if (shield == null) {
            // update player shield slot
            shield = newShield;
            // update player defense
            if (newShield != null) {
                addDefense(newShield.getDefense());
            }
            // shield slot is not empty
        } else {
            // update player defense
            removeDefense(shield.getDefense());
            if (newShield != null) {
                addDefense(newShield.getDefense());
            }
            // update player shield slot
            shield = newShield;
        }
    }

}
