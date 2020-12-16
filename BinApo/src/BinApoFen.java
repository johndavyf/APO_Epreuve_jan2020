import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BinApoFen extends JFrame implements ActionListener
{
    // variables *********************************************************************
    public static final int TAILLE_GRILLE = 8;
    public static final File REP_DEPART = new File("Grilles");
    // buttons
    private JButton btnLire, btnFiger, btnEnregister, btnResoudre;
    private JButton btnPartie2, btnTester, btnRAZ, btnQuitter;
    private JScrollPane logScrollPane;

    BinApoPanel[][] grille = new BinApoPanel[TAILLE_GRILLE][TAILLE_GRILLE];

    // binApoFen ***************************************************************
    //
    BinApoFen(String titre)
    {
        setTitle(titre);
        setDefaultCloseOperation(EXIT_ON_CLOSE); // diff�rence avec DISPOSE_ON_CLOSE


        // Panel de droite ************************************************
        // TODO add panel gauche
        JPanel PanelDroite = new JPanel(new BorderLayout());
        add(PanelDroite, "East");

        // Panel de droite - Bouttons panel du haut *********
        btnLire = new JButton("Lire");
        btnLire.addActionListener(this);

        btnFiger = new JButton("Figer");
        btnFiger.addActionListener(this);
        btnFiger.setEnabled(false);

        btnEnregister = new JButton("Enregistrer");
        btnEnregister.addActionListener(this);
        btnEnregister.setEnabled(false);

        btnResoudre = new JButton("Résoudre");
        btnResoudre.addActionListener(this);
        btnResoudre.setEnabled(false);

        JPanel buttonPanelHaut = new JPanel(); // JPanel par défault == use FlowLayout !!!!!!!!!!!!!!!!!
        buttonPanelHaut.add(btnLire);
        buttonPanelHaut.add(btnFiger);
        buttonPanelHaut.add(btnEnregister);
        buttonPanelHaut.add(btnResoudre);

        // Panel de droite  JTextArea ************************************************************
        // JTextArea (de 20 sur 40) non modifiable disposant de barres de défilement
        // verticale et horizontale (qui n’apparaissent que quand c’est nécessaire).

        // Création de JtextArea pour afficher du text
        JTextArea log = new JTextArea(20,40);//5 = nb de lignes, 20 = nb de colonnes
        log.setMargin(new Insets(5,5,5,5));
        log.setEditable(false);
        JScrollPane logScrollPane = new JScrollPane(log);

        // Panel de droite buttonPanelBas ************************************************************
        // btnPartie2, btnTester, btnRAZ, btnQuitter;
        btnPartie2 = new JButton("Partie II");
        btnPartie2.addActionListener(this);

        btnTester = new JButton("Tester");
        btnTester.addActionListener(this);

        btnRAZ = new JButton("RAZ");
        btnRAZ.addActionListener(this);

        btnQuitter = new JButton("Quitter");
        btnQuitter.addActionListener(this);

        JPanel buttonPanelBas = new JPanel(); // JPanel par défault == use FlowLayout !!!!!!!!!!!!!!!!!
        buttonPanelBas.add(btnPartie2);
        buttonPanelBas.add(btnTester);
        buttonPanelBas.add(btnRAZ);
        buttonPanelBas.add(btnQuitter);

        // add to Panel de droite !!!

        PanelDroite.add(buttonPanelHaut, "North");
        PanelDroite.add(logScrollPane, "Center");
        PanelDroite.add(buttonPanelBas, "South");




    }

    public void actionPerformed(ActionEvent ae)
    {

    }




    // fonctions données par le prof ************************************

    public static String findExtension(File f)
    {
        if ( f != null )
        {
            String s = f.getName();
            int posDernierPoint = s.lastIndexOf('.');
            if ( posDernierPoint == -1 ) // le fichier n'a pas d'extension
                return "";
            else
                return s.substring(posDernierPoint+1).toLowerCase();
        }
        return "";
    }

    private void afficher(JTextArea log, String message)
    {
        log.append(message+System.lineSeparator());
    }
}
