/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.wild_time.Game;

import com.mycompany.wild_time.Engine.GameDescription;
import com.mycompany.wild_time.Type.Command;
import com.mycompany.wild_time.Type.CommandType;
import com.mycompany.wild_time.Type.Conversation;
import com.mycompany.wild_time.Type.Npc;
import com.mycompany.wild_time.Type.Player;
import com.mycompany.wild_time.Type.Inventory;
import com.mycompany.wild_time.Type.Item;
import com.mycompany.wild_time.Type.Room;

/**
 *
 * @author rocco
 */
public class WildTime extends GameDescription {
    @Override
    public void init() throws Exception {  
        // set title
        setTitle("Wild Time");
        
        // ----- COMANDI -----
        Command nord = new Command(CommandType.NORD, "nord");
        nord.setAlias(new String[]{"n", "N", "Nord", "NORD"});
        getCommands().add(nord);
        
        Command inventory = new Command(CommandType.INVENTORY, "zaino");
        inventory.setAlias(new String[]{"inv", "inventario"});
        getCommands().add(inventory);
        
        Command sud = new Command(CommandType.SOUTH, "sud");
        sud.setAlias(new String[]{"s", "S", "Sud", "SUD"});
        getCommands().add(sud);
        
        Command est = new Command(CommandType.EAST, "est");
        est.setAlias(new String[]{"e", "E", "Est", "EST"});
        getCommands().add(est);
        
        Command ovest = new Command(CommandType.WEST, "ovest");
        ovest.setAlias(new String[]{"o", "O", "Ovest", "OVEST"});
        getCommands().add(ovest);
        
        Command end = new Command(CommandType.END, "end");
        end.setAlias(new String[]{"end", "fine", "esci", "muori", "ammazzati", "ucciditi", "suicidati","exit"});
        getCommands().add(end);
        
        Command look = new Command(CommandType.LOOK_AT, "osserva");
        look.setAlias(new String[]{"guarda", "vedi", "cerca"});
        getCommands().add(look);
        
        Command pickup = new Command(CommandType.PICK_UP, "raccogli");
        pickup.setAlias(new String[]{"prendi"});
        getCommands().add(pickup);
        
        Command open = new Command(CommandType.OPEN, "apri");
        open.setAlias(new String[]{});
        getCommands().add(open);
        
//        Command push = new Command(CommandType.PUSH, "premi");
//        push.setAlias(new String[]{"spingi","attiva"});
//        getCommands().add(push);
        
        Command save = new Command(CommandType.SAVE, "salva");
        save.setAlias(new String[]{});
        getCommands().add(save);
        
        Command clean = new Command(CommandType.CLEAN, "pulisci");
        clean.setAlias(new String[]{"igienizza", "lava"});
        getCommands().add(clean);
        
        Command talk = new Command(CommandType.TALK_TO, "parla");
        talk.setAlias(new String[]{"chiacchiera"});
        getCommands().add(talk);
        
        Command eat = new Command(CommandType.EAT, "mangia");
        eat.setAlias(new String[]{"bevi", "assumi"});
        getCommands().add(eat);
        
        Command equip = new Command(CommandType.EQUIP, "equipaggia");
        equip.setAlias(new String[]{"usa", "utizza"});
        getCommands().add(equip);
        
        Command attack = new Command(CommandType.ATTACK, "attacca");
        attack.setAlias(new String[]{"combatti", "lotta"});
        getCommands().add(attack);
        
        Command leaves = new Command(CommandType.THROW, "lascia");
        leaves.setAlias(new String[]{"butta", "getta", "lancia"});
        getCommands().add(leaves);
        
        
        // ----- LUOGHI -----
        // stanza di partenza del gioco 0 - FORESTA BIANCA
        Room whiteForest = new Room();
        whiteForest.setName("Foresta Bianca");
        whiteForest.setId(0);
        whiteForest.setDescription("Sei un mercenario giunto nelle terre misteriose di ooo mandato da un re preoccupato per paura che venga rubato il misterioso ingranaggio del tempo,"
                + "un congegno che regola lo scorrere del tempo di queste terre che se rubato potrebbe causare il fermarsi del normale flusso del tempo bloccando di fatto la vita di queste terre,"
                + "da una banda che sta infestando ormai da qualche tempo queste terre . Dalle informazioni questo congegno risulta essere collocato nella grotta della memoria,"
                + " una grotta situata in cima al monte tempo nella zona nord delle terre."
                + "\n\nSei giunto nella FORESTA BIANCA, "
                + "una foresta tanto bella quanto ingannevole per via del suo aspetto bianco e puro, cosa si celera in questa foresta? Sembra che ci sia qualcuno forse sarebbe una buona idea"
                + "PARALRE con questo strano tipo...");
        whiteForest.setExplored(false);
        whiteForest.setBlocked(false);
        whiteForest.setFinal(true);
        
        // stanza 1 - SENTIERO PER LA FORESTA BIANCA
        Room whitePath = new Room();
        whitePath.setName("Sentiero per la Foresta Bianca");
        whitePath.setId(1);
        whitePath.setDescription("\nIl cosidetto SENTIERO PER LA FORESTA BIANCA, nome alquanto banale,"
                + "datogli da un vecchio e pigro re che governava queste terre tempo fa che non sapeva con chiamare questo quadrante di terra."
                + "Come dice il nome è un semplice sentiero che ti porta alla foresta alla bianca ma da cui puoi raggiungere altri luoghi di queste lande misteriose.");
        whitePath.setExplored(false);
        whitePath.setBlocked(false);
        
        // stanza 2 - PALUDE STRANA 
        Room weirdSwamp = new Room();
        weirdSwamp.setName("Palude Strana");
        weirdSwamp.setId(2);
        weirdSwamp.setDescription("La PALUDE STRANA, un luogo avvolto nel mistero dove per qualche strano motivo la gente del posto sostiene di sentire delle voci,"
                + "dei sussuri che hanno fatto impazzire chiunque provasse ad addentrarsi nella palude."
                + "Per quanto avvolta nel mistero è pur sempre una palude.");
        weirdSwamp.setExplored(false);
        weirdSwamp.setBlocked(false);
        
        // stanza 3 - COLLINA DEI SUSSURI
        Room whisperingHill = new Room();
        whisperingHill.setName("Collina dei Sussurri");
        whisperingHill.setId(3);
        whisperingHill.setDescription("Ti trovi nella Collina dei Sussurri");
        whisperingHill.setExplored(false);
        whisperingHill.setBlocked(true);
        
        // stanza 4 - MERCATO DEI NOMADI
        Room nomadMarket = new Room();
        nomadMarket.setName("Mercato dei Nomadi");
        nomadMarket.setId(4);
        nomadMarket.setDescription("Ti trovi nel Mercato dei Nomadi");
        nomadMarket.setExplored(false);
        nomadMarket.setBlocked(false);
        
        // stanza 5 - STRADA MALMESSA
        Room roughStreet = new Room();
        roughStreet.setName("Strada Malmessa");
        roughStreet.setId(5);
        roughStreet.setDescription("Ti trovi nella Strada Malmessa");
        roughStreet.setExplored(false);
        roughStreet.setBlocked(false);
        
        // stanza 6 - PICCOLO LAGO
        Room smallLake = new Room();
        smallLake.setName("Piccolo Lago");
        smallLake.setId(6);
        smallLake.setDescription("Ti trovi al Piccolo Lago");
        smallLake.setExplored(false);
        smallLake.setBlocked(false);
        
        // STANZA 7 - CASA SUL PICCOLO LAGO
        Room houseLake = new Room();
        houseLake.setName("Casa sul Piccolo Lago");
        houseLake.setId(7);
        houseLake.setDescription("Ti trovi alla Casa sul Piccolo Lago");
        houseLake.setExplored(false);
        houseLake.setBlocked(true);
                
        // STANZA 8 - BURRONE
        Room ravine = new Room();
        ravine.setName("Burrone");
        ravine.setId(8);
        ravine.setDescription("Ti trovi al Burrone");
        ravine.setExplored(false);
        ravine.setBlocked(false);
                               
        // STANZA 9 - AVAMPOSTO DELLA BANDA
        Room gangOutpost = new Room();
        gangOutpost.setName("Avamposto della Banda");
        gangOutpost.setId(9);
        gangOutpost.setDescription("Ti trovi nell'Avamposto della Banda");
        gangOutpost.setExplored(false);
        gangOutpost.setBlocked(false);
        
        // stanza 10 - PALAZZO DEL TEMPO
        Room timePalace = new Room();
        timePalace.setName("Palazzo del Tempo");
        timePalace.setId(10);
        timePalace.setDescription("Ti trovi nel Palazzo del Tempo");
        timePalace.setExplored(false);
        timePalace.setBlocked(false);
                
        // stanza 11 - SCALINATA RIPIDA
        Room steepStairway = new Room();
        steepStairway.setName("Scalinata Ripida");
        steepStairway.setId(11);
        steepStairway.setDescription("Ti trovi sulla Scalinata Ripida");
        steepStairway.setExplored(false);
        steepStairway.setBlocked(false);
                              
        // stanza 12 - COLLINA DELLA SAPIENZA
        Room knowledgeHill = new Room();
        knowledgeHill.setName("Collina della Sapienza");
        knowledgeHill.setId(12);
        knowledgeHill.setDescription("Ti trovi sulla Collina della sapienza");
        knowledgeHill.setExplored(false);
        knowledgeHill.setBlocked(false);
                                      
        // stanza 13 - ALTOPIANO DEL SERPENTE
        Room serpentPlateau = new Room();
        serpentPlateau.setName("Altopiano dei Serpenti");
        serpentPlateau.setId(13);
        serpentPlateau.setDescription("Ti trovi sull'Altopiano dei Serpenti");
        serpentPlateau.setExplored(false);
        serpentPlateau.setBlocked(false);
                                              
        // stanza 14 - MONTE TEMPO
        Room timeMountain = new Room();
        timeMountain.setName("Monte Tempo");
        timeMountain.setId(14);
        timeMountain.setDescription("Ti trovi sul Monte Tempo");
        timeMountain.setExplored(false);
        timeMountain.setBlocked(false);
                                                
        // stanza FINALE 15 - GROTTA DELLA MEMORIA - STANZA FINALE
        Room memoryCave = new Room();
        memoryCave.setName("Grotta della Memoria");
        memoryCave.setId(15);
        memoryCave.setDescription("Ti trovi nella Grotta della Memoria");
        memoryCave.setExplored(false);
        memoryCave.setBlocked(false);
        memoryCave.setFinal(true);
       
        
        
        // foresta bianca
        whiteForest.setNord(whitePath); // sentiero
        whiteForest.setSud(null);
        whiteForest.setEst(null);
        whiteForest.setOvest(null);
        
        // sentiero per la foresta bianca
        whitePath.setNord(null);    
        whitePath.setSud(whiteForest);  // foresta
        whitePath.setEst(nomadMarket);  // mercato
        whitePath.setOvest(weirdSwamp); // palude
        
        // palude strana
        weirdSwamp.setNord(null);
        weirdSwamp.setSud(whisperingHill); // collina
        weirdSwamp.setEst(whitePath);      // sentiero
        weirdSwamp.setOvest(null);
        
        // collina dei susssurri
        whisperingHill.setNord(weirdSwamp); // palude
        whisperingHill.setSud(null);
        whisperingHill.setEst(null);
        whisperingHill.setOvest(null);
        
        // mercato dei nomadi
        nomadMarket.setNord(null);
        nomadMarket.setSud(null);
        nomadMarket.setEst(roughStreet);    // strada malmessa
        nomadMarket.setOvest(whitePath);    // sentiero
        
        // strada malmessa
        roughStreet.setNord(gangOutpost);  // avamposto banda
        roughStreet.setSud(smallLake);       // piccolo lago
        roughStreet.setEst(ravine);      // burrone
        roughStreet.setOvest(nomadMarket);    // mercato dei nomadi
        
        // piccolo lago
        smallLake.setNord(roughStreet);      // strada
        smallLake.setSud(houseLake);         // casa di jiraya
        smallLake.setEst(null);
        smallLake.setOvest(null);
        
        // piccolo lago
        houseLake.setNord(smallLake);   // lago
        houseLake.setSud(null);         
        houseLake.setEst(null);
        houseLake.setOvest(null);
        
        // burrone
        ravine.setNord(null);
        ravine.setSud(null);         
        ravine.setEst(null);
        ravine.setOvest(roughStreet);   // strada
        
        // avamposto della banda
        gangOutpost.setNord(null);
        gangOutpost.setSud(roughStreet);     // strada
        gangOutpost.setEst(timePalace);                // palazzo tempo
        gangOutpost.setOvest(steepStairway);              // scalinata
        
        // palazzo del tempo
        timePalace.setNord(null);
        timePalace.setSud(null);         
        timePalace.setEst(null);     // avamposto
        timePalace.setOvest(gangOutpost);
        
        // scalinata ripida
        steepStairway.setNord(timeMountain);               // monte tempo
        steepStairway.setSud(null);         
        steepStairway.setEst(gangOutpost);     // avamposto
        steepStairway.setOvest(knowledgeHill);              // collina della sapienza
        
        // collina della sapienza
        knowledgeHill.setNord(serpentPlateau);            // altopiano
        knowledgeHill.setSud(null);         
        knowledgeHill.setEst(steepStairway);    
        knowledgeHill.setOvest(null);
        
        // altopiano dei serpenti
        serpentPlateau.setNord(null);            
        serpentPlateau.setSud(knowledgeHill);                 // collina
        serpentPlateau.setEst(null);    
        serpentPlateau.setOvest(null);
        
        // monte tempo
        timeMountain.setNord(null);            
        timeMountain.setSud(steepStairway);         // strada
        timeMountain.setEst(memoryCave);                      // grotta 
        timeMountain.setOvest(null);
        
        // grotta della memoria
        memoryCave.setNord(null);            
        memoryCave.setSud(null);         // strada
        memoryCave.setEst(null);                      // grotta 
        memoryCave.setOvest(timeMountain);
        

        
        // ----- OGGETTI -----
        // armi
        Item oldSword = new Item();
        oldSword.setId(1);
        oldSword.setName("vecchia_spada");
        oldSword.setDescription("Spada che da sempre ti accompagna nelle tue avventure");
        oldSword.setTakeable(true);
        oldSword.setUseable(true);
        oldSword.setIsWeapon(true);
        oldSword.setAttackDamage(10);
        
        Item sword = new Item();
        sword.setId(8);
        sword.setName("spada");
        sword.setDescription("Spada che da sempre ti accompagna nelle tue avventure");
        sword.setTakeable(true);
        sword.setUseable(true);
        sword.setIsWeapon(true);
        sword.setAttackDamage(20);
        
        // scudi 
        Item oldShield = new Item();
        oldShield.setId(2);
        oldShield.setName("vecchio_scudo");
        oldShield.setDescription("Scudo che da sempre ti accompagna nelle tue avventure");       
        oldShield.setTakeable(true);
        oldShield.setUseable(true);
        oldShield.setIsWeapon(true);
        oldShield.setDefenseBonus(10);
        
        getItems().add(oldSword);
        getItems().add(sword);
        getItems().add(oldShield);
        
        // cure e potenziamenti
        Item apple = new Item();
        apple.setName("mela");
        apple.setDescription("Mela rossa di stagione. Restituisce 10 HP.");
        apple.setValue(5);
        apple.setId(3);
        apple.setTakeable(true);
        apple.setUseable(true);
        apple.setIsHeal(true);
        apple.setBonusHP(10);
           
        Item redPotion = new Item();
        redPotion.setName("pozione_rossa"); 
        redPotion.setDescription("Pozione di colore rosso, ha strani effetti sul corpo."
                + "Restituisce 20 HP.");
        redPotion.setValue(10);
        redPotion.setId(4);
        redPotion.setTakeable(true);
        redPotion.setUseable(true);
        redPotion.setIsHeal(true);
        redPotion.setBonusHP(10);
        
        Item bluePotion = new Item();
        bluePotion.setName("pozione_blu"); 
        bluePotion.setDescription("Pozione di colore blu, ha strani effetti sul corpo."
                + "Ripara l'armatura.");
        bluePotion.setValue(10);
        bluePotion.setId(5);
        bluePotion.setTakeable(true);
        bluePotion.setUseable(true);
        bluePotion.setIsHeal(true);
        bluePotion.setBonusHP(10);
        
        getItems().add(apple);
        getItems().add(redPotion);
        getItems().add(bluePotion);
        
        // oggetti
        Item hat = new Item();
        hat.setName("cappello");
        hat.setId(6);
        hat.setDescription("Un normale cappello, servira mai a qualcosa?");
        hat.setTakeable(true);
        hat.setUseable(true);        

        Item key = new Item();
        key.setName("chiave");
        key.setDescription("Strana chiave, puo servire ad aprire qualcosa...");
        key.setId(7);
        key.setTakeable(true);
        key.setUseable(true);
                
        getItems().add(key);
        getItems().add(hat);
        
        weirdSwamp.getChest().setName("cassa");
        weirdSwamp.getChest().setIsOpen(false);
        weirdSwamp.getChest().getList().add(redPotion);
        weirdSwamp.getChest().getList().add(hat);
        weirdSwamp.getChest().setOpenWith(key);
        
        getItems().add(weirdSwamp.getChest());
        
        whiteForest.getItems().add(key);
        whiteForest.getItems().add(apple);
        whiteForest.getItems().add(sword);
        whitePath.getItems().add(oldSword);
        nomadMarket.getItems().add(oldShield);

        
        // ----- PERSONAGGI -----
        Player geralt = new Player();
        geralt.setHp(7);
        geralt.setMaxHP(50);
        geralt.setName("Geralt");
        geralt.setCurrentPlace(whiteForest);  
        // oggetti di base 
        geralt.setArma(oldSword);
        geralt.setScudo(oldShield);
        geralt.setInventory(new Inventory());
        
        setPlayer(geralt);
        
        // ---- NPC ----
        // tizio del tutorial
        Npc strangeTraveler = new Npc();
        strangeTraveler.setHp(20);
        strangeTraveler.setName("strano_viandante");
        strangeTraveler.setTalk("Sei nuovo da queste parti vero?");
        strangeTraveler.setDescription("Viandante dall'aspetto trasandato che se ne sta ai piedi"
                + "di un fuoco semi accesso. Sembra abbia qualcosa di interessante da dire...");
        
        Conversation constr = new Conversation();
        constr.setQuestion("chi sei?");
        constr.setAnswer("Sono qualcuno che potrebbe aiutarti nell'attraversare queste terre tanto belle quanto pericolose."
                + "Cosa vuoi sapere?");
        
        Conversation constr2 = new Conversation();
        constr2.setQuestion("cosa posso fare?");
        constr2.setAnswer("Ci sono tante cose che puoi fare, come ad esempio esplorare andando a NORD, SUD, OVEST, EST."
                + "Puoi RACCOGLIERE gli oggetti che puoi trovare in giro, alcuni li puoi EQUIPAGGIARE, altri MANGIARE o BERE."
                + "Puoi anche vedere cosa c'è nel tuo ZAINO e magari BUTTARE qualcosa. Poi se ti senti solo puoi PARLARE con qualcuno, ma questo credo che"
                + "tu lo abbia capito, se invece c'è qualcuno che ti infastidisce lo puoi sempre ATTACCARE."
                + "Mi raccomando dove vai e cerca sempre di OSSERVARE bene cio che ti circonda, non sai cosa ci puoi trovare."
                + "Se poi tutte queste scritte ti infastidiscono, puoi sempre PULIRE lo schermo."
                + "Infine, caro mercenario, ricordati che puoi USCIRE quando vuoi ma ricordati"
                + "di SALVARE altrimenti la prossima volta non sai piu da dove riprendere il tuo viaggio.");
        
        Conversation constr3 = new Conversation();
        constr3.setQuestion("cosa sai di queste terre?");
        constr3.setAnswer("Non molto in verita mercenario, ma so che sono terre misteriose.");
        
        strangeTraveler.getConversation().add(constr);
        strangeTraveler.getConversation().add(constr2);
        strangeTraveler.getConversation().add(constr3);

        //////////////////////////////
        Npc scaredBoy = new Npc();
        scaredBoy.setHp(20);
        scaredBoy.setName("renato_spaventato");
        scaredBoy.setTalk("Dall'aspetto sembri un mercenario. Sento provenire delle voci"
                + "dalla parte sud della Palude.");
        scaredBoy.setDescription("Renato Spaventato, un ragazzino spaventato -ma tu guarda un po- dopo che ha provato ad addentrarsi nella parte sud della palude strana."
                + "Preso per pazzo dalla gente del posto forse non sarebbe una cattiva idea parlarci...");
        
        Conversation convBoy1 = new Conversation();
        convBoy1.setQuestion("cosa ti spaventa?");
        convBoy1.setAnswer("Non sono pazzo te lo giuro, ho sentito delle voci nella mia testa, non sono pazzo");
        
        Conversation convBoy2 = new Conversation();
        convBoy2.setQuestion("cosa è successo?");
        convBoy2.setAnswer("Ho provato ad addentrarmi nella palude qui a est ma andando avanti ho sentito delle voci, dei sussurri nella mia testa."
                + "Stavo impazzendo...");
        
        scaredBoy.getConversation().add(convBoy1);
        scaredBoy.getConversation().add(convBoy2);

        //////////////////////////////////
        Npc scaredWoman = new Npc();
        scaredWoman.setHp(20);
        scaredWoman.setName("rita_l'impaurita");
        scaredWoman.setTalk("Dall'aspetto sembri un mercenario. Sento provenire delle voci"
                + "dalla parte nord della Palude.");
        scaredWoman.setDescription("Rita l'impaurita, il nome gia dice tutto.");
        
        Npc merchant = new Npc();
        merchant.setHp(20);
        merchant.setName("tino_cre");
        merchant.setTalk("Salve viadante io sono Tino Cre");
        merchant.setDescription("Mercante dall'aspetto buffo");
        
        Npc littleFrog = new Npc();
        littleFrog.setHp(20);
        littleFrog.setName("rospetto_il_sospetto");
        littleFrog.setTalk("Crack mercenario! Mi chiamo Gamabunta crack!");
        littleFrog.setDescription("Rospetto che si atteggia a vecchio maestro, forse sara"
                + "per quel lungo pizzetto bianco.");
        
        Npc jiraya = new Npc();
        jiraya.setHp(20);
        jiraya.setName("eremita_dei_rospi");
        jiraya.setTalk("Salve viadante io sono l'eremita dei rospi");
        jiraya.setDescription("Si dice che provenga da un villaggio che ha come simbolo una foglia,"
                + "quanta fantasia...");
        
        Npc explorer = new Npc();
        explorer.setHp(20);
        explorer.setName("Nathan");
        explorer.setTalk("Salve viadante io sono Nathan e sono un esploratore");
        explorer.setDescription("Si definisce esploratore e pronipote di sir Francis Drake,"
                + "in realta è solo un ladro a cui piace rischiare la propria vita");
        
        Npc oldMan = new Npc();
        oldMan.setHp(20);
        oldMan.setName("Maestro_Muten");
        oldMan.setTalk("Salve viadante io sono Muten e sono un maestro d'arti maziali");
        oldMan.setDescription("Si fa chiamare anche Genio delle Tartarughe di mare e si definisce un"
                + "povero vecchietto che si gode le sue strane riviste e quando vede uno straniero"
                + "improvvisa una mossa con le mani che lo fa sembrare solo un vecchio pazzo");
        
        
        getNpcs().add(strangeTraveler);
        getNpcs().add(scaredBoy);
        getNpcs().add(scaredWoman);
        getNpcs().add(littleFrog);
        getNpcs().add(merchant);
        getNpcs().add(jiraya);
        getNpcs().add(explorer);        
        getNpcs().add(oldMan);
        
        whiteForest.getNpcs().add(strangeTraveler);
        whitePath.getNpcs().add(scaredBoy);
        weirdSwamp.getNpcs().add(scaredWoman);
        nomadMarket.getNpcs().add(merchant);
        smallLake.getNpcs().add(littleFrog);
        houseLake.getNpcs().add(jiraya);
        steepStairway.getNpcs().add(explorer);
        knowledgeHill.getNpcs().add(oldMan);
        
        
        // TEST 
        Item shit = new Item();
        shit.setName("merda_affilata");
        shit.setDescription("Una cacca leggendaria per via della sua durezza");
        shit.setId(7);
        shit.setTakeable(true);
        shit.setUseable(true);
        shit.setIsWeapon(true);
        shit.setAttackDamage(10);
        
        Item shitgold = new Item();
        shitgold.setName("merdascudo");
        shitgold.setDescription("Una cacca leggendaria per via della sua durezza");
        shitgold.setId(7);
        shitgold.setTakeable(true);
        shitgold.setUseable(true);
        shitgold.setIsWeapon(true);
        shitgold.setDefenseBonus(10);
        
        getItems().add(shit);        
        getItems().add(shitgold);

        Npc tester = new Npc();
        tester.setHp(10);
        tester.setIsEnemy(true);
        tester.setName("tester");
        tester.setTalk("Colpiscimi sono un tester");
        tester.setDescription("tester");
        tester.setArma(shit);
        tester.setScudo(shitgold);
        tester.setReward(shitgold);
        
        Conversation con1 = new Conversation();
        con1.setQuestion("Che fai?");
        con1.setAnswer("Schifo");
        
        Conversation con2 = new Conversation();
        con2.setQuestion("Cosa sai fare?");
        con2.setAnswer("Puoi usarmi come sacco da box o posso darti una mano con i comandi");
        
        tester.getConversation().add(con1);
        tester.getConversation().add(con2);

        Npc tester2 = new Npc();
        tester2.setHp(10);
        tester2.setIsEnemy(true);
        tester2.setName("tester2");
        tester2.setTalk("Colpiscimi sono un tester");
        tester2.setDescription("trimone 2");
        tester2.setArma(shit);
        tester2.setScudo(shitgold);
        tester2.setReward(shitgold);
        
        
        getNpcs().add(tester);
        getNpcs().add(tester2);

        whiteForest.getNpcs().add(tester);
        nomadMarket.getNpcs().add(tester2);
        
        // ----- ENEMIES -----
        // COLEI CHE SA - MINIBOSS
        Npc sheWhoKnows = new Npc();
        sheWhoKnows.setIsEnemy(true);
        sheWhoKnows.setHp(40);
        sheWhoKnows.setName("Colei_che_Sa");
        sheWhoKnows.setTalk("IO SONO LA SOVRANA DI QUESTO REGNO CHI OSA INVADERE LA MIA TERRA");
        sheWhoKnows.setDescription("Un tempo sovrana incontrasta di questa terra, un giorno fu imprigionata"
                + "dalle figlie all'interno della collina. Da allora la collina fu chiamata Dei Sussurri"
                + "perche chiunque provi ad avvicinarsi sente sussurri");
        
        // SCAGNOZZO 1
        Npc henchman1 = new Npc();
        henchman1.setIsEnemy(true);
        henchman1.setHp(25);
        henchman1.setName("Scagnozzo_1");
        henchman1.setTalk("");
        henchman1.setDescription("Il loro capo consapevole della loro debolezza ha semplicemente"
                + "numerato i suoi scagnozzi. Ecco lui è il numero 1, solo di numero...");
        
        // SCAGNOZZO 2
        Npc henchman2 = new Npc();
        henchman2.setIsEnemy(true);
        henchman2.setHp(25);
        henchman2.setName("Scagnozzo_2");
        henchman2.setTalk("");
        henchman2.setDescription("Il loro capo consapevole della loro debolezza ha semplicemente"
                + "numerato i suoi scagnozzi. Ecco lui è il numero 2, persino il programmatore "
                + "non li rispetta....");
        
        // VICE CAPO DELLA BANDA - MINIBOSS
        Npc deputyBoss = new Npc();
        deputyBoss.setIsEnemy(true);
        deputyBoss.setHp(50);
        deputyBoss.setName("Doffy");
        deputyBoss.setTalk("");
        deputyBoss.setDescription("Vice capo della banda del tempo, ha una strana passione per la moda"
                + "dal momento che se ne va in giro con un pellicciotto rosa e degli occhialetti da sole"
                + "abbastanza discutibili. Resta il fatto che è temuto e rispettato, sopratutto temuto "
                + "per quella strana tecnica che usa attarverso dei fili");
        
        // MINIBOSS ALTOPIANO DEI SERPENTI
        Npc slytherin = new Npc();
        slytherin.setIsEnemy(true);
        slytherin.setHp(70);
        slytherin.setName("serpe_verde");
        slytherin.setTalk("");
        slytherin.setDescription("");    
        
        
        // BOSS DELLA BANDA 
        Npc boss = new Npc();
        boss.setIsEnemy(true);
        boss.setHp(80);
        boss.setName("Lucci");
        boss.setTalk("");
        boss.setDescription("Capo della banda del tempo, la sua pachetezza è cio che fa piu paura, non riesci"
                + "mai a capire ");
        
        getNpcs().add(sheWhoKnows);
        getNpcs().add(henchman1);
        getNpcs().add(henchman2);
        getNpcs().add(deputyBoss);
        getNpcs().add(boss);
        getNpcs().add(slytherin);
        
        whisperingHill.getNpcs().add(sheWhoKnows);
        timePalace.getNpcs().add(deputyBoss);
        memoryCave.getNpcs().add(boss);
        roughStreet.getNpcs().add(henchman1);
        gangOutpost.getNpcs().add(henchman2);
        serpentPlateau.getNpcs().add(slytherin);
        
        
        getRooms().add(whiteForest);       
        getRooms().add(whitePath);        
        getRooms().add(weirdSwamp); 
        getRooms().add(whisperingHill);        
        getRooms().add(nomadMarket); 
        getRooms().add(roughStreet);
        getRooms().add(smallLake);        
        getRooms().add(houseLake);        
        getRooms().add(ravine);       
        getRooms().add(gangOutpost);
        getRooms().add(timePalace);        
        getRooms().add(steepStairway);       
        getRooms().add(knowledgeHill);       
        getRooms().add(serpentPlateau);        
        getRooms().add(timeMountain);
        getRooms().add(memoryCave);
    }
    
    
}
