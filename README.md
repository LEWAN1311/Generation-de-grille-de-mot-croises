# Generation-de-grille-de-mot-croises

## Préambule : mots croisés

Au cours des TME 1 à 3 nous allons bâtir une application permettant de construire des mots
croisés. L’objectif global est un programme qui prend en entrées un dictionnaire et une grille vierge,
et qui rend en sortie une grille résolue.

Par exemple, une grille vide possible est représentée ci-dessous. Elle comporte 12 emplacements de
mot, les premières cases de chaque emplacement de mot y sont numérotées de 0 à 11. Nous considérons
que les mots croisés sont donnés comme une grille dont chaque case est soit pleine (noire) soit vide
(blanche).

Le but est d’inscrire une lettre dans chaque case vide, en s’assurant que tous les mots horizontaux
et verticaux sont des mots du dictionnaire. Par exemple, la grille ci-dessous est solution des mots
croisés donnés ci-dessus. Normalement, un indice est donné pour chaque emplacement de mot, ce qui aide le cruciverbiste (un humain) à deviner les mots à placer. Ici, c’est l’inverse : nous souhaitons
générer des problèmes de mots croisés à l’aide de notre outil.

## Organisation
La construction d’une solution à ce problème va se faire en trois parties ce qui occupera trois
séances de TME.
- Partie 1 :
  - construction de la structure de données permettant de représenter une grille de mots-croisés
  en mémoire
  - chargement d’une grille (a priori vide) depuis un fichier.
- Partie 2 :
  - mise en place d’un algorithme de recherche d’emplacement de mots dans une grille et calcul
  de leur longueur.
  - définition, pour chaque emplacement de mot d’un dictionnaire qui maintient l’ensemble
  des mots possibles à cet emplacement.
- Partie 3 :
  - raffinage des dictionnaires en examinant les intersections entre deux emplacements de
  mots (les lettres des mots choisis doivent coïncide)
  - réalisation d’un algorithme de satisfaction de contraintes qui sera formulé de façon abstraite (grâce à l’utilisation d’interfaces) et adaptation du code précédent aux besoins de
  l’algorithme.

Pour les plus courageux, une quatrième partie bonus est donnée en fin de ce sujet afin d’améliorer les performances de résolution.