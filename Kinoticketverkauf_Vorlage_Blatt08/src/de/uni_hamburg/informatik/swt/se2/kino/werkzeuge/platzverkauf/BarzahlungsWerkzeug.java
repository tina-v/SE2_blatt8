package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.platzverkauf;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        // TODO Aktionen tatsächlich registrieren

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
