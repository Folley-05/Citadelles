package modele;

public class Caracteristiques {
	public static String ASSASSIN= 
		"L'assassin peut tuer un personnage de son choix. " +
		"Celui-ci ne jouera pas ce tour-ci.";
	public static String ECHEVIN= 
		"L'�chevin place des mandats de r�quisition, face cach�e, " +
		"sous 3 jetons Personnage diff�rents. Il peut r�v�ler le " +
		"mandat sign� pour confisquer le premier quartier b�ti par " +
		"le joueur cibl�, qui r�cup�re le co�t de construction.";
	public static String SORCIERE=
		"Apr�s avoir pris or ou carte, la Sorci�re ensorcelle un " +
		"personnage et interrompt son tour. Elle le terminera en " +
		"jouant � la place du personnage ensorcel�";
	public static String MAITRE_CHANTEUSE=
		"La Ma�tre-chanteuse place des menaces, face cach�e, sous " +
		"2 jetons Personnage diff�rents. Un personnage menac� peut " +
		"lui payer la moiti� de son or pour retirer la menace. Si " +
		"la Ma�tre-chanteuse r�v�le le vrai jeton Menace, elle " +
		"prend tout l'or du joueur cibl�";
	public static String ESPION=
		"L'Espion choisit un type (couleur) de quartier et regarde " +
		"la main d'un autre joueur. Pour chaque quartier du type " +
		"indiqu�, il re�oit 1 pi�ce d'or de ce joueur et pioche 1 " +
		"carte Quartier.";
	public static String VOLEUR=
		"Le Voleur peut piller le tr�sor du personnage de son choix. " +
		"Quand le personnage d�trouss� sera r�v�l�, il donnera tout " +
		"son or au Voleur.";
	public static String MAGICIENNE=
		"La Magicienne peut, au choix : soit �changer la totalit� " +
		"des cartes de sa main avec celle d'un autre joueur, soit " +
		"�changer des cartes de sa main contre le m�me nombre de " +
		"cartes de la pioche.";
	public static String SORCIER=
		"Le Sorcier choisit 1 carte dans la main d'un autre joueur " +
		"et peut soit payer son co�t pour la b�tir, soit l'ajouter " +
		"� sa main. Il peut b�tir des quartiers identiques � "+
		"d'autres quartiers de sa cit�.";
	public static String VOYANTE=
		"La Voyante prend 1 carte au hasard dans la main de chaque " +
		"joueur, puis donne � chacun 1 carte de son choix. Son " +
		"permis de construire est de 2 quartiers.";
	public static String EMPEREUR=
		"L'Empereur donne la Couronne � un autre joueur, qui lui " +
		"paie 1 pi�ce d'or ou 1 carte. Chaque quartier Noble dans " +
		"sa cit� lui rapporte 1 pi�ce d'or.";
	public static String PATRICIEN=
		"Le Patricien prend la Couronne et choisira en premier " +
		"en premier son Personnage lors du prochain tour. " +
		"Chaque quartier Noble dans sa cit� lui rapporte 1 " +
		"pi�ce d'or.";
	public static String ROI = 
		"Le Roi prend la Couronne et choisira " +
		"en premier son personnage lors du prochain tour." +
		"Chaque quartier Noble dans sa cit� lui rapporte 1 " +
		"pi�ce d'or.";
	public static String ABBE=
		"Le joueur le plus riche doit donner 1 pi�ce d'or � l'Abb�." +
		"Chaque quartier Religieux dans sa cit� lui rapport 1 pi�ce " +
		"d'or ou 1 carte.";
	public static String CARDINAL=
		"Si le Cardinal n'a pas assez d'or pour b�tir un quartier, " +
		"il peut le prendre � un joueur en �change de carte (1 " +
		"carte = 1 pi�ce d'or). Chaque quartier Religieux dans sa " +
		"cit� lui rapport 1 carte quartier.";
	public static String EVEQUE=
		"La cit� de l'Ev�que est prot�g�e contre les personnages " +
		"de rang 8 (gemme rouge). Chaque quartier Religieux dans sa "+
		"cit� lui rapport 1 pi�ce d'or";
	public static String ALCHIMISTE=
		"A la fin de son tour, l'Alchimiste r�cup�re l'or qu'il a " +
		"d�pens� pour b�tir des quartiers durant son tour.";
	public static String MARCHANDE=
		"La Marchande re�oit 1 pi�ce d'or suppl�mentaire. Chaque " +
		"quartier Commer�ant dans sa cit� lui rapporte 1 pi�ce d'or.";
	public static String NEGOCIANT=
		"Le N�gociant peut b�tir des quartiers Commer�ants sans " +
		"restrictions. Chaque quartier Commer�ant dans sa cit� " +
		"lui rapporte 1 pi�ce d'or.";
	public static String ARCHITECTE=
		"L'Architecte pioche 2 cartes suppl�mentaires. Son permis " +
		"de construire est de 3 quartiers.";
	public static String ARCHIVISTE=
		"L'Archiviste pioche 7 cartes et en conserve 1 de son choix. " +
		"Son permis de construire est de 2 quartiers.";
	public static String NAVIGATRICE=
		"La Navigatrice gagne 4 pi�ce d'or ou 4 cartes. Elle ne " +
		"ne peut b�tir de quartiers.";
	public static String CAPITAINE=
		"Le Capitaine peut confisquer un quartier de co�t inf�rieur " +
		"ou �gal � 3, en payant son co�t � son propri�taire." +
		"Chaque quartier Militaire dans sa cit� lui rapporte 1 " +
		"pi�ce d'or.";
	public static String DIPLOMATE=
		"Le Diplomate peut �changer l'un de ses quartiers b�tis " +
		"avec un quartier adverse. Chaque quartier Militaire " +
		"dans sa cit� lui rapporte 1 pi�ce d'or.";
	public static String CONDOTTIERE=
		"Le Condottiere peut d�truire un quartier en payant " +
		"son co�t de construction moins 1. " +
		"Chaque quartier Militaire dans sa cit� lui rapporte 1 " +
		"pi�ce d'or.";
	public static String ARTISTE=
		"L'Artiste peut embellir un ou deux de ses quartiers en " +
		"leur assignant 1 pi�ce d'or. Un m�me quartier ne peut �tre " +
		"embelli qu'une seule fois.";
	public static String BAILLI=
		"Chaque fois qu'un joueur b�tit un quartier, il doit placer " +
		"1 pi�ce d'or sur le jeton Bailli. Prenez toutes les pi�ces" +
		"d'or sur le jeton Bailli.";
	public static String REINE=
		"Si la Reine est à côté du joueur qui a choisi la carte " +
		"du personnage de rang 4 (gemme jaune), elle reçoit 3 " +
		"pi�ces d'or.";
	public static String BIBLIOTHEQUE="Si vous choisissez de piocher des cartes au debut du tour, concervez-les toutes.";
	public static String CARRIERE="Vous pouvez batir des quartiers identiques a d’autres quartiers de votre cite. Le proprietaire de la carriere peut batir autant de quartiers identiques qu’il le souhaite, mais ne peut pas utiliser le pouvoir de l’Echevin, du Diplomate ou du Capitaine pour acqu ́erir des quartiers identiques.";
	public static String COURS="Pour le calcul du score final, la Cour des Miracles est consideree comme un quartier de type (couleur) de votre choix. Dans la cas ou le proprietaire la considere comme un quartier noble, militaire, marchant ou religieux, la Cour des Miracles ne peut plus etre consideree comme une merveille.";
	public static String DONJON="Le Donjon ne peut être affect ́e par les pouvoirs des personnages de rang 8.";
	public static String DRACOPORT="Marquez 2 points supplémentaires à la fin de la partie.";
	public static String MAGIE="Pour la perception des revenus des personnages, l’Ecole de Magie est considérée comme un quartier du type (couleur) de votre choix.";
	public static String FONTAINE="A la fin de la partie, marquez 1 point supplméntaire par merveille dans votre cité, y compris la Fontaine aux Souhaits.";
	public static String FORGE="Une fois par tour, vous pouvez payez 2 pièces d’or pour piocher 3 cartes.";
	public static String LABORATOIRE="Une fois par tour, vous pouvez défausser 1 carte pour recevoir 2 pièces d’or.";
	public static String MANUFACTURE="Payez 1 pièce d’or de moins lorsque vous bâtissez une autre merveille.";
	public static String CARTE="A la fin de la partie, marquez 1 point supplémentaire par carte dans votre main.";
	public static String STATUE="Si vous détenez le Couronne `a la fin de la partie, marquez 5 points supplémentaires.";
	public static String TRESOR="A la fin de la partie, marquez 1 point supplémentaire par pièce d’or dans votre trésor.";
	public static String TRIPOT="Vous pouvez payer tout ou partie du coût de construction du Tripot en cartes de votre main,\n"
			+ "au prix de 1 carte pour 1 pièce d’or. Si le Tripot est confisqué par l’Echevin, le joueur n’est rembours ́e que de l’or qu’il a dépensé, pas des cartes.";
	public static String OBJECTIF="Deux \u0012a huit joueurs s'a\u000Brontent pour construire le plus rapidement possible la plus prestigieuse\n" +
			"cit\u0013e. Pour cela, chaque joueur devra construire des quartiers, ayant chacun des co^uts di\u000B\u0013erents.\n" +
			"Comme dans un jeu de r^ole, chaque joueur doit se mettre dans la peau d'un personnage, \u0012a ceci\n" +
			"pr\u0012es que les joueurs changent de personnage \u0012a chaque tour de jeu. Ces personnages ont chacun des\n" +
			"pouvoirs particuliers : la meilleure stat\u0013egie est de choisir un personnage au bon moment du jeu.";
	public static String PERSONNAGE="Assassin : Annoncez le personnage que vous assassinez. Si un joueur a ce personnage, il ne doit\n" +
			"pas r\u0013eagir tout de suite, mais lorsque le personnage assassin\u0013e sera appel\u0013e. Le personnage\n" +
			"assassin\u0013e passe son tour.\n"+
			"\n"+
			"Voleur : Annoncez le personnage que vous volez. Si un joueur a ce personnage, il ne doit pas\n" +
			"r\u0013eagir. Lorsque le personnage vol\u0013e sera appel\u0013e et r\u0013ev\u0013el\u0013e, vous lui prendrez toutes ces pi\u0012eces\n" +
			"d'or. Vous ne pouvez voler ni le personnage de rang 1 (Assassin, Sorci\u0012ere ou \u0013Echevin), ni le\n" +
			"personnage assassin\u0013e ou ensorcel\u0013e.\n"+
			"\n"+
			"Magicienne: Vous pouvez au choix :\n" +
			"  soit echanger toutes les cartes de votre main avec celles d'un autre joueur ; si vous n'avez\n" +
			"aucune carte en main, vous prenez simplement les cartes de l'autre joueur,\n" +
			"  soit defausser un certain nombre de cartes de votre main, les placer sous la pioche et\n" +
			"piocher le meme nombre de cartes du dessus de la pioche.\n"+
			"\n"+
			"Roi: Recevez une pi\u0012ece d'or pour chaque quartier Noble dans votre cit\u0013e.\n" +
			"Vous devez prendre la Couronne. C'est d\u0013esormais vous qui appelerez les personnages. En\n" +
			"outre, au prochain tour, et aux tours suivants jusqu'\u0012a ce qu'un autre joueur r\u0013ev\u0012ele le Roi,\n" +
			"vous choisirez votre personnage en premier.\n" +
			"Si vous ^etes assassin\u0013e, vous passez votre tour comme n'importe quel personnage. N\u0013eanmoins,\n" +
			"apr\u0012es que tous les autres joueurs ont jou\u0013e, vous r\u0013ev\u0013elez que vous aviez choisi le Roi et, en\n" +
			"tant qu'h\u0013eritier du Roi assassin\u0013e, prenez la Couronne.\n" +
			"Si vous ^etes ensorcel\u0013e, vous prenez quand m^eme la Couronne.\n" +
			"Si le Roi est \u0013ecart\u0013e face visible en d\u0013ebut de tour, remplacez-le par le personnage suivant et\n" +
			"m\u0013elangez-le avec les personnages restants.\n"+
			"\u0013Ev^eque: Recevez 1 pi\u0012ece d'or pour chaque quartier religieux dans votre cit\u0013e.\n" +
			"Vos quartiers ne peuvent pas ^etre a\u000Bect\u0013es par les pouvoirs des personnages de rang 8 (Condot-\n" +
			"tiere, Diplomate, Capitaine).\n" +
			"Si vous ^etes assassin\u0013e, vous n'^etes plus \u0013Ev^eque ; vous ^etes mort, et vos Quartiers peuvent\n" +
			"donc ^etre la cible des personnages de rang 8. De m^eme, si vous ^etes ensorcel\u0013e, les quartiers\n" +
			"de la Sorci\u0012ere sont prot\u0013eg\u0013es contre les personnages de rang 8, mais pas les v^otres.\n"+
			"\n"+
			"Ev^eque : Recevez 1 pi\u0012ece d'or pour chaque quartier religieux dans votre cit\u0013e.\n" +
			"Vos quartiers ne peuvent pas ^etre a\u000Bect\u0013es par les pouvoirs des personnages de rang 8 (Condot-\n" +
			"tiere, Diplomate, Capitaine).\n" +
			"Si vous ^etes assassin\u0013e, vous n'^etes plus \u0013Ev^eque ; vous ^etes mort, et vos Quartiers peuvent\n" +
			"donc ^etre la cible des personnages de rang 8. De m^eme, si vous ^etes ensorcel\u0013e, les quartiers\n"+
			"\n"+
			"Marchande :Recevez 1 pi\u0012ece d'or pour chaque quartier Commer\u0018cant dans votre cit\u0013e.\n" +
			"Recevez 1 pi\u0012ece d'or suppl\u0013ementaire quel que soit le type de ressources (pi\u0012ece d'or ou carte)\n" +
			"que vous avez prises au d\u0013ebut de votre tour.\n "+
			"\n"+
			"Architecte: Piochez 2 cartes Quartier et ajoutez-les \u0012a votre main.\n" +
			"Vous pouvez b^atir jusqu'\u0012a 3 quartiers durant votre tour.\n"+
			"\n"+
			"Condottiere :Recevez 1 pi\u0012ece d'or pour chaque quartier Militaire dans votre cit\u0013e.\n" +
			"Vous pouvez d\u0013etruire un quartier de votre choix dans une cit\u0013e en payant son co^ut de construc-\n" +
			"tion moins 1. Vous pouvez donc d\u0013etruire gratuitement un quartier de co^ut 1, ou payer 1 pi\u0012ece\n" +
			"d'or pour d\u0013etruire un quartier de co^ut 2, etc.\n" +
			"Vous ne pouvez d\u0013etruire un quartier d'une cit\u0013e d\u0013ej\u0012a compl\u0012ete. Vous pouvez d\u0013etruire l'un de\n" +
			"vos propres quartiers. Les quartiers d\u0013etruits sont d\u0013efauss\u0013es, face cach\u0013ee, en dessous de la\n" +
			"pioche.\n"+
			"\n";
	public static String TOUR="Les tours des joueurs ne se succ\u0012edent pas dans le sens habituel des aiguilles d'une montre, mais\n" +
			"dans l'ordre croissant des rangs des Personnages. Dans le jeu de plateau, le joueur qui d\u0013etient\n" +
			"la Couronne appelle les Personnages les uns apr\u0012es les autres en commen\u0018cant donc par le rang 1\n" +
			"(Assassin, Sorci\u0012ere ou \u0013Echevin), et ainsi de suite. Dans cette version \u0013electronique, c'est l'application\n" +
			"qui appelera les Personnages.\n" +
			"Lorsqu'un Personnage est appel\u0013e, le joueur qui l'a choisi r\u0013ev\u0012ele la carte Personnage et commence\n" +
			"\u0012a jouer. Chaque joueur :\n" +
			"1. re\u0018coit des ressources en choisissant :\n" +
			"| soit de recevoir 2 pi\u0012eces d'or de la banque, ou\n" +
			"| soit de piocher 2 cartes Quartier, en conserver une et remettre l'autre sous la pioche.\n" +
			"2. puis (de mani\u0012ere indi\u000B\u0013erente si aucune pr\u0013ecision n'est indiqu\u0013ee) :\n" +
			"| re\u0018coit les ressources sp\u0013eci\fques \u0012a son Personnage, ainsi que les ressources que lui procure\n" +
			"les Merveilles de sa cit\u0013e,\n" +
			"| utilise le pouvoir de son Personnage,\n" +
			"| et peut b^atir ou non un quartier dans sa cit\u0013e en payant son co^ut de construction.\n" +
			"Le joueur ne peut utiliser son pouvoir qu'une seule fois par tour. De la m^eme mani\u0012ere, le joueur\n" +
			"ne peut b^atir qu'un seul quartier par tour (sauf indication contraire) et ne peut pas b^atir deux fois\n" +
			"le m^eme quartier de m^eme nom (sauf indication contraire).";
	public static String FIN="Les tours se succ\u0012edent jusqu'\u0012a ce qu'un des joueurs poss\u0012ede une cit\u0013e compl\u0012ete : c'est \u0012a dire une\n" +
			"cit\u0013e de 7 quartiers ou plus pour les parties de 4 \u0012a 7 joueurs, ou une cit\u0013e de 8 quartiers pour les\n" +
			"parties a 2, 3 ou 8 joueurs. On ach\u0012eve alors le tour et la partie est termin\u0013ee.\n" +
			"6 Le calcul des points\n" +
			"A\n" +
			"l'issue de la partie, chaque joueur calcule ses points en additionnant :\n" +
			"la somme totale des co^uts de contruction des quartiers de sa cit\u0013e,\n" +
			"3 points suppl\u0013ementaires si la cit\u0013e comprend au moins un quartier de cinq types differents\n" +
			"(Noble, Commer\u0018cant, Religieux, Militaire et Merveille),\n" +
			"4 points supplementaires s'il est le premier joueur ayant compl\u0013et\u0013e sa cite,\n" +
			"2 points suppl\u0013ementaires si sa cite est complete mais qu'il n'a pas \u0013et\u0013e le premier \u0012a la completer,\n" +
			"et enfin la somme des differents bonus eventuels des Merveilles de sa cite.\n" +
			"Le joueur qui a le score le plus eleve est vainqueur. En cas d'egalite, la victoire revient a celui\n" +
			"qui a revele le personnage de rang le plus eleve au dernier tour.";

}
