package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.platzverkauf;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BarzahlungsWerkzeug extends PlatzVerkaufsWerkzeug
{
	private BarzahlungsWerkzeugUI _ui;
	
	public BarzahlungsWerkzeug()
	{
		_ui = new BarzahlungsWerkzeugUI();
	}
	
	  //TODO _restBetragTextField.addPropertyChangeListener("value",this);(!)
	
    /**
     * Setzt den Gesamtpreis für das Feld _text1 (Gesamtbetrag).
     * 
     * @param int preis
     */
    public void setGesamtpreis( int preis)
    {
    	//reminder: int preis ist nur lokal.
    	_ui.getGesamtpreisLabel().setText(preis+ "");
    }
        
    /**
     * Setzt den Restbetrag in abhängigkeit vom Gesamtpreis und der _eingabe fest im Feld _restBetragTextLabel.
     * 
     * @param int gesamtpreis
     */
    public void setRestbetrag(int gesamtpreis)
   
    {
    	 //TODO reminder: int gesamtpreis ist gerade nur lokal.
    }
}
