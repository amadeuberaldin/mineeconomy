package com.amadeu.mineeconomy.shop.reward;

import com.amadeu.mineeconomy.shop.ShopEntry;
import net.minecraft.core.Holder;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.Filterable;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.WrittenBookContent;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.ItemEnchantments;

import java.util.List;

public final class ItemRewardFactory {

    private ItemRewardFactory() {
    }

    public static ItemStack createFromEntry(ServerPlayer player, ShopEntry entry) {
        return switch (entry.itemType()) {
            case "enchanted_book" -> createEnchantedBook(player, entry);
            case "golden_apple" -> new ItemStack(Items.GOLDEN_APPLE, entry.count());
            case "golden_carrot" -> new ItemStack(Items.GOLDEN_CARROT, entry.count());
            case "safezone_book" -> createSafezoneBook();
            case "hivemind_book" -> createHivemindBook();
            case "music_disc" -> createMusicDisc(entry);
            case "pvp_book" -> createPvpBook();
            default -> throw new IllegalArgumentException("Tipo de item não suportado: " + entry.itemType());
        };
    }

    private static ItemStack createEnchantedBook(ServerPlayer player, ShopEntry entry) {
        ItemStack stack = new ItemStack(Items.ENCHANTED_BOOK);

        stack.set(DataComponents.CUSTOM_NAME, Component.literal(entry.displayName()));

        ItemEnchantments.Mutable mutable = new ItemEnchantments.Mutable(ItemEnchantments.EMPTY);

        RegistryAccess registryAccess = player.registryAccess();

        for (ShopEntry.EnchantEntry enchantEntry : entry.enchantments()) {
            ResourceKey<Enchantment> key = mapEnchantKey(enchantEntry.id());

            Holder<Enchantment> holder = registryAccess
                    .lookupOrThrow(Registries.ENCHANTMENT)
                    .getOrThrow(key);

            mutable.set(holder, enchantEntry.level());
        }

        stack.set(DataComponents.STORED_ENCHANTMENTS, mutable.toImmutable());

        return stack;
    }

    /*
     * Cria um written book pronto para abrir no cliente.
     *
     * Uso:
     * - safezone_book
     * - hivemind_book
     *
     * O título do livro aparece na capa.
     * As páginas são convertidas para componentes de texto simples.
     */
    private static ItemStack createWrittenBook(String title, List<String> pages) {
        ItemStack stack = new ItemStack(Items.WRITTEN_BOOK);

        List<Filterable<Component>> pageComponents = pages.stream()
                .<Filterable<Component>>map(page -> Filterable.passThrough(Component.literal(page)))
                .toList();

        WrittenBookContent content = new WrittenBookContent(
                Filterable.passThrough(title),
                "Servidor",
                0,
                pageComponents,
                true);

        stack.set(DataComponents.WRITTEN_BOOK_CONTENT, content);
        return stack;
    }

    private static ItemStack createPvpBook() {
    return createWrittenBook(
            "PvP",
            List.of(
                    "Manual Oficial\n\nSistema PvP\n\nEste livro explica:\n\n- PvP\n- Combate\n- Arenas\n- Regras",

                    "Existem 3 estados:\n\nVerde = PvE\nVermelho = PvP\nAmarelo = Em combate",

                    "PvE\n\nJogadores em PvE não podem atacar nem ser atacados por outros jogadores.",

                    "/pvp on\n\nAtiva o PvP.\n\nSeu nome ficará vermelho.",

                    "/pvp off\n\nDesativa o PvP.\n\nSeu nome ficará verde.",

                    "Para que um ataque funcione:\n\nOs DOIS jogadores precisam estar com PvP ativado.",

                    "Se apenas um jogador estiver com PvP ativado:\n\nO dano será bloqueado.",

                    "Combate\n\nAo atacar ou ser atacado:\n\nVocê entra em combate.",

                    "Durante o combate:\n\nSeu nome ficará amarelo.",

                    "O estado de combate dura 30 segundos após o último ataque recebido.",

                    "Durante o combate:\n\n/pvp off fica bloqueado.",

                    "Combat Log\n\nJogadores que deslogarem em combate serão mortos.",

                    "Arenas PvP\n\nDentro de arenas PvP o combate é sempre permitido.",

                    "Em arenas PvP:\n\nNão é necessário usar /pvp on.",

                    "Dica\n\nSe pretende explorar ou construir, mantenha PvP desligado.\n\nAtive apenas quando desejar lutar."));
}

    /*
     * Manual do sistema de claims.
     *
     * Este item é vendido na loja para o jogador recuperar as instruções
     * caso perca o livro inicial do starterkit.
     */
    private static ItemStack createSafezoneBook() {
        return createWrittenBook(
                "Zonas Seguras",
                List.of(
                        "Manual Oficial\n\nClaims e Permissões\n\nEste livro explica:\n\n- Claims\n- Proteções\n- Permissões\n- Guests",
                        "O que é uma claim?\n\nUma claim é um território protegido.\n\nOutros jogadores não podem roubar, quebrar ou construir sem permissão.",
                        "/claim\n\nCria uma claim.\n\nA claim possui:\n\n- 30 blocos para cada lado\n- Proteção de construção\n- Proteção de baús",
                        "Cada jogador pode possuir até 10 claims.\n\nCada claim possui permissões próprias.\n\nVocê deve estar dentro da claim para usar comandos dela.",
                        "/disclaim\n\nRemove sua claim.\n\nVocê deve estar dentro da claim para abandonar o território.",
                        "/claimlocation\n\nMostra as coordenadas de todas as suas claims.",
                        "/claimshow\n\nMostra os limites da claim.\n\n/claimhide\n\nEsconde a visualização da claim.",
                        "/trust Nome\n\nPermite acesso TOTAL:\n\n- abrir baús\n- usar portas\n- construir\n- modificar entidades",
                        "/untrust Nome\n\nRemove todas as permissões do jogador.\n\n/trustlist\n\nLista todos os jogadores autorizados.",
                        "/guest Nome\n\nPermite acesso LIMITADO:\n\n- abrir baús\n- usar portas\n- usar alavancas\n- usar botões",
                        "Guests NÃO podem:\n\n- construir\n- quebrar blocos\n- mexer em armor stands\n- mexer em item frames",
                        "/unguest Nome\n\nRemove o acesso guest.\n\n/guestlist\n\nLista todos os guests da claim.",
                        "Proteções\n\nClaims possuem proteção contra:\n\n- PVP\n- Flechas\n- Creepers\n- TNT\n- Roubo",
                        "Jogadores protegidos dentro de claims:\n\n- não recebem dano PVP\n- não causam dano PVP\n- não podem abusar de arco",
                        "Dica\n\nUse /guest para farms automáticas e áreas compartilhadas.\n\nUse /trust apenas para jogadores de confiança."));
    }

    /*
     * Manual oficial do Hivemind.
     *
     * Este livro explica:
     * - ativação
     * - duração
     * - cooldown
     * - níveis por armadura
     */
    private static ItemStack createHivemindBook() {
        return createWrittenBook(
                "Hivemind",
                List.of(
                        "Manual Oficial\n\nSistema: Hivemind\n\nEste livro explica:\n\n- ativação\n- duração\n- níveis\n- monstros",
                        "O que é o Hivemind?\n\nQuando você ataca um monstro...\n\noutros monstros próximos podem entrar no combate.",
                        "O sistema aumenta a dificuldade do servidor.\n\nQuanto melhor sua armadura...\n\nmais perigosa será a resposta.",
                        "Ativação\n\nAo atacar um inimigo:\n\n- o Hivemind ativa\n- monstros próximos detectam você\n- o contador aparece na tela",
                        "Duração\n\nO Hivemind permanece ativo por 5 minutos.",
                        "Cooldown\n\nApós terminar:\n\n- o sistema entra em cooldown\n- duração: 30 minutos\n- durante o cooldown o mundo volta ao normal",
                        "Nível 1\n\nSem armadura\nCouro\nCobre\nOuro\nAté 1 peça de ferro\n\nRaio: 32\nLimite: 10",
                        "Nível 1\n\nApenas zumbis participam do Hivemind.",
                        "Nível 2\n\n2 ou mais peças de ferro\n\nRaio: 48\nLimite: 25",
                        "Nível 2\n\nApenas zumbis participam do Hivemind.",
                        "Nível 3\n\n1 a 3 peças de diamante\n\nRaio: 64\nLimite: 40",
                        "Nível 3\n\nParticipam:\n\n- zumbis\n- esqueletos\n- aranhas",
                        "Nível 4\n\nFull diamante\nou qualquer netherite\n\nRaio: 128\nLimite: 80",
                        "Nível 4\n\nParticipam:\n\n- zumbis\n- esqueletos\n- aranhas",
                        "Bônus Netherite\n\nQualquer peça:\n\n- creepers entram no combate",
                        "Full Netherite\n\nParticipam:\n\n- bruxas\n- wither skeletons\n\n(apenas no Nether)",
                        "Durante o Hivemind:\n\n- sobreviva\n- mantenha comida\n- tenha rota de fuga\n- lute com cuidado",
                        "Recompensa\n\nMonstros afetados pelo Hivemind possuem chance de dropar esmeraldas.",
                        "O Hivemind foi criado para tornar a progressão mais perigosa.\n\nQuanto mais forte você fica...\n\nmais o mundo reage."));
    }

    private static ResourceKey<Enchantment> mapEnchantKey(String enchantId) {
        return switch (enchantId) {
            case "unbreaking" -> Enchantments.UNBREAKING;
            case "mending" -> Enchantments.MENDING;

            case "sharpness" -> Enchantments.SHARPNESS;
            case "looting" -> Enchantments.LOOTING;
            case "fire_aspect" -> Enchantments.FIRE_ASPECT;
            case "knockback" -> Enchantments.KNOCKBACK;

            case "power" -> Enchantments.POWER;
            case "infinity" -> Enchantments.INFINITY;
            case "flame" -> Enchantments.FLAME;
            case "punch" -> Enchantments.PUNCH;

            case "efficiency" -> Enchantments.EFFICIENCY;
            case "fortune" -> Enchantments.FORTUNE;
            case "silk_touch" -> Enchantments.SILK_TOUCH;

            case "protection" -> Enchantments.PROTECTION;
            case "respiration" -> Enchantments.RESPIRATION;
            case "aqua_affinity" -> Enchantments.AQUA_AFFINITY;
            case "feather_falling" -> Enchantments.FEATHER_FALLING;
            case "depth_strider" -> Enchantments.DEPTH_STRIDER;

            case "luck_of_the_sea" -> Enchantments.LUCK_OF_THE_SEA;
            case "lure" -> Enchantments.LURE;
            case "fire_protection" -> Enchantments.FIRE_PROTECTION;
            case "blast_protection" -> Enchantments.BLAST_PROTECTION;
            case "projectile_protection" -> Enchantments.PROJECTILE_PROTECTION;
            case "thorns" -> Enchantments.THORNS;
            case "frost_walker" -> Enchantments.FROST_WALKER;

            case "multishot" -> Enchantments.MULTISHOT;
            case "quick_charge" -> Enchantments.QUICK_CHARGE;
            case "piercing" -> Enchantments.PIERCING;

            case "loyalty" -> Enchantments.LOYALTY;
            case "impaling" -> Enchantments.IMPALING;
            case "riptide" -> Enchantments.RIPTIDE;
            case "channeling" -> Enchantments.CHANNELING;

            case "density" -> Enchantments.DENSITY;
            case "breach" -> Enchantments.BREACH;
            case "lunge" -> Enchantments.LUNGE;
            case "smite" -> Enchantments.SMITE;
            case "bane_of_arthropods" -> Enchantments.BANE_OF_ARTHROPODS;
            case "sweeping_edge" -> Enchantments.SWEEPING_EDGE;

            default -> throw new IllegalArgumentException("Encantamento não mapeado: " + enchantId);
        };
    }

    /*
     * Cria discos de música para a loja.
     *
     * Uso:
     * - itens cosméticos baratos (1 esmeralda)
     * - não afetam gameplay
     */
    private static ItemStack createMusicDisc(ShopEntry entry) {
        return switch (entry.id()) {
            case "music_13" -> new ItemStack(Items.MUSIC_DISC_13);
            case "music_cat" -> new ItemStack(Items.MUSIC_DISC_CAT);
            case "music_blocks" -> new ItemStack(Items.MUSIC_DISC_BLOCKS);
            case "music_chirp" -> new ItemStack(Items.MUSIC_DISC_CHIRP);
            case "music_far" -> new ItemStack(Items.MUSIC_DISC_FAR);
            case "music_mall" -> new ItemStack(Items.MUSIC_DISC_MALL);
            case "music_mellohi" -> new ItemStack(Items.MUSIC_DISC_MELLOHI);
            case "music_stal" -> new ItemStack(Items.MUSIC_DISC_STAL);
            case "music_strad" -> new ItemStack(Items.MUSIC_DISC_STRAD);
            case "music_ward" -> new ItemStack(Items.MUSIC_DISC_WARD);
            case "music_11" -> new ItemStack(Items.MUSIC_DISC_11);
            case "music_wait" -> new ItemStack(Items.MUSIC_DISC_WAIT);
            case "music_pigstep" -> new ItemStack(Items.MUSIC_DISC_PIGSTEP);
            case "music_otherside" -> new ItemStack(Items.MUSIC_DISC_OTHERSIDE);
            case "music_5" -> new ItemStack(Items.MUSIC_DISC_5);
            case "music_relic" -> new ItemStack(Items.MUSIC_DISC_RELIC);
            case "music_creator" -> new ItemStack(Items.MUSIC_DISC_CREATOR);
            case "music_creator_music_box" -> new ItemStack(Items.MUSIC_DISC_CREATOR_MUSIC_BOX);
            case "music_precipice" -> new ItemStack(Items.MUSIC_DISC_PRECIPICE);
            case "music_tears" -> new ItemStack(Items.MUSIC_DISC_TEARS);
            case "music_lava_chicken" -> new ItemStack(Items.MUSIC_DISC_LAVA_CHICKEN);
            default -> throw new IllegalArgumentException("Disco não suportado: " + entry.id());
        };
    }
}
