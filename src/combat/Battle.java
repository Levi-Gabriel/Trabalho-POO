package combat;
import items.Item;
import java.util.List;
import java.util.Scanner;
import character.Hero;
import character.Monster;

/**
 * Responsável por gerenciar o combate por turnos entre o Herói e os
 * monstros de uma sala. 
 **/

public class Battle {

    public static boolean start(Hero hero, List<Monster> monsters, Scanner scanner) {
        System.out.println("\n*** Iniciou um combate! ***");

        for (Monster monster : monsters) {
            if (!monster.isAlive()) {
                continue;
            }
            boolean heroWins = fightAgainst(hero, monster, scanner);
            if (!heroWins) {
                return false; // herói foi derrotado
            }
        }
        System.out.println("*** Combate vencido! ***\n");
        return true;
    }

    private static boolean fightAgainst(Hero hero, Monster monster, Scanner scanner) {
        System.out.println("\n-- " + monster.getName() + " bloqueia seu caminho! --");

        while (hero.isAlive() && monster.isAlive()) {
            System.out.println("\n" + hero);
            System.out.println(monster);
            System.out.println("Ações: [1] Atacar  [2] Usar item  [3] Fugir");
            System.out.print("> ");
            String option = scanner.nextLine().trim();

            switch (option) {
                case "1":
                    hero.attack(monster); // polimorfismo: atacar() varia conforme o monstro/heroi
                    if (monster.isAlive()) {
                        monster.attack(hero); // polimorfismo: cada monstro ataca de forma diferente
                    }
                    break;
                case "2":
                	useItemOnCombat(hero, scanner);
                    if (monster.isAlive()) {
                        monster.attack(hero);
                    }
                    break;
                case "3":
                    System.out.println("Você foge do combate!");
                    return true; // considera-se que o herói escapou, não morreu
                default:
                    System.out.println("Opção inválida.");
            }
        }

        if (!hero.isAlive()) {
            System.out.println(hero.getName() + " foi derrotado...");
            return false;
        }

        System.out.println(monster.getName() + " foi derrotado!");
        Item drop = monster.getItemDrop();
        if (drop != null) {
            hero.getItem(drop);
        }
        return true;
    }

    private static void useItemOnCombat(Hero hero, Scanner scanner) {
        if (hero.getInventory().isEmpty()) {
            System.out.println("Você não tem itens.");
            return;
        }
        hero.getInventory().listItems();
        System.out.print("Escolha o número do item (ou 0 para cancelar): ");
        try {
            int choose = Integer.parseInt(scanner.nextLine().trim());
            if (choose <= 0 || choose > hero.getInventory().getItems().size()) {
                System.out.println("Cancelado.");
                return;
            }
            Item item = hero.getInventory().getItems().get(choose - 1);
            hero.useItem(item);
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida.");
        }
    }
}