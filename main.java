import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class main {
    public static void main(String[] args) {
        //
        DecimalFormat formater = new DecimalFormat("###,###.##");
        //
        ArrayList<Programa> programas = new ArrayList<>();

        Programa dibujo = new Programa("Dibujo", 2500000, 6, 7);
        Programa pintura = new Programa("Pintura", 2700000, 8, 9);
        Programa Escultura = new Programa("Escultura", 3000000, 10, 12);

        programas.add(dibujo);
        programas.add(pintura);
        programas.add(Escultura);

        int deseaAñadirNuevoNino = JOptionPane.YES_OPTION;

        double totalEscuela = 0;

        do{
            String nombre = JOptionPane.showInputDialog("Ingrese nombre del niño:");
            String edadTxt = JOptionPane.showInputDialog("Ingrese la edad de " + nombre + " :");
            int edad = Integer.parseInt(edadTxt);

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
                int deseaMatricular = JOptionPane.showConfirmDialog(null, "Le aplica el programa " + programaAplicable.getNombre() + " con el valor " +  formater.format(programaAplicable.getValorBase()), "¿Desea matricular el niño?", JOptionPane.YES_NO_OPTION);

                if (deseaMatricular == JOptionPane.YES_OPTION){

                    double totalAPagar = programaAplicable.getValorBase();
                    Nino niño = new Nino(nombre,edad,false,false,false);

                    programaAplicable.obtenerEstudiantes().add(niño);

                    int tieneMaterialesEpeciales = JOptionPane.showConfirmDialog(null, "¿Desea añadir materiales especiales por un valor de: " + formater.format(programaAplicable.VALOR_MATERIALES_ESPECIALES) + "?", "Añadir valor adicional", JOptionPane.YES_NO_OPTION);
                    if (tieneMaterialesEpeciales == JOptionPane.YES_OPTION){
                        niño.setTieneMaterialesEpeciales(true);
                        totalAPagar += programaAplicable.VALOR_MATERIALES_ESPECIALES;
                    }

                    int tieneClasesIntensivas = JOptionPane.showConfirmDialog(null, "¿Desea añadir clases intensivas por un valor de: " + formater.format(programaAplicable.VALOR_CLASES_INTENSIVAS) + "?", "Añadir valor adicional", JOptionPane.YES_NO_OPTION);
                    if (tieneClasesIntensivas == JOptionPane.YES_OPTION){
                        niño.setTieneClasesIntensivas(true);
                        totalAPagar += programaAplicable.VALOR_CLASES_INTENSIVAS;
                    }

                    int tieneTalleresFinDeSemana = JOptionPane.showConfirmDialog(null, "¿Desea añadir Talleres de fin de semana por un valor de: " + formater.format(programaAplicable.VALOR_TALLERES_FIN_DE_SEMANA)  + "?", "Añadir valor adicional", JOptionPane.YES_NO_OPTION);
                    if (tieneTalleresFinDeSemana == JOptionPane.YES_OPTION){
                        niño.setTieneTalleresFinDeSemana(true);
                        totalAPagar += programaAplicable.VALOR_TALLERES_FIN_DE_SEMANA;
                    }

                    JOptionPane.showMessageDialog(null, "Valor total a pagar: " + formater.format(totalAPagar), "VALOR TOTAL", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            
            deseaAñadirNuevoNino = JOptionPane.showConfirmDialog(null, "Desea añadir nuevo niño?", "continuar", JOptionPane.YES_NO_CANCEL_OPTION);
        } while(deseaAñadirNuevoNino == JOptionPane.YES_OPTION);
        
        String informacion = "";
        for (Programa programa : programas) {

            double totalPrograma = 0;
            informacion += "Nombre Programa: " + programa.getNombre() + "\n";
            ArrayList<Nino> estudiantesPrograma = programa.obtenerEstudiantes();

            if (programa.obtenerEstudiantes().size() > 0){
                for (Nino niño : estudiantesPrograma){

                    double materiales = 0;
                    double clases = 0;
                    double finDeSemana = 0;
                    
                    if (niño.isTieneMaterialesEpeciales() == true){
                        materiales = programa.VALOR_MATERIALES_ESPECIALES;
                    }

                    if (niño.isTieneClasesIntensivas() == true){
                        clases = programa.VALOR_CLASES_INTENSIVAS;
                    }

                    if (niño.isTieneTalleresFinDeSemana() == true){
                        finDeSemana = programa.VALOR_TALLERES_FIN_DE_SEMANA;
                    }

                    double totalPorNino = programa.getValorBase() + materiales + clases + finDeSemana;

                    informacion += String.format("------------------------------------------------------------\n" + "* %s (%d)\n -Base: $%s %n -Materiales: %s \n -Clase internsiva: %s \n -Talleres fin de semana: %s \n TOTAL A PAGAR: %s \n", niño.getNombre(), niño.getEdad(), formater.format(programa.getValorBase()), formater.format(materiales), formater.format(clases), formater.format(finDeSemana), formater.format(totalPorNino));

                    totalPrograma += totalPorNino;
                }
            }else{
                informacion += "No hay estudiantes matriculados en este programa. \n ";
            }
            
            totalEscuela += totalPrograma;

            informacion += "------------------------------------------------------------\n" + "TOTAL PROGRAMA: " + formater.format(totalPrograma) + "\n------------------------------------------------------------\n\n";
        }

        informacion += "------------------------------------------------------------\n" + "TOTAL ESCUELA: " + formater.format(totalEscuela) + "\n------------------------------------------------------------\n\n";
        JOptionPane.showMessageDialog(null, informacion);

    }
}
