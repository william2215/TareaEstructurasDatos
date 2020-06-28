package cr.ac.ulead.logica;
import cr.ac.ulead.models.Mascota;
import cr.ac.ulead.models.Persona;
import cr.ac.ulead.tda.Cola;
import cr.ac.ulead.tda.ColaSerializadorUlead;
import cr.ac.ulead.tda.Pila;
import cr.ac.ulead.ui.UIUtils;

public class Logic {
    public void execute(int logic) {
        UIUtils ui = new UIUtils();
        switch (logic){
            case 1:
                try{
                    Persona persona = new Persona();
                    if (ui.eleccion("\n Digite 0 si quiere JSON o 1 si quiere XML")){
                        ui.print(ui.llenarPersona(persona).serializadorJSON());
                    }else{
                        ui.print(ui.llenarPersona(persona).serializadorXML());
                    }
                }catch (Exception e){
                    ui.print("Estas llenando los datos mal");
                }
                break;
            case 2:
                try{
                    Mascota mascota = new Mascota();
                    if (ui.eleccion("\n Digite 0 si quiere JSON o 1 si quiere XML")){
                        ui.print(ui.llenarMascota(mascota).serializadorJSON());
                    }else{
                        ui.print(ui.llenarMascota(mascota).serializadorXML());
                    }
                }catch (Exception e){
                    ui.print("Estas llenando los datos mal");
                }
                break;
            case 3:
                try{
                    int i = 0;
                    Pila pila = new Pila(50);
                    while (i < 50) {
                        Persona personaPila = new Persona();
                        ui.print("\n Estas en el intento " + i + " te faltan " + (50 - i) + " \n");
                        ui.print("De la opcion 1 llenar persona,  2 sacar o 3 buscar");
                        int opcion = ui.darOpcion();
                        if (opcion == 1){
                            i++;
                            pila.push(ui.llenarPersona(personaPila));
                        }else if(opcion == 2){
                            i--;
                            ui.print(pila.pop().serializadorJSON());
                        }else{
                            System.out.println("Menor estatura es " + pila.menorEstatura());
                        }
                    }
                }catch (Exception e){
                    ui.print(e.getMessage());
                }
                break;
            case 4:
                try{
                    int i = 0;
                    Cola cola = new Cola(50);
                    while ( i < 50) {
                        Mascota newMascotaCola = new Mascota();
                        ui.print("\n Estas en el intento " + i + " te faltan " + (50 - i) + " \n");
                        boolean estaSacando = ui.eleccion("0 para sacar elemento, 1 para meter elemento");
                        if (!estaSacando){
                            i++;
                            cola.enQueue(ui.llenarMascota(newMascotaCola));
                        }else{
                            i--;
                            ui.print(cola.deQueue().serializadorJSON());
                        }
                    }
                }catch (Exception e){
                    ui.print(e.getMessage());
                }
                break;
            case 5:
                try{
                    int i = 0;
                    Mascota newMascotaColaSerializador = new Mascota();
                    Persona newPersonaColaSerializador = new Persona();
                    ColaSerializadorUlead colaSerializadorUlead = new ColaSerializadorUlead(50);
                    while ( i < 50 ) {
                        ui.print("\n Estas en el intento " + i + " te faltan " + (50 - i) + " \n");
                        boolean estaSacando = ui.eleccion("1 para sacar elemento, 0 para meter elemento");
                        if (estaSacando){
                            boolean isHuman = ui.eleccion("1 para elegir persona, 0 para elegir mascota");
                            if (!isHuman){
                                i++;
                                colaSerializadorUlead.enQueue(ui.llenarPersona(newPersonaColaSerializador));
                            }else{
                                i++;
                                colaSerializadorUlead.enQueue(ui.llenarMascota(newMascotaColaSerializador));
                            }
                        }else{
                            i--;
                            ui.print(colaSerializadorUlead.deQueue().serializadorJSON());
                        }
                    }
                }catch (Exception e){
                    ui.print(e.getMessage());
                }
            default:
                break;
        }
    }
}
