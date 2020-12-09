import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BinApoPanel extends JPanel implements ActionListener
{
    private JButton btnGauche = new JButton("0"), btnDroite = new JButton("1");
    private BinApoTextField textField = new BinApoTextField();
    private int numLig, numCol;


    public BinApoPanel(int v, int numLig, int numCol)
    {
        super(new BorderLayout());

        this.numLig = numLig;
        this.numCol = numCol;

        JPanel pnlButtons = new JPanel(new GridLayout(1, 0));
        add(pnlButtons, "North");
        pnlButtons.add(btnGauche);
        pnlButtons.add(btnDroite);
        btnGauche.addActionListener(this);
        btnDroite.addActionListener(this);

        add(textField, "Center");

        textField.setText(conv(v));

        setBackground(Color.BLACK);
    }

    public JButton getGauche()
    {
        return btnGauche;
    }

    public JButton getDroite()
    {
        return btnDroite;
    }

    public int getValeur()
    {
        switch (textField.getText())
        {
            case " ": // case vide
                return -1;
            case "0": // cas 0
                return 0;
            case "1": // cas 1
                return 1;
            default:
                throw new IllegalArgumentException("Gros problème : "+textField.getText()+" dans une case");
        }
    }

    public int getLigne()
    {
        return numLig;
    }

    public int getColonne()
    {
        return numCol;
    }

    public void setValeur(int v)
    {
        textField.setText(conv(v));
    }

    private String conv(int v)
    {
        switch (v)
        {
            case -1: // case vide
                return " ";
            case 0: // cas 0
                return "0";
            case 1: // cas 1
                return "1";
            default:
                throw new IllegalArgumentException("Gros problème : "+v+" à mettre dans une case");
        }
    }

    @Override
    public void setEnabled(boolean enabled)
    {
        super.setEnabled(enabled);
        textField.setEnabled(false);
        btnGauche.setEnabled(false);
        btnDroite.setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if (textField.getText().equals(ae.getActionCommand()))
                textField.setText(" ");
            else
                textField.setText(ae.getActionCommand());
    }

    public void reset()
    {
        super.setEnabled(true);
        textField.setEnabled(true);
        btnGauche.setEnabled(true);
        btnDroite.setEnabled(true);
        textField.setText(" ");
    }

    public static void main(String[] args)
    {
        JFrame jf = new JFrame("Exemple d'un seul BinApoPanel");
        jf.setContentPane((new BinApoPanel(-1, 0, 0)));
        jf.pack();
        jf.setVisible(true);
    }
}

