# TextEngine

## Descrizione
TextEngine nasce come progetto universitario per l’esame di Metodi Avanzati di Programmazione (MAP) presso l’Università degli Studi “Aldo Moro” di Bari.
L’obiettivo dell’engine è quello di funzionare come una sorta di Game Boy per avventure testuali:
l’utente può caricare un’avventura testuale in formato JSON come se fosse una cartuccia.

## Come funziona
Per utilizzare il sistema è sufficiente:

1. Scrivere un’avventura testuale rispettando la GameDescription, 
ovvero un insieme di regole che definiscono la struttura del gioco.
2. Esportarla in formato JSON.
3. Caricarla tramite la schermata iniziale dell’engine.

In futuro si prevede lo sviluppo di un editor integrato per la creazione delle avventure direttamente dall’engine stesso.

## Project Status
È attualmente in corso un rebuild completo dell’engine, basato sul progetto originale 
(che necessitava di una riorganizzazione significativa del codice).

## Feature

### 🟢 Implementate

- GUI

Una GUI basilare che include:
  - finestra del menu
  - finestra di gioco
  - elementi base per l’interazione


### 🟡 In sviluppo

- Parser
Si occupa della lettura e pulizia dei comandi immessi dall’utente.
Attualmente riconosce i comandi definiti nel file JSON, ripulisce la stringa di input e genera una lista di Command.
- GameManager
Interpreta la lista dei comandi e li associa alle azioni da eseguire, modificando di conseguenza lo stato del gioco.
Al momento è presente solo come struttura base.
- CartridgeManager
Gestisce il caricamento della “cartuccia”, ovvero il file JSON contenente l’avventura.
Attualmente supporta il caricamento tramite la libreria Gson di Google.

### 🚀 Prossime aggiunte

- Editor in-engine per la creazione guidata delle avventure, nel rispetto della GameDescription
- Gestione dei salvataggi

## Installazione e uso

Attualmente l'unico modo per testare l'engine è clonare la repo ed avviare in locale il progetto.