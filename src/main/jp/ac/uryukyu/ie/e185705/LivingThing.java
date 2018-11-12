package jp.ac.uryukyu.ie.e185705;

/*
 * String name:     キャラクター名
 * int hitPoint:    キャラクターのHP
 * int maximumHP:   キャラクターの最大HP
 * int attaack:     キャラクターの攻撃力
 * boolean dead:    キャラクターの生死確認。
 */

public class LivingThing {
    String name;
    int hitPoint;
    int attack;
    boolean dead;

    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name モンスター,勇者名
     * @param maximumHP モンスター,勇者のHP
     * @param attack モンスター,勇者の攻撃力
     */

    public LivingThing (String name, int maximumHP, int attack) {
        this.name = name;
        this.hitPoint = maximumHP;
        this.attack = attack;
        this.dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%sです。\n",name,maximumHP,attack);

    }

    /**
     * getterメソッドと同等。生死をboolean表現しているためメソッド名をisDead()とした。
     * @return boolean
     */

    public boolean isDead(){
        return dead;
    }

    /*
     * getterメソッドと同等。モンスターと勇者の名前を変数nameに保存する。
     *　
     */

    public String getName(){
        return name;
    }

    /**
     * 相手に攻撃するメソッド。
     * attackに応じて乱数でダメージを算出し、hero.wounded()によりダメージ処理を実行。
     * @param opponent 攻撃対象
     */

    public void attack(LivingThing opponent){
        int damage = (int)(Math.random() * attack);
        if(dead == false){
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
            opponent.wounded(damage);
        }
    }

    /**
     * 攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ
     */

    public void wounded(int damage){
        hitPoint -= damage;
        if(hitPoint < 0){
            dead = true;
            System.out.printf("%sは倒れた。" + "\n", name);
        }
    }
}
