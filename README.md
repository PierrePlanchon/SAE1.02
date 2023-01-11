Alpha Chevaux
===========

Développé par Pierre Planchon et Rafael Piral
Contacts : pierre.planchon.etu@univ-lille.fr, rafael.piral.etu@univ-lille.fr

#Présentation d’Alpha Chevaux
  Alpha Chevaux est un logiciel ludo-pédagogique visant des élèves de primaire afin de leur permettre d'apprendre les tables de multiplications tout en s'amusant. Le jeu se joue avec des pions et 2 dés (6 et   10 faces). 
  Le but du jeu est de faire avancer ses pions autour d’un plateau de jeu jusqu’à ce qu’ils se placent devant la case centrale du plateau en répondant à des multiplications pour avancer.
  
#Règles

	Le jeu se joue à 4 joueurs et chaque joueur dispose de 2 pions.
	
# [Déroulement]

#1.Début de Partie.

	À tour de rôle chacun lance un premier dé (6 faces) pour déterminer le nombre de cases qu'il pourra avancer ensuite lance un second dé (10 faces) 2 fois pour savoir la multiplication à résoudre.
	
#2.Déplacement

	Si la réponse est correcte, le joueur avance du nombre de cases obtenues en lançant le premier dé, et si la réponse est incorrecte, le joueur avance de la moitié du nombre de cases obtenues.
 
	Si un joueur atterrit sur la même case que son adversaire, le pion de l'adversaire est mangé et il retourne sur sa case départ.
	
#3.Comment gagner ?

	Pour gagner la partie, le joueur doit faire le tour du plateau avec son cheval et gravir le chemin associé à sa	couleur.


Des captures d'écran illustrant le fonctionnement du logiciel sont proposées dans le répertoire shots.


# Utilisation de AlphaChevaux

Afin d'utiliser le projet, il suffit de taper les commandes suivantes dans un terminal en se placant de le repertoire ./ArchiveExemple

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
