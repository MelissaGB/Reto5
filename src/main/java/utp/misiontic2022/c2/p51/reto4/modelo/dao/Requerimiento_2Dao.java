package utp.misiontic2022.c2.p51.reto4.modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utp.misiontic2022.c2.p51.reto4.modelo.vo.Requerimiento_2;
import utp.misiontic2022.c2.p51.reto4.util.JDBCUtilities;

public class Requerimiento_2Dao {
    public ArrayList<Requerimiento_2> requerimiento2() throws SQLException {
        var responses = new ArrayList<Requerimiento_2>();
        
        String consulta = "SELECT DISTINCT p.Constructora , p.Ciudad" 
                            +" FROM Proyecto p " 
                            +" WHERE p.Ciudad LIKE 'B%'"
                            +" ORDER by p.Ciudad;";

        try (var connection = JDBCUtilities.getConnection();
        var statement = connection.prepareStatement(consulta);
        var rset = statement.executeQuery()) {
            
            while(rset.next()){
                var requerimiento_2VO = new Requerimiento_2();
                requerimiento_2VO.setConstructora(rset.getString("Constructora"));
                requerimiento_2VO.setCiudad(rset.getString("Ciudad"));

                responses.add(requerimiento_2VO);
            }

        } 
        return responses;
    }
}