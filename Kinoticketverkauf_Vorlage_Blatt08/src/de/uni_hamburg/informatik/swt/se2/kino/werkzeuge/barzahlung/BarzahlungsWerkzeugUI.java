package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.barzahlung;

import java.awt.GridLayout;
import java.awt.Dialog;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
// import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.platzverkauf.PlatzVerkaufsWerkzeug;

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

    private JLabel _gesamtpreisBeschriftung;
    private JLabel _gesamtpreisBetrag;

    private JLabel _eingabepreisBeschriftung;
    private JFormattedTextField _eingabepreisTextfield;

    private JLabel _wechselgeldBetrag;
    private JLabel _wechselgeldBeschriftung;

    private JButton _verkaufenButton;
    private JButton _abbrechenButton;

    private int _kartenPreis;

    /**
     * Initialisiert die UI.
     * 
     * @param preis der gesamtpreis der zu verkaufenden Karten
     * 
     * @require preis >= 0
     */
    public BarzahlungsWerkzeugUI(int preis)
    {
        assert preis >= 0 : "Vorbedingung verletzt";

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

    }

    /**
     * Setzt das Fenster auf sichtbar (aus dem Konstruktor herausgezogen)
     */
    public void zeigeFenster()
    {
        _dialog.setVisible(true);
    }

    /**
     * Erstellt das Hauptpanel im Gridlayout
     */
    private void initialisiereHauptPanel()
    {
        _hauptPanel = new JPanel();
        _hauptPanel.setLayout(new GridLayout(4, 2));
        _hauptPanel.add(_gesamtpreisBeschriftung);
        _hauptPanel.add(_gesamtpreisBetrag);
        _hauptPanel.add(_eingabepreisBeschriftung);
        _hauptPanel.add(_eingabepreisTextfield);
        _hauptPanel.add(_wechselgeldBeschriftung);
        _hauptPanel.add(_wechselgeldBetrag);
        _hauptPanel.add(_verkaufenButton);
        _hauptPanel.add(_abbrechenButton);
    }

    /**
     * Initialisiert die einzelnen Komponenten des fertigen Layouts
     */
    private void initialisiereEinzelKomponenten()
    {
        _gesamtpreisBeschriftung = new JLabel("Gesamtbetrag:");
        _gesamtpreisBetrag = new JLabel(_kartenPreis + "");

        _eingabepreisBeschriftung = new JLabel(
                "Bezahlt (mit enter bestätigen):");
        _eingabepreisTextfield = new JFormattedTextField(
                NumberFormat.getIntegerInstance());
        //http://docs.oracle.com/javase/tutorial/uiswing/components/formattedtextfield.html
        _eingabepreisTextfield.setValue(new Integer(0));

        _wechselgeldBeschriftung = new JLabel("Restbetrag/Rückgeld:");
        _wechselgeldBetrag = new JLabel("0");

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
     * Gibt das Eingabefeld für den Preis zurueck
     * 
     * @return _eingabepreisTextfield
     */
    public JFormattedTextField getEingabepreisTextfield()
    {
        return _eingabepreisTextfield;
    }

    /**
     * Gibt das _hauptPanel wieder.
     * 
     * @return _hauptPanel
     */
    public JPanel getUIPanel()
    {
        return _hauptPanel;
    }

    /**
     * Gibt das JLabel für den Wechselgeldbetragzurueck.
     * 
     * @return _wechselgeldBetrag
     */
    public JLabel getWechselgeldLabel()
    {
        return _wechselgeldBetrag;
    }

    /**
     * Schließt das Dialogfenster des UI.
     */
    public void schliesseFenster()
    {
        _dialog.dispose();
    }
}
