package exercice_java_7_form.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import exercice_java_7_form.metier.Contact;

public class MainWindow extends JFrame implements ActionListener,
												  ListSelectionListener,
												  DocumentListener {

	
	
	private JPanel panelHaut;
	private JScrollPane panelDroit;
	private JScrollPane panelCentre;
	
	private List<Contact> fullContacts;
	private DefaultListModel<String> referentsVisibles;
	private DefaultListModel<Contact> contactsVisibles;
	
	private JList<String> affichageReferents;
	private JList<Contact> affichageContacts;
	
	private Predicate<Contact> filtreReferent;
	private Predicate<Contact> filtreGold;
	private Predicate<Contact> filtreAge;
	private Comparator<Contact> triContact;
	
	private JCheckBox goldOnly;
	private JTextField saisieAge;
	
	private JComboBox<String> choixTri;
	
	
	
	public MainWindow() throws HeadlessException {
		super("repertoire cloud agile");
		setSize(800, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout());
		
		// preparation données
		fullContacts = new ArrayList<>();
		fullContacts.add(new Contact(1, "Van Damme", "Jean claude", "aware@fullcircle.com", 'M', 56, true, "bob"));
		fullContacts.add(new Contact(2, "Genial", "Tortue", "strong@kamehouse.com", 'M', 150, false, "karin"));
		fullContacts.add(new Contact(3, "Uzumaki", "naruto", "naruto@ramenforever.com", 'M', 15, false, "bob"));
		fullContacts.add(new Contact(4, "Haruno", "Sakura", "sakura@sasukefanclub.com", 'F', 15, true, "tsunade"));
		fullContacts.add(new Contact(5, "Li", "Chun", "fighter@china.com", 'F', 35, true, "tsunade"));
		fullContacts.add(new Contact(6, "kenshiro", "ken", "atatatatata@punch.com", 'M', 40, false, "bob"));
		fullContacts.add(new Contact(7, "Matrix", "John", "commando@badass.com", 'M', 75, true, "karin"));
		fullContacts.add(new Contact(8, "Anderson", "Thomas", "neo@gothic.com", 'M', 27, false, "morpheus"));
		fullContacts.add(new Contact(9, "Li", "Jet", "dragon@fureur.com", 'M', 29, true, "morpheus"));
		
		// panel haut
		panelHaut = new JPanel();
		BoxLayout bl = new BoxLayout(panelHaut, BoxLayout.X_AXIS);
		panelHaut.setLayout(bl);
		panelHaut.add(new JLabel("trier par"));
		choixTri = new JComboBox<>(new String[]{Contact.TRI_ID,
												Contact.TRI_NOM,
												Contact.TRI_PRENOM,
												Contact.TRI_NOM_PRENOM,
												Contact.TRI_EMAIL,
												Contact.TRI_AGE});
		panelHaut.add(choixTri);
		
		panelHaut.add(new JLabel("age"));
		saisieAge = new JTextField(10);
		panelHaut.add(saisieAge);
		goldOnly = new JCheckBox("gold only");
		goldOnly.addActionListener(this);
		panelHaut.add(goldOnly);
		
		
		
		
		add(panelHaut, BorderLayout.NORTH);
		
		// panel centre
		contactsVisibles = new DefaultListModel<>();
		affichageContacts = new JList<>(contactsVisibles);
		panelCentre = new JScrollPane(affichageContacts);
		
		add(panelCentre, BorderLayout.CENTER);
		
		referentsVisibles = new DefaultListModel<>();
		affichageReferents = new JList<>(referentsVisibles);
		
		panelDroit = new JScrollPane(affichageReferents);
		add(panelDroit, BorderLayout.EAST);
	
		// mise en place evenement, filtres, stream, etc
		fullContacts.stream()
					.map(c -> c.getReferent())
					.distinct()
					.forEach(s -> referentsVisibles.addElement(s));
		referentsVisibles.addElement("tous");
		
		
		filtreReferent = c -> true;
		filtreGold = c -> true;
		filtreAge = c -> true;
		triContact = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
		
		affichageReferents.addListSelectionListener(this);
		
		saisieAge.getDocument().addDocumentListener(this);
		ageChanged();
		choixTri.addActionListener(this);
		
		refreshFullContacts();
	}
	
	private void refreshFullContacts() {
		contactsVisibles.clear();
		fullContacts.stream()
					.filter(filtreReferent)
					.filter(filtreGold)
					.filter(filtreAge)
					.sorted(triContact)
					.forEach(c -> contactsVisibles.addElement(c));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		filtreGold = Contact.getGoldFilter(goldOnly.isSelected());
		triContact = Contact.getTri(choixTri.getSelectedItem().toString());
		refreshFullContacts();
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		filtreReferent = Contact.getReferentFilter(affichageReferents.getSelectedValue());
		refreshFullContacts();
	}

	private void ageChanged() {
		String contenu = saisieAge.getText();
		try {
			int age = Integer.parseInt(contenu);
			saisieAge.setBackground(Color.green);
			filtreAge = Contact.getAgeFilter(age);
		}
		catch (NumberFormatException ex) {
			saisieAge.setBackground(Color.pink);
			//filtreAge = Contact.getAgeFilter(Integer.MAX_VALUE);
			filtreAge = c -> true;
		}
		refreshFullContacts();
	}
	
	@Override
	public void insertUpdate(DocumentEvent e) {ageChanged();}
	@Override
	public void removeUpdate(DocumentEvent e) {ageChanged();}
	@Override
	public void changedUpdate(DocumentEvent e) {ageChanged();}

}
