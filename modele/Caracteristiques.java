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
}
