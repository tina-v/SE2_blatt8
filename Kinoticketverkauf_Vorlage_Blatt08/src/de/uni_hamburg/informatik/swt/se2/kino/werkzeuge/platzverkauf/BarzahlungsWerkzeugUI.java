package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.platzverkauf;

import java.awt.GridLayout;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Die UI des {@link PlatzVerkaufsWerkzeug}.
 * 
 * @author Ms X
 * @version 16.06
 */
public class BarzahlungsWerkzeugUI {
	
	    // Die Widgets, aus denen das UI sich zusammensetzt	
		private JPanel _hauptPanel;
	    private JLabel _text1;
	    private JLabel _text2;
	    private JLabel _text3;
	    private GridLayout _BarzahlungsFenster;
	    private JLabel _restBetragTextLabel;
	    private JFormattedTextField _eingabefeld;
	    private JLabel _preisLabel;
	    private JButton _verkaufenButton;
	    private JButton _abbrechenButton;
	    
	   
	    /**
	     * Initialisiert die UI.
	     */
	    public BarzahlungsWerkzeugUI()
	    {
	    	_hauptPanel = new JPanel(erstellePanel());	
		     _text1 = new JLabel("Gesamtbetrag:");
		     _text2 = new JLabel("Bezahlt:");
		     _text3 = new JLabel("Restbetrag/Rückgeld:");
		     _restBetragTextLabel = new JLabel("0");
		     
		     _eingabefeld = new JFormattedTextField(NumberFormat.getNumberInstance());
		     //http://docs.oracle.com/javase/tutorial/uiswing/components/formattedtextfield.html
		     _eingabefeld.setValue(new Integer(0));
		     
		     _preisLabel = new JLabel();
		     _verkaufenButton = new JButton();
		     _abbrechenButton = new JButton();    	
	    }

	    /**
	     * Erzeugt den Layoutmanager, in dem Gesamtbetrag, Restbetrag, Eingabefeld dargestellt
	     * wird.
	     */
	    private GridLayout erstellePanel()
	    {
	        _BarzahlungsFenster = new GridLayout(4,2);
	        _BarzahlungsFenster.addLayoutComponent("Gesamtbetrag",_text1);
	        //Gesamtpreis ist gegen Anfang 0.
	        _BarzahlungsFenster.addLayoutComponent("0", _preisLabel);
	        _BarzahlungsFenster.addLayoutComponent("Bezahlt", _text2);
	        _BarzahlungsFenster.addLayoutComponent("Eingabefeld", _eingabefeld);
	        _BarzahlungsFenster.addLayoutComponent("Restbetrag", _text3);
	        _BarzahlungsFenster.addLayoutComponent("0", _restBetragTextLabel);
	        _BarzahlungsFenster.addLayoutComponent("Zahlen", _verkaufenButton);
	        _BarzahlungsFenster.addLayoutComponent("Abbrechen", _abbrechenButton);
	        
	        return _BarzahlungsFenster;
	    }
	    
		/**
	     * gibt das _restBetragTextLabel wieder.
	     * @return _restBetragTextLabel
	     */
	    public JLabel getRestbetrag() 
	    {
			return _restBetragTextLabel;
		}

		/**
	     * gibt das _preisLabel wieder.
	     * @return _preisLabel
	     */
	    public JLabel getGesamtpreisLabel()
	    {
	    	return _preisLabel;
	    }
	    
	    /**
	     * gibt das _eingabefeld wieder.
	     * @return _eingabefeld
	     */
	    public JFormattedTextField getEingabefeld()
	    {
	    	return _eingabefeld;
	    }
	    
	    /**
	     * gibt das _erestBetragTextField wieder.
	     * @return _erestBetragTextField
	     */
	    public JLabel getRestbetragFeld()
	    {
	    	return _restBetragTextLabel;
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

