import java.util.ArrayList;
import javax.swing.JOptionPane;

public class main {
    public static void main(String[] args) {

        String nombre = JOptionPane.showInputDialog("Ingrese nombre del niño:");
        String edadTxt = JOptionPane.showInputDialog("Ingrese la edad de " + nombre + " :");
        int edad = Integer.parseInt(edadTxt);
        ArrayList<Programa> programas = new ArrayList<>();

        Programa dibujo = new Programa("Dibujo", 2500000, 6, 7);
        Programa pintura = new Programa("Pintura", 2700000, 8, 9);
        Programa Escultura = new Programa("Escultura", 3000000, 10, 12);

        programas.add(dibujo);
        programas.add(pintura);
        programas.add(Escultura);

        Programa programaAplicable = null;
        
        for (Programa programa : programas){
            if(edad >= programa.getEdadMinima() && edad <= programa.getEdadMaxima()){
                programaAplicable = programa;
                break;
            }
        }

        if (programaAplicable == null){
            JOptionPane.showMessageDialog(null, "No hay programa aplicable");
        }else {
            JOptionPane.showMessageDialog(null, "Le aplica el programa " + programaAplicable.getNombre() + " con el valor " +  programaAplicable.getValorBase());
        }

        
    }
}
