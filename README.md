# 🏰 Dungeon Adventure - Trabalho de Programação Orientada a Objetos

Um jogo de aventura em texto desenvolvido em **Java** para a disciplina de **Programação Orientada a Objetos (POO)**. O jogador explora uma masmorra, enfrenta monstros, coleta itens, abre baús e derrota o chefe final para vencer a partida.

---

## 🎮 Funcionalidades

- Exploração de um mapa composto por salas.
- Movimentação nas quatro direções (norte, sul, leste e oeste).
- Sistema de combate contra diferentes monstros.
- Inventário para armazenar itens.
- Baús contendo equipamentos e poções.
- Uso de armas, armaduras e poções de cura.
- Sala final com o chefe da masmorra.
- Geração aleatória de monstros e itens.

---

## 👾 Monstros

O jogo possui diferentes inimigos, cada um com seus próprios atributos:

- 🐉 Dragão
- 💀 Esqueleto
- 👹 Goblin

---

## 🧪 Itens

Os jogadores podem encontrar:

- ⚔️ Armas
- 🛡️ Armaduras
- ❤️ Poções de cura

---

## 📂 Estrutura do Projeto

```
src/
├── application/
├── character/
├── combat/
├── factory/
├── items/
└── world/
```

### Organização

- **application** → Inicialização e controle do jogo.
- **character** → Herói, monstros e interfaces.
- **combat** → Sistema de batalha.
- **factory** → Criação de monstros e itens.
- **items** → Inventário e equipamentos.
- **world** → Mapa, salas, direções e baús.

---

## 🛠️ Tecnologias

- Java
- Programação Orientada a Objetos

---

## ▶️ Como executar

1. Clone o repositório:

```bash
git clone <url-do-repositorio>
```

2. Abra o projeto em uma IDE Java (Eclipse, IntelliJ IDEA ou VS Code).

3. Execute a classe:

```
application.Main
```

---

## 🎯 Comandos do jogo

| Comando | Ação |
|---------|------|
| `mover norte` | Move para o norte |
| `mover sul` | Move para o sul |
| `mover leste` | Move para o leste |
| `mover oeste` | Move para o oeste |
| `abrir` | Abre o baú da sala |
| `usar` | Usa um item do inventário |
| `inventario` | Lista os itens |
| `ajuda` | Exibe os comandos disponíveis |
| `sair` | Encerra o jogo |

---

## 🧩 Conceitos de POO utilizados

- Encapsulamento
- Herança
- Polimorfismo
- Abstração
- Interfaces
- Classes abstratas
- Factory Method (criação de monstros e itens)

---

## 🏆 Objetivo

Explore a masmorra, derrote todos os monstros, colete equipamentos para fortalecer seu herói e elimine o guardião da sala final para conquistar a vitória.
