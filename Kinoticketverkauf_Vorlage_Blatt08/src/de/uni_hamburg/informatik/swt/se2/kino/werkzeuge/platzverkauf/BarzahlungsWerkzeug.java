package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.platzverkauf;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

public class BarzahlungsWerkzeug //erbt nicht mehr
{
    private BarzahlungsWerkzeugUI _ui;
    private int _gesamtpreis;

    /**
     * Erzeugt ein neues BarzahlungsWerkzeug. 
     * (Da der Preis im Platzverkaufswerkzeug verfügbar ist, macht eine Übergabe Sinn) 
     * 
     * @param gesamtpreis der zu bezahlende Kartenpreis  
     */
    public BarzahlungsWerkzeug(int gesamtpreis)
    {
        _ui = new BarzahlungsWerkzeugUI(gesamtpreis);
        _gesamtpreis = gesamtpreis;
        registriereUIAktionen();
    }

    private void registriereUIAktionen()
    {
        // TODO Aktionen tatsächlich registrieren (funktioniert anscheinend nicht)

        //Verkaufen-Button
        _ui.getVerkaufenButton()
        .addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                fuehreVerkaufWeiter();
            }
        });

        //Abbruchsbutton
        _ui.getAbbrechenButton()
        .addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                brecheVerkaufAb();
            }
        });

        //Geldeingabe
        _ui.getEingabepreisTextfield()
        .addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                beruecksichtigePreiseingabe();
            }
        });
        
    }

    private void beruecksichtigePreiseingabe()
    {
        // TODO Wechselgeld berechnen, Button-Aktivität steuern
        System.out.println("Preis verändert"); //(als Test)
        
      
    }

    private void brecheVerkaufAb()
    {
        // TODO Verkaufsabbruch implementieren, kommentieren
        System.out.println("Abbruch"); //(als Test)

    }

    private void fuehreVerkaufWeiter()
    {
        // TODO Verkaufsaktion implementieren, kommentieren
        System.out.println("Verkauf"); //(als Test)
        
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
