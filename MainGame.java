import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
 
public class MainGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // senjata dan skill hero
        Senjata sword = new Senjata("Pedang", 10);
        Senjata arch = new Senjata("Panah", 30);
        Senjata glove = new Senjata("Sarung Tangan", 15);
        Senjata magic = new Senjata("Sihir", 20);
        Armor shield = new Armor("Perisai", 5, 50);
        Armor gauntlet = new Armor("Cincin", 2, 50);

        Skill knightSkill = new Skill("Shield", 20, 25);
        Skill archerSkill = new Skill("Kemampuan Khusus", 15, 20);
        Skill fighterSkill = new Skill("Combat Focus", 20, 25);
        Skill fairySkill = new Skill("Healing", 25, 30);

        // senjata dan skill foe
        Senjata magic2 = new Senjata("Sihirr", 20);
        Senjata scratch = new Senjata("Cakar", 30);
        Senjata knife = new Senjata("Pisau", 25);

        Skill elfSkill = new Skill("Recover", 80, 30);
        Skill elfSkill2 = new Skill("Lullaby", 70, 30);
        Skill dragonSkill = new Skill("Fire", 50, 25);
        Skill goblinSkill = new Skill("Gigit", 60, 25);

        System.out.println("Pilih ras untuk Hero (Knight, Archer, Fighter, Fairy): ");
        String heroRace = scanner.nextLine();

        Senjata heroSenjata;
        if (heroRace.equalsIgnoreCase("Knight")) {
            heroSenjata = sword;
        } else if (heroRace.equalsIgnoreCase("Archer")) {
            heroSenjata = arch;
        } else if (heroRace.equalsIgnoreCase("Fighter")){
            heroSenjata = glove;
        } else if (heroRace.equalsIgnoreCase("Fairy")){
            heroSenjata = magic;
        } else {
            System.out.println("Ras tidak valid, default menggunakan Pedang untuk Hero.");
            heroSenjata = sword;
        }

        System.out.println("Pilih armor untuk Hero (Perisai, Cincin): ");
        String heroArmorName = scanner.nextLine();
        Armor heroArmor = heroArmorName.equalsIgnoreCase("Perisai") ? shield : gauntlet;

        Skill heroSkill;
        if (heroRace.equalsIgnoreCase("Knight")) {
            heroSkill = knightSkill;
        } else if (heroRace.equalsIgnoreCase("Archer")) {
            heroSkill = archerSkill;
        } else if (heroRace.equalsIgnoreCase("Fighter")){
            heroSkill = fighterSkill;
        } else if (heroRace.equalsIgnoreCase("Fairy")) {
            heroSkill = fairySkill;
        } else {
            System.out.println("Skill tidak valid, default menggunakan Pedang untuk Hero.");
            heroSkill = knightSkill;
        }

        System.out.println("Masukkan level untuk Hero (1-10): ");
        int heroLevel = scanner.nextInt();

        // objek hero
        Hero hero;
        if (heroRace.equalsIgnoreCase("Knight")){
            hero = new Knight("Satria", heroRace, heroSenjata, heroArmor, 120, 50, heroSkill, heroLevel);
        } else if (heroRace.equalsIgnoreCase("Archer")){
            hero = new Archer("Pemanah", heroRace, heroSenjata, heroArmor, 100, 60, heroSkill, heroLevel);
        } else if (heroRace.equalsIgnoreCase("Fighter")){
            hero = new Fighter("Pembunuh", heroRace, heroSenjata, heroArmor, 250, 50, heroSkill, heroLevel);
        } else {
            hero = new Fairy("Peri", heroRace, heroSenjata, heroArmor, 200, 80, heroSkill, heroLevel);
        }

        // objek foe
        Armor foeArmor = random.nextBoolean() ? shield : gauntlet;
        List<Character> foes = new ArrayList<>();
        foes.add(new Elf("Nymph", "Elf", magic2, foeArmor, 80, 60, elfSkill, random.nextInt(10) + 1));
        foes.add(new Elf("Pixie", "Elf", magic2, foeArmor, 100, 70, elfSkill2, random.nextInt(10) + 1));
        foes.add(new Dragon("Naga", "Dragon", scratch, foeArmor, 120, 40, dragonSkill, random.nextInt(10) + 1));
        foes.add(new Goblin("Kurcaci", "Goblin", knife, foeArmor, 100, 80, goblinSkill, random.nextInt(10) + 1));

        int randomIndx = random.nextInt(foes.size());
        Character foe = foes.get(randomIndx);

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
                System.out.println("Pilih item untuk digunakan (Potion, Ether, Elixir, Remedy, Antidote): ");
                String itemName = scanner.next();
                Item item = new Item(itemName, 0, 0);

                if (item.isPotion()) {
                    item.setHpIncrease(100);
                } else if (item.isEther()) {
                    item.setMpIncrease(100);
                } else if (item.isElixir()) {
                    item.setHpIncrease(150);
                    item.setMpIncrease(100);
                }

                if (hero instanceof Hero) {
                    hero.useItem(item);
                } else if (item.isPotion() || item.isEther() || item.isElixir()) {
                    System.out.println("Item tidak dapat digunakan oleh Foe.");
                } else {
                    System.out.println("Item tidak dapat digunakan oleh Foe.");
                }
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