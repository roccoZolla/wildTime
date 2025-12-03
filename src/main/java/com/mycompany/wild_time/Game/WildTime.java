///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.mycompany.wild_time.Game;
//
//import com.mycompany.wild_time.Utils.Utils;
//import com.mycompany.wild_time.Command.Command;
//import com.mycompany.wild_time.Command.CommandType;
//import com.mycompany.wild_time.Type.Conversation;
//import com.mycompany.wild_time.Type.Npc;
//import com.mycompany.wild_time.Type.Player;
//import com.mycompany.wild_time.Type.Item;
//import com.mycompany.wild_time.Type.Room;
//
///**
// *
// * @author rocco
// */
//public class WildTime extends Game {
//    public WildTime() {
//        super();
//    }
//
//    @Override
//    public void init() {
//        // set title
//        setTitle("Wild Time");
//
//        // ----- COMANDI -----
//        Command nord = new Command(CommandType.NORD, "nord");
//        nord.setAlias(new String[]{"n", "N", "Nord", "NORD"});
//
//        Command inventory = new Command(CommandType.INVENTORY, "zaino");
//        inventory.setAlias(new String[]{"inv", "inventario"});
//
//        Command sud = new Command(CommandType.SOUTH, "sud");
//        sud.setAlias(new String[]{"s", "S", "Sud", "SUD"});
//
//        Command est = new Command(CommandType.EAST, "est");
//        est.setAlias(new String[]{"e", "E", "Est", "EST"});
//
//        Command ovest = new Command(CommandType.WEST, "ovest");
//        ovest.setAlias(new String[]{"o", "O", "Ovest", "OVEST"});
//
//        Command end = new Command(CommandType.END, "end");
//        end.setAlias(new String[]{"end", "fine", "esci", "muori", "ammazzati", "ucciditi", "suicidati", "exit"});
//
//        Command look = new Command(CommandType.LOOK_AT, "osserva");
//        look.setAlias(new String[]{"guarda", "vedi", "cerca"});
//
//        Command pickup = new Command(CommandType.PICK_UP, "raccogli");
//        pickup.setAlias(new String[]{"prendi"});
//
//        Command open = new Command(CommandType.OPEN, "apri");
//        open.setAlias(new String[]{});
//
//        Command save = new Command(CommandType.SAVE, "salva");
//        save.setAlias(new String[]{});
//
//        Command clean = new Command(CommandType.CLEAN, "pulisci");
//        clean.setAlias(new String[]{"igienizza", "lava"});
//
//        Command talk = new Command(CommandType.TALK_TO, "parla");
//        talk.setAlias(new String[]{"chiacchiera"});
//
//        Command eat = new Command(CommandType.EAT, "mangia");
//        eat.setAlias(new String[]{"bevi", "assumi"});
//
//        Command equip = new Command(CommandType.EQUIP, "equipaggia");
//        equip.setAlias(new String[]{"arma", "metti"});
//
//        Command attack = new Command(CommandType.ATTACK, "attacca");
//        attack.setAlias(new String[]{"combatti", "lotta"});
//
//        Command leaves = new Command(CommandType.THROW, "lascia");
//        leaves.setAlias(new String[]{"butta", "getta", "lancia"});
//
//        Command use = new Command(CommandType.USE, "usa");
//        use.setAlias(new String[]{"use", "utilizza"});
//
//        Command help = new Command(CommandType.HELP, "aiuto");
//        help.setAlias(new String[]{"comandi", "guida"});
//
//        Utils.addObjects(this.getCommands(),
//                nord, sud, est, ovest,
//                inventory, help, use, leaves,
//                attack, equip, eat, talk,
//                clean, save, open, pickup,
//                look, end);
//
//        // ----- OGGETTI -----
//        // armi
//        Item oldSword = new Item();
//        oldSword.setId(1);
//        oldSword.setName("vecchia_spada");
//        oldSword.setDescription("Spada che da sempre ti accompagna nelle tue avventure");
//        oldSword.setTakeable(true);
//        oldSword.setUseable(true);
//        oldSword.setIsWeapon(true);
//        oldSword.setAttackDamage(10);
//
//        Item sword = new Item();
//        sword.setId(2);
//        sword.setName("spada");
//        sword.setDescription("Spada affilata. Ottima per affrontare gli scocciatori");
//        sword.setTakeable(true);
//        sword.setUseable(true);
//        sword.setIsWeapon(true);
//        sword.setAttackDamage(15);
//
//        Item bigSword = new Item();
//        bigSword.setId(3);
//        bigSword.setName("granspada");
//        bigSword.setDescription("Spada con una lama piu grande. Piu pesante ma anche piu potente");
//        bigSword.setTakeable(true);
//        bigSword.setUseable(true);
//        bigSword.setIsWeapon(true);
//        bigSword.setAttackDamage(20);
//
//        Item leggendarySword = new Item();
//        leggendarySword.setId(4);
//        leggendarySword.setName("spada_leggendaria");
//        leggendarySword.setDescription("Spada le cui origini si perdono nel tempo. Avvolta da un'aura misteriosa è in grado di tagliare qualsiasi cosa. Forgiata con lo scudo.");
//        leggendarySword.setTakeable(true);
//        leggendarySword.setUseable(true);
//        leggendarySword.setIsWeapon(true);
//        leggendarySword.setAttackDamage(30);
//
//
//        // scudi
//        Item oldShield = new Item();
//        oldShield.setId(5);
//        oldShield.setName("vecchio_scudo");
//        oldShield.setDescription("Scudo che da sempre ti accompagna nelle tue avventure");
//        oldShield.setTakeable(true);
//        oldShield.setUseable(true);
//        oldShield.setIsWeapon(true);
//        oldShield.setDefenseBonus(10);
//
//        Item shield = new Item();
//        shield.setId(6);
//        shield.setName("scudo");
//        shield.setDescription("Scudo di metallo, ottimo per incassare colpi di spada");
//        shield.setTakeable(true);
//        shield.setUseable(true);
//        shield.setIsWeapon(true);
//        shield.setDefenseBonus(15);
//
//        Item bigShield = new Item();
//        bigShield.setId(7);
//        bigShield.setName("grandscudo");
//        bigShield.setDescription("Scudo piu grande, realizzato con un metallo piu resistente");
//        bigShield.setTakeable(true);
//        bigShield.setUseable(true);
//        bigShield.setIsWeapon(true);
//        bigShield.setDefenseBonus(20);
//
//        Item leggendaryShield = new Item();
//        leggendaryShield.setId(8);
//        leggendaryShield.setName("scudo_leggendario");
//        leggendaryShield.setDescription("Scudo le cui origini si perdono nel tempo. Avvolto da un'aura misteriosa è in grado di resistere a qualsiasi cosa. Forgiato con la spada");
//        leggendaryShield.setTakeable(true);
//        leggendaryShield.setUseable(true);
//        leggendaryShield.setIsWeapon(true);
//        leggendaryShield.setDefenseBonus(10);
//
//
//        // curativi
//        Item apple = new Item();
//        apple.setName("mela");
//        apple.setDescription("Mela rossa di stagione. Restituisce 10 HP.");
//        apple.setId(9);
//        apple.setTakeable(true);
//        apple.setUseable(true);
//        apple.setIsHeal(true);
//        apple.setBonus(10);
//
//        Item sandwich = new Item();
//        sandwich.setName("tramezzino");
//        sandwich.setDescription("Un semplice tramezzino. Restituisce 10 HP.");
//        sandwich.setId(10);
//        sandwich.setTakeable(true);
//        sandwich.setUseable(true);
//        sandwich.setIsHeal(true);
//        sandwich.setBonus(10);
//
//        Item redPotion = new Item();
//        redPotion.setName("pozione_rossa");
//        redPotion.setDescription("Pozione di colore rosso, ha strani effetti sul corpo."
//                + "Restituisce 15 HP.");
//        redPotion.setId(11);
//        redPotion.setTakeable(true);
//        redPotion.setUseable(true);
//        redPotion.setIsHeal(true);
//        redPotion.setBonus(15);
//
//        Item bluePotion = new Item();
//        bluePotion.setName("pozione_blu");
//        bluePotion.setDescription("Pozione di colore blu, ha strani effetti sul corpo."
//                + "Restituisce 20 HP.");
//        bluePotion.setId(12);
//        bluePotion.setTakeable(true);
//        bluePotion.setUseable(true);
//        bluePotion.setIsHeal(true);
//        bluePotion.setBonus(10);
//
//        Item superPotion = new Item();
//        superPotion.setName("super_pozione");
//        superPotion.setDescription("Pozione misteriosa preparata dal leggendario maestro muten, ha strani effetti sul corpo."
//                + "Restituisce 30 HP.");
//        superPotion.setId(13);
//        superPotion.setTakeable(true);
//        superPotion.setUseable(true);
//        superPotion.setIsHeal(true);
//        superPotion.setBonus(10);
//
//        // power up
//        Item yellowPotion = new Item();
//        yellowPotion.setName("pozione_gialla");
//        yellowPotion.setDescription("Pozione di colore giallo, ha strani effetti sulle spade."
//                + "Aumenta la potenza di attacco di 10.");
//        yellowPotion.setId(14);
//        yellowPotion.setTakeable(true);
//        yellowPotion.setUseable(true);
//        yellowPotion.setIsPowerUp(true);
//        yellowPotion.setIsWeapon(true);
//        yellowPotion.setAttackDamage(10);
//
//        Item greenPotion = new Item();
//        greenPotion.setName("pozione_verde");
//        greenPotion.setDescription("Pozione di colore verde, ha strani effetti sugli scudi."
//                + "Aumenta la difesa di uno scudo di 10.");
//        greenPotion.setId(15);
//        greenPotion.setTakeable(true);
//        greenPotion.setUseable(true);
//        greenPotion.setIsPowerUp(true);
//        greenPotion.setIsWeapon(true);
//        greenPotion.setDefenseBonus(10);
//
//        Item spinach = new Item();
//        spinach.setName("spinaci");
//        spinach.setDescription("Spinaci. Fanno bene. Aumenta la salute massima di 10 HP.");
//        spinach.setId(16);
//        spinach.setTakeable(true);
//        spinach.setUseable(true);
//        spinach.setIsPowerUp(true);
//        spinach.setIsWeapon(false);
//        spinach.setBonus(10);
//
//        Item amberPotion = new Item();
//        amberPotion.setName("pozione_ambra");
//        amberPotion.setDescription("Pozione di color ambra, ha strani effetti sulle spade."
//                + "Aumenta la potenza di attacco di 15.");
//        amberPotion.setId(17);
//        amberPotion.setTakeable(true);
//        amberPotion.setUseable(true);
//        amberPotion.setIsPowerUp(true);
//        amberPotion.setIsWeapon(true);
//        amberPotion.setAttackDamage(15);
//
//        Item emeraldPotion = new Item();
//        emeraldPotion.setName("pozione_smeraldo");
//        emeraldPotion.setDescription("Pozione di colore verde smeraldo, ha strani effetti sugli scudi."
//                + "Aumenta la difesa di uno scudo di 15.");
//        emeraldPotion.setId(18);
//        emeraldPotion.setTakeable(true);
//        emeraldPotion.setUseable(true);
//        emeraldPotion.setIsPowerUp(true);
//        emeraldPotion.setIsWeapon(true);
//        emeraldPotion.setDefenseBonus(15);
//
//        Item parmigiana = new Item();
//        parmigiana.setName("parmigiana");
//        parmigiana.setDescription("Pietanza mistica in grado di sfamare intere popolazioni con una sola porzione."
//                + "Ricca di gusto, aumenta la salute massima di 20 HP");
//        parmigiana.setId(19);
//        parmigiana.setTakeable(true);
//        parmigiana.setUseable(true);
//        parmigiana.setIsPowerUp(true);
//        parmigiana.setIsWeapon(false);
//        parmigiana.setBonus(20);
//
//
//        // oggetti -chiave-
//        Item strangeKey = new Item();
//        strangeKey.setName("chiave_strana");
//        strangeKey.setDescription("Strana chiave, puo servire ad aprire qualcosa... Ha un odore che ricorda quello di una palude...");
//        strangeKey.setId(20);
//        strangeKey.setTakeable(true);
//        strangeKey.setUseable(true);
//
//        Item rockyKey = new Item();
//        rockyKey.setName("chiave_rocciosa");
//        rockyKey.setDescription("Chiave rocciosa, puo servire ad aprire qualcosa... Sembra provenire da un monte...");
//        rockyKey.setId(21);
//        rockyKey.setTakeable(true);
//        rockyKey.setUseable(true);
//
//        Item shears = new Item();
//        shears.setName("cesoie");
//        shears.setDescription("Semplici cesoie, c'è qualcosa da tagliare qui nei dintorni?");
//        shears.setId(22);
//        shears.setTakeable(true);
//        shears.setUseable(true);
//
//        Item littleBoat = new Item();
//        littleBoat.setName("piccola_barca");
//        littleBoat.setDescription("Piccola barchetta di legno, a cosa servira mai?");
//        littleBoat.setId(23);
//        littleBoat.setTakeable(true);
//        littleBoat.setUseable(true);
//
//        Item timeGear = new Item();
//        timeGear.setName("ingranaggio_del_tempo");
//        timeGear.setDescription("Ingraggio che governa la vita di queste terre. Chi lo possiede ha il potere di modificare lo scorrere del tempo fino a fermarlo.");
//        timeGear.setId(24);
//        timeGear.setTakeable(true);
//        timeGear.setUseable(true);
//
//        // oggetti random
//        Item oldBook = new Item();
//        oldBook.setName("vecchio_libro");
//        oldBook.setDescription("Non molto utile. Sembra raccontare la storia della Vecchia Dinastia.");
//        oldBook.setId(25);
//        oldBook.setTakeable(true);
//        oldBook.setUseable(true);
//
//        Item brokenWand = new Item();
//        brokenWand.setName("bacchetta_rotta");
//        brokenWand.setDescription("Non molto utile. Bacchetta usata in passato da una vecchia strega che abitava la palude.");
//        brokenWand.setId(26);
//        brokenWand.setTakeable(true);
//        brokenWand.setUseable(true);
//
//        Item grapplingHook = new Item();
//        grapplingHook.setName("rampino");
//        grapplingHook.setDescription("Non molto utile. Sembra sia appartenuto ad un esploratore del passato che non è riuscito a scalare la scalinata.");
//        grapplingHook.setId(27);
//        grapplingHook.setTakeable(true);
//        grapplingHook.setUseable(true);
//
//        // armi nemici
//        // scagnozzo 1
//        Item henchmanSword1 = new Item();
//        henchmanSword1.setId(28);
//        henchmanSword1.setName("vecchia_spada1");
//        henchmanSword1.setDescription("Vecchia spada. Data ai piu incapaci della banda.");
//        henchmanSword1.setTakeable(true);
//        henchmanSword1.setUseable(true);
//        henchmanSword1.setIsWeapon(true);
//        henchmanSword1.setAttackDamage(10);
//
//        Item henchmanShield1 = new Item();
//        henchmanShield1.setId(29);
//        henchmanShield1.setName("vecchio_scudo1");
//        henchmanShield1.setDescription("Vecchio scudo. Dato ai piu incapaci della banda.");
//        henchmanShield1.setTakeable(true);
//        henchmanShield1.setUseable(true);
//        henchmanShield1.setIsWeapon(true);
//        henchmanShield1.setDefenseBonus(10);
//
//
//        // scagnozzo 2
//        Item henchmanSword2 = new Item();
//        henchmanSword2.setId(30);
//        henchmanSword2.setName("spada1");
//        henchmanSword2.setDescription("Spada. Data agli incapaci un po piu capaci della banda.");
//        henchmanSword2.setTakeable(true);
//        henchmanSword2.setUseable(true);
//        henchmanSword2.setIsWeapon(true);
//        henchmanSword2.setAttackDamage(15);
//
//        Item henchmanShield2 = new Item();
//        henchmanShield2.setId(31);
//        henchmanShield2.setName("scudo1");
//        henchmanShield2.setDescription("Scudo. Dato agli incapaci un po piu capaci della banda.");
//        henchmanShield2.setTakeable(true);
//        henchmanShield2.setUseable(true);
//        henchmanShield2.setIsWeapon(true);
//        henchmanShield2.setDefenseBonus(15);
//
//        // colei che sa
//        Item magicBranch = new Item();
//        magicBranch.setId(32);
//        magicBranch.setName("ramo_maledetto");
//        magicBranch.setDescription("Dato che lo spirito di ColeiCheSa è intrappolato in un albero, si è dovuta adattare"
//                + "per poter attaccare le persone. Maledicendo un ramo e usandolo come arma...");
//        magicBranch.setTakeable(true);
//        magicBranch.setUseable(true);
//        magicBranch.setIsWeapon(true);
//        magicBranch.setAttackDamage(22);
//
//        Item foliageShield = new Item();
//        foliageShield.setId(33);
//        foliageShield.setName("chioma_scudo");
//        foliageShield.setDescription("Dato che lo spirito di ColeiCheSa è intrappolato in un albero, si è dovuta adattare"
//                + "per potersi difendere dalle minacce esterne. Maledicendo la chioma dell'albero e difendosi con essa...");
//        foliageShield.setTakeable(true);
//        foliageShield.setUseable(true);
//        foliageShield.setIsWeapon(true);
//        foliageShield.setDefenseBonus(20);
//
//        // doffy
//        Item doffySword = new Item();
//        doffySword.setId(34);
//        doffySword.setName("spada_Doflamingo");
//        doffySword.setDescription("Spada la cui lama è il risultato dell'intreccio di miglialia di fili.\n"
//                + "Nonostante l'aspetto è una spada molto pericolosa");
//        doffySword.setTakeable(true);
//        doffySword.setUseable(true);
//        doffySword.setIsWeapon(true);
//        doffySword.setAttackDamage(22);
//
//        Item doffyShield = new Item();
//        doffyShield.setId(35);
//        doffyShield.setName("scudo_Doflamingo");
//        doffyShield.setDescription("Scudo composto da un miglialio di fili intrecciati."
//                + "Molto resistente al pari di un granscudo");
//        doffyShield.setTakeable(true);
//        doffyShield.setUseable(true);
//        doffyShield.setIsWeapon(true);
//        doffyShield.setDefenseBonus(20);
//
//        // lucci
//        Item lucciClaw = new Item();
//        lucciClaw.setId(36);
//        lucciClaw.setName("artiglio_affilato");
//        lucciClaw.setDescription("Artiglio molto piu affilato e resistente di una spada. Sembra che Lucci sia in"
//                + "grado di produrli...");
//        lucciClaw.setTakeable(true);
//        lucciClaw.setUseable(true);
//        lucciClaw.setIsWeapon(true);
//        lucciClaw.setAttackDamage(25);
//
//        Item lucciShield = new Item();
//        lucciShield.setId(37);
//        lucciShield.setName("scudo_leopardo");
//        lucciShield.setDescription("Non è un vero e proprio scudo. Sembra che lucci sia in grado di indurire alcune"
//                + "parti del proprio corpo e utilizarle come scudo...");
//        lucciShield.setTakeable(true);
//        lucciShield.setUseable(true);
//        lucciShield.setIsWeapon(true);
//        lucciShield.setDefenseBonus(25);
//
//        Utils.addObjects(this.getItems(), oldSword, sword, bigSword, leggendarySword,
//                oldShield, shield, bigShield, leggendaryShield,
//                apple, sandwich, redPotion, bluePotion, superPotion,
//                yellowPotion, greenPotion, spinach, amberPotion, emeraldPotion, parmigiana,
//                strangeKey, rockyKey, shears, littleBoat, timeGear,
//                oldBook, brokenWand, grapplingHook,
//                henchmanSword1, henchmanShield1, henchmanSword2, henchmanShield2,
//                magicBranch, foliageShield, doffySword, doffyShield,
//                lucciClaw, lucciShield);
//
//        // ----- DEFINIZIONE DEI LUOGHI -----
//        // stanza di partenza del gioco 0 - FORESTA BIANCA
//        Room whiteForest = new Room("Foresta Bianca");
//        whiteForest.setId(0);
//        whiteForest.setDescription("Sei un mercenario giunto nelle terre misteriose di Ooo mandato da un re, di una terra vicina, preoccupato che venga rubato il misterioso ingranaggio del tempo,"
//                + "un congegno che regola lo scorrere del tempo di queste terre che se rubato potrebbe causare il fermarsi del normale flusso del tempo bloccando la vita di queste terre."
//                + "Sembra essere diventato l'obiettivo della banda che da tempo governa questa terra. Il re ha parlato di un certo Rob Lucci, uomo a capo della banda del tempo.\n"
//                + "Il tuo obiettivo è fermare Rob Lucci, ma dove si trovera? Che la caccia abbia inizio!"
//                + "\n\nSei giunto nella FORESTA BIANCA, luogo di ingresso per chiunque voglia visitare le terre di Ooo, "
//                + "una foresta tanto bella quanto ingannevole per via del suo aspetto bianco e puro, cosa si celera in questa foresta? Sembra che ci sia qualcuno... forse sarebbe una buona idea "
//                + "PARLARE con questo strano_viandante...\n");
//
//        // stanza 1 - SENTIERO PER LA FORESTA BIANCA
//        Room whitePath = new Room("Sentiero per la Foresta Bianca");
//        whitePath.setName("Sentiero per la Foresta Bianca");
//        whitePath.setId(1);
//        whitePath.setDescription("Il cosidetto SENTIERO PER LA FORESTA BIANCA, nome alquanto esplicativo, è la strada che ti conduce alla foresta. E' un semplice sentiero."
//                + "Da qui pero è possibile raggiungere altre zone di questa terra, come ad esempio il mercato ad est e la palude ad ovest.\n");
//
//        // stanza 2 - PALUDE STRANA
//        Room weirdSwamp = new Room("Palude Strana");
//        weirdSwamp.setId(2);
//        weirdSwamp.setDescription("La PALUDE STRANA, un luogo avvolto nel mistero dove per qualche strano motivo la gente del posto sostiene di sentire delle voci,"
//                + "dei sussuri che hanno fatto impazzire chiunque provasse ad addentrarsi nella palude. E' un fenomeno che ormai tartassa la popolazione da decenni..."
//                + "Cosa sarà mai?"
//                + "Pero, per quanto avvolta nel mistero, è pur sempre una palude, attenzione a non sporcarti di fango.\n");
//
//        // stanza 3 - COLLINA DEI SUSSURI
//        Room whisperingHill = new Room("Collina dei Sussurri");
//        whisperingHill.setId(3);
//        whisperingHill.setDescription("Sei giunto nella COLLINA DEI SUSSURI, luogo tanto temuto quanto strano, in quanto popolato da un solo albero sulla sommita della collina."
//                + "E' un albero particolare perche, nonostante abbia il tronco ormai seccato, ha una folta chioma di foglie verdi; inoltre sembra che i sussurri provengano proprio da li...\n");
//        whisperingHill.setBlocked(true);
//        whisperingHill.setOpenWith(shears);
//
//
//        // stanza 4 - MERCATO DEI NOMADI
//        Room nomadMarket = new Room("Mercato dei Nomadi");
//        nomadMarket.setId(4);
//        nomadMarket.setDescription("Sei giunto nel MERCATO DEI NOMADI. Questo è il luogo piu esotico e al tempo stesso caotico di queste terre. Nonostante siano nomadi, si dice che basti"
//                + "fare la domanda giusta al giusto mercante e si puo ottenere qualsiasi cosa. Sarà vero o sarà la solita pubblicita ingannevole dei mercanti?\n");
//
//        // stanza 5 - STRADA MALMESSA
//        Room roughStreet = new Room("Strada Malmessa");
//        roughStreet.setId(5);
//        roughStreet.setDescription("Sei giunto alla STRADA MALMESSA. Deve il suo nome a tutti i governanti che in passato hanno promesso di ripararla, ma alla fine è rimasta cosi com'è...malmessa."
//                + "Cosi come ogni luogo caduto nel dimencatoio, anche questo sembra essere popolato da gente non proprio tranquilla... E' un crocevia in quanto collega il palazzo del tempo, il piccolo lago"
//                + "e il burron.\n");
//
//        // stanza 6 - PICCOLO LAGO
//        Room smallLake = new Room("Piccolo Lago");
//        smallLake.setId(6);
//        smallLake.setDescription("Sei al PICCOLO LAGO, unico specchio d'acqua di queste terre. Stando alla gente del luogo sembra che ci sia un rospo in grado di parlare..."
//                + "Cosa avrà mai da dire un rospo? Ma, poi, sarà vero?\n");
//
//        // STANZA 7 - CASA SUL PICCOLO LAGO
//        Room houseLake = new Room("Casa sul Piccolo Lago");
//        houseLake.setId(7);
//        houseLake.setDescription("Dopo aver recuperato la barchetta dal saggio rospetto, sei giunto alla CASA SUL PICCOLO LAGO. Una casa in mezzo al nulla di cui non si è mai accorto nessuno.\n"
//                + "Sarà abitata? Perche nessuno si è mai accorto di una casa in mezzo al lago?");
//        houseLake.setBlocked(true);
//        houseLake.setOpenWith(littleBoat);
//
//        // STANZA 8 - BURRONE
//        Room ravine = new Room("Burrone");
//        ravine.setId(8);
//        ravine.setDescription("Un BURRONE. Nient'altro da aggiungere.\n");
//
//        // STANZA 9 - AVAMPOSTO DELLA BANDA
//        Room gangOutpost = new Room("Avamposto della Banda");
//        gangOutpost.setId(9);
//        gangOutpost.setDescription("Dopo aver girato a lungo, sei giunto finalmente nell'AVAMPOSTO DELLA BANDA che presiede il quartier generale, il Palazzo del Tempo. Questo è un luogo popolato"
//                + "dagli scagnozzi della banda ma nonostante la 'sicurezza', sembra sia molto facile passare... In ogni caso occhi aperti!\n");
//
//        // stanza 10 - PALAZZO DEL TEMPO
//        Room timePalace = new Room("Palazzo del Tempo");
//        timePalace.setId(10);
//        timePalace.setDescription("Sei giunto al PALAZZO DEL TEMPO. In passato era il luogo in cui veniva custodito l'ingranaggio del tempo e sede della Vecchia Dinastia."
//                + "Poco prima che la dinastia precedente venisse fatta cadere per mano di un giovane e ambizioso Lucci,"
//                + "l'ingranaggio fu spostato in una localita tutt'ora segreta. "
//                + "Adesso è diventato il quartier generale della banda ed è presieduto dal temibile vicecapo, Doffy, che sembra avere qualche sorta di potere, stai attento...\n");
//
//        // stanza 11 - SCALINATA RIPIDA
//        Room steepStairway = new Room("Scalinata Ripida");
//        steepStairway.setId(11);
//        steepStairway.setDescription("Sei giunto alla SCALINATA RIPIDA. Da qui puoi raggiungere i posti sacri di queste terre. "
//                + "E' cosi ripida che sembra sia il versante stesso della montagna, ma da queste parti si dice che solo"
//                + "colui che vuole vedere il mondo sia in grado di scalarla. Chissa come sara la vista lassu...\n");
//
//        // stanza 12 - COLLINA DELLA SAPIENZA
//        Room knowledgeHill = new Room("Altopiano della Sapienza");
//        knowledgeHill.setId(12);
//        knowledgeHill.setDescription("Sei giunto all'ALTOPIANO DELLA SAPIENZA. Per la grande vista sul mondo di 'sotto' e l'essere cosi vicino ai confini del 'cielo',"
//                + " la gente del posto crede che sia in grado di conferirti conoscenza"
//                + "e saggiezza. Stando ad alcune voci, qui dovrebbe abitarci"
//                + " un vecchio maestro di arti marziali con il suo allievo. Avranno avuto anche loro conoscenza e saggezza da questo posto?\n");
//
//        // stanza 13 - MONTE TEMPO
//        Room timeMountain = new Room("Monte Tempo");
//        timeMountain.setId(13);
//        timeMountain.setDescription("Sei giunto (finalmente) al MONTE TEMPO. La montagna piu alta di queste terre. Qui lo scorrere del tempo sembra scorrere in maniera diversa da quando un giovane ragazzo,"
//                + " membro della dinastia caduta di queste terre, ha fatto visita alla cima di questo monte."
//                + " Che si tratti dell'Ingranaggio del Tempo?\n");
//
//        // stanza FINALE 14 - GROTTA DELLA MEMORIA - STANZA FINALE
//        Room memoryCave = new Room("Grotta della Memoria");
//        memoryCave.setId(14);
//        memoryCave.setDescription("Sei giunto alla GROTTA DELLA MEMORIA, il luogo piu sacro di tutte le terre di Ooo. Qui il tempo sembra non scorrere. Chiunque abbia mai provato ad entrare ha raccontato"
//                + " di come i suoi ricordi fossero diventati vivi e una volta uscito si ricordava perfettamente ogni"
//                + "singolo momento della sua vita. Ed è proprio qui che sembra essere giunto Lucci, sai gia qual'è il tuo compito, è il momento di concludere questa caccia!\n");
//        memoryCave.setFinal(true);
//
//        // foresta bianca
//        whiteForest.setNord(whitePath); // sentiero
//
//        // sentiero per la foresta bianca
//        whitePath.setSud(whiteForest);  // foresta
//        whitePath.setEst(nomadMarket);  // mercato
//        whitePath.setOvest(weirdSwamp); // palude
//
//        // palude strana
//        weirdSwamp.setSud(whisperingHill); // collina
//        weirdSwamp.setEst(whitePath);      // sentiero
//
//        // collina dei susssurri
//        whisperingHill.setNord(weirdSwamp); // palude
//
//        // mercato dei nomadi
//        nomadMarket.setEst(roughStreet);    // strada malmessa
//        nomadMarket.setOvest(whitePath);    // sentiero
//
//        // strada malmessa
//        roughStreet.setNord(gangOutpost);  // avamposto banda
//        roughStreet.setSud(smallLake);       // piccolo lago
//        roughStreet.setEst(ravine);      // burrone
//        roughStreet.setOvest(nomadMarket);    // mercato dei nomadi
//
//        // piccolo lago
//        smallLake.setNord(roughStreet);      // strada
//        smallLake.setSud(houseLake);         // casa di jiraya
//
//        // piccolo lago
//        houseLake.setNord(smallLake);
//
//        // burrone
//        ravine.setOvest(roughStreet);   // strada
//
//        // avamposto della banda
//        gangOutpost.setSud(roughStreet);     // strada
//        gangOutpost.setEst(timePalace);                // palazzo tempo
//        gangOutpost.setOvest(steepStairway);              // scalinata
//
//        // palazzo del tempo
//        timePalace.setOvest(gangOutpost);
//
//        // scalinata ripida
//        steepStairway.setNord(timeMountain);               // monte tempo
//        steepStairway.setEst(gangOutpost);     // avamposto
//        steepStairway.setOvest(knowledgeHill);              // collina della sapienza
//
//        // collina della sapienza
//        knowledgeHill.setEst(steepStairway);
//
//        // monte tempo
//        timeMountain.setSud(steepStairway);
//        timeMountain.setEst(memoryCave);
//
//        // grotta della memoria
//        memoryCave.setOvest(timeMountain);
//
//        // ----- AGGIUNTA OGGETTI NEL MONDO DI GIOCO -----
//
//        whiteForest.getItems().add(apple);
//        whiteForest.getItems().add(strangeKey);
//        whitePath.getItems().add(shears);
//        weirdSwamp.getItems().add(brokenWand);
//        nomadMarket.getItems().add(sandwich);
//        ravine.getItems().add(rockyKey);
//        ravine.getItems().add(spinach);
//        smallLake.getItems().add(littleBoat);
//        houseLake.getItems().add(parmigiana);
//        timePalace.getItems().add(amberPotion);
//        timePalace.getItems().add(oldBook);
//        steepStairway.getItems().add(emeraldPotion);
//        steepStairway.getItems().add(grapplingHook);
//        knowledgeHill.getItems().add(superPotion);
//
//        // ----- DEFINIZIONE DELLE CASSE -----
//        // cassa della Palude Strana -> strana chiave
//        weirdSwamp.getChest().setName("cassa_paludosa");
//        weirdSwamp.getChest().setOpenWith(strangeKey);
//        weirdSwamp.getChest().setIsOpen(false);
//        weirdSwamp.getChest().getList().add(redPotion);
//        weirdSwamp.getChest().getList().add(sword);
//        weirdSwamp.getChest().getList().add(shield);
//
//        // cassa del Monte tempo -> chiave rocciosa
//        timeMountain.getChest().setName("cassa_rocciosa");
//        timeMountain.getChest().setOpenWith(rockyKey);
//        timeMountain.getChest().setIsOpen(false);
//        timeMountain.getChest().getList().add(bluePotion);
//        timeMountain.getChest().getList().add(bigSword);
//        timeMountain.getChest().getList().add(bigShield);
//
//        getItems().add(weirdSwamp.getChest());
//        getItems().add(timeMountain.getChest());
//
//
//        // ----- PERSONAGGI -----
//        Player geralt = new Player();
//        geralt.setHp(30);
//        geralt.setMaxHP(30);
//        geralt.setName("Geralt");
//        geralt.setArma(oldSword);
//        geralt.setScudo(oldShield);
//
//        this.setCurrentPlace(whiteForest);
//        this.setPlayer(geralt);
//
//        // ---- NPC ----
//        // tizio del tutorial
//        Npc strangeTraveler = new Npc();
//        strangeTraveler.setHp(20);
//        strangeTraveler.setName("strano_viandante");
//        strangeTraveler.setTalk("Sei nuovo da queste parti vero?\n");
//        strangeTraveler.setDescription("Viandante dall'aspetto trasandato che se ne sta ai piedi"
//                + "di un fuoco semi accesso. Sembra abbia qualcosa di interessante da dire...\n");
//
//        Conversation constr = new Conversation();
//        constr.setQuestion("chi sei?");
//        constr.setAnswer("Sono qualcuno che potrebbe aiutarti nell'attraversare queste terre tanto belle quanto pericolose."
//                + "Cosa vuoi sapere?\n");
//
//        Conversation constr2 = new Conversation();
//        constr2.setQuestion("cosa posso fare?");
//        constr2.setAnswer("Sai hai bisogno di aiuto, puoi digitare il comando aiuto e avrai risposta ad ogni tua domanda\n");
//
//        Conversation constr3 = new Conversation();
//        constr3.setQuestion("cosa sai di queste terre?");
//        constr3.setAnswer("Non molto in verita, mercenario. Sono terre misteriose in cui strani fatti avvengono.\n");
//
//        Conversation constr4 = new Conversation();
//        constr4.setQuestion("cosa sai della banda del tempo?");
//        constr4.setAnswer("Governano queste terre da ormai un decina d'anni, da quando un giovanissimo lucci da solo ha messo fuori l'intera dinastia precedente"
//                + "assicurandosi un posto nel Palazzo del Tempo. Ci penserei due volte prima di avvicinarmi...\n");
//
//        Utils.addObjects(strangeTraveler.getConversation(), constr, constr2, constr3, constr4);
//
//        //////////////////////////////
//        Npc scaredBoy = new Npc();
//        scaredBoy.setHp(20);
//        scaredBoy.setName("renato_spaventato");
//        scaredBoy.setTalk("Dall'aspetto sembri un mercenario. Ho bisogno di aiuto. Sento provenire delle voci"
//                + "dalla parte sud della Palude.\n");
//        scaredBoy.setDescription("Renato Spaventato, un ragazzino spaventato -ma tu guarda un po- dopo che ha provato ad addentrarsi nella parte sud della palude strana."
//                + "Preso per pazzo dalla gente del posto forse non sarebbe una cattiva idea parlarci...\n");
//
//        Conversation convBoy1 = new Conversation();
//        convBoy1.setQuestion("cosa è successo?");
//        convBoy1.setAnswer("Ho provato ad addentrarmi con mia sorella nella palude qui a est ma andando avanti ho sentito delle voci, dei sussurri nella mia testa."
//                + "Stavo impazzendo... Mia sorella si trova ancora li, ma ho paura...\n");
//
//        Conversation convBoy2 = new Conversation();
//        convBoy2.setQuestion("sai qualcosa sulla banda del tempo?");
//        convBoy2.setAnswer("Quello che so è che controllano il palazzo del tempo e presiedere il palazzo c'è tipo un avamposto. Non so altro mercenario!\n");
//
//        Utils.addObjects(scaredBoy.getConversation(), convBoy1, convBoy2);
//
//        //////////////////////////////////
//        Npc scaredWoman = new Npc();
//        scaredWoman.setHp(20);
//        scaredWoman.setName("rita_l'impaurita");
//        scaredWoman.setTalk("Salve mercenario...\n");
//        scaredWoman.setDescription("Rita l'impaurita, sorella di Renato. Anche lei sostiene di aver sentito delle voci, ma c'è qualcosa di diverso in lei...\n");
//
//        Conversation conWom1 = new Conversation();
//        conWom1.setQuestion("perche sei qui da sola?");
//        conWom1.setAnswer("Stavo facendo una passeggiata...\n");
//
//        Conversation conWom2 = new Conversation();
//        conWom2.setQuestion("tuo fratello è preoccupato");
//        conWom2.setAnswer("Stavo facendo una passeggiata...\n");
//
//        Conversation conWom3 = new Conversation();
//        conWom3.setQuestion("da dove provengono le voci?");
//        conWom3.setAnswer("-indica il sud della palude ma sembra che siano delle piante da quella parte-\n");
//
//        Utils.addObjects(scaredWoman.getConversation(), conWom1, conWom2, conWom3);
//
//        //////////////////////////////////
//        Npc merchant = new Npc();
//        merchant.setHp(20);
//        merchant.setName("tino_cre");
//        merchant.setTalk("Salve viadante io sono Tino Cre, sono un nomade mercante o un mercante nomade dipende\n");
//        merchant.setDescription("Mercante nomade che si ritrova sempre in queste lande misteriose vendendo robaccia e cianfrusaglie che trova in giro. Sembra essere bravo nel suo mestiere pero...\n");
//
//        Conversation conMer1 = new Conversation();
//        conMer1.setQuestion("cosa vendi?");
//        conMer1.setAnswer("C'è chi direbbe che io vendo sogni, ma io non vendo sogni ma solide realta."
//                + "-sembra abbia disegnato un cerchio intorno a se stesso-\n");
//
//        Conversation conMer2 = new Conversation();
//        conMer2.setQuestion("perche sei qui?");
//        conMer2.setAnswer("Necessita lavorative, nella mia terra natale non navighiamo di certo nell'oro...\n");
//
//        Conversation conMer3 = new Conversation();
//        conMer3.setQuestion("parlami della banda del tempo");
//        conMer3.setAnswer("Vedo che vai subito al sodo... Il vicecapo, Doffy, so che puo controllare i fili e so anche che è lui che presiede il"
//                + "Palazzo del Tempo, quando il boss non c'è. Questo è tutto cio che so.\n");
//
//        Conversation conMer4 = new Conversation();
//        conMer4.setQuestion("come ci arrivo?");
//        conMer4.setAnswer("Si trova a nord della Strada Malmessa a est di qui. Ma fa attenzione agli scagnozzi della banda.\n");
//
//        Utils.addObjects(merchant.getConversation(), conMer1, conMer2, conMer3, conMer4);
//
//        //////////////////////////////////
//
//        Npc littleFrog = new Npc();
//        littleFrog.setHp(20);
//        littleFrog.setName("rospetto1");
//        littleFrog.setTalk("Crack mercenario! Mi chiamo Gamabunta crack!\n");
//        littleFrog.setDescription("Rospetto che si atteggia a vecchio maestro, forse sara"
//                + "per quel lungo pizzetto bianco.\n");
//
//        Npc littleFrog2 = new Npc();
//        littleFrog2.setHp(20);
//        littleFrog2.setName("rospetto2");
//        littleFrog2.setTalk("Crack mercenario! Mi chiamo Gamabunta crack!\n");
//        littleFrog2.setDescription("Rospetto che si atteggia a vecchio maestro, forse sara"
//                + "per quel lungo pizzetto bianco.\n");
//
//        Npc littleFrog3 = new Npc();
//        littleFrog3.setHp(20);
//        littleFrog3.setName("rospetto3");
//        littleFrog3.setTalk("Crack mercenario! Mi chiamo Gamabunta crack!\n");
//        littleFrog3.setDescription("Rospetto che si atteggia a vecchio maestro, forse sara"
//                + "per quel lungo pizzetto bianco.\n");
//
//        Conversation conFrog3_1 = new Conversation();
//        conFrog3_1.setQuestion("perche puoi parlare?");
//        conFrog3_1.setAnswer("Crack! Mai sentito parlare di tecniche ninja? Crack!\n");
//
//        Conversation conFrog3_2 = new Conversation();
//        conFrog3_2.setQuestion("si puo attraversare il lago?");
//        conFrog3_2.setAnswer("Crack! Sembra non ti si possa nascondere nulla! Crack!"
//                + "Con la piccola barca che è qui Crack!, con questa puoi vedere cosa realmente Crack! cela il piccolo lago di Ooo. Crack!\n");
//
//        Conversation conFrog3_3 = new Conversation();
//        conFrog3_3.setQuestion("parlami della banda del tempo");
//        conFrog3_3.setAnswer("Crack! Tutto quello che so è che il capo non si trova al Palazzo del tempo a nord di qui. Crack!\n");
//
//        Utils.addObjects(littleFrog3.getConversation(), conFrog3_1, conFrog3_2, conFrog3_3);
//
//        /////////////////////////////////
//
//        Npc jiraya = new Npc();
//        jiraya.setHp(20);
//        jiraya.setName("eremita_dei_rospi");
//        jiraya.setTalk("Dall'aspetto sembri un mercenario, come hai fatto a raggiungermi?\n");
//        jiraya.setDescription("Si dice sia originario di un villaggio molto lontano che ha come simbolo una foglia.\n");
//
//        Conversation conJiraya = new Conversation();
//        conJiraya.setQuestion("il tuo rospo non brilla per intelligenza");
//        conJiraya.setAnswer("Ah, vecchio Gamabunta...dovrei mandarti in pensione...");
//
//        Conversation conJiraya2 = new Conversation();
//        conJiraya2.setQuestion("chi sei?");
//        conJiraya2.setAnswer("Molti mi chiamano Eremita dei rospi, ma puoi anche chiamarmi Jiraya.");
//
//        Conversation conJiraya3 = new Conversation();
//        conJiraya3.setQuestion("perche non vedevo la casa?");
//        conJiraya3.setAnswer("Immagino tu non abbia mai sentito parlare di tecniche illusorie ninja...");
//
//        Conversation conJiraya4 = new Conversation();
//        conJiraya4.setQuestion("perche sei qui?");
//        conJiraya4.setAnswer("E' l'unico posto in cui Lucci non puo trovarmi. Ho provato a fermarlo in passato ma non è andata bene. Adesso sto cercando un modo per sconfiggerlo...");
//
//        Conversation conJiraya5 = new Conversation();
//        conJiraya5.setQuestion("dove puo essere lucci?");
//        conJiraya5.setAnswer("Dirigiti al MONTE TEMPO, a nord della SCALINATA RIPIDA. Una volta arrivato li saprai dove andare.\n");
//
//        Utils.addObjects(jiraya.getConversation(),
//                conJiraya, conJiraya2, conJiraya3, conJiraya4, conJiraya5);
//
//        /////////////////////////////////
//
//        Npc explorer = new Npc();
//        explorer.setHp(20);
//        explorer.setName("nathan");
//        explorer.setTalk("Finalmente qualcuno che vuole assaporare il rischio qui alla SCALINATA RIPIDA!\n");
//        explorer.setDescription("Si definisce esploratore e pronipote di sir Francis Drake,"
//                + "in realta è solo un ladro a cui piace rischiare la propria vita\n");
//
//        Conversation conExp = new Conversation();
//        conExp.setQuestion("sono qui per altro");
//        conExp.setAnswer("Non c'è bisogno di scaldarsi...\n");
//
//        Conversation conExp2 = new Conversation();
//        conExp2.setQuestion("parlami della banda del tempo");
//        conExp2.setAnswer("Sono stanco di quella banda di pagliacci, che andassero al diavolo. So solo che il loro stupido capo animalesco stia cercando"
//                + "una sorta di ingranaggio da queste parti, ma non so dove possa trovarsi...\n");
//
//        Conversation conExp3 = new Conversation();
//        conExp3.setQuestion("animalesco?");
//        conExp3.setAnswer("Si dice che abbia il potere di trasformarsi in un leopardo acquisendo le migliori qualita di quell'animale...\n");
//
//        Utils.addObjects(explorer.getConversation(),
//                conExp, conExp2, conExp3);
//
//        /////////////////////////////////
//
//        Npc oldMan = new Npc();
//        oldMan.setHp(30);
//        oldMan.setName("maestro_muten");
//        oldMan.setTalk("Salve mercenario io sono Muten e sono un maestro d'arti maziali!");
//        oldMan.setDescription("Si fa chiamare anche Genio delle Tartarughe di mare e si definisce un"
//                + "povero vecchietto che si gode le sue strane riviste e quando vede uno straniero"
//                + "improvvisa una mossa con le mani che lo fa sembrare solo un vecchio pazzo\n");
//
//        Conversation conOld = new Conversation();
//        conOld.setQuestion("perche sei qui?");
//        conOld.setAnswer("Questa collina puo essere raggiunta solo da spiriti impavidi che non hanno paura del rischio. Sono questi gli allievi che cerco.\n");
//
//        Conversation conOld1 = new Conversation();
//        conOld.setQuestion("la vecchia dinastia");
//        conOld.setAnswer("La vecchia dinastia era una famiglia di persone dotate non solo di poteri speciali ma anche di buon cuore, hanno sempre fatto il possibile"
//                + "per garantire il benessere di queste terre tanto misteriose quanto magiche.\n");
//
//        Conversation conOld2 = new Conversation();
//        conOld2.setQuestion("l'ingranaggio del tempo");
//        conOld2.setAnswer("Strano congegno la cui origine si perde nella notte dei tempi, non si sa perche si trovi in queste terre. Quello che so per certo è che non"
//                + "deve cadere nelle mani di Lucci, va al Monte Tempo!\n");
//
//        Utils.addObjects(oldMan.getConversation(),
//                conOld, conOld1, conOld2);
//
//        /////////////////////////////////
//
//        // abitanti random
//        Npc tizio = new Npc();
//        tizio.setHp(20);
//        tizio.setName("tizio");
//        tizio.setTalk("....che seccatura....che....seccatura....\n");
//        tizio.setDescription("Un tizio che abita queste terre. Sembra seccato, non credo parlagli sia una buona idea...\n");
//
//        Npc mercanteRandom = new Npc();
//        mercanteRandom.setHp(20);
//        mercanteRandom.setName("mercante_urlante");
//        mercanteRandom.setTalk("SCONTI SU TUTTA LA MERCE, PRENDI 2 PAGHI 3. VENGHINO SIGNORI VENGHINO!!!\n");
//        mercanteRandom.setDescription("Mercante del mercato dei Nomadi. Sembra non convenga fare affare con lui...\n");
//
//        Npc mercanteRandom2 = new Npc();
//        mercanteRandom2.setHp(20);
//        mercanteRandom2.setName("mercante_curioso");
//        mercanteRandom2.setTalk("...sembra sia possibile...il piccolo lago...tre rospi...uno parla pure....una casa sull'acqua.....\n");
//        mercanteRandom2.setDescription("Mercante del mercato dei Nomadi. Sembra abbia scoperto qualcosa...\n");
//
//        Npc angryWoman = new Npc();
//        angryWoman.setHp(20);
//        angryWoman.setName("donna_arrabbiata");
//        angryWoman.setTalk("Questi pagliacci della banda del tempo hanno veramente rotto le scatole...\n");
//        angryWoman.setDescription("Donna arrabiata. Sembra non essere molto contenta di essere governata da questi tizi...\n");
//
//        Npc sonGoku = new Npc();
//        sonGoku.setHp(20);
//        sonGoku.setName("allievo_del_maestro");
//        sonGoku.setTalk("...Devo continuare ad allenarmi se voglio diventare il guerriero piu forte di queste terre...\n");
//        sonGoku.setDescription("Allievo del maestro. Ha una strana coda che ricorda quella di una scimmia...\n");
//
//        Npc servant = new Npc();
//        servant.setHp(20);
//        servant.setName("vecchio_servitore");
//        servant.setTalk("Ti prego mercenario liberaci da questa condanna!\n");
//        servant.setDescription("Fedele servitore della Vecchia Dinastia. Da quando è caduta, è diventato lo schiavo personale di Doffy.\n");
//
//        Npc sleepyHenchman = new Npc();
//        sleepyHenchman.setHp(20);
//        sleepyHenchman.setName("scagnozzo_dormiente");
//        sleepyHenchman.setTalk("...ZzzZZz...fermo mercenario...zzzZZ..zZZ..\n");
//        sleepyHenchman.setDescription("Scagnozzo della Banda del Tempo. Sta dormendo, non ci perderei tempo...\n");
//
//
//        // ----- ENEMIES -----
//        // COLEI CHE SA - MINIBOSS
//        Npc sheWhoKnows = new Npc();
//        sheWhoKnows.setIsEnemy(true);
//        sheWhoKnows.setHp(40);
//        sheWhoKnows.setName("colei_che_sa");
//        sheWhoKnows.setTalk("IO SONO LA SOVRANA DI QUESTO REGNO CHI OSA INVADERE LA MIA TERRA\n");
//        sheWhoKnows.setDescription("In un tempo assai remoto, era la sovrana incontrasta di questa terra. Un giorno fu imprigionata"
//                + "dalle figlie all'interno della collina. Da allora la collina fu chiamata Dei Sussurri"
//                + " perche chiunque provi ad avvicinarsi sente delle voci nella testa e impazzisce.\n");
//        sheWhoKnows.setArma(magicBranch);
//        sheWhoKnows.setScudo(foliageShield);
//        sheWhoKnows.setReward(leggendaryShield);
//
//        // SCAGNOZZO 1
//        Npc henchman1 = new Npc();
//        henchman1.setIsEnemy(true);
//        henchman1.setHp(25);
//        henchman1.setName("scagnozzo1");
//        henchman1.setTalk("Attento mercenario sappiamo perche sei qui!\n");
//        henchman1.setDescription("E' comparso scagnozzo1 selvatico!"
//                + "Talmente mediocri che anche loro si chiedono perche lucci li abbia assoldati...\n");
//        henchman1.setArma(henchmanSword1);
//        henchman1.setScudo(henchmanSword1);
//        henchman1.setReward(yellowPotion);
//
//        // SCAGNOZZO 2
//        Npc henchman2 = new Npc();
//        henchman2.setIsEnemy(true);
//        henchman2.setHp(25);
//        henchman2.setName("scagnozzo2");
//        henchman2.setTalk("Attento mercenario sappiamo perche sei qui!\n");
//        henchman2.setDescription("E' comparso scagnozzo2 selvatico!"
//                + "Talmente mediocri che anche loro si chiedono perche lucci li abbia assoldati...\n");
//        henchman2.setArma(henchmanSword2);
//        henchman2.setScudo(henchmanSword2);
//        henchman2.setReward(greenPotion);
//
//        // VICE CAPO DELLA BANDA - MINIBOSS
//        Npc deputyBoss = new Npc();
//        deputyBoss.setIsEnemy(true);
//        deputyBoss.setHp(45);
//        deputyBoss.setName("doffy");
//        deputyBoss.setTalk("Alla fine il mercenario assoldato per sgominarci è finalmente giunto! NON VEDO L'ORA DI SCOPRIRE COSA VUOI FARE AHAHAH\n");
//        deputyBoss.setDescription("Vice capo della banda del tempo, ha una strana passione per la moda"
//                + "dal momento che se ne va in giro con un pellicciotto rosa e degli occhialetti da sole"
//                + "abbastanza discutibili. Al di la della moda, si dice che sia in grado di controllare i fili...\n");
//        deputyBoss.setArma(doffySword);
//        deputyBoss.setScudo(doffyShield);
//        deputyBoss.setReward(leggendarySword);
//
//        // BOSS DELLA BANDA
//        Npc boss = new Npc();
//        boss.setIsEnemy(true);
//        boss.setHp(60);
//        boss.setName("rob_lucci");
//        boss.setTalk("Chi osa distubarmi?\n");
//        boss.setDescription("Capo della banda del tempo, colui che, da solo, all'eta di 16 anni ha spazzato via la vecchia dinastia. Temutissimo, ormai da dieci anni domina"
//                + "queste terre. Si dice sia in grado di sfruttare i poteri di un leopardo...\n");
//        boss.setReward(timeGear);
//        boss.setArma(lucciClaw);
//        boss.setScudo(lucciShield);
//
//        Conversation conLucci = new Conversation();
//        conLucci.setQuestion("quali sono le tue reali intenzioni?");
//        conLucci.setAnswer("Certo che ne hai di coraggio da vendere mercenario! Voglio poter controllare il tempo!\n");
//
//        Conversation conLucci1 = new Conversation();
//        conLucci1.setQuestion("perche?");
//        conLucci1.setAnswer("Mi chiede perche quando la risposta gia la sai... Sarei infermabile, potrei avere potere su tutto!\n");
//
//        boss.getConversation().add(conLucci);
//        boss.getConversation().add(conLucci1);
//
//        ////////////////////////////////
//        // aggiungi npc ai luoghi
//        Utils.addObjects(whiteForest.getNpcList(),
//                strangeTraveler, scaredBoy, tizio);
//        Utils.addObjects(weirdSwamp.getNpcList(), scaredWoman);
//        Utils.addObjects(nomadMarket.getNpcList(),
//                merchant, mercanteRandom, mercanteRandom2);
//        Utils.addObjects(roughStreet.getNpcList(), angryWoman, henchman1);
//        Utils.addObjects(smallLake.getNpcList(),
//                littleFrog, littleFrog2, littleFrog3);
//        Utils.addObjects(houseLake.getNpcList(), jiraya);
//        Utils.addObjects(gangOutpost.getNpcList(), sleepyHenchman, henchman2);
//        Utils.addObjects(steepStairway.getNpcList(), explorer);
//        Utils.addObjects(timePalace.getNpcList(), servant, deputyBoss);
//        Utils.addObjects(knowledgeHill.getNpcList(),
//                oldMan, sonGoku);
//
//        Utils.addObjects(whisperingHill.getNpcList(), sheWhoKnows);
//        Utils.addObjects(memoryCave.getNpcList(), boss);
//
//        // lista npc
//        Utils.addObjects(this.getNpcs(),
//                strangeTraveler, scaredBoy, scaredWoman, littleFrog, littleFrog2, littleFrog3,
//                merchant, jiraya, explorer, oldMan, tizio, mercanteRandom, mercanteRandom2,
//                angryWoman, sonGoku, servant, sleepyHenchman,
//                // enemies
//                sheWhoKnows, henchman1, henchman2, deputyBoss, boss);
//
//        // lista luoghi
//        Utils.addObjects(this.getRooms(),
//                whiteForest, whitePath, weirdSwamp, whisperingHill,
//                nomadMarket, roughStreet, smallLake, houseLake,
//                ravine, gangOutpost, timePalace, steepStairway,
//                knowledgeHill, timeMountain, memoryCave);
//    }
//
//
//}
