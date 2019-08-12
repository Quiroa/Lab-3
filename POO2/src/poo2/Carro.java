/*
Nombre: José Alejandro Quiroa Martínez
Carnet: 5090-18-2169
Fecha: 11/8/2019
 */

package poo2;

import java.applet.Applet;
import java.awt.*;
import javax.swing.*;
import javax.swing.JOptionPane;

public class Carro extends Applet {
    
    boolean a=false, c=true;
    String p="123ASD" ,tmp;
    double va=0,vM=0,vm=0,tg=20,ta=50,h=0;
    int op;
    
    /*
    Descripcion de variables:
    a -> Estado del auto: false = Apagado, true = Encendido
    c -> Variable centinela que es utilizada para terminar el siclo "do...while..." y para revisar
        el estado2 del carro: true = el carro funciona, false = el carro se averio
    p -> Placa del auto
    tmp -> Variable temporal para el ingreso de datos
    va -> Velocidad actual del atuo inicializada en 0 km/h
    vM -> Velocidad maxima del auto inicializada en 0 km/h
    vm -> Velocidad minima del auto inicializada en 0 km/h
    tg -> Tanque de gasolina del auto inicializada en 20 Lts
    ta -> Tanque de aceite del auto inicializada en 50 Lts
    h -> Varialbe temporal para el ingreso de datos de todas las demas variables tipo "double"
    op -> Seleccion de la opcion escogida por el usuario
    */
    
    public void init() { //Funcion principal
        do{//Menu
            if (ta<=0 && a){ //En caso de que "ta" alla llegado a 0 y que "a" sea true
                a0(); //Llamado a la funcion a0
                ta=0; //Reinicia la varialbe ta en 0 en caso de que alla llegado a numeros negativos
            }
            else{ //En caso contrario
                if (ta<5 && a) //En caso de que "ta" sea menor a 5 y "a" sea true
                    JOptionPane.showMessageDialog(null,"¡ACEITE APUNTO DE AGOTARSE!\n\n"); //Mensaje de alerta
            } //Fin del "if-esle"
            if (tg<=0 && a){ //En caso de que "tg" alla llegado a 0 y que "a" sea true
                g0(); //Llamado de la funcion g0
                tg=0; //Reinicia la varialbe tg en 0 en caso de que alla llegado a numeros negativos
            }
            else{ //En caso contrario
                if (tg<5 && a) //En caso de que "tg" sea menor a 5 y que "a" sea true
                    JOptionPane.showMessageDialog(null,"¡GASOLINA APUNTO DE AGOTARSE!\n\n"); //Mensaje de alerta
            } //Fin del "if-else"
            tmp=JOptionPane.showInputDialog("       Menu\n\n"
                                          + "1 - Encender Auto\n"
                                          + "2 - Aumentar Velocidad\n"
                                          + "3 - Disminuir Velocidad\n"
                                          + "4 - Cargar Tanque de Gasolina\n"
                                          + "5 - Cargar Tanque de Aceite\n"
                                          + "6 - Mostrar Condiciones del Auto\n"
                                          + "7 - Apagar Auto\n\n"); //Presentacion y seleccion del menu
            op=Integer.parseInt(tmp); //Asignacion de la seleccion del usuario a la variable "op" para compararla posteriormente
            /*
            Las posibles opciones que puede elegir el usuario se clasifican en:
            
                Grupo 1:
                    Opcines que puede elegir el usuario sin nesecidad de encender el auto las
                    cuales son: 1,6,7,"defautl".
            
                Grupo 2:
                    Opciones en las cuales es nesesario encender el atuo para poder acceder
                    a ellas las cuales son: 2,3,4,5
            */
            if (op>=2 && op<=5){ //En caso que el usuario escoja una opcion del grupo 2
                if (!a){ //En caso de que el atuo este apagado
                    JOptionPane.showMessageDialog(null,"Para acceder a esta funcion\n"
                                                     + "debe de encender el auto de primero.\n\n"); //Mensaje de alerta
                }
                else{ //En caso contrario
                    switch (op){ //Inicia condicional "Switch"
                        case 2:
                            mv(); //Llamado a la funcion mv (aumentar velocidad)
                            tg-=2; //Se descuentan 2 unidades del tanque de gasolina
                            ta-=2; //Se descuentan 2 unidades del tanque de aceite
                        break;
                        case 3:
                            if (va>0){ //En caso que la velocidad actual del auto sea mayor a 0
                                dv(); //Llamado a la funcion dv (disminuir velocidad)
                                tg-=2; //Se descuentan 2 unidades del tanque de gasolina
                                ta-=2; //Se descuentan 2 unidades del tanque de aceite
                            }
                            else //En caso contrario
                                JOptionPane.showMessageDialog(null,"La velocidad actual del carro es de 0km/h.\n"
                                                                 + "No puede disminuirle mas la velocidad del auto.\n\n"); //Mensaje de alerta
                            //Fin del "if-else"
                        break;
                        case 4:
                            if (va==0){ //En caso de que la velocidad actual del auto sea igual a 0 (el atuo este detenido)
                            tgas(); //Llamado a la funcion tgas
                            ta-=2; //Se descuentan 2 unidades del tanque de aceite
                            }
                            else{ //En caso contrario
                                JOptionPane.showMessageDialog(null,"Para acceder a esta funcion primero\n"
                                                                 + "debe bajar la velocidad del auto a 0km/h.\n"
                                                                 + "Velocidad actual: "+va); //Mensaje de alerta
                            } //Fin del "if-esle"
                        break;
                        case 5:
                            if (va==0){ //En caso que la velocidad sea igual a 0 (el auto esta detenido)
                            tac(); //Llamado a la funcion tac
                            tg-=2; //Se descuentan 2 unidades del tanque de gasolina
                            }
                            else{ //En caso contrario
                                JOptionPane.showMessageDialog(null,"Para acceder a esta funcion primero\n"
                                                                 + "debe bajar la velocidad del auto a 0km/h.\n"
                                                                 + "Velocidad actual: "+va); //Mensaje de alerta
                            } //Fin del "if-else" 
                        break;
                    } //Finaliza el condicional "switch"
                } //Fin del "if-else"
            }
            else{ //En caso de que el usuario es coja una opcion del grupo 1
                switch (op){ //Inicia condicional "switch"
                    case 1:
                        if (c){ //En caso de que "c" sea true (el auto sirva)
                            en(); //Llamado a la funcion en
                            tg-=2; //Se descuentan 2 unidades del tanque de gasolina
                            ta-=2; //Se descuentan 2 unidades del tanque de aceite
                        }
                        else{ //En caso contrario
                            JOptionPane.showMessageDialog(null,"El carro esta averiado, no se puede encender\n"
                                                             + "en este momento. Porfavor llevelo al mecanio.\n\n"); //Mensaje de alerta
                        }
                    break;
                    case 6:
                        m(); //Llamado a la funcion m
                        if (a){ //En caso de que "a" sea sierto (el atuo este encnedido)
                            tg-=2; //Se descuentan 2 unidades del tanque de gasolina
                            ta-=2; //Se descuentan 2 unidades del tanque de aseite
                        }
                    break;
                    case 7:
                        ap(); //Llamado de la funcion ap
                    break;
                    default:
                        non(); //Llamado de la funcion non (opcion invalida)
                    break;
                } //Finaliza el condicional "switch"
            } //Finaliza el "if-else" (seleccion del grupo de posibles opciones)
        }while (c); //Repetira el siclo "do...while..." mientras que el atuo sirva (c=true)o el usuario decida apagar el atuo (c=true)
        JOptionPane.showMessageDialog(null,"Gracias por visitarnos.\n"
                                         + "Esperamos que vuelva pronto.\n\n"); //Mensaje de agradecimiento por hacer uso del programa
        System.exit(0); //Fin del programa, sierre el programa
    }
    
    public void en(){ //Encender auto
        a=true; //Reasigna la variable "a" en true (estado del atuo: encendido)
        if (tg==0) //En caso de que el tanque de gasolina alla llegado a 0
            tg=5; //Reinicia el tanque de gasolina en 5 unidades
        //Fin del "if"
        if (ta==0) //En caso de que el tanque de aceite alla llegado a 0
            ta=5; //Reinicia el tanque de aceite en 5 unidades
        //Fin del "if"
        JOptionPane.showMessageDialog(null,"El auto a sido encendido exitosamente.\n\n"); //Mensaje de notificacion
    } //Fin de la funcion en
    
    public void mv(){ //aumentar velocidad
        do{ //Solicitud de la velocidad a aumentar
            tmp=JOptionPane.showInputDialog("Ingrese una velocidad en kilometros por hora (km/h)\n"
                                          + "para aumentarle al auto.\n"
                                          + "Velocidad actual: "+va+"km/h.\n\n"); //Solicitud de la velocidad a aumentar
            h=Double.parseDouble(tmp); //Asignacion de las unidades ingresadas por el usuario a una variable "h" para calificar su valor posteriormente
            if (h<0) //En caso de que el usuario ingrese un numero negativo
                JOptionPane.showMessageDialog(null,"El valor que ingreso es invalido.\n"
                                                 + "Porfavor ingrese una velocidad positiva (h>=0).\n\n");//Mensaje de alerta
            //Fin del "if"
            if ((h+va)>250) //En caso de que la velocidad ingresada por el usuario haga que la velocidad del atuo supere su limite
                JOptionPane.showMessageDialog(null,"La velocidad del carro no puede superar\n"
                                                 + "los 250km/h.\n\n"
                                                 + "Velocidad actual del auto: "+va); //Mensaje de alerta
            //Fin del "if"
        }while(h<0 || (h+va)>250); //Repetira el siclo "do...while..."  asta que el usuario escoja un numero positivo y la suma de velocidades no supere el maximo posible por el auto
        va+=h; //Aumenta la velocidad actual del atuo en "h" unidades
        JOptionPane.showMessageDialog(null,"La velocidad del auto\n"
                                         + "se actualizo a: "+va+"km/h\n\n"); //Mensaje de notificacion
        if (va>vM){ //En caso de que la velocidad actual sea mayor a la maxima alcanzada por el usuario
            vM=va; //La velocidad maxima del atuo se actualiza a "va" unidades
        }// Fin del "if"
        if (vm==0) //En caso de que la velocidad minima alcanzada por el auto siga siendo igual a 0 unidades
            vm=va; //Actualiza la velocidad actual del atuo a "va" unidades
        else{ //En caso contrario
            if (va<vm && va>0) //En caso de que la velocidad actual del auto sea menor a la velocidad minima alcanzada por el auto y la velocidad actual del auto sea mayor a 0 unidades
                vm=va; //Actualiza la velocidad minima del atuo a "va" unidades
            //Fin del "if"
        } //Fin del "if-else"
    } //Fin de la funcion mv
    
    public void dv(){ //Disminuir velocidad
        do{ //Solicitud de la velocidad a disminuir
            tmp=JOptionPane.showInputDialog("Ingrese una velocidad en kilometros por hora (km/h)\n"
                                          + "para aumentarle al auto.\n"
                                          + "Velocidad actual: "+va+"km/h.\n\n"); //Solicitud de la velocidad a disminuir
            h=Double.parseDouble(tmp); //Asignacion de las unidades ingresadas por el usuario a una variable "h" para calificar su valor posteriormente
            if (h<0) //En caso de que el usuario ingrese un numero negativo
                JOptionPane.showMessageDialog(null,"El valor que ingreso es invalido.\n"
                                                 + "Porfavor ingrese una velocidad positiva (h>=0).\n\n"); //Mensaje de alerta
            if ((va-h)<0) //En caso de que la resta entre la velocidad actual del auto y la velocidad ingresada por el usuario sea un numero negativo
                JOptionPane.showMessageDialog(null,"La velocidad del carro no puede ser\n"
                                                 + "menos de 0km/h.\n\n"
                                                 + "Velocidad actual del auto: "+va); //Mensaje de alerta
        }while(h<0 || (va-h)<0); /*Repetira la solicitud de disminucion de velocidad asta que: el
        usuario ingrese un numero positivo y la resta entre la velocida actual del auto y el dato
        ingresado por el susuario sea mayor o igual a 0
        */
        va-=h; //Disminucion de la velocidad actual del atuo en "h" unidades
        JOptionPane.showMessageDialog(null,"La velocidad del auto\n"
                                         + "se actualizo a: "+va+"km/h\n\n"); //Mensaje de notificacion
        if (vm==0) //En caso de que la velocidad minima alcanzada por el atuo sea igual a 0 unidades
            vm=va; //Actualiza la velocidad minima a "va" unidades
        else{ //En caso contrario
            if (va<vm && va>0) //En caso de que la velocidad actual del auto sea menor a la velocidad minima alcanzada por el mismo y la velocidad actual del auto sea mayor a 0 unidades
                vm=va; //Actualiza la velocidad minima a "va" unidades
            //Fin del "if"
        } //fin del "if-else"
    } //Fin de la funcion dv
    
    public void tgas(){ //Mas combustible
        do{ //Solicitud de las unidades a aumentarle al tanque de gasolina
            tmp=JOptionPane.showInputDialog("Ingrese la cantidad de gasolina en\n"
                                          + "litros (Lts) para introducirle al auto.\n"
                                          + "Nivel del tanque actual: "+tg+"Lts.\n\n"); //Solicitud de las unidades a aumentarle al tanque de gasolina
            h=Double.parseDouble(tmp); //Asignacion de las unidades ingresadas por el usuario a la varialbe "h" para calificar su valor posteriormente
            if (h<0) //En caso de que el usuario ingrese un numero negativo
                JOptionPane.showMessageDialog(null,"Porfavor ingrese una cantidad positiva (h>=0).\n\n"); //Mensaje de alerta
            //Fin del "if"
            if ((tg+h)>20) //En caso de que el usuario ingrese una cantidad que exeda la capacidad del tanque de gasolina
                JOptionPane.showMessageDialog(null,"El tanque de gasolina solo tiene capasidad\n"
                                                 + "para 20Lts, el tanque actualmente posee: "+tg+"Lts"); //Mensaje de alerta
        }while (h<0 || (h+tg)>20); /*Repetira el siclo "do...while..." asta que el usuario ingrese un
        numero positivo y la cantidad ingresada por el usuairo no supere la capasidad del tanque
        de gasolina*/
        tg+=h; //Incremento de la cantidad de gasolina en el tanque respectivo en "h" unidades
        JOptionPane.showMessageDialog(null,"El nivel del tanque de gasolina\n"
                                         + "se actualizo a: "+tg+"Lts\n\n"); //Mensaje de notificacion
    } //Fin de la funcion tgas
    
    public void tac(){ //Mas aceite
        do{ //Solicitud de las unidades de aceite a ingresarle al tanque respectivo
            tmp=JOptionPane.showInputDialog("Ingrese la cantidad de aceite en\n"
                                          + "litros (Lts) para introducirle al auto.\n"
                                          + "Nivel del tanque actual: "+ta+"Lts.\n\n"); //Solicitud de la sunidades de aceite a ingresalre al tanque respectivo
            h=Double.parseDouble(tmp); //Asignacion a la varialbe "h" a las unidades ingresadas por el usuario para calificar su valor posteriormente
            if (h<0) //En caso de que el usuario ingrese una cantidad negativa
                JOptionPane.showMessageDialog(null,"Porfavor ingrese una cantidad positiva (h>=0).\n\n"); //Mensaje de alerta
            //Fin del "if"
            if ((ta+h)>50) //En caso de que el usuario ingrese una cantidad que exeda la capacidad del tanque de aceite
                JOptionPane.showMessageDialog(null,"El tanque de aceite solo tiene capasidad\n"
                                                 + "para 50Lts, el tanque actualmente posee: "+ta+"Lts"); //Mensaje de alerta
            //Fin del "if"
        }while (h<0 || (h+ta)>50); /*Repetira el siclo "do...while..." asta que el usuario ingrese un
        numero positivo y la cantidad ingresada por el usuairo no supere la capasidad del tanque
        de aceite*/
        ta+=h; //Incremento de la cantidad de aceite en el tanque respectivo en "h" unidades
        JOptionPane.showMessageDialog(null,"El nivel del tanque de aceite\n"
                                         + "se actualizo a: "+ta+"Lts\n\n"); //Mensaje de notificacion
    } //Fin de la funcion tac
    
    public void m(){ //Informe/estado del auto
        JOptionPane.showMessageDialog(null,"Condiciones del Atuo:\n\n"
                                         + "Placa:      "+p+"\n"
                                         + "Vel. Act.:  "+va+"km/h\n"
                                         + "Vel. Max.:  "+vM+"km/h\n"
                                         + "Vel. min.:  "+vm+"km/h\n"
                                         + "Taq. Gas.:  "+tg+"Lts\n"
                                         + "Taq. Ac.:   "+ta+"Lts\n"
                                         + "Estado :    "+a); //Presentacion del estado actual del atuo
    } //Fin de la funcion m
    
    public void ap(){ //Apagar auto
        a=false; //Apaga el atuo
        c=false; //Sale del siclo "do...while" de la funcion init
        JOptionPane.showMessageDialog(null,"El auot ha sido apagado exitosamente\n\n"); //Mensaje de notificacion
    } //Fin de la funcion ap
    
    public void non(){ //Funcion invalida
        //Si el susuario ingresa una opcion invalida se mostrara el siguiente mensaje
        JOptionPane.showMessageDialog(null,"La opcion que selecciono no existe.\n"
                                         + "porfavor seleccione otra opcion.\n\n"); //Mensaje de alerta
    } //Fin de lafuncion non
    
    public void g0(){ //Funcion Gasolina 0
        a=false; //Apaga el auto
        JOptionPane.showMessageDialog(null,"¡Ohh!\n"
                                         + "El carro se apago debido a que se quedo sin gasolina.\n\n"); //Mensaje de alerta
        va=0; //Detiene el auto
    } //Fin de la funcion g0
    
    public void a0(){ //Funcion Aceite 0
        a=false; //Apaga el auto
        c=false; //Se arruina el atuo, fin del siclo "do...while..." de la funcion init
        JOptionPane.showMessageDialog(null,"¡Ohh!\n"
                                         + "El carro se averio debido a que se quedo sin aceite.\n"
                                         + "Porfavor llevelo al mecanico.\n\n"); //Mensaje de alerta
        va=0; //Detiene el auto
    }//Fin de la funcion a0
    
} //Fin de la funcion carro

