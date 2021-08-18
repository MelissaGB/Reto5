package utp.misiontic2022.c2.p51.reto4.vista;

import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;


import utp.misiontic2022.c2.p51.reto4.controlador.ControladorRequerimientos;
import utp.misiontic2022.c2.p51.reto4.modelo.vo.Requerimiento_1;
//import utp.misiontic2022.c2.p51.reto4.modelo.vo.Requerimiento_2;
import utp.misiontic2022.c2.p51.reto4.modelo.vo.Requerimiento_2;
//import utp.misiontic2022.c2.p51.reto4.modelo.vo.Requerimiento_3;
import utp.misiontic2022.c2.p51.reto4.modelo.vo.Requerimiento_3;



public class VentanaRequeriemiento2 extends JFrame {
    
    private  ControladorRequerimientos controlador;
    private  ControladorRequerimientos controlador2;
    private  ControladorRequerimientos controlador3;

    private JTable tabla;
    private JTable tabla2;
    private JTable tabla3;


    public VentanaRequeriemiento2(){

        controlador = new ControladorRequerimientos();
        controlador2 = new ControladorRequerimientos();
        controlador3 = new ControladorRequerimientos();

        initUI();

        setLocationRelativeTo(null);

    }

    private void initUI(){
        setTitle("Interfaz Reto 5");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,600);

        var tbd = new JTabbedPane();
        

        getContentPane().add(tbd, BorderLayout.CENTER);
       

        var panel = new JPanel();
        var panel2 = new JPanel();
        var panel3 = new JPanel();
        
        panel.setLayout(new BorderLayout());
        panel2.setLayout(new BorderLayout());
        panel3.setLayout(new BorderLayout());

        tbd.addTab("Consulta Requerimiento 1", panel);
        tbd.addTab("Consulta Requerimiento 2", panel2);
        tbd.addTab("Consulta Requerimiento 3", panel3);

        // Panel
        var panelEntrada = new JPanel();
        panelEntrada.add(new JLabel("Requerimeinto 1 Label"));

        var panelEntrada2 = new JPanel();
        panelEntrada2.add(new JLabel("Requerimeinto 2 Label"));

        var panelEntrada3 = new JPanel();
        panelEntrada3.add(new JLabel("Requerimeinto 3 Label"));
        
        //Boton
        var btnConsulta = new JButton("Consultar!");

        btnConsulta.addActionListener(e -> cargarTablaConsulta());

        var btnConsulta2 = new JButton("Consultar!");

        btnConsulta2.addActionListener(e -> cargarTablaConsulta2());

        var btnConsulta3 = new JButton("Consultar!");

        btnConsulta3.addActionListener(e -> cargarTablaConsulta3());

        //Panel

        panelEntrada.add(btnConsulta);

        panel.add(panelEntrada, BorderLayout.PAGE_START);

        tabla = new JTable();

        panel.add(new JScrollPane(tabla), BorderLayout.CENTER );


        //2
        panelEntrada2.add(btnConsulta2);

        panel2.add(panelEntrada2, BorderLayout.PAGE_START);

        tabla2 = new JTable();

        panel2.add(new JScrollPane(tabla2), BorderLayout.CENTER );

        //3
        panelEntrada3.add(btnConsulta3);

        panel3.add(panelEntrada3, BorderLayout.PAGE_START);

        tabla3 = new JTable();

        panel3.add(new JScrollPane(tabla3), BorderLayout.CENTER );

    }
    // Consulta 1

    private void cargarTablaConsulta() {
        try {
            var lista = controlador.consultarRequerimiento1();
            var tableModel = new requerimiento1TableModel();
            tableModel.setData(lista);

            tabla.setModel(tableModel);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), getTitle(), JOptionPane.ERROR_MESSAGE);
          
        }
    }

    // Consulta 2

    private void cargarTablaConsulta2() {
        try {
            var lista2 = controlador2.consultarRequerimiento2();
            var tableModel2 = new requerimiento2TableModel();
            tableModel2.setData(lista2);

            tabla2.setModel(tableModel2);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), getTitle(), JOptionPane.ERROR_MESSAGE);
          
        }

    }


    // Consulta 3

    private void cargarTablaConsulta3() {
        try {
            var lista3 = controlador3.consultarRequerimiento3();
            var tableModel3 = new requerimiento3TableModel();
            tableModel3.setData(lista3);

            tabla3.setModel(tableModel3);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), getTitle(), JOptionPane.ERROR_MESSAGE);
          
        }

    }



    //Lista 1

    private class requerimiento1TableModel extends AbstractTableModel{
        private ArrayList<Requerimiento_1> data;

        public void setData(ArrayList<Requerimiento_1> data){
            this.data = data;
        }

        @Override
        public String getColumnName(int column) {
            switch(column){
                case 0: 
                    return "Nombre Material";
                case 1:
                    return "Precio por Unidad";
            }
            return super.getColumnName(column);
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            switch(columnIndex){
                case 0: 
                    return String.class;
                case 1:
                    return Integer.class;
            }
            return super.getColumnClass(columnIndex);
        }

        @Override
        public int getRowCount() {
            return data.size();
        }

        @Override
        public int getColumnCount() {
            return 2;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            var registro = data.get(rowIndex);

            switch(columnIndex){
                case 0: 
                    return registro.getNombreMaterial();
                case 1:
                    return registro.getPrecioUnidad();
            }
            return null;
        }

    }

    //Lista 2

    private class requerimiento2TableModel extends AbstractTableModel{
        private ArrayList<Requerimiento_2> data;

        public void setData(ArrayList<Requerimiento_2> data){
            this.data = data;
        }

        @Override
        public String getColumnName(int column) {
            switch(column){
                case 0: 
                    return "Constructora";
                case 1:
                    return "Ciudad";
            }
            return super.getColumnName(column);
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            switch(columnIndex){
                case 0: 
                    return String.class;
                case 1:
                    return String.class;
            }
            return super.getColumnClass(columnIndex);
        }

        @Override
        public int getRowCount() {
            return data.size();
        }

        @Override
        public int getColumnCount() {
            return 2;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            var registro = data.get(rowIndex);

            switch(columnIndex){
                case 0: 
                    return registro.getConstructora();
                case 1:
                    return registro.getCiudad();
            }
            return null;
        }

    }


    //Lista 3

    private class requerimiento3TableModel extends AbstractTableModel{
        private ArrayList<Requerimiento_3> data;

        public void setData(ArrayList<Requerimiento_3> data){
            this.data = data;
        }

        @Override
        public String getColumnName(int column) {
            switch(column){
                case 0: 
                    return "Proveedor";
                case 1:
                    return "Nombre Material";
                case 2: 
                    return "Importado";
                case 3:
                    return "Precio por Unidad";
                case 4:
                    return "Cantidad";  
            }
            return super.getColumnName(column);
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            switch(columnIndex){
                case 0: 
                    return String.class;
                case 1:
                    return String.class;
                case 2: 
                    return String.class;
                case 3:
                    return Integer.class;
                case 4: 
                    return Integer.class;
                
            }
            return super.getColumnClass(columnIndex);
        }

        @Override
        public int getRowCount() {
            return data.size();
        }

        @Override
        public int getColumnCount() {
            return 5;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            var registro = data.get(rowIndex);

            switch(columnIndex){
                case 0:
                    return registro.getProveedor();
                case 1:
                    return registro.getNombreMaterial();
                case 2:
                    return registro.getImportado();
                case 3:
                    return registro.getPrecioUnidad();
                case 4: 
                    return registro.getCantidad();


            }
            return null;
        }

    }

}



