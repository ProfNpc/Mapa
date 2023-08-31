package belval.mapa;

import java.util.Scanner;

public class MainMapa {
	public static void main(String[] args) {
		
		String os = getSistemaOperacional(args);
		
		System.out.println("Inicio");
		Scanner teclado = new Scanner(System.in);
		
		Mapa mapa = montarMapa();
		
		Local local = mapa.getInicio();
		
		System.out.println("Voce ve:");
		System.out.println(local.getDescricao());
		
		try {
			String comando = "";
			char letraComando = ' ';
			do {
				System.out.println("Para onde voce quer ir?[norte, sul, leste, oeste]");
				comando = teclado.nextLine() + " ";
				letraComando = comando.toUpperCase().charAt(0);
				if ("NSLO".indexOf(letraComando) > -1) {
					if ('N' == letraComando) {
						local = local.irNorte();
					} else if ('S' == letraComando) {
						local = local.irSul();
					} else if ('L' == letraComando) {
						local = local.irLeste();
					} else if ('O' == letraComando) {
						local = local.irOeste();
					}
					limparConsole(os);
					System.out.println("Voce ve:");
					System.out.println(local.getDescricao());
				}
			} while(letraComando != 'X');
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			teclado.close();
		}
		System.out.println("Fim");
	}

	private static String getSistemaOperacional(String[] args) {
		String os = System.getProperty("os.name");
		
		if (args.length >= 1 && args[0].toLowerCase().startsWith("os=")) {
			os = args[0].toLowerCase().replace("os=", "");
		}
		//System.out.println(os);
		return os;
	}
	
	public static Mapa montarMapa() {
		Local inicio = new Local("Um hall escuro com acesso a outros comodos");
		Local local1 = new Local("Um banheiro com uma pequena janela");
		Local local2 = new Local("Uma cozinha branca");
		Local local3 = new Local("Estamos do lado de fora, na rua, eh possivel ver varias casas");
		Local local4 = new Local("Esta eh a sala de estar de estar");
		inicio.addNorte(local1);
		inicio.addSul(local3);
		inicio.addLeste(local2);
		inicio.addOeste(local4);
		
		Local local5 = new Local("Esta eh a suite");
		local4.addNorte(local5);
		
		Mapa mapa = new Mapa(inicio, local5);
		
		return mapa;
	}
	
	public static void limparConsole(String os) {
		try {
			//final String os = System.getProperty("os.name");
			if (os.contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
				//Runtime.getRuntime().exec("clear");
				new ProcessBuilder("clear").inheritIO().start().waitFor();
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
	
	  
	
}