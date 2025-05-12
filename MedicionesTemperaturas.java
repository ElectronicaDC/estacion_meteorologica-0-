import java.util.ArrayList; 
/**
 * Registros de temperaturas diarios de una estacion meteorológica
 *                        (rama1)
 */
public class MedicionesTemperaturas
{
    /**
     * Contiene las mediciones de temperaturas.
     */
    private ArrayList<Integer> registros;
    
    /**
     * Dia del registro
     */
    private int dia;
    
    /**
     * Mes del registro
     */
    private int mes;
    
    /**
     * Constructor de la clase. Inicializa dia y mes con los parámetros respectivos,
     * y la lista de registros se inicializa vacía (sin mediciones).
     * Precondición: 
     *  - dia debe ser un día válido (entre 1 y 31)
     *  - mes debe ser un mes válido (entre 1 y 12)
     */
    public MedicionesTemperaturas(int dia, int mes) {
        assert dia >= 1 && dia <= 31;
        assert mes >= 1 && mes <= 12;
        this.dia = dia;
        this.mes = mes;
        this.registros = new ArrayList<Integer>();
    }
    
    /**
     * Agrega una temperatura al registro de temperaturas
     */
    public void agregarRegistro(int nuevaTemperatura) {
        registros.add(new Integer(nuevaTemperatura));
    }
    
    /**
     * Muestra todas las temperaturas registradas en 
     * la pantalla. 
     */
    public void imprimirTemperaturas() {
        System.out.println(dia + "/" + mes);
        int pos = 0;
        for (Integer temperatura: registros) {
            System.out.print(pos + ": ");
            System.out.println(temperatura + "C");
            pos = pos + 1;
        }
    }
    
    /**
     * Muestra las temeperaturas extremas, que son las inferiores a -15
     * y superiores a 35 grados.
     */
    public int cantTemExtrema(){
        int contador = 0; 
        for(Integer temp:registros){
            if(temp<-15 || temp>35){
                contador += 1;
            }
        }
        return contador;
    }
    
    /**
     * Muestra la temperatura promedio de todas las mediciones. 
     */
    public double promedioTem(){
        if(registros.size() == 0 ){
            return 0;
        }
        double suma = 0; 
        for(Integer temp : registros){
            suma+= temp;
        }
        return suma / registros.size();
    }
    
    /**
     * Muestra la temperatura maxima de todas las mediciones registradas.
     */
    public int maximaTemp(){
        if(registros.size() == 0){
            return 0;
            }
        int maxima = registros.get(1);
        for(Integer temp:registros){
            if(temp > maxima){
                maxima = temp;
            }
        }
        return maxima;
    }
    
    /**
     * Muestra la temepratura minima de todas las mediciones registradas.
     */
    public int minimaTemp(){
        if(registros.size() == 0){
            return 0;
        }
        int minima = registros.get(1);
        for(Integer temp:registros){
            if(temp < minima){
                minima = temp;
            }
        }
        return minima;
    }
    
    /**
     * Muestra la amlitud termica de las temperaturas registradas.
     */
    public int amplitudtemp(){
        int minima = registros.get(0);
        int maxima = registros.get(0);
        int amplitud = 0;
        for(Integer temp:registros){
            if(temp>minima){
                maxima = temp;
            }else{
                minima = temp;
            }
        }
        return amplitud = maxima - minima; 
    }
    
    /**
     * Muestra la cantidad de mediciones consecutivas con una misma temperatura.
     */
    public int cantTempConsecutivas(){
        if(registros.size() == 0 || registros.size() == 1){
            return 0;
        }
        boolean serie = false;
        int anterior = registros.get(0);
        int contador = 0;
        int i = 1;
        while(i<registros.size()){
            if(registros.get(i).equals(anterior)){
                if(!serie){
                    contador++;
                    serie = true;
                }else{
                    serie = false;
                }
                anterior = registros.get(i);
            }
            i ++;
        }
        return contador;
    }
}


       
        
        

        

