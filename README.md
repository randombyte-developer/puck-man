#PuckMan

A school project in Java with [Greenfoot](https://www.greenfoot.org).

German 'how to play':

###Steuerung und Spielprinzip
- Den Spieler mit den Pfeiltasten steuern
- Die Gegner durch Berühren fressen
- Die Gegner sammeln die Punkte auf dem Spielfeld
- Anzahl noch verbleibender Punkte wird oben am Spielfeldrand angezeigt
- Das Spiel startet, wenn man den Spieler in eine Richtung bewegt
- Das aktuell gestartete Level kann mit Escape verlassen werden, um zur Levelauswahl zurückzukehren

###Spielende:
- Der Spieler verliert, wenn er 0 Punkte hat, und somit kein Punkt mehr auf dem Spielfeld ist
- Der Spieler gewinnt, wenn er alle Gegner gefressen hat

###PowerUps
- Zufällig spawnen PowerUps, die durch berühren eingesammelt werden können
- Beim Einsammeln eines PowerUps wird das aktuell zwischengespeicherte mit dem aufgesammeltem ersetzt und oben am Spielfeldrand angezeigt
- Zwischengespeicherte PowerUps können mit der Leertaste aktiviert werden
- Die drei Arten von PowerUps: Zufälliger Teleport, einige Punkte erscheinen wieder auf dem Spielfeld und kurzzeitiger Geschwindigkeits-Boosts des Spielers
