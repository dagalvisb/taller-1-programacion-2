public class Nino {
    
    String nombre;
    int edad;
    boolean tieneMaterialesEpeciales;
    boolean tieneClasesIntensivas;
    boolean tieneTalleresFinDeSemana;


    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public boolean isTieneMaterialesEpeciales() {
        return tieneMaterialesEpeciales;
    }
    public void setTieneMaterialesEpeciales(boolean tieneMaterialesEpeciales) {
        this.tieneMaterialesEpeciales = tieneMaterialesEpeciales;
    }
    public boolean isTieneClasesIntensivas() {
        return tieneClasesIntensivas;
    }
    public void setTieneClasesIntensivas(boolean tieneClasesIntensivas) {
        this.tieneClasesIntensivas = tieneClasesIntensivas;
    }
    public boolean isTieneTalleresFinDeSemana() {
        return tieneTalleresFinDeSemana;
    }
    public void setTieneTalleresFinDeSemana(boolean tieneTalleresFinDeSemana) {
        this.tieneTalleresFinDeSemana = tieneTalleresFinDeSemana;
    }

    public Nino(String nombre, int edad, boolean tieneMaterialesEpeciales, boolean tieneClasesIntensivas, boolean tieneTalleresFinDeSemana){
        this.nombre= nombre;
        this.edad= edad;
        this.tieneMaterialesEpeciales = tieneMaterialesEpeciales;
        this.tieneClasesIntensivas = tieneClasesIntensivas;
        this.tieneTalleresFinDeSemana = tieneTalleresFinDeSemana;
    }
}
