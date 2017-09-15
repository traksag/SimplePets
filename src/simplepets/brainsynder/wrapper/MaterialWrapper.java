//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package simplepets.brainsynder.wrapper;

import com.google.common.collect.Maps;
import org.bukkit.Material;
import simple.brainsynder.utils.ServerVersion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public enum MaterialWrapper {
    AIR(ServerVersion.v1_8_R3, 0),
    STONE(ServerVersion.v1_8_R3, 1),
    GRASS(ServerVersion.v1_8_R3, 2),
    DIRT(ServerVersion.v1_8_R3, 3),
    COBBLESTONE(ServerVersion.v1_8_R3, 4),
    WOOD(ServerVersion.v1_8_R3, 5),
    SAPLING(ServerVersion.v1_8_R3, 6),
    BEDROCK(ServerVersion.v1_8_R3, 7),
    WATER(ServerVersion.v1_8_R3, 8),
    STATIONARY_WATER(ServerVersion.v1_8_R3, 9),
    LAVA(ServerVersion.v1_8_R3, 10),
    STATIONARY_LAVA(ServerVersion.v1_8_R3, 11),
    SAND(ServerVersion.v1_8_R3, 12),
    GRAVEL(ServerVersion.v1_8_R3, 13),
    GOLD_ORE(ServerVersion.v1_8_R3, 14),
    IRON_ORE(ServerVersion.v1_8_R3, 15),
    COAL_ORE(ServerVersion.v1_8_R3, 16),
    LOG(ServerVersion.v1_8_R3, 17),
    LEAVES(ServerVersion.v1_8_R3, 18),
    SPONGE(ServerVersion.v1_8_R3, 19),
    GLASS(ServerVersion.v1_8_R3, 20),
    LAPIS_ORE(ServerVersion.v1_8_R3, 21),
    LAPIS_BLOCK(ServerVersion.v1_8_R3, 22),
    DISPENSER(ServerVersion.v1_8_R3, 23),
    SANDSTONE(ServerVersion.v1_8_R3, 24),
    NOTE_BLOCK(ServerVersion.v1_8_R3, 25),
    BED_BLOCK(ServerVersion.v1_8_R3, 26),
    POWERED_RAIL(ServerVersion.v1_8_R3, 27),
    DETECTOR_RAIL(ServerVersion.v1_8_R3, 28),
    PISTON_STICKY_BASE(ServerVersion.v1_8_R3, 29),
    WEB(ServerVersion.v1_8_R3, 30),
    LONG_GRASS(ServerVersion.v1_8_R3, 31),
    DEAD_BUSH(ServerVersion.v1_8_R3, 32),
    PISTON_BASE(ServerVersion.v1_8_R3, 33),
    PISTON_EXTENSION(ServerVersion.v1_8_R3, 34),
    WOOL(ServerVersion.v1_8_R3, 35),
    PISTON_MOVING_PIECE(ServerVersion.v1_8_R3, 36),
    YELLOW_FLOWER(ServerVersion.v1_8_R3, 37),
    RED_ROSE(ServerVersion.v1_8_R3, 38),
    BROWN_MUSHROOM(ServerVersion.v1_8_R3, 39),
    RED_MUSHROOM(ServerVersion.v1_8_R3, 40),
    GOLD_BLOCK(ServerVersion.v1_8_R3, 41),
    IRON_BLOCK(ServerVersion.v1_8_R3, 42),
    DOUBLE_STEP(ServerVersion.v1_8_R3, 43),
    STEP(ServerVersion.v1_8_R3, 44),
    BRICK(ServerVersion.v1_8_R3, 45),
    TNT(ServerVersion.v1_8_R3, 46),
    BOOKSHELF(ServerVersion.v1_8_R3, 47),
    MOSSY_COBBLESTONE(ServerVersion.v1_8_R3, 48),
    OBSIDIAN(ServerVersion.v1_8_R3, 49),
    TORCH(ServerVersion.v1_8_R3, 50),
    FIRE(ServerVersion.v1_8_R3, 51),
    MOB_SPAWNER(ServerVersion.v1_8_R3, 52),
    WOOD_STAIRS(ServerVersion.v1_8_R3, 53),
    CHEST(ServerVersion.v1_8_R3, 54),
    REDSTONE_WIRE(ServerVersion.v1_8_R3, 55),
    DIAMOND_ORE(ServerVersion.v1_8_R3, 56),
    DIAMOND_BLOCK(ServerVersion.v1_8_R3, 57),
    WORKBENCH(ServerVersion.v1_8_R3, 58),
    CROPS(ServerVersion.v1_8_R3, 59),
    SOIL(ServerVersion.v1_8_R3, 60),
    FURNACE(ServerVersion.v1_8_R3, 61),
    BURNING_FURNACE(ServerVersion.v1_8_R3, 62),
    SIGN_POST(ServerVersion.v1_8_R3, 63),
    WOODEN_DOOR(ServerVersion.v1_8_R3, 64),
    LADDER(ServerVersion.v1_8_R3, 65),
    RAILS(ServerVersion.v1_8_R3, 66),
    COBBLESTONE_STAIRS(ServerVersion.v1_8_R3, 67),
    WALL_SIGN(ServerVersion.v1_8_R3, 68),
    LEVER(ServerVersion.v1_8_R3, 69),
    STONE_PLATE(ServerVersion.v1_8_R3, 70),
    IRON_DOOR_BLOCK(ServerVersion.v1_8_R3, 71),
    WOOD_PLATE(ServerVersion.v1_8_R3, 72),
    REDSTONE_ORE(ServerVersion.v1_8_R3, 73),
    GLOWING_REDSTONE_ORE(ServerVersion.v1_8_R3, 74),
    REDSTONE_TORCH_OFF(ServerVersion.v1_8_R3, 75),
    REDSTONE_TORCH_ON(ServerVersion.v1_8_R3, 76),
    STONE_BUTTON(ServerVersion.v1_8_R3, 77),
    SNOW(ServerVersion.v1_8_R3, 78),
    ICE(ServerVersion.v1_8_R3, 79),
    SNOW_BLOCK(ServerVersion.v1_8_R3, 80),
    CACTUS(ServerVersion.v1_8_R3, 81),
    CLAY(ServerVersion.v1_8_R3, 82),
    SUGAR_CANE_BLOCK(ServerVersion.v1_8_R3, 83),
    JUKEBOX(ServerVersion.v1_8_R3, 84),
    FENCE(ServerVersion.v1_8_R3, 85),
    PUMPKIN(ServerVersion.v1_8_R3, 86),
    NETHERRACK(ServerVersion.v1_8_R3, 87),
    SOUL_SAND(ServerVersion.v1_8_R3, 88),
    GLOWSTONE(ServerVersion.v1_8_R3, 89),
    PORTAL(ServerVersion.v1_8_R3, 90),
    JACK_O_LANTERN(ServerVersion.v1_8_R3, 91),
    CAKE_BLOCK(ServerVersion.v1_8_R3, 92),
    DIODE_BLOCK_OFF(ServerVersion.v1_8_R3, 93),
    DIODE_BLOCK_ON(ServerVersion.v1_8_R3, 94),
    STAINED_GLASS(ServerVersion.v1_8_R3, 95),
    TRAP_DOOR(ServerVersion.v1_8_R3, 96),
    MONSTER_EGGS(ServerVersion.v1_8_R3, 97),
    SMOOTH_BRICK(ServerVersion.v1_8_R3, 98),
    HUGE_MUSHROOM_1(ServerVersion.v1_8_R3, 99),
    HUGE_MUSHROOM_2(ServerVersion.v1_8_R3, 100),
    IRON_FENCE(ServerVersion.v1_8_R3, 101),
    THIN_GLASS(ServerVersion.v1_8_R3, 102),
    MELON_BLOCK(ServerVersion.v1_8_R3, 103),
    PUMPKIN_STEM(ServerVersion.v1_8_R3, 104),
    MELON_STEM(ServerVersion.v1_8_R3, 105),
    VINE(ServerVersion.v1_8_R3, 106),
    FENCE_GATE(ServerVersion.v1_8_R3, 107),
    BRICK_STAIRS(ServerVersion.v1_8_R3, 108),
    SMOOTH_STAIRS(ServerVersion.v1_8_R3, 109),
    MYCEL(ServerVersion.v1_8_R3, 110),
    WATER_LILY(ServerVersion.v1_8_R3, 111),
    NETHER_BRICK(ServerVersion.v1_8_R3, 112),
    NETHER_FENCE(ServerVersion.v1_8_R3, 113),
    NETHER_BRICK_STAIRS(ServerVersion.v1_8_R3, 114),
    NETHER_WARTS(ServerVersion.v1_8_R3, 115),
    ENCHANTMENT_TABLE(ServerVersion.v1_8_R3, 116),
    BREWING_STAND(ServerVersion.v1_8_R3, 117),
    CAULDRON(ServerVersion.v1_8_R3, 118),
    ENDER_PORTAL(ServerVersion.v1_8_R3, 119),
    ENDER_PORTAL_FRAME(ServerVersion.v1_8_R3, 120),
    ENDER_STONE(ServerVersion.v1_8_R3, 121),
    DRAGON_EGG(ServerVersion.v1_8_R3, 122),
    REDSTONE_LAMP_OFF(ServerVersion.v1_8_R3, 123),
    REDSTONE_LAMP_ON(ServerVersion.v1_8_R3, 124),
    WOOD_DOUBLE_STEP(ServerVersion.v1_8_R3, 125),
    WOOD_STEP(ServerVersion.v1_8_R3, 126),
    COCOA(ServerVersion.v1_8_R3, 127),
    SANDSTONE_STAIRS(ServerVersion.v1_8_R3, 128),
    EMERALD_ORE(ServerVersion.v1_8_R3, 129),
    ENDER_CHEST(ServerVersion.v1_8_R3, 130),
    TRIPWIRE_HOOK(ServerVersion.v1_8_R3, 131),
    TRIPWIRE(ServerVersion.v1_8_R3, 132),
    EMERALD_BLOCK(ServerVersion.v1_8_R3, 133),
    SPRUCE_WOOD_STAIRS(ServerVersion.v1_8_R3, 134),
    BIRCH_WOOD_STAIRS(ServerVersion.v1_8_R3, 135),
    JUNGLE_WOOD_STAIRS(ServerVersion.v1_8_R3, 136),
    COMMAND(ServerVersion.v1_8_R3, 137),
    BEACON(ServerVersion.v1_8_R3, 138),
    COBBLE_WALL(ServerVersion.v1_8_R3, 139),
    FLOWER_POT(ServerVersion.v1_8_R3, 140),
    CARROT(ServerVersion.v1_8_R3, 141),
    POTATO(ServerVersion.v1_8_R3, 142),
    WOOD_BUTTON(ServerVersion.v1_8_R3, 143),
    SKULL(ServerVersion.v1_8_R3, 144),
    ANVIL(ServerVersion.v1_8_R3, 145),
    TRAPPED_CHEST(ServerVersion.v1_8_R3, 146),
    GOLD_PLATE(ServerVersion.v1_8_R3, 147),
    IRON_PLATE(ServerVersion.v1_8_R3, 148),
    REDSTONE_COMPARATOR_OFF(ServerVersion.v1_8_R3, 149),
    REDSTONE_COMPARATOR_ON(ServerVersion.v1_8_R3, 150),
    DAYLIGHT_DETECTOR(ServerVersion.v1_8_R3, 151),
    REDSTONE_BLOCK(ServerVersion.v1_8_R3, 152),
    QUARTZ_ORE(ServerVersion.v1_8_R3, 153),
    HOPPER(ServerVersion.v1_8_R3, 154),
    QUARTZ_BLOCK(ServerVersion.v1_8_R3, 155),
    QUARTZ_STAIRS(ServerVersion.v1_8_R3, 156),
    ACTIVATOR_RAIL(ServerVersion.v1_8_R3, 157),
    DROPPER(ServerVersion.v1_8_R3, 158),
    STAINED_CLAY(ServerVersion.v1_8_R3, 159),
    STAINED_GLASS_PANE(ServerVersion.v1_8_R3, 160),
    LEAVES_2(ServerVersion.v1_8_R3, 161),
    LOG_2(ServerVersion.v1_8_R3, 162),
    ACACIA_STAIRS(ServerVersion.v1_8_R3, 163),
    DARK_OAK_STAIRS(ServerVersion.v1_8_R3, 164),
    SLIME_BLOCK(ServerVersion.v1_8_R3, 165),
    BARRIER(ServerVersion.v1_8_R3, 166),
    IRON_TRAPDOOR(ServerVersion.v1_8_R3, 167),
    PRISMARINE(ServerVersion.v1_8_R3, 168),
    SEA_LANTERN(ServerVersion.v1_8_R3, 169),
    HAY_BLOCK(ServerVersion.v1_8_R3, 170),
    CARPET(ServerVersion.v1_8_R3, 171),
    HARD_CLAY(ServerVersion.v1_8_R3, 172),
    COAL_BLOCK(ServerVersion.v1_8_R3, 173),
    PACKED_ICE(ServerVersion.v1_8_R3, 174),
    DOUBLE_PLANT(ServerVersion.v1_8_R3, 175),
    STANDING_BANNER(ServerVersion.v1_8_R3, 176),
    WALL_BANNER(ServerVersion.v1_8_R3, 177),
    DAYLIGHT_DETECTOR_INVERTED(ServerVersion.v1_8_R3, 178),
    RED_SANDSTONE(ServerVersion.v1_8_R3, 179),
    RED_SANDSTONE_STAIRS(ServerVersion.v1_8_R3, 180),
    DOUBLE_STONE_SLAB2(ServerVersion.v1_8_R3, 181),
    STONE_SLAB2(ServerVersion.v1_8_R3, 182),
    SPRUCE_FENCE_GATE(ServerVersion.v1_8_R3, 183),
    BIRCH_FENCE_GATE(ServerVersion.v1_8_R3, 184),
    JUNGLE_FENCE_GATE(ServerVersion.v1_8_R3, 185),
    DARK_OAK_FENCE_GATE(ServerVersion.v1_8_R3, 186),
    ACACIA_FENCE_GATE(ServerVersion.v1_8_R3, 187),
    SPRUCE_FENCE(ServerVersion.v1_8_R3, 188),
    BIRCH_FENCE(ServerVersion.v1_8_R3, 189),
    JUNGLE_FENCE(ServerVersion.v1_8_R3, 190),
    DARK_OAK_FENCE(ServerVersion.v1_8_R3, 191),
    ACACIA_FENCE(ServerVersion.v1_8_R3, 192),
    SPRUCE_DOOR(ServerVersion.v1_8_R3, 193),
    BIRCH_DOOR(ServerVersion.v1_8_R3, 194),
    JUNGLE_DOOR(ServerVersion.v1_8_R3, 195),
    ACACIA_DOOR(ServerVersion.v1_8_R3, 196),
    DARK_OAK_DOOR(ServerVersion.v1_8_R3, 197),
    END_ROD(ServerVersion.v1_9_R1, 198),
    CHORUS_PLANT(ServerVersion.v1_9_R1, 199),
    CHORUS_FLOWER(ServerVersion.v1_9_R1, 200),
    PURPUR_BLOCK(ServerVersion.v1_9_R1, 201),
    PURPUR_PILLAR(ServerVersion.v1_9_R1, 202),
    PURPUR_STAIRS(ServerVersion.v1_9_R1, 203),
    PURPUR_DOUBLE_SLAB(ServerVersion.v1_9_R1, 204),
    PURPUR_SLAB(ServerVersion.v1_9_R1, 205),
    END_BRICKS(ServerVersion.v1_9_R1, 206),
    BEETROOT_BLOCK(ServerVersion.v1_9_R1, 207),
    GRASS_PATH(ServerVersion.v1_9_R1, 208),
    END_GATEWAY(ServerVersion.v1_9_R1, 209),
    COMMAND_REPEATING(ServerVersion.v1_9_R1, 210),
    COMMAND_CHAIN(ServerVersion.v1_9_R1, 211),
    FROSTED_ICE(ServerVersion.v1_9_R1, 212),
    MAGMA(ServerVersion.v1_10_R1, 213),
    NETHER_WART_BLOCK(ServerVersion.v1_10_R1, 214),
    RED_NETHER_BRICK(ServerVersion.v1_10_R1, 215),
    BONE_BLOCK(ServerVersion.v1_10_R1, 216),
    STRUCTURE_VOID(ServerVersion.v1_10_R1, 217),
    OBSERVER(ServerVersion.v1_11_R1, 218),
    WHITE_SHULKER_BOX(ServerVersion.v1_11_R1, 219),
    ORANGE_SHULKER_BOX(ServerVersion.v1_11_R1, 220),
    MAGENTA_SHULKER_BOX(ServerVersion.v1_11_R1, 221),
    LIGHT_BLUE_SHULKER_BOX(ServerVersion.v1_11_R1, 222),
    YELLOW_SHULKER_BOX(ServerVersion.v1_11_R1, 223),
    LIME_SHULKER_BOX(ServerVersion.v1_11_R1, 224),
    PINK_SHULKER_BOX(ServerVersion.v1_11_R1, 225),
    GRAY_SHULKER_BOX(ServerVersion.v1_11_R1, 226),
    SILVER_SHULKER_BOX(ServerVersion.v1_11_R1, 227),
    CYAN_SHULKER_BOX(ServerVersion.v1_11_R1, 228),
    PURPLE_SHULKER_BOX(ServerVersion.v1_11_R1, 229),
    BLUE_SHULKER_BOX(ServerVersion.v1_11_R1, 230),
    BROWN_SHULKER_BOX(ServerVersion.v1_11_R1, 231),
    GREEN_SHULKER_BOX(ServerVersion.v1_11_R1, 232),
    RED_SHULKER_BOX(ServerVersion.v1_11_R1, 233),
    BLACK_SHULKER_BOX(ServerVersion.v1_11_R1, 234),
    STRUCTURE_BLOCK(ServerVersion.v1_10_R1, 255),
    WHITE_GLAZED_TERRACOTTA(ServerVersion.v1_12_R1, 235),
    ORANGE_GLAZED_TERRACOTTA(ServerVersion.v1_12_R1, 236),
    MAGENTA_GLAZED_TERRACOTTA(ServerVersion.v1_12_R1, 237),
    LIGHT_BLUE_GLAZED_TERRACOTTA(ServerVersion.v1_12_R1, 238),
    YELLOW_GLAZED_TERRACOTTA(ServerVersion.v1_12_R1, 239),
    LIME_GLAZED_TERRACOTTA(ServerVersion.v1_12_R1, 240),
    PINK_GLAZED_TERRACOTTA(ServerVersion.v1_12_R1, 241),
    GRAY_GLAZED_TERRACOTTA(ServerVersion.v1_12_R1, 242),
    SILVER_GLAZED_TERRACOTTA(ServerVersion.v1_12_R1, 243),
    CYAN_GLAZED_TERRACOTTA(ServerVersion.v1_12_R1, 244),
    PURPLE_GLAZED_TERRACOTTA(ServerVersion.v1_12_R1, 245),
    BLUE_GLAZED_TERRACOTTA(ServerVersion.v1_12_R1, 246),
    BROWN_GLAZED_TERRACOTTA(ServerVersion.v1_12_R1, 247),
    GREEN_GLAZED_TERRACOTTA(ServerVersion.v1_12_R1, 248),
    RED_GLAZED_TERRACOTTA(ServerVersion.v1_12_R1, 249),
    BLACK_GLAZED_TERRACOTTA(ServerVersion.v1_12_R1, 250),
    CONCRETE(ServerVersion.v1_12_R1, 251),
    CONCRETE_POWDER(ServerVersion.v1_12_R1, 252),
    IRON_SPADE(ServerVersion.v1_8_R3, 256),
    IRON_PICKAXE(ServerVersion.v1_8_R3, 257),
    IRON_AXE(ServerVersion.v1_8_R3, 258),
    FLINT_AND_STEEL(ServerVersion.v1_8_R3, 259),
    APPLE(ServerVersion.v1_8_R3, 260),
    BOW(ServerVersion.v1_8_R3, 261),
    ARROW(ServerVersion.v1_8_R3, 262),
    COAL(ServerVersion.v1_8_R3, 263),
    DIAMOND(ServerVersion.v1_8_R3, 264),
    IRON_INGOT(ServerVersion.v1_8_R3, 265),
    GOLD_INGOT(ServerVersion.v1_8_R3, 266),
    IRON_SWORD(ServerVersion.v1_8_R3, 267),
    WOOD_SWORD(ServerVersion.v1_8_R3, 268),
    WOOD_SPADE(ServerVersion.v1_8_R3, 269),
    WOOD_PICKAXE(ServerVersion.v1_8_R3, 270),
    WOOD_AXE(ServerVersion.v1_8_R3, 271),
    STONE_SWORD(ServerVersion.v1_8_R3, 272),
    STONE_SPADE(ServerVersion.v1_8_R3, 273),
    STONE_PICKAXE(ServerVersion.v1_8_R3, 274),
    STONE_AXE(ServerVersion.v1_8_R3, 275),
    DIAMOND_SWORD(ServerVersion.v1_8_R3, 276),
    DIAMOND_SPADE(ServerVersion.v1_8_R3, 277),
    DIAMOND_PICKAXE(ServerVersion.v1_8_R3, 278),
    DIAMOND_AXE(ServerVersion.v1_8_R3, 279),
    STICK(ServerVersion.v1_8_R3, 280),
    BOWL(ServerVersion.v1_8_R3, 281),
    MUSHROOM_SOUP(ServerVersion.v1_8_R3, 282),
    GOLD_SWORD(ServerVersion.v1_8_R3, 283),
    GOLD_SPADE(ServerVersion.v1_8_R3, 284),
    GOLD_PICKAXE(ServerVersion.v1_8_R3, 285),
    GOLD_AXE(ServerVersion.v1_8_R3, 286),
    STRING(ServerVersion.v1_8_R3, 287),
    FEATHER(ServerVersion.v1_8_R3, 288),
    SULPHUR(ServerVersion.v1_8_R3, 289),
    WOOD_HOE(ServerVersion.v1_8_R3, 290),
    STONE_HOE(ServerVersion.v1_8_R3, 291),
    IRON_HOE(ServerVersion.v1_8_R3, 292),
    DIAMOND_HOE(ServerVersion.v1_8_R3, 293),
    GOLD_HOE(ServerVersion.v1_8_R3, 294),
    SEEDS(ServerVersion.v1_8_R3, 295),
    WHEAT(ServerVersion.v1_8_R3, 296),
    BREAD(ServerVersion.v1_8_R3, 297),
    LEATHER_HELMET(ServerVersion.v1_8_R3, 298),
    LEATHER_CHESTPLATE(ServerVersion.v1_8_R3, 299),
    LEATHER_LEGGINGS(ServerVersion.v1_8_R3, 300),
    LEATHER_BOOTS(ServerVersion.v1_8_R3, 301),
    CHAINMAIL_HELMET(ServerVersion.v1_8_R3, 302),
    CHAINMAIL_CHESTPLATE(ServerVersion.v1_8_R3, 303),
    CHAINMAIL_LEGGINGS(ServerVersion.v1_8_R3, 304),
    CHAINMAIL_BOOTS(ServerVersion.v1_8_R3, 305),
    IRON_HELMET(ServerVersion.v1_8_R3, 306),
    IRON_CHESTPLATE(ServerVersion.v1_8_R3, 307),
    IRON_LEGGINGS(ServerVersion.v1_8_R3, 308),
    IRON_BOOTS(ServerVersion.v1_8_R3, 309),
    DIAMOND_HELMET(ServerVersion.v1_8_R3, 310),
    DIAMOND_CHESTPLATE(ServerVersion.v1_8_R3, 311),
    DIAMOND_LEGGINGS(ServerVersion.v1_8_R3, 312),
    DIAMOND_BOOTS(ServerVersion.v1_8_R3, 313),
    GOLD_HELMET(ServerVersion.v1_8_R3, 314),
    GOLD_CHESTPLATE(ServerVersion.v1_8_R3, 315),
    GOLD_LEGGINGS(ServerVersion.v1_8_R3, 316),
    GOLD_BOOTS(ServerVersion.v1_8_R3, 317),
    FLINT(ServerVersion.v1_8_R3, 318),
    PORK(ServerVersion.v1_8_R3, 319),
    GRILLED_PORK(ServerVersion.v1_8_R3, 320),
    PAINTING(ServerVersion.v1_8_R3, 321),
    GOLDEN_APPLE(ServerVersion.v1_8_R3, 322),
    SIGN(ServerVersion.v1_8_R3, 323),
    WOOD_DOOR(ServerVersion.v1_8_R3, 324),
    BUCKET(ServerVersion.v1_8_R3, 325),
    WATER_BUCKET(ServerVersion.v1_8_R3, 326),
    LAVA_BUCKET(ServerVersion.v1_8_R3, 327),
    MINECART(ServerVersion.v1_8_R3, 328),
    SADDLE(ServerVersion.v1_8_R3, 329),
    IRON_DOOR(ServerVersion.v1_8_R3, 330),
    REDSTONE(ServerVersion.v1_8_R3, 331),
    SNOW_BALL(ServerVersion.v1_8_R3, 332),
    BOAT(ServerVersion.v1_8_R3, 333),
    LEATHER(ServerVersion.v1_8_R3, 334),
    MILK_BUCKET(ServerVersion.v1_8_R3, 335),
    CLAY_BRICK(ServerVersion.v1_8_R3, 336),
    CLAY_BALL(ServerVersion.v1_8_R3, 337),
    SUGAR_CANE(ServerVersion.v1_8_R3, 338),
    PAPER(ServerVersion.v1_8_R3, 339),
    BOOK(ServerVersion.v1_8_R3, 340),
    SLIME_BALL(ServerVersion.v1_8_R3, 341),
    STORAGE_MINECART(ServerVersion.v1_8_R3, 342),
    POWERED_MINECART(ServerVersion.v1_8_R3, 343),
    EGG(ServerVersion.v1_8_R3, 344),
    COMPASS(ServerVersion.v1_8_R3, 345),
    FISHING_ROD(ServerVersion.v1_8_R3, 346),
    WATCH(ServerVersion.v1_8_R3, 347),
    GLOWSTONE_DUST(ServerVersion.v1_8_R3, 348),
    RAW_FISH(ServerVersion.v1_8_R3, 349),
    COOKED_FISH(ServerVersion.v1_8_R3, 350),
    INK_SACK(ServerVersion.v1_8_R3, 351),
    BONE(ServerVersion.v1_8_R3, 352),
    SUGAR(ServerVersion.v1_8_R3, 353),
    CAKE(ServerVersion.v1_8_R3, 354),
    BED(ServerVersion.v1_8_R3, 355),
    DIODE(ServerVersion.v1_8_R3, 356),
    COOKIE(ServerVersion.v1_8_R3, 357),
    MAP(ServerVersion.v1_8_R3, 358),
    SHEARS(ServerVersion.v1_8_R3, 359),
    MELON(ServerVersion.v1_8_R3, 360),
    PUMPKIN_SEEDS(ServerVersion.v1_8_R3, 361),
    MELON_SEEDS(ServerVersion.v1_8_R3, 362),
    RAW_BEEF(ServerVersion.v1_8_R3, 363),
    COOKED_BEEF(ServerVersion.v1_8_R3, 364),
    RAW_CHICKEN(ServerVersion.v1_8_R3, 365),
    COOKED_CHICKEN(ServerVersion.v1_8_R3, 366),
    ROTTEN_FLESH(ServerVersion.v1_8_R3, 367),
    ENDER_PEARL(ServerVersion.v1_8_R3, 368),
    BLAZE_ROD(ServerVersion.v1_8_R3, 369),
    GHAST_TEAR(ServerVersion.v1_8_R3, 370),
    GOLD_NUGGET(ServerVersion.v1_8_R3, 371),
    NETHER_STALK(ServerVersion.v1_8_R3, 372),
    POTION(ServerVersion.v1_8_R3, 373),
    GLASS_BOTTLE(ServerVersion.v1_8_R3, 374),
    SPIDER_EYE(ServerVersion.v1_8_R3, 375),
    FERMENTED_SPIDER_EYE(ServerVersion.v1_8_R3, 376),
    BLAZE_POWDER(ServerVersion.v1_8_R3, 377),
    MAGMA_CREAM(ServerVersion.v1_8_R3, 378),
    BREWING_STAND_ITEM(ServerVersion.v1_8_R3, 379),
    CAULDRON_ITEM(ServerVersion.v1_8_R3, 380),
    EYE_OF_ENDER(ServerVersion.v1_8_R3, 381),
    SPECKLED_MELON(ServerVersion.v1_8_R3, 382),
    MONSTER_EGG(ServerVersion.v1_8_R3, 383),
    EXP_BOTTLE(ServerVersion.v1_8_R3, 384),
    FIREBALL(ServerVersion.v1_8_R3, 385),
    BOOK_AND_QUILL(ServerVersion.v1_8_R3, 386),
    WRITTEN_BOOK(ServerVersion.v1_8_R3, 387),
    EMERALD(ServerVersion.v1_8_R3, 388),
    ITEM_FRAME(ServerVersion.v1_8_R3, 389),
    FLOWER_POT_ITEM(ServerVersion.v1_8_R3, 390),
    CARROT_ITEM(ServerVersion.v1_8_R3, 391),
    POTATO_ITEM(ServerVersion.v1_8_R3, 392),
    BAKED_POTATO(ServerVersion.v1_8_R3, 393),
    POISONOUS_POTATO(ServerVersion.v1_8_R3, 394),
    EMPTY_MAP(ServerVersion.v1_8_R3, 395),
    GOLDEN_CARROT(ServerVersion.v1_8_R3, 396),
    SKULL_ITEM(ServerVersion.v1_8_R3, 397),
    CARROT_STICK(ServerVersion.v1_8_R3, 398),
    NETHER_STAR(ServerVersion.v1_8_R3, 399),
    PUMPKIN_PIE(ServerVersion.v1_8_R3, 400),
    FIREWORK(ServerVersion.v1_8_R3, 401),
    FIREWORK_CHARGE(ServerVersion.v1_8_R3, 402),
    ENCHANTED_BOOK(ServerVersion.v1_8_R3, 403),
    REDSTONE_COMPARATOR(ServerVersion.v1_8_R3, 404),
    NETHER_BRICK_ITEM(ServerVersion.v1_8_R3, 405),
    QUARTZ(ServerVersion.v1_8_R3, 406),
    EXPLOSIVE_MINECART(ServerVersion.v1_8_R3, 407),
    HOPPER_MINECART(ServerVersion.v1_8_R3, 408),
    PRISMARINE_SHARD(ServerVersion.v1_8_R3, 409),
    PRISMARINE_CRYSTALS(ServerVersion.v1_8_R3, 410),
    RABBIT(ServerVersion.v1_8_R3, 411),
    COOKED_RABBIT(ServerVersion.v1_8_R3, 412),
    RABBIT_STEW(ServerVersion.v1_8_R3, 413),
    RABBIT_FOOT(ServerVersion.v1_8_R3, 414),
    RABBIT_HIDE(ServerVersion.v1_8_R3, 415),
    ARMOR_STAND(ServerVersion.v1_8_R3, 416),
    IRON_BARDING(ServerVersion.v1_8_R3, 417),
    GOLD_BARDING(ServerVersion.v1_8_R3, 418),
    DIAMOND_BARDING(ServerVersion.v1_8_R3, 419),
    LEASH(ServerVersion.v1_8_R3, 420),
    NAME_TAG(ServerVersion.v1_8_R3, 421),
    COMMAND_MINECART(ServerVersion.v1_8_R3, 422),
    MUTTON(ServerVersion.v1_8_R3, 423),
    COOKED_MUTTON(ServerVersion.v1_8_R3, 424),
    BANNER(ServerVersion.v1_8_R3, 425),
    END_CRYSTAL(ServerVersion.v1_8_R3, 426),
    SPRUCE_DOOR_ITEM(ServerVersion.v1_8_R3, 427),
    BIRCH_DOOR_ITEM(ServerVersion.v1_8_R3, 428),
    JUNGLE_DOOR_ITEM(ServerVersion.v1_8_R3, 429),
    ACACIA_DOOR_ITEM(ServerVersion.v1_8_R3, 430),
    DARK_OAK_DOOR_ITEM(ServerVersion.v1_8_R3, 431),
    CHORUS_FRUIT(ServerVersion.v1_9_R1, 432),
    CHORUS_FRUIT_POPPED(ServerVersion.v1_9_R1, 433),
    BEETROOT(ServerVersion.v1_9_R1, 434),
    BEETROOT_SEEDS(ServerVersion.v1_9_R1, 435),
    BEETROOT_SOUP(ServerVersion.v1_9_R1, 436),
    DRAGONS_BREATH(ServerVersion.v1_9_R1, 437),
    SPLASH_POTION(ServerVersion.v1_8_R3, 438),
    SPECTRAL_ARROW(ServerVersion.v1_9_R1, 439),
    TIPPED_ARROW(ServerVersion.v1_9_R1, 440),
    LINGERING_POTION(ServerVersion.v1_9_R1, 441),
    SHIELD(ServerVersion.v1_9_R1, 442),
    ELYTRA(ServerVersion.v1_9_R1, 443),
    BOAT_SPRUCE(ServerVersion.v1_8_R3, 444),
    BOAT_BIRCH(ServerVersion.v1_8_R3, 445),
    BOAT_JUNGLE(ServerVersion.v1_8_R3, 446),
    BOAT_ACACIA(ServerVersion.v1_8_R3, 447),
    BOAT_DARK_OAK(ServerVersion.v1_8_R3, 448),
    TOTEM(ServerVersion.v1_11_R1, 449),
    SHULKER_SHELL(ServerVersion.v1_11_R1, 450),
    KNOWLEDGE_BOOK(ServerVersion.v1_12_R1, 453),
    GOLD_RECORD(ServerVersion.v1_8_R3, 2256),
    GREEN_RECORD(ServerVersion.v1_8_R3, 2257),
    RECORD_3(ServerVersion.v1_8_R3, 2258),
    RECORD_4(ServerVersion.v1_8_R3, 2259),
    RECORD_5(ServerVersion.v1_8_R3, 2260),
    RECORD_6(ServerVersion.v1_8_R3, 2261),
    RECORD_7(ServerVersion.v1_8_R3, 2262),
    RECORD_8(ServerVersion.v1_8_R3, 2263),
    RECORD_9(ServerVersion.v1_8_R3, 2264),
    RECORD_10(ServerVersion.v1_8_R3, 2265),
    RECORD_11(ServerVersion.v1_8_R3, 2266),
    RECORD_12(ServerVersion.v1_8_R3, 2267),
    NOT_SUPPORTED(ServerVersion.UNKNOWN, -1);

    private static final Map<String, MaterialWrapper> BY_NAME = Maps.newHashMap();
    private static final Map<Integer, MaterialWrapper> BY_ID = Maps.newHashMap();

    static {
        for (MaterialWrapper materialWrapper : values()) {
            BY_NAME.put(materialWrapper.name(), materialWrapper);
            BY_ID.put(materialWrapper.id, materialWrapper);
        }
    }

    private final int id;
    private final ServerVersion supportedVersion;

    MaterialWrapper(ServerVersion supportedVersion, int id) {
        this.id = id;
        this.supportedVersion = supportedVersion;
    }

    public static List<MaterialWrapper> forServerVersion() {
        List<MaterialWrapper> list = new ArrayList<>();
        int version = ServerVersion.getVersion().getIntVersion();
        for (MaterialWrapper wrapper : values()) {
            if (wrapper.supportedVersion.getIntVersion() <= version) list.add(wrapper);
        }
        return list;
    }

    public static MaterialWrapper fromMaterial(Material material) {
        try {
            return MaterialWrapper.valueOf(material.name());
        } catch (Exception ignored) {
        }
        return NOT_SUPPORTED;
    }

    public static MaterialWrapper fromID(int id) {
        if (BY_ID.containsKey(id))
            return BY_ID.get(id);
        return NOT_SUPPORTED;
    }

    public static MaterialWrapper fromName(String name) {
        if (BY_NAME.containsKey(name))
            return BY_NAME.get(name);
        return NOT_SUPPORTED;
    }

    public static MaterialWrapper fromIDName(Object value) {
        try {
            int id = Integer.parseInt(String.valueOf(value));
            return fromID(id);
        } catch (NumberFormatException e) {
            return fromName(String.valueOf(value));
        }
    }

    public ServerVersion getSupportedVersion() {
        return supportedVersion;
    }

    public int getId() {
        return this.id;
    }

    public Material toMaterial() {
        try {
            if (supportedVersion.getIntVersion() <= ServerVersion.getVersion().getIntVersion()) {
                return Material.valueOf(name());
            }
        } catch (Exception ignored) {
        }
        return Material.AIR;
    }
}
