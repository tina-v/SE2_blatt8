package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.barzahlung;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


// import javax.swing.SwingUtilities;

public class BarzahlungsWerkzeug
{
	// UI zum Werkzeug
    private BarzahlungsWerkzeugUI _ui;
    // der zu zahlende Preis
    private int _gesamtpreis;
    // gibt an, ob Verkauf erfolgreich war
    private boolean _verkauf;

    /**
     * Erzeugt ein neues BarzahlungsWerkzeug. 
     * (Preis soll aus dem Platzverkaufswerkzeug uebergeben werden.)
     *  
     * @param gesamtpreis der zu zahlende Gesamtpreis fuer die ausgewaehlten Plaetze  
     */
    public BarzahlungsWerkzeug(int gesamtpreis)
    {
        _gesamtpreis = gesamtpreis;
        _ui = new BarzahlungsWerkzeugUI(_gesamtpreis);
        
        // OK-Button erstmal inaktiv gesetzt
        _ui.getVerkaufenButton().setEnabled(false); 
        
        registriereUIAktionen();
        _ui.zeigeFenster();
    }

    private void registriereUIAktionen()
    {
        // TODO Aktionen tatsächlich registrieren (funktioniert anscheinend nicht)

        //Verkaufen-Button
        _ui.getVerkaufenButton().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                verkaufeKarten();
                
            }
        });

        //Abbruchsbutton
        _ui.getAbbrechenButton().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                brecheVerkaufAb();
            }
        });

        //Geldeingabe
       
        _ui.getEingabepreisTextfield().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                beruecksichtigePreiseingabe();
            }
        });
        
    }

    /**
     * Aktion, die ausgefuehrt wird wenn ein neuer Geldbetrag eingegeben wird.
     */
    private void beruecksichtigePreiseingabe() 
    {
        //int geldeingabe = Integer.parseInt(_ui.getEingabepreisTextfield().getText());
        
        int geldeingabe = ((Number)_ui.getEingabepreisTextfield().getValue()).intValue();
        
        if ((_gesamtpreis - geldeingabe) <= 0)
        {
            //Wechselgeld setzen
            _ui.getWechselgeldLabel().setText((geldeingabe - _gesamtpreis) + "");
            //Button aktivieren
            _ui.getVerkaufenButton().setEnabled(true);
        }
        else
        {
            _ui.getVerkaufenButton().setEnabled(false);
        }
    }

    /**
     * Aktion, die ausgefuehrt wird wenn der "Abbrechen" Button gedrueckt wird.
     */
    private void brecheVerkaufAb()
    {
        _verkauf = false;
        _ui.schliesseFenster(); 
    }

    /**
     * Aktion, die ausgefuehrt wird, wenn der "Verkaufen" Button gedrueckt wird.
     */
    private void verkaufeKarten()
    {
    	_verkauf = true;
    	_ui.schliesseFenster(); 
    }

    /**
     * Gibt an, ob der Barverkauf durchgefuehrt oder abgebrochen 
     * 
     * @return _verkauf;
     */
    public boolean verkaufWarErfolgreich()
    {
    	return _verkauf;
    }
}
