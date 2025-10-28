import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        Random random = new Random();

        // --- Datos del Pokémon 1 ---
        String pokemon1 = "Pikachu";
        int vida1 = 120;
        int mp1 = 50;
        int danhoGolpe1 = 10;
        int defensa1 = 5;
        String golpeEspecial1 = "Impactrueno";
        int danhoEspecial1 = 40;
        int mpGolpeEspecial1 = 15;

        // --- Datos del Pokémon 2 ---
        String pokemon2 = "Charmander";
        int vida2 = 180;
        int mp2 = 60;
        int danhoGolpe2 = 10;
        int defensa2 = 8;
        String golpeEspecial2 = "llamarada";
        int danhoEspecial2 = 30;
        int mpGolpeEspecial2 = 30;

        //Control de turnos
        boolean turnoPokemon1 = true;

        System.out.println("Comienza la batalla entre " + pokemon1 + " y " + pokemon2 );

        //Bucle de combate
        while (vida1 > 0 && vida2 > 0) {
            System.out.println("\n------------------------------");
            System.out.println(pokemon1 + " => Vida: " + vida1 + " | MP: " + mp1);
            System.out.println(pokemon2 + " => Vida: " + vida2 + " | MP: " + mp2);
            System.out.println("------------------------------");

            if (turnoPokemon1) {
                System.out.println("\n👉 Es el turno de " + pokemon1);

                System.out.println("2. REALIZAR ATAQUE");
                System.out.println("3. VER ESTADO DE TU POKEMON.");
                int opcion = 0;


                do {
                    System.out.print("ELIGE ACCIÓN (recuerda que tiene que ser una opción valida): ");
                    opcion = sc.nextInt();
                    if (opcion == 2) {
                        do {
                            System.out.println("elije una opcion de ataque:");
                            System.out.println("\n1. ATAQUE NORMAL");
                            System.out.println("\n2. ATAQUE ESPECIAL");
                            opcion = sc.nextInt();
                        }while(opcion!=1 && opcion!=2);
                        if(opcion==1){
                            vida2 = ataquepokemon(pokemon1,vida2,defensa2,danhoGolpe1,danhoEspecial1,opcion);
                            turnoPokemon1 = !turnoPokemon1;
                        }else if(opcion==2){
                            if (mp1 <= mpGolpeEspecial1){
                                System.out.println("\nNO TIENES SUFICIENTE MP PARA REALIZAR ESTE ATAQUE ...");
                            }else {
                                mp1 = controlmp(mp1,mpGolpeEspecial1);
                                vida2 = ataquepokemon(pokemon1,vida2,defensa2,danhoGolpe1,danhoEspecial1,opcion);
                                turnoPokemon1 = !turnoPokemon1;
                            }

                        }

                    } else if (opcion == 3) {
                        estadopokemon(pokemon1, vida1, mp1);

                    }
                }while(opcion!=3 && opcion!=2);

                } else {
                System.out.println("\n👉 Es el turno de " + pokemon2);

                System.out.println("2. REALIZAR ATAQUE");
                System.out.println("3. VER ESTADO DE TU POKEMON.");
                int opcion = 0;
                do {
                    System.out.print("ELIGE ACCIÓN (recuerda que tiene que ser una opción valida): ");
                    opcion = sc.nextInt();
                    if (opcion == 2) {
                        do {
                            System.out.println("elije una opcion de ataque:");
                            System.out.println("\n1. ATAQUE NORMAL");
                            System.out.println("\n2. ATAQUE ESPECIAL");
                            opcion = sc.nextInt();
                        }while(opcion!=1 && opcion!=2);
                        if (opcion == 1) {
                            vida1 = ataquepokemon(pokemon2,vida1,defensa1,danhoGolpe2,danhoEspecial2,opcion);
                            turnoPokemon1 = !turnoPokemon1;
                        }else if (opcion == 2) {
                            if (mp2 <= mpGolpeEspecial2){
                                System.out.println("\nNO TIENES SUFICIENTE MP PARA REALIZAR ESTE ATAQUE REALIZA OTRA ACCION...");
                            }else {
                                mp2 = controlmp(mp2,mpGolpeEspecial2);
                                vida1 = ataquepokemon(pokemon2,vida1,defensa1,danhoGolpe2,danhoEspecial2,opcion);
                                turnoPokemon1 = !turnoPokemon1;
                            }


                        }



                    } else if (opcion == 3) {
                        estadopokemon(pokemon1, vida1, mp1);

                    }
                }while(opcion!=3 && opcion!=2);


                }

            }




        //Resultado final
        System.out.println("\n¡La batalla ha terminado! ️");
        if (vida1 <= 0) {
            System.out.println(pokemon2 + " gana la batalla.");
        } else {
            System.out.println(pokemon1 + " gana la batalla.");
        }




    }
    private static void estadopokemon(String a, int x, int y) {
        System.out.println(a + " => Vida: " + x + " | MP: " + y);
    }
    private static int ataquepokemon(String a, int vidaenemigo, int defensarival, int ataque, int danoespecial, int eleccion) {

        Random miGenerador = new Random();


            if (eleccion == 1) {
                int prob = miGenerador.nextInt(20) + 1;
                if (prob == 20) {
                    int danho = (int) (danoespecial * 1.5) - defensarival;
                    if (danho < 0) danho = 0;
                    vidaenemigo -= danho;
                    System.out.println(a + " hace crítico causando " + danho + " puntos de daño al rival ");

                } else {
                    int danho = danoespecial - defensarival;
                    if (danho < 0) danho = 0;
                    vidaenemigo -= danho;
                    System.out.println(a + " ataca y causa " + danho + " puntos de daño al rival ");
                }

            } else if (eleccion == 2) {


                    int prob = miGenerador.nextInt(20) + 1;
                    if (prob == 20) {
                        int danho = (int) (danoespecial * 1.5) - defensarival;
                        if (danho < 0) danho = 0;
                        vidaenemigo -= danho;
                        System.out.println(a + " usa " + danoespecial + " y hace crítico causando " + danho + " puntos de daño a ");
                    } else {
                        int danho = danoespecial - defensarival;
                        if (danho < 0) danho = 0;
                        vidaenemigo -= danho;
                        System.out.println(a + " usa " + danoespecial + " y causa " + danho + " puntos de daño a ");
                    }



                }


            return vidaenemigo;
    }
    private static int controlmp(int mp, int mpespecial) {
        return mp - mpespecial;
    }
}
