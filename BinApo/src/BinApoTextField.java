import javax.swing.*;
import java.awt.*;

public class BinApoTextField extends JTextField
{
    public static final Color BLEU = Color.BLUE;
    public static final Color ROUGE = Color.RED;
    public static final Color GRIS = Color.darkGray;

    private static final Font CELL_FONT = new Font("Dialog", Font.BOLD, 28);//28 = 12 + 16

    public BinApoTextField()
    {
        this("", 0);
    }

    public BinApoTextField(String text)
    {
        this(text, 0);
    }

    public BinApoTextField(int columns)
    {
        this("", columns);
    }

    public BinApoTextField(String text, int columns)
    {
        super(text, columns);
        setHorizontalAlignment(CENTER);
        setFont(CELL_FONT);
        setMargin(new Insets(14,0,14,0));// (top, left, bottom, right)
        setForeground(Color.BLUE);
        setEditable(false);
        setBackground(Color.WHITE);
    }

    public void setCouleur(Color k)
    {
        setForeground(k);
    }
}
