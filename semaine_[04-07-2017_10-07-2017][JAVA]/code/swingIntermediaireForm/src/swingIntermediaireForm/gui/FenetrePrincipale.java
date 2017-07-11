package swingIntermediaireForm.gui;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import swingIntermediaireForm.metier.Produit;

public class FenetrePrincipale extends JFrame implements ListSelectionListener {

	private JPanel paneltri;
	private JList<String> listeCategories;
	
	private JButton triNomBt;
	private JButton triPrixBt;
	private JButton triPoidsBt;
	
	// le model/données affichée par le composant graphique
	private DefaultListModel<Produit> produitsVisiblesData;
	// composant graphique affiché
	private JList<Produit> produitsVisibles;
	
	private ArrayList<Produit> produitFullData;
	
	// variable stockant le lambda qui servira a filter les produits par categorie
	private Predicate<Produit> currentFilter;

	
	
	public FenetrePrincipale() throws HeadlessException {
		super("ma super application");
		setSize(500, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		produitFullData = new ArrayList<>();
		produitFullData.add(new Produit(1, "steak de lama", 49.99, 1.2, "viandes"));
		produitFullData.add(new Produit(2, "tofu tout fou", 29.99, 0.750, "fromages"));
		produitFullData.add(new Produit(3, "quinoa des andes", 39.99, 1.0, "cereales"));
		produitFullData.add(new Produit(4, "miel des carpathes", 59.99, 1.0, "divers"));
		produitFullData.add(new Produit(5, "oignon rouges", 9.99, 1.1, "legumes"));
		produitFullData.add(new Produit(6, "brebis des alpes", 15.99, 0.35, "fromages"));
		produitFullData.add(new Produit(7, "boeuf yogique", 69.99, 0.75, "viandes"));
		produitFullData.add(new Produit(8, "ble sans gluten", 27.50, 2.0, "cereales"));
		produitFullData.add(new Produit(9, "poulet plein air", 17.50, 1.8, "viandes"));
		
		// layout de la partie de nord de la fenetre avec les boutons de tri
		paneltri = new JPanel();
		// organisation horizontale de mes boutons dans cette partie nord (panelTri)
		BoxLayout bl = new BoxLayout(paneltri, BoxLayout.X_AXIS);
		paneltri.setLayout(bl);
		
		triNomBt = new JButton("trier par nom");
		paneltri.add(triNomBt);
		triPrixBt = new JButton("trier par prix");
		paneltri.add(triPrixBt);
		triPoidsBt = new JButton("trier par poids");
		paneltri.add(triPoidsBt);
		
		// ajout du panel en haut de la fenetre principale
		add(paneltri, BorderLayout.NORTH);
		
		List<String> categorieNames =
				produitFullData.stream()			// le flux de produit
							   .map(p -> p.getCategorie()) // transformation en flux de categorie
							   .distinct()
							   .collect(Collectors.toList()); // recupération dans une liste
		categorieNames.add("toutes");
		
		
		
		// partie ouest, liste des categorie pour filtrage
		listeCategories = new JList<>(categorieNames.toArray(new String[0]));
		
		// j'ajoute ma liste dans un panel defilant a l'ouest de la fenetre principale
		add(new JScrollPane(listeCategories), BorderLayout.WEST);
		
		// partie centrale de la fenetre, la liste des produits
		produitsVisiblesData = new DefaultListModel<>();
		produitsVisibles = new JList<>(produitsVisiblesData);
		
		add(new JScrollPane(produitsVisibles));
		
		
		
		
	/*	// copie la liste integrale des produits dans les produits a afficher
		// en filtrant et triant celle-ci
		produitFullData.stream()
						.filter(p -> p.getCategorie().equals("viandes"))
						.sorted((p1, p2) -> Double.compare(p1.getPrix(), p2.getPrix()))
						.forEach(p -> produitsVisiblesData.addElement(p));
		*/
		// je choisi un filtre
		currentFilter = Produit.getFilter("toutes");
		// je rafraichis la liste affichée
		refreshList();
		
		// ecouter la liste des categories
		listeCategories.addListSelectionListener(this);
		
	}
	
	private void refreshList() {
		produitsVisiblesData.clear();
		
		produitFullData.stream()
			.filter(currentFilter)
			.sorted((p1, p2) -> Double.compare(p1.getPrix(), p2.getPrix()))
			.forEach(p -> produitsVisiblesData.addElement(p));
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		String choix = listeCategories.getSelectedValue();
		if (choix == null)
			currentFilter = Produit.getFilter("toutes");
		else
			currentFilter = Produit.getFilter(choix);
		refreshList();
		
		/*switch(listeCategories.getSelectedValue()) {
			case "viandes"	: currentFilter = Produit.VIANDES_CATEGORIES_FILTER; break;
			case "legumes"	: currentFilter = Produit.LEGUMES_CATEGORIES_FILTER; break;
			case "cereales" : currentFilter = Produit.CEREALES_CATEGORIES_FILTER; break;
			case "fromages" : currentFilter = Produit.FROMAGES_CATEGORIES_FILTER; break;
			case "divers"	: currentFilter = Produit.DIVERS_CATEGORIES_FILTER; break;
			default 		: currentFilter = Produit.ALL_CATEGORIES_FILTER; break;
		}
		refreshList();*/
	}
	
	

}
