class Palillo
{
private int numero;
private boolean cogido;
public Palillo (int id)
{
this.numero= id;
this.cogido=false;
}
public int getId(){
return this.numero;
}
synchronized public void coger()
{
while (cogido)
{
try
{
System.out.println (“Palillo “ + numero + “ bloqueado”);
wait();
} catch (InterruptedException e) {
System.out.println (“ -Espera por palillo “ + numero + “
interrumpida”);
System.exit(1);
}
}

cogido = true;
System.out.println (“Palillo “ + numero + “ ha sido cogido”);
}
synchronized public void soltar()
{
58
Programación de Servicios y Procesos © RA-MA
cogido= false;
System.out.println (“Palillo “ + numero + “ ha sido soltado”);
notify();
}
}
class Filosofo extends Thread
{
protected Palillo ind_izq, ind_der;
protected int identidad;
static final protected int MAX_DELAY=1000;
public Filosofo (int id)
{
this.identidad= id;
ind_izq= Filosofos.mesa.palillo_izquierdo(id);
ind_der= Filosofos.mesa.palillo_derecho(id);
}
protected void pensar()
{
try
{
System.out.println (“Filósofo “ + identidad + “ está pensando”);
Thread.sleep((int) Math.random()*MAX_DELAY);
} catch (InterruptedException e) {
System.out.println (“Filósofo “ + identidad + “ interrumpido”);
System.exit(1);
}
}
protected void comer()
{
try
{
System.out.println (“Filósofo “ + identidad + “ esta comiendo”);
Thread.sleep((int) Math.random()*MAX_DELAY);
} catch (InterruptedException e) {
System.out.println (“Filósofo “ + identidad + “ interrumpido”);
System.exit(1);
}
}
protected void queriendo_comer()
{
System.out.println (“Filósofo “ + identidad + “ quiere comer”);
ind_izq.coger();
ind_der.coger();
}
protected void dejando_de_comer()
{
ind_izq.soltar();
ind_der.soltar();
}
public void run()
{
while (true)
{
pensar();
queriendo_comer();
comer();
dejando_de_comer();

}
}
}
class MesaCircular
{
private Palillo palillos[];
private int filosofos;
public MesaCircular (int personas)
{
this.filosofos= personas;
palillos= new Palillo[personas];
for (int i= 0; i < personas; i++)
palillos[i]= new Palillo(i);
}
public Palillo palillo_derecho(int i)
{
return palillos[(i+1)%filosofos];
}
public Palillo palillo_izquierdo(int i)
{
return palillos[i];
}
}
public class CenaFilosofos {
public static MesaCircular mesa;
public static void main(String[] args) throws InterruptedException {
int filosofos = Integer.parseInt (args[0]);
mesa = new MesaCircular(filosofos);
System.out.println („Sentados „ + filosofos + „ filósofos“);
for (int i= 0; i < filosofos; i++)
{
Filosofo f = new Filosofo(i);
f.start();
}
}
}
Otra forma para mejorar el tiempo de ejecución sería utilizar una sentencia sincronizada utilizando los
propios palillos como objetos monitores. Como se deben coger dos, se puede poner una sentencia sincronizada
dentro de otra, como se ve en el ejemplo.
class Palillo
{
private int numero;
public Palillo (int id)
{
this.numero= id;
}
public int getId(){
return this.numero;
}
}
class Filosofo extends Thread
{
protected Palillo ind_izq, ind_der;
protected int identidad;
static final protected int MAX_DELAY=1000;
public Filosofo (int id)
{
this.identidad= id;
ind_izq= CenaFilosofos.mesa.palillo_izquierdo(identidad);
ind_der= CenaFilosofos.mesa.palillo_derecho(identidad);
}
protected void pensar()
{
try

{
System.out.println (“Filósofo “ + identidad + “ esta pensando”);
Thread.sleep((int) Math.random()*MAX_DELAY);
} catch (InterruptedException e) {
System.out.println (“Filósofo “ + identidad + “ interrumpido”);
System.exit(1);
}
}
protected void comer()
{
try
{
System.out.println (“Filósofo “ + identidad + “ comiendo usando “ +
CenaFilosofos.mesa.palillo_izquierdo(identidad).getId() + “ y “ +
CenaFilosofos.mesa.palillo_derecho(identidad).getId());
Thread.sleep((int) Math.random()*MAX_DELAY);
} catch (InterruptedException e) {
System.out.println (“Filósofo “ + identidad + “ interrumpido”);
System.exit(1);
}
}
protected void queriendo_comer()
{
System.out.println (“Filosofo “ + identidad + “ quiere comer”);
synchronized(CenaFilosofos.mesa.palillo_izquierdo(identidad)) {
synchronized(CenaFilosofos.mesa.palillo_derecho(identidad)){
comer();
}
}
}
public void run()
{
while (true)
{
pensar();
queriendo_comer();
}
}
}
Para solucionar el interbloqueo se puede utilizar una solución asimétrica. Para ello solamente se debe
modificar la forma en que se cogen los palillos, identificando si el filósofo que los coge es par o impar. Por
ejemplo,
para la primera solución mostrada valdría con:
protected void queriendo_comer()
{
System.out.println (“Filósofo “ + identidad + “ quiere comer”);
if (identidad %2 ==0) {
ind_izq.coger();
ind_der.coger();
} else {
ind_der.coger();
ind_izq.coger();
}
}
Para la segunda solución el cambio a realizar sería:
protected void queriendo_comer()
{
System.out.println („Filósofo „ + identidad + „ quiere comer“);
if (identidad % 2 == 0) {
synchronized(CenaFilosofos.mesa.palillo_izquierdo(identidad)) {
synchronized(CenaFilosofos.mesa.palillo_derecho(identidad)) {
comer();
}
}

} else {
synchronized(CenaFilosofos.mesa.palillo_derecho(identidad)) {
synchronized(CenaFilosofos.mesa.palillo_izquierdo(identidad)) {
comer();
}
}
}
}