# Software-G25---Java

Her kommer en instruksjon p� hvordan du kj�rer prototypen:

Windows (Anbefaler � kj�re dette i windows, da er det minst knot!)
Last ned og installer IntelliJ
N�r IntelliJ er lastet ned, importerer du prosjektmappen. (Software-G25---Java)
N�r valget �Import from an external model� kommer, er det viktig at du velger Maven.
Trykk next
Trykk next (Pass p� at Maven-prosjektet blir importert)
Trykk next
Trykk finish
S� m� du vente noen minutter p� at Maven synkroniserer seg.
Etter hvert kan du navigere deg til src / main / java / main / Main. N�r ikonet til Main-klassen ser ut som en cd kan du kj�re denne ved � h�yreklikke.

Kj�re testene:

Naviger til src / tests / java. Deretter h�yreklikk p� mappen java og kj�r alle testene.

Linux (testet med Debian 10)

Last ned Java versjon 13 fra https://java.com/en/download/help/linux_x64_install.xml 
Pakk ut fil og bruk �make .install.ph� i terminalen.
Java er n� installert.

Kj�re prototypen
Last ned https://www.jetbrains.com/idea/download/#section=linux
Flytt filen til en mappe der du �nsker at den skal ligge.
Pakk ut filen og bruk �make ./install� fra terminalen.
Start IntelliJ og importer prosjektet, velg pom.xml
Etter dette, opprett en main fil med standard oppsett samt skriv inn under �enviroment� url til mappen hvor java13 befinner seg og kj�r.
