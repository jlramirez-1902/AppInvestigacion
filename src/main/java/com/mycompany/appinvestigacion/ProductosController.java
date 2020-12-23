package com.mycompany.appinvestigacion;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author usuario
 */
public class ProductosController implements Initializable {

    private static final Logger LOG = Logger.getLogger(ProductosController.class.getName());
    

    @FXML
    private ComboBox<String> cmbIva;
    @FXML
    private ComboBox<Marca> cmbMarca;
    //Declaración de la clase en donde se encuentra la conexión a la base de datos
    private ConexionBD conex;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //Establecer la forma en el que el combo va a mostrar los ítems en el menú
        this.cmbMarca.setCellFactory((ListView<Marca> l)->{
            
            return new ListCell<Marca>(){
                @Override
                protected void updateItem(Marca m, boolean empty){
                    if(!empty){
                        this.setText("("+m.getCodigo()+") "+m.getDescripcion());
                    }else{
                        this.setText("");
                    }
                    super.updateItem(m, empty);
                }
            };
        });
        
        //Establecer la forma en que el combo va a mostrar la marca seleccioinada
        this.cmbMarca.setButtonCell(new ListCell<Marca>(){
                @Override
                protected void updateItem(Marca m, boolean empty){
                    if(!empty){
                        this.setText("("+m.getCodigo()+") "+m.getDescripcion());
                    }else{
                        this.setText("");
                    }
                    super.updateItem(m, empty);
                }
            }
        );
            
        //Cargar los posibles valores en el combo de IVA
        this.cmbIva.getItems().add("10%");
        this.cmbIva.getItems().add("5%");
        this.cmbIva.getItems().add("Excento");
        this.cmbIva.getSelectionModel().selectFirst();

        //Se crea la conexion a la base de datos con la clase creada para el efecto
        this.conex = new ConexionBD();
        //Invocamos al metodo que trae los registros de la tabla marca para cargar en el combo
        this.cargarMarcas();
    }

    //Metodo que consulta a la base de datos y carga las marcas en el combo
    private void cargarMarcas(){
        try{
            String sql = "SELECT * FROM marca";
            Statement stm = this.conex.getConexion().createStatement();
            ResultSet resultado = stm.executeQuery(sql);
            while(resultado.next()){
                this.cmbMarca.getItems().add(new Marca(resultado.getInt("idmarca"), resultado.getString("descripcion")));
            }
        }catch(SQLException ex){
            LOG.log(Level.SEVERE, "Error al cargar Marcas", ex);
        }
    }
    
}
