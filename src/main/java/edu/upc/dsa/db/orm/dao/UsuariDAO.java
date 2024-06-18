
package edu.upc.dsa.db.orm.dao;

import edu.upc.dsa.models.Usuari;

import java.util.List;

public interface UsuariDAO {

    public void addUsuari(String nom, String cognom, String nomusuari, String password, String password2, int coins);

    public Usuari getUsuari(int employeeID);
}
    /*
    public void updateUsuari(int employeeID, String name, String surname, double salary);
    public void deleteUsuari(int employeeID);

    public List<Usuari> getUsuaris();
    public List <Usuari> getUsuariByDept(int deptId);
*/