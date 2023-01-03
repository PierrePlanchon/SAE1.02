Alpha Chevaux
===========

Développé par Pierre Planchon Rafael Piral
Contacts : pierre.planchon.etu@univ-lille.fr, rafael.piral.etu@univ-lille.fr

# Présentation d'Alpha Chevaux
AlphaChevaux est un jeu de société qui se joue avec des dés et des pions. Le but du jeu est de faire avancer ses pions autour du plateau de jeu jusqu'à ce qu'ils atteignent la maison.



<Description de votre jeu>
Le jeu se joue a 4 joueurs, chaque joueur a 2 pions.
À tour de rôle chacun lance un premier dé (6 faces) pour déterminer de combien de cases il pourra avancer et lance un second dé (10 faces) 2 fois pour savoir quelle mutiplication il va devoir resoudre, si la
reponse est bonne le joueur avance alors du nombres de cases obtenus lors du lancement du premier dé, si la reponse est fausse il avancera de la moitié du nombre de cases obtenus. Le plateau est en forme de croix avec une maison au centre, le premier joueur a faire le tour du plateau et mettre ses pions devant la case X(maison) remporte la partie.




Des captures d'écran illustrant le fonctionnement du logiciel sont proposées dans le répertoire shots.


# Utilisation de AlphaChevaux

Afin d'utiliser le projet, il suffit de taper les commandes suivantes dans un terminal :
./ArchiveExemple

```
./compile.sh
```
Permet la compilation des fichiers présents dans 'src' et création des fichiers '.class' dans 'classes'

```
./run.sh AlphaChevaux
```
Permet le lancement du jeu



# A venir
creer un type Chemins ?
gerer la fin d'un tour (ne depasse pas les limites du chemins) ---> en cours
dans deplacer() ajouter le type Cheval, tout gerer avec le type cheval !! ---> OK
chevaux "1" et "2" ---> en cours
clignotant de la bonne couleur ---> à faire
gerer les pions mangés !! --- à faire
creer foncton deplacements_interieurs ---> à faire
gérer la sauvegarde d'une partie ---> à faire
