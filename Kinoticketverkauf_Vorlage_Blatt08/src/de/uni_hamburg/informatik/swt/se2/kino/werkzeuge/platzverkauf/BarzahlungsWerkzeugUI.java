package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.platzverkauf;

import java.awt.Dialog;
import java.awt.GridLayout;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * Die UI des {@link PlatzVerkaufsWerkzeug}.
 * 
 * @author Ms X
 * @version 16.06
 */
public class BarzahlungsWerkzeugUI
{

    // Die Widgets, aus denen das UI sich zusammensetzt	
    private static final String TITEL = "Dialog Barzahlung";
    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;

    private JDialog _dialog;

    private JPanel _hauptPanel;

    private JLabel _gesamtpreisBeschriftungLabel;
    private JLabel _gesamtpreisLabel;

    private JLabel _eingabepreisBeschriftungLabel;
    private JFormattedTextField _eingabepreisTextfield;

    private JLabel _wechselgeldLabel;
    private JLabel _wechselgeldBetragLabel;

    private JButton _verkaufenButton;
    private JButton _abbrechenButton;

    private int _kartenPreis;

    /**
     * Initialisiert die UI.
     */
    public BarzahlungsWerkzeugUI(int preis)
    {
        _kartenPreis = preis;
        initialisiereEinzelKomponenten();
        initialisiereHauptPanel();
        
        erstelleDialog();

    }

    /**
     * Erstellt das Dialogfenster mit den vorbereiteten Layoutkomponenten.
     */
    private void erstelleDialog()
    {
        _dialog = new JDialog();
        _dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        _dialog.setTitle(TITEL);
        _dialog.setSize(WIDTH, HEIGHT);
        _dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);

        _dialog.add(_hauptPanel);
        _dialog.setVisible(true);
    }

    /**
     * Erstellt das hauptpanel im Gridlayout
     */
    private void initialisiereHauptPanel()
    {
        _hauptPanel = new JPanel();
        _hauptPanel.setLayout(new GridLayout(4,2));
        _hauptPanel.add(_gesamtpreisBeschriftungLabel);
        _hauptPanel.add(_gesamtpreisLabel);
        _hauptPanel.add(_eingabepreisBeschriftungLabel);
        _hauptPanel.add(_eingabepreisTextfield);
        _hauptPanel.add(_wechselgeldBetragLabel);
        _hauptPanel.add(_wechselgeldLabel);
        _hauptPanel.add(_verkaufenButton);
        _hauptPanel.add(_abbrechenButton);
    }

    /**
     * Initialisiert die einzelnen Komponenten des fertigen Layouts
     */
    private void initialisiereEinzelKomponenten()
    {
        _gesamtpreisBeschriftungLabel = new JLabel("Gesamtbetrag:");
        _gesamtpreisLabel = new JLabel(_kartenPreis + "");

        _eingabepreisBeschriftungLabel = new JLabel("Bezahlt:");
        _eingabepreisTextfield = new JFormattedTextField(NumberFormat.getIntegerInstance());
        //http://docs.oracle.com/javase/tutorial/uiswing/components/formattedtextfield.html
        _eingabepreisTextfield.setValue(new Integer(0));

        _wechselgeldBetragLabel = new JLabel("Restbetrag/Rückgeld:");
        _wechselgeldLabel = new JLabel("0");
        
        _verkaufenButton = new JButton("Verkaufen");
        _abbrechenButton = new JButton("Abbrechen");
        
    }


    /**
     * gibt das _verkaufenButton wieder.
     * @return _verkaufenButton
     */
    public JButton getVerkaufenButton()
    {
        return _verkaufenButton;
    }

    /**
     * gibt das _abbrechenButton wieder.
     * @return _abbrechenButton
     */
    public JButton getAbbrechenButton()
    {
        return _abbrechenButton;
    }

    /**
     * gibt das _hauptPanel wieder.
     * @return _hauptPanel
     */
    public JPanel getUIPanel()
    {
        return _hauptPanel;
    }
}
