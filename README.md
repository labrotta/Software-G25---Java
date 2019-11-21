# Software-G25---Java

Her kommer en instruksjon på hvordan du kjører prototypen:

Windows (Anbefaler å kjøre dette i windows, da er det minst knot!)
Last ned og installer IntelliJ
Når IntelliJ er lastet ned, importerer du prosjektmappen. (Software-G25---Java)
Når valget “Import from an external model” kommer, er det viktig at du velger Maven.
Trykk next
Trykk next (Pass på at Maven-prosjektet blir importert)
Trykk next
Trykk finish
Så må du vente noen minutter på at Maven synkroniserer seg.
Etter hvert kan du navigere deg til src / main / java / main / Main. Når ikonet til Main-klassen ser ut som en cd kan du kjøre denne ved å høyreklikke.

Kjøre testene:

Naviger til src / tests / java. Deretter høyreklikk på mappen java og kjør alle testene.

Linux (testet med Debian 10)

Last ned Java versjon 13 fra https://java.com/en/download/help/linux_x64_install.xml 
Pakk ut fil og bruk “make .install.ph” i terminalen.
Java er nå installert.

Kjøre prototypen
Last ned https://www.jetbrains.com/idea/download/#section=linux
Flytt filen til en mappe der du ønsker at den skal ligge.
Pakk ut filen og bruk “make ./install” fra terminalen.
Start IntelliJ og importer prosjektet, velg pom.xml
Etter dette, opprett en main fil med standard oppsett samt skriv inn under “enviroment” url til mappen hvor java13 befinner seg og kjør.
