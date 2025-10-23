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
                System.out.println("1. Ataque normal (" + danhoGolpe1 + " daño)");
                System.out.println("2. " + golpeEspecial1 + " (" + danhoEspecial1 + " daño, " + mpGolpeEspecial1 + " MP)");
                System.out.println("3. ver estado de tu pokemon.");
                System.out.print("Elige tu acción: ");
                int opcion = sc.nextInt();

                if (opcion == 1) {
                    int prob = random.nextInt(20) + 1;
                    if (prob == 20) {
                        int danho = (int) (danhoGolpe1 * 1.5) - defensa2;
                        if (danho < 0) danho = 0;
                        vida2 -= danho;
                        System.out.println(pokemon1 + " hace crítico causando " + danho + " puntos de daño a " + pokemon2);

                    } else {
                        int danho = danhoGolpe1 - defensa2;
                        if (danho < 0) danho = 0;
                        vida2 -= danho;
                        System.out.println(pokemon1 + " ataca y causa " + danho + " puntos de daño a " + pokemon2);
                    }
                    turnoPokemon1 = !turnoPokemon1;
                } else if (opcion == 2) {
                    if (mp1 >= mpGolpeEspecial1) {
                        mp1 -= mpGolpeEspecial1;
                        int prob = random.nextInt(20) + 1;
                        if (prob == 20) {
                            int danho = (int) (danhoEspecial1 * 1.5) - defensa2;
                            if (danho < 0) danho = 0;
                            vida2 -= danho;
                            System.out.println(pokemon1 + " usa " + golpeEspecial1 + " y hace crítico causando " + danho + " puntos de daño a " + pokemon2);
                        } else {
                            int danho = danhoEspecial1 - defensa2;
                            if (danho < 0) danho = 0;
                            vida2 -= danho;
                            System.out.println(pokemon1 + " usa " + golpeEspecial1 + " y causa " + danho + " puntos de daño a " + pokemon2);
                        }
                        turnoPokemon1 = !turnoPokemon1;
                    } else {
                        System.out.println(pokemon1 + " no tiene suficientes MP. ¡Pierde el turno!");
                        turnoPokemon1 = !turnoPokemon1;
                    }
                }else if (opcion == 3) {
                        estadopokemon(pokemon1, vida1, mp1);

                } else {
                        System.out.println("Opción no válida. Pierde el turno.");
                        turnoPokemon1 = !turnoPokemon1;
                }

                } else {
                    System.out.println("\n Es el turno de " + pokemon2);
                    System.out.println("1. Ataque normal (" + danhoGolpe2 + " daño)");
                    System.out.println("2. " + golpeEspecial2 + " (" + danhoEspecial2 + " daño, " + mpGolpeEspecial2 + " MP)");
                    System.out.print("Elige tu acción: ");
                    int opcion = sc.nextInt();

                    if (opcion == 1) {
                        int prob = random.nextInt(20) + 1;
                        if (prob == 20) {
                            int danho = (int) (danhoGolpe2 * 1.5) - defensa1;
                            if (danho < 0) danho = 0;
                            vida1 -= danho;
                            System.out.println(pokemon2 + " hace crítico causando " + danho + " puntos de daño a " + pokemon1);
                        } else {
                            int danho = danhoGolpe2 - defensa1;
                            if (danho < 0) danho = 0;
                            vida1 -= danho;
                            System.out.println(pokemon2 + " ataca y causa " + danho + " puntos de daño a " + pokemon1);
                        }
                        turnoPokemon1 = !turnoPokemon1;
                    } else if (opcion == 2) {
                        if (mp2 >= mpGolpeEspecial2) {
                            mp2 -= mpGolpeEspecial2;
                            int prob = random.nextInt(20) + 1;
                            if (prob == 20) {
                                int danho = (int) (danhoEspecial2 * 1.5) - defensa1;
                                if (danho < 0) danho = 0;
                                vida1 -= danho;
                                System.out.println(pokemon2 + " usa " + golpeEspecial2 + " y hace crítico causando " + danho + " puntos de daño a " + pokemon1);

                            } else {
                                int danho = danhoEspecial2 - defensa1;
                                if (danho < 0) danho = 0;
                                vida1 -= danho;
                                System.out.println(pokemon2 + " usa " + golpeEspecial2 + " y causa " + danho + " puntos de daño a " + pokemon1);
                            }
                        } else {
                            System.out.println(pokemon2 + " no tiene suficientes MP. ¡Pierde el turno!");
                        }
                            turnoPokemon1 = !turnoPokemon1;
                        }else if (opcion == 3) {
                            estadopokemon(pokemon1, vida1, mp1);



                    } else {
                        System.out.println("Opción no válida. Pierde el turno.");
                        turnoPokemon1 = !turnoPokemon1;
                    }
                }

            }    // Cambiar turno




        //Resultado final
        System.out.println("\n¡La batalla ha terminado! ️");
        if (vida1 <= 0 && vida2 <= 0) {
            System.out.println("¡Empate! Ambos Pokémon han caído.");
        } else if (vida1 <= 0) {
            System.out.println(pokemon2 + " gana la batalla.");
        } else {
            System.out.println(pokemon1 + " gana la batalla.");
        }




    }
    private static void estadopokemon(String a, int x, int y) {
        System.out.println(a + " => Vida: " + x + " | MP: " + y);
    }
}
