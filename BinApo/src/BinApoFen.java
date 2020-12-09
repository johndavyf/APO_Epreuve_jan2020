import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BinApoFen
{
    public static final int TAILLE_GRILLE = 8;
    public static final File REP_DEPART = new File("Grilles");

    BinApoPanel[][] grille = new BinApoPanel[TAILLE_GRILLE][TAILLE_GRILLE];

    BinApoFen(String titre)
    {
        setTitle(aTitle);

    }


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
