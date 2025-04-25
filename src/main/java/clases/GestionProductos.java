package clases;

import com.santi.dao.ProductoDao;
import com.santi.entidades.Producto;

import javax.swing.*;
import java.util.List;
public class GestionProductos {
    ProductoDao miProductoDao = new ProductoDao();
    public GestionProductos() {
        String menu="MENU DE OPCIONES - GESTION PRODUCTOS\n\n";
        menu+="1. Registrar Producto\n";
        menu+="2. Consultar Producto\n";
        menu+="3. Consultar Lista de Productos\n";
        menu+="4. Comprar Productos\n";
        menu+="5. Actualizar Producto\n";
        menu+="6. Eliminar Producto\n";
        menu+="7. Salir\n";
        int opc=0;
        while(opc!=7) {
            opc=Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch (opc) {
                case 1: registrar(); break;
                case 2: consultar(); break;
                case 3: consultarLista();break;
                case 4: comprarProductos(); break;
                case 5: actualizar(); break;
                case 6: eliminar(); break;
                case 7: miProductoDao.close(); break;
            }
        }
    }
    private void registrar() {
        Producto miProducto = new Producto();
        miProducto.setIdProducto(null);
        miProducto.setNombreProducto(JOptionPane.showInputDialog("Ingrese el nombre del Producto"));
        miProducto.setPrecioProducto(Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del Producto")));
        System.out.println(miProductoDao.registrarProducto(miProducto));
        System.out.println();
    }
    private void consultar() {
        Long idMascota = Long.parseLong(JOptionPane.showInputDialog("Ingrese el id del Producto"));
        Producto miProducto = miProductoDao.consultarProducto(idMascota);
        if (miProducto != null) {
            System.out.println(miProducto);
            System.out.println();
        } else {
            System.out.println();
            System.out.println("No se encontró el Producto");
        }
        System.out.println();



    }
    private void consultarLista() {
        System.out.println("Lista de Productos");
        List<Producto> listaProductos = miProductoDao.consultarListaProductos();
        for (Producto producto : listaProductos) {
            System.out.println(producto);
        }
    }
    private void actualizar() {
        Long idProducto = Long.parseLong(JOptionPane.showInputDialog("Ingrese el id del Producto para actualizar"));
        Producto miProducto = miProductoDao.consultarProducto(idProducto);
        if (miProducto != null) {
            System.out.println(miProducto);
            System.out.println();
            miProducto.setNombreProducto(JOptionPane.showInputDialog("Ingrese el nombre del Producto"));
            miProducto.setPrecioProducto(Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del Producto")));
            System.out.println(miProductoDao.actualizarProducto(miProducto));
            System.out.println();
        } else {
            System.out.println();
            System.out.println("No se encontró el Producto");
        }
        System.out.println();
    }
    private void eliminar() {
        Long idProducto = Long.parseLong(JOptionPane.showInputDialog("Ingrese el id del Producto para eliminar"));
        Producto miProducto = miProductoDao.consultarProducto(idProducto);
        if (miProducto != null) {
            System.out.println(miProducto);
            System.out.println();
            System.out.println(miProductoDao.eliminarProducto(miProducto));
            System.out.println();
        } else {
            System.out.println();
            System.out.println("No se encontró el Producto");
        }
        System.out.println();
    }
    /*Metodo vacio por ahora para posteriormente agregar la logica de compra*/
    private void comprarProductos() {
    }
}
