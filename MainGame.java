import java.util.Random;
import java.util.Scanner;


public class MainGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        Senjata sword = new Senjata("Pedang", 10);
        Senjata glove = new Senjata("Sarung tangan", 7);
        Armor shield = new Armor("Perisai", 5, 50);
        Armor gauntlet = new Armor("Cincin", 2, 50);

        Skill knightSkill = new Skill("Serangan Kilat", 20, 25);
        Skill archerSkill = new Skill("Panah Api", 15, 20);
        Skill fairySkill = new Skill("Serangan Sihir", 25, 30);

        System.out.println("Pilih ras untuk Hero (Knight, Archer, Fairy): ");
        String heroRace = scanner.nextLine();

        Senjata heroSenjata;
        if (heroRace.equalsIgnoreCase("Knight")) {
            heroSenjata = sword;
        } else if (heroRace.equalsIgnoreCase("Archer") || heroRace.equalsIgnoreCase("Fairy")) {
            heroSenjata = glove;
        } else {
            System.out.println("Ras tidak valid, default menggunakan Pedang untuk Hero.");
            heroSenjata = sword;
        }

        System.out.println("Pilih armor untuk Hero (Perisai, Cincin): ");
        String heroArmorName = scanner.nextLine();
        Armor heroArmor = heroArmorName.equalsIgnoreCase("Perisai") ? shield : gauntlet;

        Skill heroSkill;
        if (heroRace.equalsIgnoreCase("Knight")) {
            System.out.println("Pilih skill untuk Hero (Serangan Kilat): ");
            heroSkill = knightSkill;
        } else if (heroRace.equalsIgnoreCase("Archer")) {
            System.out.println("Pilih skill untuk Hero (Panah Api): ");
            heroSkill = archerSkill;
        } else if (heroRace.equalsIgnoreCase("Fairy")) {
            System.out.println("Pilih skill untuk Hero (Serangan Sihir): ");
            heroSkill = fairySkill;
        } else {
            System.out.println("Skill tidak valid, default menggunakan Serangan Kilat untuk Hero.");
            heroSkill = knightSkill;
        }

        System.out.println("Masukkan level untuk Hero (1-10): ");
        int heroLevel = scanner.nextInt();

        Hero hero = new Hero("Sang Hero", heroRace, heroSenjata, heroArmor, 100, 50, heroSkill, heroLevel);

        Armor foeArmor = random.nextBoolean() ? shield : gauntlet;
        Skill foeSkill = random.nextBoolean() ? knightSkill : archerSkill; // Contoh skill untuk Foe
        Foe foe = new Foe("Monster", "Orc", glove, foeArmor, 80, 40, foeSkill, random.nextInt(10) + 1); // Level foe akan diacak antara 1-10

        System.out.println("Foe menggunakan " + foe.armor.name + " (Armor: " + foe.armor.value + ") sebagai armor.");
        System.out.println("Foe memiliki skill " + foe.skill.name + " yang memiliki MP Cost: " + foe.skill.mpCost + " dan Damage: " + foe.skill.damage);
        System.out.println("Foe adalah seorang " + foe.race);

        battle(hero, foe, scanner);
    }

    public static void battle(Character hero, Character foe, Scanner scanner) {
        Random random = new Random();
        while (hero.hp > 0 && foe.hp > 0) {
            hero.displayStatus();
            foe.displayStatus();
            System.out.println("Pilih aksi untuk Hero (1. Attack, 2. Use Item, 3. Use Skill): ");
            int action = scanner.nextInt();

            if (action == 1) {
                hero.attack(foe);
            } else if (action == 2) {
                System.out.println("Pilih item untuk digunakan (Potion, Ether): ");
                String itemName = scanner.next();
                Item item = itemName.equalsIgnoreCase("Potion") ? new Item("Potion", 20, 0) : new Item("Ether", 0, 15);
                hero.useItem(item);
            } else if (action == 3) {
                if (hero instanceof Hero) {
                    ((Hero) hero).useSkill(foe);
                }
            }

            if (random.nextBoolean()) {
                if (foe instanceof Foe) {
                    ((Foe) foe).useSkill(hero);
                }
            }
        }

        if (hero.hp <= 0) {
            System.out.println("Hero kalah. Game over!");
        } else {
            System.out.println("Hero menang. Selamat!");
        }
    }
}