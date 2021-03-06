/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.vezbazatermin;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.VezbaZaTermin;
import java.sql.SQLException;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Kujovic
 */
public class SOGetAllVezbaZaTermin extends AbstractSO {
    
    private ArrayList<VezbaZaTermin> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof VezbaZaTermin)) {
            throw new Exception("Prosledjeni objekat nije instanca klase VezbaZaTermin!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {
        ArrayList<AbstractDomainObject> listaVezbi = 
                      (ArrayList<AbstractDomainObject>) DBBroker.getInstance().select(ado);
        lista = (ArrayList<VezbaZaTermin>) (ArrayList<?>) listaVezbi;
    }

    public ArrayList<VezbaZaTermin> getLista() {
        return lista;
    }
}
