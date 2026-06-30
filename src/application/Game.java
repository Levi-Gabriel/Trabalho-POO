package application;

import java.util.List;
import java.util.Scanner;

import combat.Battle;
import world.Chest;
import world.Direction;
import world.Map;
import world.Room;
import character.Hero;
import character.Monster;
import character.Character;

public class Game {

    private final Hero hero;
    private final Map map;
    private Room actualRoom;
    private final Scanner scanner;

    public Game() {
        this.scanner = new Scanner(System.in);
        this.hero = createHero();
        this.map = new Map(5, System.currentTimeMillis());
        this.actualRoom = map.getInitialRoom();
    }

    private Hero createHero() {
        System.out.println("=== Bem-vindo à Masmorra! ===");
        System.out.print("Digite o nome do seu herói: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
        	name = "Aventureiro";
        }
        return new Hero(name, 50, 8, 2);
    }

    public void start() {
        System.out.println("\nComandos: mover <norte|sul|leste|oeste>, atacar, usar, inventario, sair");
        boolean isPlaying = true;

        while (isPlaying && hero.isAlive()) {
            actualRoom.description();

            if (actualRoom.areMonsterALive()) {
                List<Monster> monsters = actualRoom.getMonsters();
                boolean venceu = Battle.start(hero, monsters, scanner);
                if (!venceu) {
                    break; // herói foi derrotado
                }
            }

            if (actualRoom.isFinalRoom() && !actualRoom.areMonsterALive()) {
                System.out.println("\n*** Parabéns! Você derrotou o guardião final e venceu o jogo! ***");
                break;
            }
            System.out.print("\n> ");
            String comando = scanner.nextLine().trim().toLowerCase();
            isPlaying = checkAction(comando);
        }

        if (!hero.isAlive()) {
            System.out.println("\nFim de jogo."
                    + Character.getTotalChar());
        }

        scanner.close();
    }

    private boolean checkAction(String action) {
        if (action.equals("sair")) {
            System.out.println("Até a próxima!");
            return false;
        }

        if (action.startsWith("mover")) {
            mover(action);
        } else if (action.equals("inventario")) {
            hero.getInventory().listItems();
        } else if (action.equals("usar")) {
            useItemOutCombat();
        } else if (action.equals("abrir") || action.equals("bau")) {
            openChest();
        } else if (action.equals("ajuda")) {
            System.out.println("Comandos: mover <direcao>, abrir, usar, inventario, sair");
        } else {
            System.out.println("Comando não reconhecido. Digite 'ajuda' para ver as opções.");
        }
        return true;
    }

    private void mover(String comando) {
        String[] paths = comando.split(" ");
        if (paths.length < 2) {
            System.out.println("Use: mover <leste|oeste>");
            return;
        }
        Direction direction = Direction.direction(paths[1]);
        if (direction == null) {
            System.out.println("Direção inválida.");
            return;
        }
        Room destination = actualRoom.getpaths(direction);
        if (destination == null) {
            System.out.println("Não há saída nessa direção.");
            return;
        }
        if (actualRoom.areMonsterALive()) {
            System.out.println("Derrote os monstros antes de avançar!");
            return;
        }
        actualRoom = destination;
        actualRoom.isVisited();
    }

    private void openChest() {
        Chest chest = actualRoom.getChest();
        if (chest == null) {
            System.out.println("Não há baú nesta sala.");
            return;
        }
        chest.interact(hero);
    }

    private void useItemOutCombat() {
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
            hero.useItem(hero.getInventory().getItems().get(choose - 1));
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida.");
        }
    }
}