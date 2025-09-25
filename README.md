Kalkylator

Ett Java-konsolprogram som fungerar som en kalkylator. Programmet är utvecklat för att uppfylla alla kravspecifikationer i kursen "Grundläggande programmering i Java".

Beskrivning
Denna kalkylator är en robust applikation som körs i en kommandotolk. Den guidar användaren genom en meny, hanterar flera tal i samma beräkning och innehåller avancerad felhantering. Koden är utformad för att vara läsbar, modulär och lätt att underhålla.

Funktionalitet och funktioner
Huvudmeny: Användaren presenteras med en huvudmeny där man kan välja mellan de fem grundläggande räknesätten (+, -, *, /, %) eller avsluta programmet.

Stöd för flera tal: Varje räknesätt hanterar fler än två tal i en och samma beräkning. Användaren kan mata in så många tal som önskas och avslutar inmatningen med 'E'.

Robusta beräkningar: Applikationen hanterar ogiltiga matematiska operationer, såsom division och modulus med noll, och informerar användaren om felet utan att krascha.

Färgläggning: För att förbättra användarupplevelsen och göra menyn mer intuitiv, är de olika operatorerna färgkodade i kommandotolken.

Design och tekniska val
1. Kodstruktur (VG-krav)
Programmets logik är uppdelad i mindre, separata metoder (performAddition, performSubtraction, etc.). Detta val gjordes för att förbättra kodens modularitet och läsbarhet. Istället för att ha en enda, stor metod, är varje funktion inkapslad i en egen del, vilket gör koden enklare att läsa, felsöka och underhålla. Denna designprincip kallas för Single Responsibility Principle.

2. Felhantering (VG-krav)
All användarinmatning för numeriska värden hanteras inom en try-catch-block. Detta är en kritisk del för att skapa en robust applikation.

try-blocket hanterar den korrekta exekveringen av koden.

catch-blocket fångar upp fel som NumberFormatException, vilket inträffar när användaren skriver in text istället för siffror. Istället för att krascha, fångas felet, ett informativt felmeddelande skrivs ut och användaren får en ny chans att mata in ett korrekt värde. Detta ger en smidigare och mer professionell användarupplevelse.

3. Användargränssnitt (VG-krav)
Utöver färgkodning används en ASCII-baserad logotyp som programintro för att ge applikationen en personlig och visuell prägel. En tydlig och konsekvent menystruktur guidar användaren genom programmet.

Installation och körning
Programmet är ett standard Java-projekt och kan köras med valfri Java Development Kit (JDK) version 17 eller högre.

Klona repot till din lokala maskin.

Öppna projektet i din IDE (t.ex. IntelliJ, Eclipse eller VS Code).

Kör main-metoden i Main.java.

Versionshantering
Projektet är versionshanterat med Git och GitHub. Arbetet har utförts i separata brancher för varje ny funktion, som sedan har mergeats till main. Detta arbetsflöde har resulterat i fyra distinkta pushar som speglar projektets utveckling.

Push 1: Grundläggande meny och navigeringsstruktur.

Push 2: Implementerade grundläggande beräkningar för två tal.

Push 3: Utökade beräkningarna till att hantera fler än två tal och la till felhantering.

Push 4: Komplett kalkylator med stöd för alla VG-krav, inklusive modulus och robust felhantering.
