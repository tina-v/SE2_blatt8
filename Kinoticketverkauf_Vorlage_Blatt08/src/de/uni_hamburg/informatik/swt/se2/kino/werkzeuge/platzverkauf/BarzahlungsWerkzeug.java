package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.platzverkauf;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.platzverkauf.BarzahlungsWerkzeugUI;


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
     * (Da der Preis im Platzverkaufswerkzeug verfügbar ist, macht eine Übergabe Sinn) 
     * 
     * @param gesamtpreis der zu zahlende Gesamtpreis fuer die ausgewaehlten Plaetze  
     */
    public BarzahlungsWerkzeug(int gesamtpreis)
    {
        _gesamtpreis = gesamtpreis;
        _ui = new BarzahlungsWerkzeugUI(_gesamtpreis);
        // OK-Button erstmal inaktiv gesetzt
        _ui.setVerkaufenButtonAktiv(false);
        registriereUIAktionen();
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
                fuehreVerkaufWeiter();
                
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

    private void beruecksichtigePreiseingabe(int gezahlterBetrag)
    {
        // TODO Wechselgeld berechnen, Button-Aktivität steuern
        System.out.println("Preis verändert"); //(als Test)
        
        
        
        
      
    }

    private void brecheVerkaufAb()
    {
        // TODO Verkaufsabbruch implementieren, kommentieren
        // System.out.println("Abbruch"); //(als Test)
        
        //_ui. Methode Zum Fensterschliessen
        _verkauf = false;

    }

    private void fuehreVerkaufWeiter()
    {
        // TODO Verkaufsaktion implementieren, kommentieren
        // System.out.println("Verkauf"); //(als Test)
    	
    	//_ui- Methode zum Fensterschliessen
    	_verkauf = true;
    	
        
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
    
    public boolean verkaufWarErfolgreich()
    {
    	return _verkauf;
    }
}
