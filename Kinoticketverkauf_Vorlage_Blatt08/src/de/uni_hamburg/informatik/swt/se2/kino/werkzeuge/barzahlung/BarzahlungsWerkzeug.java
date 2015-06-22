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
     * (Da der Preis im Platzverkaufswerkzeug verfügbar ist, macht eine Übergabe Sinn) 
     * 
     * @param gesamtpreis der zu zahlende Gesamtpreis fuer die ausgewaehlten Plaetze  
     */
    public BarzahlungsWerkzeug(int gesamtpreis)
    {
        _gesamtpreis = gesamtpreis;
        _ui = new BarzahlungsWerkzeugUI(_gesamtpreis);
        // OK-Button erstmal inaktiv gesetzt
        //_ui.setVerkaufenButtonAktiv(false);
        _ui.getVerkaufenButton().setEnabled(false); //funktioniert auch ohne Methode :)
        
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

    private void beruecksichtigePreiseingabe() //abfrage preis unten, so wieder kompilierbar
    {
        // TODO Wechselgeld berechnen, Button-Aktivität steuern
        //System.out.println("Preis verändert"); //(als Test)
        int geldeingabe = Integer.parseInt(_ui.getEingabepreisTextfield().getText());
        
        if ((_gesamtpreis - geldeingabe) <= 0)
        {
            //Wechselgeld setzen
            _ui.getWechselgeldLabel().setText((geldeingabe - _gesamtpreis) + "");
            //Button aktivieren
            _ui.getVerkaufenButton().setEnabled(true);
        }
    }

    private void brecheVerkaufAb()
    {
        // TODO Verkaufsabbruch implementieren, kommentieren
        // System.out.println("Abbruch"); //(als Test)
        
        _verkauf = false;
        _ui.close(); //_ui. Methode Zum Fensterschliessen
    }

    private void verkaufeKarten()
    {
        // TODO Verkaufsaktion implementieren, kommentieren
        // System.out.println("Verkauf"); //(als Test)
    	
    	_verkauf = true;
    	_ui.close(); //_ui- Methode zum Fensterschliessen
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
