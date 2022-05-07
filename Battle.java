public class Battle {

    private Player opposition;
    private int pointsReward;
    private int goldreward;
    private boolean[] hasUsedSpecialAbility = {false, false, false};

    public Battle(Player opposition, int pointsReward, int goldreward, boolean[] hasUsedSpecialAbility) {
        super();
        this.opposition = opposition;
        this.pointsReward = pointsReward;
        this.goldreward = goldreward;
        this.hasUsedSpecialAbility = hasUsedSpecialAbility;
    }

    public Player getOpposition() {
        return opposition;
    }
    public void setOpposition(Player opposition) {
        this.opposition = opposition;
    }
    public int getPointsReward() {
        return pointsReward;
    }
    public void setPointsReward(int pointsReward) {
        this.pointsReward = pointsReward;
    }
    public int getGoldreward() {
        return goldreward;
    }
    public void setGoldreward(int goldreward) {
        this.goldreward = goldreward;
    }
    public boolean[] getHasUsedSpecialAbility() {
        return hasUsedSpecialAbility;
    }
    public void setHasUsedSpecialAbility(boolean[] hasUsedSpecialAbility) {
        this.hasUsedSpecialAbility = hasUsedSpecialAbility;
    }

    public void chooseAttack() {
        //Some sort of window/buttons thing to choose between base and special attack?
    }
    /*
    public Monster chooseAttackTarget() {
        //some sort of window thing i guess
        //int i = index of opposition monster
        //Monster monster = opposition.getTeam()[i];
        //return monster;
    }

    public void oppositionAttacks() {

    }*/
}